package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.ModulePath
import com.danrusu.pods4k.utils.addPropertyWithGetter
import com.danrusu.pods4k.utils.suppress
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.jvm.jvmInline
import java.io.File

internal object ImmutableArrayCodeGenerator {
    fun generate() {
        val packageName = ImmutableArrayCodeGenerator::class.java.`package`.name

        for (baseType in BaseType.values()) {
            val fileSpec = generateImmutableArrayFile(baseType, packageName)

            fileSpec.writeTo(File(ModulePath.IMMUTABLE_ARRAYS, ""))
        }
    }
}

private fun generateImmutableArrayFile(baseType: BaseType, packageName: String): FileSpec {
    val qualifiedClassName = ClassName(packageName, baseType.generatedClassName)

    return FileSpec.builder(packageName, baseType.generatedClassName)
        .addFileComment("Auto-generated file. DO NOT EDIT!")
        .addType(
            TypeSpec.classBuilder(qualifiedClassName)
                .jvmInline()
                .addModifiers(KModifier.VALUE)
                .maybeAddGenericType(baseType)
                .addPrimaryConstructor(baseType)
                .addPropertyWithGetter<Int>(name = "size", get = "return values.size")
                .addFunction(createToStringMethod())
                .addFunction(createArrayIndexOperator(baseType))
                .addFunction(createIteratorOperator(baseType))
                .addType(
                    TypeSpec.companionObjectBuilder()
                        .addFunction(createInvokeOperator(baseType, qualifiedClassName))
                        .build()
                )
                .build()
        )
        .build()
}

private fun TypeSpec.Builder.addPrimaryConstructor(baseType: BaseType): TypeSpec.Builder {
    val valuesPropertyName = "values"

    // adding a parameter to the constructor and creating an identical property generates it in the primary constructor
    return primaryConstructor(
        FunSpec.constructorBuilder()
            .addAnnotation(PublishedApi::class)
            .addParameter(valuesPropertyName, baseType.backingArrayType)
            .addModifiers(KModifier.INTERNAL)
            .build()
    ).addProperty(
        PropertySpec.builder(valuesPropertyName, baseType.backingArrayType, KModifier.PRIVATE)
            .initializer(valuesPropertyName)
            .build()
    )
}

private fun createToStringMethod(): FunSpec {
    return FunSpec.builder("toString")
        .addModifiers(KModifier.OVERRIDE)
        .returns(String::class)
        .addStatement(
            """
                return values.joinToString(prefix = "[", postfix = "]")
            """.trimIndent()
        )
        .build()
}

private fun createArrayIndexOperator(baseType: BaseType): FunSpec {
    val funSpec = FunSpec.builder("get")
        .addKdoc("Returns the element at the specified [index]. This method can be called using the index operator.")
        .addModifiers(KModifier.OPERATOR)
        .returns(baseType.type)
        .addParameter("index", Int::class)

    if (baseType == BaseType.GENERIC) {
        return funSpec.suppress("UNCHECKED_CAST")
            .addStatement("return values[index] as %T", baseType.type)
            .build()
    }

    return funSpec.addStatement("return values[index]").build()
}

private fun createIteratorOperator(baseType: BaseType): FunSpec {
    val iteratorType = Iterator::class.asClassName().parameterizedBy(baseType.type)

    val funSpec = FunSpec.builder("iterator")
        .addKdoc("Creates an iterator allowing iteration over the elements of the array.")
        .addModifiers(KModifier.OPERATOR)
        .returns(iteratorType)

    if (baseType == BaseType.GENERIC) {
        return funSpec.suppress("UNCHECKED_CAST")
            .addStatement("return values.iterator() as %T", iteratorType)
            .build()
    }

    return funSpec.addStatement("return values.iterator()").build()
}

private fun createInvokeOperator(baseType: BaseType, qualifiedClassName: ClassName): FunSpec {
    return FunSpec.builder("invoke")
        .addKdoc(
            """
                Creates a ${baseType.generatedClassName} instance of the specified [size], where each element is calculated by calling the specified [init] function.
                
                [init] is called sequentially starting at index 0 to initialize the array with each element at its given index.
                
                Implementation:
                We're using the invoke method instead of a regular constructor so that we can declare it inline.  The call site will look like a regular constructor call.
            """.trimIndent()
        )
        .addModifiers(KModifier.INLINE, KModifier.OPERATOR)
        .maybeAddGenericType(baseType)
        .addParameter("size", Int::class)
        .addParameter(
            ParameterSpec.builder(
                name = "init",
                type = LambdaTypeName.get(
                    parameters = listOf(ParameterSpec.builder("index", Int::class).build()),
                    returnType = baseType.type
                )
            ).build()
        )
        .returns(qualifiedClassName.maybeAddGenericType(baseType))
        .addCode(
            """
                val backingArray = ${baseType.backingArrayConstructor}(size) { index -> init(index) }
                return ${baseType.generatedClassName}(backingArray)
            """.trimIndent()
        )
        .build()
}

private fun TypeSpec.Builder.maybeAddGenericType(baseType: BaseType): TypeSpec.Builder = when (baseType) {
    BaseType.GENERIC -> addTypeVariable(baseType.type as TypeVariableName)
    else -> this
}

private fun FunSpec.Builder.maybeAddGenericType(baseType: BaseType): FunSpec.Builder = when (baseType) {
    BaseType.GENERIC -> addTypeVariable(baseType.type as TypeVariableName)
    else -> this
}

private fun ClassName.maybeAddGenericType(baseType: BaseType): TypeName = when (baseType) {
    BaseType.GENERIC -> this.parameterizedBy(baseType.type)
    else -> this
}

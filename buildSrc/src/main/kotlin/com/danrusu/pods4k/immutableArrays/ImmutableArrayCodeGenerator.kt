package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.utils.*
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import java.io.File

private const val NUM_COMPONENT_N_FUNCTIONS = 5

private val packageName = ImmutableArrayCodeGenerator::class.java.`package`.name

internal object ImmutableArrayCodeGenerator {
    fun generate(destinationPath: String) {

        for (baseType in BaseType.values()) {
            val fileSpec = generateImmutableArrayFile(baseType)
            fileSpec.writeTo(File(destinationPath, ""))
        }
    }
}

private fun generateImmutableArrayFile(baseType: BaseType): FileSpec {
    val qualifiedClassName = ClassName(packageName, baseType.generatedClassName)

    return createFile(packageName, baseType.generatedClassName) {
        addClass(modifiers = listOf(KModifier.VALUE), name = qualifiedClassName) {
            addAnnotation(JvmInline::class)
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addPrimaryConstructor(baseType)
            addProperty(name = "size", type = Int::class.asTypeName(), get = "return values.size")
            addProperty(
                kdoc = "Returns the index of the last element or -1 if the array is empty.",
                name = "lastIndex",
                type = Int::class.asTypeName(),
                get = "return values.size - 1",
            )
            addProperty(
                kdoc = "Returns the range of valid indices for the array.",
                name = "indices",
                type = IntRange::class.asTypeName(),
                get = "return values.indices",
            )
            overrideToString()
            "isEmpty"(baseType = baseType, returns = Boolean::class.asTypeName())
            "isNotEmpty"(baseType = baseType, returns = Boolean::class.asTypeName())
            addArrayIndexOperator(baseType)
            "getOrNull"(
                baseType = baseType,
                parameters = { "index"<Int>() },
                returns = baseType.type.copy(nullable = true),
            )
            "getOrElse"(
                baseType = baseType,
                modifiers = listOf(KModifier.INLINE),
                parameters = {
                    "index"<Int>()
                    "defaultValue"(
                        type = LambdaTypeName.get(
                            parameters = parameters { "index"<Int>() },
                            returnType = baseType.type,
                        )
                    )
                },
                returns = baseType.type,
            )
            addComponentNFunctions(baseType)
            "single"(baseType = baseType, returns = baseType.type)
            "first"(baseType = baseType, returns = baseType.type)
            "firstOrNull"(
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "last"(baseType = baseType, returns = baseType.type)
            "lastOrNull"(
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "toList"(
                baseType = baseType,
                returns = List::class.asTypeName().parameterizedBy(baseType.type),
            )
            "toMutableList"(
                baseType = baseType,
                returns = ClassName("kotlin.collections", "MutableList").parameterizedBy(baseType.type),
            )
            "iterator"(
                baseType = baseType,
                modifiers = listOf(KModifier.OPERATOR),
                returns = Iterator::class.asTypeName().parameterizedBy(baseType.type),
            )
            "asIterable"(
                baseType = baseType,
                returns = Iterable::class.asTypeName().parameterizedBy(baseType.type),
            )
            "withIndex"(
                baseType = baseType,
                returns = Iterable::class.asTypeName().parameterizedBy(
                    IndexedValue::class.asTypeName().parameterizedBy(baseType.type)
                ),
            )
            "asSequence"(
                baseType = baseType,
                returns = Sequence::class.asTypeName().parameterizedBy(baseType.type),
            )
            "forEach"(
                baseType = baseType,
                modifiers = listOf(KModifier.INLINE),
                parameters = {
                    "action"(
                        type = LambdaTypeName.get(
                            parameters = parameters { "element"(type = baseType.type) },
                            returnType = Unit::class.asTypeName()
                        )
                    )
                },
            )
            "forEachIndexed"(
                baseType = baseType,
                modifiers = listOf(KModifier.INLINE),
                parameters = {
                    "action"(
                        type = LambdaTypeName.get(
                            parameters = parameters { "index"<Int>(); "element"(type = baseType.type) },
                            returnType = Unit::class.asTypeName()
                        )
                    )
                },
            )
            addCompanionObject {
                addInvokeOperator(baseType, qualifiedClassName)
            }
        }
    }
}

private fun TypeSpec.Builder.addPrimaryConstructor(baseType: BaseType) {
    // adding a parameter to the primary constructor and creating an identical property initialized by that parameter
    // ends up defining it in the primary constructor
    addPrimaryConstructor(
        modifiers = listOf(KModifier.INTERNAL),
        parameters = { "values"(type = baseType.backingArrayType) },
    ) {
        addAnnotation(PublishedApi::class)
    }.addProperty(
        kdoc = """
            This is internal instead of private so we can have inline functions that delegate to the same function on the backing array.  The backing array won't be accessible from Kotlin code since the auto-generarted arrays are in their own module and the internal modifier prevents outside access.  The constructor is also internal preventing anyone from creating an "instance" that points to an array that they have access to.
            
            Attempting to bypass the internal visibility from java won't work since this is an inline class so both the field and constructor are mangled by the Kotlin compiler.  While these might appear to be accessible from Java due to the friendly Kotlin interop, these won't actually exist with those names in the generated bytecode resulting in an unknown symbol exception.
            
            Therefore, the combination of being internal in its own module along with inline classes makes this effectively private.
        """.trimIndent(),
        modifiers = listOf(KModifier.INTERNAL),
        name = "values",
        type = baseType.backingArrayType,
        init = "values",
    ) {
        addAnnotation(PublishedApi::class)
    }
}

/**
 * Delegates to the same function on the backing array.
 */
context (TypeSpec.Builder)
private operator fun String.invoke(
    baseType: BaseType,
    kdoc: String = "See [${if (baseType == BaseType.GENERIC) "Array" else baseType.backingArrayConstructor}.$this]",
    modifiers: List<KModifier> = emptyList(),
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName = Unit::class.asTypeName(),
) {

    val params = ParameterDSL().apply(parameters).build().map { it.name }.joinToString()
    addFunction(
        kdoc = kdoc,
        modifiers = modifiers,
        name = this,
        parameters = parameters,
        returns = returns,
    ) {
        addStatement("return values.${this@invoke}($params)")
    }
}

private fun TypeSpec.Builder.overrideToString() {
    addFunction(
        modifiers = listOf(KModifier.OVERRIDE),
        name = "toString",
        returns = String::class.asTypeName(),
        code = """
            return values.joinToString(prefix = "[", postfix = "]")
        """.trimIndent(),
    )
}

private fun TypeSpec.Builder.addArrayIndexOperator(baseType: BaseType) {
    addFunction(
        modifiers = listOf(KModifier.OPERATOR),
        kdoc = "Returns the element at the specified [index]. This method can be called using the index operator.",
        name = "get",
        parameters = { "index"<Int>() },
        returns = baseType.type,
    ) {
        addStatement("return values[index]")
    }
}

private fun TypeSpec.Builder.addComponentNFunctions(baseType: BaseType) {
    for (n in 1..NUM_COMPONENT_N_FUNCTIONS) {
        addFunction(
            modifiers = listOf(KModifier.OPERATOR),
            name = "component$n",
            returns = baseType.type,
            code = "return get(${n - 1})",
        )
    }
}

private fun TypeSpec.Builder.addInvokeOperator(baseType: BaseType, qualifiedClassName: ClassName) {
    addFunction(
        kdoc = """
            Creates a ${baseType.generatedClassName} instance of the specified [size], where each element is calculated by calling the specified [init] function.
            
            [init] is called sequentially starting at index 0 to initialize the array with each element at its given index.
            
            Implementation:
            We're using the invoke method instead of a regular constructor so that we can declare it inline.  The call site will look like a regular constructor call.
        """.trimIndent(),
        modifiers = listOf(KModifier.INLINE, KModifier.OPERATOR),
        name = "invoke",
        parameters = {
            "size"<Int>()
            "init"(
                type = LambdaTypeName.get(
                    parameters = parameters { "index"<Int>() },
                    returnType = baseType.type
                )
            )
        },
        returns = qualifiedClassName.maybeAddGenericType(baseType),
    ) {
        if (baseType == BaseType.GENERIC) {
            suppress("UNCHECKED_CAST")
            addTypeVariable(baseType.type as TypeVariableName)
        }
        addStatement("val backingArray = ${baseType.backingArrayConstructor}(size) { index -> init(index) }")
        if (baseType == BaseType.GENERIC) {
            addStatement("return ${baseType.generatedClassName}(backingArray as %T)", baseType.backingArrayType)
        } else {
            addStatement("return ${baseType.generatedClassName}(backingArray)")
        }
    }
}

private fun ClassName.maybeAddGenericType(baseType: BaseType): TypeName = when (baseType) {
    BaseType.GENERIC -> this.parameterizedBy(baseType.type)
    else -> this
}

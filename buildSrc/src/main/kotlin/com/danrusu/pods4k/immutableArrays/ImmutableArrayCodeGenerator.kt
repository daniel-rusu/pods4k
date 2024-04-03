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
            if (baseType.isGeneric()) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addPrimaryConstructor(baseType)
            addProperty(name = "size", type = Int::class.asTypeName(), get = "return values.size")
            addProperty(
                kdoc = "Returns the index of the last element or -1 if the array is empty.",
                name = "lastIndex",
                type = Int::class.asTypeName(),
                get = "return values.lastIndex",
            )
            addProperty(
                kdoc = "Returns the range of valid indices for the array.",
                name = "indices",
                type = IntRange::class.asTypeName(),
                get = "return values.indices",
            )
            overrideToString()
            "isEmpty"(returns = Boolean::class.asTypeName())
            "isNotEmpty"(returns = Boolean::class.asTypeName())
            addArrayIndexOperator(baseType)
            "getOrNull"(
                parameters = { "index"<Int>() },
                returns = baseType.type.copy(nullable = true),
                isGeneric = baseType.isGeneric(),
            )
            "getOrElse"(
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
                isGeneric = baseType.isGeneric(),
            )
            addComponentNFunctions(baseType)
            "single"(returns = baseType.type, isGeneric = baseType.isGeneric())
            "first"(returns = baseType.type, isGeneric = baseType.isGeneric())
            "firstOrNull"(
                returns = baseType.type.copy(nullable = true),
                isGeneric = baseType.isGeneric(),
            )
            "last"(returns = baseType.type, isGeneric = baseType.isGeneric())
            "lastOrNull"(
                returns = baseType.type.copy(nullable = true),
                isGeneric = baseType.isGeneric(),
            )
            "toList"(
                returns = List::class.asTypeName().parameterizedBy(baseType.type),
                isGeneric = baseType.isGeneric(),
            )
            "toMutableList"(
                returns = ClassName("kotlin.collections", "MutableList").parameterizedBy(baseType.type),
                isGeneric = baseType.isGeneric(),
            )
            "iterator"(
                modifiers = listOf(KModifier.OPERATOR),
                returns = Iterator::class.asTypeName().parameterizedBy(baseType.type),
                isGeneric = baseType.isGeneric()
            )
            "asIterable"(
                returns = Iterable::class.asTypeName().parameterizedBy(baseType.type),
                isGeneric = baseType.isGeneric()
            )
            "asSequence"(
                returns = Sequence::class.asTypeName().parameterizedBy(baseType.type),
                isGeneric = baseType.isGeneric(),
            )
            addForEach(baseType)
            addForEachIndexed(baseType)
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
    kdoc: String = "See [Array.$this]",
    modifiers: List<KModifier> = emptyList(),
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName,
    isGeneric: Boolean = false,
) {
    val params = ParameterDSL().apply(parameters).build().map { it.name }.joinToString()
    addFunction(
        kdoc = kdoc,
        modifiers = modifiers,
        name = this,
        parameters = parameters,
        returns = returns,
    ) {
        if (isGeneric) {
            suppress("UNCHECKED_CAST")
            addStatement("return values.${this@invoke}($params) as %T", returns)
        } else {
            addStatement("return values.${this@invoke}($params)")
        }
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
        if (baseType == BaseType.GENERIC) {
            suppress("UNCHECKED_CAST")
            addStatement("return values[index] as %T", baseType.type)
        } else {
            addStatement("return values[index]")
        }
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

private fun TypeSpec.Builder.addForEach(baseType: BaseType) {
    addFunction(
        kdoc = "Performs the specified [action] on each element sequentially starting with the first element",
        modifiers = listOf(KModifier.INLINE),
        name = "forEach",
        parameters = {
            "action"(
                type = LambdaTypeName.get(
                    parameters = parameters { "element"(type = baseType.type) },
                    returnType = Unit::class.asTypeName()
                )
            )
        },
    ) {
        if (baseType == BaseType.GENERIC) {
            suppress("UNCHECKED_CAST")
            addStatement("return values.forEach { action(it as %T) }", baseType.type)
        } else {
            addStatement("return values.forEach(action)")
        }
    }
}

private fun TypeSpec.Builder.addForEachIndexed(baseType: BaseType) {
    addFunction(
        kdoc = "Performs the specified [action] on each element sequentially starting with the first element",
        modifiers = listOf(KModifier.INLINE),
        name = "forEachIndexed",
        parameters = {
            "action"(
                type = LambdaTypeName.get(
                    parameters = parameters { "index"<Int>(); "element"(type = baseType.type) },
                    returnType = Unit::class.asTypeName()
                )
            )
        },
    ) {
        if (baseType == BaseType.GENERIC) {
            suppress("UNCHECKED_CAST")
            addStatement(
                "return values.forEachIndexed { index, element -> action(index, element as %T) }",
                baseType.type
            )
        } else {
            addStatement("return values.forEachIndexed(action)")
        }
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
            addTypeVariable(baseType.type as TypeVariableName)
        }
        addCode(
            """
                val backingArray = ${baseType.backingArrayConstructor}(size) { index -> init(index) }
                return ${baseType.generatedClassName}(backingArray)
            """.trimIndent()
        )
    }
}

private fun ClassName.maybeAddGenericType(baseType: BaseType): TypeName = when (baseType) {
    BaseType.GENERIC -> this.parameterizedBy(baseType.type)
    else -> this
}

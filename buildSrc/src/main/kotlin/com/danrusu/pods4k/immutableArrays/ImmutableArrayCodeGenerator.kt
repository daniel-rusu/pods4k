package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.utils.*
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import java.io.File

internal object ImmutableArrayCodeGenerator {
    fun generate(destinationPath: String) {
        for (baseType in BaseType.values()) {
            val fileSpec = generateImmutableArrayFile(baseType)
            fileSpec.writeTo(File(destinationPath, ""))
        }
    }
}

private fun generateImmutableArrayFile(baseType: BaseType): FileSpec {
    return createFile(Config.packageName, baseType.generatedClassName) {
        addClass(modifiers = listOf(KModifier.VALUE), name = baseType.getGeneratedClass()) {
            addAnnotation(JvmInline::class)
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addPrimaryConstructor(baseType)
            addProperty<Int>(name = "size", get = "return values.size")
            addProperty<Int>(
                kdoc = "Returns the index of the last element or -1 if the array is empty.",
                name = "lastIndex",
                get = "return values.size - 1",
            )
            addProperty<IntRange>(
                kdoc = "Returns the range of valid indices for the array.",
                name = "indices",
                get = "return values.indices",
            )
            overrideToString()
            addEqualsOperator(baseType)
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
                parameters = {
                    "index"<Int>()
                    "defaultValue"(type = lambda(parameters = { "index"<Int>() }, returnType = baseType.type))
                },
                returns = baseType.type,
            )
            addComponentNFunctions(baseType)
            "single"(baseType = baseType, returns = baseType.type)
            "single"(
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type
            )
            "singleOrNull"(
                baseType = baseType,
                returns = baseType.type.copy(nullable = true)
            )
            "singleOrNull"(
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type.copy(nullable = true)
            )
            "first"(baseType = baseType, returns = baseType.type)
            "first"(
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type
            )
            "firstOrNull"(
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "firstOrNull"(
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type.copy(nullable = true)
            )
            "last"(baseType = baseType, returns = baseType.type)
            "last"(
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type
            )
            "lastOrNull"(
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "lastOrNull"(
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type.copy(nullable = true)
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
                parameters = {
                    "action"(type = lambda<Unit> { "element"(type = baseType.type) })
                },
            )
            "forEachIndexed"(
                baseType = baseType,
                parameters = {
                    "action"(type = lambda<Unit> { "index"<Int>(); "element"(type = baseType.type) })
                },
            )
            addCompanionObject {
                addEmptyProperty(baseType)
                addInvokeOperator(baseType)
            }
        }
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
    val params = ParameterDSL().apply(parameters).build()
    addFunction(
        kdoc = kdoc,
        // Inline all delegated functions so that we get the same performance as if working with a regular array
        modifiers = modifiers + KModifier.INLINE,
        name = this,
        parameters = parameters,
        returns = returns,
    ) {
        if (params.none { it.type is LambdaTypeName }) {
            // Inlining won't introduce negative performance impacts since the current method is a dummy wrapper that
            // delegates to the same method on the backing array so the instruction cache isn't negatively affected
            suppress("NOTHING_TO_INLINE")
        }
        addStatement("return values.${this@invoke}(${params.joinToString { it.name }})")
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

private fun TypeSpec.Builder.addEqualsOperator(baseType: BaseType) {
    val otherType = when (baseType) {
        BaseType.GENERIC -> baseType.getGeneratedClass().parameterizedBy(STAR)
        else -> baseType.getGeneratedClass()
    }
    addFunction(
        modifiers = listOf(KModifier.OPERATOR),
        name = "equals",
        parameters = { "other"(type = otherType) },
        returns = Boolean::class.asTypeName(),
        code = """
            if (other.size != this.size) return false
            
            forEachIndexed { index, element ->
                if (other[index] != element) return false
            }
            return true
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
        code = "return values[index]"
    )
}

private fun TypeSpec.Builder.addComponentNFunctions(baseType: BaseType) {
    for (n in 1..Config.NUM_COMPONENT_N_FUNCTIONS) {
        addFunction(
            modifiers = listOf(KModifier.OPERATOR),
            name = "component$n",
            returns = baseType.type,
            code = "return get(${n - 1})",
        )
    }
}

private fun TypeSpec.Builder.addEmptyProperty(baseType: BaseType) {
    val type = when (baseType) {
        BaseType.GENERIC -> baseType.getGeneratedClass().parameterizedBy(Any::class.asTypeName().copy(nullable = true))
        else -> baseType.getGeneratedClass()
    }
    addProperty(
        modifiers = listOf(KModifier.INTERNAL),
        name = "EMPTY",
        type = type,
    ) {
        addAnnotation(PublishedApi::class)
        if (baseType == BaseType.GENERIC) {
            initializer("${baseType.generatedClassName}(emptyArray())")
        } else {
            initializer("${baseType.generatedClassName}(${baseType.backingArrayConstructor}(0))")
        }
    }
}

private fun TypeSpec.Builder.addInvokeOperator(baseType: BaseType) {
    val returnType = baseType.getGeneratedTypeName()
    addFunction(
        kdoc = """
            Returns an ${baseType.generatedClassName} instance of the specified [size], where each element is calculated by calling the specified [init] function.
            
            [init] is called sequentially starting at index 0 to initialize the array with each element at its given index.
            
            Implementation:
            We're using the invoke method instead of a regular constructor so that we can declare it inline.  The call site will look like a regular constructor call.
        """.trimIndent(),
        modifiers = listOf(KModifier.INLINE, KModifier.OPERATOR),
        name = "invoke",
        parameters = {
            "size"<Int>()
            "init"(type = lambda(parameters = { "index"<Int>() }, returnType = baseType.type))
        },
        returns = returnType,
    ) {
        if (baseType == BaseType.GENERIC) {
            suppress("UNCHECKED_CAST")
            addTypeVariable(baseType.type as TypeVariableName)
            addStatement("if (size == 0) return EMPTY as %T", returnType)
        } else {
            addStatement("if (size == 0) return EMPTY")
        }

        addStatement("val backingArray = ${baseType.backingArrayConstructor}(size) { index -> init(index) }")
        if (baseType == BaseType.GENERIC) {
            addStatement("return ${baseType.generatedClassName}(backingArray as %T)", baseType.backingArrayType)
        } else {
            addStatement("return ${baseType.generatedClassName}(backingArray)")
        }
    }
}

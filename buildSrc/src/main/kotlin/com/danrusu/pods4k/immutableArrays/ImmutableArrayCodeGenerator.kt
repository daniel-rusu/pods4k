package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.utils.*
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import java.io.File

private const val NUM_COMPONENT_N_FUNCTIONS = 5

internal object ImmutableArrayCodeGenerator {
    fun generate(destinationPath: String) {
        val packageName = ImmutableArrayCodeGenerator::class.java.`package`.name

        for (baseType in BaseType.values()) {
            val fileSpec = generateImmutableArrayFile(baseType, packageName)

            fileSpec.writeTo(File(destinationPath, ""))
        }
    }
}

private fun generateImmutableArrayFile(baseType: BaseType, packageName: String): FileSpec {
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
                get = "return values.size - 1"
            )
            overrideToString()
            addIsEmpty()
            addIsNotEmpty()
            addArrayIndexOperator(baseType)
            addComponentNFunctions(baseType)
            addSingle(baseType)
            addFirst(baseType)
            addLast(baseType)
            addIteratorOperator(baseType)
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
        modifiers = listOf(KModifier.PRIVATE),
        name = "values",
        type = baseType.backingArrayType,
        init = "values",
    )
}

private fun TypeSpec.Builder.overrideToString() {
    addFunction(
        modifiers = listOf(KModifier.OVERRIDE),
        name = "toString",
        returns = String::class.asTypeName(),
        code = """
            return values.joinToString(prefix = "[", postfix = "]")
        """.trimIndent()
    )
}

private fun TypeSpec.Builder.addIsEmpty() {
    addFunction(
        name = "isEmpty",
        returns = Boolean::class.asTypeName(),
        code = """
            return values.isEmpty()
        """.trimIndent()
    )
}

private fun TypeSpec.Builder.addIsNotEmpty() {
    addFunction(
        name = "isNotEmpty",
        returns = Boolean::class.asTypeName(),
        code = """
            return values.isNotEmpty()
        """.trimIndent()
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

private fun TypeSpec.Builder.addSingle(baseType: BaseType) {
    addFunction(
        kdoc = """
            Returns the single element from the array, or throws an exception if the array is empty or has more than one element.
        """.trimIndent(),
        name = "single",
        returns = baseType.type,
        code = """
            return when (size) {
                0 -> throw NoSuchElementException("Array is empty!")
                1 -> get(0)
                else -> throw IllegalArgumentException("Array has more than one element!")
            }
        """.trimIndent(),
    )
}

private fun TypeSpec.Builder.addFirst(baseType: BaseType) {
    addFunction(
        kdoc = """
            Returns the first element.
            
            @throws NoSuchElementException if the array is empty.
        """.trimIndent(),
        name = "first",
        returns = baseType.type,
        code = """
            if (isEmpty()) throw NoSuchElementException("Array is empty!")
            
            return get(0)
        """.trimIndent(),
    )
}

private fun TypeSpec.Builder.addLast(baseType: BaseType) {
    addFunction(
        kdoc = """
            Returns the last element.
            
            @throws NoSuchElementException if the array is empty.
        """.trimIndent(),
        name = "last",
        returns = baseType.type,
        code = """
            if (isEmpty()) throw NoSuchElementException("Array is empty!")
            
            return get(lastIndex)
        """.trimIndent(),
    )
}

private fun TypeSpec.Builder.addComponentNFunctions(baseType: BaseType) {
    for (n in 1..NUM_COMPONENT_N_FUNCTIONS) {
        addFunction(
            modifiers = listOf(KModifier.OPERATOR),
            name = "component$n",
            returns = baseType.type,
            code = "return get(${n - 1})"
        )
    }
}

private fun TypeSpec.Builder.addIteratorOperator(baseType: BaseType) {
    val iteratorType = Iterator::class.asClassName().parameterizedBy(baseType.type)

    addFunction(
        kdoc = "Creates an iterator allowing iteration over the elements of the array.",
        modifiers = listOf(KModifier.OPERATOR),
        name = "iterator",
        returns = iteratorType,
    ) {
        if (baseType == BaseType.GENERIC) {
            suppress("UNCHECKED_CAST")
            addStatement("return values.iterator() as %T", iteratorType)
        } else {
            addStatement("return values.iterator()")
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
        returns = qualifiedClassName.maybeAddGenericType(baseType)
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

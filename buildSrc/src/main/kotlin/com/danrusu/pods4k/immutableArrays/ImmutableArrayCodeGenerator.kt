package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.utils.*
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import java.io.File

private const val NUM_COMPONENT_N_FUNCTIONS = 5

private val packageName = ImmutableArrayCodeGenerator::class.java.`package`.name
private val emptySingletonsPackageName = "$packageName.emptySingletons"

private val emptyIterator = ClassName(emptySingletonsPackageName, "EmptyIterator")

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
                get = "return IntRange(0, lastIndex)",
            )
            overrideToString()
            addIsEmpty()
            addIsNotEmpty()
            addArrayIndexOperator(baseType)
            addGetOrNull(baseType)
            addComponentNFunctions(baseType)
            addSingle(baseType)
            addFirst(baseType)
            addFirstOrNull(baseType)
            addLast(baseType)
            addToList(baseType)
            addToMutableList(baseType)
            addIteratorOperator(baseType)
            addAsSequence(baseType)
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
        """.trimIndent(),
    )
}

private fun TypeSpec.Builder.addIsEmpty() {
    addFunction(
        name = "isEmpty",
        returns = Boolean::class.asTypeName(),
        code = """
            return values.isEmpty()
        """.trimIndent(),
    )
}

private fun TypeSpec.Builder.addIsNotEmpty() {
    addFunction(
        name = "isNotEmpty",
        returns = Boolean::class.asTypeName(),
        code = """
            return values.isNotEmpty()
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

private fun TypeSpec.Builder.addGetOrNull(baseType: BaseType) {
    val warning = when {
        // The 2 consecutive blank lines are intentional so that the kdoc ends up with a blank line before the warning
        baseType != BaseType.GENERIC -> """
            
            
            Note: 
            This array stores primitive values but getOrNull returns a nullable reference type resulting in the value being auto-boxed.
            
            When calling this method in a loop, for best performance and to reduce the pressure on the garbage collector, we recommend ensuring that the [index] is always within bounds and use [get] instead as that returns the primitive value without any autoboxing.
        """.trimIndent()

        else -> ""
    }

    addFunction(
        kdoc = "Returns the element at the specified [index] or null if the index is out of bounds.$warning",
        name = "getOrNull",
        parameters = { "index"<Int>() },
        returns = baseType.type.copy(nullable = true),
        code = """
            if (index < 0 || index > lastIndex) return null
            
            return get(index)
        """.trimIndent()
    )
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

private fun TypeSpec.Builder.addFirstOrNull(baseType: BaseType) {
    addFunction(
        kdoc = "Returns the first element or null if the array is empty.",
        name = "firstOrNull",
        returns = baseType.type.copy(nullable = true),
        code = "return if (isEmpty()) null else get(0)"
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
            code = "return get(${n - 1})",
        )
    }
}

private fun TypeSpec.Builder.addToList(baseType: BaseType) {
    val listType = List::class.asTypeName().parameterizedBy(baseType.type)

    addFunction(
        kdoc = "Returns a [List] containing all the elements.",
        name = "toList",
        returns = listType,
    ) {
        if (baseType == BaseType.GENERIC) {
            suppress("UNCHECKED_CAST")
            addStatement("return values.toList() as %T", listType)
        } else {
            addStatement("return values.toList()")
        }
    }
}

private fun TypeSpec.Builder.addToMutableList(baseType: BaseType) {
    val mutableListClassName = ClassName("kotlin.collections", "MutableList")
    val listType = mutableListClassName.parameterizedBy(baseType.type)

    addFunction(
        kdoc = "Returns a [MutableList] containing all the elements.",
        name = "toMutableList",
        returns = listType,
    ) {
        if (baseType == BaseType.GENERIC) {
            suppress("UNCHECKED_CAST")
            addStatement("return values.toMutableList() as %T", listType)
        } else {
            addStatement("return values.toMutableList()")
        }
    }
}

private fun TypeSpec.Builder.addIteratorOperator(baseType: BaseType) {
    val iteratorType = Iterator::class.asClassName().parameterizedBy(baseType.type)

    addFunction(
        kdoc = "Returns an iterator allowing iteration over the elements of the array.",
        modifiers = listOf(KModifier.OPERATOR),
        name = "iterator",
        returns = iteratorType,
    ) {
        addStatement("if (isEmpty()) return %T", emptyIterator)
        if (baseType == BaseType.GENERIC) {
            suppress("UNCHECKED_CAST")
            addStatement("return values.iterator() as %T", iteratorType)
        } else {
            addStatement("return values.iterator()")
        }
    }
}

private fun TypeSpec.Builder.addAsSequence(baseType: BaseType) {
    addFunction(
        kdoc = "Returns a [Sequence] which returns the elements of this array when iterated.",
        name = "asSequence",
        returns = Sequence::class.asClassName().parameterizedBy(baseType.type),
        code = """
            if (isEmpty()) return emptySequence()
            
            return Sequence { iterator() }
        """.trimIndent()
    )
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
        code = """
            for (value in this) {
                action(value)
            }
        """.trimIndent(),
    )
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
        code = """
            for (index in 0..lastIndex) {
                action(index, get(index))
            }
        """.trimIndent(),
    )
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

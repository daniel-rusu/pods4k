package com.danrusu.pods4k.immutableArrays.immutableArraysModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.BaseType.GENERIC
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.ParameterDSL
import com.danrusu.pods4k.utils.addPrimaryConstructor
import com.danrusu.pods4k.utils.comment
import com.danrusu.pods4k.utils.companionObject
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.declareClass
import com.danrusu.pods4k.utils.emptyLine
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.property
import com.danrusu.pods4k.utils.statement
import com.danrusu.pods4k.utils.suppress
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.NOTHING
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.WildcardTypeName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object ImmutableArrayGenerator {
    fun generate(destinationPath: String) {
        for (baseType in BaseType.values()) {
            val fileSpec = generateImmutableArrayFile(baseType)
            fileSpec.writeTo(File(destinationPath, ""))
        }
    }
}

private fun generateImmutableArrayFile(baseType: BaseType): FileSpec {
    return createFile(ImmutableArrayConfig.packageName, baseType.generatedClassName) {
        declareClass(modifiers = listOf(KModifier.VALUE), name = baseType.generatedClassName) {
            addKdoc(
                """
                    Represents an array that cannot have its elements re-assigned.
                    
                    Although this is a class that wraps a regular array, it's really a zero-cost abstraction that gets eliminated at compile time so that variables of this type end up pointing directly at the underlying array.
                    
                    In order to preserve the same performance as regular arrays, all methods that delegate to the same method on the backing array are marked with inline so that call sites end up calling the underlying methods directly.  Note that this won't have any negative performance impacts as it doesn't result in duplicate code or anything as it just replaces the wrapper method call with the underlying method call.
                """.trimIndent()
            )
            suppress("NOTHING_TO_INLINE")
            addAnnotation(JvmInline::class)
            if (baseType == GENERIC) {
                val typeName = (baseType.type as TypeVariableName).name
                addTypeVariable(TypeVariableName(typeName, KModifier.OUT))
            }
            addPrimaryConstructor(baseType)
            property<Int>(
                name = "size",
                getModifiers = listOf(KModifier.INLINE),
                get = "return values.size"
            )
            property<Int>(
                kdoc = "Returns the index of the last element or -1 if the array is empty.",
                name = "lastIndex",
                getModifiers = listOf(KModifier.INLINE),
                get = "return values.lastIndex",
            )
            property<IntRange>(
                kdoc = "Returns the range of valid indices for the array.",
                name = "indices",
                getModifiers = listOf(KModifier.INLINE),
                get = "return values.indices",
            )
            overrideToString()
            addEqualsOperator(baseType)
            overrideHashCode(baseType)
            "isEmpty"(baseType = baseType, returns = Boolean::class.asTypeName())
            "isNotEmpty"(baseType = baseType, returns = Boolean::class.asTypeName())
            addArrayIndexOperator(baseType)
            "getOrNull"(
                baseType = baseType,
                parameters = { "index"<Int>() },
                returns = baseType.type.copy(nullable = true),
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
            "asList"(
                baseType = baseType,
                kdoc = when (baseType) {
                    GENERIC -> "Wraps the backing array in a class that implements the read-only [List] interface by referencing the same backing array without copying the elements."
                    else -> {
                        """
                            Wraps the backing array in a class that implements the read-only [List] interface by referencing the same backing array without copying the elements.
                            
                            Note that [${baseType.generatedClassName}] stores primitive values whereas [List] operates on generic types so this will auto-box the value that is accessed on every access.  If the total number of accesses is expected to be multiple times larger than the total number of elements then you might want to consider converting it into a list instead as that will auto-box all the elements only once at the cost of allocating a separate backing array.
                        """.trimIndent()
                    }
                },
                returns = List::class.asTypeName().parameterizedBy(baseType.type)
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
            "all"(
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Boolean::class.asTypeName(),
            )
            "any"(
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Boolean::class.asTypeName(),
            )
            "none"(
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Boolean::class.asTypeName(),
            )
            "count"(
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Int::class.asTypeName(),
            )
            addPartition(baseType)
            addSortedBy(baseType)
            addSortedByDescending(baseType)
            addSortedWith(baseType)

            companionObject {
                if (baseType == GENERIC) {
                    suppress("UNCHECKED_CAST")
                }
                addCompanionObjectEmptyProperty(baseType)
                addCompanionObjectInvokeOperator(baseType)
            }

            declareClass(name = "Builder") {
                addKdoc(
                    """
                        Builder to construct immutable arrays when the resulting size isn't known in advance.
                        
                        @param initialCapacity The initial capacity of the temporary array where the values are accumulated.  A larger value reduces the number of times it's resized as elements get added.
                    """.trimIndent()
                )
                if (baseType == GENERIC) {
                    addTypeVariable(baseType.type as TypeVariableName)
                }
                addPrimaryConstructor(
                    parameters = { "initialCapacity"<Int>(defaultValue = "10") },
                )
                property<Int>(isMutable = true, name = "size", init = "0", privateSetter = true)
                property(
                    modifiers = listOf(KModifier.PRIVATE),
                    isMutable = true,
                    name = "values",
                    type = when (baseType) {
                        GENERIC -> Array::class.asTypeName()
                            .parameterizedBy(Any::class.asTypeName().copy(nullable = true))

                        else -> baseType.backingArrayType
                    },
                ) {
                    when (baseType) {
                        GENERIC -> initializer("arrayOfNulls(initialCapacity)")
                        else -> initializer("${baseType.backingArrayConstructor}(initialCapacity)")
                    }
                }
                addBuilderAddFunction(baseType)
                addBuilderPlusAssignOperator(baseType)
                addBuilderAddAllFunctions(baseType)
                addBuilderBuildFunction(baseType)
                addBuilderEnsureCapacityFunction(baseType)
            }
        }
    }
}

/**
 * Delegates to the same function on the backing array.
 *
 * @param baseType
 */
context (TypeSpec.Builder)
private operator fun String.invoke(
    baseType: BaseType,
    kdoc: String = "See [${if (baseType == GENERIC) "Array" else baseType.backingArrayConstructor}.$this]",
    modifiers: List<KModifier> = emptyList(),
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName = Unit::class.asTypeName(),
) {
    val params = ParameterDSL().apply(parameters).build()
    function(
        kdoc = kdoc,
        // Inline all delegated functions so that we get the same performance as if working with a regular array
        modifiers = modifiers + KModifier.INLINE,
        name = this,
        parameters = parameters,
        returns = returns,
    ) {
        statement("return values.${this@invoke}(${params.joinToString { it.name }})")
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
    }.property(
        kdoc = """
            This is internal instead of private so we can have inline functions that delegate to the same function on the backing array.  The backing array won't be accessible from Kotlin code since the auto-generated arrays are in their own module and the internal modifier prevents outside access.  The constructor is also internal preventing anyone from creating an "instance" that points to an array that they have access to.
            
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
    function(
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
        GENERIC -> baseType.getGeneratedClass().parameterizedBy(STAR)
        else -> baseType.getGeneratedClass()
    }
    function(
        modifiers = listOf(KModifier.OPERATOR),
        name = "equals",
        parameters = { "other"(type = otherType) },
        returns = Boolean::class.asTypeName(),
    ) {
        addStatement("if (other.size != this.size) return false")
        emptyLine()
        controlFlow("forEachIndexed { index, element ->") {
            addStatement("if (other[index] != element) return false")
        }
        addStatement("return true")
    }
}

private fun TypeSpec.Builder.overrideHashCode(baseType: BaseType) {
    val prime1 = 7
    val prime2 = 31
    function(
        modifiers = listOf(KModifier.OVERRIDE),
        name = "hashCode",
        returns = Int::class.asTypeName(),
    ) {
        comment("Start with non-zero hash so that arrays that start with a different number of zero-hash elements end up with different hashCodes")

        statement("var hashCode = $prime1")
        controlFlow("for (value in values)") {
            when (baseType) {
                GENERIC -> statement("hashCode = $prime2 * hashCode + (value?.hashCode() ?: 0)")
                else -> statement("hashCode = $prime2 * hashCode + value.hashCode()")
            }
        }
        statement("return hashCode")
    }
}

private fun TypeSpec.Builder.addArrayIndexOperator(baseType: BaseType) {
    function(
        modifiers = listOf(KModifier.INLINE, KModifier.OPERATOR),
        kdoc = "Returns the element at the specified [index]. This method can be called using the index operator.",
        name = "get",
        parameters = { "index"<Int>() },
        returns = baseType.type,
        code = "return values[index]",
    )
}

private fun TypeSpec.Builder.addComponentNFunctions(baseType: BaseType) {
    for (n in 1..ImmutableArrayConfig.NUM_COMPONENT_N_FUNCTIONS) {
        function(
            modifiers = listOf(KModifier.OPERATOR),
            name = "component$n",
            returns = baseType.type,
            code = "return get(${n - 1})",
        )
    }
}

private fun TypeSpec.Builder.addPartition(baseType: BaseType) {
    function(
        kdoc = """
            Creates a pair of immutable arrays, where the first contains elements for which predicate yielded true, and the second contains the other elements.
        """.trimIndent(),
        name = "partition",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = Pair::class.asTypeName()
            .parameterizedBy(baseType.getGeneratedTypeName(), baseType.getGeneratedTypeName())
    ) {
        if (baseType == GENERIC) {
            statement("val first = Builder<%T>()", baseType.type)
            statement("val second = Builder<%T>()", baseType.type)
        } else {
            statement("val first = Builder()")
            statement("val second = Builder()")
        }
        controlFlow("for (element in values)") {
            controlFlow("when (predicate(element))") {
                statement("true -> first.add(element)")
                statement("else -> second.add(element)")
            }
        }
        statement("return Pair(first.build(), second.build())")
    }
}

private fun TypeSpec.Builder.addSortedBy(baseType: BaseType) {
    val genericVariableName = "R"
    val genericType = TypeVariableName(genericVariableName)
    function(
        kdoc = """
            Leaves this immutable array as is and returns an ${baseType.generatedClassName} with all elements sorted according to the natural sort order of the value returned by the [selector].
            
            The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
        """.trimIndent(),
        modifiers = listOf(KModifier.INLINE),
        name = "sortedBy",
        parameters = {
            "selector"(
                modifiers = listOf(KModifier.CROSSINLINE),
                type = lambda(
                    parameters = { "element"(type = baseType.type) },
                    returnType = genericType.copy(nullable = true)
                )
            )
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        addTypeVariable(
            TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType))
        )
        statement("return sortedWith(compareBy(selector))")
    }
}

private fun TypeSpec.Builder.addSortedByDescending(baseType: BaseType) {
    val genericVariableName = "R"
    val genericType = TypeVariableName(genericVariableName)
    function(
        kdoc = """
            Leaves this immutable array as is and returns an ${baseType.generatedClassName} with all elements sorted according to the reverse natural sort order of the value returned by the [selector].
            
            The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
        """.trimIndent(),
        modifiers = listOf(KModifier.INLINE),
        name = "sortedByDescending",
        parameters = {
            "selector"(
                modifiers = listOf(KModifier.CROSSINLINE),
                type = lambda(
                    parameters = { "element"(type = baseType.type) },
                    returnType = genericType.copy(nullable = true)
                )
            )
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        addTypeVariable(
            TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType))
        )
        statement("return sortedWith(compareByDescending(selector))")
    }
}

private fun TypeSpec.Builder.addSortedWith(baseType: BaseType) {
    function(
        kdoc = "Leaves this immutable array as is and returns an [${baseType.generatedClassName}] with all elements sorted according to the specified [comparator].",
        name = "sortedWith",
        parameters = {
            "comparator"(
                type = Comparator::class.asTypeName().parameterizedBy(WildcardTypeName.consumerOf(baseType.type))
            )
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        comment("Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change")
        statement("if (size <= 1) return this")
        emptyLine()
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement(
                "val backingArray = ${baseType.backingArrayConstructor}(size) { get(it) } as Array<%T>",
                baseType.type
            )
            statement("%T.sort(backingArray, comparator)", java.util.Arrays::class)
            statement("return ${baseType.generatedClassName}(backingArray)")
        } else {
            // The standard library comparator-based sort algorithms only operate on generic arrays
            statement("val temp = values.toTypedArray()")
            statement("%T.sort(temp, comparator)", java.util.Arrays::class)
            statement("return temp.toImmutableArray()")
        }
    }
}

private fun TypeSpec.Builder.addCompanionObjectEmptyProperty(baseType: BaseType) {
    val type = when (baseType) {
        GENERIC -> baseType.getGeneratedClass().parameterizedBy(NOTHING)
        else -> baseType.getGeneratedClass()
    }
    property(
        modifiers = listOf(KModifier.INTERNAL),
        name = "EMPTY",
        type = type,
    ) {
        addAnnotation(PublishedApi::class)
        when (baseType) {
            GENERIC -> initializer("${baseType.generatedClassName}(emptyArray<Any>()) as %T", type)
            else -> initializer("${baseType.generatedClassName}(${baseType.backingArrayConstructor}(0))")
        }
    }
}

private fun TypeSpec.Builder.addCompanionObjectInvokeOperator(baseType: BaseType) {
    val returnType = baseType.getGeneratedTypeName()
    function(
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
        if (baseType == GENERIC) {
            addTypeVariable(baseType.type as TypeVariableName)
        }
        statement("if (size == 0) return EMPTY")
        emptyLine()
        statement("val backingArray = ${baseType.backingArrayConstructor}(size) { index -> init(index) }")
        if (baseType == GENERIC) {
            statement("return ${baseType.generatedClassName}(backingArray as %T)", baseType.backingArrayType)
        } else {
            statement("return ${baseType.generatedClassName}(backingArray)")
        }
    }
}

private fun TypeSpec.Builder.addBuilderAddFunction(baseType: BaseType) {
    val returnType = when (baseType) {
        GENERIC -> ClassName(
            ImmutableArrayConfig.packageName,
            "${baseType.generatedClassName}.Builder"
        ).parameterizedBy(baseType.type)

        else -> ClassName(ImmutableArrayConfig.packageName, "${baseType.generatedClassName}.Builder")
    }
    function(
        name = "add",
        parameters = { "element"(type = baseType.type) },
        returns = returnType,
    ) {
        statement("ensureCapacity(size + 1)")
        statement("values[size++] = element")
        statement("return this")
    }
}

private fun TypeSpec.Builder.addBuilderPlusAssignOperator(baseType: BaseType) {
    function(
        modifiers = listOf(KModifier.OPERATOR),
        kdoc = "Adds the [element] to the builder.",
        name = "plusAssign",
        parameters = { "element"(type = baseType.type) },
        code = "add(element)",
    )
}

private fun TypeSpec.Builder.addBuilderAddAllFunctions(baseType: BaseType) {
    val returnType = when (baseType) {
        GENERIC -> {
            ClassName(ImmutableArrayConfig.packageName, "${baseType.generatedClassName}.Builder")
                .parameterizedBy(baseType.type)
        }

        else -> ClassName(ImmutableArrayConfig.packageName, "${baseType.generatedClassName}.Builder")
    }
    function(
        name = "addAll",
        parameters = { "elements"(type = baseType.backingArrayType) },
        returns = returnType,
    ) {
        statement("ensureCapacity(size + elements.size)")
        statement("System.arraycopy(elements, 0, values, size, elements.size)")
        statement("size += elements.size")
        statement("return this")
    }

    if (baseType != GENERIC) {
        function(
            name = "addAll",
            parameters = { "elements"(type = Array::class.asTypeName().parameterizedBy(baseType.type)) },
            returns = returnType,
        ) {
            statement("ensureCapacity(size + elements.size)")
            controlFlow("for (element in elements)") {
                statement("values[size++] = element")
            }
            statement("return this")
        }
    }

    function(
        name = "addAll",
        parameters = { "elements"(type = baseType.getGeneratedTypeName()) },
        returns = returnType,
    ) {
        statement("ensureCapacity(size + elements.size)")
        statement("System.arraycopy(elements.values, 0, values, size, elements.size)")
        statement("size += elements.size")
        statement("return this")
    }

    if (baseType != GENERIC) {
        function(
            name = "addAll",
            parameters = { "elements"(type = GENERIC.getGeneratedClass().parameterizedBy(baseType.type)) },
            returns = returnType,
        ) {
            statement("ensureCapacity(size + elements.size)")
            controlFlow("for (element in elements)") {
                statement("values[size++] = element")
            }
            statement("return this")
        }
    }

    function(
        name = "addAll",
        parameters = { "elements"(type = Iterable::class.asTypeName().parameterizedBy(baseType.type)) },
        returns = returnType,
    ) {
        controlFlow("if (elements is Collection)") {
            statement("ensureCapacity(size + elements.size)")
            controlFlow("for (element in elements)") {
                statement("values[size++] = element")
            }
            statement("return this")
        }
        controlFlow("for (element in elements)") {
            statement("add(element)")
        }
        statement("return this")
    }
}

private fun TypeSpec.Builder.addBuilderBuildFunction(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing the elements that were added.",
        name = "build",
        returns = baseType.getGeneratedTypeName(),
    ) {
        controlFlow("when (size)") {
            statement("0 -> return EMPTY")

            // Avoiding copying the array again when the size matches the capacity is important for when the initial
            // capacity was set appropriately.  Other capabilities of this library depend on this optimization
            if (baseType == GENERIC) {
                statement("values.size -> return ${baseType.generatedClassName}(values as Array<%T>)", baseType.type)
            } else {
                statement("values.size -> return ${baseType.generatedClassName}(values)")
            }
        }
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement("val backingArray = arrayOfNulls<Any?>(size) as Array<%T>", baseType.type)
        } else {
            statement("val backingArray = ${baseType.backingArrayConstructor}(size)")
        }
        statement("System.arraycopy(values, 0, backingArray, 0, size)")

        statement("return ${baseType.generatedClassName}(backingArray)")
    }
}

private fun TypeSpec.Builder.addBuilderEnsureCapacityFunction(baseType: BaseType) {
    function(
        modifiers = listOf(KModifier.PRIVATE),
        name = "ensureCapacity",
        parameters = { "minCapacity"<Int>() },
    ) {
        statement("val newCapacity = BuilderUtils.computeNewCapacity(values.size, minCapacity)")
        statement("if (newCapacity == values.size) return")
        emptyLine()
        when (baseType) {
            GENERIC -> statement("val replacement = arrayOfNulls<Any?>(newCapacity)")
            else -> statement("val replacement = ${baseType.backingArrayConstructor}(newCapacity)")
        }
        statement("System.arraycopy(values, 0, replacement, 0, size)")
        statement("values = replacement")
    }
}

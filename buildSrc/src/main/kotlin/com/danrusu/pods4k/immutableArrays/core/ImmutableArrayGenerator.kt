package com.danrusu.pods4k.immutableArrays.core

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
        for (baseType in BaseType.entries) {
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

                    To preserve the same performance as regular arrays, all functions that simply delegate to the same function on the backing array are marked inline.  This won't result in code duplication as it's a direct substitution replacing calls to the wrapper with direct calls to the underlying functions on the backing array.
                """.trimIndent(),
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
                get = "return values.size",
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

            "joinToString"(
                typeSpecBuilder = this,
                baseType = baseType,
                makeInline = false, // because the lambda is nullable
                parameters = {
                    "separator"<CharSequence>(defaultValue = "\", \"")
                    "prefix"<CharSequence>(defaultValue = "\"\"")
                    "postfix"<CharSequence>(defaultValue = "\"\"")
                    "limit"<Int>(defaultValue = "-1")
                    "truncated"<CharSequence>(defaultValue = "\"...\"")
                    "transform"(
                        type = nullableLambda<CharSequence>(parameters = { "element"(type = baseType.type) }),
                        defaultValue = "null",
                    )
                },
                returns = String::class.asTypeName(),
            )

            addEqualsOperator(baseType)
            overrideHashCode(baseType)
            "isEmpty"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Boolean::class.asTypeName(),
            )
            "isNotEmpty"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Boolean::class.asTypeName(),
            )
            addArrayIndexOperator(baseType)
            "getOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "index"<Int>() },
                returns = baseType.type.copy(nullable = true),
            )
            addComponentNFunctions(baseType)
            "single"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type,
            )
            "single"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type,
                forceFunctionBody = true,
            )
            "singleOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "singleOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type.copy(nullable = true),
                forceFunctionBody = true,
            )
            "first"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type,
            )
            "first"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type,
                forceFunctionBody = true,
            )
            "firstOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "firstOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type.copy(nullable = true),
                forceFunctionBody = true,
            )
            "last"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type,
            )
            "last"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type,
                forceFunctionBody = true,
            )
            "lastOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "lastOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type.copy(nullable = true),
                forceFunctionBody = true,
            )
            "iterator"(
                typeSpecBuilder = this,
                baseType = baseType,
                modifiers = listOf(KModifier.OPERATOR),
                returns = Iterator::class.asTypeName().parameterizedBy(baseType.type),
            )
            "asIterable"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Iterable::class.asTypeName().parameterizedBy(baseType.type),
            )
            "withIndex"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Iterable::class.asTypeName().parameterizedBy(
                    IndexedValue::class.asTypeName().parameterizedBy(baseType.type),
                ),
            )
            "asSequence"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Sequence::class.asTypeName().parameterizedBy(baseType.type),
            )
            "forEach"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "action"(type = lambda<Unit> { "element"(type = baseType.type) })
                },
            )
            "forEachIndexed"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "action"(
                        type = lambda<Unit> {
                            "index"<Int>()
                            "element"(type = baseType.type)
                        },
                    )
                },
            )
            "all"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Boolean::class.asTypeName(),
                forceFunctionBody = true,
            )
            "any"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Boolean::class.asTypeName(),
                forceFunctionBody = true,
            )
            "none"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Boolean::class.asTypeName(),
                forceFunctionBody = true,
            )
            "count"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Int::class.asTypeName(),
                forceFunctionBody = true,
            )
            "indexOfFirst"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = Int::class.asTypeName(),
                forceFunctionBody = true,
            )
            "indexOfLast"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = Int::class.asTypeName(),
                forceFunctionBody = true,
            )
            addTake(baseType)
            addTakeWhile(baseType)
            addTakeLast(baseType)
            addTakeLastWhile(baseType)
            addDrop(baseType)
            addFilter(baseType)
            addFilterIndexed(baseType)
            addFilterNot(baseType)
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
                        Builder to create immutable arrays when the resulting size isn't known in advance.

                        @param initialCapacity The initial capacity of the temporary array where the values are accumulated.  A larger value reduces the number of times it's resized as elements get added.
                    """.trimIndent(),
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

                /**
                 * IMPORTANT: See the warning in [addBuilderBuildFunction] before considering adding mutating
                 * capabilities that clear, remove, or re-assign previous elements.  Adding these types of capabilities
                 * would require that optimization to be removed.
                 */
                addBuilderAddFunction(baseType)
                addBuilderPlusAssignOperator(baseType)
                addBuilderAddAllFunctions(baseType)
                addBuilderBuildFunction(baseType)
                addBuilderEnsureCapacityFunction(baseType)
            }
        }
    }
}

/** Delegates to the same function on the backing array */
private operator fun String.invoke(
    typeSpecBuilder: TypeSpec.Builder,
    baseType: BaseType,
    kdoc: String = "See [${if (baseType == GENERIC) "Array" else baseType.backingArrayConstructor}.$this]",
    makeInline: Boolean = true,
    modifiers: List<KModifier> = emptyList(),
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName = Unit::class.asTypeName(),
    forceFunctionBody: Boolean = false,
) {
    val params = ParameterDSL().apply(parameters).build().joinToString { it.name }
    typeSpecBuilder.function(
        kdoc = kdoc,
        // Inline all delegated functions so that we get the same performance as if working with a regular array
        modifiers = if (makeInline) modifiers + KModifier.INLINE else modifiers,
        name = this,
        parameters = parameters,
        returns = returns,
        forceFunctionBody = forceFunctionBody,
    ) {
        if (returns == Unit::class.asTypeName()) {
            statement("values.${this@invoke}($params)")
        } else {
            statement("return values.${this@invoke}($params)")
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
    }.property(
        kdoc = """
            The backing array is internal instead of private so that we can have inline functions that delegate to the same function on the backing array.  The backing array won't be accessible from Kotlin code since the auto-generated arrays are in their own module and the internal modifier prevents outside access.  The constructor is also internal preventing anyone from creating an "instance" that points to an array that they have access to.

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
    ) {
        statement(
            """
                return values.joinToString(prefix = "[", postfix = "]")
            """.trimIndent(),
        )
    }
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
        // IMPORTANT: Check referential equality of backing array (not `other === this`) to handle auto-boxing scenarios
        addStatement("if (other.values === this.values) return true")
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
        comment(
            "Start with non-zero hash so that arrays that start with a different number of zero-hash elements end " +
                "up with different hashCodes",
        )

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
        kdoc = "Returns the element at [index]. This method can be called using the index operator.",
        name = "get",
        parameters = { "index"<Int>() },
        returns = baseType.type,
    ) {
        statement("return values[index]")
    }
}

private fun TypeSpec.Builder.addComponentNFunctions(baseType: BaseType) {
    for (n in 1..ImmutableArrayConfig.NUM_COMPONENT_N_FUNCTIONS) {
        function(
            modifiers = listOf(KModifier.OPERATOR),
            name = "component$n",
            returns = baseType.type,
        ) {
            statement("return get(${n - 1})")
        }
    }
}

private fun TypeSpec.Builder.addTake(baseType: BaseType) {
    function(
        kdoc = """
            Returns an immutable array containing the first [n] elements.

            @throws IllegalArgumentException if [n] is negative.
        """.trimIndent(),
        name = "take",
        parameters = { "n"<Int>() },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement(
            """
            require(n >= 0) { "Requested element count ${'$'}n is less than zero." }
            """.trimIndent(),
        )
        statement("if (n == 0) return EMPTY")
        statement("if (n >= size) return this")
        emptyLine()
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement("val backingArray = arrayOfNulls<Any>(n) as %T", baseType.backingArrayType)
        } else {
            statement("val backingArray = ${baseType.backingArrayConstructor}(n)")
        }
        statement("System.arraycopy(values, 0, backingArray, 0, n)")
        statement("return ${baseType.generatedClassName}(backingArray)")
    }
}

private fun TypeSpec.Builder.addTakeWhile(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing the first elements that satisfy the [predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "takeWhile",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement("var untilIndex = 0")
        controlFlow("while (untilIndex < size && predicate(values[untilIndex]))") {
            statement("untilIndex++")
        }
        statement("return take(untilIndex)")
    }
}

private fun TypeSpec.Builder.addTakeLast(baseType: BaseType) {
    function(
        kdoc = """
            Returns an immutable array containing the last [n] elements.

            @throws IllegalArgumentException if [n] is negative.
        """.trimIndent(),
        name = "takeLast",
        parameters = { "n"<Int>() },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement(
            """
            require(n >= 0) { "Requested element count ${'$'}n is less than zero." }
            """.trimIndent(),
        )
        statement("if (n == 0) return EMPTY")
        statement("if (n >= size) return this")
        emptyLine()
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement("val backingArray = arrayOfNulls<Any>(n) as %T", baseType.backingArrayType)
        } else {
            statement("val backingArray = ${baseType.backingArrayConstructor}(n)")
        }
        statement("System.arraycopy(values, size - n, backingArray, 0, n)")
        statement("return ${baseType.generatedClassName}(backingArray)")
    }
}

private fun TypeSpec.Builder.addTakeLastWhile(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing the last elements that satisfy the [predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "takeLastWhile",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement("var untilIndex = lastIndex")
        controlFlow("while (untilIndex >= 0 && predicate(values[untilIndex]))") {
            statement("untilIndex--")
        }
        statement("return takeLast(lastIndex - untilIndex)")
    }
}

private fun TypeSpec.Builder.addDrop(baseType: BaseType) {
    function(
        kdoc = """
            Returns an immutable array containing all the elements expect the first n elements.

            @throws IllegalArgumentException if [n] is negative.
        """.trimIndent(),
        name = "drop",
        parameters = { "n"<Int>() },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement(
            """
            require(n >= 0) { "Requested element count ${'$'}n is less than zero." }
            """.trimIndent(),
        )
        emptyLine()
        statement("return takeLast((size - n).coerceAtLeast(0))")
    }
}

private fun TypeSpec.Builder.addFilter(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing only the elements matching the given [predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "filter",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = baseType.getGeneratedTypeName(),
    ) {
        if (baseType == GENERIC) {
            statement("val result = Builder<%T>()", baseType.type)
        } else {
            statement("val result = Builder()")
        }
        controlFlow("for (element in values)") {
            controlFlow("if (predicate(element))") {
                statement("result.add(element)")
            }
        }
        statement("if (result.size == size) return this")
        emptyLine()
        statement("return result.build()")
    }
}

private fun TypeSpec.Builder.addFilterIndexed(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing only the elements matching the given [predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "filterIndexed",
        parameters = {
            "predicate"(
                type = lambda<Boolean> {
                    "index"<Int>()
                    "element"(type = baseType.type)
                },
            )
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        if (baseType == GENERIC) {
            statement("val result = Builder<%T>()", baseType.type)
        } else {
            statement("val result = Builder()")
        }
        controlFlow("forEachIndexed { index, element ->") {
            controlFlow("if (predicate(index, element))") {
                statement("result.add(element)")
            }
        }
        statement("if (result.size == size) return this")
        emptyLine()
        statement("return result.build()")
    }
}

private fun TypeSpec.Builder.addFilterNot(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing only the elements that don't match the [predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "filterNot",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = baseType.getGeneratedTypeName(),
    ) {
        if (baseType == GENERIC) {
            statement("val result = Builder<%T>()", baseType.type)
        } else {
            statement("val result = Builder()")
        }
        controlFlow("for (element in values)") {
            controlFlow("if (!predicate(element))") {
                statement("result.add(element)")
            }
        }
        statement("if (result.size == size) return this")
        emptyLine()
        statement("return result.build()")
    }
}

private fun TypeSpec.Builder.addPartition(baseType: BaseType) {
    // Validated with JMH benchmarks that this function is faster as a regular non-inlined function
    function(
        kdoc = "Creates a pair of immutable arrays, where the first contains elements for which the predicate " +
            "yielded true, and the second contains the other elements.",
        name = "partition",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = Pair::class.asTypeName()
            .parameterizedBy(baseType.getGeneratedTypeName(), baseType.getGeneratedTypeName()),
    ) {
        /*
        Create a perfectly-sized double-ended buffer.  Add the elements that yielded true starting from the beginning of
        the buffer and the other elements from the end.  The only trick is to remember to copy the elements from the end
        in reverse order so that they maintain their original ordering.

        This uses less memory and is much faster based on JMH benchmarks compared to the traditional approach of
        maintaining separate builders.  That's because unlike the builders, the buffer never needs to be resized so the
        elements don't need to be copied multiple times into larger replacements as it gets resized along the way.
         */
        statement("var firstIndex = 0")
        statement("var secondIndex = size - 1")
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement("val buffer = arrayOfNulls<Any?>(size) as Array<T>")
        } else {
            statement("val buffer = ${baseType.backingArrayConstructor}(size)")
        }
        controlFlow("for (element in values)") {
            addCode(
                """
                    if (predicate(element)) {
                        buffer[firstIndex] = element
                        firstIndex++
                    } else {
                        buffer[secondIndex] = element
                        secondIndex--
                    }
                """.trimIndent(),
            )
        }
        statement("if (firstIndex == 0) return Pair(empty${baseType.generatedClassName}(), this)")
        statement("if (firstIndex == size) return Pair(this, empty${baseType.generatedClassName}())")
        emptyLine()
        statement("val first = ${baseType.generatedClassName}(firstIndex) { buffer[it] }")
        statement("val second = ${baseType.generatedClassName}(size - first.size) { buffer[size - it - 1] }")
        statement("return Pair(first, second)")
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
                    returnType = genericType.copy(nullable = true),
                ),
            )
        },
        returns = baseType.getGeneratedTypeName(),
        forceFunctionBody = true,
    ) {
        addTypeVariable(
            TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType)),
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
                    returnType = genericType.copy(nullable = true),
                ),
            )
        },
        returns = baseType.getGeneratedTypeName(),
        forceFunctionBody = true,
    ) {
        addTypeVariable(
            TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType)),
        )
        statement("return sortedWith(compareByDescending(selector))")
    }
}

private fun TypeSpec.Builder.addSortedWith(baseType: BaseType) {
    function(
        kdoc = "Leaves this immutable array as is and returns an [${baseType.generatedClassName}] with all elements " +
            "sorted according to the specified [comparator].",
        name = "sortedWith",
        parameters = {
            "comparator"(
                type = Comparator::class.asTypeName().parameterizedBy(WildcardTypeName.consumerOf(baseType.type)),
            )
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        comment(
            "Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change",
        )
        statement("if (size <= 1) return this")
        emptyLine()
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement(
                "val backingArray = ${baseType.backingArrayConstructor}(size) { get(it) } as Array<%T>",
                baseType.type,
            )
            statement("%T.sort(backingArray, comparator)", java.util.Arrays::class)
            statement("return ${baseType.generatedClassName}(backingArray)")
        } else {
            // The standard library comparator-based sort utilities only operate on generic arrays.
            // This is probably to avoid auto-boxing each value everytime it's compared
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
            Returns an ${baseType.generatedClassName} instance of the specified [size], where each element is calculated by calling the [init] function.

            [init] is called sequentially, starting at index 0, to initialize the array with each element at its given index.

            Implementation:
            We're using the invoke operator instead of a regular constructor so that we can declare it inline.  The call site will look like a regular constructor call.
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
        GENERIC -> ClassName(ImmutableArrayConfig.packageName, baseType.generatedClassName, "Builder")
            .parameterizedBy(baseType.type)

        else -> ClassName(ImmutableArrayConfig.packageName, baseType.generatedClassName, "Builder")
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
    ) {
        statement("add(element)")
    }
}

private fun TypeSpec.Builder.addBuilderAddAllFunctions(baseType: BaseType) {
    val builderType = when (baseType) {
        GENERIC -> ClassName(ImmutableArrayConfig.packageName, baseType.generatedClassName, "Builder")
            .parameterizedBy(baseType.type)

        else -> ClassName(ImmutableArrayConfig.packageName, baseType.generatedClassName, "Builder")
    }
    function(
        name = "addAll",
        parameters = { "elements"(type = baseType.backingArrayType) },
        returns = builderType,
    ) {
        statement("ensureCapacity(size + elements.size)")
        statement("System.arraycopy(elements, 0, values, size, elements.size)")
        statement("size += elements.size")
        statement("return this")
    }

    if (baseType != GENERIC) {
        // Supports boxed values.  Eg. adding Array<Int> to ImmutableIntArray.Builder
        function(
            name = "addAll",
            parameters = { "elements"(type = Array::class.asTypeName().parameterizedBy(baseType.type)) },
            returns = builderType,
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
        returns = builderType,
    ) {
        statement("ensureCapacity(size + elements.size)")
        statement("System.arraycopy(elements.values, 0, values, size, elements.size)")
        statement("size += elements.size")
        statement("return this")
    }

    if (baseType != GENERIC) {
        // Supports boxed values.  Eg. adding ImmutableArray<Int> to ImmutableIntArray.Builder
        function(
            name = "addAll",
            parameters = { "elements"(type = GENERIC.getGeneratedClass().parameterizedBy(baseType.type)) },
            returns = builderType,
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
        returns = builderType,
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

    function(
        name = "addAll",
        parameters = { "elements"(type = Sequence::class.asTypeName().parameterizedBy(baseType.type)) },
        returns = builderType,
    ) {
        statement("elements.forEach { add(it) }")
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

            /*
            Avoiding copying the array again when the size matches the capacity is important for when the initial
            capacity was set appropriately.  Other capabilities of this library depend on this optimization for optimal
            efficiency.

             *** IMPORTANT ***
            This optimization is only safe as long as the builder can only append elements without the ability to
            remove or re-assign previously-added elements.  Allowing the ability to modify previously-assigned array
            positions would introduce a mutation backdoor:
             1. Call build() when the array is exactly full so that the immutable array uses the same backing array
             2. Continue using the builder to remove or re-assign previous elements modifying the immutable array

            This optimization is safe when only reading & appending is allowed because:
             1. Reading doesn't modify the immutable array anyway
             2. Continuing to use the builder to append more elements would end up creating a new backing array because
             this optimization only applies when calling build() with the array exactly full.
             */
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

/**
 * Ensures that the backing array is large enough to add more elements.
 *
 * IMPORTANT:
 * When creating a larger backing array, don't modify the existing array because build() may have been called on a full
 * array which ends up sharing the same backing array with the generated immutable array.  See the warning in
 * [addBuilderBuildFunction] for more specifics.
 */
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

package com.danrusu.pods4k.immutableArrays.core

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.BaseType.BOOLEAN
import com.danrusu.pods4k.immutableArrays.BaseType.GENERIC
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.immutableArrays.createImmutableArrayBuilder
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.annotation
import com.danrusu.pods4k.utils.comment
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.emptyLine
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.jvmName
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.WildcardTypeName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object ImmutableArrayExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "ImmutableArrays") {
            addAsList()
            addContains()
            addIndexOf()
            addLastIndexOf()
            addGetOrElse()
            addMin()
            addMinOrNull()
            addMax()
            addMaxOrNull()
            addFilterNotNull()
            addSorted()
            addSortedDescending()
            addPlusImmutableArray()
            addPlusValue()
            addToPrimitiveImmutableArray()
            addToTypedImmutableArray()
            addToMutableArray()
            addToTypedMutableArray()
            addRequireNoNulls()
            addFlatten()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addAsList() {
    val genericKdoc = "Returns an immutable list that wraps the same backing array without copying the elements."

    val generatePrimitiveKdoc: (BaseType) -> String = { baseType ->
        val immutableArrayClass = baseType.generatedClassName

        """
            $genericKdoc

            Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is
            because [$immutableArrayClass] stores primitive values whereas [List] is defined as a generic type.  If the
            number of accesses is expected to be multiple times larger than the size of this array, then you might want
            to consider using [toList] instead in order to copy all the elements into a standalone list and only
            auto-box each element once.
        """.trimIndent()
    }

    for (baseType in BaseType.entries) {
        function(
            kdoc = when (baseType) {
                GENERIC -> genericKdoc
                else -> generatePrimitiveKdoc(baseType)
            },
            receiver = baseType.getGeneratedTypeName(),
            name = "asList",
            returns = List::class.asTypeName().parameterizedBy(baseType.type),
        ) {
            addGenericTypes(baseType.type)

            // IMPORTANT: Don't attempt to delegate to the backing array (eg. "return values.asList()") because that
            // can allow an outsider to mutate the backing array via the list wrapper
            // See https://youtrack.jetbrains.com/issue/KT-70779/Array.asList-exposes-mutation-back-door
            addCode(
                """
                    return object : %T<%T>(), %T {
                        override val size: Int get() = this@asList.size
                        override fun isEmpty(): Boolean = this@asList.isEmpty()
                        override fun contains(element: %T): Boolean = this@asList.contains(element)
                        override fun get(index: Int): %T = this@asList[index]
                        override fun indexOf(element: %T): Int = this@asList.indexOf(element)
                        override fun lastIndexOf(element: %T): Int = this@asList.lastIndexOf(element)
                    }
                """.trimIndent(),
                AbstractList::class.asTypeName(),
                baseType.type,
                RandomAccess::class.asTypeName(),
                baseType.type,
                baseType.type,
                baseType.type,
                baseType.type,
            )
        }
    }
}

private fun FileSpec.Builder.addContains() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.contains]",
            modifiers = listOf(KModifier.OPERATOR),
            receiver = baseType.getGeneratedTypeName(),
            name = "contains",
            parameters = { "element"(type = baseType.type) },
            returns = Boolean::class.asTypeName(),
            forceFunctionBody = true,
        ) {
            addGenericTypes(baseType.type)

            statement("return any { it == element }")
        }
    }
}

private fun FileSpec.Builder.addIndexOf() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.indexOf]",
            receiver = baseType.getGeneratedTypeName(),
            name = "indexOf",
            parameters = { "element"(type = baseType.type) },
            returns = Int::class.asTypeName(),
        ) {
            addGenericTypes(baseType.type)

            statement("forEachIndexed { index, value -> if (value == element) return index }")
            statement("return -1")
        }
    }
}

private fun FileSpec.Builder.addLastIndexOf() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.lastIndexOf]",
            receiver = baseType.getGeneratedTypeName(),
            name = "lastIndexOf",
            parameters = { "element"(type = baseType.type) },
            returns = Int::class.asTypeName(),
        ) {
            addGenericTypes(baseType.type)

            controlFlow("for (index in lastIndex downTo 0)") {
                statement("if (get(index) == element) return index")
            }
            statement("return -1")
        }
    }
}

private fun FileSpec.Builder.addGetOrElse() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.getOrElse]",
            modifiers = listOf(KModifier.INLINE),
            receiver = baseType.getGeneratedTypeName(),
            name = "getOrElse",
            parameters = {
                "index"<Int>()
                "defaultValue"(type = lambda(parameters = { "index"<Int>() }, returnType = baseType.type))
            },
            returns = baseType.type,
            forceFunctionBody = true,
        ) {
            addGenericTypes(baseType.type)

            statement("return values.getOrElse(index, defaultValue)")
        }
    }
}

private fun FileSpec.Builder.addMin() {
    val genericType = TypeVariableName("T", Comparable::class.asTypeName().parameterizedBy(TypeVariableName("T")))
    for (baseType in BaseType.entries) {
        function(
            kdoc = """
                @return the smallest element
                @throws NoSuchElementException if this ${baseType.generatedClassName} is empty
            """.trimIndent(),
            receiver = when (baseType) {
                GENERIC -> baseType.getGeneratedClass().parameterizedBy(genericType)
                else -> baseType.getGeneratedTypeName()
            },
            name = "min",
            returns = if (baseType == GENERIC) genericType else baseType.type,
        ) {
            if (baseType == GENERIC) {
                addGenericTypes(genericType)
            }
            if (baseType == BOOLEAN) {
                // only call minOf once and use equality checks instead because minOf(boolean, boolean) auto-boxes the
                // primitive booleans.  This optimization also stops early as it doesn't need to inspect the remainder
                // after finding the min boolean value
                statement("val minBoolean = minOf(true, false)")
                statement("if (contains(minBoolean)) return minBoolean")
                emptyLine()
                statement("return first()")
            } else {
                statement("var minValue = first()")
                controlFlow("for (i in 1..lastIndex)") {
                    statement("minValue = minOf(minValue, values[i])")
                }
                statement("return minValue")
            }
        }
    }
}

private fun FileSpec.Builder.addMinOrNull() {
    val genericType = TypeVariableName("T", Comparable::class.asTypeName().parameterizedBy(TypeVariableName("T")))
    for (baseType in BaseType.entries) {
        function(
            kdoc = "@return the smallest element or null if [this] is empty",
            receiver = when (baseType) {
                GENERIC -> baseType.getGeneratedClass().parameterizedBy(genericType)
                else -> baseType.getGeneratedTypeName()
            },
            name = "minOrNull",
            returns = when (baseType) {
                GENERIC -> genericType.copy(nullable = true)
                else -> baseType.type.copy(nullable = true)
            },
        ) {
            if (baseType == GENERIC) {
                addGenericTypes(genericType)
            }
            statement("return if (isEmpty()) null else min()")
        }
    }
}

private fun FileSpec.Builder.addMax() {
    val genericType = TypeVariableName("T", Comparable::class.asTypeName().parameterizedBy(TypeVariableName("T")))
    for (baseType in BaseType.entries) {
        function(
            kdoc = """
                @return the largest element
                @throws NoSuchElementException if this ${baseType.generatedClassName} is empty
            """.trimIndent(),
            receiver = when (baseType) {
                GENERIC -> baseType.getGeneratedClass().parameterizedBy(genericType)
                else -> baseType.getGeneratedTypeName()
            },
            name = "max",
            returns = if (baseType == GENERIC) genericType else baseType.type,
        ) {
            if (baseType == GENERIC) {
                addGenericTypes(genericType)
            }
            if (baseType == BOOLEAN) {
                // only call maxOf once and use equality checks instead because maxOf(boolean, boolean) auto-boxes the
                // primitive booleans.  This optimization also stops early as it doesn't need to inspect the remainder
                // after finding the max boolean value
                statement("val maxBoolean = maxOf(true, false)")
                statement("if (contains(maxBoolean)) return maxBoolean")
                emptyLine()
                statement("return first()")
            } else {
                statement("var maxValue = first()")
                controlFlow("for (i in 1..lastIndex)") {
                    statement("maxValue = maxOf(maxValue, values[i])")
                }
                statement("return maxValue")
            }
        }
    }
}

private fun FileSpec.Builder.addMaxOrNull() {
    val genericType = TypeVariableName("T", Comparable::class.asTypeName().parameterizedBy(TypeVariableName("T")))
    for (baseType in BaseType.entries) {
        function(
            kdoc = "@return the largest element or null if [this] is empty",
            receiver = when (baseType) {
                GENERIC -> baseType.getGeneratedClass().parameterizedBy(genericType)
                else -> baseType.getGeneratedTypeName()
            },
            name = "maxOrNull",
            returns = when (baseType) {
                GENERIC -> genericType.copy(nullable = true)
                else -> baseType.type.copy(nullable = true)
            },
        ) {
            if (baseType == GENERIC) {
                addGenericTypes(genericType)
            }
            statement("return if (isEmpty()) null else max()")
        }
    }
}

private fun FileSpec.Builder.addFilterNotNull() {
    for (baseType in BaseType.entries) {
        val nonNullType = when (baseType) {
            GENERIC -> TypeVariableName("T", Any::class.asTypeName())
            else -> baseType.type
        }
        val returnType = when (baseType) {
            GENERIC -> baseType.getGeneratedClass().parameterizedBy(nonNullType)
            else -> baseType.getGeneratedTypeName()
        }

        function(
            kdoc = "Returns an immutable array containing only the non-null elements",
            receiver = GENERIC.getGeneratedClass().parameterizedBy(nonNullType.copy(nullable = true)),
            name = "filterNotNull",
            returns = returnType,
            forceFunctionBody = true,
        ) {
            addGenericTypes(nonNullType)
            jvmName("filterNotNull", baseType.name)
            createImmutableArrayBuilder(name = "result", forType = baseType, genericTypeOverride = nonNullType)
            controlFlow("forEach { value ->") {
                controlFlow("if (value != null)") {
                    statement("result.add(value)")
                }
            }
            if (baseType == GENERIC) {
                annotation<Suppress>("UNCHECKED_CAST")
                val castType = baseType.getGeneratedClass().parameterizedBy(nonNullType)
                statement("if (result.size == size) return this as %T", castType)
                emptyLine()
            }

            statement("return result.build()")
        }
    }
}

private fun FileSpec.Builder.addSorted() {
    val genericVariableName = "T"
    val genericType = TypeVariableName(genericVariableName)

    val generateKdoc: (BaseType) -> String = { baseType ->
        val immutableArrayClass = baseType.generatedClassName

        if (baseType == GENERIC) {
            """
                Leaves [this] immutable array as is and returns an [$immutableArrayClass] with all elements sorted
                according to their natural sort order.

                The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
            """.trimIndent()
        } else {
            """
                Leaves [this] immutable array as is and returns an [$immutableArrayClass] with all elements sorted
                according to their natural sort order.
            """.trimIndent()
        }
    }

    for (baseType in BaseType.entries) {
        val receiver = when (baseType) {
            GENERIC -> baseType.getGeneratedClass().parameterizedBy(genericType)
            else -> baseType.getGeneratedClass()
        }
        function(
            kdoc = generateKdoc(baseType),
            receiver = receiver,
            name = "sorted",
            returns = receiver,
        ) {
            statement("if (size <= 1) return this")
            emptyLine()

            // regular primitive boolean arrays don't have sorting abilities so we need a custom solution in order for
            // Immutable Arrays to be a replacement for lists since we can sort List<Boolean>
            if (baseType == BOOLEAN) {
                comment(
                    "match sorting order of List<Boolean>.sorted() as that relies on the compareTo method of the " +
                        "auto-boxed Boolean wrapper",
                )
                statement("val minValue: Boolean = minOf(true, false)")
                statement("val numMinValues = count { it == minValue }")
                emptyLine()
                statement("val backingArray = ${baseType.backingArrayConstructor}(size)")
                controlFlow("when (backingArray[0] == minValue)") {
                    statement(
                        "true -> backingArray.fill(element = !minValue, fromIndex = numMinValues, toIndex = size)",
                    )
                    statement("else -> backingArray.fill(element = minValue, fromIndex = 0, toIndex = numMinValues)")
                }
                statement("return ${baseType.generatedClassName}(backingArray)")
                return@function
            }

            if (baseType == GENERIC) {
                addTypeVariable(
                    TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType)),
                )
                annotation<Suppress>("UNCHECKED_CAST")
                statement("val backingArray = ${baseType.backingArrayConstructor}(size) { get(it) }")
            } else {
                statement("val backingArray = values.copyOf()")
            }
            statement("backingArray.sort()")
            if (baseType == GENERIC) {
                statement("return ${baseType.generatedClassName}(backingArray) as %T", receiver)
            } else {
                statement("return ${baseType.generatedClassName}(backingArray)")
            }
        }
    }
}

private fun FileSpec.Builder.addSortedDescending() {
    val genericVariableName = "T"
    val genericType = TypeVariableName(genericVariableName)

    val generateKdoc: (BaseType) -> String = { baseType ->
        val immutableArrayClass = baseType.generatedClassName

        if (baseType == GENERIC) {
            """
                Leaves [this] immutable array as is and returns an [$immutableArrayClass] with all elements sorted
                according to their reverse natural sort order.

                The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
            """.trimIndent()
        } else {
            """
                Leaves [this] immutable array as is and returns an [$immutableArrayClass] with all elements sorted
                according to their reverse natural sort order.
            """.trimIndent()
        }
    }

    for (baseType in BaseType.entries) {
        val receiver = when (baseType) {
            GENERIC -> baseType.getGeneratedClass().parameterizedBy(genericType)
            else -> baseType.getGeneratedClass()
        }
        function(
            kdoc = generateKdoc(baseType),
            receiver = receiver,
            name = "sortedDescending",
            returns = receiver,
            forceFunctionBody = true,
        ) {
            statement("if (size <= 1) return this")
            emptyLine()

            // regular primitive boolean arrays don't have sorting abilities so we need a custom solution in order for
            // Immutable Arrays to be a replacement for lists since we can sort List<Boolean>
            if (baseType == BOOLEAN) {
                comment(
                    "match sorting order of List<Boolean>.sortedDescending() as that relies on the compareTo method " +
                        "of the auto-boxed Boolean wrapper",
                )
                statement("val maxValue: Boolean = maxOf(true, false)")
                statement("val numMaxValues = count { it == maxValue }")
                emptyLine()
                statement("val backingArray = ${baseType.backingArrayConstructor}(size)")
                controlFlow("when (backingArray[0] == maxValue)") {
                    statement(
                        "true -> backingArray.fill(element = !maxValue, fromIndex = numMaxValues, toIndex = size)",
                    )
                    statement(
                        "else -> backingArray.fill(element = maxValue, fromIndex = 0, toIndex = numMaxValues)",
                    )
                }
                statement("return ${baseType.generatedClassName}(backingArray)")
            } else if (baseType == GENERIC) {
                addTypeVariable(
                    TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType)),
                )
                statement("return sortedWith(reverseOrder())")
            } else {
                statement("val backingArray = ${baseType.backingArrayConstructor}(size) { get(it) }")
                statement("backingArray.sort()")
                statement("backingArray.reverse()")
                statement("return ${baseType.generatedClassName}(backingArray)")
            }
        }
    }
}

private fun FileSpec.Builder.addPlusImmutableArray() {
    val generateKdoc: (BaseType) -> String = { baseType ->
        val immutableArrayClass = baseType.generatedClassName

        """
            Leaves [this] immutable array as is and returns an [$immutableArrayClass] with the elements of [this]
            followed by the elements of [other]
        """.trimIndent()
    }

    for (baseType in BaseType.entries) {
        function(
            kdoc = generateKdoc(baseType),
            modifiers = listOf(KModifier.OPERATOR),
            receiver = baseType.getGeneratedTypeName(),
            name = "plus",
            parameters = {
                "other"(type = baseType.getGeneratedTypeName())
            },
            returns = baseType.getGeneratedTypeName(),
        ) {
            addGenericTypes(baseType.type)

            controlFlow("return when") {
                statement("isEmpty() -> other")
                statement("other.isEmpty() -> this")
                if (baseType == GENERIC) {
                    annotation<Suppress>("UNCHECKED_CAST")
                    statement(
                        "else -> ${baseType.generatedClassName}((this.values as Array<%T>) + other.values)",
                        baseType.type,
                    )
                } else {
                    statement("else -> ${baseType.generatedClassName}(this.values + other.values)")
                }
            }
        }
    }
}

private fun FileSpec.Builder.addPlusValue() {
    val generateKdoc: (BaseType) -> String = { baseType ->
        val immutableArrayClass = baseType.generatedClassName
        """
            Leaves [this] immutable array as is and returns an [$immutableArrayClass] with the elements of [this]
            followed by the specified [element].

            Important:
            When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
            builders as that's much more efficient instead of calling this function repeatedly.
        """.trimIndent()
    }

    for (baseType in BaseType.entries) {
        function(
            kdoc = generateKdoc(baseType),
            modifiers = listOf(KModifier.OPERATOR),
            receiver = baseType.getGeneratedTypeName(),
            name = "plus",
            parameters = { "element"(type = baseType.type) },
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            addGenericTypes(baseType.type)

            if (baseType == GENERIC) {
                annotation<Suppress>("UNCHECKED_CAST")
                statement("return ${baseType.generatedClassName}((values as Array<%T>) + element)", baseType.type)
            } else {
                statement("return ${baseType.generatedClassName}(values + element)")
            }
        }
    }
}

private fun FileSpec.Builder.addToPrimitiveImmutableArray() {
    val generateKdoc: (BaseType) -> String = { baseType ->
        val immutableArrayClass = baseType.generatedClassName

        """
            Returns an [$immutableArrayClass] containing the unboxed values of this array.

            [$immutableArrayClass] uses less memory and is faster to access as it stores the primitive values directly
            without needing to store them in wrapper objects.
        """.trimIndent()
    }

    for (baseType in BaseType.entries) {
        if (baseType == GENERIC) continue

        function(
            kdoc = generateKdoc(baseType),
            receiver = GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            name = "to${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            statement("return ${baseType.generatedClassName}(size) { this[it] }")
        }
    }
}

private fun FileSpec.Builder.addToTypedImmutableArray() {
    val generateKdoc: (BaseType) -> String = { baseType ->
        val immutableArrayClass = GENERIC.generatedClassName

        """
            Returns a typed [$immutableArrayClass] containing the values of this array.

            Note that [$immutableArrayClass] uses more memory and is slower to access as each primitive value will be
            auto-boxed in a wrapper object.
        """.trimIndent()
    }

    for (baseType in BaseType.entries) {
        if (baseType == GENERIC) continue

        function(
            kdoc = generateKdoc(baseType),
            receiver = baseType.getGeneratedClass(),
            name = "toTyped${GENERIC.generatedClassName}",
            returns = GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            forceFunctionBody = true,
        ) {
            statement("return ${GENERIC.generatedClassName}(size) { this[it] }")
        }
    }
}

private fun FileSpec.Builder.addToMutableArray() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "Returns a regular (mutable) array with a copy of the elements.",
            modifiers = if (baseType == GENERIC) listOf(KModifier.INLINE) else emptyList(),
            receiver = baseType.getGeneratedTypeName(),
            name = "toMutableArray",
            returns = baseType.backingArrayType,
        ) {
            if (baseType == GENERIC) {
                // We need to use reified generics so that the array is of the appropriate type since generic arrays
                // store the generic type at runtime.  This is especially important when wanting to use the spread
                // operator to call a vararg function otherwise we'll get a cast exception at runtime
                addGenericTypes((baseType.type as TypeVariableName).copy(reified = true))

                // Can't use copyOf as the resulting array would store `Object` as the generic type
                statement("return Array(size) { values[it] }")
            } else {
                statement("return values.copyOf()")
            }
        }
    }
}

private fun FileSpec.Builder.addToTypedMutableArray() {
    for (baseType in BaseType.entries) {
        val returnType = when (baseType) {
            GENERIC -> Array::class.asTypeName().parameterizedBy(WildcardTypeName.producerOf(baseType.type))
            else -> Array::class.asTypeName().parameterizedBy(baseType.type)
        }
        function(
            kdoc = "Returns a regular (mutable) typed array with a copy of the elements.",
            modifiers = if (baseType == GENERIC) listOf(KModifier.INLINE) else emptyList(),
            receiver = baseType.getGeneratedTypeName(),
            name = "toTypedMutableArray",
            returns = returnType,
        ) {
            if (baseType == GENERIC) {
                // We need to use reified generics so that the array is of the appropriate type since generic arrays
                // store the generic type at runtime.  This is especially important when wanting to use the spread
                // operator to call a vararg function otherwise we'll get a cast exception at runtime
                addGenericTypes((baseType.type as TypeVariableName).copy(reified = true))
            }
            statement("return Array(size) { values[it] }")
        }
    }
}

private fun FileSpec.Builder.addRequireNoNulls() {
    val typeVariable = TypeVariableName("T", Any::class)

    function(
        kdoc = """
            Ensures that none of the elements are null otherwise an [IllegalArgumentException] is thrown.

            Returns the same [ImmutableArray] instance cast with a non-null generic type.
        """.trimIndent(),
        receiver = GENERIC.getGeneratedClass().parameterizedBy(typeVariable.copy(nullable = true)),
        name = "requireNoNulls",
        returns = GENERIC.getGeneratedClass().parameterizedBy(typeVariable),
    ) {
        addGenericTypes(GENERIC.type)

        statement("require (null !in this) { \"null element found in \$this\" }")
        emptyLine()
        annotation<Suppress>("UNCHECKED_CAST")
        statement("return this as ${GENERIC.generatedClassName}<%T>", GENERIC.type)
    }
}

private fun FileSpec.Builder.addFlatten() {
    function(
        kdoc = "Returns a single immutable array with all the elements from all nested collections.",
        receiver = GENERIC.getGeneratedClass()
            .parameterizedBy(Iterable::class.asTypeName().parameterizedBy(GENERIC.type)),
        name = "flatten",
        returns = GENERIC.getGeneratedTypeName(),
        forceFunctionBody = true,
    ) {
        jvmName("flatten", "Iterable", GENERIC.name)
        addGenericTypes(GENERIC.type)

        controlFlow("return build${GENERIC.generatedClassName}()") {
            controlFlow("for (nestedCollection in this@flatten)") {
                statement("this@build${GENERIC.generatedClassName}.addAll(nestedCollection)")
            }
        }
    }

    for (baseType in BaseType.entries) {
        function(
            kdoc = "Returns a single immutable array with all the elements from all nested arrays.",
            receiver = GENERIC.getGeneratedClass().parameterizedBy(baseType.getGeneratedTypeName()),
            name = "flatten",
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            jvmName("flatten", baseType.generatedClassName)
            addGenericTypes(baseType.type)

            controlFlow("return build${baseType.generatedClassName}()") {
                controlFlow("for (nestedArray in this@flatten)") {
                    statement("this@build${baseType.generatedClassName}.addAll(nestedArray)")
                }
            }
        }
    }
}

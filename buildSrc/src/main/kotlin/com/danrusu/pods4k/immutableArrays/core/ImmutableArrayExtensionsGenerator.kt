package com.danrusu.pods4k.immutableArrays.core

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.BaseType.BOOLEAN
import com.danrusu.pods4k.immutableArrays.BaseType.GENERIC
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.immutableArrays.createImmutableArrayBuilder
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.comment
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.emptyLine
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.jvmName
import com.danrusu.pods4k.utils.statement
import com.danrusu.pods4k.utils.suppress
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
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
            addFilterNotNull()
            addSorted()
            addSortedDescending()
            addPlusImmutableArray()
            addPlusValue()
            addToPrimitiveImmutableArray()
            addToTypedImmutableArray()
            addRequireNoNulls()
            addFlatten()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addAsList() {
    val standardKdoc = "Returns an immutable list that wraps the same backing array without copying the elements."

    for (baseType in BaseType.entries) {
        function(
            kdoc = when (baseType) {
                GENERIC -> standardKdoc
                else -> {
                    """
                    $standardKdoc

                    Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is because [${baseType.generatedClassName}] stores primitive values whereas [List] is defined as a generic type.  If the number of accesses is expected to be multiple times larger than the size of this array, then you might want to consider using [toList] instead in order to copy all the elements into a standalone list and only auto-box each element once.
                    """.trimIndent()
                }
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
                suppress("UNCHECKED_CAST")
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

    for (baseType in BaseType.entries) {
        // both Java and Kotlin standard libraries don't provide sorting abilities for primitive boolean arrays
        if (baseType == BOOLEAN) continue

        val kdoc = when (baseType) {
            GENERIC -> """
                Leaves [this] immutable array as is and returns an [${baseType.generatedClassName}] with all elements sorted according to their natural sort order.

                The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
            """.trimIndent()

            else -> "Leaves [this] immutable array as is and returns an [${baseType.generatedClassName}] with all elements sorted according to their natural sort order."
        }
        val receiver = when (baseType) {
            GENERIC -> baseType.getGeneratedClass().parameterizedBy(genericType)
            else -> baseType.getGeneratedClass()
        }
        function(
            kdoc = kdoc,
            receiver = receiver,
            name = "sorted",
            returns = receiver,
        ) {
            comment(
                "Immutable arrays can't be mutated, so it's safe to return the same array when the ordering " +
                    "won't change",
            )
            statement("if (size <= 1) return this")
            emptyLine()
            if (baseType == GENERIC) {
                addTypeVariable(
                    TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType)),
                )
                suppress("UNCHECKED_CAST")
                statement("val backingArray = ${baseType.backingArrayConstructor}(size) { get(it) }")
            } else {
                statement("val backingArray = values.copyOf()")
            }
            statement("%T.sort(backingArray)", java.util.Arrays::class)
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

    for (baseType in BaseType.entries) {
        // both Kotlin & Java standard libraries don't provide sorting abilities for primitive boolean arrays
        if (baseType == BOOLEAN) continue

        val kdoc = when (baseType) {
            GENERIC -> """
                Leaves [this] immutable array as is and returns an [${baseType.generatedClassName}] with all elements sorted according to their reverse natural sort order.

                The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
            """.trimIndent()

            else ->
                "Leaves [this] immutable array as is and returns an [${baseType.generatedClassName}] with all " +
                    "elements sorted according to their reverse natural sort order."
        }
        val receiver = when (baseType) {
            GENERIC -> baseType.getGeneratedClass().parameterizedBy(genericType)
            else -> baseType.getGeneratedClass()
        }
        function(
            kdoc = kdoc,
            receiver = receiver,
            name = "sortedDescending",
            returns = receiver,
            forceFunctionBody = true,
        ) {
            if (baseType == GENERIC) {
                addTypeVariable(
                    TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType)),
                )
                statement("return sortedWith(reverseOrder())")
            } else {
                comment("Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change")
                statement("if (size <= 1) return this")
                emptyLine()
                statement("val backingArray = ${baseType.backingArrayConstructor}(size) { get(it) }")
                statement("%T.sort(backingArray)", java.util.Arrays::class)
                statement("backingArray.reverse()")
                statement("return ${baseType.generatedClassName}(backingArray)")
            }
        }
    }
}

private fun FileSpec.Builder.addPlusImmutableArray() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "Leaves [this] immutable array as is and returns an [${baseType.generatedClassName}] with the " +
                "elements of [this] followed by the elements of [other]",
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
                    suppress("UNCHECKED_CAST")
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
    for (baseType in BaseType.entries) {
        function(
            kdoc = """
                Leaves [this] immutable array as is and returns an [${baseType.generatedClassName}] with the elements of [this] followed by the specified [element].

                Important:
                When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array builders as that's much more efficient instead of calling this function repeatedly.
            """.trimIndent(),
            modifiers = listOf(KModifier.OPERATOR),
            receiver = baseType.getGeneratedTypeName(),
            name = "plus",
            parameters = { "element"(type = baseType.type) },
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            addGenericTypes(baseType.type)

            if (baseType == GENERIC) {
                suppress("UNCHECKED_CAST")
                statement("return ${baseType.generatedClassName}((values as Array<%T>) + element)", baseType.type)
            } else {
                statement("return ${baseType.generatedClassName}(values + element)")
            }
        }
    }
}

private fun FileSpec.Builder.addToPrimitiveImmutableArray() {
    for (baseType in BaseType.entries) {
        if (baseType == GENERIC) continue

        function(
            kdoc = """
                Returns an [${baseType.generatedClassName}] containing the unboxed values of this array.

                [${baseType.generatedClassName}] uses less memory and is faster to access as it stores the primitive values directly without needing to store them in wrapper objects.
            """.trimIndent(),
            receiver = GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            name = "to${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            statement("return ${baseType.generatedClassName}(size)·{·this[it]·}")
        }
    }
}

private fun FileSpec.Builder.addToTypedImmutableArray() {
    for (baseType in BaseType.entries) {
        if (baseType == GENERIC) continue

        function(
            kdoc = """
                Returns a typed [${GENERIC.generatedClassName}] containing the values of this array.

                Note that [${GENERIC.generatedClassName}] uses more memory and is slower to access as each primitive value will be auto-boxed in a wrapper object.
            """.trimIndent(),
            receiver = baseType.getGeneratedClass(),
            name = "toTyped${GENERIC.generatedClassName}",
            returns = GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            forceFunctionBody = true,
        ) {
            statement("return ${GENERIC.generatedClassName}(size)·{·this[it]·}")
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

        statement("if (contains(null)) throw %T(\"null element found in \$this\")", IllegalArgumentException::class)
        emptyLine()
        suppress("UNCHECKED_CAST")
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

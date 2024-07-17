package com.danrusu.pods4k.immutableArrays.immutableArraysModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.BaseType.BOOLEAN
import com.danrusu.pods4k.immutableArrays.BaseType.GENERIC
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.comment
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.emptyLine
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.danrusu.pods4k.utils.suppress
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object ImmutableArraysFileGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "ImmutableArrays") {
            addEmptyFunctions()
            addImmutableArrayOf()
            addBuilderFunctions()
            addGenericImmutableArrayToPrimitiveImmutableArray()
            addPrimitiveImmutableArrayToTypedImmutableArray()
            addImmutableArrayGetOrElse()
            addImmutableArraySorted()
            addImmutableArraySortedDescending()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addImmutableArrayOf() {
    // Calling immutableArrayOf() without arguments will delegate to the empty generic factory function
    function(
        kdoc = "Returns an empty [${GENERIC.generatedClassName}].",
        name = "immutableArrayOf",
        returns = GENERIC.getGeneratedTypeName(),
    ) {
        addTypeVariable(GENERIC.type as TypeVariableName)
        statement("return empty${GENERIC.generatedClassName}()")
    }

    for (baseType in BaseType.values()) {
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] containing the specified [values].",
            name = "immutableArrayOf",
            parameters = { "values"(type = baseType.type, isVararg = true) },
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
                suppress("UNCHECKED_CAST")
                statement("val backingArray = arrayOfNulls<Any?>(values.size) as Array<%T>", baseType.type)
            } else {
                statement("val backingArray = ${baseType.backingArrayConstructor}(values.size)")
            }
            statement("System.arraycopy(values, 0, backingArray, 0, values.size)")
            statement("return ${baseType.generatedClassName}(backingArray)")
        }
    }
}

private fun FileSpec.Builder.addBuilderFunctions() {
    "ars".apply { }
    for (baseType in BaseType.values()) {
        val receiver = when (baseType) {
            GENERIC -> baseType.getGeneratedClass().nestedClass("Builder").parameterizedBy(baseType.type)
            else -> baseType.getGeneratedClass().nestedClass("Builder")
        }
        function(
            kdoc = "Builds an [${baseType.generatedClassName}] for when the size isn't known in advance.",
            name = "build${baseType.generatedClassName}",
            parameters = {
                "body"(
                    type = lambda<Unit>(receiver = receiver)
                )
            },
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
                statement("return ${baseType.generatedClassName}.Builder<%T>().apply(body).build()", baseType.type)
            } else {
                statement("return ${baseType.generatedClassName}.Builder().apply(body).build()")
            }
        }
    }
}

private fun FileSpec.Builder.addEmptyFunctions() {
    for (baseType in BaseType.values()) {
        function(
            kdoc = "Returns an empty [${baseType.generatedClassName}].",
            name = "empty${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return ${baseType.generatedClassName}.EMPTY")
        }
    }
}

private fun FileSpec.Builder.addGenericImmutableArrayToPrimitiveImmutableArray() {
    for (baseType in BaseType.values()) {
        if (baseType == GENERIC) continue

        function(
            kdoc = """
                Returns an [${baseType.generatedClassName}] containing the values of this array.
                
                [${baseType.generatedClassName}] uses less memory and is faster to access as it stores the primitive values directly without needing to store them in wrapper objects.
            """.trimIndent(),
            receiver = GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            name = "to${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
            code = "return ${baseType.generatedClassName}(size)·{·this[it]·}"
        )
    }
}

private fun FileSpec.Builder.addPrimitiveImmutableArrayToTypedImmutableArray() {
    for (baseType in BaseType.values()) {
        if (baseType == GENERIC) continue

        function(
            kdoc = """
                Returns a typed [${baseType.generatedClassName}] containing the values of this array.
                
                Note that [${GENERIC.generatedClassName}] uses more memory and is slower to access as each primitive value will be auto-boxed in a wrapper object.
            """.trimIndent(),
            receiver = baseType.getGeneratedClass(),
            name = "toTyped${GENERIC.generatedClassName}",
            returns = GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            code = "return ${GENERIC.generatedClassName}(size)·{·this[it]·}"
        )
    }
}

private fun FileSpec.Builder.addImmutableArrayGetOrElse() {
    for (baseType in BaseType.values()) {
        val receiver = when (baseType) {
            GENERIC -> baseType.getGeneratedClass().parameterizedBy(baseType.type)
            else -> baseType.getGeneratedClass()
        }
        function(
            kdoc = "See [Array.getOrElse]",
            modifiers = listOf(KModifier.INLINE),
            receiver = receiver,
            name = "getOrElse",
            parameters = {
                "index"<Int>()
                "defaultValue"(type = lambda(parameters = { "index"<Int>() }, returnType = baseType.type))
            },
            returns = baseType.type,
        ) {
            if (baseType == GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return values.getOrElse(index, defaultValue)")
        }
    }
}

private fun FileSpec.Builder.addImmutableArraySorted() {
    val genericVariableName = "T"
    val genericType = TypeVariableName(genericVariableName)

    for (baseType in BaseType.values()) {
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
            comment("Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change")
            statement("if (size <= 1) return this")
            emptyLine()
            if (baseType == GENERIC) {
                addTypeVariable(
                    TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType))
                )
                suppress("UNCHECKED_CAST")
                statement("val backingArray = ${baseType.backingArrayConstructor}(size) { get(it) }")
            } else {
                statement("val backingArray = ${baseType.backingArrayConstructor}(size)")
                statement("System.arraycopy(values, 0, backingArray, 0, size)")
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

private fun FileSpec.Builder.addImmutableArraySortedDescending() {
    val genericVariableName = "T"
    val genericType = TypeVariableName(genericVariableName)

    for (baseType in BaseType.values()) {
        // both Kotlin & Java standard libraries don't provide sorting abilities for primitive boolean arrays
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
            name = "sortedDescending",
            returns = receiver,
        ) {
            if (baseType == GENERIC) {
                addTypeVariable(
                    TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType))
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

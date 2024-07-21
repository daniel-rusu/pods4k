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

internal object ImmutableArrayExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "ImmutableArrays") {
            addToPrimitiveImmutableArray()
            addToTypedImmutableArray()
            addGetOrElse()
            addSorted()
            addSortedDescending()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addToPrimitiveImmutableArray() {
    for (baseType in BaseType.values()) {
        if (baseType == GENERIC) continue

        function(
            kdoc = """
                Returns an [${baseType.generatedClassName}] containing the unboxed values of this array.
                
                [${baseType.generatedClassName}] uses less memory and is faster to access as it stores the primitive values directly without needing to store them in wrapper objects.
            """.trimIndent(),
            receiver = GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            name = "to${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
            code = "return ${baseType.generatedClassName}(size)·{·this[it]·}"
        )
    }
}

private fun FileSpec.Builder.addToTypedImmutableArray() {
    for (baseType in BaseType.values()) {
        if (baseType == GENERIC) continue

        function(
            kdoc = """
                Returns a typed [${GENERIC.generatedClassName}] containing the values of this array.
                
                Note that [${GENERIC.generatedClassName}] uses more memory and is slower to access as each primitive value will be auto-boxed in a wrapper object.
            """.trimIndent(),
            receiver = baseType.getGeneratedClass(),
            name = "toTyped${GENERIC.generatedClassName}",
            returns = GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            code = "return ${GENERIC.generatedClassName}(size)·{·this[it]·}"
        )
    }
}

private fun FileSpec.Builder.addGetOrElse() {
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

private fun FileSpec.Builder.addSorted() {
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

private fun FileSpec.Builder.addSortedDescending() {
    val genericVariableName = "T"
    val genericType = TypeVariableName(genericVariableName)

    for (baseType in BaseType.values()) {
        // both Kotlin & Java standard libraries don't provide sorting abilities for primitive boolean arrays
        if (baseType == BOOLEAN) continue

        val kdoc = when (baseType) {
            GENERIC -> """
                Leaves [this] immutable array as is and returns an [${baseType.generatedClassName}] with all elements sorted according to their reverse natural sort order.
                
                The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
            """.trimIndent()

            else -> "Leaves [this] immutable array as is and returns an [${baseType.generatedClassName}] with all elements sorted according to their reverse natural sort order."
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

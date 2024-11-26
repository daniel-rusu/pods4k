package com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollections

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object TransformationsToMapFileGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "TransformationsToMap") {
            addToMap()
            addAssociate()
            addAssociateBy()
            addAssociateWith()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addToMap() {
    val key = TypeVariableName("K")
    val value = TypeVariableName("V")
    val pair = Pair::class.asTypeName().parameterizedBy(key, value)
    function(
        kdoc = "See [Array.toMap]",
        receiver = BaseType.GENERIC.getGeneratedClass().parameterizedBy(pair),
        name = "toMap",
        returns = ClassName("kotlin.collections", "Map").parameterizedBy(key, value),
    ) {
        addTypeVariable(key)
        addTypeVariable(value)
        // Important: This needs to meet the same contract as what's promised by the standard library to maintain
        // iteration order since this library is documented as a replacement for read-only lists.
        statement("return asList().toMap()")
    }
}

private fun FileSpec.Builder.addAssociate() {
    val key = TypeVariableName("K")
    val value = TypeVariableName("V")
    val pair = Pair::class.asTypeName().parameterizedBy(key, value)
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.associate]",
            modifiers = listOf(KModifier.INLINE),
            receiver = baseType.getGeneratedTypeName(),
            name = "associate",
            parameters = {
                "transform"(
                    type = lambda(parameters = { "element"(type = baseType.type) }, returnType = pair),
                )
            },
            returns = ClassName("kotlin.collections", "Map").parameterizedBy(key, value),
            forceFunctionBody = true,
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addTypeVariable(key)
            addTypeVariable(value)
            // Important: This needs to meet the same contract as what's promised by the standard library to maintain
            // iteration order since this library is documented as a replacement for read-only lists.
            statement("return asList().associate(transform)")
        }
    }
}

private fun FileSpec.Builder.addAssociateBy() {
    val key = TypeVariableName("K")
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.associateBy]",
            modifiers = listOf(KModifier.INLINE),
            receiver = baseType.getGeneratedTypeName(),
            name = "associateBy",
            parameters = {
                "keySelector"(
                    type = lambda(parameters = { "element"(type = baseType.type) }, returnType = key),
                )
            },
            returns = ClassName("kotlin.collections", "Map").parameterizedBy(key, baseType.type),
            forceFunctionBody = true,
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addTypeVariable(key)
            // Important: This needs to meet the same contract as what's promised by the standard library to maintain
            // iteration order since this library is documented as a replacement for read-only lists.
            statement("return asList().associateBy(keySelector)")
        }
    }
}

private fun FileSpec.Builder.addAssociateWith() {
    val value = TypeVariableName("V")
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.associateWith]",
            modifiers = listOf(KModifier.INLINE),
            receiver = baseType.getGeneratedTypeName(),
            name = "associateWith",
            parameters = {
                "valueSelector"(
                    type = lambda(parameters = { "element"(type = baseType.type) }, returnType = value),
                )
            },
            returns = ClassName("kotlin.collections", "Map").parameterizedBy(baseType.type, value),
            forceFunctionBody = true,
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addTypeVariable(value)
            // Important: This needs to meet the same contract as what's promised by the standard library to maintain
            // iteration order since this library is documented as a replacement for read-only lists.
            statement("return asList().associateWith(valueSelector)")
        }
    }
}

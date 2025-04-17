package com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollections

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.annotation
import com.danrusu.pods4k.utils.controlFlow
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
            addGroupBy()
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
            addGenericTypes(baseType.type, key, value)

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
            addGenericTypes(baseType.type, key)

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
            addGenericTypes(baseType.type, value)
            // Important: This needs to meet the same contract as what's promised by the standard library to maintain
            // iteration order since this library is documented as a replacement for read-only lists.
            statement("return asList().associateWith(valueSelector)")
        }
    }
}

private fun FileSpec.Builder.addGroupBy() {
    val key = TypeVariableName("K")
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.groupBy]",
            receiver = baseType.getGeneratedTypeName(),
            name = "groupBy",
            parameters = {
                "keySelector"(
                    type = lambda(parameters = { "element"(type = baseType.type) }, returnType = key),
                )
            },
            returns = ClassName("kotlin.collections", "Map").parameterizedBy(key, baseType.getGeneratedTypeName()),
            forceFunctionBody = true,
        ) {
            // Important: This needs to meet the same contract as what's promised by the standard library to maintain
            // iteration order since this library is documented as a replacement for read-only lists.
            addGenericTypes(baseType.type, key)
            /*
            Reusing the same map to store the builders and final immutable arrays in order to reduce memory footprint.

            The regular approach of creating a map of builders and calling mapValues ends up creating
            a second map so all the builders (with their extra unused capacity) stick around until groupBy returns.
            However, replacing the values in-place discards each builder immediately making it eligible for garbage
            collection.  This approach is also more compute efficient as it avoids re-hashing each key to determine its
            location in the map since it just iterates through the links replacing each map entry value in place.
             */
            statement("val result = mutableMapOf<K, Any>()")
            controlFlow("for (element in this)") {
                statement("val key = keySelector(element)")
                if (baseType == BaseType.GENERIC) {
                    statement(
                        "val builder = result.getOrPut(key) { ${baseType.generatedClassName}.Builder<%T>() } " +
                            "as ${baseType.generatedClassName}.Builder<%T>",
                        baseType.type,
                        baseType.type,
                    )
                } else {
                    statement(
                        "val builder = result.getOrPut(key) { ${baseType.generatedClassName}.Builder() } " +
                            "as ${baseType.generatedClassName}.Builder",
                    )
                }
                statement("builder.add(element)")
            }
            if (baseType == BaseType.GENERIC) {
                statement(
                    "result.replaceAll { _, builder -> " +
                        "(builder as ${baseType.generatedClassName}.Builder<%T>).build() }",
                    baseType.type,
                )
            } else {
                statement(
                    "result.replaceAll { _, builder -> (builder as ${baseType.generatedClassName}.Builder).build() }",
                )
            }
            annotation<Suppress>("UNCHECKED_CAST")
            statement("return result as %T<K, %T>", Map::class, baseType.getGeneratedTypeName())
        }
    }
}

package com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollections

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

internal object TransformationsToListFileGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "TransformationsToList") {
            addToList()
            addToMutableList()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addToList() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.toList]",
            receiver = baseType.getGeneratedTypeName(),
            name = "toList",
            returns = ClassName("kotlin.collections", "List").parameterizedBy(baseType.type),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            controlFlow("return when (size)") {
                statement("0 -> emptyList()")
                statement("1 -> listOf(this[0])") // Defer to SingletonList
                if (baseType == BaseType.GENERIC) {
                    // Share the same backing array because ImmutableArray.asList() is guaranteed to be immutable
                    statement("else -> this.asList()")
                } else {
                    // Don't return asList() directly when dealing with primitive types because the generated wrapper that
                    // asList() returns auto-boxes the values each time they are accessed
                    statement("else -> ArrayList(this.asList())")
                }
            }
        }
    }
}

private fun FileSpec.Builder.addToMutableList() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.toMutableList]",
            receiver = baseType.getGeneratedTypeName(),
            name = "toMutableList",
            returns = ClassName("kotlin.collections", "MutableList").parameterizedBy(baseType.type),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return ArrayList(this.asList())")
        }
    }
}

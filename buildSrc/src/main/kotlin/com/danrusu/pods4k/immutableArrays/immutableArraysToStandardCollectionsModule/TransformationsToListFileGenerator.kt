package com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollectionsModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.Config
import com.danrusu.pods4k.utils.addFunction
import com.danrusu.pods4k.utils.createFile
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

internal object TransformationsToListFileGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(Config.packageName, "TransformationsToList") {
            addToList()
            addToMutableList()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addToList() {
    for (baseType in BaseType.values()) {
        val receiver = when (baseType) {
            BaseType.GENERIC -> baseType.getGeneratedClass().parameterizedBy(baseType.type)
            else -> baseType.getGeneratedClass()
        }
        addFunction(
            kdoc = "See [Array.toList]",
            receiver = receiver,
            name = "toList",
            returns = ClassName("kotlin.collections", "List").parameterizedBy(baseType.type),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addCode(
                """
                    val result = ArrayList<${baseType.type}>(size)
                    forEach { result.add(it) }
                    return result
                """.trimIndent()
            )
        }
    }
}

private fun FileSpec.Builder.addToMutableList() {
    for (baseType in BaseType.values()) {
        val receiver = when (baseType) {
            BaseType.GENERIC -> baseType.getGeneratedClass().parameterizedBy(baseType.type)
            else -> baseType.getGeneratedClass()
        }
        addFunction(
            kdoc = "See [Array.toMutableList]",
            receiver = receiver,
            name = "toMutableList",
            returns = ClassName("kotlin.collections", "MutableList").parameterizedBy(baseType.type),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addCode(
                """
                    val result = ArrayList<${baseType.type}>(size)
                    forEach { result.add(it) }
                    return result
                """.trimIndent()
            )
        }
    }
}

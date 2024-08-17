package com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollections

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

internal object TransformationsToSetFileGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "TransformationsToSet") {
            addToSet()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addToSet() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "See [Array.toSet]",
            receiver = baseType.getGeneratedTypeName(),
            name = "toSet",
            returns = ClassName("kotlin.collections", "Set").parameterizedBy(baseType.type),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            // Important: This needs to meet the same contract as what's promised by the standard library to maintain
            // iteration order since this library is documented as a replacement for read-only lists.
            statement("return asList().toSet()")
        }
    }
}

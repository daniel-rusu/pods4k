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
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object TransformationsToMapFileGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "TransformationsToMap") {
            addToSet()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addToSet() {
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

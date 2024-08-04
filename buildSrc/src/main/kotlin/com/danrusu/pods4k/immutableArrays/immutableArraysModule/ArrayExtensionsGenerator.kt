package com.danrusu.pods4k.immutableArrays.immutableArraysModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object ArrayExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "Arrays") {
            addPrimitiveArrayToImmutableArray()
            addGenericArrayToImmutableArray()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addGenericArrayToImmutableArray() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of this array.",
            receiver = Array::class.asTypeName().parameterizedBy(baseType.type),
            name = "toImmutableArray",
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            controlFlow("return build${baseType.generatedClassName}(size)") {
                statement("addAll(this@toImmutableArray)")
            }
        }
    }
}

private fun FileSpec.Builder.addPrimitiveArrayToImmutableArray() {
    for (baseType in BaseType.entries) {
        if (baseType == BaseType.GENERIC) continue

        function(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of this array.",
            receiver = baseType.backingArrayType,
            name = "toImmutableArray",
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            controlFlow("return build${baseType.generatedClassName}(size)") {
                statement("addAll(this@toImmutableArray)")
            }
        }
    }
}

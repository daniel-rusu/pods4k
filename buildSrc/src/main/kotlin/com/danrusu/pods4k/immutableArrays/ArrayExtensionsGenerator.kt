package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.utils.addFunction
import com.danrusu.pods4k.utils.createFile
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object ArrayExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(Config.packageName, "Arrays") {
            addPrimitiveArrayToImmutableArray()
            addGenericArrayToImmutableArray()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addGenericArrayToImmutableArray() {
    for (baseType in BaseType.values()) {
        addFunction(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of this array.",
            receiver = Array::class.asTypeName().parameterizedBy(baseType.type),
            name = "to${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addStatement("return ${baseType.generatedClassName}(size)·{·this[it]·}")
        }
    }
}

private fun FileSpec.Builder.addPrimitiveArrayToImmutableArray() {
    for (baseType in BaseType.values()) {
        if (baseType == BaseType.GENERIC) continue

        addFunction(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of this array.",
            receiver = baseType.backingArrayType,
            name = "toImmutableArray",
            returns = baseType.getGeneratedTypeName(),
        ) {
            addStatement("return ${baseType.generatedClassName}(size)·{·this[it]·}")
        }
    }
}

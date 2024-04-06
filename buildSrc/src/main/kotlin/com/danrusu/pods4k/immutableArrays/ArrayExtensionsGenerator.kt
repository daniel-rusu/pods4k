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
            } else {
                addComment("Automatically unboxing the boxed values and storing the primitive values directly ")
            }
            addStatement("return ${baseType.generatedClassName}(size) { this[it] }")
        }
    }
}

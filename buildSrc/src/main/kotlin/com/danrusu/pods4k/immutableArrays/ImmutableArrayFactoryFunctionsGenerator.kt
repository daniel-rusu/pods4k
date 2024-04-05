package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.utils.addFunction
import com.danrusu.pods4k.utils.createFile
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

internal object ImmutableArrayFactoryFunctionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = generateFactoryFunctions()
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun generateFactoryFunctions(): FileSpec {
    return createFile(Config.packageName, "ImmutableArrays") {
        addImmutableArrayOf()
    }
}

private fun FileSpec.Builder.addImmutableArrayOf() {
    for (baseType in BaseType.values()) {
        addFunction(
            kdoc = "Returns an [${baseType.generatedClassName}] containing the specified [values].",
            name = "immutableArrayOf",
            parameters = { "values"(type = baseType.type, isVararg = true) },
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addStatement("return ${baseType.generatedClassName}(values.size) { values[it] }")
        }
    }
}

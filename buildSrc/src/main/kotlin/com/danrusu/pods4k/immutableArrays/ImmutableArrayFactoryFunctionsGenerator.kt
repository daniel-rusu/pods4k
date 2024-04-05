package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.utils.addFunction
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.suppress
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
        addEmptyFunctions()
        addImmutableArrayOf()
    }
}

private fun FileSpec.Builder.addImmutableArrayOf() {
    // Calling immutableArrayOf() without arguments will delegate to the empty generic factory function
    addFunction(
        kdoc = "Returns an empty [${BaseType.GENERIC.generatedClassName}].",
        name = "immutableArrayOf",
        returns = BaseType.GENERIC.getGeneratedTypeName(),
    ) {
        addTypeVariable(BaseType.GENERIC.type as TypeVariableName)
        addStatement("return empty${BaseType.GENERIC.generatedClassName}()")
    }

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

private fun FileSpec.Builder.addEmptyFunctions() {
    for (baseType in BaseType.values()) {
        addFunction(
            kdoc = "Returns an empty [${baseType.generatedClassName}].",
            name = "empty${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                suppress("UNCHECKED_CAST")
                addTypeVariable(baseType.type as TypeVariableName)
                addStatement("return ${baseType.generatedClassName}.EMPTY as %T", baseType.getGeneratedTypeName())
            } else {
                addStatement("return ${baseType.generatedClassName}.EMPTY")
            }
        }
    }
}

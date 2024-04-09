package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.utils.addFunction
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.suppress
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

internal object ImmutableArraysFileGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(Config.packageName, "ImmutableArrays") {
            addEmptyFunctions()
            addImmutableArrayOf()
            addGenericImmutableArrayToPrimitiveImmutableArray()
        }
        fileSpec.writeTo(File(destinationPath, ""))
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

private fun FileSpec.Builder.addGenericImmutableArrayToPrimitiveImmutableArray() {
    for (baseType in BaseType.values()) {
        if (baseType == BaseType.GENERIC) continue

        addFunction(
            kdoc = """
                Returns an [${baseType.generatedClassName}] containing the values of this array.
                
                [${baseType.generatedClassName}] uses less memory and is faster to access as it stores the primitive values directly without needing to store them in wrapper objects.
            """.trimIndent(),
            receiver = BaseType.GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            name = "to${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
            code = "return ${baseType.generatedClassName}(size)·{·this[it]·}"
        )
    }
}

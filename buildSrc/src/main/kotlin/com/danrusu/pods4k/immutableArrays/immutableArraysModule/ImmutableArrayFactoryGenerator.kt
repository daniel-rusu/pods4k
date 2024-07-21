package com.danrusu.pods4k.immutableArrays.immutableArraysModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.danrusu.pods4k.utils.suppress
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

internal object ImmutableArrayFactoryGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "ImmutableArrayFactory") {
            addEmptyFunctions()
            addImmutableArrayOf()
            addBuilderFunctions()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addEmptyFunctions() {
    for (baseType in BaseType.values()) {
        function(
            kdoc = "Returns an empty [${baseType.generatedClassName}].",
            name = "empty${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return ${baseType.generatedClassName}.EMPTY")
        }
    }
}

private fun FileSpec.Builder.addImmutableArrayOf() {
    // Calling immutableArrayOf() without arguments will delegate to the empty generic factory function
    function(
        kdoc = "Returns an empty [${BaseType.GENERIC.generatedClassName}].",
        name = "immutableArrayOf",
        returns = BaseType.GENERIC.getGeneratedTypeName(),
    ) {
        addTypeVariable(BaseType.GENERIC.type as TypeVariableName)
        statement("return empty${BaseType.GENERIC.generatedClassName}()")
    }

    for (baseType in BaseType.values()) {
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] containing the specified [values].",
            name = "immutableArrayOf",
            parameters = { "values"(type = baseType.type, isVararg = true) },
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
                suppress("UNCHECKED_CAST")
                statement("val backingArray = arrayOfNulls<Any?>(values.size) as Array<%T>", baseType.type)
            } else {
                statement("val backingArray = ${baseType.backingArrayConstructor}(values.size)")
            }
            statement("System.arraycopy(values, 0, backingArray, 0, values.size)")
            statement("return ${baseType.generatedClassName}(backingArray)")
        }
    }
}

private fun FileSpec.Builder.addBuilderFunctions() {
    for (baseType in BaseType.values()) {
        val receiver = when (baseType) {
            BaseType.GENERIC -> baseType.getGeneratedClass().nestedClass("Builder").parameterizedBy(baseType.type)
            else -> baseType.getGeneratedClass().nestedClass("Builder")
        }
        function(
            kdoc = "Builds an [${baseType.generatedClassName}] for when the size isn't known in advance.",
            name = "build${baseType.generatedClassName}",
            parameters = {
                "body"(
                    type = lambda<Unit>(receiver = receiver)
                )
            },
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
                statement("return ${baseType.generatedClassName}.Builder<%T>().apply(body).build()", baseType.type)
            } else {
                statement("return ${baseType.generatedClassName}.Builder().apply(body).build()")
            }
        }
    }
}

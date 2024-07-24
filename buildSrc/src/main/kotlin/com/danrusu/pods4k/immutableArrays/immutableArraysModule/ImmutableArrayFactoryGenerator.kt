package com.danrusu.pods4k.immutableArrays.immutableArraysModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.comment
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.declareObject
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.property
import com.danrusu.pods4k.utils.statement
import com.danrusu.pods4k.utils.suppress
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object ImmutableArrayFactoryGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "ImmutableArrayFactory") {
            addEmptyFunctions()
            addImmutableArrayOf()
            addBuilderFunctions()
            declareObject(
                modifiers = listOf(KModifier.INTERNAL),
                name = "BuilderUtils",
            ) {
                property<Int>(
                    kdoc = "Some VMs reserve header words in the array so this is the max safe array size",
                    modifiers = listOf(KModifier.CONST),
                    name = "MAX_ARRAY_SIZE",
                    init = "Int.MAX_VALUE - 8",
                )
                addBuilderUtilsEnsureCapacity()
            }
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

private fun TypeSpec.Builder.addBuilderUtilsEnsureCapacity() {
    function(
        kdoc = """
            Returns a larger capacity when [currentCapacity] is less than [minCapacity] otherwise returns [currentCapacity].
            
            The strategy of choosing the new capacity attempts to balance the negative performance impact of repeated resizing operations with the negative memory impact of ending up with too much unused capacity.
        """.trimIndent(),
        name = "computeNewCapacity",
        parameters = {
            "currentCapacity"<Int>()
            "minCapacity"<Int>()
        },
        returns = Int::class.asTypeName(),
    ) {
        controlFlow("when") {
            statement("minCapacity < 0 -> throw %T() // overflow", OutOfMemoryError::class)
            statement("currentCapacity >= minCapacity -> return currentCapacity")
            statement("minCapacity > MAX_ARRAY_SIZE -> throw %T()", OutOfMemoryError::class)
        }
        comment("increase the size by at least 50 percent")
        statement("var newCapacity = currentCapacity + (currentCapacity shr 1) + 1")
        controlFlow("return when") {
            statement("newCapacity < 0 -> MAX_ARRAY_SIZE // handle overflow")
            statement("newCapacity < minCapacity -> minCapacity")
            statement("else -> newCapacity")
        }
    }
}
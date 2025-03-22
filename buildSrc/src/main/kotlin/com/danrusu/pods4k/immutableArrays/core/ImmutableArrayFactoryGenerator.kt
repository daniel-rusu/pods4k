package com.danrusu.pods4k.immutableArrays.core

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.BaseType.GENERIC
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.immutableArrays.createImmutableArrayBuilder
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.comment
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.declareObject
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.jvmName
import com.danrusu.pods4k.utils.property
import com.danrusu.pods4k.utils.statement
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
            addImmutableArrayOfNotNull()
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
    for (baseType in BaseType.entries) {
        function(
            kdoc = "Returns an empty [${baseType.generatedClassName}].",
            name = "empty${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
        ) {
            addGenericTypes(baseType.type)

            statement("return ${baseType.generatedClassName}.EMPTY")
        }
    }
}

private fun FileSpec.Builder.addImmutableArrayOf() {
    // Calling immutableArrayOf() without arguments will delegate to the empty generic factory function
    function(
        kdoc = "Returns an empty [${GENERIC.generatedClassName}].",
        name = "immutableArrayOf",
        returns = GENERIC.getGeneratedTypeName(),
    ) {
        addGenericTypes(GENERIC.type)

        statement("return empty${GENERIC.generatedClassName}()")
    }

    for (baseType in BaseType.entries) {
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] containing the specified [values].",
            name = "immutableArrayOf",
            parameters = { "values"(type = baseType.type, isVararg = true) },
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            addGenericTypes(baseType.type)

            statement(
                "return ${baseType.generatedClassName}.copyFrom(source = values, startIndex = 0, size = values.size)",
            )
        }
    }
}

private fun FileSpec.Builder.addImmutableArrayOfNotNull() {
    for (baseType in BaseType.entries) {
        val nonNullType = when (baseType) {
            GENERIC -> TypeVariableName("T", Any::class.asTypeName())
            else -> baseType.type
        }
        val returnType = when (baseType) {
            GENERIC -> baseType.getGeneratedClass().parameterizedBy(nonNullType)
            else -> baseType.getGeneratedTypeName()
        }
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] containing only the non-null values.",
            name = "immutableArrayOfNotNull",
            parameters = { "values"(type = nonNullType.copy(nullable = true), isVararg = true) },
            returns = returnType,
            forceFunctionBody = true,
        ) {
            addGenericTypes(nonNullType)
            jvmName("immutableArrayOfNotNull", baseType.name)
            controlFlow("return build${baseType.generatedClassName}") {
                controlFlow("for (value in values)") {
                    controlFlow("if (value != null)") {
                        statement("add(value)")
                    }
                }
            }
        }
    }
}

private fun FileSpec.Builder.addBuilderFunctions() {
    for (baseType in BaseType.entries) {
        val receiver = when (baseType) {
            GENERIC -> baseType.getGeneratedClass().nestedClass("Builder").parameterizedBy(baseType.type)
            else -> baseType.getGeneratedClass().nestedClass("Builder")
        }
        function(
            kdoc = "Builds an [${baseType.generatedClassName}] for when the size isn't known in advance.",
            name = "build${baseType.generatedClassName}",
            parameters = {
                "initialCapacity"<Int>(defaultValue = "10")
                "body"(
                    type = lambda<Unit>(receiver = receiver),
                )
            },
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            addGenericTypes(baseType.type)
            createImmutableArrayBuilder(name = "builder", forType = baseType, initialCapacity = "initialCapacity")
            statement("return builder.apply(body).build()")
        }
    }
}

private fun TypeSpec.Builder.addBuilderUtilsEnsureCapacity() {
    function(
        kdoc = """
            Returns a capacity that's greater than or equal to [minCapacity].  If [currentCapacity] is already sufficient then [currentCapacity] is returned.

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
            statement("minCapacity < 0 -> error(%S)", "minCapacity encountered overflow")
            statement("currentCapacity >= minCapacity -> return currentCapacity")
            statement("minCapacity > MAX_ARRAY_SIZE -> error(%S)", "minCapacity exceeds max array size")
        }
        comment("increase the size by at least 50 percent")
        statement("val newCapacity = currentCapacity + (currentCapacity shr 1) + 1")
        controlFlow("return when") {
            statement("newCapacity < 0 -> MAX_ARRAY_SIZE // handle overflow")
            statement("newCapacity < minCapacity -> minCapacity")
            statement("else -> newCapacity")
        }
    }
}

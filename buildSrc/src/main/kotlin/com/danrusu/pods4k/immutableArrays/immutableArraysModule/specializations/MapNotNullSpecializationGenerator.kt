package com.danrusu.pods4k.immutableArrays.immutableArraysModule.specializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

internal object MapNotNullSpecializationGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.specializationPackageName, "MapNotNullSpecializations") {
            for (fromType in BaseType.values()) {
                for (toType in BaseType.values()) {
                    addMapNotNullFunction(fromType, toType)
                }
            }
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addMapNotNullFunction(fromType: BaseType, toType: BaseType) {
    val mappedType: TypeName
    val resultTypeName: TypeName
    if (toType == BaseType.GENERIC) {
        mappedType = TypeVariableName("R")
        resultTypeName = toType.getGeneratedClass().parameterizedBy(mappedType)
    } else {
        mappedType = toType.type
        resultTypeName = toType.getGeneratedTypeName()
    }
    function(
        kdoc = "Transforms each element and returns an immutable array with the non-null results.",
        modifiers = listOf(KModifier.INLINE),
        receiver = fromType.getGeneratedTypeName(),
        name = "mapNotNull",
        parameters = {
            "transform"(
                type = lambda(
                    parameters = { "element"(type = fromType.type) },
                    returnType = mappedType.copy(nullable = true),
                )
            )
        },
        returns = resultTypeName,
    ) {
        addAnnotation(OverloadResolutionByLambdaReturnType::class)
        if (fromType == BaseType.GENERIC) {
            addTypeVariable(fromType.type as TypeVariableName)
        }
        if (toType == BaseType.GENERIC) {
            addTypeVariable(mappedType as TypeVariableName)
            statement("val builder = ${toType.generatedClassName}.Builder<%T>()", mappedType)
        } else {
            statement("val builder = ${toType.generatedClassName}.Builder()")
        }
        controlFlow("forEach { element ->") {
            statement("transform(element)?.let { builder.add(it) }")
        }
        statement("return builder.build()")
    }
}

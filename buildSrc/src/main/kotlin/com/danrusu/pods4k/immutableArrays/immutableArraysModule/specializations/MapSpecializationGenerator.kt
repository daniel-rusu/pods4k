package com.danrusu.pods4k.immutableArrays.immutableArraysModule.specializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName

internal object MapSpecializationGenerator : SpecializationGenerator("MapSpecializations") {
    override fun generateSpecialization(fileSpec: FileSpec.Builder, fromType: BaseType, toType: BaseType) {
        fileSpec.addMapFunction(fromType, toType)
    }
}

private fun FileSpec.Builder.addMapFunction(fromType: BaseType, toType: BaseType) {
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
        kdoc = "Returns an immutable array containing the results of applying [transform] to each element.",
        modifiers = listOf(KModifier.INLINE),
        receiver = fromType.getGeneratedTypeName(),
        name = "map",
        parameters = {
            "transform"(
                type = lambda(
                    parameters = { "element"(type = fromType.type) },
                    returnType = mappedType,
                ),
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
        }
        statement("return ${toType.generatedClassName}(size) { transform(get(it)) }")
    }
}

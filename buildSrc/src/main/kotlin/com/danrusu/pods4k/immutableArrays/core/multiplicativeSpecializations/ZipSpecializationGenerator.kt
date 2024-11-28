package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName

internal object ZipSpecializationGenerator : SpecializationGenerator("ZipSpecializations") {
    override fun generateSpecialization(fileSpec: FileSpec.Builder, fromType: BaseType, toType: BaseType) {
        fileSpec.addZipWithTransformFunction(fromType, toType)
    }
}

private fun FileSpec.Builder.addZipWithTransformFunction(fromType: BaseType, toType: BaseType) {
    val valueType: TypeName
    val resultTypeName: TypeName
    if (toType == BaseType.GENERIC) {
        valueType = TypeVariableName("V")
        resultTypeName = toType.getGeneratedClass().parameterizedBy(valueType)
    } else {
        valueType = toType.type
        resultTypeName = toType.getGeneratedTypeName()
    }
    function(
        kdoc = "Returns an immutable array of values built from the elements of [this] and [other] with the same " +
            "index using the provided transform function applied to each pair of elements. The result has the " +
            "length of the shortest immutable array.",
        modifiers = listOf(KModifier.INLINE),
        receiver = fromType.getGeneratedTypeName(),
        name = "zip",
        parameters = {
            "other"(type = fromType.getGeneratedTypeName())
            "transform"(
                type = lambda(
                    parameters = {
                        "a"(type = fromType.type)
                        "b"(type = fromType.type)
                    },
                    returnType = valueType,
                ),
            )
        },
        returns = resultTypeName,
        forceFunctionBody = true,
    ) {
        addAnnotation(OverloadResolutionByLambdaReturnType::class)
        if (fromType == BaseType.GENERIC) {
            addTypeVariable(fromType.type as TypeVariableName)
        }
        if (toType == BaseType.GENERIC) {
            addTypeVariable(valueType as TypeVariableName)
        }
        controlFlow("return ${toType.generatedClassName}(minOf(size, other.size)) { index ->") {
            statement("transform(this[index], other[index])")
        }
    }
}

package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName

internal object ZipSpecializationGenerator : SpecializationGenerator("ZipSpecializations") {
    override fun generateSpecialization(
        fileSpec: FileSpec.Builder,
        fromType: BaseType,
        toType: BaseType,
    ) {
        fileSpec.addZipWithTransformFunction(fromType, toType)
        fileSpec.addZipFunction(fromType, toType)
    }
}

private fun FileSpec.Builder.addZipFunction(type1: BaseType, type2: BaseType) {
    val type2Name: TypeName
    val type2ValueName: TypeName
    if (type2 == BaseType.GENERIC) {
        type2ValueName = TypeVariableName("R")
        type2Name = type2.getGeneratedClass().parameterizedBy(type2ValueName)
    } else {
        type2ValueName = type2.type
        type2Name = type2.getGeneratedTypeName()
    }

    val kdoc = """
        Returns an immutable array of pairs built from the elements of [this] and [other] with the same index. The
        result has the length of the shortest immutable array.
    """.trimIndent()

    function(
        kdoc = kdoc,
        modifiers = listOf(KModifier.INFIX),
        receiver = type1.getGeneratedTypeName(),
        name = "zip",
        parameters = { "other"(type = type2Name) },
        returns = BaseType.GENERIC.getGeneratedClass()
            .parameterizedBy(Pair::class.asTypeName().parameterizedBy(type1.type, type2ValueName)),
        forceFunctionBody = true,
    ) {
        addGenericTypes(type1.type, type2ValueName)

        controlFlow("return ${BaseType.GENERIC.generatedClassName}(minOf(size, other.size)) { index ->") {
            statement("Pair(this[index], other[index])")
        }
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

    val kdoc = """
        Returns an immutable array of values built from the elements of [this] and [other] with the same index using
        the provided transform function applied to each pair of elements. The result has the length of the shortest
        immutable array.
    """.trimIndent()

    function(
        kdoc = kdoc,
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
        addGenericTypes(fromType.type, valueType)

        controlFlow("return ${toType.generatedClassName}(minOf(size, other.size)) { index ->") {
            statement("transform(this[index], other[index])")
        }
    }
}

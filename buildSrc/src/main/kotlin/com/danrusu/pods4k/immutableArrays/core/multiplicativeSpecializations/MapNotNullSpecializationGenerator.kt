package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.createImmutableArrayBuilder
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName

internal object MapNotNullSpecializationGenerator : SpecializationGenerator("MapNotNullSpecializations") {
    override fun generateSpecialization(fileSpec: FileSpec.Builder, fromType: BaseType, toType: BaseType) {
        fileSpec.addMapNotNullFunction(fromType, toType)
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
                ),
            )
        },
        returns = resultTypeName,
    ) {
        addAnnotation(OverloadResolutionByLambdaReturnType::class)
        addGenericTypes(fromType.type, mappedType)

        createImmutableArrayBuilder(name = "builder", forType = toType, genericTypeOverride = mappedType)
        controlFlow("forEach { element ->") {
            statement("transform(element)?.let { builder.add(it) }")
        }
        statement("return builder.build()")
    }
}

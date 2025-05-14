package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.createImmutableArrayBuilder
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.annotation
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName

internal object MapIndexedNotNullSpecializationGenerator :
    SpecializationGenerator("MapIndexedNotNullSpecializations") {

    override fun generateSpecialization(
        fileSpec: FileSpec.Builder,
        fromType: BaseType,
        toType: BaseType,
    ) {
        fileSpec.addMapIndexedNotNullFunction(fromType, toType)
    }
}

private fun FileSpec.Builder.addMapIndexedNotNullFunction(fromType: BaseType, toType: BaseType) {
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
        kdoc = "Returns an Immutable Array containing the non-null results of applying [transform] to each element " +
            "and its index.",
        modifiers = listOf(KModifier.INLINE),
        receiver = fromType.getGeneratedTypeName(),
        name = "mapIndexedNotNull",
        parameters = {
            "transform"(
                type = lambda(
                    parameters = {
                        "index"<Int>()
                        "element"(type = fromType.type)
                    },
                    returnType = mappedType.copy(nullable = true),
                ),
            )
        },
        returns = resultTypeName,
    ) {
        annotation<OverloadResolutionByLambdaReturnType>()
        addGenericTypes(fromType.type, mappedType)

        createImmutableArrayBuilder(name = "builder", forType = toType, genericTypeOverride = mappedType)
        controlFlow("forEachIndexed { index, element ->") {
            statement("transform(index, element)?.let { builder.add(it) }")
        }
        statement("return builder.build()")
    }
}

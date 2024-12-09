package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName

internal object MapIndexedSpecializationGenerator : SpecializationGenerator("MapIndexedSpecializations") {
    override fun generateSpecialization(fileSpec: FileSpec.Builder, fromType: BaseType, toType: BaseType) {
        fileSpec.addMapIndexedFunction(fromType, toType)
    }
}

private fun FileSpec.Builder.addMapIndexedFunction(fromType: BaseType, toType: BaseType) {
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
        kdoc = "Returns an immutable array containing the results of applying [transform] to each element and its index.",
        modifiers = listOf(KModifier.INLINE),
        receiver = fromType.getGeneratedTypeName(),
        name = "mapIndexed",
        parameters = {
            "transform"(
                type = lambda(
                    parameters = {
                        "index"<Int>()
                        "element"(type = fromType.type)
                    },
                    returnType = mappedType,
                ),
            )
        },
        returns = resultTypeName,
        forceFunctionBody = true,
    ) {
        addAnnotation(OverloadResolutionByLambdaReturnType::class)
        addGenericTypes(fromType.type, mappedType)

        statement("return ${toType.generatedClassName}(size) { transform(it, get(it)) }")
    }
}

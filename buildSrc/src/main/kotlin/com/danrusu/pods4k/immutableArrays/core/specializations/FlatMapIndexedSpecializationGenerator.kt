package com.danrusu.pods4k.immutableArrays.core.specializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName

internal object FlatMapIndexedSpecializationGenerator : SpecializationGenerator("FlatMapIndexedSpecializations") {
    override fun generateSpecialization(fileSpec: FileSpec.Builder, fromType: BaseType, toType: BaseType) {
        fileSpec.addFlatMapIndexedFunction(fromType, toType)
    }
}

private fun FileSpec.Builder.addFlatMapIndexedFunction(fromType: BaseType, toType: BaseType) {
    val mappedType: TypeName
    val resultType: TypeName
    if (toType == BaseType.GENERIC) {
        mappedType = TypeVariableName("R")
        resultType = toType.getGeneratedClass().parameterizedBy(mappedType)
    } else {
        mappedType = toType.type
        resultType = toType.getGeneratedTypeName()
    }
    function(
        kdoc = """
            Transforms each element into a collection and appends those collections in a single ${toType.generatedClassName}.

            Note that if [transform] produces an array then you'll want to use the [asList] function for optimal performance instead of copying the elements into a temporary list.  That's because [asList] wraps the array without copying the elements.
        """.trimIndent(),
        modifiers = listOf(KModifier.INLINE),
        receiver = fromType.getGeneratedTypeName(),
        name = "flatMapIndexed",
        parameters = {
            "transform"(
                type = lambda(
                    parameters = {
                        "index"<Int>()
                        "element"(type = fromType.type)
                    },
                    returnType = Iterable::class.asTypeName().parameterizedBy(mappedType),
                ),
            )
        },
        returns = resultType,
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
        statement("forEachIndexed { index, element -> builder.addAll(transform(index, element)) }")
        statement("return builder.build()")
    }
}

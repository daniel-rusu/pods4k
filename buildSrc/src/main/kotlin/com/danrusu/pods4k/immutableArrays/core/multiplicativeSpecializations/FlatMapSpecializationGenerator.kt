package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import com.squareup.kotlinpoet.jvm.jvmName

internal object FlatMapSpecializationGenerator : SpecializationGenerator("FlatMapSpecializations") {
    override fun generateSpecialization(fileSpec: FileSpec.Builder, fromType: BaseType, toType: BaseType) {
        fileSpec.addFlatMapFunction(fromType, toType)
    }
}

private fun FileSpec.Builder.addFlatMapFunction(fromType: BaseType, toType: BaseType) {
    val mappedType: TypeName
    val resultType: TypeName
    if (toType == BaseType.GENERIC) {
        mappedType = TypeVariableName("R")
        resultType = toType.getGeneratedClass().parameterizedBy(mappedType)
    } else {
        mappedType = toType.type
        resultType = toType.getGeneratedTypeName()
    }

    // flatMap joining iterables
    function(
        kdoc = "Transforms each element into a collection and appends those collections in a single ${toType.generatedClassName}.",
        modifiers = listOf(KModifier.INLINE),
        receiver = fromType.getGeneratedTypeName(),
        name = "flatMap",
        parameters = {
            "transform"(
                type = lambda(
                    parameters = { "element"(type = fromType.type) },
                    returnType = Iterable::class.asTypeName().parameterizedBy(mappedType),
                ),
            )
        },
        returns = resultType,
    ) {
        jvmName("flatMap${toType.typeClass.simpleName}Iterable")
        flatMapBody(fromType, toType, mappedType)
    }

    // flatMap joining immutable arrays
    function(
        kdoc = "Transforms each element into an immutable array and appends those arrays in a single ${toType.generatedClassName}.",
        modifiers = listOf(KModifier.INLINE),
        receiver = fromType.getGeneratedTypeName(),
        name = "flatMap",
        parameters = {
            "transform"(
                type = lambda(
                    parameters = { "element"(type = fromType.type) },
                    returnType = resultType,
                ),
            )
        },
        returns = resultType,
    ) {
        jvmName("flatMap${toType.generatedClassName}")
        flatMapBody(fromType, toType, mappedType)
    }
}

private fun FunSpec.Builder.flatMapBody(
    fromType: BaseType,
    toType: BaseType,
    mappedType: TypeName,
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
    statement("forEach { builder.addAll(transform(it)) }")
    statement("return builder.build()")
}

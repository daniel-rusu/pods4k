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

    // flatMapIndexed joining iterables
    function(
        kdoc = "Transforms each element into a collection and appends those collections in a single ${toType.generatedClassName}.",
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
        jvmName("flatMapIndexed${toType.typeClass.simpleName}Iterable")
        flatMapIndexedBody(fromType, toType, mappedType)
    }

    // flatMapIndexed joining immutable arrays
    function(
        kdoc = "Transforms each element into an immutable array and appends those arrays in a single ${toType.generatedClassName}.",
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
                    returnType = resultType,
                ),
            )
        },
        returns = resultType,
    ) {
        jvmName("flatMapIndexed${toType.generatedClassName}")
        flatMapIndexedBody(fromType, toType, mappedType)
    }
}

private fun FunSpec.Builder.flatMapIndexedBody(
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
    statement("forEachIndexed { index, element -> builder.addAll(transform(index, element)) }")
    statement("return builder.build()")
}

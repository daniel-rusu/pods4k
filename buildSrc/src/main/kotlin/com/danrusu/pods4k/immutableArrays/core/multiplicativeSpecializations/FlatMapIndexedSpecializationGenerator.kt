package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.immutableArrays.createImmutableArrayBuilder
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.annotation
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.jvmName
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName

internal object FlatMapIndexedSpecializationGenerator : SpecializationGenerator("FlatMapIndexedSpecializations") {
    override fun generateSpecialization(
        fileSpec: FileSpec.Builder,
        fromType: BaseType,
        toType: BaseType,
    ) {
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
        kdoc = "Transforms each element into a collection and appends those collections in a single " +
            "${toType.generatedClassName}.",
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
        jvmName("flatMapIndexed", "Iterable", toType.name)
        annotation<OverloadResolutionByLambdaReturnType>()
        addGenericTypes(fromType.type, mappedType)

        createImmutableArrayBuilder(name = "builder", forType = toType, genericTypeOverride = mappedType)
        statement("forEachIndexed { index, element -> builder.addAll(transform(index, element)) }")
        statement("return builder.build()")
    }

    // flatMapIndexed joining immutable arrays
    function(
        kdoc = "Transforms each element into an immutable array and appends those arrays in a single " +
            "${toType.generatedClassName}.",
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
        jvmName("flatMapIndexed", toType.generatedClassName)
        annotation<OverloadResolutionByLambdaReturnType>()
        addGenericTypes(fromType.type, mappedType)
        /**
         * Mapping the elements into an array of sub-arrays is more memory efficient and also improves performance based
         * on JMH benchmarks.  See the equivalent function in [FlatMapSpecializationGenerator] for explanation.
         */
        statement("var numElements = 0")
        controlFlow("val arrays = mapIndexed { index, element ->") {
            // reference the underlying array directly to avoid auto-boxing the immutable array
            statement("transform(index, element).values.also { numElements += it.size }")
        }
        controlFlow(
            "return %M(initialCapacity = numElements)",
            MemberName(ImmutableArrayConfig.packageName, "build${toType.generatedClassName}"),
        ) {
            statement("arrays.forEach { addAll(it) }")
        }
    }
}

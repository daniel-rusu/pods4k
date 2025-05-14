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

internal object FlatMapSpecializationGenerator : SpecializationGenerator("FlatMapSpecializations") {
    override fun generateSpecialization(
        fileSpec: FileSpec.Builder,
        fromType: BaseType,
        toType: BaseType,
    ) {
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
        kdoc = "Transforms each element into a collection and appends those collections in a single " +
            "${toType.generatedClassName}.",
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
        jvmName("flatMap", "Iterable", toType.name)
        annotation<OverloadResolutionByLambdaReturnType>()
        addGenericTypes(fromType.type, mappedType)

        createImmutableArrayBuilder(name = "builder", forType = toType, genericTypeOverride = mappedType)
        statement("forEach { builder.addAll(transform(it)) }")
        statement("return builder.build()")
    }

    // flatMap joining Immutable Arrays
    function(
        kdoc = "Transforms each element into an Immutable Array and appends those arrays in a single " +
            "${toType.generatedClassName}.",
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
        jvmName("flatMap", toType.generatedClassName)
        annotation<OverloadResolutionByLambdaReturnType>()
        addGenericTypes(fromType.type, mappedType)

        /*
        Mapping the elements into an array of sub-arrays is more memory efficient and also improves performance based
        on JMH benchmarks.

        Let's look at both approaches where:
        - Current array has N elements
        - Each element is transformed into a sub-array that has an average size of M
        - The resulting flattened array will contain N * M elements

        Traditional approach with dynamic backing array:
        ===================================================
        - When running out of capacity, a new backing array that's K times larger is allocated, where K > 1, and the
        elements are copied to the new backing array before continuing to add more elements.

        - Since the temporary backing array will almost never end up being perfectly sized, the elements will be copied
        into a final perfectly-sized array destination.  The temporary backing array uses at least N * M element slots
        of auxiliary memory.  In the worst case, the temporary backing array will be resized when it's just shy of
        being able to hold N * M elements, so it could be up to N * M * K in size.

        - Additionally, all the previous backing arrays that ran out of capacity and replaced along the way are
        additional auxiliary memory.  If we're lucky and these previously-discarded arrays are in a contiguous region of
        memory, some of that memory can be combined re-used for future backing arrays as it grows after multiple
        iterations of resizing the backing array.

        Current approach counting the elements first:
        =============================================
        - Store all the nested arrays in an array and keep a tally of their accumulated sizes.  Create a builder with
        the exact capacity needed and avoid having to copy that builder backing array into a final array since it won't
        have any unused capacity.

        - If the provided transform returns references to pre-existing arrays, this approach cuts the overall memory
        consumption in half since it doesn't need to accumulate the elements in some temporary location before being
        copied to their final destination.

        - If the provided transform creates temporary arrays, this approach holds all those nested arrays. However, the
        memory overhead in this scenario is the same as the traditional approach because we're just storing the elements
        in multiple chunks instead of storing them as a single large chunk.  Unlike the traditional approach where the
        large backing array ends up with unused capacity, each of the chunks are perfectly-sized arrays.  So the
        array-object overhead of all the nested arrays is offset by not having any wasted unused capacity.

        - The only extra memory that this approach requires is for a temporary array of size N that stores references
        to each of the nested arrays acquired from transforming the N elements.

        Memory Comparison:
        ==================
        The memory overhead of storing an array of N references to each nested array is significantly lower than the
        memory of the temporary backing arrays as it's re-sized a bunch of times to finally end up with sufficient
        capacity to store N * M elements.  If the provided flatMap transform returns references to pre-existing
        Immutable Arrays (which is common) then the memory benefit becomes even larger.

        Performance intuition:
        =======================
        The traditional approach copies all the N * M elements to the temporary backing array and then copies them again
        to their final destination.  Additionally, some of the elements get copied multiple times as the backing array
        is resized a bunch of times until it finally has sufficient capacity to store all the elements.

        The new approach copies the N references of the nested arrays and then copies the N * M elements directly to
        their final destination.
         */
        statement("var numElements = 0")
        controlFlow("val arrays = map { element ->") {
            // reference the underlying array directly to avoid auto-boxing the Immutable Array
            statement("transform(element).values.also { numElements += it.size }")
        }
        controlFlow(
            "return %M(initialCapacity = numElements)",
            MemberName(ImmutableArrayConfig.packageName, "build${toType.generatedClassName}"),
        ) {
            statement("arrays.forEach { addAll(it) }")
        }
    }
}

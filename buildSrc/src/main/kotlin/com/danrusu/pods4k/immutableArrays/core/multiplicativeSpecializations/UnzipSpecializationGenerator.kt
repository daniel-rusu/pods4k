package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.createImmutableArrayBuilder
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.jvmName
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName

internal object UnzipSpecializationGenerator : SpecializationGenerator("UnzipSpecializations") {
    override fun generateSpecialization(fileSpec: FileSpec.Builder, fromType: BaseType, toType: BaseType) {
        fileSpec.addUnzipFunction(fromType, toType)
    }
}

private fun FileSpec.Builder.addUnzipFunction(type1: BaseType, type2: BaseType) {
    val type2Name: TypeName
    val type2ValueName: TypeName
    if (type2 == BaseType.GENERIC) {
        type2ValueName = TypeVariableName("R")
        type2Name = type2.getGeneratedClass().parameterizedBy(type2ValueName)
    } else {
        type2ValueName = type2.type
        type2Name = type2.getGeneratedTypeName()
    }
    function(
        kdoc = "Returns a pair of immutable arrays, where first immutable array is built from the first values of " +
            "each pair, and the second immutable array is built from the second values of each pair.",
        receiver = BaseType.GENERIC.getGeneratedClass().parameterizedBy(
            Pair::class.asTypeName().parameterizedBy(type1.type, type2ValueName),
        ),
        name = "unzip",
        returns = Pair::class.asTypeName().parameterizedBy(type1.getGeneratedTypeName(), type2Name),
    ) {
        jvmName("unzip", "Pair", type1.name, type2.name)
        addGenericTypes(type1.type, type2ValueName)

        createImmutableArrayBuilder(name = "first", forType = type1, initialCapacity = "size")
        createImmutableArrayBuilder(
            name = "second",
            forType = type2,
            initialCapacity = "size",
            genericTypeOverride = type2ValueName,
        )

        controlFlow("for (pair in this)") {
            statement("first.add(pair.first)")
            statement("second.add(pair.second)")
        }
        statement("return Pair(first.build(), second.build())")
    }
}

package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import com.squareup.kotlinpoet.jvm.jvmName

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
        jvmName("unzip_${type1.name}_${type2.name}")
        if (type1 == BaseType.GENERIC) {
            addTypeVariable(type1.type as TypeVariableName)
        }
        if (type2 == BaseType.GENERIC) {
            addTypeVariable(type2ValueName as TypeVariableName)
        }

        if (type1 == BaseType.GENERIC) {
            statement("val first = ${type1.generatedClassName}.Builder<%T>(initialCapacity = size)", type1.type)
        } else {
            statement("val first = ${type1.generatedClassName}.Builder(initialCapacity = size)")
        }
        if (type2 == BaseType.GENERIC) {
            statement("val second = ${type2.generatedClassName}.Builder<%T>(initialCapacity = size)", type2ValueName)
        } else {
            statement("val second = ${type2.generatedClassName}.Builder(initialCapacity = size)")
        }
        controlFlow("for (pair in this)") {
            statement("first.add(pair.first)")
            statement("second.add(pair.second)")
        }
        statement("return Pair(first.build(), second.build())")
    }
}

package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName

internal fun parameters(body: ParameterDSL.() -> Unit): List<ParameterSpec> {
    return ParameterDSL().apply(body).build()
}

internal class ParameterDSL {
    private val parameters = mutableListOf<ParameterSpec>()

    inline operator fun <reified T> String.invoke() {
        invoke(T::class.asTypeName())
    }

    operator fun String.invoke(type: TypeName) {
        parameters += ParameterSpec.builder(this, type).build()
    }

    fun build(): List<ParameterSpec> = parameters
}

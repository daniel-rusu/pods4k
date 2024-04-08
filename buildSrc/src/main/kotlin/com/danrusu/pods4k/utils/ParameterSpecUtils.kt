package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.*

internal class ParameterDSL {
    private val parameters = mutableListOf<ParameterSpec>()

    inline operator fun <reified T> String.invoke() {
        invoke(T::class.asTypeName())
    }

    operator fun String.invoke(type: TypeName, isVararg: Boolean = false) {
        val parameter = ParameterSpec.builder(this, type)
        if (isVararg) {
            parameter.addModifiers(KModifier.VARARG)
        }
        parameters += parameter.build()
    }

    inline fun <reified T : Any> lambda(parameters: ParameterDSL.() -> Unit): LambdaTypeName {
        val params = ParameterDSL().apply(parameters).build()
        return LambdaTypeName.get(parameters = params, returnType = T::class.asTypeName())
    }

    inline fun lambda(parameters: ParameterDSL.() -> Unit, returnType: TypeName): LambdaTypeName {
        val params = ParameterDSL().apply(parameters).build()
        return LambdaTypeName.get(parameters = params, returnType = returnType)
    }

    fun build(): List<ParameterSpec> = parameters
}

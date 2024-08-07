package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName

internal class ParameterDSL {
    private val parameters = mutableListOf<ParameterSpec>()

    inline operator fun <reified T> String.invoke(
        modifiers: List<KModifier> = emptyList(),
        isVararg: Boolean = false,
        defaultValue: String? = null,
    ) {
        invoke(modifiers, T::class.asTypeName(), isVararg, defaultValue)
    }

    operator fun String.invoke(
        modifiers: List<KModifier> = emptyList(),
        type: TypeName,
        isVararg: Boolean = false,
        defaultValue: String? = null,
    ) {
        val parameter = ParameterSpec.builder(this, type)
        parameter.addModifiers(modifiers)
        if (isVararg) {
            parameter.addModifiers(KModifier.VARARG)
        }
        if (defaultValue != null) {
            parameter.defaultValue(defaultValue)
        }
        parameters += parameter.build()
    }

    inline fun <reified T : Any> lambda(
        receiver: TypeName? = null,
        parameters: ParameterDSL.() -> Unit = {},
    ): LambdaTypeName {
        val params = ParameterDSL().apply(parameters).build()
        return LambdaTypeName.get(receiver = receiver, parameters = params, returnType = T::class.asTypeName())
    }

    inline fun <reified T : Any> nullableLambda(
        receiver: TypeName? = null,
        parameters: ParameterDSL.() -> Unit = {},
    ): LambdaTypeName {
        val params = ParameterDSL().apply(parameters).build()
        return LambdaTypeName.get(receiver = receiver, parameters = params, returnType = T::class.asTypeName())
            .copy(nullable = true) as LambdaTypeName
    }

    inline fun lambda(
        receiver: TypeName? = null,
        parameters: ParameterDSL.() -> Unit = {},
        returnType: TypeName,
    ): LambdaTypeName {
        val params = ParameterDSL().apply(parameters).build()
        return LambdaTypeName.get(receiver = receiver, parameters = params, returnType = returnType)
    }

    fun build(): List<ParameterSpec> = parameters
}

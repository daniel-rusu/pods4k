package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.*

internal inline fun TypeSpec.Builder.addPrimaryConstructor(
    modifiers: List<KModifier> = emptyList(),
    parameters: ParameterDSL.() -> Unit = {},
    body: FunSpec.Builder.() -> Unit
): TypeSpec.Builder {
    return primaryConstructor(
        FunSpec.constructorBuilder().apply {
            addModifiers(modifiers)
            addParameters(ParameterDSL().apply(parameters).build())
            body()
        }.build()
    )
}

internal inline fun TypeSpec.Builder.addCompanionObject(body: TypeSpec.Builder.() -> Unit): TypeSpec.Builder {
    return addType(TypeSpec.companionObjectBuilder().apply(body).build())
}

internal fun TypeSpec.Builder.addProperty(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    name: String,
    type: TypeName,
    init: String? = null,
    get: String? = null
): TypeSpec.Builder {
    return addProperty(
        PropertySpec.builder(name, type, modifiers).apply {
            kdoc?.let { addKdoc(it) }
            init?.let { initializer(it) }
            get?.let { getter(FunSpec.getterBuilder().addStatement(get).build()) }
        }.build()
    )
}

internal inline fun TypeSpec.Builder.addFunction(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    name: String,
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName,
    code: String,
): TypeSpec.Builder {
    return addFunction(kdoc, modifiers, name, parameters, returns) {
        addCode(code)
    }
}

internal inline fun TypeSpec.Builder.addFunction(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    name: String,
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName,
    body: FunSpec.Builder.() -> Unit
): TypeSpec.Builder {
    return addFunction(
        FunSpec.builder(name).apply {
            kdoc?.let { addKdoc(it) }
            addModifiers(modifiers)
            addParameters(ParameterDSL().apply(parameters).build())
            returns(returns)
            body()
        }.build()
    )
}

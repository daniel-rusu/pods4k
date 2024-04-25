package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName

internal fun TypeSpec.Builder.suppress(warning: String): TypeSpec.Builder {
    return addAnnotation(
        AnnotationSpec.builder(Suppress::class)
            .addMember("%S", warning)
            .build()
    )
}

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

internal inline fun <reified T : Any> TypeSpec.Builder.addProperty(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    name: String,
    init: String? = null,
    getModifiers: List<KModifier> = emptyList(),
    get: String? = null,
    body: PropertySpec.Builder.() -> Unit = {},
): TypeSpec.Builder {
    return addProperty(kdoc, modifiers, name, type = T::class.asTypeName(), init, getModifiers, get, body)
}

internal inline fun TypeSpec.Builder.addProperty(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    name: String,
    type: TypeName,
    init: String? = null,
    getModifiers: List<KModifier> = emptyList(),
    get: String? = null,
    body: PropertySpec.Builder.() -> Unit = {},
): TypeSpec.Builder {
    return addProperty(
        PropertySpec.builder(name, type, modifiers).apply {
            kdoc?.let { addKdoc(it) }
            init?.let { initializer(it) }
            get?.let {
                getter(
                    FunSpec.getterBuilder()
                        .addModifiers(getModifiers)
                        .addStatement(get)
                        .build()
                )
            }
            body()
        }.build()
    )
}

internal inline fun TypeSpec.Builder.addFunction(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    name: String,
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName? = null,
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
    returns: TypeName? = null,
    body: FunSpec.Builder.() -> Unit
): TypeSpec.Builder {
    return addFunction(
        FunSpec.builder(name).apply {
            kdoc?.let { addKdoc(it) }
            addModifiers(modifiers)
            addParameters(ParameterDSL().apply(parameters).build())
            returns?.let { returns(it) }
            body()
        }.build()
    )
}

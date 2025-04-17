package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName

internal inline fun <reified T : Annotation> TypeSpec.Builder.annotation(vararg members: String): TypeSpec.Builder {
    var builder = AnnotationSpec.builder(T::class)
    for (member in members) {
        builder = builder.addMember("%S", member)
    }

    return addAnnotation(builder.build())
}

internal inline fun TypeSpec.Builder.addPrimaryConstructor(
    modifiers: List<KModifier> = emptyList(),
    parameters: ParameterDSL.() -> Unit = {},
    body: FunSpec.Builder.() -> Unit = {},
): TypeSpec.Builder {
    return primaryConstructor(
        FunSpec.constructorBuilder().apply {
            addModifiers(modifiers)
            addParameters(ParameterDSL().apply(parameters).build())
            body()
        }.build(),
    )
}

internal inline fun TypeSpec.Builder.companionObject(body: TypeSpec.Builder.() -> Unit): TypeSpec.Builder {
    return addType(TypeSpec.companionObjectBuilder().apply(body).build())
}

internal inline fun <reified T : Any> TypeSpec.Builder.property(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    isMutable: Boolean = false,
    name: String,
    init: String? = null,
    getModifiers: List<KModifier> = emptyList(),
    get: String? = null,
    privateSetter: Boolean = false,
    body: PropertySpec.Builder.() -> Unit = {},
): TypeSpec.Builder {
    return property(
        kdoc = kdoc,
        modifiers = modifiers,
        isMutable = isMutable,
        name = name,
        type = T::class.asTypeName(),
        init = init,
        getModifiers = getModifiers,
        get = get,
        privateSetter = privateSetter,
        body = body,
    )
}

internal inline fun TypeSpec.Builder.property(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    isMutable: Boolean = false,
    name: String,
    type: TypeName,
    init: String? = null,
    getModifiers: List<KModifier> = emptyList(),
    get: String? = null,
    privateSetter: Boolean = false,
    body: PropertySpec.Builder.() -> Unit = {},
): TypeSpec.Builder {
    return addProperty(
        PropertySpec.builder(name, type, modifiers).apply {
            kdoc?.let { addKdoc(it) }
            mutable(isMutable)
            init?.let { initializer(it) }
            get?.let {
                getter(
                    FunSpec.getterBuilder()
                        .addModifiers(getModifiers)
                        .addStatement(get)
                        .build(),
                )
            }
            if (privateSetter) {
                setter(
                    FunSpec.setterBuilder()
                        .addModifiers(KModifier.PRIVATE)
                        .build(),
                )
            }
            body()
        }.build(),
    )
}

internal inline fun TypeSpec.Builder.function(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    name: String,
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName? = null,
    forceFunctionBody: Boolean = false,
    body: FunSpec.Builder.() -> Unit,
): TypeSpec.Builder {
    return addFunction(
        FunSpec.builder(name).apply {
            if (forceFunctionBody) {
                emptyLine() // Empty line prevents expression body.  Spotless formatting will remove the empty line
            }
            kdoc?.let { addKdoc(it) }
            addModifiers(modifiers)
            addParameters(ParameterDSL().apply(parameters).build())
            returns?.let { returns(it) }
            body()
        }.build(),
    )
}

internal inline fun TypeSpec.Builder.declareClass(
    modifiers: List<KModifier> = emptyList(),
    name: String,
    body: TypeSpec.Builder.() -> Unit,
): TypeSpec.Builder {
    return addType(
        TypeSpec.classBuilder(name).apply {
            addModifiers(modifiers)
            body()
        }.build(),
    )
}

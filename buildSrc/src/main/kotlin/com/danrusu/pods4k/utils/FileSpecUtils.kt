package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName

internal inline fun createFile(packageName: String, fileName: String, body: FileSpec.Builder.() -> Unit): FileSpec {
    return FileSpec.builder(packageName, fileName).apply {
        indent("    ") // 4 spaces for indentation
        addFileComment("Auto-generated file. DO NOT EDIT!")
        body()
    }.build()
}

internal inline fun FileSpec.Builder.addClass(
    modifiers: List<KModifier> = emptyList(),
    name: String,
    body: TypeSpec.Builder.() -> Unit
): FileSpec.Builder {
    return addType(
        TypeSpec.classBuilder(name).apply {
            addModifiers(modifiers)
            body()
        }.build()
    )
}

internal inline fun FileSpec.Builder.function(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    receiver: TypeName? = null,
    name: String,
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName? = null,
    code: String,
): FileSpec.Builder {
    return function(kdoc, modifiers, receiver, name, parameters, returns) {
        statement(code)
    }
}

internal inline fun FileSpec.Builder.function(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    receiver: TypeName? = null,
    name: String,
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName? = null,
    body: FunSpec.Builder.() -> Unit
): FileSpec.Builder {
    return addFunction(
        FunSpec.builder(name).apply {
            kdoc?.let { addKdoc(it) }
            addModifiers(modifiers)
            receiver?.let { receiver(it) }
            addParameters(ParameterDSL().apply(parameters).build())
            returns?.let { returns(it) }
            body()
        }.build()
    )
}

internal inline fun <reified T : Any> FileSpec.Builder.property(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    name: String,
    init: String? = null,
    body: PropertySpec.Builder.() -> Unit = {},
): FileSpec.Builder {
    return property(
        kdoc = kdoc,
        modifiers = modifiers,
        name = name,
        type = T::class.asTypeName(),
        init = init,
        body = body
    )
}

internal inline fun FileSpec.Builder.property(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    name: String,
    type: TypeName,
    init: String? = null,
    body: PropertySpec.Builder.() -> Unit = {},
): FileSpec.Builder {
    return addProperty(
        PropertySpec.builder(name, type, modifiers).apply {
            kdoc?.let { addKdoc(it) }
            init?.let { initializer(it) }
            body()
        }.build()
    )
}

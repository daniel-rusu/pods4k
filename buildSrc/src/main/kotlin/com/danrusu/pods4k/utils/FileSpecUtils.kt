package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.*

internal inline fun createFile(packageName: String, fileName: String, body: FileSpec.Builder.() -> Unit): FileSpec {
    return FileSpec.builder(packageName, fileName).apply {
        indent("    ") // 4 spaces for indentation
        addFileComment("Auto-generated file. DO NOT EDIT!")
        body()
    }.build()
}

internal inline fun FileSpec.Builder.addClass(
    modifiers: List<KModifier> = emptyList(),
    name: ClassName,
    body: TypeSpec.Builder.() -> Unit
): FileSpec.Builder {
    return addType(
        TypeSpec.classBuilder(name).apply {
            addModifiers(modifiers)
            body()
        }.build()
    )
}

internal inline fun FileSpec.Builder.addFunction(
    kdoc: String? = null,
    modifiers: List<KModifier> = emptyList(),
    receiver: TypeName? = null,
    name: String,
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName? = null,
    code: String,
): FileSpec.Builder {
    return addFunction(kdoc, modifiers, receiver, name, parameters, returns) {
        addStatement(code)
    }
}

internal inline fun FileSpec.Builder.addFunction(
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

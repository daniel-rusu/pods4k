package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec

internal inline fun createFile(packageName: String, fileName: String, body: FileSpec.Builder.() -> Unit): FileSpec {
    return FileSpec.builder(packageName, fileName).apply {
        addFileComment("Auto-generated file. DO NOT EDIT!")
        body()
    }.build()
}

internal inline fun FileSpec.Builder.addClass(
    vararg modifiers: KModifier,
    name: ClassName,
    body: TypeSpec.Builder.() -> Unit
): FileSpec.Builder {
    return addType(
        TypeSpec.classBuilder(name).apply {
            addModifiers(*modifiers)
            body()
        }.build()
    )
}

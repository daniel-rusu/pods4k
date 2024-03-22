package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

internal inline fun <reified T> TypeSpec.Builder.addPropertyWithGetter(name: String, get: String): TypeSpec.Builder {
    val property = PropertySpec.builder(name, T::class)
        .getter(
            FunSpec.getterBuilder()
                .addStatement(get)
                .build()
        )
        .build()

    return addProperty(property)
}

package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.PropertySpec

internal inline fun <reified T : Annotation> PropertySpec.Builder.annotation(
    vararg members: String,
): PropertySpec.Builder {
    var builder = AnnotationSpec.builder(T::class)
    for (member in members) {
        builder = builder.addMember("%S", member)
    }

    return addAnnotation(builder.build())
}

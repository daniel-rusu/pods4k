package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec

internal fun FunSpec.Builder.suppress(warning: String): FunSpec.Builder {
    return addAnnotation(
        AnnotationSpec.builder(Suppress::class)
            .addMember("%S", warning)
            .build().apply {  }
    )
}

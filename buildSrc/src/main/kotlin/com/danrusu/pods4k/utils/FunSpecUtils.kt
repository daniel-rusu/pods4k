package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec

internal fun FunSpec.Builder.suppress(warning: String): FunSpec.Builder {
    return addAnnotation(
        AnnotationSpec.builder(Suppress::class)
            .addMember("%S", warning)
            .build(),
    )
}

internal fun FunSpec.Builder.jvmName(name: String): FunSpec.Builder {
    return addAnnotation(
        AnnotationSpec.builder(JvmName::class)
            .addMember("%S", name)
            .build(),
    )
}

internal fun FunSpec.Builder.emptyLine() {
    statement("")
}

internal fun FunSpec.Builder.comment(comment: String, vararg args: Any) {
    addComment(comment, *args)
}

internal fun FunSpec.Builder.statement(statement: String, vararg args: Any) {
    addStatement(statement, *args)
}

internal fun FunSpec.Builder.controlFlow(
    controlFlow: String,
    vararg args: Any,
    body: FunSpec.Builder.() -> Unit,
) {
    beginControlFlow(controlFlow, *args).apply(body).endControlFlow()
}

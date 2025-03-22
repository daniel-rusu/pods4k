package com.danrusu.pods4k.utils

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName

internal fun FunSpec.Builder.suppress(warning: String): FunSpec.Builder {
    return addAnnotation(
        AnnotationSpec.builder(Suppress::class)
            .addMember("%S", warning)
            .build(),
    )
}

/**
 * Adds the jvmName override.
 *
 * IMPORTANT:
 * 1.
 * For consistency, specify the function name followed by the generic types in the same order as they appear in the
 * generated function.  Don't include the main receiver type but only generic type parameters.
 *
 * E.g.
 * fun Sequence<List<Person>>.doSomething()
 * fun Sequence<Set<Person>>.doSomething()
 *
 * USE: jvmName("doSomething", collectionType, "Person")
 *
 * Note that "Sequence" isn't included as we start with the collection type (List / Set)
 *
 * 2.
 * If multiple functions swap between the generic ImmutableArray<T> and primitive variants like ImmutableIntArray, use
 * baseType.generatedClassName and ignore the generic type variable T.
 *
 * E.g.
 * fun <T> Iterable<ImmutableArray<T>>.flatten() : ImmutableArray<T>
 * fun <T> Iterable<ImmutableBooleanArray>.flatten() : ImmutableBooleanArray
 *
 * USE: jvmName("flatten", baseType.generatedClassName)
 *
 * 3.
 * If multiple functions swap between a generic type variable, T, and the 8 base types, use baseType.name to produce
 * GENERIC / BOOLEAN, etc and don't specify the generic type variable name (T or T?).
 *
 * E.g.
 * fun Iterable<Pair<Person, Boolean>>.doSomething()
 * fun Iterable<Pair<Person, Float>>.doSomething()
 *
 * USE: jvmName("doSomething", "Pair", "Person", baseType.name)
 *
 * 4.
 * When using the @OverloadResolutionByLambdaReturnType annotation, also add the lambda return type to the end.
 *
 * E.g.
 * fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Byte>): ImmutableByteArray
 * fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Int>): ImmutableIntArray
 *
 * USE: jvmName("flatMap", "Iterable", baseType.name)
 */
internal fun FunSpec.Builder.jvmName(functionName: String, vararg genericTypes: String): FunSpec.Builder {
    val name = buildString {
        append(functionName)
        for (type in genericTypes) {
            append('_')
            append(type)
        }
    }
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

internal fun FunSpec.Builder.controlFlow(controlFlow: String, vararg args: Any, body: FunSpec.Builder.() -> Unit) {
    beginControlFlow(controlFlow, *args).apply(body).endControlFlow()
}

internal fun FunSpec.Builder.addGenericTypes(vararg types: TypeName) {
    for (type in types) {
        if (type is TypeVariableName) {
            addTypeVariable(type)
        }
    }
}

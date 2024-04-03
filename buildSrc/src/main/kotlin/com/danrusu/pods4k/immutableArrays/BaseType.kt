package com.danrusu.pods4k.immutableArrays

import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import kotlin.reflect.KClass

private val genericType = TypeVariableName("T")

internal enum class BaseType(
    val type: TypeName,
    val backingArrayType: TypeName,
    val backingArrayConstructor: String,
    val generatedClassName: String,
) {
    GENERIC(
        type = genericType,
        backingArrayType = Array::class.asTypeName().parameterizedBy(genericType),
        backingArrayConstructor = "Array<Any?>",
        generatedClassName = "ImmutableArray"
    ),
    BOOLEAN(Boolean::class, BooleanArray::class),
    BYTE(Byte::class, ByteArray::class),
    CHAR(Char::class, CharArray::class),
    SHORT(Short::class, ShortArray::class),
    INT(Int::class, IntArray::class),
    LONG(Long::class, LongArray::class),
    FLOAT(Float::class, FloatArray::class),
    DOUBLE(Double::class, DoubleArray::class);

    constructor(
        type: KClass<*>,
        arrayType: KClass<*>
    ) : this(
        type = type.asTypeName(),
        backingArrayType = arrayType.asTypeName(),
        backingArrayConstructor = arrayType.simpleName!!,
        generatedClassName = "Immutable${type.simpleName}Array"
    )
}

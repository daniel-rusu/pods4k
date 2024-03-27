package com.danrusu.pods4k.immutableArrays

import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import com.squareup.kotlinpoet.typeNameOf
import kotlin.reflect.KClass

internal enum class BaseType(
    val type: TypeName,
    val backingArrayType: TypeName,
    val backingArrayConstructor: String,
    val generatedClassName: String,
) {
    GENERIC(
        type = TypeVariableName("T"),
        backingArrayType = typeNameOf<Array<Any?>>(),
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

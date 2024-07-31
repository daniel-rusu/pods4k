// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Byte
import kotlin.Char
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short
import kotlin.sequences.Sequence

/**
 * Returns an [ImmutableArray] with the contents of this sequence.
 */
public fun <T> Sequence<T>.toImmutableArray(): ImmutableArray<T> = buildImmutableArray {
    addAll(this@toImmutableArray)
}

/**
 * Returns an [ImmutableBooleanArray] with the contents of this sequence.
 */
public fun Sequence<Boolean>.toImmutableArray(): ImmutableBooleanArray =
        buildImmutableBooleanArray {
    addAll(this@toImmutableArray)
}

/**
 * Returns an [ImmutableByteArray] with the contents of this sequence.
 */
public fun Sequence<Byte>.toImmutableArray(): ImmutableByteArray = buildImmutableByteArray {
    addAll(this@toImmutableArray)
}

/**
 * Returns an [ImmutableCharArray] with the contents of this sequence.
 */
public fun Sequence<Char>.toImmutableArray(): ImmutableCharArray = buildImmutableCharArray {
    addAll(this@toImmutableArray)
}

/**
 * Returns an [ImmutableShortArray] with the contents of this sequence.
 */
public fun Sequence<Short>.toImmutableArray(): ImmutableShortArray = buildImmutableShortArray {
    addAll(this@toImmutableArray)
}

/**
 * Returns an [ImmutableIntArray] with the contents of this sequence.
 */
public fun Sequence<Int>.toImmutableArray(): ImmutableIntArray = buildImmutableIntArray {
    addAll(this@toImmutableArray)
}

/**
 * Returns an [ImmutableLongArray] with the contents of this sequence.
 */
public fun Sequence<Long>.toImmutableArray(): ImmutableLongArray = buildImmutableLongArray {
    addAll(this@toImmutableArray)
}

/**
 * Returns an [ImmutableFloatArray] with the contents of this sequence.
 */
public fun Sequence<Float>.toImmutableArray(): ImmutableFloatArray = buildImmutableFloatArray {
    addAll(this@toImmutableArray)
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of this sequence.
 */
public fun Sequence<Double>.toImmutableArray(): ImmutableDoubleArray = buildImmutableDoubleArray {
    addAll(this@toImmutableArray)
}

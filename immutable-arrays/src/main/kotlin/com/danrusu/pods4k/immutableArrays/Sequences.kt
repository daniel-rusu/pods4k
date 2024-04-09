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
public fun <T> Sequence<T>.toImmutableArray(): ImmutableArray<T> {
    val elements = this.toList()
    return ImmutableArray(elements.size) { elements[it] }
}

/**
 * Returns an [ImmutableBooleanArray] with the contents of this sequence.
 */
public fun Sequence<Boolean>.toImmutableBooleanArray(): ImmutableBooleanArray {
    val elements = this.toList()
    return ImmutableBooleanArray(elements.size) { elements[it] }
}

/**
 * Returns an [ImmutableByteArray] with the contents of this sequence.
 */
public fun Sequence<Byte>.toImmutableByteArray(): ImmutableByteArray {
    val elements = this.toList()
    return ImmutableByteArray(elements.size) { elements[it] }
}

/**
 * Returns an [ImmutableCharArray] with the contents of this sequence.
 */
public fun Sequence<Char>.toImmutableCharArray(): ImmutableCharArray {
    val elements = this.toList()
    return ImmutableCharArray(elements.size) { elements[it] }
}

/**
 * Returns an [ImmutableShortArray] with the contents of this sequence.
 */
public fun Sequence<Short>.toImmutableShortArray(): ImmutableShortArray {
    val elements = this.toList()
    return ImmutableShortArray(elements.size) { elements[it] }
}

/**
 * Returns an [ImmutableIntArray] with the contents of this sequence.
 */
public fun Sequence<Int>.toImmutableIntArray(): ImmutableIntArray {
    val elements = this.toList()
    return ImmutableIntArray(elements.size) { elements[it] }
}

/**
 * Returns an [ImmutableLongArray] with the contents of this sequence.
 */
public fun Sequence<Long>.toImmutableLongArray(): ImmutableLongArray {
    val elements = this.toList()
    return ImmutableLongArray(elements.size) { elements[it] }
}

/**
 * Returns an [ImmutableFloatArray] with the contents of this sequence.
 */
public fun Sequence<Float>.toImmutableFloatArray(): ImmutableFloatArray {
    val elements = this.toList()
    return ImmutableFloatArray(elements.size) { elements[it] }
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of this sequence.
 */
public fun Sequence<Double>.toImmutableDoubleArray(): ImmutableDoubleArray {
    val elements = this.toList()
    return ImmutableDoubleArray(elements.size) { elements[it] }
}

// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Array
import kotlin.Boolean
import kotlin.BooleanArray
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Char
import kotlin.CharArray
import kotlin.Double
import kotlin.DoubleArray
import kotlin.Float
import kotlin.FloatArray
import kotlin.Int
import kotlin.IntArray
import kotlin.Long
import kotlin.LongArray
import kotlin.Short
import kotlin.ShortArray

/**
 * Returns an [ImmutableBooleanArray] with the contents of this array.
 */
public fun BooleanArray.toImmutableArray(): ImmutableBooleanArray {
    return ImmutableBooleanArray.copyOf(copy = this, startIndex = 0, size = size)
}

/**
 * Returns an [ImmutableByteArray] with the contents of this array.
 */
public fun ByteArray.toImmutableArray(): ImmutableByteArray {
    return ImmutableByteArray.copyOf(copy = this, startIndex = 0, size = size)
}

/**
 * Returns an [ImmutableCharArray] with the contents of this array.
 */
public fun CharArray.toImmutableArray(): ImmutableCharArray {
    return ImmutableCharArray.copyOf(copy = this, startIndex = 0, size = size)
}

/**
 * Returns an [ImmutableShortArray] with the contents of this array.
 */
public fun ShortArray.toImmutableArray(): ImmutableShortArray {
    return ImmutableShortArray.copyOf(copy = this, startIndex = 0, size = size)
}

/**
 * Returns an [ImmutableIntArray] with the contents of this array.
 */
public fun IntArray.toImmutableArray(): ImmutableIntArray {
    return ImmutableIntArray.copyOf(copy = this, startIndex = 0, size = size)
}

/**
 * Returns an [ImmutableLongArray] with the contents of this array.
 */
public fun LongArray.toImmutableArray(): ImmutableLongArray {
    return ImmutableLongArray.copyOf(copy = this, startIndex = 0, size = size)
}

/**
 * Returns an [ImmutableFloatArray] with the contents of this array.
 */
public fun FloatArray.toImmutableArray(): ImmutableFloatArray {
    return ImmutableFloatArray.copyOf(copy = this, startIndex = 0, size = size)
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of this array.
 */
public fun DoubleArray.toImmutableArray(): ImmutableDoubleArray {
    return ImmutableDoubleArray.copyOf(copy = this, startIndex = 0, size = size)
}

/**
 * Returns an [ImmutableArray] with the contents of this array.
 */
public fun <T> Array<T>.toImmutableArray(): ImmutableArray<T> {
    return ImmutableArray.copyOf(copy = this, startIndex = 0, size = size)
}

/**
 * Returns an [ImmutableBooleanArray] with the contents of this array.
 */
public fun Array<Boolean>.toImmutableArray(): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { this[it] }
}

/**
 * Returns an [ImmutableByteArray] with the contents of this array.
 */
public fun Array<Byte>.toImmutableArray(): ImmutableByteArray {
    return ImmutableByteArray(size) { this[it] }
}

/**
 * Returns an [ImmutableCharArray] with the contents of this array.
 */
public fun Array<Char>.toImmutableArray(): ImmutableCharArray {
    return ImmutableCharArray(size) { this[it] }
}

/**
 * Returns an [ImmutableShortArray] with the contents of this array.
 */
public fun Array<Short>.toImmutableArray(): ImmutableShortArray {
    return ImmutableShortArray(size) { this[it] }
}

/**
 * Returns an [ImmutableIntArray] with the contents of this array.
 */
public fun Array<Int>.toImmutableArray(): ImmutableIntArray {
    return ImmutableIntArray(size) { this[it] }
}

/**
 * Returns an [ImmutableLongArray] with the contents of this array.
 */
public fun Array<Long>.toImmutableArray(): ImmutableLongArray {
    return ImmutableLongArray(size) { this[it] }
}

/**
 * Returns an [ImmutableFloatArray] with the contents of this array.
 */
public fun Array<Float>.toImmutableArray(): ImmutableFloatArray {
    return ImmutableFloatArray(size) { this[it] }
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of this array.
 */
public fun Array<Double>.toImmutableArray(): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { this[it] }
}

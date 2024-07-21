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
import kotlin.Suppress

/**
 * Returns an [ImmutableBooleanArray] with the contents of this array.
 */
public fun BooleanArray.toImmutableArray(): ImmutableBooleanArray {
    if (isEmpty()) return ImmutableBooleanArray.EMPTY

    val backingArray = BooleanArray(size)
    System.arraycopy(this, 0, backingArray, 0, size)
    return ImmutableBooleanArray(backingArray)
}

/**
 * Returns an [ImmutableByteArray] with the contents of this array.
 */
public fun ByteArray.toImmutableArray(): ImmutableByteArray {
    if (isEmpty()) return ImmutableByteArray.EMPTY

    val backingArray = ByteArray(size)
    System.arraycopy(this, 0, backingArray, 0, size)
    return ImmutableByteArray(backingArray)
}

/**
 * Returns an [ImmutableCharArray] with the contents of this array.
 */
public fun CharArray.toImmutableArray(): ImmutableCharArray {
    if (isEmpty()) return ImmutableCharArray.EMPTY

    val backingArray = CharArray(size)
    System.arraycopy(this, 0, backingArray, 0, size)
    return ImmutableCharArray(backingArray)
}

/**
 * Returns an [ImmutableShortArray] with the contents of this array.
 */
public fun ShortArray.toImmutableArray(): ImmutableShortArray {
    if (isEmpty()) return ImmutableShortArray.EMPTY

    val backingArray = ShortArray(size)
    System.arraycopy(this, 0, backingArray, 0, size)
    return ImmutableShortArray(backingArray)
}

/**
 * Returns an [ImmutableIntArray] with the contents of this array.
 */
public fun IntArray.toImmutableArray(): ImmutableIntArray {
    if (isEmpty()) return ImmutableIntArray.EMPTY

    val backingArray = IntArray(size)
    System.arraycopy(this, 0, backingArray, 0, size)
    return ImmutableIntArray(backingArray)
}

/**
 * Returns an [ImmutableLongArray] with the contents of this array.
 */
public fun LongArray.toImmutableArray(): ImmutableLongArray {
    if (isEmpty()) return ImmutableLongArray.EMPTY

    val backingArray = LongArray(size)
    System.arraycopy(this, 0, backingArray, 0, size)
    return ImmutableLongArray(backingArray)
}

/**
 * Returns an [ImmutableFloatArray] with the contents of this array.
 */
public fun FloatArray.toImmutableArray(): ImmutableFloatArray {
    if (isEmpty()) return ImmutableFloatArray.EMPTY

    val backingArray = FloatArray(size)
    System.arraycopy(this, 0, backingArray, 0, size)
    return ImmutableFloatArray(backingArray)
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of this array.
 */
public fun DoubleArray.toImmutableArray(): ImmutableDoubleArray {
    if (isEmpty()) return ImmutableDoubleArray.EMPTY

    val backingArray = DoubleArray(size)
    System.arraycopy(this, 0, backingArray, 0, size)
    return ImmutableDoubleArray(backingArray)
}

/**
 * Returns an [ImmutableArray] with the contents of this array.
 */
@Suppress("UNCHECKED_CAST")
public fun <T> Array<T>.toImmutableArray(): ImmutableArray<T> {
    if (isEmpty()) return ImmutableArray.EMPTY

    val backingArray = arrayOfNulls<Any?>(size) as Array<T>
    System.arraycopy(this, 0, backingArray, 0, size)
    return ImmutableArray(backingArray)
}

/**
 * Returns an [ImmutableBooleanArray] with the contents of this array.
 */
public fun Array<Boolean>.toImmutableArray(): ImmutableBooleanArray =
        ImmutableBooleanArray(size) { this[it] }

/**
 * Returns an [ImmutableByteArray] with the contents of this array.
 */
public fun Array<Byte>.toImmutableArray(): ImmutableByteArray =
        ImmutableByteArray(size) { this[it] }

/**
 * Returns an [ImmutableCharArray] with the contents of this array.
 */
public fun Array<Char>.toImmutableArray(): ImmutableCharArray =
        ImmutableCharArray(size) { this[it] }

/**
 * Returns an [ImmutableShortArray] with the contents of this array.
 */
public fun Array<Short>.toImmutableArray(): ImmutableShortArray =
        ImmutableShortArray(size) { this[it] }

/**
 * Returns an [ImmutableIntArray] with the contents of this array.
 */
public fun Array<Int>.toImmutableArray(): ImmutableIntArray = ImmutableIntArray(size) { this[it] }

/**
 * Returns an [ImmutableLongArray] with the contents of this array.
 */
public fun Array<Long>.toImmutableArray(): ImmutableLongArray =
        ImmutableLongArray(size) { this[it] }

/**
 * Returns an [ImmutableFloatArray] with the contents of this array.
 */
public fun Array<Float>.toImmutableArray(): ImmutableFloatArray =
        ImmutableFloatArray(size) { this[it] }

/**
 * Returns an [ImmutableDoubleArray] with the contents of this array.
 */
public fun Array<Double>.toImmutableArray(): ImmutableDoubleArray =
        ImmutableDoubleArray(size) { this[it] }

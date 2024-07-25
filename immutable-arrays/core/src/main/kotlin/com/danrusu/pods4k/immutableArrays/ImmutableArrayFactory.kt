// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import java.lang.OutOfMemoryError
import kotlin.Boolean
import kotlin.Byte
import kotlin.Char
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short
import kotlin.Unit

/**
 * Returns an empty [ImmutableArray].
 */
public fun <T> emptyImmutableArray(): ImmutableArray<T> = ImmutableArray.EMPTY

/**
 * Returns an empty [ImmutableBooleanArray].
 */
public fun emptyImmutableBooleanArray(): ImmutableBooleanArray = ImmutableBooleanArray.EMPTY

/**
 * Returns an empty [ImmutableByteArray].
 */
public fun emptyImmutableByteArray(): ImmutableByteArray = ImmutableByteArray.EMPTY

/**
 * Returns an empty [ImmutableCharArray].
 */
public fun emptyImmutableCharArray(): ImmutableCharArray = ImmutableCharArray.EMPTY

/**
 * Returns an empty [ImmutableShortArray].
 */
public fun emptyImmutableShortArray(): ImmutableShortArray = ImmutableShortArray.EMPTY

/**
 * Returns an empty [ImmutableIntArray].
 */
public fun emptyImmutableIntArray(): ImmutableIntArray = ImmutableIntArray.EMPTY

/**
 * Returns an empty [ImmutableLongArray].
 */
public fun emptyImmutableLongArray(): ImmutableLongArray = ImmutableLongArray.EMPTY

/**
 * Returns an empty [ImmutableFloatArray].
 */
public fun emptyImmutableFloatArray(): ImmutableFloatArray = ImmutableFloatArray.EMPTY

/**
 * Returns an empty [ImmutableDoubleArray].
 */
public fun emptyImmutableDoubleArray(): ImmutableDoubleArray = ImmutableDoubleArray.EMPTY

/**
 * Returns an empty [ImmutableArray].
 */
public fun <T> immutableArrayOf(): ImmutableArray<T> = emptyImmutableArray()

/**
 * Returns an [ImmutableArray] containing the specified [values].
 */
public fun <T> immutableArrayOf(vararg values: T): ImmutableArray<T> =
        buildImmutableArray(initialCapacity = values.size) { addAll(values) }

/**
 * Returns an [ImmutableBooleanArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Boolean): ImmutableBooleanArray =
        buildImmutableBooleanArray(initialCapacity = values.size) { addAll(values) }

/**
 * Returns an [ImmutableByteArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Byte): ImmutableByteArray =
        buildImmutableByteArray(initialCapacity = values.size) { addAll(values) }

/**
 * Returns an [ImmutableCharArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Char): ImmutableCharArray =
        buildImmutableCharArray(initialCapacity = values.size) { addAll(values) }

/**
 * Returns an [ImmutableShortArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Short): ImmutableShortArray =
        buildImmutableShortArray(initialCapacity = values.size) { addAll(values) }

/**
 * Returns an [ImmutableIntArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Int): ImmutableIntArray =
        buildImmutableIntArray(initialCapacity = values.size) { addAll(values) }

/**
 * Returns an [ImmutableLongArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Long): ImmutableLongArray =
        buildImmutableLongArray(initialCapacity = values.size) { addAll(values) }

/**
 * Returns an [ImmutableFloatArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Float): ImmutableFloatArray =
        buildImmutableFloatArray(initialCapacity = values.size) { addAll(values) }

/**
 * Returns an [ImmutableDoubleArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Double): ImmutableDoubleArray =
        buildImmutableDoubleArray(initialCapacity = values.size) { addAll(values) }

/**
 * Builds an [ImmutableArray] for when the size isn't known in advance.
 */
public fun <T> buildImmutableArray(initialCapacity: Int = 10,
        body: ImmutableArray.Builder<T>.() -> Unit): ImmutableArray<T> =
        ImmutableArray.Builder<T>(initialCapacity).apply(body).build()

/**
 * Builds an [ImmutableBooleanArray] for when the size isn't known in advance.
 */
public fun buildImmutableBooleanArray(initialCapacity: Int = 10,
        body: ImmutableBooleanArray.Builder.() -> Unit): ImmutableBooleanArray =
        ImmutableBooleanArray.Builder(initialCapacity).apply(body).build()

/**
 * Builds an [ImmutableByteArray] for when the size isn't known in advance.
 */
public fun buildImmutableByteArray(initialCapacity: Int = 10,
        body: ImmutableByteArray.Builder.() -> Unit): ImmutableByteArray =
        ImmutableByteArray.Builder(initialCapacity).apply(body).build()

/**
 * Builds an [ImmutableCharArray] for when the size isn't known in advance.
 */
public fun buildImmutableCharArray(initialCapacity: Int = 10,
        body: ImmutableCharArray.Builder.() -> Unit): ImmutableCharArray =
        ImmutableCharArray.Builder(initialCapacity).apply(body).build()

/**
 * Builds an [ImmutableShortArray] for when the size isn't known in advance.
 */
public fun buildImmutableShortArray(initialCapacity: Int = 10,
        body: ImmutableShortArray.Builder.() -> Unit): ImmutableShortArray =
        ImmutableShortArray.Builder(initialCapacity).apply(body).build()

/**
 * Builds an [ImmutableIntArray] for when the size isn't known in advance.
 */
public fun buildImmutableIntArray(initialCapacity: Int = 10,
        body: ImmutableIntArray.Builder.() -> Unit): ImmutableIntArray =
        ImmutableIntArray.Builder(initialCapacity).apply(body).build()

/**
 * Builds an [ImmutableLongArray] for when the size isn't known in advance.
 */
public fun buildImmutableLongArray(initialCapacity: Int = 10,
        body: ImmutableLongArray.Builder.() -> Unit): ImmutableLongArray =
        ImmutableLongArray.Builder(initialCapacity).apply(body).build()

/**
 * Builds an [ImmutableFloatArray] for when the size isn't known in advance.
 */
public fun buildImmutableFloatArray(initialCapacity: Int = 10,
        body: ImmutableFloatArray.Builder.() -> Unit): ImmutableFloatArray =
        ImmutableFloatArray.Builder(initialCapacity).apply(body).build()

/**
 * Builds an [ImmutableDoubleArray] for when the size isn't known in advance.
 */
public fun buildImmutableDoubleArray(initialCapacity: Int = 10,
        body: ImmutableDoubleArray.Builder.() -> Unit): ImmutableDoubleArray =
        ImmutableDoubleArray.Builder(initialCapacity).apply(body).build()

internal object BuilderUtils {
    /**
     * Some VMs reserve header words in the array so this is the max safe array size
     */
    public const val MAX_ARRAY_SIZE: Int = Int.MAX_VALUE - 8

    /**
     * Returns a larger capacity when [currentCapacity] is less than [minCapacity] otherwise returns
     * [currentCapacity].
     *
     * The strategy of choosing the new capacity attempts to balance the negative performance impact
     * of repeated resizing operations with the negative memory impact of ending up with too much
     * unused capacity.
     */
    public fun computeNewCapacity(currentCapacity: Int, minCapacity: Int): Int {
        when {
            minCapacity < 0 -> throw OutOfMemoryError() // overflow
            currentCapacity >= minCapacity -> return currentCapacity
            minCapacity > MAX_ARRAY_SIZE -> throw OutOfMemoryError()
        }
        // increase the size by at least 50 percent
        var newCapacity = currentCapacity + (currentCapacity shr 1) + 1
        return when {
            newCapacity < 0 -> MAX_ARRAY_SIZE // handle overflow
            newCapacity < minCapacity -> minCapacity
            else -> newCapacity
        }
    }
}

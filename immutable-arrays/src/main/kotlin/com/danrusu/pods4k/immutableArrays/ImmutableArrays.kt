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
import kotlin.Suppress

/**
 * Returns an empty [ImmutableArray].
 */
@Suppress("UNCHECKED_CAST")
public fun <T> emptyImmutableArray(): ImmutableArray<T> = ImmutableArray.EMPTY as ImmutableArray<T>

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
public fun <T> immutableArrayOf(vararg values: T): ImmutableArray<T> = ImmutableArray(values.size) {
        values[it] }

/**
 * Returns an [ImmutableBooleanArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Boolean): ImmutableBooleanArray =
        ImmutableBooleanArray(values.size) { values[it] }

/**
 * Returns an [ImmutableByteArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Byte): ImmutableByteArray =
        ImmutableByteArray(values.size) { values[it] }

/**
 * Returns an [ImmutableCharArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Char): ImmutableCharArray =
        ImmutableCharArray(values.size) { values[it] }

/**
 * Returns an [ImmutableShortArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Short): ImmutableShortArray =
        ImmutableShortArray(values.size) { values[it] }

/**
 * Returns an [ImmutableIntArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Int): ImmutableIntArray = ImmutableIntArray(values.size)
        { values[it] }

/**
 * Returns an [ImmutableLongArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Long): ImmutableLongArray =
        ImmutableLongArray(values.size) { values[it] }

/**
 * Returns an [ImmutableFloatArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Float): ImmutableFloatArray =
        ImmutableFloatArray(values.size) { values[it] }

/**
 * Returns an [ImmutableDoubleArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Double): ImmutableDoubleArray =
        ImmutableDoubleArray(values.size) { values[it] }

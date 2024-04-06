// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Array
import kotlin.Boolean
import kotlin.Byte
import kotlin.Char
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short

/**
 * Returns an [ImmutableArray] with the contents of this array.
 */
public fun <T> Array<T>.toImmutableArray(): ImmutableArray<T> = ImmutableArray(size) { this[it] }

/**
 * Returns an [ImmutableBooleanArray] with the contents of this array.
 */
public fun Array<Boolean>.toImmutableBooleanArray(): ImmutableBooleanArray {
    // Automatically unboxing the boxed values and storing the primitive values directly 
    return ImmutableBooleanArray(size) { this[it] }
}

/**
 * Returns an [ImmutableByteArray] with the contents of this array.
 */
public fun Array<Byte>.toImmutableByteArray(): ImmutableByteArray {
    // Automatically unboxing the boxed values and storing the primitive values directly 
    return ImmutableByteArray(size) { this[it] }
}

/**
 * Returns an [ImmutableCharArray] with the contents of this array.
 */
public fun Array<Char>.toImmutableCharArray(): ImmutableCharArray {
    // Automatically unboxing the boxed values and storing the primitive values directly 
    return ImmutableCharArray(size) { this[it] }
}

/**
 * Returns an [ImmutableShortArray] with the contents of this array.
 */
public fun Array<Short>.toImmutableShortArray(): ImmutableShortArray {
    // Automatically unboxing the boxed values and storing the primitive values directly 
    return ImmutableShortArray(size) { this[it] }
}

/**
 * Returns an [ImmutableIntArray] with the contents of this array.
 */
public fun Array<Int>.toImmutableIntArray(): ImmutableIntArray {
    // Automatically unboxing the boxed values and storing the primitive values directly 
    return ImmutableIntArray(size) { this[it] }
}

/**
 * Returns an [ImmutableLongArray] with the contents of this array.
 */
public fun Array<Long>.toImmutableLongArray(): ImmutableLongArray {
    // Automatically unboxing the boxed values and storing the primitive values directly 
    return ImmutableLongArray(size) { this[it] }
}

/**
 * Returns an [ImmutableFloatArray] with the contents of this array.
 */
public fun Array<Float>.toImmutableFloatArray(): ImmutableFloatArray {
    // Automatically unboxing the boxed values and storing the primitive values directly 
    return ImmutableFloatArray(size) { this[it] }
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of this array.
 */
public fun Array<Double>.toImmutableDoubleArray(): ImmutableDoubleArray {
    // Automatically unboxing the boxed values and storing the primitive values directly 
    return ImmutableDoubleArray(size) { this[it] }
}

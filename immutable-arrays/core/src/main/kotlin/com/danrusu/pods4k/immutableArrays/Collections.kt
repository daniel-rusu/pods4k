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
import kotlin.collections.Iterable

/**
 * Returns an [ImmutableArray] with the contents of [this] collection.
 */
public fun <T> Iterable<T>.toImmutableArray(): ImmutableArray<T> {
    if (this is Collection<T>) {
        val iterator = this.iterator()
        return ImmutableArray(size) { iterator.next() }
    }
    val values = this.toList()
    return ImmutableArray(values.size) { values[it] }
}

/**
 * Returns an [ImmutableBooleanArray] with the contents of [this] collection.
 */
public fun Iterable<Boolean>.toImmutableBooleanArray(): ImmutableBooleanArray {
    if (this is Collection<kotlin.Boolean>) {
        val iterator = this.iterator()
        return ImmutableBooleanArray(size) { iterator.next() }
    }
    val values = this.toList()
    return ImmutableBooleanArray(values.size) { values[it] }
}

/**
 * Returns an [ImmutableByteArray] with the contents of [this] collection.
 */
public fun Iterable<Byte>.toImmutableByteArray(): ImmutableByteArray {
    if (this is Collection<kotlin.Byte>) {
        val iterator = this.iterator()
        return ImmutableByteArray(size) { iterator.next() }
    }
    val values = this.toList()
    return ImmutableByteArray(values.size) { values[it] }
}

/**
 * Returns an [ImmutableCharArray] with the contents of [this] collection.
 */
public fun Iterable<Char>.toImmutableCharArray(): ImmutableCharArray {
    if (this is Collection<kotlin.Char>) {
        val iterator = this.iterator()
        return ImmutableCharArray(size) { iterator.next() }
    }
    val values = this.toList()
    return ImmutableCharArray(values.size) { values[it] }
}

/**
 * Returns an [ImmutableShortArray] with the contents of [this] collection.
 */
public fun Iterable<Short>.toImmutableShortArray(): ImmutableShortArray {
    if (this is Collection<kotlin.Short>) {
        val iterator = this.iterator()
        return ImmutableShortArray(size) { iterator.next() }
    }
    val values = this.toList()
    return ImmutableShortArray(values.size) { values[it] }
}

/**
 * Returns an [ImmutableIntArray] with the contents of [this] collection.
 */
public fun Iterable<Int>.toImmutableIntArray(): ImmutableIntArray {
    if (this is Collection<kotlin.Int>) {
        val iterator = this.iterator()
        return ImmutableIntArray(size) { iterator.next() }
    }
    val values = this.toList()
    return ImmutableIntArray(values.size) { values[it] }
}

/**
 * Returns an [ImmutableLongArray] with the contents of [this] collection.
 */
public fun Iterable<Long>.toImmutableLongArray(): ImmutableLongArray {
    if (this is Collection<kotlin.Long>) {
        val iterator = this.iterator()
        return ImmutableLongArray(size) { iterator.next() }
    }
    val values = this.toList()
    return ImmutableLongArray(values.size) { values[it] }
}

/**
 * Returns an [ImmutableFloatArray] with the contents of [this] collection.
 */
public fun Iterable<Float>.toImmutableFloatArray(): ImmutableFloatArray {
    if (this is Collection<kotlin.Float>) {
        val iterator = this.iterator()
        return ImmutableFloatArray(size) { iterator.next() }
    }
    val values = this.toList()
    return ImmutableFloatArray(values.size) { values[it] }
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of [this] collection.
 */
public fun Iterable<Double>.toImmutableDoubleArray(): ImmutableDoubleArray {
    if (this is Collection<kotlin.Double>) {
        val iterator = this.iterator()
        return ImmutableDoubleArray(size) { iterator.next() }
    }
    val values = this.toList()
    return ImmutableDoubleArray(values.size) { values[it] }
}

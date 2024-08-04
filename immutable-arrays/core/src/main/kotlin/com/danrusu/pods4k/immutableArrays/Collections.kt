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
import kotlin.collections.MutableCollection

/**
 * Returns an [ImmutableArray] with the contents of [this] collection.
 */
public fun <T> Iterable<T>.toImmutableArray(): ImmutableArray<T> {
    val initialCapacity = when (this) {
        is Collection<T> -> size
        else -> 10
    }
    return buildImmutableArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableBooleanArray] with the contents of [this] collection.
 */
public fun Iterable<Boolean>.toImmutableArray(): ImmutableBooleanArray {
    val initialCapacity = when (this) {
        is Collection<Boolean> -> size
        else -> 10
    }
    return buildImmutableBooleanArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableByteArray] with the contents of [this] collection.
 */
public fun Iterable<Byte>.toImmutableArray(): ImmutableByteArray {
    val initialCapacity = when (this) {
        is Collection<Byte> -> size
        else -> 10
    }
    return buildImmutableByteArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableCharArray] with the contents of [this] collection.
 */
public fun Iterable<Char>.toImmutableArray(): ImmutableCharArray {
    val initialCapacity = when (this) {
        is Collection<Char> -> size
        else -> 10
    }
    return buildImmutableCharArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableShortArray] with the contents of [this] collection.
 */
public fun Iterable<Short>.toImmutableArray(): ImmutableShortArray {
    val initialCapacity = when (this) {
        is Collection<Short> -> size
        else -> 10
    }
    return buildImmutableShortArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableIntArray] with the contents of [this] collection.
 */
public fun Iterable<Int>.toImmutableArray(): ImmutableIntArray {
    val initialCapacity = when (this) {
        is Collection<Int> -> size
        else -> 10
    }
    return buildImmutableIntArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableLongArray] with the contents of [this] collection.
 */
public fun Iterable<Long>.toImmutableArray(): ImmutableLongArray {
    val initialCapacity = when (this) {
        is Collection<Long> -> size
        else -> 10
    }
    return buildImmutableLongArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableFloatArray] with the contents of [this] collection.
 */
public fun Iterable<Float>.toImmutableArray(): ImmutableFloatArray {
    val initialCapacity = when (this) {
        is Collection<Float> -> size
        else -> 10
    }
    return buildImmutableFloatArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of [this] collection.
 */
public fun Iterable<Double>.toImmutableArray(): ImmutableDoubleArray {
    val initialCapacity = when (this) {
        is Collection<Double> -> size
        else -> 10
    }
    return buildImmutableDoubleArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun <T> MutableCollection<in T>.addAll(elements: ImmutableArray<T>): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Boolean>.addAll(elements: ImmutableBooleanArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Byte>.addAll(elements: ImmutableByteArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Char>.addAll(elements: ImmutableCharArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Short>.addAll(elements: ImmutableShortArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Int>.addAll(elements: ImmutableIntArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Long>.addAll(elements: ImmutableLongArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Float>.addAll(elements: ImmutableFloatArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Double>.addAll(elements: ImmutableDoubleArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

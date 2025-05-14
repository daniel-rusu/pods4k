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
import kotlin.jvm.JvmName
import kotlin.sequences.Sequence

/**
 * Returns an [ImmutableArray] with the contents of this sequence.
 */
public fun <T> Sequence<T>.toImmutableArray(): ImmutableArray<T> {
    return buildImmutableArray {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableBooleanArray] with the contents of this sequence.
 */
public fun Sequence<Boolean>.toImmutableArray(): ImmutableBooleanArray {
    return buildImmutableBooleanArray {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableByteArray] with the contents of this sequence.
 */
public fun Sequence<Byte>.toImmutableArray(): ImmutableByteArray {
    return buildImmutableByteArray {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableCharArray] with the contents of this sequence.
 */
public fun Sequence<Char>.toImmutableArray(): ImmutableCharArray {
    return buildImmutableCharArray {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableShortArray] with the contents of this sequence.
 */
public fun Sequence<Short>.toImmutableArray(): ImmutableShortArray {
    return buildImmutableShortArray {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableIntArray] with the contents of this sequence.
 */
public fun Sequence<Int>.toImmutableArray(): ImmutableIntArray {
    return buildImmutableIntArray {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableLongArray] with the contents of this sequence.
 */
public fun Sequence<Long>.toImmutableArray(): ImmutableLongArray {
    return buildImmutableLongArray {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableFloatArray] with the contents of this sequence.
 */
public fun Sequence<Float>.toImmutableArray(): ImmutableFloatArray {
    return buildImmutableFloatArray {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of this sequence.
 */
public fun Sequence<Double>.toImmutableArray(): ImmutableDoubleArray {
    return buildImmutableDoubleArray {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns a sequence of all elements from all nested Immutable Arrays in this sequence.
 *
 * The operation is _intermediate_ and _stateless_.
 */
@JvmName("flatten_ImmutableArray")
public fun <T> Sequence<ImmutableArray<T>>.flatten(): Sequence<T> {
    return map { it.asIterable() }.flatten()
}

/**
 * Returns a sequence of all elements from all nested Immutable Arrays in this sequence.
 *
 * The operation is _intermediate_ and _stateless_.
 */
@JvmName("flatten_ImmutableBooleanArray")
public fun Sequence<ImmutableBooleanArray>.flatten(): Sequence<Boolean> {
    return map { it.asIterable() }.flatten()
}

/**
 * Returns a sequence of all elements from all nested Immutable Arrays in this sequence.
 *
 * The operation is _intermediate_ and _stateless_.
 */
@JvmName("flatten_ImmutableByteArray")
public fun Sequence<ImmutableByteArray>.flatten(): Sequence<Byte> {
    return map { it.asIterable() }.flatten()
}

/**
 * Returns a sequence of all elements from all nested Immutable Arrays in this sequence.
 *
 * The operation is _intermediate_ and _stateless_.
 */
@JvmName("flatten_ImmutableCharArray")
public fun Sequence<ImmutableCharArray>.flatten(): Sequence<Char> {
    return map { it.asIterable() }.flatten()
}

/**
 * Returns a sequence of all elements from all nested Immutable Arrays in this sequence.
 *
 * The operation is _intermediate_ and _stateless_.
 */
@JvmName("flatten_ImmutableShortArray")
public fun Sequence<ImmutableShortArray>.flatten(): Sequence<Short> {
    return map { it.asIterable() }.flatten()
}

/**
 * Returns a sequence of all elements from all nested Immutable Arrays in this sequence.
 *
 * The operation is _intermediate_ and _stateless_.
 */
@JvmName("flatten_ImmutableIntArray")
public fun Sequence<ImmutableIntArray>.flatten(): Sequence<Int> {
    return map { it.asIterable() }.flatten()
}

/**
 * Returns a sequence of all elements from all nested Immutable Arrays in this sequence.
 *
 * The operation is _intermediate_ and _stateless_.
 */
@JvmName("flatten_ImmutableLongArray")
public fun Sequence<ImmutableLongArray>.flatten(): Sequence<Long> {
    return map { it.asIterable() }.flatten()
}

/**
 * Returns a sequence of all elements from all nested Immutable Arrays in this sequence.
 *
 * The operation is _intermediate_ and _stateless_.
 */
@JvmName("flatten_ImmutableFloatArray")
public fun Sequence<ImmutableFloatArray>.flatten(): Sequence<Float> {
    return map { it.asIterable() }.flatten()
}

/**
 * Returns a sequence of all elements from all nested Immutable Arrays in this sequence.
 *
 * The operation is _intermediate_ and _stateless_.
 */
@JvmName("flatten_ImmutableDoubleArray")
public fun Sequence<ImmutableDoubleArray>.flatten(): Sequence<Double> {
    return map { it.asIterable() }.flatten()
}

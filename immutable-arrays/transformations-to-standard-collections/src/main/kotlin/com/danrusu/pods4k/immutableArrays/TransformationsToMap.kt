// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Byte
import kotlin.Char
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Pair
import kotlin.Short
import kotlin.collections.Map

/**
 * See [Array.toMap]
 */
public fun <K, V> ImmutableArray<Pair<K, V>>.toMap(): Map<K, V> = asList().toMap()

/**
 * See [Array.associate]
 */
public inline fun <T, K, V> ImmutableArray<T>.associate(transform: (element: T) -> Pair<K, V>): Map<K, V> {
    return asList().associate(transform)
}

/**
 * See [Array.associate]
 */
public inline fun <K, V> ImmutableBooleanArray.associate(transform: (element: Boolean) -> Pair<K, V>): Map<K, V> {
    return asList().associate(transform)
}

/**
 * See [Array.associate]
 */
public inline fun <K, V> ImmutableByteArray.associate(transform: (element: Byte) -> Pair<K, V>): Map<K, V> {
    return asList().associate(transform)
}

/**
 * See [Array.associate]
 */
public inline fun <K, V> ImmutableCharArray.associate(transform: (element: Char) -> Pair<K, V>): Map<K, V> {
    return asList().associate(transform)
}

/**
 * See [Array.associate]
 */
public inline fun <K, V> ImmutableShortArray.associate(transform: (element: Short) -> Pair<K, V>): Map<K, V> {
    return asList().associate(transform)
}

/**
 * See [Array.associate]
 */
public inline fun <K, V> ImmutableIntArray.associate(transform: (element: Int) -> Pair<K, V>): Map<K, V> {
    return asList().associate(transform)
}

/**
 * See [Array.associate]
 */
public inline fun <K, V> ImmutableLongArray.associate(transform: (element: Long) -> Pair<K, V>): Map<K, V> {
    return asList().associate(transform)
}

/**
 * See [Array.associate]
 */
public inline fun <K, V> ImmutableFloatArray.associate(transform: (element: Float) -> Pair<K, V>): Map<K, V> {
    return asList().associate(transform)
}

/**
 * See [Array.associate]
 */
public inline fun <K, V> ImmutableDoubleArray.associate(transform: (element: Double) -> Pair<K, V>): Map<K, V> {
    return asList().associate(transform)
}

/**
 * See [Array.associateBy]
 */
public inline fun <T, K> ImmutableArray<T>.associateBy(keySelector: (element: T) -> K): Map<K, T> {
    return asList().associateBy(keySelector)
}

/**
 * See [Array.associateBy]
 */
public inline fun <K> ImmutableBooleanArray.associateBy(keySelector: (element: Boolean) -> K): Map<K, Boolean> {
    return asList().associateBy(keySelector)
}

/**
 * See [Array.associateBy]
 */
public inline fun <K> ImmutableByteArray.associateBy(keySelector: (element: Byte) -> K): Map<K, Byte> {
    return asList().associateBy(keySelector)
}

/**
 * See [Array.associateBy]
 */
public inline fun <K> ImmutableCharArray.associateBy(keySelector: (element: Char) -> K): Map<K, Char> {
    return asList().associateBy(keySelector)
}

/**
 * See [Array.associateBy]
 */
public inline fun <K> ImmutableShortArray.associateBy(keySelector: (element: Short) -> K): Map<K, Short> {
    return asList().associateBy(keySelector)
}

/**
 * See [Array.associateBy]
 */
public inline fun <K> ImmutableIntArray.associateBy(keySelector: (element: Int) -> K): Map<K, Int> {
    return asList().associateBy(keySelector)
}

/**
 * See [Array.associateBy]
 */
public inline fun <K> ImmutableLongArray.associateBy(keySelector: (element: Long) -> K): Map<K, Long> {
    return asList().associateBy(keySelector)
}

/**
 * See [Array.associateBy]
 */
public inline fun <K> ImmutableFloatArray.associateBy(keySelector: (element: Float) -> K): Map<K, Float> {
    return asList().associateBy(keySelector)
}

/**
 * See [Array.associateBy]
 */
public inline fun <K> ImmutableDoubleArray.associateBy(keySelector: (element: Double) -> K): Map<K, Double> {
    return asList().associateBy(keySelector)
}

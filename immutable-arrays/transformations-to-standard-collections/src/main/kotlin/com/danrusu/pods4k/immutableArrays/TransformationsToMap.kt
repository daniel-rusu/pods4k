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

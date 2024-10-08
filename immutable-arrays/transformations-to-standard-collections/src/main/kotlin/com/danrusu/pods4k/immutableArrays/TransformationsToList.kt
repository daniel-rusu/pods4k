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
import kotlin.collections.List
import kotlin.collections.MutableList

/**
 * See [Array.toList]
 */
public fun <T> ImmutableArray<T>.toList(): List<T> = when (size) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> this.asList()
}

/**
 * See [Array.toList]
 */
public fun ImmutableBooleanArray.toList(): List<Boolean> = when (size) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> ArrayList(this.asList())
}

/**
 * See [Array.toList]
 */
public fun ImmutableByteArray.toList(): List<Byte> = when (size) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> ArrayList(this.asList())
}

/**
 * See [Array.toList]
 */
public fun ImmutableCharArray.toList(): List<Char> = when (size) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> ArrayList(this.asList())
}

/**
 * See [Array.toList]
 */
public fun ImmutableShortArray.toList(): List<Short> = when (size) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> ArrayList(this.asList())
}

/**
 * See [Array.toList]
 */
public fun ImmutableIntArray.toList(): List<Int> = when (size) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> ArrayList(this.asList())
}

/**
 * See [Array.toList]
 */
public fun ImmutableLongArray.toList(): List<Long> = when (size) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> ArrayList(this.asList())
}

/**
 * See [Array.toList]
 */
public fun ImmutableFloatArray.toList(): List<Float> = when (size) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> ArrayList(this.asList())
}

/**
 * See [Array.toList]
 */
public fun ImmutableDoubleArray.toList(): List<Double> = when (size) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> ArrayList(this.asList())
}

/**
 * See [Array.toMutableList]
 */
public fun <T> ImmutableArray<T>.toMutableList(): MutableList<T> = ArrayList(this.asList())

/**
 * See [Array.toMutableList]
 */
public fun ImmutableBooleanArray.toMutableList(): MutableList<Boolean> = ArrayList(this.asList())

/**
 * See [Array.toMutableList]
 */
public fun ImmutableByteArray.toMutableList(): MutableList<Byte> = ArrayList(this.asList())

/**
 * See [Array.toMutableList]
 */
public fun ImmutableCharArray.toMutableList(): MutableList<Char> = ArrayList(this.asList())

/**
 * See [Array.toMutableList]
 */
public fun ImmutableShortArray.toMutableList(): MutableList<Short> = ArrayList(this.asList())

/**
 * See [Array.toMutableList]
 */
public fun ImmutableIntArray.toMutableList(): MutableList<Int> = ArrayList(this.asList())

/**
 * See [Array.toMutableList]
 */
public fun ImmutableLongArray.toMutableList(): MutableList<Long> = ArrayList(this.asList())

/**
 * See [Array.toMutableList]
 */
public fun ImmutableFloatArray.toMutableList(): MutableList<Float> = ArrayList(this.asList())

/**
 * See [Array.toMutableList]
 */
public fun ImmutableDoubleArray.toMutableList(): MutableList<Double> = ArrayList(this.asList())

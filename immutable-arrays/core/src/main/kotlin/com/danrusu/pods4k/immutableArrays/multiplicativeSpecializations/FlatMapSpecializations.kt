// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.ImmutableBooleanArray
import com.danrusu.pods4k.immutableArrays.ImmutableByteArray
import com.danrusu.pods4k.immutableArrays.ImmutableCharArray
import com.danrusu.pods4k.immutableArrays.ImmutableDoubleArray
import com.danrusu.pods4k.immutableArrays.ImmutableFloatArray
import com.danrusu.pods4k.immutableArrays.ImmutableIntArray
import com.danrusu.pods4k.immutableArrays.ImmutableLongArray
import com.danrusu.pods4k.immutableArrays.ImmutableShortArray
import kotlin.Boolean
import kotlin.Byte
import kotlin.Char
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.OverloadResolutionByLambdaReturnType
import kotlin.Short
import kotlin.collections.Iterable
import kotlin.jvm.JvmName

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableArray<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableBooleanArray): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableByteArray): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableCharArray): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableShortArray): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableIntArray): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableLongArray): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableFloatArray): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableDoubleArray): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableArray<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableBooleanArray): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableByteArray): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableCharArray): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableShortArray): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableIntArray): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableLongArray): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableFloatArray): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableDoubleArray): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableArray<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableBooleanArray): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableByteArray): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableCharArray): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableShortArray): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableIntArray): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableLongArray): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableFloatArray): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableDoubleArray): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableArray<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableBooleanArray): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableByteArray): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableCharArray): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableShortArray): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableIntArray): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableLongArray): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableFloatArray): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableDoubleArray): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableArray<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableBooleanArray): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableByteArray): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableCharArray): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableShortArray): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableIntArray): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableLongArray): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableFloatArray): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableDoubleArray): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableArray<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableBooleanArray): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableByteArray): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableCharArray): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableShortArray): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableIntArray): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableLongArray): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableFloatArray): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableDoubleArray): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableArray<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableBooleanArray): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableByteArray): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableCharArray): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableShortArray): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableIntArray): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableLongArray): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableFloatArray): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableDoubleArray): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableArray<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableBooleanArray): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableByteArray): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableCharArray): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableShortArray): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableIntArray): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableLongArray): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableFloatArray): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableDoubleArray): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableArray<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableBooleanArray): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableByteArray): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableCharArray): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableShortArray): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableIntArray): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableLongArray): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableFloatArray): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableDoubleArray): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

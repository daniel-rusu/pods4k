// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays.specializations

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
@JvmName("flatMapIndexedAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> Iterable<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> ImmutableArray<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> Iterable<Byte>,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> ImmutableByteArray,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> Iterable<Char>,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> ImmutableCharArray,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> Iterable<Short>,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> ImmutableShortArray,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> Iterable<Int>,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> ImmutableIntArray,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> Iterable<Long>,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> ImmutableLongArray,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> Iterable<Float>,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> ImmutableFloatArray,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMapIndexed(
    transform: (
        index: Int,
        element: T,
    ) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Iterable<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> ImmutableArray<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Iterable<Byte>,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> ImmutableByteArray,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Iterable<Char>,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> ImmutableCharArray,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Iterable<Short>,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> ImmutableShortArray,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Iterable<Int>,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> ImmutableIntArray,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Iterable<Long>,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> ImmutableLongArray,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Iterable<Float>,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> ImmutableFloatArray,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> Iterable<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> ImmutableArray<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> Iterable<Byte>,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> ImmutableByteArray,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> Iterable<Char>,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> ImmutableCharArray,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> Iterable<Short>,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> ImmutableShortArray,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> Iterable<Int>,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> ImmutableIntArray,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> Iterable<Long>,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> ImmutableLongArray,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> Iterable<Float>,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> ImmutableFloatArray,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Byte,
    ) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> Iterable<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> ImmutableArray<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> Iterable<Byte>,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> ImmutableByteArray,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> Iterable<Char>,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> ImmutableCharArray,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> Iterable<Short>,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> ImmutableShortArray,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> Iterable<Int>,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> ImmutableIntArray,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> Iterable<Long>,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> ImmutableLongArray,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> Iterable<Float>,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> ImmutableFloatArray,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Char,
    ) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Iterable<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> ImmutableArray<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Iterable<Byte>,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> ImmutableByteArray,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Iterable<Char>,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> ImmutableCharArray,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Iterable<Short>,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> ImmutableShortArray,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Iterable<Int>,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> ImmutableIntArray,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Iterable<Long>,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> ImmutableLongArray,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Iterable<Float>,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> ImmutableFloatArray,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> Iterable<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> ImmutableArray<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> Iterable<Byte>,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> ImmutableByteArray,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> Iterable<Char>,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> ImmutableCharArray,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> Iterable<Short>,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> ImmutableShortArray,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> Iterable<Int>,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> ImmutableIntArray,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> Iterable<Long>,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> ImmutableLongArray,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> Iterable<Float>,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> ImmutableFloatArray,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Int,
    ) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> Iterable<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> ImmutableArray<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> Iterable<Byte>,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> ImmutableByteArray,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> Iterable<Char>,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> ImmutableCharArray,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> Iterable<Short>,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> ImmutableShortArray,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> Iterable<Int>,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> ImmutableIntArray,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> Iterable<Long>,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> ImmutableLongArray,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> Iterable<Float>,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> ImmutableFloatArray,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Long,
    ) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Iterable<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> ImmutableArray<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Iterable<Byte>,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> ImmutableByteArray,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Iterable<Char>,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> ImmutableCharArray,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Iterable<Short>,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> ImmutableShortArray,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Iterable<Int>,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> ImmutableIntArray,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Iterable<Long>,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> ImmutableLongArray,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Iterable<Float>,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> ImmutableFloatArray,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedAnyIterable")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Iterable<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableArray.
 */
@JvmName("flatMapIndexedImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> ImmutableArray<R>,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedBooleanIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableBooleanArray.
 */
@JvmName("flatMapIndexedImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedByteIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Iterable<Byte>,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableByteArray.
 */
@JvmName("flatMapIndexedImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> ImmutableByteArray,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedCharIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Iterable<Char>,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableCharArray.
 */
@JvmName("flatMapIndexedImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> ImmutableCharArray,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedShortIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Iterable<Short>,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableShortArray.
 */
@JvmName("flatMapIndexedImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> ImmutableShortArray,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedIntIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Iterable<Int>,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableIntArray.
 */
@JvmName("flatMapIndexedImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> ImmutableIntArray,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedLongIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Iterable<Long>,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableLongArray.
 */
@JvmName("flatMapIndexedImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> ImmutableLongArray,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedFloatIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Iterable<Float>,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableFloatArray.
 */
@JvmName("flatMapIndexedImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> ImmutableFloatArray,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedDoubleIterable")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single
 * ImmutableDoubleArray.
 */
@JvmName("flatMapIndexedImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element -> builder.addAll(transform(index, element)) }
    return builder.build()
}

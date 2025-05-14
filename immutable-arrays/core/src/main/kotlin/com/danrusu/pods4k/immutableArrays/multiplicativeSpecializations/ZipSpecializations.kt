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
import kotlin.Pair
import kotlin.Short

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T, V> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (a: T, b: T) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <T, R> ImmutableArray<T>.zip(other: ImmutableArray<R>): ImmutableArray<Pair<T, R>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (a: T, b: T) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <T> ImmutableArray<T>.zip(other: ImmutableBooleanArray): ImmutableArray<Pair<T, Boolean>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (a: T, b: T) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <T> ImmutableArray<T>.zip(other: ImmutableByteArray): ImmutableArray<Pair<T, Byte>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (a: T, b: T) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <T> ImmutableArray<T>.zip(other: ImmutableCharArray): ImmutableArray<Pair<T, Char>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (a: T, b: T) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <T> ImmutableArray<T>.zip(other: ImmutableShortArray): ImmutableArray<Pair<T, Short>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (a: T, b: T) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <T> ImmutableArray<T>.zip(other: ImmutableIntArray): ImmutableArray<Pair<T, Int>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (a: T, b: T) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <T> ImmutableArray<T>.zip(other: ImmutableLongArray): ImmutableArray<Pair<T, Long>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (a: T, b: T) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <T> ImmutableArray<T>.zip(other: ImmutableFloatArray): ImmutableArray<Pair<T, Float>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (a: T, b: T) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <T> ImmutableArray<T>.zip(other: ImmutableDoubleArray): ImmutableArray<Pair<T, Double>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (a: Boolean, b: Boolean) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <R> ImmutableBooleanArray.zip(other: ImmutableArray<R>): ImmutableArray<Pair<Boolean, R>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (a: Boolean, b: Boolean) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableBooleanArray.zip(other: ImmutableBooleanArray): ImmutableArray<Pair<Boolean, Boolean>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (a: Boolean, b: Boolean) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableBooleanArray.zip(other: ImmutableByteArray): ImmutableArray<Pair<Boolean, Byte>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (a: Boolean, b: Boolean) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableBooleanArray.zip(other: ImmutableCharArray): ImmutableArray<Pair<Boolean, Char>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (a: Boolean, b: Boolean) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableBooleanArray.zip(other: ImmutableShortArray): ImmutableArray<Pair<Boolean, Short>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (a: Boolean, b: Boolean) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableBooleanArray.zip(other: ImmutableIntArray): ImmutableArray<Pair<Boolean, Int>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (a: Boolean, b: Boolean) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableBooleanArray.zip(other: ImmutableLongArray): ImmutableArray<Pair<Boolean, Long>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (a: Boolean, b: Boolean) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableBooleanArray.zip(other: ImmutableFloatArray): ImmutableArray<Pair<Boolean, Float>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (a: Boolean, b: Boolean) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableBooleanArray.zip(other: ImmutableDoubleArray): ImmutableArray<Pair<Boolean, Double>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (a: Byte, b: Byte) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <R> ImmutableByteArray.zip(other: ImmutableArray<R>): ImmutableArray<Pair<Byte, R>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (a: Byte, b: Byte) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableByteArray.zip(other: ImmutableBooleanArray): ImmutableArray<Pair<Byte, Boolean>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (a: Byte, b: Byte) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableByteArray.zip(other: ImmutableByteArray): ImmutableArray<Pair<Byte, Byte>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (a: Byte, b: Byte) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableByteArray.zip(other: ImmutableCharArray): ImmutableArray<Pair<Byte, Char>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (a: Byte, b: Byte) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableByteArray.zip(other: ImmutableShortArray): ImmutableArray<Pair<Byte, Short>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (a: Byte, b: Byte) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableByteArray.zip(other: ImmutableIntArray): ImmutableArray<Pair<Byte, Int>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (a: Byte, b: Byte) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableByteArray.zip(other: ImmutableLongArray): ImmutableArray<Pair<Byte, Long>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (a: Byte, b: Byte) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableByteArray.zip(other: ImmutableFloatArray): ImmutableArray<Pair<Byte, Float>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (a: Byte, b: Byte) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableByteArray.zip(other: ImmutableDoubleArray): ImmutableArray<Pair<Byte, Double>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (a: Char, b: Char) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <R> ImmutableCharArray.zip(other: ImmutableArray<R>): ImmutableArray<Pair<Char, R>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (a: Char, b: Char) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableCharArray.zip(other: ImmutableBooleanArray): ImmutableArray<Pair<Char, Boolean>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (a: Char, b: Char) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableCharArray.zip(other: ImmutableByteArray): ImmutableArray<Pair<Char, Byte>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (a: Char, b: Char) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableCharArray.zip(other: ImmutableCharArray): ImmutableArray<Pair<Char, Char>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (a: Char, b: Char) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableCharArray.zip(other: ImmutableShortArray): ImmutableArray<Pair<Char, Short>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (a: Char, b: Char) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableCharArray.zip(other: ImmutableIntArray): ImmutableArray<Pair<Char, Int>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (a: Char, b: Char) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableCharArray.zip(other: ImmutableLongArray): ImmutableArray<Pair<Char, Long>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (a: Char, b: Char) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableCharArray.zip(other: ImmutableFloatArray): ImmutableArray<Pair<Char, Float>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (a: Char, b: Char) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableCharArray.zip(other: ImmutableDoubleArray): ImmutableArray<Pair<Char, Double>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (a: Short, b: Short) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <R> ImmutableShortArray.zip(other: ImmutableArray<R>): ImmutableArray<Pair<Short, R>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (a: Short, b: Short) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableShortArray.zip(other: ImmutableBooleanArray): ImmutableArray<Pair<Short, Boolean>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (a: Short, b: Short) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableShortArray.zip(other: ImmutableByteArray): ImmutableArray<Pair<Short, Byte>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (a: Short, b: Short) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableShortArray.zip(other: ImmutableCharArray): ImmutableArray<Pair<Short, Char>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (a: Short, b: Short) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableShortArray.zip(other: ImmutableShortArray): ImmutableArray<Pair<Short, Short>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (a: Short, b: Short) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableShortArray.zip(other: ImmutableIntArray): ImmutableArray<Pair<Short, Int>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (a: Short, b: Short) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableShortArray.zip(other: ImmutableLongArray): ImmutableArray<Pair<Short, Long>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (a: Short, b: Short) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableShortArray.zip(other: ImmutableFloatArray): ImmutableArray<Pair<Short, Float>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (a: Short, b: Short) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableShortArray.zip(other: ImmutableDoubleArray): ImmutableArray<Pair<Short, Double>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (a: Int, b: Int) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <R> ImmutableIntArray.zip(other: ImmutableArray<R>): ImmutableArray<Pair<Int, R>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (a: Int, b: Int) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableIntArray.zip(other: ImmutableBooleanArray): ImmutableArray<Pair<Int, Boolean>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (a: Int, b: Int) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableIntArray.zip(other: ImmutableByteArray): ImmutableArray<Pair<Int, Byte>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (a: Int, b: Int) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableIntArray.zip(other: ImmutableCharArray): ImmutableArray<Pair<Int, Char>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (a: Int, b: Int) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableIntArray.zip(other: ImmutableShortArray): ImmutableArray<Pair<Int, Short>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (a: Int, b: Int) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableIntArray.zip(other: ImmutableIntArray): ImmutableArray<Pair<Int, Int>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (a: Int, b: Int) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableIntArray.zip(other: ImmutableLongArray): ImmutableArray<Pair<Int, Long>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (a: Int, b: Int) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableIntArray.zip(other: ImmutableFloatArray): ImmutableArray<Pair<Int, Float>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (a: Int, b: Int) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableIntArray.zip(other: ImmutableDoubleArray): ImmutableArray<Pair<Int, Double>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (a: Long, b: Long) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <R> ImmutableLongArray.zip(other: ImmutableArray<R>): ImmutableArray<Pair<Long, R>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (a: Long, b: Long) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableLongArray.zip(other: ImmutableBooleanArray): ImmutableArray<Pair<Long, Boolean>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (a: Long, b: Long) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableLongArray.zip(other: ImmutableByteArray): ImmutableArray<Pair<Long, Byte>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (a: Long, b: Long) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableLongArray.zip(other: ImmutableCharArray): ImmutableArray<Pair<Long, Char>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (a: Long, b: Long) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableLongArray.zip(other: ImmutableShortArray): ImmutableArray<Pair<Long, Short>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (a: Long, b: Long) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableLongArray.zip(other: ImmutableIntArray): ImmutableArray<Pair<Long, Int>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (a: Long, b: Long) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableLongArray.zip(other: ImmutableLongArray): ImmutableArray<Pair<Long, Long>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (a: Long, b: Long) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableLongArray.zip(other: ImmutableFloatArray): ImmutableArray<Pair<Long, Float>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (a: Long, b: Long) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableLongArray.zip(other: ImmutableDoubleArray): ImmutableArray<Pair<Long, Double>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (a: Float, b: Float) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <R> ImmutableFloatArray.zip(other: ImmutableArray<R>): ImmutableArray<Pair<Float, R>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (a: Float, b: Float) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableFloatArray.zip(other: ImmutableBooleanArray): ImmutableArray<Pair<Float, Boolean>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (a: Float, b: Float) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableFloatArray.zip(other: ImmutableByteArray): ImmutableArray<Pair<Float, Byte>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (a: Float, b: Float) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableFloatArray.zip(other: ImmutableCharArray): ImmutableArray<Pair<Float, Char>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (a: Float, b: Float) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableFloatArray.zip(other: ImmutableShortArray): ImmutableArray<Pair<Float, Short>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (a: Float, b: Float) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableFloatArray.zip(other: ImmutableIntArray): ImmutableArray<Pair<Float, Int>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (a: Float, b: Float) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableFloatArray.zip(other: ImmutableLongArray): ImmutableArray<Pair<Float, Long>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (a: Float, b: Float) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableFloatArray.zip(other: ImmutableFloatArray): ImmutableArray<Pair<Float, Float>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (a: Float, b: Float) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableFloatArray.zip(other: ImmutableDoubleArray): ImmutableArray<Pair<Float, Double>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (a: Double, b: Double) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun <R> ImmutableDoubleArray.zip(other: ImmutableArray<R>): ImmutableArray<Pair<Double, R>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (a: Double, b: Double) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableDoubleArray.zip(other: ImmutableBooleanArray): ImmutableArray<Pair<Double, Boolean>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (a: Double, b: Double) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableDoubleArray.zip(other: ImmutableByteArray): ImmutableArray<Pair<Double, Byte>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (a: Double, b: Double) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableDoubleArray.zip(other: ImmutableCharArray): ImmutableArray<Pair<Double, Char>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (a: Double, b: Double) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableDoubleArray.zip(other: ImmutableShortArray): ImmutableArray<Pair<Double, Short>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (a: Double, b: Double) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableDoubleArray.zip(other: ImmutableIntArray): ImmutableArray<Pair<Double, Int>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (a: Double, b: Double) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableDoubleArray.zip(other: ImmutableLongArray): ImmutableArray<Pair<Double, Long>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (a: Double, b: Double) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableDoubleArray.zip(other: ImmutableFloatArray): ImmutableArray<Pair<Double, Float>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of values built from the elements of [this] and [other] with the same index using
 * the provided transform function applied to each pair of elements. The result has the length of the shortest
 * Immutable Array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (a: Double, b: Double) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an Immutable Array of pairs built from the elements of [this] and [other] with the same index. The
 * result has the length of the shortest Immutable Array.
 */
public infix fun ImmutableDoubleArray.zip(other: ImmutableDoubleArray): ImmutableArray<Pair<Double, Double>> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        Pair(this[index], other[index])
    }
}

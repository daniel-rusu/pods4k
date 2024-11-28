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

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T, V> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (
        a: T,
        b: T,
    ) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (
        a: T,
        b: T,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (
        a: T,
        b: T,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (
        a: T,
        b: T,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (
        a: T,
        b: T,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (
        a: T,
        b: T,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (
        a: T,
        b: T,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (
        a: T,
        b: T,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.zip(
    other: ImmutableArray<T>,
    transform: (
        a: T,
        b: T,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
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
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (
        a: Boolean,
        b: Boolean,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (
        a: Boolean,
        b: Boolean,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (
        a: Boolean,
        b: Boolean,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (
        a: Boolean,
        b: Boolean,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (
        a: Boolean,
        b: Boolean,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (
        a: Boolean,
        b: Boolean,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (
        a: Boolean,
        b: Boolean,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.zip(
    other: ImmutableBooleanArray,
    transform: (
        a: Boolean,
        b: Boolean,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (
        a: Byte,
        b: Byte,
    ) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (
        a: Byte,
        b: Byte,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (
        a: Byte,
        b: Byte,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (
        a: Byte,
        b: Byte,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (
        a: Byte,
        b: Byte,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (
        a: Byte,
        b: Byte,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (
        a: Byte,
        b: Byte,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (
        a: Byte,
        b: Byte,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.zip(
    other: ImmutableByteArray,
    transform: (
        a: Byte,
        b: Byte,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (
        a: Char,
        b: Char,
    ) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (
        a: Char,
        b: Char,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (
        a: Char,
        b: Char,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (
        a: Char,
        b: Char,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (
        a: Char,
        b: Char,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (
        a: Char,
        b: Char,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (
        a: Char,
        b: Char,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (
        a: Char,
        b: Char,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.zip(
    other: ImmutableCharArray,
    transform: (
        a: Char,
        b: Char,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (
        a: Short,
        b: Short,
    ) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (
        a: Short,
        b: Short,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (
        a: Short,
        b: Short,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (
        a: Short,
        b: Short,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (
        a: Short,
        b: Short,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (
        a: Short,
        b: Short,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (
        a: Short,
        b: Short,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (
        a: Short,
        b: Short,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.zip(
    other: ImmutableShortArray,
    transform: (
        a: Short,
        b: Short,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (
        a: Int,
        b: Int,
    ) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (
        a: Int,
        b: Int,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (
        a: Int,
        b: Int,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (
        a: Int,
        b: Int,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (
        a: Int,
        b: Int,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (
        a: Int,
        b: Int,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (
        a: Int,
        b: Int,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (
        a: Int,
        b: Int,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.zip(
    other: ImmutableIntArray,
    transform: (
        a: Int,
        b: Int,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (
        a: Long,
        b: Long,
    ) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (
        a: Long,
        b: Long,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (
        a: Long,
        b: Long,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (
        a: Long,
        b: Long,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (
        a: Long,
        b: Long,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (
        a: Long,
        b: Long,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (
        a: Long,
        b: Long,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (
        a: Long,
        b: Long,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.zip(
    other: ImmutableLongArray,
    transform: (
        a: Long,
        b: Long,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (
        a: Float,
        b: Float,
    ) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (
        a: Float,
        b: Float,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (
        a: Float,
        b: Float,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (
        a: Float,
        b: Float,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (
        a: Float,
        b: Float,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (
        a: Float,
        b: Float,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (
        a: Float,
        b: Float,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (
        a: Float,
        b: Float,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.zip(
    other: ImmutableFloatArray,
    transform: (
        a: Float,
        b: Float,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <V> ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (
        a: Double,
        b: Double,
    ) -> V,
): ImmutableArray<V> {
    return ImmutableArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (
        a: Double,
        b: Double,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (
        a: Double,
        b: Double,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (
        a: Double,
        b: Double,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (
        a: Double,
        b: Double,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (
        a: Double,
        b: Double,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (
        a: Double,
        b: Double,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (
        a: Double,
        b: Double,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

/**
 * Returns an immutable array of values built from the elements of [this] and [other] with the same
 * index using the provided transform function applied to each pair of elements. The result has the
 * length of the shortest immutable array.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.zip(
    other: ImmutableDoubleArray,
    transform: (
        a: Double,
        b: Double,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(minOf(size, other.size)) { index ->
        transform(this[index], other[index])
    }
}

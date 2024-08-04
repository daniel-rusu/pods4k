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

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.mapIndexed(transform: (index: Int, element: T) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexed(transform: (index: Int, element: T) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexed(transform: (index: Int, element: T) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexed(transform: (index: Int, element: T) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexed(transform: (index: Int, element: T) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexed(transform: (index: Int, element: T) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexed(transform: (index: Int, element: T) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexed(transform: (index: Int, element: T) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexed(transform: (index: Int, element: T) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.mapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> R,
): ImmutableArray<R> {
    return ImmutableArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Byte,
): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Char,
): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Int,
): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Long,
): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexed(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.mapIndexed(transform: (index: Int, element: Byte) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexed(transform: (index: Int, element: Byte) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexed(transform: (index: Int, element: Byte) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexed(transform: (index: Int, element: Byte) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexed(transform: (index: Int, element: Byte) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexed(transform: (index: Int, element: Byte) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexed(transform: (index: Int, element: Byte) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexed(transform: (index: Int, element: Byte) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexed(transform: (index: Int, element: Byte) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.mapIndexed(transform: (index: Int, element: Char) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexed(transform: (index: Int, element: Char) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexed(transform: (index: Int, element: Char) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexed(transform: (index: Int, element: Char) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexed(transform: (index: Int, element: Char) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexed(transform: (index: Int, element: Char) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexed(transform: (index: Int, element: Char) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexed(transform: (index: Int, element: Char) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexed(transform: (index: Int, element: Char) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.mapIndexed(transform: (index: Int, element: Short) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexed(
    transform: (
        index: Int,
        element: Short,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexed(transform: (index: Int, element: Short) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexed(transform: (index: Int, element: Short) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexed(transform: (index: Int, element: Short) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexed(transform: (index: Int, element: Short) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexed(transform: (index: Int, element: Short) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexed(transform: (index: Int, element: Short) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexed(transform: (index: Int, element: Short) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.mapIndexed(transform: (index: Int, element: Int) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexed(transform: (index: Int, element: Int) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexed(transform: (index: Int, element: Int) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexed(transform: (index: Int, element: Int) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexed(transform: (index: Int, element: Int) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexed(transform: (index: Int, element: Int) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexed(transform: (index: Int, element: Int) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexed(transform: (index: Int, element: Int) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexed(transform: (index: Int, element: Int) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.mapIndexed(transform: (index: Int, element: Long) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexed(transform: (index: Int, element: Long) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexed(transform: (index: Int, element: Long) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexed(transform: (index: Int, element: Long) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexed(transform: (index: Int, element: Long) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexed(transform: (index: Int, element: Long) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexed(transform: (index: Int, element: Long) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexed(transform: (index: Int, element: Long) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexed(transform: (index: Int, element: Long) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.mapIndexed(transform: (index: Int, element: Float) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexed(
    transform: (
        index: Int,
        element: Float,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexed(transform: (index: Int, element: Float) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexed(transform: (index: Int, element: Float) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexed(transform: (index: Int, element: Float) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexed(transform: (index: Int, element: Float) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexed(transform: (index: Int, element: Float) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexed(transform: (index: Int, element: Float) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexed(transform: (index: Int, element: Float) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.mapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> R,
): ImmutableArray<R> {
    return ImmutableArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Boolean,
): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexed(transform: (index: Int, element: Double) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexed(transform: (index: Int, element: Double) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Short,
): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexed(transform: (index: Int, element: Double) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexed(transform: (index: Int, element: Double) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Float,
): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(it, get(it)) }
}

/**
 * Returns an immutable array containing the results of applying [transform] to each element and its
 * index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexed(
    transform: (
        index: Int,
        element: Double,
    ) -> Double,
): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(it, get(it)) }
}

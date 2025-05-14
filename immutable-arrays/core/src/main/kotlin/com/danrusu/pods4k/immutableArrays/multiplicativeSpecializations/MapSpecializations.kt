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
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.map(transform: (element: T) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.map(transform: (element: Boolean) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.map(transform: (element: Byte) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.map(transform: (element: Char) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.map(transform: (element: Short) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.map(transform: (element: Int) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.map(transform: (element: Long) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.map(transform: (element: Float) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.map(transform: (element: Double) -> R): ImmutableArray<R> {
    return ImmutableArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Byte): ImmutableByteArray {
    return ImmutableByteArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Char): ImmutableCharArray {
    return ImmutableCharArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Short): ImmutableShortArray {
    return ImmutableShortArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Int): ImmutableIntArray {
    return ImmutableIntArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Long): ImmutableLongArray {
    return ImmutableLongArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Float): ImmutableFloatArray {
    return ImmutableFloatArray(size) { transform(get(it)) }
}

/**
 * Returns an Immutable Array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { transform(get(it)) }
}

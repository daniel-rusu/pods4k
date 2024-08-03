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
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.map(transform: (element: T) -> R): ImmutableArray<R> =
    ImmutableArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Boolean): ImmutableBooleanArray = ImmutableBooleanArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Byte): ImmutableByteArray =
    ImmutableByteArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Char): ImmutableCharArray =
    ImmutableCharArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Short): ImmutableShortArray =
    ImmutableShortArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Int): ImmutableIntArray =
    ImmutableIntArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Long): ImmutableLongArray =
    ImmutableLongArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Float): ImmutableFloatArray =
    ImmutableFloatArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.map(transform: (element: T) -> Double): ImmutableDoubleArray = ImmutableDoubleArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.map(transform: (element: Boolean) -> R): ImmutableArray<R> = ImmutableArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Boolean): ImmutableBooleanArray = ImmutableBooleanArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Byte): ImmutableByteArray = ImmutableByteArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Char): ImmutableCharArray = ImmutableCharArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Short): ImmutableShortArray = ImmutableShortArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Int): ImmutableIntArray = ImmutableIntArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Long): ImmutableLongArray = ImmutableLongArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Float): ImmutableFloatArray = ImmutableFloatArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.map(transform: (element: Boolean) -> Double): ImmutableDoubleArray = ImmutableDoubleArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.map(transform: (element: Byte) -> R): ImmutableArray<R> =
    ImmutableArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Boolean): ImmutableBooleanArray = ImmutableBooleanArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Byte): ImmutableByteArray =
    ImmutableByteArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Char): ImmutableCharArray =
    ImmutableCharArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Short): ImmutableShortArray =
    ImmutableShortArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Int): ImmutableIntArray =
    ImmutableIntArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Long): ImmutableLongArray =
    ImmutableLongArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Float): ImmutableFloatArray =
    ImmutableFloatArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.map(transform: (element: Byte) -> Double): ImmutableDoubleArray = ImmutableDoubleArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.map(transform: (element: Char) -> R): ImmutableArray<R> =
    ImmutableArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Boolean): ImmutableBooleanArray = ImmutableBooleanArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Byte): ImmutableByteArray =
    ImmutableByteArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Char): ImmutableCharArray =
    ImmutableCharArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Short): ImmutableShortArray =
    ImmutableShortArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Int): ImmutableIntArray =
    ImmutableIntArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Long): ImmutableLongArray =
    ImmutableLongArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Float): ImmutableFloatArray =
    ImmutableFloatArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.map(transform: (element: Char) -> Double): ImmutableDoubleArray = ImmutableDoubleArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.map(transform: (element: Short) -> R): ImmutableArray<R> =
    ImmutableArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Boolean): ImmutableBooleanArray = ImmutableBooleanArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Byte): ImmutableByteArray =
    ImmutableByteArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Char): ImmutableCharArray =
    ImmutableCharArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Short): ImmutableShortArray = ImmutableShortArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Int): ImmutableIntArray =
    ImmutableIntArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Long): ImmutableLongArray =
    ImmutableLongArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Float): ImmutableFloatArray = ImmutableFloatArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.map(transform: (element: Short) -> Double): ImmutableDoubleArray = ImmutableDoubleArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.map(transform: (element: Int) -> R): ImmutableArray<R> =
    ImmutableArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Boolean): ImmutableBooleanArray = ImmutableBooleanArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Byte): ImmutableByteArray =
    ImmutableByteArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Char): ImmutableCharArray =
    ImmutableCharArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Short): ImmutableShortArray =
    ImmutableShortArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Int): ImmutableIntArray =
    ImmutableIntArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Long): ImmutableLongArray =
    ImmutableLongArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Float): ImmutableFloatArray =
    ImmutableFloatArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.map(transform: (element: Int) -> Double): ImmutableDoubleArray =
    ImmutableDoubleArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.map(transform: (element: Long) -> R): ImmutableArray<R> =
    ImmutableArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Boolean): ImmutableBooleanArray = ImmutableBooleanArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Byte): ImmutableByteArray =
    ImmutableByteArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Char): ImmutableCharArray =
    ImmutableCharArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Short): ImmutableShortArray =
    ImmutableShortArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Int): ImmutableIntArray =
    ImmutableIntArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Long): ImmutableLongArray =
    ImmutableLongArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Float): ImmutableFloatArray =
    ImmutableFloatArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.map(transform: (element: Long) -> Double): ImmutableDoubleArray = ImmutableDoubleArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.map(transform: (element: Float) -> R): ImmutableArray<R> =
    ImmutableArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Boolean): ImmutableBooleanArray = ImmutableBooleanArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Byte): ImmutableByteArray =
    ImmutableByteArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Char): ImmutableCharArray =
    ImmutableCharArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Short): ImmutableShortArray = ImmutableShortArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Int): ImmutableIntArray =
    ImmutableIntArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Long): ImmutableLongArray =
    ImmutableLongArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Float): ImmutableFloatArray = ImmutableFloatArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.map(transform: (element: Float) -> Double): ImmutableDoubleArray = ImmutableDoubleArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.map(transform: (element: Double) -> R): ImmutableArray<R> = ImmutableArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Boolean): ImmutableBooleanArray = ImmutableBooleanArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Byte): ImmutableByteArray = ImmutableByteArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Char): ImmutableCharArray = ImmutableCharArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Short): ImmutableShortArray = ImmutableShortArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Int): ImmutableIntArray =
    ImmutableIntArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Long): ImmutableLongArray = ImmutableLongArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Float): ImmutableFloatArray = ImmutableFloatArray(size) { transform(get(it)) }

/**
 * Returns an immutable array containing the results of applying [transform] to each element.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.map(transform: (element: Double) -> Double): ImmutableDoubleArray = ImmutableDoubleArray(size) { transform(get(it)) }

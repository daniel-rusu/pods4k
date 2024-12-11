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
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.mapNotNull(transform: (element: T) -> R?): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapNotNull(transform: (element: T) -> Boolean?): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapNotNull(transform: (element: T) -> Byte?): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapNotNull(transform: (element: T) -> Char?): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapNotNull(transform: (element: T) -> Short?): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapNotNull(transform: (element: T) -> Int?): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapNotNull(transform: (element: T) -> Long?): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapNotNull(transform: (element: T) -> Float?): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapNotNull(transform: (element: T) -> Double?): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.mapNotNull(transform: (element: Boolean) -> R?): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapNotNull(transform: (element: Boolean) -> Boolean?): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapNotNull(transform: (element: Boolean) -> Byte?): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapNotNull(transform: (element: Boolean) -> Char?): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapNotNull(transform: (element: Boolean) -> Short?): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapNotNull(transform: (element: Boolean) -> Int?): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapNotNull(transform: (element: Boolean) -> Long?): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapNotNull(transform: (element: Boolean) -> Float?): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapNotNull(transform: (element: Boolean) -> Double?): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.mapNotNull(transform: (element: Byte) -> R?): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapNotNull(transform: (element: Byte) -> Boolean?): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapNotNull(transform: (element: Byte) -> Byte?): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapNotNull(transform: (element: Byte) -> Char?): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapNotNull(transform: (element: Byte) -> Short?): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapNotNull(transform: (element: Byte) -> Int?): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapNotNull(transform: (element: Byte) -> Long?): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapNotNull(transform: (element: Byte) -> Float?): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapNotNull(transform: (element: Byte) -> Double?): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.mapNotNull(transform: (element: Char) -> R?): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapNotNull(transform: (element: Char) -> Boolean?): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapNotNull(transform: (element: Char) -> Byte?): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapNotNull(transform: (element: Char) -> Char?): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapNotNull(transform: (element: Char) -> Short?): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapNotNull(transform: (element: Char) -> Int?): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapNotNull(transform: (element: Char) -> Long?): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapNotNull(transform: (element: Char) -> Float?): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapNotNull(transform: (element: Char) -> Double?): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.mapNotNull(transform: (element: Short) -> R?): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapNotNull(transform: (element: Short) -> Boolean?): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapNotNull(transform: (element: Short) -> Byte?): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapNotNull(transform: (element: Short) -> Char?): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapNotNull(transform: (element: Short) -> Short?): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapNotNull(transform: (element: Short) -> Int?): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapNotNull(transform: (element: Short) -> Long?): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapNotNull(transform: (element: Short) -> Float?): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapNotNull(transform: (element: Short) -> Double?): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.mapNotNull(transform: (element: Int) -> R?): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapNotNull(transform: (element: Int) -> Boolean?): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapNotNull(transform: (element: Int) -> Byte?): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapNotNull(transform: (element: Int) -> Char?): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapNotNull(transform: (element: Int) -> Short?): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapNotNull(transform: (element: Int) -> Int?): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapNotNull(transform: (element: Int) -> Long?): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapNotNull(transform: (element: Int) -> Float?): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapNotNull(transform: (element: Int) -> Double?): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.mapNotNull(transform: (element: Long) -> R?): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapNotNull(transform: (element: Long) -> Boolean?): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapNotNull(transform: (element: Long) -> Byte?): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapNotNull(transform: (element: Long) -> Char?): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapNotNull(transform: (element: Long) -> Short?): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapNotNull(transform: (element: Long) -> Int?): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapNotNull(transform: (element: Long) -> Long?): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapNotNull(transform: (element: Long) -> Float?): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapNotNull(transform: (element: Long) -> Double?): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.mapNotNull(transform: (element: Float) -> R?): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapNotNull(transform: (element: Float) -> Boolean?): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapNotNull(transform: (element: Float) -> Byte?): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapNotNull(transform: (element: Float) -> Char?): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapNotNull(transform: (element: Float) -> Short?): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapNotNull(transform: (element: Float) -> Int?): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapNotNull(transform: (element: Float) -> Long?): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapNotNull(transform: (element: Float) -> Float?): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapNotNull(transform: (element: Float) -> Double?): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.mapNotNull(transform: (element: Double) -> R?): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapNotNull(transform: (element: Double) -> Boolean?): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapNotNull(transform: (element: Double) -> Byte?): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapNotNull(transform: (element: Double) -> Char?): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapNotNull(transform: (element: Double) -> Short?): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapNotNull(transform: (element: Double) -> Int?): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapNotNull(transform: (element: Double) -> Long?): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapNotNull(transform: (element: Double) -> Float?): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Transforms each element and returns an immutable array with the non-null results.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapNotNull(transform: (element: Double) -> Double?): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(size)
    forEach { element ->
        transform(element)?.let { builder.add(it) }
    }
    return builder.build()
}

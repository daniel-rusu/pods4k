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
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.mapIndexedNotNull(
    transform: (
        index: Int,
        element: T,
    ) -> R?,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexedNotNull(
    transform: (
        index: Int,
        element: T,
    ) -> Boolean?,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexedNotNull(
    transform: (
        index: Int,
        element: T,
    ) -> Byte?,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexedNotNull(
    transform: (
        index: Int,
        element: T,
    ) -> Char?,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexedNotNull(
    transform: (
        index: Int,
        element: T,
    ) -> Short?,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexedNotNull(
    transform: (
        index: Int,
        element: T,
    ) -> Int?,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexedNotNull(
    transform: (
        index: Int,
        element: T,
    ) -> Long?,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexedNotNull(
    transform: (
        index: Int,
        element: T,
    ) -> Float?,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.mapIndexedNotNull(
    transform: (
        index: Int,
        element: T,
    ) -> Double?,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Boolean,
    ) -> R?,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Boolean?,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Byte?,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Char?,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Short?,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Int?,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Long?,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Float?,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Boolean,
    ) -> Double?,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Byte,
    ) -> R?,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Byte,
    ) -> Boolean?,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Byte,
    ) -> Byte?,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Byte,
    ) -> Char?,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Byte,
    ) -> Short?,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Byte,
    ) -> Int?,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Byte,
    ) -> Long?,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Byte,
    ) -> Float?,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Byte,
    ) -> Double?,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Char,
    ) -> R?,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Char,
    ) -> Boolean?,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Char,
    ) -> Byte?,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Char,
    ) -> Char?,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Char,
    ) -> Short?,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Char,
    ) -> Int?,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Char,
    ) -> Long?,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Char,
    ) -> Float?,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Char,
    ) -> Double?,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Short,
    ) -> R?,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Short,
    ) -> Boolean?,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Short,
    ) -> Byte?,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Short,
    ) -> Char?,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Short,
    ) -> Short?,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Short,
    ) -> Int?,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Short,
    ) -> Long?,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Short,
    ) -> Float?,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Short,
    ) -> Double?,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Int,
    ) -> R?,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Int,
    ) -> Boolean?,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Int,
    ) -> Byte?,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Int,
    ) -> Char?,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Int,
    ) -> Short?,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Int,
    ) -> Int?,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Int,
    ) -> Long?,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Int,
    ) -> Float?,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Int,
    ) -> Double?,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Long,
    ) -> R?,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Long,
    ) -> Boolean?,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Long,
    ) -> Byte?,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Long,
    ) -> Char?,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Long,
    ) -> Short?,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Long,
    ) -> Int?,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Long,
    ) -> Long?,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Long,
    ) -> Float?,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Long,
    ) -> Double?,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Float,
    ) -> R?,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Float,
    ) -> Boolean?,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Float,
    ) -> Byte?,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Float,
    ) -> Char?,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Float,
    ) -> Short?,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Float,
    ) -> Int?,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Float,
    ) -> Long?,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Float,
    ) -> Float?,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Float,
    ) -> Double?,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Double,
    ) -> R?,
): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Double,
    ) -> Boolean?,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Double,
    ) -> Byte?,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Double,
    ) -> Char?,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Double,
    ) -> Short?,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Double,
    ) -> Int?,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Double,
    ) -> Long?,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Double,
    ) -> Float?,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

/**
 * Returns an immutable array containing the non-null results of applying [transform] to each
 * element and its index.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.mapIndexedNotNull(
    transform: (
        index: Int,
        element: Double,
    ) -> Double?,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEachIndexed { index, element ->
        transform(index, element)?.let { builder.add(it) }
    }
    return builder.build()
}

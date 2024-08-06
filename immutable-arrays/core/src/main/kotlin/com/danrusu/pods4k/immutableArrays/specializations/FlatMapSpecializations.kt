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

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableBooleanArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableByteArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableCharArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableShortArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableIntArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableLongArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableFloatArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into a collection and appends those collections in a single
 * ImmutableDoubleArray.
 *
 * Note that if [transform] produces an array then you'll want to use the [asList] function for
 * optimal performance instead of copying the elements into a temporary list.  That's because [asList]
 * wraps the array without copying the elements.
 */
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

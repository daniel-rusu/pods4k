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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableBooleanArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableByteArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableCharArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableShortArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableIntArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableLongArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableFloatArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableDoubleArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableBooleanArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableByteArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableCharArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableShortArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableIntArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableLongArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableFloatArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableDoubleArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableBooleanArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableByteArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableCharArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableShortArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableIntArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableLongArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableFloatArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableDoubleArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableBooleanArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableByteArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableCharArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableShortArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableIntArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableLongArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableFloatArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableDoubleArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableBooleanArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableByteArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableCharArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableShortArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableIntArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableLongArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableFloatArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableDoubleArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableBooleanArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableByteArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableCharArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableShortArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableIntArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableLongArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableFloatArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableDoubleArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableBooleanArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableByteArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableCharArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableShortArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableIntArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableLongArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableFloatArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableDoubleArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableBooleanArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableByteArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableCharArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableShortArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableIntArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableLongArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableFloatArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableDoubleArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableBooleanArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableByteArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableCharArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableShortArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableIntArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableLongArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableFloatArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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
 * Calls [transform] on each element to produce collections and appends all those collections in a
 * single ImmutableDoubleArray.
 *
 * Note that if [transform] is producing an array or immutable array then you'll want to use the
 * [asList] function for optimal performance as it wraps those results instead of copying them into a
 * temporary list.
 */
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

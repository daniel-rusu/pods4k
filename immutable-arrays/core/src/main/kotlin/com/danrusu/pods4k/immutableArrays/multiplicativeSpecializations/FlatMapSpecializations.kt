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
import com.danrusu.pods4k.immutableArrays.buildImmutableArray
import com.danrusu.pods4k.immutableArrays.buildImmutableBooleanArray
import com.danrusu.pods4k.immutableArrays.buildImmutableByteArray
import com.danrusu.pods4k.immutableArrays.buildImmutableCharArray
import com.danrusu.pods4k.immutableArrays.buildImmutableDoubleArray
import com.danrusu.pods4k.immutableArrays.buildImmutableFloatArray
import com.danrusu.pods4k.immutableArrays.buildImmutableIntArray
import com.danrusu.pods4k.immutableArrays.buildImmutableLongArray
import com.danrusu.pods4k.immutableArrays.buildImmutableShortArray
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
 * Transforms each element into a collection and appends those collections in a single ImmutableArray.
 */
@JvmName("flatMap_Iterable_GENERIC")
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableArray.
 */
@JvmName("flatMap_ImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T, R> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableArray<R>): ImmutableArray<R> {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_Iterable_BOOLEAN")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_ImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(
    transform: (element: T) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableBooleanArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableByteArray.
 */
@JvmName("flatMap_Iterable_BYTE")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableByteArray.
 */
@JvmName("flatMap_ImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableByteArray): ImmutableByteArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableByteArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableCharArray.
 */
@JvmName("flatMap_Iterable_CHAR")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableCharArray.
 */
@JvmName("flatMap_ImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableCharArray): ImmutableCharArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableCharArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableShortArray.
 */
@JvmName("flatMap_Iterable_SHORT")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableShortArray.
 */
@JvmName("flatMap_ImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableShortArray): ImmutableShortArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableShortArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableIntArray.
 */
@JvmName("flatMap_Iterable_INT")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableIntArray.
 */
@JvmName("flatMap_ImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableIntArray): ImmutableIntArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableIntArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableLongArray.
 */
@JvmName("flatMap_Iterable_LONG")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableLongArray.
 */
@JvmName("flatMap_ImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableLongArray): ImmutableLongArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableLongArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableFloatArray.
 */
@JvmName("flatMap_Iterable_FLOAT")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableFloatArray.
 */
@JvmName("flatMap_ImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableFloatArray): ImmutableFloatArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableFloatArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_Iterable_DOUBLE")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_ImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun <T> ImmutableArray<T>.flatMap(transform: (element: T) -> ImmutableDoubleArray): ImmutableDoubleArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableDoubleArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableArray.
 */
@JvmName("flatMap_Iterable_GENERIC")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableArray.
 */
@JvmName("flatMap_ImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> ImmutableArray<R>,
): ImmutableArray<R> {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_Iterable_BOOLEAN")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_ImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableBooleanArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableByteArray.
 */
@JvmName("flatMap_Iterable_BYTE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableByteArray.
 */
@JvmName("flatMap_ImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> ImmutableByteArray,
): ImmutableByteArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableByteArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableCharArray.
 */
@JvmName("flatMap_Iterable_CHAR")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableCharArray.
 */
@JvmName("flatMap_ImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> ImmutableCharArray,
): ImmutableCharArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableCharArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableShortArray.
 */
@JvmName("flatMap_Iterable_SHORT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableShortArray.
 */
@JvmName("flatMap_ImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> ImmutableShortArray,
): ImmutableShortArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableShortArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableIntArray.
 */
@JvmName("flatMap_Iterable_INT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableIntArray.
 */
@JvmName("flatMap_ImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> ImmutableIntArray): ImmutableIntArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableIntArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableLongArray.
 */
@JvmName("flatMap_Iterable_LONG")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableLongArray.
 */
@JvmName("flatMap_ImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> ImmutableLongArray,
): ImmutableLongArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableLongArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableFloatArray.
 */
@JvmName("flatMap_Iterable_FLOAT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(transform: (element: Boolean) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableFloatArray.
 */
@JvmName("flatMap_ImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> ImmutableFloatArray,
): ImmutableFloatArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableFloatArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_Iterable_DOUBLE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> Iterable<Double>,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_ImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableBooleanArray.flatMap(
    transform: (element: Boolean) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableDoubleArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableArray.
 */
@JvmName("flatMap_Iterable_GENERIC")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableArray.
 */
@JvmName("flatMap_ImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableArray<R>): ImmutableArray<R> {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_Iterable_BOOLEAN")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_ImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(
    transform: (element: Byte) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableBooleanArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableByteArray.
 */
@JvmName("flatMap_Iterable_BYTE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableByteArray.
 */
@JvmName("flatMap_ImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableByteArray): ImmutableByteArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableByteArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableCharArray.
 */
@JvmName("flatMap_Iterable_CHAR")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableCharArray.
 */
@JvmName("flatMap_ImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableCharArray): ImmutableCharArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableCharArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableShortArray.
 */
@JvmName("flatMap_Iterable_SHORT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableShortArray.
 */
@JvmName("flatMap_ImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableShortArray): ImmutableShortArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableShortArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableIntArray.
 */
@JvmName("flatMap_Iterable_INT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableIntArray.
 */
@JvmName("flatMap_ImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableIntArray): ImmutableIntArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableIntArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableLongArray.
 */
@JvmName("flatMap_Iterable_LONG")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableLongArray.
 */
@JvmName("flatMap_ImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableLongArray): ImmutableLongArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableLongArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableFloatArray.
 */
@JvmName("flatMap_Iterable_FLOAT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableFloatArray.
 */
@JvmName("flatMap_ImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableFloatArray): ImmutableFloatArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableFloatArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_Iterable_DOUBLE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_ImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableByteArray.flatMap(transform: (element: Byte) -> ImmutableDoubleArray): ImmutableDoubleArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableDoubleArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableArray.
 */
@JvmName("flatMap_Iterable_GENERIC")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableArray.
 */
@JvmName("flatMap_ImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableArray<R>): ImmutableArray<R> {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_Iterable_BOOLEAN")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_ImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(
    transform: (element: Char) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableBooleanArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableByteArray.
 */
@JvmName("flatMap_Iterable_BYTE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableByteArray.
 */
@JvmName("flatMap_ImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableByteArray): ImmutableByteArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableByteArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableCharArray.
 */
@JvmName("flatMap_Iterable_CHAR")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableCharArray.
 */
@JvmName("flatMap_ImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableCharArray): ImmutableCharArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableCharArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableShortArray.
 */
@JvmName("flatMap_Iterable_SHORT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableShortArray.
 */
@JvmName("flatMap_ImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableShortArray): ImmutableShortArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableShortArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableIntArray.
 */
@JvmName("flatMap_Iterable_INT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableIntArray.
 */
@JvmName("flatMap_ImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableIntArray): ImmutableIntArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableIntArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableLongArray.
 */
@JvmName("flatMap_Iterable_LONG")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableLongArray.
 */
@JvmName("flatMap_ImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableLongArray): ImmutableLongArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableLongArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableFloatArray.
 */
@JvmName("flatMap_Iterable_FLOAT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableFloatArray.
 */
@JvmName("flatMap_ImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableFloatArray): ImmutableFloatArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableFloatArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_Iterable_DOUBLE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_ImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableCharArray.flatMap(transform: (element: Char) -> ImmutableDoubleArray): ImmutableDoubleArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableDoubleArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableArray.
 */
@JvmName("flatMap_Iterable_GENERIC")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableArray.
 */
@JvmName("flatMap_ImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableArray<R>): ImmutableArray<R> {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_Iterable_BOOLEAN")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_ImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(
    transform: (element: Short) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableBooleanArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableByteArray.
 */
@JvmName("flatMap_Iterable_BYTE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableByteArray.
 */
@JvmName("flatMap_ImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableByteArray): ImmutableByteArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableByteArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableCharArray.
 */
@JvmName("flatMap_Iterable_CHAR")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableCharArray.
 */
@JvmName("flatMap_ImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableCharArray): ImmutableCharArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableCharArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableShortArray.
 */
@JvmName("flatMap_Iterable_SHORT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableShortArray.
 */
@JvmName("flatMap_ImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableShortArray): ImmutableShortArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableShortArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableIntArray.
 */
@JvmName("flatMap_Iterable_INT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableIntArray.
 */
@JvmName("flatMap_ImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableIntArray): ImmutableIntArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableIntArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableLongArray.
 */
@JvmName("flatMap_Iterable_LONG")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableLongArray.
 */
@JvmName("flatMap_ImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableLongArray): ImmutableLongArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableLongArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableFloatArray.
 */
@JvmName("flatMap_Iterable_FLOAT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableFloatArray.
 */
@JvmName("flatMap_ImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> ImmutableFloatArray): ImmutableFloatArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableFloatArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_Iterable_DOUBLE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(transform: (element: Short) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_ImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableShortArray.flatMap(
    transform: (element: Short) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableDoubleArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableArray.
 */
@JvmName("flatMap_Iterable_GENERIC")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableArray.
 */
@JvmName("flatMap_ImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableArray<R>): ImmutableArray<R> {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_Iterable_BOOLEAN")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_ImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableBooleanArray): ImmutableBooleanArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableBooleanArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableByteArray.
 */
@JvmName("flatMap_Iterable_BYTE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableByteArray.
 */
@JvmName("flatMap_ImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableByteArray): ImmutableByteArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableByteArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableCharArray.
 */
@JvmName("flatMap_Iterable_CHAR")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableCharArray.
 */
@JvmName("flatMap_ImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableCharArray): ImmutableCharArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableCharArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableShortArray.
 */
@JvmName("flatMap_Iterable_SHORT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableShortArray.
 */
@JvmName("flatMap_ImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableShortArray): ImmutableShortArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableShortArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableIntArray.
 */
@JvmName("flatMap_Iterable_INT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableIntArray.
 */
@JvmName("flatMap_ImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableIntArray): ImmutableIntArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableIntArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableLongArray.
 */
@JvmName("flatMap_Iterable_LONG")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableLongArray.
 */
@JvmName("flatMap_ImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableLongArray): ImmutableLongArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableLongArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableFloatArray.
 */
@JvmName("flatMap_Iterable_FLOAT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableFloatArray.
 */
@JvmName("flatMap_ImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableFloatArray): ImmutableFloatArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableFloatArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_Iterable_DOUBLE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_ImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableIntArray.flatMap(transform: (element: Int) -> ImmutableDoubleArray): ImmutableDoubleArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableDoubleArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableArray.
 */
@JvmName("flatMap_Iterable_GENERIC")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableArray.
 */
@JvmName("flatMap_ImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableArray<R>): ImmutableArray<R> {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_Iterable_BOOLEAN")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_ImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(
    transform: (element: Long) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableBooleanArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableByteArray.
 */
@JvmName("flatMap_Iterable_BYTE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableByteArray.
 */
@JvmName("flatMap_ImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableByteArray): ImmutableByteArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableByteArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableCharArray.
 */
@JvmName("flatMap_Iterable_CHAR")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableCharArray.
 */
@JvmName("flatMap_ImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableCharArray): ImmutableCharArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableCharArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableShortArray.
 */
@JvmName("flatMap_Iterable_SHORT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableShortArray.
 */
@JvmName("flatMap_ImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableShortArray): ImmutableShortArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableShortArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableIntArray.
 */
@JvmName("flatMap_Iterable_INT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableIntArray.
 */
@JvmName("flatMap_ImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableIntArray): ImmutableIntArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableIntArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableLongArray.
 */
@JvmName("flatMap_Iterable_LONG")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableLongArray.
 */
@JvmName("flatMap_ImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableLongArray): ImmutableLongArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableLongArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableFloatArray.
 */
@JvmName("flatMap_Iterable_FLOAT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableFloatArray.
 */
@JvmName("flatMap_ImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableFloatArray): ImmutableFloatArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableFloatArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_Iterable_DOUBLE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_ImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableLongArray.flatMap(transform: (element: Long) -> ImmutableDoubleArray): ImmutableDoubleArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableDoubleArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableArray.
 */
@JvmName("flatMap_Iterable_GENERIC")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableArray.
 */
@JvmName("flatMap_ImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableArray<R>): ImmutableArray<R> {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_Iterable_BOOLEAN")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Boolean>): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_ImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(
    transform: (element: Float) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableBooleanArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableByteArray.
 */
@JvmName("flatMap_Iterable_BYTE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableByteArray.
 */
@JvmName("flatMap_ImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableByteArray): ImmutableByteArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableByteArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableCharArray.
 */
@JvmName("flatMap_Iterable_CHAR")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableCharArray.
 */
@JvmName("flatMap_ImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableCharArray): ImmutableCharArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableCharArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableShortArray.
 */
@JvmName("flatMap_Iterable_SHORT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableShortArray.
 */
@JvmName("flatMap_ImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableShortArray): ImmutableShortArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableShortArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableIntArray.
 */
@JvmName("flatMap_Iterable_INT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableIntArray.
 */
@JvmName("flatMap_ImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableIntArray): ImmutableIntArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableIntArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableLongArray.
 */
@JvmName("flatMap_Iterable_LONG")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableLongArray.
 */
@JvmName("flatMap_ImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableLongArray): ImmutableLongArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableLongArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableFloatArray.
 */
@JvmName("flatMap_Iterable_FLOAT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableFloatArray.
 */
@JvmName("flatMap_ImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> ImmutableFloatArray): ImmutableFloatArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableFloatArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_Iterable_DOUBLE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(transform: (element: Float) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_ImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableFloatArray.flatMap(
    transform: (element: Float) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableDoubleArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableArray.
 */
@JvmName("flatMap_Iterable_GENERIC")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<R>): ImmutableArray<R> {
    val builder = ImmutableArray.Builder<R>()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableArray.
 */
@JvmName("flatMap_ImmutableArray")
@OverloadResolutionByLambdaReturnType
public inline fun <R> ImmutableDoubleArray.flatMap(
    transform: (element: Double) -> ImmutableArray<R>,
): ImmutableArray<R> {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_Iterable_BOOLEAN")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(
    transform: (element: Double) -> Iterable<Boolean>,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableBooleanArray.
 */
@JvmName("flatMap_ImmutableBooleanArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(
    transform: (element: Double) -> ImmutableBooleanArray,
): ImmutableBooleanArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableBooleanArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableByteArray.
 */
@JvmName("flatMap_Iterable_BYTE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Byte>): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableByteArray.
 */
@JvmName("flatMap_ImmutableByteArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableByteArray): ImmutableByteArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableByteArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableCharArray.
 */
@JvmName("flatMap_Iterable_CHAR")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Char>): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableCharArray.
 */
@JvmName("flatMap_ImmutableCharArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableCharArray): ImmutableCharArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableCharArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableShortArray.
 */
@JvmName("flatMap_Iterable_SHORT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Short>): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableShortArray.
 */
@JvmName("flatMap_ImmutableShortArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(
    transform: (element: Double) -> ImmutableShortArray,
): ImmutableShortArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableShortArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableIntArray.
 */
@JvmName("flatMap_Iterable_INT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Int>): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableIntArray.
 */
@JvmName("flatMap_ImmutableIntArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableIntArray): ImmutableIntArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableIntArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableLongArray.
 */
@JvmName("flatMap_Iterable_LONG")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Long>): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableLongArray.
 */
@JvmName("flatMap_ImmutableLongArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> ImmutableLongArray): ImmutableLongArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableLongArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableFloatArray.
 */
@JvmName("flatMap_Iterable_FLOAT")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Float>): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableFloatArray.
 */
@JvmName("flatMap_ImmutableFloatArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(
    transform: (element: Double) -> ImmutableFloatArray,
): ImmutableFloatArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableFloatArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

/**
 * Transforms each element into a collection and appends those collections in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_Iterable_DOUBLE")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(transform: (element: Double) -> Iterable<Double>): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder()
    forEach { builder.addAll(transform(it)) }
    return builder.build()
}

/**
 * Transforms each element into an immutable array and appends those arrays in a single ImmutableDoubleArray.
 */
@JvmName("flatMap_ImmutableDoubleArray")
@OverloadResolutionByLambdaReturnType
public inline fun ImmutableDoubleArray.flatMap(
    transform: (element: Double) -> ImmutableDoubleArray,
): ImmutableDoubleArray {
    var numElements = 0
    val arrays = map { element ->
        transform(element).values.also { numElements += it.size }
    }
    return buildImmutableDoubleArray(initialCapacity = numElements) {
        arrays.forEach { addAll(it) }
    }
}

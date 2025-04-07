// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import java.util.RandomAccess
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.BooleanArray
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Char
import kotlin.CharArray
import kotlin.Comparable
import kotlin.Double
import kotlin.DoubleArray
import kotlin.Float
import kotlin.FloatArray
import kotlin.Int
import kotlin.IntArray
import kotlin.Long
import kotlin.LongArray
import kotlin.Short
import kotlin.ShortArray
import kotlin.Suppress
import kotlin.collections.AbstractList
import kotlin.collections.Iterable
import kotlin.collections.List
import kotlin.jvm.JvmName

/**
 * Returns an immutable list that wraps the same backing array without copying the elements.
 */
public fun <T> ImmutableArray<T>.asList(): List<T> = object : AbstractList<T>(), RandomAccess {
    override val size: Int get() = this@asList.size
    override fun isEmpty(): Boolean = this@asList.isEmpty()
    override fun contains(element: T): Boolean = this@asList.contains(element)
    override fun get(index: Int): T = this@asList[index]
    override fun indexOf(element: T): Int = this@asList.indexOf(element)
    override fun lastIndexOf(element: T): Int = this@asList.lastIndexOf(element)
}

/**
 * Returns an immutable list that wraps the same backing array without copying the elements.
 *
 * Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is
 * because [ImmutableBooleanArray] stores primitive values whereas [List] is defined as a generic type.  If the
 * number of accesses is expected to be multiple times larger than the size of this array, then you might want
 * to consider using [toList] instead in order to copy all the elements into a standalone list and only
 * auto-box each element once.
 */
public fun ImmutableBooleanArray.asList(): List<Boolean> = object : AbstractList<Boolean>(), RandomAccess {
    override val size: Int get() = this@asList.size
    override fun isEmpty(): Boolean = this@asList.isEmpty()
    override fun contains(element: Boolean): Boolean = this@asList.contains(element)
    override fun get(index: Int): Boolean = this@asList[index]
    override fun indexOf(element: Boolean): Int = this@asList.indexOf(element)
    override fun lastIndexOf(element: Boolean): Int = this@asList.lastIndexOf(element)
}

/**
 * Returns an immutable list that wraps the same backing array without copying the elements.
 *
 * Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is
 * because [ImmutableByteArray] stores primitive values whereas [List] is defined as a generic type.  If the
 * number of accesses is expected to be multiple times larger than the size of this array, then you might want
 * to consider using [toList] instead in order to copy all the elements into a standalone list and only
 * auto-box each element once.
 */
public fun ImmutableByteArray.asList(): List<Byte> = object : AbstractList<Byte>(), RandomAccess {
    override val size: Int get() = this@asList.size
    override fun isEmpty(): Boolean = this@asList.isEmpty()
    override fun contains(element: Byte): Boolean = this@asList.contains(element)
    override fun get(index: Int): Byte = this@asList[index]
    override fun indexOf(element: Byte): Int = this@asList.indexOf(element)
    override fun lastIndexOf(element: Byte): Int = this@asList.lastIndexOf(element)
}

/**
 * Returns an immutable list that wraps the same backing array without copying the elements.
 *
 * Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is
 * because [ImmutableCharArray] stores primitive values whereas [List] is defined as a generic type.  If the
 * number of accesses is expected to be multiple times larger than the size of this array, then you might want
 * to consider using [toList] instead in order to copy all the elements into a standalone list and only
 * auto-box each element once.
 */
public fun ImmutableCharArray.asList(): List<Char> = object : AbstractList<Char>(), RandomAccess {
    override val size: Int get() = this@asList.size
    override fun isEmpty(): Boolean = this@asList.isEmpty()
    override fun contains(element: Char): Boolean = this@asList.contains(element)
    override fun get(index: Int): Char = this@asList[index]
    override fun indexOf(element: Char): Int = this@asList.indexOf(element)
    override fun lastIndexOf(element: Char): Int = this@asList.lastIndexOf(element)
}

/**
 * Returns an immutable list that wraps the same backing array without copying the elements.
 *
 * Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is
 * because [ImmutableShortArray] stores primitive values whereas [List] is defined as a generic type.  If the
 * number of accesses is expected to be multiple times larger than the size of this array, then you might want
 * to consider using [toList] instead in order to copy all the elements into a standalone list and only
 * auto-box each element once.
 */
public fun ImmutableShortArray.asList(): List<Short> = object : AbstractList<Short>(), RandomAccess {
    override val size: Int get() = this@asList.size
    override fun isEmpty(): Boolean = this@asList.isEmpty()
    override fun contains(element: Short): Boolean = this@asList.contains(element)
    override fun get(index: Int): Short = this@asList[index]
    override fun indexOf(element: Short): Int = this@asList.indexOf(element)
    override fun lastIndexOf(element: Short): Int = this@asList.lastIndexOf(element)
}

/**
 * Returns an immutable list that wraps the same backing array without copying the elements.
 *
 * Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is
 * because [ImmutableIntArray] stores primitive values whereas [List] is defined as a generic type.  If the
 * number of accesses is expected to be multiple times larger than the size of this array, then you might want
 * to consider using [toList] instead in order to copy all the elements into a standalone list and only
 * auto-box each element once.
 */
public fun ImmutableIntArray.asList(): List<Int> = object : AbstractList<Int>(), RandomAccess {
    override val size: Int get() = this@asList.size
    override fun isEmpty(): Boolean = this@asList.isEmpty()
    override fun contains(element: Int): Boolean = this@asList.contains(element)
    override fun get(index: Int): Int = this@asList[index]
    override fun indexOf(element: Int): Int = this@asList.indexOf(element)
    override fun lastIndexOf(element: Int): Int = this@asList.lastIndexOf(element)
}

/**
 * Returns an immutable list that wraps the same backing array without copying the elements.
 *
 * Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is
 * because [ImmutableLongArray] stores primitive values whereas [List] is defined as a generic type.  If the
 * number of accesses is expected to be multiple times larger than the size of this array, then you might want
 * to consider using [toList] instead in order to copy all the elements into a standalone list and only
 * auto-box each element once.
 */
public fun ImmutableLongArray.asList(): List<Long> = object : AbstractList<Long>(), RandomAccess {
    override val size: Int get() = this@asList.size
    override fun isEmpty(): Boolean = this@asList.isEmpty()
    override fun contains(element: Long): Boolean = this@asList.contains(element)
    override fun get(index: Int): Long = this@asList[index]
    override fun indexOf(element: Long): Int = this@asList.indexOf(element)
    override fun lastIndexOf(element: Long): Int = this@asList.lastIndexOf(element)
}

/**
 * Returns an immutable list that wraps the same backing array without copying the elements.
 *
 * Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is
 * because [ImmutableFloatArray] stores primitive values whereas [List] is defined as a generic type.  If the
 * number of accesses is expected to be multiple times larger than the size of this array, then you might want
 * to consider using [toList] instead in order to copy all the elements into a standalone list and only
 * auto-box each element once.
 */
public fun ImmutableFloatArray.asList(): List<Float> = object : AbstractList<Float>(), RandomAccess {
    override val size: Int get() = this@asList.size
    override fun isEmpty(): Boolean = this@asList.isEmpty()
    override fun contains(element: Float): Boolean = this@asList.contains(element)
    override fun get(index: Int): Float = this@asList[index]
    override fun indexOf(element: Float): Int = this@asList.indexOf(element)
    override fun lastIndexOf(element: Float): Int = this@asList.lastIndexOf(element)
}

/**
 * Returns an immutable list that wraps the same backing array without copying the elements.
 *
 * Note that accessing values from the resulting list will auto-box them everytime they are accessed.  This is
 * because [ImmutableDoubleArray] stores primitive values whereas [List] is defined as a generic type.  If the
 * number of accesses is expected to be multiple times larger than the size of this array, then you might want
 * to consider using [toList] instead in order to copy all the elements into a standalone list and only
 * auto-box each element once.
 */
public fun ImmutableDoubleArray.asList(): List<Double> = object : AbstractList<Double>(), RandomAccess {
    override val size: Int get() = this@asList.size
    override fun isEmpty(): Boolean = this@asList.isEmpty()
    override fun contains(element: Double): Boolean = this@asList.contains(element)
    override fun get(index: Int): Double = this@asList[index]
    override fun indexOf(element: Double): Int = this@asList.indexOf(element)
    override fun lastIndexOf(element: Double): Int = this@asList.lastIndexOf(element)
}

/**
 * See [Array.contains]
 */
public operator fun <T> ImmutableArray<T>.contains(element: T): Boolean {
    return any { it == element }
}

/**
 * See [Array.contains]
 */
public operator fun ImmutableBooleanArray.contains(element: Boolean): Boolean {
    return any { it == element }
}

/**
 * See [Array.contains]
 */
public operator fun ImmutableByteArray.contains(element: Byte): Boolean {
    return any { it == element }
}

/**
 * See [Array.contains]
 */
public operator fun ImmutableCharArray.contains(element: Char): Boolean {
    return any { it == element }
}

/**
 * See [Array.contains]
 */
public operator fun ImmutableShortArray.contains(element: Short): Boolean {
    return any { it == element }
}

/**
 * See [Array.contains]
 */
public operator fun ImmutableIntArray.contains(element: Int): Boolean {
    return any { it == element }
}

/**
 * See [Array.contains]
 */
public operator fun ImmutableLongArray.contains(element: Long): Boolean {
    return any { it == element }
}

/**
 * See [Array.contains]
 */
public operator fun ImmutableFloatArray.contains(element: Float): Boolean {
    return any { it == element }
}

/**
 * See [Array.contains]
 */
public operator fun ImmutableDoubleArray.contains(element: Double): Boolean {
    return any { it == element }
}

/**
 * See [Array.indexOf]
 */
public fun <T> ImmutableArray<T>.indexOf(element: T): Int {
    forEachIndexed { index, value -> if (value == element) return index }
    return -1
}

/**
 * See [Array.indexOf]
 */
public fun ImmutableBooleanArray.indexOf(element: Boolean): Int {
    forEachIndexed { index, value -> if (value == element) return index }
    return -1
}

/**
 * See [Array.indexOf]
 */
public fun ImmutableByteArray.indexOf(element: Byte): Int {
    forEachIndexed { index, value -> if (value == element) return index }
    return -1
}

/**
 * See [Array.indexOf]
 */
public fun ImmutableCharArray.indexOf(element: Char): Int {
    forEachIndexed { index, value -> if (value == element) return index }
    return -1
}

/**
 * See [Array.indexOf]
 */
public fun ImmutableShortArray.indexOf(element: Short): Int {
    forEachIndexed { index, value -> if (value == element) return index }
    return -1
}

/**
 * See [Array.indexOf]
 */
public fun ImmutableIntArray.indexOf(element: Int): Int {
    forEachIndexed { index, value -> if (value == element) return index }
    return -1
}

/**
 * See [Array.indexOf]
 */
public fun ImmutableLongArray.indexOf(element: Long): Int {
    forEachIndexed { index, value -> if (value == element) return index }
    return -1
}

/**
 * See [Array.indexOf]
 */
public fun ImmutableFloatArray.indexOf(element: Float): Int {
    forEachIndexed { index, value -> if (value == element) return index }
    return -1
}

/**
 * See [Array.indexOf]
 */
public fun ImmutableDoubleArray.indexOf(element: Double): Int {
    forEachIndexed { index, value -> if (value == element) return index }
    return -1
}

/**
 * See [Array.lastIndexOf]
 */
public fun <T> ImmutableArray<T>.lastIndexOf(element: T): Int {
    for (index in lastIndex downTo 0) {
        if (get(index) == element) return index
    }
    return -1
}

/**
 * See [Array.lastIndexOf]
 */
public fun ImmutableBooleanArray.lastIndexOf(element: Boolean): Int {
    for (index in lastIndex downTo 0) {
        if (get(index) == element) return index
    }
    return -1
}

/**
 * See [Array.lastIndexOf]
 */
public fun ImmutableByteArray.lastIndexOf(element: Byte): Int {
    for (index in lastIndex downTo 0) {
        if (get(index) == element) return index
    }
    return -1
}

/**
 * See [Array.lastIndexOf]
 */
public fun ImmutableCharArray.lastIndexOf(element: Char): Int {
    for (index in lastIndex downTo 0) {
        if (get(index) == element) return index
    }
    return -1
}

/**
 * See [Array.lastIndexOf]
 */
public fun ImmutableShortArray.lastIndexOf(element: Short): Int {
    for (index in lastIndex downTo 0) {
        if (get(index) == element) return index
    }
    return -1
}

/**
 * See [Array.lastIndexOf]
 */
public fun ImmutableIntArray.lastIndexOf(element: Int): Int {
    for (index in lastIndex downTo 0) {
        if (get(index) == element) return index
    }
    return -1
}

/**
 * See [Array.lastIndexOf]
 */
public fun ImmutableLongArray.lastIndexOf(element: Long): Int {
    for (index in lastIndex downTo 0) {
        if (get(index) == element) return index
    }
    return -1
}

/**
 * See [Array.lastIndexOf]
 */
public fun ImmutableFloatArray.lastIndexOf(element: Float): Int {
    for (index in lastIndex downTo 0) {
        if (get(index) == element) return index
    }
    return -1
}

/**
 * See [Array.lastIndexOf]
 */
public fun ImmutableDoubleArray.lastIndexOf(element: Double): Int {
    for (index in lastIndex downTo 0) {
        if (get(index) == element) return index
    }
    return -1
}

/**
 * See [Array.getOrElse]
 */
public inline fun <T> ImmutableArray<T>.getOrElse(index: Int, defaultValue: (index: Int) -> T): T {
    return values.getOrElse(index, defaultValue)
}

/**
 * See [Array.getOrElse]
 */
public inline fun ImmutableBooleanArray.getOrElse(index: Int, defaultValue: (index: Int) -> Boolean): Boolean {
    return values.getOrElse(index, defaultValue)
}

/**
 * See [Array.getOrElse]
 */
public inline fun ImmutableByteArray.getOrElse(index: Int, defaultValue: (index: Int) -> Byte): Byte {
    return values.getOrElse(index, defaultValue)
}

/**
 * See [Array.getOrElse]
 */
public inline fun ImmutableCharArray.getOrElse(index: Int, defaultValue: (index: Int) -> Char): Char {
    return values.getOrElse(index, defaultValue)
}

/**
 * See [Array.getOrElse]
 */
public inline fun ImmutableShortArray.getOrElse(index: Int, defaultValue: (index: Int) -> Short): Short {
    return values.getOrElse(index, defaultValue)
}

/**
 * See [Array.getOrElse]
 */
public inline fun ImmutableIntArray.getOrElse(index: Int, defaultValue: (index: Int) -> Int): Int {
    return values.getOrElse(index, defaultValue)
}

/**
 * See [Array.getOrElse]
 */
public inline fun ImmutableLongArray.getOrElse(index: Int, defaultValue: (index: Int) -> Long): Long {
    return values.getOrElse(index, defaultValue)
}

/**
 * See [Array.getOrElse]
 */
public inline fun ImmutableFloatArray.getOrElse(index: Int, defaultValue: (index: Int) -> Float): Float {
    return values.getOrElse(index, defaultValue)
}

/**
 * See [Array.getOrElse]
 */
public inline fun ImmutableDoubleArray.getOrElse(index: Int, defaultValue: (index: Int) -> Double): Double {
    return values.getOrElse(index, defaultValue)
}

/**
 * @return the smallest element
 * @throws NoSuchElementException if this ImmutableArray is empty
 */
public fun <T : Comparable<T>> ImmutableArray<T>.min(): T {
    var minValue = first()
    for (i in 1..lastIndex) {
        minValue = minOf(minValue, values[i])
    }
    return minValue
}

/**
 * @return the smallest element
 * @throws NoSuchElementException if this ImmutableBooleanArray is empty
 */
public fun ImmutableBooleanArray.min(): Boolean {
    val minBoolean = minOf(true, false)
    if (contains(minBoolean)) return minBoolean

    return first()
}

/**
 * @return the smallest element
 * @throws NoSuchElementException if this ImmutableByteArray is empty
 */
public fun ImmutableByteArray.min(): Byte {
    var minValue = first()
    for (i in 1..lastIndex) {
        minValue = minOf(minValue, values[i])
    }
    return minValue
}

/**
 * @return the smallest element
 * @throws NoSuchElementException if this ImmutableCharArray is empty
 */
public fun ImmutableCharArray.min(): Char {
    var minValue = first()
    for (i in 1..lastIndex) {
        minValue = minOf(minValue, values[i])
    }
    return minValue
}

/**
 * @return the smallest element
 * @throws NoSuchElementException if this ImmutableShortArray is empty
 */
public fun ImmutableShortArray.min(): Short {
    var minValue = first()
    for (i in 1..lastIndex) {
        minValue = minOf(minValue, values[i])
    }
    return minValue
}

/**
 * @return the smallest element
 * @throws NoSuchElementException if this ImmutableIntArray is empty
 */
public fun ImmutableIntArray.min(): Int {
    var minValue = first()
    for (i in 1..lastIndex) {
        minValue = minOf(minValue, values[i])
    }
    return minValue
}

/**
 * @return the smallest element
 * @throws NoSuchElementException if this ImmutableLongArray is empty
 */
public fun ImmutableLongArray.min(): Long {
    var minValue = first()
    for (i in 1..lastIndex) {
        minValue = minOf(minValue, values[i])
    }
    return minValue
}

/**
 * @return the smallest element
 * @throws NoSuchElementException if this ImmutableFloatArray is empty
 */
public fun ImmutableFloatArray.min(): Float {
    var minValue = first()
    for (i in 1..lastIndex) {
        minValue = minOf(minValue, values[i])
    }
    return minValue
}

/**
 * @return the smallest element
 * @throws NoSuchElementException if this ImmutableDoubleArray is empty
 */
public fun ImmutableDoubleArray.min(): Double {
    var minValue = first()
    for (i in 1..lastIndex) {
        minValue = minOf(minValue, values[i])
    }
    return minValue
}

/**
 * @return the smallest element or null if [this] is empty
 */
public fun <T : Comparable<T>> ImmutableArray<T>.minOrNull(): T? = if (isEmpty()) null else min()

/**
 * @return the smallest element or null if [this] is empty
 */
public fun ImmutableBooleanArray.minOrNull(): Boolean? = if (isEmpty()) null else min()

/**
 * @return the smallest element or null if [this] is empty
 */
public fun ImmutableByteArray.minOrNull(): Byte? = if (isEmpty()) null else min()

/**
 * @return the smallest element or null if [this] is empty
 */
public fun ImmutableCharArray.minOrNull(): Char? = if (isEmpty()) null else min()

/**
 * @return the smallest element or null if [this] is empty
 */
public fun ImmutableShortArray.minOrNull(): Short? = if (isEmpty()) null else min()

/**
 * @return the smallest element or null if [this] is empty
 */
public fun ImmutableIntArray.minOrNull(): Int? = if (isEmpty()) null else min()

/**
 * @return the smallest element or null if [this] is empty
 */
public fun ImmutableLongArray.minOrNull(): Long? = if (isEmpty()) null else min()

/**
 * @return the smallest element or null if [this] is empty
 */
public fun ImmutableFloatArray.minOrNull(): Float? = if (isEmpty()) null else min()

/**
 * @return the smallest element or null if [this] is empty
 */
public fun ImmutableDoubleArray.minOrNull(): Double? = if (isEmpty()) null else min()

/**
 * @return the largest element
 * @throws NoSuchElementException if this ImmutableArray is empty
 */
public fun <T : Comparable<T>> ImmutableArray<T>.max(): T {
    var maxValue = first()
    for (i in 1..lastIndex) {
        maxValue = maxOf(maxValue, values[i])
    }
    return maxValue
}

/**
 * @return the largest element
 * @throws NoSuchElementException if this ImmutableBooleanArray is empty
 */
public fun ImmutableBooleanArray.max(): Boolean {
    val maxBoolean = maxOf(true, false)
    if (contains(maxBoolean)) return maxBoolean

    return first()
}

/**
 * @return the largest element
 * @throws NoSuchElementException if this ImmutableByteArray is empty
 */
public fun ImmutableByteArray.max(): Byte {
    var maxValue = first()
    for (i in 1..lastIndex) {
        maxValue = maxOf(maxValue, values[i])
    }
    return maxValue
}

/**
 * @return the largest element
 * @throws NoSuchElementException if this ImmutableCharArray is empty
 */
public fun ImmutableCharArray.max(): Char {
    var maxValue = first()
    for (i in 1..lastIndex) {
        maxValue = maxOf(maxValue, values[i])
    }
    return maxValue
}

/**
 * @return the largest element
 * @throws NoSuchElementException if this ImmutableShortArray is empty
 */
public fun ImmutableShortArray.max(): Short {
    var maxValue = first()
    for (i in 1..lastIndex) {
        maxValue = maxOf(maxValue, values[i])
    }
    return maxValue
}

/**
 * @return the largest element
 * @throws NoSuchElementException if this ImmutableIntArray is empty
 */
public fun ImmutableIntArray.max(): Int {
    var maxValue = first()
    for (i in 1..lastIndex) {
        maxValue = maxOf(maxValue, values[i])
    }
    return maxValue
}

/**
 * @return the largest element
 * @throws NoSuchElementException if this ImmutableLongArray is empty
 */
public fun ImmutableLongArray.max(): Long {
    var maxValue = first()
    for (i in 1..lastIndex) {
        maxValue = maxOf(maxValue, values[i])
    }
    return maxValue
}

/**
 * @return the largest element
 * @throws NoSuchElementException if this ImmutableFloatArray is empty
 */
public fun ImmutableFloatArray.max(): Float {
    var maxValue = first()
    for (i in 1..lastIndex) {
        maxValue = maxOf(maxValue, values[i])
    }
    return maxValue
}

/**
 * @return the largest element
 * @throws NoSuchElementException if this ImmutableDoubleArray is empty
 */
public fun ImmutableDoubleArray.max(): Double {
    var maxValue = first()
    for (i in 1..lastIndex) {
        maxValue = maxOf(maxValue, values[i])
    }
    return maxValue
}

/**
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("filterNotNull_GENERIC")
@Suppress("UNCHECKED_CAST")
public fun <T : Any> ImmutableArray<T?>.filterNotNull(): ImmutableArray<T> {
    val result = ImmutableArray.Builder<T>()
    forEach { value ->
        if (value != null) {
            result.add(value)
        }
    }
    if (result.size == size) return this as ImmutableArray<T>

    return result.build()
}

/**
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("filterNotNull_BOOLEAN")
public fun ImmutableArray<Boolean?>.filterNotNull(): ImmutableBooleanArray {
    val result = ImmutableBooleanArray.Builder()
    forEach { value ->
        if (value != null) {
            result.add(value)
        }
    }
    return result.build()
}

/**
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("filterNotNull_BYTE")
public fun ImmutableArray<Byte?>.filterNotNull(): ImmutableByteArray {
    val result = ImmutableByteArray.Builder()
    forEach { value ->
        if (value != null) {
            result.add(value)
        }
    }
    return result.build()
}

/**
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("filterNotNull_CHAR")
public fun ImmutableArray<Char?>.filterNotNull(): ImmutableCharArray {
    val result = ImmutableCharArray.Builder()
    forEach { value ->
        if (value != null) {
            result.add(value)
        }
    }
    return result.build()
}

/**
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("filterNotNull_SHORT")
public fun ImmutableArray<Short?>.filterNotNull(): ImmutableShortArray {
    val result = ImmutableShortArray.Builder()
    forEach { value ->
        if (value != null) {
            result.add(value)
        }
    }
    return result.build()
}

/**
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("filterNotNull_INT")
public fun ImmutableArray<Int?>.filterNotNull(): ImmutableIntArray {
    val result = ImmutableIntArray.Builder()
    forEach { value ->
        if (value != null) {
            result.add(value)
        }
    }
    return result.build()
}

/**
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("filterNotNull_LONG")
public fun ImmutableArray<Long?>.filterNotNull(): ImmutableLongArray {
    val result = ImmutableLongArray.Builder()
    forEach { value ->
        if (value != null) {
            result.add(value)
        }
    }
    return result.build()
}

/**
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("filterNotNull_FLOAT")
public fun ImmutableArray<Float?>.filterNotNull(): ImmutableFloatArray {
    val result = ImmutableFloatArray.Builder()
    forEach { value ->
        if (value != null) {
            result.add(value)
        }
    }
    return result.build()
}

/**
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("filterNotNull_DOUBLE")
public fun ImmutableArray<Double?>.filterNotNull(): ImmutableDoubleArray {
    val result = ImmutableDoubleArray.Builder()
    forEach { value ->
        if (value != null) {
            result.add(value)
        }
    }
    return result.build()
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableArray] with all elements sorted
 * according to their natural sort order.
 *
 * The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
 */
@Suppress("UNCHECKED_CAST")
public fun <T : Comparable<T>> ImmutableArray<T>.sorted(): ImmutableArray<T> {
    if (size <= 1) return this

    val backingArray = Array<Any?>(size) { get(it) }
    backingArray.sort()
    return ImmutableArray(backingArray) as ImmutableArray<T>
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableBooleanArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableBooleanArray.sorted(): ImmutableBooleanArray {
    if (size <= 1) return this

    // match sorting order of List<Boolean>.sorted() as that relies on the compareTo method of the auto-boxed Boolean wrapper
    val minValue: Boolean = minOf(true, false)
    val numMinValues = count { it == minValue }

    val backingArray = BooleanArray(size)
    when (backingArray[0] == minValue) {
        true -> backingArray.fill(element = !minValue, fromIndex = numMinValues, toIndex = size)
        else -> backingArray.fill(element = minValue, fromIndex = 0, toIndex = numMinValues)
    }
    return ImmutableBooleanArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableByteArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableByteArray.sorted(): ImmutableByteArray {
    if (size <= 1) return this

    val backingArray = values.copyOf()
    backingArray.sort()
    return ImmutableByteArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableCharArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableCharArray.sorted(): ImmutableCharArray {
    if (size <= 1) return this

    val backingArray = values.copyOf()
    backingArray.sort()
    return ImmutableCharArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableShortArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableShortArray.sorted(): ImmutableShortArray {
    if (size <= 1) return this

    val backingArray = values.copyOf()
    backingArray.sort()
    return ImmutableShortArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableIntArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableIntArray.sorted(): ImmutableIntArray {
    if (size <= 1) return this

    val backingArray = values.copyOf()
    backingArray.sort()
    return ImmutableIntArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableLongArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableLongArray.sorted(): ImmutableLongArray {
    if (size <= 1) return this

    val backingArray = values.copyOf()
    backingArray.sort()
    return ImmutableLongArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableFloatArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableFloatArray.sorted(): ImmutableFloatArray {
    if (size <= 1) return this

    val backingArray = values.copyOf()
    backingArray.sort()
    return ImmutableFloatArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableDoubleArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableDoubleArray.sorted(): ImmutableDoubleArray {
    if (size <= 1) return this

    val backingArray = values.copyOf()
    backingArray.sort()
    return ImmutableDoubleArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableArray] with all elements sorted
 * according to their reverse natural sort order.
 *
 * The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
 */
public fun <T : Comparable<T>> ImmutableArray<T>.sortedDescending(): ImmutableArray<T> {
    if (size <= 1) return this

    return sortedWith(reverseOrder())
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableBooleanArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableBooleanArray.sortedDescending(): ImmutableBooleanArray {
    if (size <= 1) return this

    // match sorting order of List<Boolean>.sortedDescending() as that relies on the compareTo method of the auto-boxed Boolean wrapper
    val maxValue: Boolean = maxOf(true, false)
    val numMaxValues = count { it == maxValue }

    val backingArray = BooleanArray(size)
    when (backingArray[0] == maxValue) {
        true -> backingArray.fill(element = !maxValue, fromIndex = numMaxValues, toIndex = size)
        else -> backingArray.fill(element = maxValue, fromIndex = 0, toIndex = numMaxValues)
    }
    return ImmutableBooleanArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableByteArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableByteArray.sortedDescending(): ImmutableByteArray {
    if (size <= 1) return this

    val backingArray = ByteArray(size) { get(it) }
    backingArray.sort()
    backingArray.reverse()
    return ImmutableByteArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableCharArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableCharArray.sortedDescending(): ImmutableCharArray {
    if (size <= 1) return this

    val backingArray = CharArray(size) { get(it) }
    backingArray.sort()
    backingArray.reverse()
    return ImmutableCharArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableShortArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableShortArray.sortedDescending(): ImmutableShortArray {
    if (size <= 1) return this

    val backingArray = ShortArray(size) { get(it) }
    backingArray.sort()
    backingArray.reverse()
    return ImmutableShortArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableIntArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableIntArray.sortedDescending(): ImmutableIntArray {
    if (size <= 1) return this

    val backingArray = IntArray(size) { get(it) }
    backingArray.sort()
    backingArray.reverse()
    return ImmutableIntArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableLongArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableLongArray.sortedDescending(): ImmutableLongArray {
    if (size <= 1) return this

    val backingArray = LongArray(size) { get(it) }
    backingArray.sort()
    backingArray.reverse()
    return ImmutableLongArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableFloatArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableFloatArray.sortedDescending(): ImmutableFloatArray {
    if (size <= 1) return this

    val backingArray = FloatArray(size) { get(it) }
    backingArray.sort()
    backingArray.reverse()
    return ImmutableFloatArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableDoubleArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableDoubleArray.sortedDescending(): ImmutableDoubleArray {
    if (size <= 1) return this

    val backingArray = DoubleArray(size) { get(it) }
    backingArray.sort()
    backingArray.reverse()
    return ImmutableDoubleArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableArray] with the elements of [this]
 * followed by the elements of [other]
 */
@Suppress("UNCHECKED_CAST")
public operator fun <T> ImmutableArray<T>.plus(other: ImmutableArray<T>): ImmutableArray<T> = when {
    isEmpty() -> other
    other.isEmpty() -> this
    else -> ImmutableArray((this.values as Array<T>) + other.values)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableBooleanArray] with the elements of [this]
 * followed by the elements of [other]
 */
public operator fun ImmutableBooleanArray.plus(other: ImmutableBooleanArray): ImmutableBooleanArray = when {
    isEmpty() -> other
    other.isEmpty() -> this
    else -> ImmutableBooleanArray(this.values + other.values)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableByteArray] with the elements of [this]
 * followed by the elements of [other]
 */
public operator fun ImmutableByteArray.plus(other: ImmutableByteArray): ImmutableByteArray = when {
    isEmpty() -> other
    other.isEmpty() -> this
    else -> ImmutableByteArray(this.values + other.values)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableCharArray] with the elements of [this]
 * followed by the elements of [other]
 */
public operator fun ImmutableCharArray.plus(other: ImmutableCharArray): ImmutableCharArray = when {
    isEmpty() -> other
    other.isEmpty() -> this
    else -> ImmutableCharArray(this.values + other.values)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableShortArray] with the elements of [this]
 * followed by the elements of [other]
 */
public operator fun ImmutableShortArray.plus(other: ImmutableShortArray): ImmutableShortArray = when {
    isEmpty() -> other
    other.isEmpty() -> this
    else -> ImmutableShortArray(this.values + other.values)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableIntArray] with the elements of [this]
 * followed by the elements of [other]
 */
public operator fun ImmutableIntArray.plus(other: ImmutableIntArray): ImmutableIntArray = when {
    isEmpty() -> other
    other.isEmpty() -> this
    else -> ImmutableIntArray(this.values + other.values)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableLongArray] with the elements of [this]
 * followed by the elements of [other]
 */
public operator fun ImmutableLongArray.plus(other: ImmutableLongArray): ImmutableLongArray = when {
    isEmpty() -> other
    other.isEmpty() -> this
    else -> ImmutableLongArray(this.values + other.values)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableFloatArray] with the elements of [this]
 * followed by the elements of [other]
 */
public operator fun ImmutableFloatArray.plus(other: ImmutableFloatArray): ImmutableFloatArray = when {
    isEmpty() -> other
    other.isEmpty() -> this
    else -> ImmutableFloatArray(this.values + other.values)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableDoubleArray] with the elements of [this]
 * followed by the elements of [other]
 */
public operator fun ImmutableDoubleArray.plus(other: ImmutableDoubleArray): ImmutableDoubleArray = when {
    isEmpty() -> other
    other.isEmpty() -> this
    else -> ImmutableDoubleArray(this.values + other.values)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
 * builders as that's much more efficient instead of calling this function repeatedly.
 */
@Suppress("UNCHECKED_CAST")
public operator fun <T> ImmutableArray<T>.plus(element: T): ImmutableArray<T> {
    return ImmutableArray((values as Array<T>) + element)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableBooleanArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
 * builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableBooleanArray.plus(element: Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray(values + element)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableByteArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
 * builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableByteArray.plus(element: Byte): ImmutableByteArray {
    return ImmutableByteArray(values + element)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableCharArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
 * builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableCharArray.plus(element: Char): ImmutableCharArray {
    return ImmutableCharArray(values + element)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableShortArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
 * builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableShortArray.plus(element: Short): ImmutableShortArray {
    return ImmutableShortArray(values + element)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableIntArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
 * builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableIntArray.plus(element: Int): ImmutableIntArray {
    return ImmutableIntArray(values + element)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableLongArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
 * builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableLongArray.plus(element: Long): ImmutableLongArray {
    return ImmutableLongArray(values + element)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableFloatArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
 * builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableFloatArray.plus(element: Float): ImmutableFloatArray {
    return ImmutableFloatArray(values + element)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableDoubleArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or immutable array
 * builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableDoubleArray.plus(element: Double): ImmutableDoubleArray {
    return ImmutableDoubleArray(values + element)
}

/**
 * Returns an [ImmutableBooleanArray] containing the unboxed values of this array.
 *
 * [ImmutableBooleanArray] uses less memory and is faster to access as it stores the primitive values directly
 * without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Boolean>.toImmutableBooleanArray(): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { this[it] }
}

/**
 * Returns an [ImmutableByteArray] containing the unboxed values of this array.
 *
 * [ImmutableByteArray] uses less memory and is faster to access as it stores the primitive values directly
 * without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Byte>.toImmutableByteArray(): ImmutableByteArray {
    return ImmutableByteArray(size) { this[it] }
}

/**
 * Returns an [ImmutableCharArray] containing the unboxed values of this array.
 *
 * [ImmutableCharArray] uses less memory and is faster to access as it stores the primitive values directly
 * without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Char>.toImmutableCharArray(): ImmutableCharArray {
    return ImmutableCharArray(size) { this[it] }
}

/**
 * Returns an [ImmutableShortArray] containing the unboxed values of this array.
 *
 * [ImmutableShortArray] uses less memory and is faster to access as it stores the primitive values directly
 * without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Short>.toImmutableShortArray(): ImmutableShortArray {
    return ImmutableShortArray(size) { this[it] }
}

/**
 * Returns an [ImmutableIntArray] containing the unboxed values of this array.
 *
 * [ImmutableIntArray] uses less memory and is faster to access as it stores the primitive values directly
 * without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Int>.toImmutableIntArray(): ImmutableIntArray {
    return ImmutableIntArray(size) { this[it] }
}

/**
 * Returns an [ImmutableLongArray] containing the unboxed values of this array.
 *
 * [ImmutableLongArray] uses less memory and is faster to access as it stores the primitive values directly
 * without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Long>.toImmutableLongArray(): ImmutableLongArray {
    return ImmutableLongArray(size) { this[it] }
}

/**
 * Returns an [ImmutableFloatArray] containing the unboxed values of this array.
 *
 * [ImmutableFloatArray] uses less memory and is faster to access as it stores the primitive values directly
 * without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Float>.toImmutableFloatArray(): ImmutableFloatArray {
    return ImmutableFloatArray(size) { this[it] }
}

/**
 * Returns an [ImmutableDoubleArray] containing the unboxed values of this array.
 *
 * [ImmutableDoubleArray] uses less memory and is faster to access as it stores the primitive values directly
 * without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Double>.toImmutableDoubleArray(): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will be
 * auto-boxed in a wrapper object.
 */
public fun ImmutableBooleanArray.toTypedImmutableArray(): ImmutableArray<Boolean> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will be
 * auto-boxed in a wrapper object.
 */
public fun ImmutableByteArray.toTypedImmutableArray(): ImmutableArray<Byte> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will be
 * auto-boxed in a wrapper object.
 */
public fun ImmutableCharArray.toTypedImmutableArray(): ImmutableArray<Char> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will be
 * auto-boxed in a wrapper object.
 */
public fun ImmutableShortArray.toTypedImmutableArray(): ImmutableArray<Short> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will be
 * auto-boxed in a wrapper object.
 */
public fun ImmutableIntArray.toTypedImmutableArray(): ImmutableArray<Int> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will be
 * auto-boxed in a wrapper object.
 */
public fun ImmutableLongArray.toTypedImmutableArray(): ImmutableArray<Long> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will be
 * auto-boxed in a wrapper object.
 */
public fun ImmutableFloatArray.toTypedImmutableArray(): ImmutableArray<Float> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will be
 * auto-boxed in a wrapper object.
 */
public fun ImmutableDoubleArray.toTypedImmutableArray(): ImmutableArray<Double> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a regular (mutable) array with a copy of the elements.
 */
public inline fun <reified T> ImmutableArray<T>.toMutableArray(): Array<out T> = Array(size) { values[it] }

/**
 * Returns a regular (mutable) array with a copy of the elements.
 */
public fun ImmutableBooleanArray.toMutableArray(): BooleanArray = values.copyOf()

/**
 * Returns a regular (mutable) array with a copy of the elements.
 */
public fun ImmutableByteArray.toMutableArray(): ByteArray = values.copyOf()

/**
 * Returns a regular (mutable) array with a copy of the elements.
 */
public fun ImmutableCharArray.toMutableArray(): CharArray = values.copyOf()

/**
 * Returns a regular (mutable) array with a copy of the elements.
 */
public fun ImmutableShortArray.toMutableArray(): ShortArray = values.copyOf()

/**
 * Returns a regular (mutable) array with a copy of the elements.
 */
public fun ImmutableIntArray.toMutableArray(): IntArray = values.copyOf()

/**
 * Returns a regular (mutable) array with a copy of the elements.
 */
public fun ImmutableLongArray.toMutableArray(): LongArray = values.copyOf()

/**
 * Returns a regular (mutable) array with a copy of the elements.
 */
public fun ImmutableFloatArray.toMutableArray(): FloatArray = values.copyOf()

/**
 * Returns a regular (mutable) array with a copy of the elements.
 */
public fun ImmutableDoubleArray.toMutableArray(): DoubleArray = values.copyOf()

/**
 * Returns a regular (mutable) typed array with a copy of the elements.
 */
public inline fun <reified T> ImmutableArray<T>.toTypedMutableArray(): Array<out T> = Array(size) { values[it] }

/**
 * Returns a regular (mutable) typed array with a copy of the elements.
 */
public fun ImmutableBooleanArray.toTypedMutableArray(): Array<Boolean> = Array(size) { values[it] }

/**
 * Returns a regular (mutable) typed array with a copy of the elements.
 */
public fun ImmutableByteArray.toTypedMutableArray(): Array<Byte> = Array(size) { values[it] }

/**
 * Returns a regular (mutable) typed array with a copy of the elements.
 */
public fun ImmutableCharArray.toTypedMutableArray(): Array<Char> = Array(size) { values[it] }

/**
 * Returns a regular (mutable) typed array with a copy of the elements.
 */
public fun ImmutableShortArray.toTypedMutableArray(): Array<Short> = Array(size) { values[it] }

/**
 * Returns a regular (mutable) typed array with a copy of the elements.
 */
public fun ImmutableIntArray.toTypedMutableArray(): Array<Int> = Array(size) { values[it] }

/**
 * Returns a regular (mutable) typed array with a copy of the elements.
 */
public fun ImmutableLongArray.toTypedMutableArray(): Array<Long> = Array(size) { values[it] }

/**
 * Returns a regular (mutable) typed array with a copy of the elements.
 */
public fun ImmutableFloatArray.toTypedMutableArray(): Array<Float> = Array(size) { values[it] }

/**
 * Returns a regular (mutable) typed array with a copy of the elements.
 */
public fun ImmutableDoubleArray.toTypedMutableArray(): Array<Double> = Array(size) { values[it] }

/**
 * Ensures that none of the elements are null otherwise an [IllegalArgumentException] is thrown.
 *
 * Returns the same [ImmutableArray] instance cast with a non-null generic type.
 */
@Suppress("UNCHECKED_CAST")
public fun <T> ImmutableArray<T?>.requireNoNulls(): ImmutableArray<T> {
    require(null !in this) { "null element found in $this" }

    return this as ImmutableArray<T>
}

/**
 * Returns a single immutable array with all the elements from all nested collections.
 */
@JvmName("flatten_Iterable_GENERIC")
public fun <T> ImmutableArray<Iterable<T>>.flatten(): ImmutableArray<T> {
    return buildImmutableArray {
        for (nestedCollection in this@flatten) {
            this@buildImmutableArray.addAll(nestedCollection)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableArray")
public fun <T> ImmutableArray<ImmutableArray<T>>.flatten(): ImmutableArray<T> {
    return buildImmutableArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableBooleanArray")
public fun ImmutableArray<ImmutableBooleanArray>.flatten(): ImmutableBooleanArray {
    return buildImmutableBooleanArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableBooleanArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableByteArray")
public fun ImmutableArray<ImmutableByteArray>.flatten(): ImmutableByteArray {
    return buildImmutableByteArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableByteArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableCharArray")
public fun ImmutableArray<ImmutableCharArray>.flatten(): ImmutableCharArray {
    return buildImmutableCharArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableCharArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableShortArray")
public fun ImmutableArray<ImmutableShortArray>.flatten(): ImmutableShortArray {
    return buildImmutableShortArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableShortArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableIntArray")
public fun ImmutableArray<ImmutableIntArray>.flatten(): ImmutableIntArray {
    return buildImmutableIntArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableIntArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableLongArray")
public fun ImmutableArray<ImmutableLongArray>.flatten(): ImmutableLongArray {
    return buildImmutableLongArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableLongArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableFloatArray")
public fun ImmutableArray<ImmutableFloatArray>.flatten(): ImmutableFloatArray {
    return buildImmutableFloatArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableFloatArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableDoubleArray")
public fun ImmutableArray<ImmutableDoubleArray>.flatten(): ImmutableDoubleArray {
    return buildImmutableDoubleArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableDoubleArray.addAll(nestedArray)
        }
    }
}

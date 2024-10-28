// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import java.lang.IllegalArgumentException
import java.util.Arrays
import java.util.RandomAccess
import kotlin.Any
import kotlin.Boolean
import kotlin.Byte
import kotlin.Char
import kotlin.Comparable
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short
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
 * Note that accessing values from the resulting list will auto-box them everytime they are
 * accessed.  This is because [ImmutableBooleanArray] stores primitive values whereas [List] is defined
 * as a generic type.  If the number of accesses is expected to be multiple times larger than the size
 * of this array, then you might want to consider using [toList] instead in order to copy all the
 * elements into a standalone list and only auto-box each element once.
 */
public fun ImmutableBooleanArray.asList(): List<Boolean> = object :
    AbstractList<Boolean>(),
    RandomAccess {
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
 * Note that accessing values from the resulting list will auto-box them everytime they are
 * accessed.  This is because [ImmutableByteArray] stores primitive values whereas [List] is defined as
 * a generic type.  If the number of accesses is expected to be multiple times larger than the size of
 * this array, then you might want to consider using [toList] instead in order to copy all the elements
 * into a standalone list and only auto-box each element once.
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
 * Note that accessing values from the resulting list will auto-box them everytime they are
 * accessed.  This is because [ImmutableCharArray] stores primitive values whereas [List] is defined as
 * a generic type.  If the number of accesses is expected to be multiple times larger than the size of
 * this array, then you might want to consider using [toList] instead in order to copy all the elements
 * into a standalone list and only auto-box each element once.
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
 * Note that accessing values from the resulting list will auto-box them everytime they are
 * accessed.  This is because [ImmutableShortArray] stores primitive values whereas [List] is defined
 * as a generic type.  If the number of accesses is expected to be multiple times larger than the size
 * of this array, then you might want to consider using [toList] instead in order to copy all the
 * elements into a standalone list and only auto-box each element once.
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
 * Note that accessing values from the resulting list will auto-box them everytime they are
 * accessed.  This is because [ImmutableIntArray] stores primitive values whereas [List] is defined as
 * a generic type.  If the number of accesses is expected to be multiple times larger than the size of
 * this array, then you might want to consider using [toList] instead in order to copy all the elements
 * into a standalone list and only auto-box each element once.
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
 * Note that accessing values from the resulting list will auto-box them everytime they are
 * accessed.  This is because [ImmutableLongArray] stores primitive values whereas [List] is defined as
 * a generic type.  If the number of accesses is expected to be multiple times larger than the size of
 * this array, then you might want to consider using [toList] instead in order to copy all the elements
 * into a standalone list and only auto-box each element once.
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
 * Note that accessing values from the resulting list will auto-box them everytime they are
 * accessed.  This is because [ImmutableFloatArray] stores primitive values whereas [List] is defined
 * as a generic type.  If the number of accesses is expected to be multiple times larger than the size
 * of this array, then you might want to consider using [toList] instead in order to copy all the
 * elements into a standalone list and only auto-box each element once.
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
 * Note that accessing values from the resulting list will auto-box them everytime they are
 * accessed.  This is because [ImmutableDoubleArray] stores primitive values whereas [List] is defined
 * as a generic type.  If the number of accesses is expected to be multiple times larger than the size
 * of this array, then you might want to consider using [toList] instead in order to copy all the
 * elements into a standalone list and only auto-box each element once.
 */
public fun ImmutableDoubleArray.asList(): List<Double> = object :
    AbstractList<Double>(),
    RandomAccess {
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
public inline fun ImmutableBooleanArray.getOrElse(
    index: Int,
    defaultValue: (index: Int) -> Boolean,
): Boolean {
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
 * Returns an immutable array containing only the non-null elements
 */
@JvmName("immutableArrayFilterNotNull")
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
@JvmName("immutableArrayFilterNotNull_Boolean")
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
@JvmName("immutableArrayFilterNotNull_Byte")
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
@JvmName("immutableArrayFilterNotNull_Char")
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
@JvmName("immutableArrayFilterNotNull_Short")
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
@JvmName("immutableArrayFilterNotNull_Int")
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
@JvmName("immutableArrayFilterNotNull_Long")
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
@JvmName("immutableArrayFilterNotNull_Float")
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
@JvmName("immutableArrayFilterNotNull_Double")
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
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = Array<Any?>(size) { get(it) }
    Arrays.sort(backingArray)
    return ImmutableArray(backingArray) as ImmutableArray<T>
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableByteArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableByteArray.sorted(): ImmutableByteArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = ByteArray(size)
    System.arraycopy(values, 0, backingArray, 0, size)
    Arrays.sort(backingArray)
    return ImmutableByteArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableCharArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableCharArray.sorted(): ImmutableCharArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = CharArray(size)
    System.arraycopy(values, 0, backingArray, 0, size)
    Arrays.sort(backingArray)
    return ImmutableCharArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableShortArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableShortArray.sorted(): ImmutableShortArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = ShortArray(size)
    System.arraycopy(values, 0, backingArray, 0, size)
    Arrays.sort(backingArray)
    return ImmutableShortArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableIntArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableIntArray.sorted(): ImmutableIntArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = IntArray(size)
    System.arraycopy(values, 0, backingArray, 0, size)
    Arrays.sort(backingArray)
    return ImmutableIntArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableLongArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableLongArray.sorted(): ImmutableLongArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = LongArray(size)
    System.arraycopy(values, 0, backingArray, 0, size)
    Arrays.sort(backingArray)
    return ImmutableLongArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableFloatArray] with all elements sorted
 * according to their natural sort order.
 */
public fun ImmutableFloatArray.sorted(): ImmutableFloatArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = FloatArray(size)
    System.arraycopy(values, 0, backingArray, 0, size)
    Arrays.sort(backingArray)
    return ImmutableFloatArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableDoubleArray] with all elements
 * sorted according to their natural sort order.
 */
public fun ImmutableDoubleArray.sorted(): ImmutableDoubleArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = DoubleArray(size)
    System.arraycopy(values, 0, backingArray, 0, size)
    Arrays.sort(backingArray)
    return ImmutableDoubleArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableArray] with all elements sorted
 * according to their reverse natural sort order.
 *
 * The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
 */
public fun <T : Comparable<T>> ImmutableArray<T>.sortedDescending(): ImmutableArray<T> {
    return sortedWith(reverseOrder())
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableByteArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableByteArray.sortedDescending(): ImmutableByteArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = ByteArray(size) { get(it) }
    Arrays.sort(backingArray)
    backingArray.reverse()
    return ImmutableByteArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableCharArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableCharArray.sortedDescending(): ImmutableCharArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = CharArray(size) { get(it) }
    Arrays.sort(backingArray)
    backingArray.reverse()
    return ImmutableCharArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableShortArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableShortArray.sortedDescending(): ImmutableShortArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = ShortArray(size) { get(it) }
    Arrays.sort(backingArray)
    backingArray.reverse()
    return ImmutableShortArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableIntArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableIntArray.sortedDescending(): ImmutableIntArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = IntArray(size) { get(it) }
    Arrays.sort(backingArray)
    backingArray.reverse()
    return ImmutableIntArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableLongArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableLongArray.sortedDescending(): ImmutableLongArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = LongArray(size) { get(it) }
    Arrays.sort(backingArray)
    backingArray.reverse()
    return ImmutableLongArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableFloatArray] with all elements sorted
 * according to their reverse natural sort order.
 */
public fun ImmutableFloatArray.sortedDescending(): ImmutableFloatArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = FloatArray(size) { get(it) }
    Arrays.sort(backingArray)
    backingArray.reverse()
    return ImmutableFloatArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableDoubleArray] with all elements
 * sorted according to their reverse natural sort order.
 */
public fun ImmutableDoubleArray.sortedDescending(): ImmutableDoubleArray {
    // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
    if (size <= 1) return this

    val backingArray = DoubleArray(size) { get(it) }
    Arrays.sort(backingArray)
    backingArray.reverse()
    return ImmutableDoubleArray(backingArray)
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableArray] with the elements of [this]
 * followed by the elements of [other]
 */
public operator fun <T> ImmutableArray<T>.plus(other: ImmutableArray<T>): ImmutableArray<T> {
    when {
        isEmpty() -> return other
        other.isEmpty() -> return this
    }
    return buildImmutableArray(initialCapacity = size + other.size) {
        addAll(this@plus)
        addAll(other)
    }
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableBooleanArray] with the elements of
 * [this] followed by the elements of [other]
 */
public operator fun ImmutableBooleanArray.plus(other: ImmutableBooleanArray): ImmutableBooleanArray {
    when {
        isEmpty() -> return other
        other.isEmpty() -> return this
    }
    return buildImmutableBooleanArray(initialCapacity = size + other.size) {
        addAll(this@plus)
        addAll(other)
    }
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableByteArray] with the elements of
 * [this] followed by the elements of [other]
 */
public operator fun ImmutableByteArray.plus(other: ImmutableByteArray): ImmutableByteArray {
    when {
        isEmpty() -> return other
        other.isEmpty() -> return this
    }
    return buildImmutableByteArray(initialCapacity = size + other.size) {
        addAll(this@plus)
        addAll(other)
    }
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableCharArray] with the elements of
 * [this] followed by the elements of [other]
 */
public operator fun ImmutableCharArray.plus(other: ImmutableCharArray): ImmutableCharArray {
    when {
        isEmpty() -> return other
        other.isEmpty() -> return this
    }
    return buildImmutableCharArray(initialCapacity = size + other.size) {
        addAll(this@plus)
        addAll(other)
    }
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableShortArray] with the elements of
 * [this] followed by the elements of [other]
 */
public operator fun ImmutableShortArray.plus(other: ImmutableShortArray): ImmutableShortArray {
    when {
        isEmpty() -> return other
        other.isEmpty() -> return this
    }
    return buildImmutableShortArray(initialCapacity = size + other.size) {
        addAll(this@plus)
        addAll(other)
    }
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableIntArray] with the elements of
 * [this] followed by the elements of [other]
 */
public operator fun ImmutableIntArray.plus(other: ImmutableIntArray): ImmutableIntArray {
    when {
        isEmpty() -> return other
        other.isEmpty() -> return this
    }
    return buildImmutableIntArray(initialCapacity = size + other.size) {
        addAll(this@plus)
        addAll(other)
    }
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableLongArray] with the elements of
 * [this] followed by the elements of [other]
 */
public operator fun ImmutableLongArray.plus(other: ImmutableLongArray): ImmutableLongArray {
    when {
        isEmpty() -> return other
        other.isEmpty() -> return this
    }
    return buildImmutableLongArray(initialCapacity = size + other.size) {
        addAll(this@plus)
        addAll(other)
    }
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableFloatArray] with the elements of
 * [this] followed by the elements of [other]
 */
public operator fun ImmutableFloatArray.plus(other: ImmutableFloatArray): ImmutableFloatArray {
    when {
        isEmpty() -> return other
        other.isEmpty() -> return this
    }
    return buildImmutableFloatArray(initialCapacity = size + other.size) {
        addAll(this@plus)
        addAll(other)
    }
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableDoubleArray] with the elements of
 * [this] followed by the elements of [other]
 */
public operator fun ImmutableDoubleArray.plus(other: ImmutableDoubleArray): ImmutableDoubleArray {
    when {
        isEmpty() -> return other
        other.isEmpty() -> return this
    }
    return buildImmutableDoubleArray(initialCapacity = size + other.size) {
        addAll(this@plus)
        addAll(other)
    }
}

/**
 * Leaves [this] immutable array as is and returns an [ImmutableArray] with the elements of [this]
 * followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or
 * immutable array builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun <T> ImmutableArray<T>.plus(element: T): ImmutableArray<T> =
    buildImmutableArray(initialCapacity = size + 1) {
        addAll(this@plus)
        add(element)
    }

/**
 * Leaves [this] immutable array as is and returns an [ImmutableBooleanArray] with the elements of
 * [this] followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or
 * immutable array builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableBooleanArray.plus(element: Boolean): ImmutableBooleanArray =
    buildImmutableBooleanArray(initialCapacity = size + 1) {
        addAll(this@plus)
        add(element)
    }

/**
 * Leaves [this] immutable array as is and returns an [ImmutableByteArray] with the elements of
 * [this] followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or
 * immutable array builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableByteArray.plus(element: Byte): ImmutableByteArray =
    buildImmutableByteArray(initialCapacity = size + 1) {
        addAll(this@plus)
        add(element)
    }

/**
 * Leaves [this] immutable array as is and returns an [ImmutableCharArray] with the elements of
 * [this] followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or
 * immutable array builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableCharArray.plus(element: Char): ImmutableCharArray =
    buildImmutableCharArray(initialCapacity = size + 1) {
        addAll(this@plus)
        add(element)
    }

/**
 * Leaves [this] immutable array as is and returns an [ImmutableShortArray] with the elements of
 * [this] followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or
 * immutable array builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableShortArray.plus(element: Short): ImmutableShortArray =
    buildImmutableShortArray(initialCapacity = size + 1) {
        addAll(this@plus)
        add(element)
    }

/**
 * Leaves [this] immutable array as is and returns an [ImmutableIntArray] with the elements of
 * [this] followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or
 * immutable array builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableIntArray.plus(element: Int): ImmutableIntArray =
    buildImmutableIntArray(initialCapacity = size + 1) {
        addAll(this@plus)
        add(element)
    }

/**
 * Leaves [this] immutable array as is and returns an [ImmutableLongArray] with the elements of
 * [this] followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or
 * immutable array builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableLongArray.plus(element: Long): ImmutableLongArray =
    buildImmutableLongArray(initialCapacity = size + 1) {
        addAll(this@plus)
        add(element)
    }

/**
 * Leaves [this] immutable array as is and returns an [ImmutableFloatArray] with the elements of
 * [this] followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or
 * immutable array builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableFloatArray.plus(element: Float): ImmutableFloatArray =
    buildImmutableFloatArray(initialCapacity = size + 1) {
        addAll(this@plus)
        add(element)
    }

/**
 * Leaves [this] immutable array as is and returns an [ImmutableDoubleArray] with the elements of
 * [this] followed by the specified [element].
 *
 * Important:
 * When needing to add multiple elements individually, use the buildImmutableArray methods or
 * immutable array builders as that's much more efficient instead of calling this function repeatedly.
 */
public operator fun ImmutableDoubleArray.plus(element: Double): ImmutableDoubleArray =
    buildImmutableDoubleArray(initialCapacity = size + 1) {
        addAll(this@plus)
        add(element)
    }

/**
 * Returns an [ImmutableBooleanArray] containing the unboxed values of this array.
 *
 * [ImmutableBooleanArray] uses less memory and is faster to access as it stores the primitive
 * values directly without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Boolean>.toImmutableBooleanArray(): ImmutableBooleanArray {
    return ImmutableBooleanArray(size) { this[it] }
}

/**
 * Returns an [ImmutableByteArray] containing the unboxed values of this array.
 *
 * [ImmutableByteArray] uses less memory and is faster to access as it stores the primitive values
 * directly without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Byte>.toImmutableByteArray(): ImmutableByteArray {
    return ImmutableByteArray(size) { this[it] }
}

/**
 * Returns an [ImmutableCharArray] containing the unboxed values of this array.
 *
 * [ImmutableCharArray] uses less memory and is faster to access as it stores the primitive values
 * directly without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Char>.toImmutableCharArray(): ImmutableCharArray {
    return ImmutableCharArray(size) { this[it] }
}

/**
 * Returns an [ImmutableShortArray] containing the unboxed values of this array.
 *
 * [ImmutableShortArray] uses less memory and is faster to access as it stores the primitive values
 * directly without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Short>.toImmutableShortArray(): ImmutableShortArray {
    return ImmutableShortArray(size) { this[it] }
}

/**
 * Returns an [ImmutableIntArray] containing the unboxed values of this array.
 *
 * [ImmutableIntArray] uses less memory and is faster to access as it stores the primitive values
 * directly without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Int>.toImmutableIntArray(): ImmutableIntArray {
    return ImmutableIntArray(size) { this[it] }
}

/**
 * Returns an [ImmutableLongArray] containing the unboxed values of this array.
 *
 * [ImmutableLongArray] uses less memory and is faster to access as it stores the primitive values
 * directly without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Long>.toImmutableLongArray(): ImmutableLongArray {
    return ImmutableLongArray(size) { this[it] }
}

/**
 * Returns an [ImmutableFloatArray] containing the unboxed values of this array.
 *
 * [ImmutableFloatArray] uses less memory and is faster to access as it stores the primitive values
 * directly without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Float>.toImmutableFloatArray(): ImmutableFloatArray {
    return ImmutableFloatArray(size) { this[it] }
}

/**
 * Returns an [ImmutableDoubleArray] containing the unboxed values of this array.
 *
 * [ImmutableDoubleArray] uses less memory and is faster to access as it stores the primitive values
 * directly without needing to store them in wrapper objects.
 */
public fun ImmutableArray<Double>.toImmutableDoubleArray(): ImmutableDoubleArray {
    return ImmutableDoubleArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will
 * be auto-boxed in a wrapper object.
 */
public fun ImmutableBooleanArray.toTypedImmutableArray(): ImmutableArray<Boolean> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will
 * be auto-boxed in a wrapper object.
 */
public fun ImmutableByteArray.toTypedImmutableArray(): ImmutableArray<Byte> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will
 * be auto-boxed in a wrapper object.
 */
public fun ImmutableCharArray.toTypedImmutableArray(): ImmutableArray<Char> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will
 * be auto-boxed in a wrapper object.
 */
public fun ImmutableShortArray.toTypedImmutableArray(): ImmutableArray<Short> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will
 * be auto-boxed in a wrapper object.
 */
public fun ImmutableIntArray.toTypedImmutableArray(): ImmutableArray<Int> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will
 * be auto-boxed in a wrapper object.
 */
public fun ImmutableLongArray.toTypedImmutableArray(): ImmutableArray<Long> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will
 * be auto-boxed in a wrapper object.
 */
public fun ImmutableFloatArray.toTypedImmutableArray(): ImmutableArray<Float> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Returns a typed [ImmutableArray] containing the values of this array.
 *
 * Note that [ImmutableArray] uses more memory and is slower to access as each primitive value will
 * be auto-boxed in a wrapper object.
 */
public fun ImmutableDoubleArray.toTypedImmutableArray(): ImmutableArray<Double> {
    return ImmutableArray(size) { this[it] }
}

/**
 * Ensures that none of the elements are null otherwise an [IllegalArgumentException] is thrown.
 *
 * Returns the same [ImmutableArray] instance cast with a non-null generic type.
 */
@Suppress("UNCHECKED_CAST")
public fun <T> ImmutableArray<T?>.requireNoNulls(): ImmutableArray<T> {
    if (contains(null)) throw IllegalArgumentException("null element found in $this")

    return this as ImmutableArray<T>
}

/**
 * Returns a single immutable array with all the elements from all nested collections.
 */
@JvmName("flattenIterable")
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
@JvmName("flattenImmutableArray")
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
@JvmName("flattenImmutableBooleanArray")
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
@JvmName("flattenImmutableByteArray")
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
@JvmName("flattenImmutableCharArray")
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
@JvmName("flattenImmutableShortArray")
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
@JvmName("flattenImmutableIntArray")
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
@JvmName("flattenImmutableLongArray")
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
@JvmName("flattenImmutableFloatArray")
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
@JvmName("flattenImmutableDoubleArray")
public fun ImmutableArray<ImmutableDoubleArray>.flatten(): ImmutableDoubleArray {
    return buildImmutableDoubleArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableDoubleArray.addAll(nestedArray)
        }
    }
}

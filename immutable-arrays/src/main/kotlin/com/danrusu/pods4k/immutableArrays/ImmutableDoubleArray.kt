// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Double
import kotlin.DoubleArray
import kotlin.Int
import kotlin.PublishedApi
import kotlin.String
import kotlin.Unit
import kotlin.collections.IndexedValue
import kotlin.collections.Iterable
import kotlin.collections.Iterator
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlin.ranges.IntRange
import kotlin.sequences.Sequence

@JvmInline
public value class ImmutableDoubleArray @PublishedApi internal constructor(
    @PublishedApi
    internal val values: DoubleArray,
) {
    public val size: Int
        get() = values.size

    /**
     * Returns the index of the last element or -1 if the array is empty.
     */
    public val lastIndex: Int
        get() = values.size - 1

    /**
     * Returns the range of valid indices for the array.
     */
    public val indices: IntRange
        get() = values.indices

    override fun toString(): String = values.joinToString(prefix = "[", postfix = "]")

    /**
     * See [DoubleArray.isEmpty]
     */
    public fun isEmpty(): Boolean = values.isEmpty()

    /**
     * See [DoubleArray.isNotEmpty]
     */
    public fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at the specified [index]. This method can be called using the index
     * operator.
     */
    public operator fun `get`(index: Int): Double = values[index]

    /**
     * See [DoubleArray.getOrNull]
     */
    public fun getOrNull(index: Int): Double? = values.getOrNull(index)

    /**
     * See [DoubleArray.getOrElse]
     */
    public inline fun getOrElse(index: Int, defaultValue: (index: Int) -> Double): Double =
            values.getOrElse(index, defaultValue)

    public operator fun component1(): Double = get(0)

    public operator fun component2(): Double = get(1)

    public operator fun component3(): Double = get(2)

    public operator fun component4(): Double = get(3)

    public operator fun component5(): Double = get(4)

    /**
     * See [DoubleArray.single]
     */
    public fun single(): Double = values.single()

    /**
     * See [DoubleArray.first]
     */
    public fun first(): Double = values.first()

    /**
     * See [DoubleArray.firstOrNull]
     */
    public fun firstOrNull(): Double? = values.firstOrNull()

    /**
     * See [DoubleArray.last]
     */
    public fun last(): Double = values.last()

    /**
     * See [DoubleArray.lastOrNull]
     */
    public fun lastOrNull(): Double? = values.lastOrNull()

    /**
     * See [DoubleArray.toList]
     */
    public fun toList(): List<Double> = values.toList()

    /**
     * See [DoubleArray.toMutableList]
     */
    public fun toMutableList(): MutableList<Double> = values.toMutableList()

    /**
     * See [DoubleArray.iterator]
     */
    public operator fun iterator(): Iterator<Double> = values.iterator()

    /**
     * See [DoubleArray.asIterable]
     */
    public fun asIterable(): Iterable<Double> = values.asIterable()

    /**
     * See [DoubleArray.withIndex]
     */
    public fun withIndex(): Iterable<IndexedValue<Double>> = values.withIndex()

    /**
     * See [DoubleArray.asSequence]
     */
    public fun asSequence(): Sequence<Double> = values.asSequence()

    /**
     * See [DoubleArray.forEach]
     */
    public inline fun forEach(action: (element: Double) -> Unit): Unit = values.forEach(action)

    /**
     * See [DoubleArray.forEachIndexed]
     */
    public inline fun forEachIndexed(action: (index: Int, element: Double) -> Unit): Unit =
            values.forEachIndexed(action)

    public companion object {
        /**
         * Creates a ImmutableDoubleArray instance of the specified [size], where each element is
         * calculated by calling the specified [init] function.
         *
         * [init] is called sequentially starting at index 0 to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke method instead of a regular constructor so that we can declare it
         * inline.  The call site will look like a regular constructor call.
         */
        public inline operator fun invoke(size: Int, `init`: (index: Int) -> Double):
                ImmutableDoubleArray {
            val backingArray = DoubleArray(size) { index -> init(index) }
            return ImmutableDoubleArray(backingArray)
        }
    }
}

// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.LongArray
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
public value class ImmutableLongArray @PublishedApi internal constructor(
    @PublishedApi
    internal val values: LongArray,
) {
    public val size: Int
        get() = values.size

    /**
     * Returns the index of the last element or -1 if the array is empty.
     */
    public val lastIndex: Int
        get() = values.lastIndex

    /**
     * Returns the range of valid indices for the array.
     */
    public val indices: IntRange
        get() = values.indices

    override fun toString(): String = values.joinToString(prefix = "[", postfix = "]")

    /**
     * See [Array.isEmpty]
     */
    public fun isEmpty(): Boolean = values.isEmpty()

    /**
     * See [Array.isNotEmpty]
     */
    public fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at the specified [index]. This method can be called using the index
     * operator.
     */
    public operator fun `get`(index: Int): Long = values[index]

    /**
     * See [Array.getOrNull]
     */
    public fun getOrNull(index: Int): Long? = values.getOrNull(index)

    /**
     * See [Array.getOrElse]
     */
    public inline fun getOrElse(index: Int, defaultValue: (index: Int) -> Long): Long =
            values.getOrElse(index, defaultValue)

    public operator fun component1(): Long = get(0)

    public operator fun component2(): Long = get(1)

    public operator fun component3(): Long = get(2)

    public operator fun component4(): Long = get(3)

    public operator fun component5(): Long = get(4)

    /**
     * See [Array.single]
     */
    public fun single(): Long = values.single()

    /**
     * See [Array.first]
     */
    public fun first(): Long = values.first()

    /**
     * See [Array.firstOrNull]
     */
    public fun firstOrNull(): Long? = values.firstOrNull()

    /**
     * See [Array.last]
     */
    public fun last(): Long = values.last()

    /**
     * See [Array.lastOrNull]
     */
    public fun lastOrNull(): Long? = values.lastOrNull()

    /**
     * See [Array.toList]
     */
    public fun toList(): List<Long> = values.toList()

    /**
     * See [Array.toMutableList]
     */
    public fun toMutableList(): MutableList<Long> = values.toMutableList()

    /**
     * See [Array.iterator]
     */
    public operator fun iterator(): Iterator<Long> = values.iterator()

    /**
     * See [Array.asIterable]
     */
    public fun asIterable(): Iterable<Long> = values.asIterable()

    /**
     * See [Array.withIndex]
     */
    public fun withIndex(): Iterable<IndexedValue<Long>> = values.withIndex()

    /**
     * See [Array.asSequence]
     */
    public fun asSequence(): Sequence<Long> = values.asSequence()

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEach(action: (element: Long) -> Unit): Unit = values.forEach(action)

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEachIndexed(action: (index: Int, element: Long) -> Unit): Unit =
            values.forEachIndexed(action)

    public companion object {
        /**
         * Creates a ImmutableLongArray instance of the specified [size], where each element is
         * calculated by calling the specified [init] function.
         *
         * [init] is called sequentially starting at index 0 to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke method instead of a regular constructor so that we can declare it
         * inline.  The call site will look like a regular constructor call.
         */
        public inline operator fun invoke(size: Int, `init`: (index: Int) -> Long):
                ImmutableLongArray {
            val backingArray = LongArray(size) { index -> init(index) }
            return ImmutableLongArray(backingArray)
        }
    }
}

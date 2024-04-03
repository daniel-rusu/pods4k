// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Int
import kotlin.IntArray
import kotlin.PublishedApi
import kotlin.String
import kotlin.Unit
import kotlin.collections.Iterator
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlin.ranges.IntRange
import kotlin.sequences.Sequence

@JvmInline
public value class ImmutableIntArray @PublishedApi internal constructor(
    @PublishedApi
    internal val values: IntArray,
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
    public operator fun `get`(index: Int): Int = values[index]

    /**
     * See [Array.getOrNull]
     */
    public fun getOrNull(index: Int): Int? = values.getOrNull(index)

    /**
     * See [Array.getOrElse]
     */
    public inline fun getOrElse(index: Int, defaultValue: (index: Int) -> Int): Int =
            values.getOrElse(index, defaultValue)

    public operator fun component1(): Int = get(0)

    public operator fun component2(): Int = get(1)

    public operator fun component3(): Int = get(2)

    public operator fun component4(): Int = get(3)

    public operator fun component5(): Int = get(4)

    /**
     * See [Array.single]
     */
    public fun single(): Int = values.single()

    /**
     * See [Array.first]
     */
    public fun first(): Int = values.first()

    /**
     * See [Array.firstOrNull]
     */
    public fun firstOrNull(): Int? = values.firstOrNull()

    /**
     * See [Array.last]
     */
    public fun last(): Int = values.last()

    /**
     * See [Array.lastOrNull]
     */
    public fun lastOrNull(): Int? = values.lastOrNull()

    /**
     * See [Array.toList]
     */
    public fun toList(): List<Int> = values.toList()

    /**
     * See [Array.toMutableList]
     */
    public fun toMutableList(): MutableList<Int> = values.toMutableList()

    /**
     * See [Array.iterator]
     */
    public operator fun iterator(): Iterator<Int> = values.iterator()

    /**
     * See [Array.asSequence]
     */
    public fun asSequence(): Sequence<Int> = values.asSequence()

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEach(action: (element: Int) -> Unit): Unit = values.forEach(action)

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEachIndexed(action: (index: Int, element: Int) -> Unit): Unit =
            values.forEachIndexed(action)

    public companion object {
        /**
         * Creates a ImmutableIntArray instance of the specified [size], where each element is
         * calculated by calling the specified [init] function.
         *
         * [init] is called sequentially starting at index 0 to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke method instead of a regular constructor so that we can declare it
         * inline.  The call site will look like a regular constructor call.
         */
        public inline operator fun invoke(size: Int, `init`: (index: Int) -> Int):
                ImmutableIntArray {
            val backingArray = IntArray(size) { index -> init(index) }
            return ImmutableIntArray(backingArray)
        }
    }
}

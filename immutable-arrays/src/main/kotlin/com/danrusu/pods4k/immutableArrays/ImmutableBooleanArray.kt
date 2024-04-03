// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.BooleanArray
import kotlin.Int
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
public value class ImmutableBooleanArray @PublishedApi internal constructor(
    @PublishedApi
    internal val values: BooleanArray,
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
    public operator fun `get`(index: Int): Boolean = values[index]

    /**
     * See [Array.getOrNull]
     */
    public fun getOrNull(index: Int): Boolean? = values.getOrNull(index)

    /**
     * Returns the element at the specified [index] or the result of calling the [defaultValue]
     * function if the [index] is out of bounds.
     */
    public inline fun getOrElse(index: Int, defaultValue: (index: Int) -> Boolean): Boolean =
            values.getOrElse(index, defaultValue)

    public operator fun component1(): Boolean = get(0)

    public operator fun component2(): Boolean = get(1)

    public operator fun component3(): Boolean = get(2)

    public operator fun component4(): Boolean = get(3)

    public operator fun component5(): Boolean = get(4)

    /**
     * See [Array.single]
     */
    public fun single(): Boolean = values.single()

    /**
     * See [Array.first]
     */
    public fun first(): Boolean = values.first()

    /**
     * See [Array.firstOrNull]
     */
    public fun firstOrNull(): Boolean? = values.firstOrNull()

    /**
     * See [Array.last]
     */
    public fun last(): Boolean = values.last()

    /**
     * See [Array.lastOrNull]
     */
    public fun lastOrNull(): Boolean? = values.lastOrNull()

    /**
     * See [Array.toList]
     */
    public fun toList(): List<Boolean> = values.toList()

    /**
     * See [Array.toMutableList]
     */
    public fun toMutableList(): MutableList<Boolean> = values.toMutableList()

    /**
     * See [Array.iterator]
     */
    public operator fun iterator(): Iterator<Boolean> = values.iterator()

    /**
     * See [Array.asSequence]
     */
    public fun asSequence(): Sequence<Boolean> = values.asSequence()

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEach(action: (element: Boolean) -> Unit): Unit = values.forEach(action)

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEachIndexed(action: (index: Int, element: Boolean) -> Unit): Unit =
            values.forEachIndexed(action)

    public companion object {
        /**
         * Creates a ImmutableBooleanArray instance of the specified [size], where each element is
         * calculated by calling the specified [init] function.
         *
         * [init] is called sequentially starting at index 0 to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke method instead of a regular constructor so that we can declare it
         * inline.  The call site will look like a regular constructor call.
         */
        public inline operator fun invoke(size: Int, `init`: (index: Int) -> Boolean):
                ImmutableBooleanArray {
            val backingArray = BooleanArray(size) { index -> init(index) }
            return ImmutableBooleanArray(backingArray)
        }
    }
}

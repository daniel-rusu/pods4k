// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.LongArray
import kotlin.PublishedApi
import kotlin.String
import kotlin.Unit
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline
import kotlin.ranges.IntRange

@JvmInline
public value class ImmutableLongArray @PublishedApi internal constructor(
    private val values: LongArray,
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
        get() = IntRange(0, lastIndex)

    override fun toString(): String = values.joinToString(prefix = "[", postfix = "]")

    public fun isEmpty(): Boolean = values.isEmpty()

    public fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at the specified [index]. This method can be called using the index
     * operator.
     */
    public operator fun `get`(index: Int): Long = values[index]

    public operator fun component1(): Long = get(0)

    public operator fun component2(): Long = get(1)

    public operator fun component3(): Long = get(2)

    public operator fun component4(): Long = get(3)

    public operator fun component5(): Long = get(4)

    /**
     * Returns the single element from the array, or throws an exception if the array is empty or
     * has more than one element.
     */
    public fun single(): Long = when (size) {
        0 -> throw NoSuchElementException("Array is empty!")
        1 -> get(0)
        else -> throw IllegalArgumentException("Array has more than one element!")
    }

    /**
     * Returns the first element.
     *
     * @throws NoSuchElementException if the array is empty.
     */
    public fun first(): Long {
        if (isEmpty()) throw NoSuchElementException("Array is empty!")

        return get(0)
    }

    /**
     * Returns the last element.
     *
     * @throws NoSuchElementException if the array is empty.
     */
    public fun last(): Long {
        if (isEmpty()) throw NoSuchElementException("Array is empty!")

        return get(lastIndex)
    }

    /**
     * Creates an iterator allowing iteration over the elements of the array.
     */
    public operator fun iterator(): Iterator<Long> = values.iterator()

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEach(action: (element: Long) -> Unit) {
        for (value in this) {
            action(value)
        }
    }

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEachIndexed(action: (index: Int, element: Long) -> Unit) {
        for (index in 0..lastIndex) {
            action(index, get(index))
        }
    }

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

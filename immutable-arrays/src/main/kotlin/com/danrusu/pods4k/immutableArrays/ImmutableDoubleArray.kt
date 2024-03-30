// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.immutableArrays.emptySingletons.EmptyIterator
import kotlin.Boolean
import kotlin.Double
import kotlin.DoubleArray
import kotlin.Int
import kotlin.PublishedApi
import kotlin.String
import kotlin.Unit
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline
import kotlin.ranges.IntRange

@JvmInline
public value class ImmutableDoubleArray @PublishedApi internal constructor(
    private val values: DoubleArray,
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
    public operator fun `get`(index: Int): Double = values[index]

    public operator fun component1(): Double = get(0)

    public operator fun component2(): Double = get(1)

    public operator fun component3(): Double = get(2)

    public operator fun component4(): Double = get(3)

    public operator fun component5(): Double = get(4)

    /**
     * Returns the single element from the array, or throws an exception if the array is empty or
     * has more than one element.
     */
    public fun single(): Double = when (size) {
        0 -> throw NoSuchElementException("Array is empty!")
        1 -> get(0)
        else -> throw IllegalArgumentException("Array has more than one element!")
    }

    /**
     * Returns the first element.
     *
     * @throws NoSuchElementException if the array is empty.
     */
    public fun first(): Double {
        if (isEmpty()) throw NoSuchElementException("Array is empty!")

        return get(0)
    }

    /**
     * Returns the last element.
     *
     * @throws NoSuchElementException if the array is empty.
     */
    public fun last(): Double {
        if (isEmpty()) throw NoSuchElementException("Array is empty!")

        return get(lastIndex)
    }

    /**
     * Creates an iterator allowing iteration over the elements of the array.
     */
    public operator fun iterator(): Iterator<Double> {
        if (isEmpty()) return EmptyIterator
        return values.iterator()
    }

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEach(action: (element: Double) -> Unit) {
        for (value in this) {
            action(value)
        }
    }

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEachIndexed(action: (index: Int, element: Double) -> Unit) {
        for (index in 0..lastIndex) {
            action(index, get(index))
        }
    }

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

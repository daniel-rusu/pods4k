// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Float
import kotlin.FloatArray
import kotlin.Int
import kotlin.PublishedApi
import kotlin.String
import kotlin.Unit
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline

@JvmInline
public value class ImmutableFloatArray @PublishedApi internal constructor(
    private val values: FloatArray,
) {
    public val size: Int
        get() = values.size

    /**
     * Returns the index of the last element or -1 if the array is empty.
     */
    public val lastIndex: Int
        get() = values.size - 1

    override fun toString(): String = values.joinToString(prefix = "[", postfix = "]")

    public fun isEmpty(): Boolean = values.isEmpty()

    public fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at the specified [index]. This method can be called using the index
     * operator.
     */
    public operator fun `get`(index: Int): Float = values[index]

    public operator fun component1(): Float = get(0)

    public operator fun component2(): Float = get(1)

    public operator fun component3(): Float = get(2)

    public operator fun component4(): Float = get(3)

    public operator fun component5(): Float = get(4)

    /**
     * Returns the single element from the array, or throws an exception if the array is empty or
     * has more than one element.
     */
    public fun single(): Float = when (size) {
        0 -> throw NoSuchElementException("Array is empty!")
        1 -> get(0)
        else -> throw IllegalArgumentException("Array has more than one element!")
    }

    /**
     * Returns the first element.
     *
     * @throws NoSuchElementException if the array is empty.
     */
    public fun first(): Float {
        if (isEmpty()) throw NoSuchElementException("Array is empty!")

        return get(0)
    }

    /**
     * Returns the last element.
     *
     * @throws NoSuchElementException if the array is empty.
     */
    public fun last(): Float {
        if (isEmpty()) throw NoSuchElementException("Array is empty!")

        return get(lastIndex)
    }

    /**
     * Creates an iterator allowing iteration over the elements of the array.
     */
    public operator fun iterator(): Iterator<Float> = values.iterator()

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEach(action: (element: Float) -> Unit) {
        for (value in this) {
            action(value)
        }
    }

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    public inline fun forEachIndexed(action: (index: Int, element: Float) -> Unit) {
        for (index in 0..lastIndex) {
            action(index, get(index))
        }
    }

    public companion object {
        /**
         * Creates a ImmutableFloatArray instance of the specified [size], where each element is
         * calculated by calling the specified [init] function.
         *
         * [init] is called sequentially starting at index 0 to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke method instead of a regular constructor so that we can declare it
         * inline.  The call site will look like a regular constructor call.
         */
        public inline operator fun invoke(size: Int, `init`: (index: Int) -> Float):
                ImmutableFloatArray {
            val backingArray = FloatArray(size) { index -> init(index) }
            return ImmutableFloatArray(backingArray)
        }
    }
}

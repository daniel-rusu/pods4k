// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.immutableArrays.emptySingletons.EmptyIterator
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.PublishedApi
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.Iterator
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlin.ranges.IntRange
import kotlin.sequences.Sequence

@JvmInline
public value class ImmutableArray<T> @PublishedApi internal constructor(
    @PublishedApi
    internal val values: Array<Any?>,
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

    public fun isEmpty(): Boolean = values.isEmpty()

    public fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at the specified [index]. This method can be called using the index
     * operator.
     */
    @Suppress("UNCHECKED_CAST")
    public operator fun `get`(index: Int): T = values[index] as T

    /**
     * Returns the element at the specified [index] or null if the index is out of bounds.
     */
    @Suppress("UNCHECKED_CAST")
    public fun getOrNull(index: Int): T? = values.getOrNull(index) as T

    public operator fun component1(): T = get(0)

    public operator fun component2(): T = get(1)

    public operator fun component3(): T = get(2)

    public operator fun component4(): T = get(3)

    public operator fun component5(): T = get(4)

    /**
     * Returns the single element from the array, or throws an exception if the array is empty or
     * has more than one element.
     */
    @Suppress("UNCHECKED_CAST")
    public fun single(): T = values.single() as T

    /**
     * Returns the first element.
     *
     * @throws NoSuchElementException if the array is empty.
     */
    @Suppress("UNCHECKED_CAST")
    public fun first(): T = values.first() as T

    /**
     * Returns the first element or null if the array is empty.
     */
    @Suppress("UNCHECKED_CAST")
    public fun firstOrNull(): T? = values.firstOrNull() as T

    /**
     * Returns the last element.
     *
     * @throws NoSuchElementException if the array is empty.
     */
    @Suppress("UNCHECKED_CAST")
    public fun last(): T = values.last() as T

    /**
     * Returns a [List] containing all the elements.
     */
    @Suppress("UNCHECKED_CAST")
    public fun toList(): List<T> = values.toList() as List<T>

    /**
     * Returns a [MutableList] containing all the elements.
     */
    @Suppress("UNCHECKED_CAST")
    public fun toMutableList(): MutableList<T> = values.toMutableList() as MutableList<T>

    /**
     * Returns an iterator allowing iteration over the elements of the array.
     */
    @Suppress("UNCHECKED_CAST")
    public operator fun iterator(): Iterator<T> {
        if (isEmpty()) return EmptyIterator
        return values.iterator() as Iterator<T>
    }

    /**
     * Returns a [Sequence] which returns the elements of this array when iterated.
     */
    @Suppress("UNCHECKED_CAST")
    public fun asSequence(): Sequence<T> = values.asSequence() as Sequence<T>

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    @Suppress("UNCHECKED_CAST")
    public inline fun forEach(action: (element: T) -> Unit): Unit = values.forEach { action(it as T)
            }

    /**
     * Performs the specified [action] on each element sequentially starting with the first element
     */
    @Suppress("UNCHECKED_CAST")
    public inline fun forEachIndexed(action: (index: Int, element: T) -> Unit): Unit =
            values.forEachIndexed { index, element -> action(index, element as T) }

    public companion object {
        /**
         * Creates a ImmutableArray instance of the specified [size], where each element is
         * calculated by calling the specified [init] function.
         *
         * [init] is called sequentially starting at index 0 to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke method instead of a regular constructor so that we can declare it
         * inline.  The call site will look like a regular constructor call.
         */
        public inline operator fun <T> invoke(size: Int, `init`: (index: Int) -> T):
                ImmutableArray<T> {
            val backingArray = Array<Any?>(size) { index -> init(index) }
            return ImmutableArray(backingArray)
        }
    }
}

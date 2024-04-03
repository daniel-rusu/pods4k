// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Char
import kotlin.CharArray
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
public value class ImmutableCharArray @PublishedApi internal constructor(
    @PublishedApi
    internal val values: CharArray,
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
     * See [CharArray.isEmpty]
     */
    public fun isEmpty(): Boolean = values.isEmpty()

    /**
     * See [CharArray.isNotEmpty]
     */
    public fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at the specified [index]. This method can be called using the index
     * operator.
     */
    public operator fun `get`(index: Int): Char = values[index]

    /**
     * See [CharArray.getOrNull]
     */
    public fun getOrNull(index: Int): Char? = values.getOrNull(index)

    /**
     * See [CharArray.getOrElse]
     */
    public inline fun getOrElse(index: Int, defaultValue: (index: Int) -> Char): Char =
            values.getOrElse(index, defaultValue)

    public operator fun component1(): Char = get(0)

    public operator fun component2(): Char = get(1)

    public operator fun component3(): Char = get(2)

    public operator fun component4(): Char = get(3)

    public operator fun component5(): Char = get(4)

    /**
     * See [CharArray.single]
     */
    public fun single(): Char = values.single()

    /**
     * See [CharArray.first]
     */
    public fun first(): Char = values.first()

    /**
     * See [CharArray.firstOrNull]
     */
    public fun firstOrNull(): Char? = values.firstOrNull()

    /**
     * See [CharArray.last]
     */
    public fun last(): Char = values.last()

    /**
     * See [CharArray.lastOrNull]
     */
    public fun lastOrNull(): Char? = values.lastOrNull()

    /**
     * See [CharArray.toList]
     */
    public fun toList(): List<Char> = values.toList()

    /**
     * See [CharArray.toMutableList]
     */
    public fun toMutableList(): MutableList<Char> = values.toMutableList()

    /**
     * See [CharArray.iterator]
     */
    public operator fun iterator(): Iterator<Char> = values.iterator()

    /**
     * See [CharArray.asIterable]
     */
    public fun asIterable(): Iterable<Char> = values.asIterable()

    /**
     * See [CharArray.withIndex]
     */
    public fun withIndex(): Iterable<IndexedValue<Char>> = values.withIndex()

    /**
     * See [CharArray.asSequence]
     */
    public fun asSequence(): Sequence<Char> = values.asSequence()

    /**
     * See [CharArray.forEach]
     */
    public inline fun forEach(action: (element: Char) -> Unit): Unit = values.forEach(action)

    /**
     * See [CharArray.forEachIndexed]
     */
    public inline fun forEachIndexed(action: (index: Int, element: Char) -> Unit): Unit =
            values.forEachIndexed(action)

    public companion object {
        /**
         * Creates a ImmutableCharArray instance of the specified [size], where each element is
         * calculated by calling the specified [init] function.
         *
         * [init] is called sequentially starting at index 0 to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke method instead of a regular constructor so that we can declare it
         * inline.  The call site will look like a regular constructor call.
         */
        public inline operator fun invoke(size: Int, `init`: (index: Int) -> Char):
                ImmutableCharArray {
            val backingArray = CharArray(size) { index -> init(index) }
            return ImmutableCharArray(backingArray)
        }
    }
}

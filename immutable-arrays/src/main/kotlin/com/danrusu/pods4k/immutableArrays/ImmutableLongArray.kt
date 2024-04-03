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
    /**
     * This is internal instead of private so we can have inline functions that delegate to the same
     * function on the backing array.  The backing array won't be accessible from Kotlin code since the
     * auto-generarted arrays are in their own module and the internal modifier prevents outside
     * access.  The constructor is also internal preventing anyone from creating an "instance" that
     * points to an array that they have access to.
     *
     * Attempting to bypass the internal visibility from java won't work since this is an inline
     * class so both the field and constructor are mangled by the Kotlin compiler.  While these might
     * appear to be accessible from Java due to the friendly Kotlin interop, these won't actually exist
     * with those names in the generated bytecode resulting in an unknown symbol exception.
     *
     * Therefore, the combination of being internal in its own module along with inline classes
     * makes this effectively private.
     */
    @PublishedApi
    internal val values: LongArray,
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
     * See [LongArray.isEmpty]
     */
    public fun isEmpty(): Boolean = values.isEmpty()

    /**
     * See [LongArray.isNotEmpty]
     */
    public fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at the specified [index]. This method can be called using the index
     * operator.
     */
    public operator fun `get`(index: Int): Long = values[index]

    /**
     * See [LongArray.getOrNull]
     */
    public fun getOrNull(index: Int): Long? = values.getOrNull(index)

    /**
     * See [LongArray.getOrElse]
     */
    public inline fun getOrElse(index: Int, defaultValue: (index: Int) -> Long): Long =
            values.getOrElse(index, defaultValue)

    public operator fun component1(): Long = get(0)

    public operator fun component2(): Long = get(1)

    public operator fun component3(): Long = get(2)

    public operator fun component4(): Long = get(3)

    public operator fun component5(): Long = get(4)

    /**
     * See [LongArray.single]
     */
    public fun single(): Long = values.single()

    /**
     * See [LongArray.single]
     */
    public fun single(predicate: (element: Long) -> Boolean): Long = values.single(predicate)

    /**
     * See [LongArray.first]
     */
    public fun first(): Long = values.first()

    /**
     * See [LongArray.first]
     */
    public fun first(predicate: (element: Long) -> Boolean): Long = values.first(predicate)

    /**
     * See [LongArray.firstOrNull]
     */
    public fun firstOrNull(): Long? = values.firstOrNull()

    /**
     * See [LongArray.firstOrNull]
     */
    public fun firstOrNull(predicate: (element: Long) -> Boolean): Long? =
            values.firstOrNull(predicate)

    /**
     * See [LongArray.last]
     */
    public fun last(): Long = values.last()

    /**
     * See [LongArray.last]
     */
    public fun last(predicate: (element: Long) -> Boolean): Long = values.last(predicate)

    /**
     * See [LongArray.lastOrNull]
     */
    public fun lastOrNull(): Long? = values.lastOrNull()

    /**
     * See [LongArray.lastOrNull]
     */
    public fun lastOrNull(predicate: (element: Long) -> Boolean): Long? =
            values.lastOrNull(predicate)

    /**
     * See [LongArray.toList]
     */
    public fun toList(): List<Long> = values.toList()

    /**
     * See [LongArray.toMutableList]
     */
    public fun toMutableList(): MutableList<Long> = values.toMutableList()

    /**
     * See [LongArray.iterator]
     */
    public operator fun iterator(): Iterator<Long> = values.iterator()

    /**
     * See [LongArray.asIterable]
     */
    public fun asIterable(): Iterable<Long> = values.asIterable()

    /**
     * See [LongArray.withIndex]
     */
    public fun withIndex(): Iterable<IndexedValue<Long>> = values.withIndex()

    /**
     * See [LongArray.asSequence]
     */
    public fun asSequence(): Sequence<Long> = values.asSequence()

    /**
     * See [LongArray.forEach]
     */
    public inline fun forEach(action: (element: Long) -> Unit): Unit = values.forEach(action)

    /**
     * See [LongArray.forEachIndexed]
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

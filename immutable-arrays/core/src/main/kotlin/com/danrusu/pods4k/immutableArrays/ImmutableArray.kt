// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.PublishedApi
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.IndexedValue
import kotlin.collections.Iterable
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline
import kotlin.ranges.IntRange
import kotlin.sequences.Sequence

/**
 * Represents an array that cannot have its elements re-assigned.
 *
 * Although this is a class that wraps a regular array, it's really a zero-cost abstraction that
 * gets eliminated at compile time so that variables of this type end up pointing directly at the
 * underlying array.
 *
 * In order to preserve the same performance as regular arrays, all methods that delegate to the
 * same method on the backing array are marked with inline so that call sites end up calling the
 * underlying methods directly.  Note that this won't have any negative performance impacts as it
 * doesn't result in duplicate code or anything as it just replaces the wrapper method call with the
 * underlying method call.
 */
@Suppress("NOTHING_TO_INLINE")
@JvmInline
public value class ImmutableArray<out T> @PublishedApi internal constructor(
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
    internal val values: Array<out T>,
) {
    public inline val size: Int
        get() = values.size

    /**
     * Returns the index of the last element or -1 if the array is empty.
     */
    public inline val lastIndex: Int
        get() = values.lastIndex

    /**
     * Returns the range of valid indices for the array.
     */
    public inline val indices: IntRange
        get() = values.indices

    override fun toString(): String = values.joinToString(prefix = "[", postfix = "]")

    public operator fun equals(other: ImmutableArray<*>): Boolean {
        if (other.size != this.size) return false

        forEachIndexed { index, element ->
            if (other[index] != element) return false
        }
        return true
    }

    override fun hashCode(): Int {
        // Start with non-zero hash so that arrays that start with a different number of zero-hash elements end up with different hashCodes
        var hashCode = 7
        for (value in values) {
            hashCode = 31 * hashCode + (value?.hashCode() ?: 0)
        }
        return hashCode
    }

    /**
     * See [Array.isEmpty]
     */
    public inline fun isEmpty(): Boolean = values.isEmpty()

    /**
     * See [Array.isNotEmpty]
     */
    public inline fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at the specified [index]. This method can be called using the index
     * operator.
     */
    public inline operator fun `get`(index: Int): T = values[index]

    /**
     * See [Array.getOrNull]
     */
    public inline fun getOrNull(index: Int): T? = values.getOrNull(index)

    public operator fun component1(): T = get(0)

    public operator fun component2(): T = get(1)

    public operator fun component3(): T = get(2)

    public operator fun component4(): T = get(3)

    public operator fun component5(): T = get(4)

    /**
     * See [Array.single]
     */
    public inline fun single(): T = values.single()

    /**
     * See [Array.single]
     */
    public inline fun single(predicate: (element: T) -> Boolean): T = values.single(predicate)

    /**
     * See [Array.singleOrNull]
     */
    public inline fun singleOrNull(): T? = values.singleOrNull()

    /**
     * See [Array.singleOrNull]
     */
    public inline fun singleOrNull(predicate: (element: T) -> Boolean): T? =
            values.singleOrNull(predicate)

    /**
     * See [Array.first]
     */
    public inline fun first(): T = values.first()

    /**
     * See [Array.first]
     */
    public inline fun first(predicate: (element: T) -> Boolean): T = values.first(predicate)

    /**
     * See [Array.firstOrNull]
     */
    public inline fun firstOrNull(): T? = values.firstOrNull()

    /**
     * See [Array.firstOrNull]
     */
    public inline fun firstOrNull(predicate: (element: T) -> Boolean): T? =
            values.firstOrNull(predicate)

    /**
     * See [Array.last]
     */
    public inline fun last(): T = values.last()

    /**
     * See [Array.last]
     */
    public inline fun last(predicate: (element: T) -> Boolean): T = values.last(predicate)

    /**
     * See [Array.lastOrNull]
     */
    public inline fun lastOrNull(): T? = values.lastOrNull()

    /**
     * See [Array.lastOrNull]
     */
    public inline fun lastOrNull(predicate: (element: T) -> Boolean): T? =
            values.lastOrNull(predicate)

    /**
     * See [Array.iterator]
     */
    public inline operator fun iterator(): Iterator<T> = values.iterator()

    /**
     * See [Array.asIterable]
     */
    public inline fun asIterable(): Iterable<T> = values.asIterable()

    /**
     * See [Array.withIndex]
     */
    public inline fun withIndex(): Iterable<IndexedValue<T>> = values.withIndex()

    /**
     * See [Array.asSequence]
     */
    public inline fun asSequence(): Sequence<T> = values.asSequence()

    /**
     * See [Array.forEach]
     */
    public inline fun forEach(action: (element: T) -> Unit): Unit = values.forEach(action)

    /**
     * See [Array.forEachIndexed]
     */
    public inline fun forEachIndexed(action: (index: Int, element: T) -> Unit): Unit =
            values.forEachIndexed(action)

    public companion object {
        @PublishedApi
        internal val EMPTY: ImmutableArray<Any?> = ImmutableArray(emptyArray())

        /**
         * Returns an ImmutableArray instance of the specified [size], where each element is
         * calculated by calling the specified [init] function.
         *
         * [init] is called sequentially starting at index 0 to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke method instead of a regular constructor so that we can declare it
         * inline.  The call site will look like a regular constructor call.
         */
        @Suppress("UNCHECKED_CAST")
        public inline operator fun <T> invoke(size: Int, `init`: (index: Int) -> T):
                ImmutableArray<T> {
            if (size == 0) return EMPTY as ImmutableArray<T>
            val backingArray = Array<Any?>(size) { index -> init(index) }
            return ImmutableArray(backingArray as Array<out T>)
        }
    }
}

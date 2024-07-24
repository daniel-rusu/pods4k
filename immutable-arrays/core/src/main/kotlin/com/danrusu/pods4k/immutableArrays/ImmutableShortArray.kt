// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import java.util.Arrays
import java.util.Comparator
import kotlin.Array
import kotlin.Boolean
import kotlin.Comparable
import kotlin.Int
import kotlin.PublishedApi
import kotlin.Short
import kotlin.ShortArray
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
public value class ImmutableShortArray @PublishedApi internal constructor(
    /**
     * This is internal instead of private so we can have inline functions that delegate to the same
     * function on the backing array.  The backing array won't be accessible from Kotlin code since the
     * auto-generated arrays are in their own module and the internal modifier prevents outside access.
     *  The constructor is also internal preventing anyone from creating an "instance" that points to
     * an array that they have access to.
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
    internal val values: ShortArray,
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

    public operator fun equals(other: ImmutableShortArray): Boolean {
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
            hashCode = 31 * hashCode + value.hashCode()
        }
        return hashCode
    }

    /**
     * See [ShortArray.isEmpty]
     */
    public inline fun isEmpty(): Boolean = values.isEmpty()

    /**
     * See [ShortArray.isNotEmpty]
     */
    public inline fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at the specified [index]. This method can be called using the index
     * operator.
     */
    public inline operator fun `get`(index: Int): Short = values[index]

    /**
     * See [ShortArray.getOrNull]
     */
    public inline fun getOrNull(index: Int): Short? = values.getOrNull(index)

    public operator fun component1(): Short = get(0)

    public operator fun component2(): Short = get(1)

    public operator fun component3(): Short = get(2)

    public operator fun component4(): Short = get(3)

    public operator fun component5(): Short = get(4)

    /**
     * See [ShortArray.single]
     */
    public inline fun single(): Short = values.single()

    /**
     * See [ShortArray.single]
     */
    public inline fun single(predicate: (element: Short) -> Boolean): Short =
            values.single(predicate)

    /**
     * See [ShortArray.singleOrNull]
     */
    public inline fun singleOrNull(): Short? = values.singleOrNull()

    /**
     * See [ShortArray.singleOrNull]
     */
    public inline fun singleOrNull(predicate: (element: Short) -> Boolean): Short? =
            values.singleOrNull(predicate)

    /**
     * See [ShortArray.first]
     */
    public inline fun first(): Short = values.first()

    /**
     * See [ShortArray.first]
     */
    public inline fun first(predicate: (element: Short) -> Boolean): Short = values.first(predicate)

    /**
     * See [ShortArray.firstOrNull]
     */
    public inline fun firstOrNull(): Short? = values.firstOrNull()

    /**
     * See [ShortArray.firstOrNull]
     */
    public inline fun firstOrNull(predicate: (element: Short) -> Boolean): Short? =
            values.firstOrNull(predicate)

    /**
     * See [ShortArray.last]
     */
    public inline fun last(): Short = values.last()

    /**
     * See [ShortArray.last]
     */
    public inline fun last(predicate: (element: Short) -> Boolean): Short = values.last(predicate)

    /**
     * See [ShortArray.lastOrNull]
     */
    public inline fun lastOrNull(): Short? = values.lastOrNull()

    /**
     * See [ShortArray.lastOrNull]
     */
    public inline fun lastOrNull(predicate: (element: Short) -> Boolean): Short? =
            values.lastOrNull(predicate)

    /**
     * See [ShortArray.iterator]
     */
    public inline operator fun iterator(): Iterator<Short> = values.iterator()

    /**
     * See [ShortArray.asIterable]
     */
    public inline fun asIterable(): Iterable<Short> = values.asIterable()

    /**
     * See [ShortArray.withIndex]
     */
    public inline fun withIndex(): Iterable<IndexedValue<Short>> = values.withIndex()

    /**
     * See [ShortArray.asSequence]
     */
    public inline fun asSequence(): Sequence<Short> = values.asSequence()

    /**
     * See [ShortArray.forEach]
     */
    public inline fun forEach(action: (element: Short) -> Unit): Unit = values.forEach(action)

    /**
     * See [ShortArray.forEachIndexed]
     */
    public inline fun forEachIndexed(action: (index: Int, element: Short) -> Unit): Unit =
            values.forEachIndexed(action)

    /**
     * See [ShortArray.all]
     */
    public inline fun all(predicate: (predicate: Short) -> Boolean): Boolean = values.all(predicate)

    /**
     * See [ShortArray.any]
     */
    public inline fun any(predicate: (predicate: Short) -> Boolean): Boolean = values.any(predicate)

    /**
     * See [ShortArray.none]
     */
    public inline fun none(predicate: (predicate: Short) -> Boolean): Boolean =
            values.none(predicate)

    /**
     * See [ShortArray.count]
     */
    public inline fun count(predicate: (predicate: Short) -> Boolean): Int = values.count(predicate)

    /**
     * Leaves this immutable array as is and returns an ImmutableShortArray with all elements sorted
     * according to the natural sort order of the value returned by the [selector].
     *
     * The sort is _stable_ so equal elements preserve their order relative to each other after
     * sorting.
     */
    public inline fun <R : Comparable<R>> sortedBy(crossinline selector: (element: Short) -> R?):
            ImmutableShortArray = sortedWith(compareBy(selector))

    /**
     * Leaves this immutable array as is and returns an ImmutableShortArray with all elements sorted
     * according to the reverse natural sort order of the value returned by the [selector].
     *
     * The sort is _stable_ so equal elements preserve their order relative to each other after
     * sorting.
     */
    public inline fun <R : Comparable<R>> sortedByDescending(crossinline
            selector: (element: Short) -> R?): ImmutableShortArray =
            sortedWith(compareByDescending(selector))

    /**
     * Leaves this immutable array as is and returns an [ImmutableShortArray] with all elements
     * sorted according to the specified [comparator].
     */
    public fun sortedWith(comparator: Comparator<in Short>): ImmutableShortArray {
        // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
        if (size <= 1) return this

        val temp = values.toTypedArray()
        Arrays.sort(temp, comparator)
        return temp.toImmutableArray()
    }

    public companion object {
        @PublishedApi
        internal val EMPTY: ImmutableShortArray = ImmutableShortArray(ShortArray(0))

        /**
         * Returns an ImmutableShortArray instance of the specified [size], where each element is
         * calculated by calling the specified [init] function.
         *
         * [init] is called sequentially starting at index 0 to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke method instead of a regular constructor so that we can declare it
         * inline.  The call site will look like a regular constructor call.
         */
        public inline operator fun invoke(size: Int, `init`: (index: Int) -> Short):
                ImmutableShortArray {
            if (size == 0) return EMPTY

            val backingArray = ShortArray(size) { index -> init(index) }
            return ImmutableShortArray(backingArray)
        }
    }

    /**
     * Builder to construct immutable arrays when the resulting size isn't known in advance.
     *
     * @param initialCapacity The initial capacity of the temporary array where the values are
     * accumulated.  A larger value reduces the number of times it's resized as elements get added.
     */
    public class Builder(
        initialCapacity: Int = 10,
    ) {
        public var size: Int = 0
            private set

        private var values: ShortArray = ShortArray(initialCapacity)

        public fun add(element: Short) {
            ensureCapacity(size + 1)
            values[size++] = element
        }

        /**
         * Adds the [element] to the builder.
         */
        public operator fun plusAssign(element: Short) {
            add(element)
        }

        public fun addAll(elements: ShortArray) {
            ensureCapacity(size + elements.size)
            System.arraycopy(elements, 0, values, size, elements.size)
            size += elements.size
        }

        public fun addAll(elements: Array<Short>) {
            ensureCapacity(size + elements.size)
            for (element in elements) {
                values[size++] = element
            }
        }

        public fun addAll(elements: ImmutableShortArray) {
            ensureCapacity(size + elements.size)
            System.arraycopy(elements.values, 0, values, size, elements.size)
            size += elements.size
        }

        public fun addAll(elements: ImmutableArray<Short>) {
            ensureCapacity(size + elements.size)
            for (element in elements) {
                values[size++] = element
            }
        }

        public fun addAll(elements: Iterable<Short>) {
            if (elements is Collection) {
                ensureCapacity(size + elements.size)
                for (element in elements) {
                    values[size++] = element
                }
                return
            }
            for (element in elements) {
                add(element)
            }
        }

        /**
         * Returns an immutable array containing the elements that were added.
         */
        @Suppress("UNCHECKED_CAST")
        public fun build(): ImmutableShortArray {
            if (size == 0) return EMPTY

            val backingArray = ShortArray(size)
            System.arraycopy(values, 0, backingArray, 0, size)
            return ImmutableShortArray(backingArray)
        }

        private fun ensureCapacity(minCapacity: Int) {
            val newCapacity = BuilderUtils.computeNewCapacity(values.size, minCapacity)
            if (newCapacity == values.size) return

            val replacement = ShortArray(newCapacity)
            System.arraycopy(values, 0, replacement, 0, size)
            values = replacement
        }
    }
}

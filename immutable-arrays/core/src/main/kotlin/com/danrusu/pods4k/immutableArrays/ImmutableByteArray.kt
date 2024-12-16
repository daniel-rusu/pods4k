// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import java.util.Arrays
import java.util.Comparator
import kotlin.Array
import kotlin.Boolean
import kotlin.Byte
import kotlin.ByteArray
import kotlin.CharSequence
import kotlin.Comparable
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.OverloadResolutionByLambdaReturnType
import kotlin.Pair
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
 * To preserve the same performance as regular arrays, all functions that simply delegate to the
 * same function on the backing array are marked inline.  This won't result in code duplication as it's
 * a direct substitution replacing calls to the wrapper with direct calls to the underlying functions
 * on the backing array.
 */
@Suppress("NOTHING_TO_INLINE")
@JvmInline
public value class ImmutableByteArray @PublishedApi internal constructor(
    /**
     * The backing array is internal instead of private so that we can have inline functions that
     * delegate to the same function on the backing array.  The backing array won't be accessible from
     * Kotlin code since the auto-generated arrays are in their own module and the internal modifier
     * prevents outside access.  The constructor is also internal preventing anyone from creating an
     * "instance" that points to an array that they have access to.
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
    internal val values: ByteArray,
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

    /**
     * See [ByteArray.joinToString]
     */
    public fun joinToString(
        separator: CharSequence = ", ",
        prefix: CharSequence = "",
        postfix: CharSequence = "",
        limit: Int = -1,
        truncated: CharSequence = "...",
        transform: ((element: Byte) -> CharSequence)? = null,
    ): String = values.joinToString(separator, prefix, postfix, limit, truncated, transform)

    public operator fun equals(other: ImmutableByteArray): Boolean {
        if (other.values === this.values) return true
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
     * See [ByteArray.isEmpty]
     */
    public inline fun isEmpty(): Boolean = values.isEmpty()

    /**
     * See [ByteArray.isNotEmpty]
     */
    public inline fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at [index]. This method can be called using the index operator.
     */
    public inline operator fun `get`(index: Int): Byte = values[index]

    /**
     * See [ByteArray.getOrNull]
     */
    public inline fun getOrNull(index: Int): Byte? = values.getOrNull(index)

    public operator fun component1(): Byte = get(0)

    public operator fun component2(): Byte = get(1)

    public operator fun component3(): Byte = get(2)

    public operator fun component4(): Byte = get(3)

    public operator fun component5(): Byte = get(4)

    /**
     * See [ByteArray.single]
     */
    public inline fun single(): Byte = values.single()

    /**
     * See [ByteArray.single]
     */
    public inline fun single(predicate: (element: Byte) -> Boolean): Byte {
        return values.single(predicate)
    }

    /**
     * See [ByteArray.singleOrNull]
     */
    public inline fun singleOrNull(): Byte? = values.singleOrNull()

    /**
     * See [ByteArray.singleOrNull]
     */
    public inline fun singleOrNull(predicate: (element: Byte) -> Boolean): Byte? {
        return values.singleOrNull(predicate)
    }

    /**
     * See [ByteArray.first]
     */
    public inline fun first(): Byte = values.first()

    /**
     * See [ByteArray.first]
     */
    public inline fun first(predicate: (element: Byte) -> Boolean): Byte {
        return values.first(predicate)
    }

    /**
     * See [ByteArray.firstOrNull]
     */
    public inline fun firstOrNull(): Byte? = values.firstOrNull()

    /**
     * See [ByteArray.firstOrNull]
     */
    public inline fun firstOrNull(predicate: (element: Byte) -> Boolean): Byte? {
        return values.firstOrNull(predicate)
    }

    /**
     * See [ByteArray.last]
     */
    public inline fun last(): Byte = values.last()

    /**
     * See [ByteArray.last]
     */
    public inline fun last(predicate: (element: Byte) -> Boolean): Byte {
        return values.last(predicate)
    }

    /**
     * See [ByteArray.lastOrNull]
     */
    public inline fun lastOrNull(): Byte? = values.lastOrNull()

    /**
     * See [ByteArray.lastOrNull]
     */
    public inline fun lastOrNull(predicate: (element: Byte) -> Boolean): Byte? {
        return values.lastOrNull(predicate)
    }

    /**
     * See [ByteArray.iterator]
     */
    public inline operator fun iterator(): Iterator<Byte> = values.iterator()

    /**
     * See [ByteArray.asIterable]
     */
    public inline fun asIterable(): Iterable<Byte> = values.asIterable()

    /**
     * See [ByteArray.withIndex]
     */
    public inline fun withIndex(): Iterable<IndexedValue<Byte>> = values.withIndex()

    /**
     * See [ByteArray.asSequence]
     */
    public inline fun asSequence(): Sequence<Byte> = values.asSequence()

    /**
     * See [ByteArray.forEach]
     */
    public inline fun forEach(action: (element: Byte) -> Unit) {
        values.forEach(action)
    }

    /**
     * See [ByteArray.forEachIndexed]
     */
    public inline fun forEachIndexed(action: (index: Int, element: Byte) -> Unit) {
        values.forEachIndexed(action)
    }

    /**
     * See [ByteArray.all]
     */
    public inline fun all(predicate: (predicate: Byte) -> Boolean): Boolean {
        return values.all(predicate)
    }

    /**
     * See [ByteArray.any]
     */
    public inline fun any(predicate: (predicate: Byte) -> Boolean): Boolean {
        return values.any(predicate)
    }

    /**
     * See [ByteArray.none]
     */
    public inline fun none(predicate: (predicate: Byte) -> Boolean): Boolean {
        return values.none(predicate)
    }

    /**
     * See [ByteArray.count]
     */
    public inline fun count(predicate: (predicate: Byte) -> Boolean): Int {
        return values.count(predicate)
    }

    /**
     * See [ByteArray.indexOfFirst]
     */
    public inline fun indexOfFirst(predicate: (element: Byte) -> Boolean): Int {
        return values.indexOfFirst(predicate)
    }

    /**
     * See [ByteArray.indexOfLast]
     */
    public inline fun indexOfLast(predicate: (element: Byte) -> Boolean): Int {
        return values.indexOfLast(predicate)
    }

    /**
     * See [ByteArray.sumOf]
     */
    @OverloadResolutionByLambdaReturnType
    public inline fun sumOf(selector: (element: Byte) -> Int): Int = values.sumOf(selector)

    /**
     * See [ByteArray.sumOf]
     */
    @OverloadResolutionByLambdaReturnType
    public inline fun sumOf(selector: (element: Byte) -> Long): Long = values.sumOf(selector)

    /**
     * See [ByteArray.sumOf]
     */
    @OverloadResolutionByLambdaReturnType
    public inline fun sumOf(selector: (element: Byte) -> Double): Double = values.sumOf(selector)

    /**
     * Returns the sum of all values produced by the [selector] function applied to each element.
     */
    @OverloadResolutionByLambdaReturnType
    public inline fun sumOf(selector: (element: Byte) -> Float): Float {
        var sum = 0.0f
        for (element in values) {
            sum += selector(element)
        }
        return sum
    }

    /**
     * Returns an immutable array containing the first [n] elements.
     *
     * @throws IllegalArgumentException if [n] is negative.
     */
    public fun take(n: Int): ImmutableByteArray {
        require(n >= 0) { "Requested element count $n is less than zero." }
        if (n == 0) return EMPTY
        if (n >= size) return this

        val backingArray = ByteArray(n)
        System.arraycopy(values, 0, backingArray, 0, n)
        return ImmutableByteArray(backingArray)
    }

    /**
     * Returns an immutable array containing the first elements that satisfy the [predicate].
     */
    public inline fun takeWhile(predicate: (element: Byte) -> Boolean): ImmutableByteArray {
        for (index in 0..lastIndex) {
            if (!predicate(values[index])) {
                return take(index)
            }
        }
        return this
    }

    /**
     * Returns an immutable array containing the last [n] elements.
     *
     * @throws IllegalArgumentException if [n] is negative.
     */
    public fun takeLast(n: Int): ImmutableByteArray {
        require(n >= 0) { "Requested element count $n is less than zero." }
        if (n == 0) return EMPTY
        if (n >= size) return this

        val backingArray = ByteArray(n)
        System.arraycopy(values, size - n, backingArray, 0, n)
        return ImmutableByteArray(backingArray)
    }

    /**
     * Returns an immutable array containing the last elements that satisfy the [predicate].
     */
    public inline fun takeLastWhile(predicate: (element: Byte) -> Boolean): ImmutableByteArray {
        for (index in lastIndex downTo 0) {
            if (!predicate(values[index])) {
                return takeLast(size - index - 1)
            }
        }
        return this
    }

    /**
     * Returns an immutable array containing all the elements except the first n elements.
     *
     * @throws IllegalArgumentException if [n] is negative.
     */
    public fun drop(n: Int): ImmutableByteArray {
        require(n >= 0) { "Requested element count $n is less than zero." }

        return takeLast((size - n).coerceAtLeast(0))
    }

    /**
     * Returns an immutable array containing all the elements except the first elements that satisfy
     * the [predicate].
     */
    public inline fun dropWhile(predicate: (element: Byte) -> Boolean): ImmutableByteArray {
        for (index in 0..lastIndex) {
            if (!predicate(values[index])) {
                return takeLast(size - index)
            }
        }
        return EMPTY
    }

    /**
     * Returns an immutable array containing all the elements except the last n elements.
     *
     * @throws IllegalArgumentException if [n] is negative.
     */
    public fun dropLast(n: Int): ImmutableByteArray {
        require(n >= 0) { "Requested element count $n is less than zero." }

        return take((size - n).coerceAtLeast(0))
    }

    /**
     * Returns an immutable array containing all the elements except the last elements that satisfy
     * the [predicate].
     */
    public inline fun dropLastWhile(predicate: (element: Byte) -> Boolean): ImmutableByteArray {
        for (index in lastIndex downTo 0) {
            if (!predicate(values[index])) {
                return take(index + 1)
            }
        }
        return EMPTY
    }

    /**
     * Returns an immutable array containing only the elements matching the given [predicate].
     */
    public inline fun filter(predicate: (element: Byte) -> Boolean): ImmutableByteArray {
        val result = Builder()
        for (element in values) {
            if (predicate(element)) {
                result.add(element)
            }
        }
        if (result.size == size) return this

        return result.build()
    }

    /**
     * Returns an immutable array containing only the elements matching the given [predicate].
     */
    public inline fun filterIndexed(predicate: (index: Int, element: Byte) -> Boolean): ImmutableByteArray {
        val result = Builder()
        forEachIndexed { index, element ->
            if (predicate(index, element)) {
                result.add(element)
            }
        }
        if (result.size == size) return this

        return result.build()
    }

    /**
     * Returns an immutable array containing only the elements that don't match the [predicate].
     */
    public inline fun filterNot(predicate: (element: Byte) -> Boolean): ImmutableByteArray {
        val result = Builder()
        for (element in values) {
            if (!predicate(element)) {
                result.add(element)
            }
        }
        if (result.size == size) return this

        return result.build()
    }

    /**
     * Creates a pair of immutable arrays, where the first contains elements for which the predicate
     * yielded true, and the second contains the other elements.
     */
    public fun partition(predicate: (element: Byte) -> Boolean): Pair<ImmutableByteArray, ImmutableByteArray> {
        var firstIndex = 0
        var secondIndex = size - 1
        val buffer = ByteArray(size)
        for (element in values) {
            if (predicate(element)) {
                buffer[firstIndex] = element
                firstIndex++
            } else {
                buffer[secondIndex] = element
                secondIndex--
            }
        }
        if (firstIndex == 0) return Pair(EMPTY, this)
        if (firstIndex == size) return Pair(this, EMPTY)

        val firstBackingArray = ByteArray(firstIndex)
        System.arraycopy(buffer, 0, firstBackingArray, 0, firstIndex)

        val first = ImmutableByteArray(firstBackingArray)
        val second = ImmutableByteArray(size - first.size) { buffer[size - it - 1] }
        return Pair(first, second)
    }

    /**
     * Leaves this immutable array as is and returns an ImmutableByteArray with all elements sorted
     * according to the natural sort order of the value returned by the [selector].
     *
     * The sort is _stable_ so equal elements preserve their order relative to each other after
     * sorting.
     */
    public inline fun <R : Comparable<R>> sortedBy(crossinline selector: (element: Byte) -> R?): ImmutableByteArray {
        return sortedWith(compareBy(selector))
    }

    /**
     * Leaves this immutable array as is and returns an ImmutableByteArray with all elements sorted
     * according to the reverse natural sort order of the value returned by the [selector].
     *
     * The sort is _stable_ so equal elements preserve their order relative to each other after
     * sorting.
     */
    public inline fun <R : Comparable<R>> sortedByDescending(crossinline selector: (element: Byte) -> R?): ImmutableByteArray {
        return sortedWith(compareByDescending(selector))
    }

    /**
     * Leaves this immutable array as is and returns an [ImmutableByteArray] with all elements
     * sorted according to the specified [comparator].
     */
    public fun sortedWith(comparator: Comparator<in Byte>): ImmutableByteArray {
        // Immutable arrays can't be mutated, so it's safe to return the same array when the ordering won't change
        if (size <= 1) return this

        val temp = values.toTypedArray()
        Arrays.sort(temp, comparator)
        return temp.toImmutableArray()
    }

    /**
     * Returns an immutable array containing only the distinct elements from this immutable array.
     *
     * Iteration order is preserved and subsequent duplicate elements are ignored.
     */
    public fun distinct(): ImmutableByteArray {
        if (size <= 1) return this

        return values.toSet().toImmutableArray()
    }

    /**
     * Returns an immutable array containing only the elements having distinct keys returned by the
     * [selector]
     */
    public inline fun <K> distinctBy(selector: (element: Byte) -> K): ImmutableByteArray {
        val keys = HashSet<K>()
        return filter { keys.add(selector(it)) }
    }

    public companion object {
        @PublishedApi
        internal val EMPTY: ImmutableByteArray = ImmutableByteArray(ByteArray(0))

        /**
         * Returns an ImmutableByteArray instance of the specified [size], where each element is
         * calculated by calling the [init] function.
         *
         * [init] is called sequentially, starting at index 0, to initialize the array with each
         * element at its given index.
         *
         * Implementation:
         * We're using the invoke operator instead of a regular constructor so that we can declare
         * it inline.  The call site will look like a regular constructor call.
         */
        public inline operator fun invoke(size: Int, `init`: (index: Int) -> Byte): ImmutableByteArray {
            if (size == 0) return EMPTY

            val backingArray = ByteArray(size) { index -> init(index) }
            return ImmutableByteArray(backingArray)
        }
    }

    /**
     * Builder to create immutable arrays when the resulting size isn't known in advance.
     *
     * @param initialCapacity The initial capacity of the temporary array where the values are
     * accumulated.  A larger value reduces the number of times it's resized as elements get added.
     */
    public class Builder(
        initialCapacity: Int = 10,
    ) {
        public var size: Int = 0
            private set

        private var values: ByteArray = ByteArray(initialCapacity)

        public fun add(element: Byte): Builder {
            ensureCapacity(size + 1)
            values[size++] = element
            return this
        }

        /**
         * Adds the [element] to the builder.
         */
        public operator fun plusAssign(element: Byte) {
            add(element)
        }

        public fun addAll(elements: ByteArray): Builder {
            ensureCapacity(size + elements.size)
            System.arraycopy(elements, 0, values, size, elements.size)
            size += elements.size
            return this
        }

        public fun addAll(elements: Array<Byte>): Builder {
            ensureCapacity(size + elements.size)
            for (element in elements) {
                values[size++] = element
            }
            return this
        }

        public fun addAll(elements: ImmutableByteArray): Builder {
            ensureCapacity(size + elements.size)
            System.arraycopy(elements.values, 0, values, size, elements.size)
            size += elements.size
            return this
        }

        public fun addAll(elements: ImmutableArray<Byte>): Builder {
            ensureCapacity(size + elements.size)
            for (element in elements) {
                values[size++] = element
            }
            return this
        }

        public fun addAll(elements: Iterable<Byte>): Builder {
            if (elements is Collection) {
                ensureCapacity(size + elements.size)
                for (element in elements) {
                    values[size++] = element
                }
                return this
            }
            for (element in elements) {
                add(element)
            }
            return this
        }

        public fun addAll(elements: Sequence<Byte>): Builder {
            elements.forEach { add(it) }
            return this
        }

        /**
         * Returns an immutable array containing the elements that were added.
         */
        public fun build(): ImmutableByteArray {
            when (size) {
                0 -> return EMPTY
                values.size -> return ImmutableByteArray(values)
            }
            val backingArray = ByteArray(size)
            System.arraycopy(values, 0, backingArray, 0, size)
            return ImmutableByteArray(backingArray)
        }

        private fun ensureCapacity(minCapacity: Int) {
            val newCapacity = BuilderUtils.computeNewCapacity(values.size, minCapacity)
            if (newCapacity == values.size) return

            val replacement = ByteArray(newCapacity)
            System.arraycopy(values, 0, replacement, 0, size)
            values = replacement
        }
    }
}

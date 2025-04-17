// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Array
import kotlin.Boolean
import kotlin.CharSequence
import kotlin.Comparable
import kotlin.Comparator
import kotlin.Double
import kotlin.Float
import kotlin.FloatArray
import kotlin.Int
import kotlin.IntArray
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
import kotlin.random.Random
import kotlin.ranges.IntRange
import kotlin.sequences.Sequence

/**
 * Represents an array that cannot have its elements re-assigned.
 *
 * Although this is a class that wraps a regular array, it's really a zero-cost abstraction that gets eliminated
 * at compile time so that variables of this type end up pointing directly at the underlying array.
 *
 * To preserve the same performance as regular arrays, all functions that simply delegate to the same function on
 * the backing array are marked inline.  This won't result in code duplication as it's a direct substitution
 * replacing calls to the wrapper with direct calls to the underlying functions on the backing array.
 */
@Suppress("NOTHING_TO_INLINE")
@JvmInline
public value class ImmutableFloatArray @PublishedApi internal constructor(
    /**
     * The backing array is internal instead of private so that we can have inline functions that delegate to the same
     * function on the backing array.  The backing array won't be accessible from Kotlin code since the auto-generated
     * arrays are in their own module and the internal modifier prevents outside access.  The constructor is also
     * internal preventing anyone from creating an "instance" that points to an array that they have access to.
     *
     * Attempting to bypass the internal visibility from java won't work since this is an inline class so both the
     * field and constructor are mangled by the Kotlin compiler.  While these might appear to be accessible from Java
     * due to the friendly Kotlin interop, these won't actually exist with those names in the generated bytecode
     * resulting in an unknown symbol exception.
     *
     * Therefore, the combination of being internal in its own module along with inline classes makes this effectively
     * private.
     */
    @PublishedApi
    internal val values: FloatArray,
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
     * See [FloatArray.joinToString]
     */
    public fun joinToString(
        separator: CharSequence = ", ",
        prefix: CharSequence = "",
        postfix: CharSequence = "",
        limit: Int = -1,
        truncated: CharSequence = "...",
        transform: ((element: Float) -> CharSequence)? = null,
    ): String = values.joinToString(separator, prefix, postfix, limit, truncated, transform)

    public operator fun equals(other: ImmutableFloatArray): Boolean {
        if (other.values === this.values) return true
        if (other.size != this.size) return false

        forEachIndexed { index, element ->
            if (other[index] != element) return false
        }
        return true
    }

    /**
     * Immutable Arrays compile to regular arrays in the generated bytecode so this checks if both immutable arrays
     * reference the same array instance.
     *
     * Kotlin doesn't allow checking reference equality of inline-class "instances" since auto-boxing the same
     * immutable array twice can result in two separate wrapper objects that both represent the same immutable array
     * with both wrappers referencing the same backing array instance.  This method allows us to safely check if we're
     * dealing with the same immutable array bypassing the auto-boxing concerns.
     */
    public fun referencesSameArrayAs(other: ImmutableFloatArray): Boolean {
        return other.values === this.values
    }

    override fun hashCode(): Int {
        // Start with non-zero result so arrays that start with a different number of zero-hash elements end
        // up with different hashCodes
        var hashCode = 7
        for (value in values) {
            hashCode = 31 * hashCode + value.hashCode()
        }
        return hashCode
    }

    /**
     * See [FloatArray.isEmpty]
     */
    public inline fun isEmpty(): Boolean = values.isEmpty()

    /**
     * See [FloatArray.isNotEmpty]
     */
    public inline fun isNotEmpty(): Boolean = values.isNotEmpty()

    /**
     * Returns the element at [index]. This method can be called using the index operator.
     */
    public inline operator fun `get`(index: Int): Float = values[index]

    /**
     * See [FloatArray.getOrNull]
     */
    public inline fun getOrNull(index: Int): Float? = values.getOrNull(index)

    public operator fun component1(): Float = get(0)

    public operator fun component2(): Float = get(1)

    public operator fun component3(): Float = get(2)

    public operator fun component4(): Float = get(3)

    public operator fun component5(): Float = get(4)

    /**
     * See [FloatArray.single]
     */
    public inline fun single(): Float = values.single()

    /**
     * See [FloatArray.single]
     */
    public inline fun single(predicate: (element: Float) -> Boolean): Float {
        return values.single(predicate)
    }

    /**
     * See [FloatArray.singleOrNull]
     */
    public inline fun singleOrNull(): Float? = values.singleOrNull()

    /**
     * See [FloatArray.singleOrNull]
     */
    public inline fun singleOrNull(predicate: (element: Float) -> Boolean): Float? {
        return values.singleOrNull(predicate)
    }

    /**
     * See [FloatArray.first]
     */
    public inline fun first(): Float = values.first()

    /**
     * See [FloatArray.first]
     */
    public inline fun first(predicate: (element: Float) -> Boolean): Float {
        return values.first(predicate)
    }

    /**
     * See [FloatArray.firstOrNull]
     */
    public inline fun firstOrNull(): Float? = values.firstOrNull()

    /**
     * See [FloatArray.firstOrNull]
     */
    public inline fun firstOrNull(predicate: (element: Float) -> Boolean): Float? {
        return values.firstOrNull(predicate)
    }

    /**
     * See [FloatArray.last]
     */
    public inline fun last(): Float = values.last()

    /**
     * See [FloatArray.last]
     */
    public inline fun last(predicate: (element: Float) -> Boolean): Float {
        return values.last(predicate)
    }

    /**
     * See [FloatArray.lastOrNull]
     */
    public inline fun lastOrNull(): Float? = values.lastOrNull()

    /**
     * See [FloatArray.lastOrNull]
     */
    public inline fun lastOrNull(predicate: (element: Float) -> Boolean): Float? {
        return values.lastOrNull(predicate)
    }

    /**
     * See [FloatArray.random]
     */
    public inline fun random(): Float = values.random()

    /**
     * See [FloatArray.random]
     */
    public inline fun random(random: Random): Float = values.random(random)

    /**
     * See [FloatArray.randomOrNull]
     */
    public inline fun randomOrNull(): Float? = values.randomOrNull()

    /**
     * See [FloatArray.randomOrNull]
     */
    public inline fun randomOrNull(random: Random): Float? = values.randomOrNull(random)

    /**
     * See [FloatArray.iterator]
     */
    public inline operator fun iterator(): Iterator<Float> = values.iterator()

    /**
     * See [FloatArray.asIterable]
     */
    public inline fun asIterable(): Iterable<Float> = values.asIterable()

    /**
     * See [FloatArray.withIndex]
     */
    public inline fun withIndex(): Iterable<IndexedValue<Float>> = values.withIndex()

    /**
     * See [FloatArray.asSequence]
     */
    public inline fun asSequence(): Sequence<Float> = values.asSequence()

    /**
     * See [FloatArray.forEach]
     */
    public inline fun forEach(action: (element: Float) -> Unit) {
        values.forEach(action)
    }

    /**
     * See [FloatArray.forEachIndexed]
     */
    public inline fun forEachIndexed(action: (index: Int, element: Float) -> Unit) {
        values.forEachIndexed(action)
    }

    /**
     * See [FloatArray.all]
     */
    public inline fun all(predicate: (predicate: Float) -> Boolean): Boolean {
        return values.all(predicate)
    }

    /**
     * See [FloatArray.any]
     */
    public inline fun any(predicate: (predicate: Float) -> Boolean): Boolean {
        return values.any(predicate)
    }

    /**
     * See [FloatArray.none]
     */
    public inline fun none(predicate: (predicate: Float) -> Boolean): Boolean {
        return values.none(predicate)
    }

    /**
     * See [FloatArray.count]
     */
    public inline fun count(predicate: (predicate: Float) -> Boolean): Int {
        return values.count(predicate)
    }

    /**
     * See [FloatArray.indexOfFirst]
     */
    public inline fun indexOfFirst(predicate: (element: Float) -> Boolean): Int {
        return values.indexOfFirst(predicate)
    }

    /**
     * See [FloatArray.indexOfLast]
     */
    public inline fun indexOfLast(predicate: (element: Float) -> Boolean): Int {
        return values.indexOfLast(predicate)
    }

    /**
     * See [FloatArray.sumOf]
     */
    @OverloadResolutionByLambdaReturnType
    public inline fun sumOf(selector: (element: Float) -> Int): Int = values.sumOf(selector)

    /**
     * See [FloatArray.sumOf]
     */
    @OverloadResolutionByLambdaReturnType
    public inline fun sumOf(selector: (element: Float) -> Long): Long = values.sumOf(selector)

    /**
     * See [FloatArray.sumOf]
     */
    @OverloadResolutionByLambdaReturnType
    public inline fun sumOf(selector: (element: Float) -> Double): Double = values.sumOf(selector)

    /**
     * Returns the sum of all values produced by the [selector] function applied to each element.
     */
    @OverloadResolutionByLambdaReturnType
    public inline fun sumOf(selector: (element: Float) -> Float): Float {
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
    public fun take(n: Int): ImmutableFloatArray {
        require(n >= 0) { "Requested element count $n is less than zero." }
        if (n >= size) return this

        return copyFrom(source = values, startIndex = 0, size = n)
    }

    /**
     * Returns an immutable array containing the first elements that satisfy the [predicate].
     */
    public inline fun takeWhile(predicate: (element: Float) -> Boolean): ImmutableFloatArray {
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
    public fun takeLast(n: Int): ImmutableFloatArray {
        require(n >= 0) { "Requested element count $n is less than zero." }
        if (n >= size) return this

        return copyFrom(source = values, startIndex = size - n, size = n)
    }

    /**
     * Returns an immutable array containing the last elements that satisfy the [predicate].
     */
    public inline fun takeLastWhile(predicate: (element: Float) -> Boolean): ImmutableFloatArray {
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
    public fun drop(n: Int): ImmutableFloatArray {
        require(n >= 0) { "Requested element count $n is less than zero." }

        return takeLast((size - n).coerceAtLeast(0))
    }

    /**
     * Returns an immutable array containing all the elements except the first elements that satisfy the [predicate].
     */
    public inline fun dropWhile(predicate: (element: Float) -> Boolean): ImmutableFloatArray {
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
    public fun dropLast(n: Int): ImmutableFloatArray {
        require(n >= 0) { "Requested element count $n is less than zero." }

        return take((size - n).coerceAtLeast(0))
    }

    /**
     * Returns an immutable array containing all the elements except the last elements that satisfy the [predicate].
     */
    public inline fun dropLastWhile(predicate: (element: Float) -> Boolean): ImmutableFloatArray {
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
    public inline fun filter(crossinline predicate: (element: Float) -> Boolean): ImmutableFloatArray {
        // delegate to filterIndexed as that's extremely optimized
        return filterIndexed { _, element -> predicate(element) }
    }

    /**
     * Returns an immutable array containing only the elements matching the given [predicate].
     */
    public inline fun filterIndexed(
        crossinline predicate: (index: Int, element: Float) -> Boolean,
    ): ImmutableFloatArray {
        if (isEmpty()) return this

        val bitmap = createBitmap()
        var resultSize = populateBitmap(bitmap) { index, element -> predicate(index, element) }
        return select(bitmap, resultSize)
    }

    /**
     * Returns an immutable array containing only the elements that don't match the [predicate].
     */
    public inline fun filterNot(crossinline predicate: (element: Float) -> Boolean): ImmutableFloatArray {
        if (isEmpty()) return this

        val bitmap = createBitmap()
        var resultSize = populateBitmap(bitmap) { _, element -> !predicate(element) }
        return select(bitmap, resultSize)
    }

    /**
     * Returns an [IntArray] containing sufficient bits to represent all the element indices.
     */
    @PublishedApi
    internal fun createBitmap(): IntArray {
        // divide by 32 rounding up
        val bitmapSize = (size + 31) ushr 5
        return IntArray(bitmapSize)
    }

    /**
     * Populates the specified [bitmap] with 1-bits at the indices where the elements match the given [predicate].
     *
     * @return the number of 1-bits that the bitmap ends up with.
     */
    @PublishedApi
    internal fun populateBitmap(bitmap: IntArray, predicate: (index: Int, element: Float) -> Boolean): Int {
        var numOneBits = 0
        // the bit index into the current 32-bit int
        var bitIndex = -1 // start at -1 as it gets incremented right away in the loop
        var bitmapIndex = 0
        var currentBits = 0 // the current 32-bits with no elements yet
        forEachIndexed { index, element ->
            if (++bitIndex == 32) {
                // reached the end of the current bits so store them and reset
                bitmap[bitmapIndex++] = currentBits
                currentBits = 0
                bitIndex = 0
            }
            // jit turns this into a branchless operation
            val currentElement = if (predicate(index, element)) 1 else 0

            // conditionally increase the size without branching
            numOneBits += currentElement

            // conditionally include the current element without branching
            currentBits = currentBits or (currentElement shl bitIndex)
        }
        // store the last set of partially-filled bits
        bitmap[bitmapIndex] = currentBits
        return numOneBits
    }

    /**
     * Returns an immutable array containing only the elements from indices where the [bitmap] bits are 1.
     *
     * @param bitmap stored in chunks of 32 bits as an [IntArray] where the 1-bits control which elements are selected
     * @param numOneBits the number of 1-bits present in the [bitmap]
     */
    @PublishedApi
    internal fun select(bitmap: IntArray, numOneBits: Int): ImmutableFloatArray {
        if (numOneBits == 0) return EMPTY
        if (numOneBits == size) return this

        val result = FloatArray(numOneBits)
        var resultIndex = 0
        var bitmapIndex = 0
        var bitIndex = -1
        var currentBits = bitmap[0]
        var originalIndex = 0

        while (resultIndex < numOneBits) {
            if (++bitIndex == 32) {
                // reached the end of the current bits so get the next 32 bits and reset
                currentBits = bitmap[++bitmapIndex]
                bitIndex = 0
            }
            // always copy to avoid branching as resultIndex won't increment if current element isn't included
            result[resultIndex] = this[originalIndex++]
            // increment the resultIndex if the current element should be included
            val currentElement = (currentBits ushr bitIndex) and 1
            resultIndex += currentElement
        }
        return ImmutableFloatArray(result)
    }

    /**
     * Creates a pair of immutable arrays, where the first contains elements for which the predicate yielded true, and
     * the second contains the other elements.
     */
    public fun partition(predicate: (element: Float) -> Boolean): Pair<ImmutableFloatArray, ImmutableFloatArray> {
        var firstIndex = 0
        var secondIndex = size - 1
        val buffer = FloatArray(size)
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

        val first = copyFrom(source = buffer, startIndex = 0, size = firstIndex)
        val second = ImmutableFloatArray(size - first.size) { buffer[size - it - 1] }
        return Pair(first, second)
    }

    /**
     * @return the first element which the [selector] yields the smallest value.
     * @throws NoSuchElementException if this ImmutableFloatArray is empty
     */
    public inline fun <R : Comparable<R>> minBy(selector: (element: Float) -> R): Float {
        var minElement = first()
        if (size == 1) return minElement

        var minValue = selector(minElement)
        for (i in 1..lastIndex) {
            val currentElement = values[i]
            val currentValue = selector(currentElement)
            if (currentValue < minValue) {
                minElement = currentElement
                minValue = currentValue
            }
        }
        return minElement
    }

    /**
     * @return the first element which the [selector] yields the smallest value, or null if empty
     */
    public inline fun <R : Comparable<R>> minByOrNull(selector: (element: Float) -> R): Float? {
        return if (isEmpty()) null else minBy(selector)
    }

    /**
     * @return the first element which the [selector] yields the largest value.
     * @throws NoSuchElementException if this ImmutableFloatArray is empty
     */
    public inline fun <R : Comparable<R>> maxBy(selector: (element: Float) -> R): Float {
        var maxElement = first()
        if (size == 1) return maxElement

        var maxValue = selector(maxElement)
        for (i in 1..lastIndex) {
            val currentElement = values[i]
            val currentValue = selector(currentElement)
            if (currentValue > maxValue) {
                maxElement = currentElement
                maxValue = currentValue
            }
        }
        return maxElement
    }

    /**
     * @return the first element which the [selector] yields the largest value, or null if empty
     */
    public inline fun <R : Comparable<R>> maxByOrNull(selector: (element: Float) -> R): Float? {
        return if (isEmpty()) null else maxBy(selector)
    }

    /**
     * @return the first element having the smallest value according to the provided [comparator].
     * @throws NoSuchElementException if this ImmutableFloatArray is empty
     */
    public fun minWith(comparator: Comparator<in Float>): Float {
        var minElement = first()
        if (size == 1) return minElement

        for (i in 1..lastIndex) {
            val currentElement = values[i]
            if (comparator.compare(minElement, currentElement) > 0) {
                minElement = currentElement
            }
        }
        return minElement
    }

    /**
     * @return the first element having the largest value according to the provided [comparator].
     * @throws NoSuchElementException if this ImmutableFloatArray is empty
     */
    public fun maxWith(comparator: Comparator<in Float>): Float {
        var maxElement = first()
        if (size == 1) return maxElement

        for (i in 1..lastIndex) {
            val currentElement = values[i]
            if (comparator.compare(maxElement, currentElement) < 0) {
                maxElement = currentElement
            }
        }
        return maxElement
    }

    /**
     * Leaves this immutable array as is and returns an ImmutableFloatArray with all elements sorted
     * according to the natural sort order of the value returned by the [selector].
     *
     * The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
     */
    public inline fun <R : Comparable<R>> sortedBy(crossinline selector: (element: Float) -> R?): ImmutableFloatArray {
        return sortedWith(compareBy(selector))
    }

    /**
     * Leaves this immutable array as is and returns an ImmutableFloatArray with all elements sorted
     * according to the reverse natural sort order of the value returned by the [selector].
     *
     * The sort is _stable_ so equal elements preserve their order relative to each other after sorting.
     */
    public inline fun <R : Comparable<R>> sortedByDescending(
        crossinline selector: (element: Float) -> R?,
    ): ImmutableFloatArray {
        return sortedWith(compareByDescending(selector))
    }

    /**
     * Leaves this immutable array as is and returns an [ImmutableFloatArray] with all elements sorted
     * according to the specified [comparator].
     */
    public fun sortedWith(comparator: Comparator<in Float>): ImmutableFloatArray {
        if (size <= 1) return this

        val temp = values.toTypedArray()
        temp.sortWith(comparator)
        return temp.toImmutableArray()
    }

    /**
     * Leaves this immutable array as is and returns an [ImmutableFloatArray] with all elements shuffled.
     */
    public fun shuffled(): ImmutableFloatArray {
        if (size <= 1) return this

        val backingArray = values.copyOf().apply { shuffle() }
        return ImmutableFloatArray(backingArray)
    }

    /**
     * Leaves this immutable array as is and returns an [ImmutableFloatArray] with all elements shuffled.
     */
    public fun shuffled(random: Random): ImmutableFloatArray {
        if (size <= 1) return this

        val backingArray = values.copyOf().apply { shuffle(random) }
        return ImmutableFloatArray(backingArray)
    }

    /**
     * Returns an immutable array containing only the distinct elements from this immutable array.
     *
     * Iteration order is preserved and subsequent duplicate elements are ignored.
     */
    public fun distinct(): ImmutableFloatArray {
        if (size <= 1) return this

        val distinctValues = HashSet<Float>()
        return filter { distinctValues.add(it) }
    }

    /**
     * Returns an immutable array containing only the elements having distinct keys returned by the [selector]
     */
    public inline fun <K> distinctBy(crossinline selector: (element: Float) -> K): ImmutableFloatArray {
        if (size <= 1) return this

        val keys = HashSet<K>()
        return filter { keys.add(selector(it)) }
    }

    public companion object {
        @PublishedApi
        internal val EMPTY: ImmutableFloatArray = ImmutableFloatArray(FloatArray(0))

        /**
         * Returns an ImmutableFloatArray instance of the specified [size], where each element is calculated by
         * calling the [init] function.
         *
         * [init] is called sequentially, starting at index 0, to initialize the array with each element at its given
         * index.
         *
         * Implementation:
         * We're using the invoke operator instead of a regular constructor so that we can declare it inline.  The call
         * site will look like a regular constructor call.
         */
        public inline operator fun invoke(size: Int, `init`: (index: Int) -> Float): ImmutableFloatArray {
            if (size == 0) return EMPTY

            val backingArray = FloatArray(size) { index -> init(index) }
            return ImmutableFloatArray(backingArray)
        }

        /**
         * Returns an ImmutableFloatArray with the first [size] elements copied from [source] starting from [startIndex].
         */
        public fun copyFrom(
            source: FloatArray,
            startIndex: Int,
            size: Int,
        ): ImmutableFloatArray {
            if (size == 0) return EMPTY

            val backingArray = FloatArray(size)
            System.arraycopy(source, startIndex, backingArray, 0, size)
            return ImmutableFloatArray(backingArray)
        }
    }

    /**
     * Builder to create immutable arrays when the resulting size isn't known in advance.
     *
     * @param initialCapacity The initial capacity of the temporary array where the values are
     * accumulated.  A larger value reduces the number of times it's resized as elements get added.
     */
    public class Builder(initialCapacity: Int = 10) {
        public var size: Int = 0
            private set

        private var values: FloatArray = FloatArray(initialCapacity)

        public fun add(element: Float): Builder {
            ensureCapacity(size + 1)
            values[size++] = element
            return this
        }

        /**
         * Adds the [element] to the builder.
         */
        public operator fun plusAssign(element: Float) {
            add(element)
        }

        public fun addAll(elements: FloatArray): Builder {
            ensureCapacity(size + elements.size)
            System.arraycopy(elements, 0, values, size, elements.size)
            size += elements.size
            return this
        }

        public fun addAll(elements: Array<Float>): Builder {
            ensureCapacity(size + elements.size)
            for (element in elements) {
                values[size++] = element
            }
            return this
        }

        public fun addAll(elements: ImmutableFloatArray): Builder {
            ensureCapacity(size + elements.size)
            System.arraycopy(elements.values, 0, values, size, elements.size)
            size += elements.size
            return this
        }

        public fun addAll(elements: ImmutableArray<Float>): Builder {
            ensureCapacity(size + elements.size)
            for (element in elements) {
                values[size++] = element
            }
            return this
        }

        public fun addAll(elements: Iterable<Float>): Builder {
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

        public fun addAll(elements: Sequence<Float>): Builder {
            elements.forEach { add(it) }
            return this
        }

        /**
         * Returns an immutable array containing the elements that were added.
         */
        public fun build(): ImmutableFloatArray {
            if (size == 0) return EMPTY
            if (size == values.size) return ImmutableFloatArray(values)

            return copyFrom(source = values, startIndex = 0, size = size)
        }

        private fun ensureCapacity(minCapacity: Int) {
            val newCapacity = BuilderUtils.computeNewCapacity(values.size, minCapacity)
            if (newCapacity == values.size) return

            values = values.copyOf(newCapacity)
        }
    }
}

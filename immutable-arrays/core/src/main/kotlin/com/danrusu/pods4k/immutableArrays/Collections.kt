// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Any
import kotlin.Boolean
import kotlin.Byte
import kotlin.Char
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Short
import kotlin.collections.Collection
import kotlin.collections.Iterable
import kotlin.collections.MutableCollection
import kotlin.jvm.JvmName

/**
 * Returns an [ImmutableArray] with the contents of [this] collection.
 */
public fun <T> Iterable<T>.toImmutableArray(): ImmutableArray<T> {
    val initialCapacity = when (this) {
        is Collection<T> -> size
        else -> 10
    }
    return buildImmutableArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableBooleanArray] with the contents of [this] collection.
 */
public fun Iterable<Boolean>.toImmutableArray(): ImmutableBooleanArray {
    val initialCapacity = when (this) {
        is Collection<Boolean> -> size
        else -> 10
    }
    return buildImmutableBooleanArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableByteArray] with the contents of [this] collection.
 */
public fun Iterable<Byte>.toImmutableArray(): ImmutableByteArray {
    val initialCapacity = when (this) {
        is Collection<Byte> -> size
        else -> 10
    }
    return buildImmutableByteArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableCharArray] with the contents of [this] collection.
 */
public fun Iterable<Char>.toImmutableArray(): ImmutableCharArray {
    val initialCapacity = when (this) {
        is Collection<Char> -> size
        else -> 10
    }
    return buildImmutableCharArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableShortArray] with the contents of [this] collection.
 */
public fun Iterable<Short>.toImmutableArray(): ImmutableShortArray {
    val initialCapacity = when (this) {
        is Collection<Short> -> size
        else -> 10
    }
    return buildImmutableShortArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableIntArray] with the contents of [this] collection.
 */
public fun Iterable<Int>.toImmutableArray(): ImmutableIntArray {
    val initialCapacity = when (this) {
        is Collection<Int> -> size
        else -> 10
    }
    return buildImmutableIntArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableLongArray] with the contents of [this] collection.
 */
public fun Iterable<Long>.toImmutableArray(): ImmutableLongArray {
    val initialCapacity = when (this) {
        is Collection<Long> -> size
        else -> 10
    }
    return buildImmutableLongArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableFloatArray] with the contents of [this] collection.
 */
public fun Iterable<Float>.toImmutableArray(): ImmutableFloatArray {
    val initialCapacity = when (this) {
        is Collection<Float> -> size
        else -> 10
    }
    return buildImmutableFloatArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Returns an [ImmutableDoubleArray] with the contents of [this] collection.
 */
public fun Iterable<Double>.toImmutableArray(): ImmutableDoubleArray {
    val initialCapacity = when (this) {
        is Collection<Double> -> size
        else -> 10
    }
    return buildImmutableDoubleArray(initialCapacity) {
        addAll(this@toImmutableArray)
    }
}

/**
 * Checks whether [this] collection contains all the elements from the specified immutable array
 */
public fun <T> Collection<T>.containsAll(elements: ImmutableArray<T>): Boolean {
    return containsAll(elements.asList())
}

/**
 * Checks whether [this] collection contains all the elements from the specified immutable array
 */
public fun Collection<Any?>.containsAll(elements: ImmutableBooleanArray): Boolean {
    return containsAll(elements.asList())
}

/**
 * Checks whether [this] collection contains all the elements from the specified immutable array
 */
public fun Collection<Any?>.containsAll(elements: ImmutableByteArray): Boolean {
    return containsAll(elements.asList())
}

/**
 * Checks whether [this] collection contains all the elements from the specified immutable array
 */
public fun Collection<Any?>.containsAll(elements: ImmutableCharArray): Boolean {
    return containsAll(elements.asList())
}

/**
 * Checks whether [this] collection contains all the elements from the specified immutable array
 */
public fun Collection<Any?>.containsAll(elements: ImmutableShortArray): Boolean {
    return containsAll(elements.asList())
}

/**
 * Checks whether [this] collection contains all the elements from the specified immutable array
 */
public fun Collection<Any?>.containsAll(elements: ImmutableIntArray): Boolean {
    return containsAll(elements.asList())
}

/**
 * Checks whether [this] collection contains all the elements from the specified immutable array
 */
public fun Collection<Any?>.containsAll(elements: ImmutableLongArray): Boolean {
    return containsAll(elements.asList())
}

/**
 * Checks whether [this] collection contains all the elements from the specified immutable array
 */
public fun Collection<Any?>.containsAll(elements: ImmutableFloatArray): Boolean {
    return containsAll(elements.asList())
}

/**
 * Checks whether [this] collection contains all the elements from the specified immutable array
 */
public fun Collection<Any?>.containsAll(elements: ImmutableDoubleArray): Boolean {
    return containsAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun <T> MutableCollection<in T>.addAll(elements: ImmutableArray<T>): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Boolean>.addAll(elements: ImmutableBooleanArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Byte>.addAll(elements: ImmutableByteArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Char>.addAll(elements: ImmutableCharArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Short>.addAll(elements: ImmutableShortArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Int>.addAll(elements: ImmutableIntArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Long>.addAll(elements: ImmutableLongArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Float>.addAll(elements: ImmutableFloatArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Adds all the elements to [this] collection.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Double>.addAll(elements: ImmutableDoubleArray): Boolean {
    // Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step
    return addAll(elements.asList())
}

/**
 * Removes all the elements from [this] collection.
 *
 * Note that if the immutable array contains duplicate elements then it might be more efficient to
 * convert the immutable array to a set first and remove the set from the collection instead.
 *
 * @return true if the collection changed.
 */
public fun <T> MutableCollection<in T>.removeAll(elements: ImmutableArray<T>): Boolean {
    return removeAll(elements.asList())
}

/**
 * Removes all the elements from [this] collection.
 *
 * Note that if the immutable array contains duplicate elements then it might be more efficient to
 * convert the immutable array to a set first and remove the set from the collection instead.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Boolean>.removeAll(elements: ImmutableBooleanArray): Boolean {
    return removeAll(elements.asList())
}

/**
 * Removes all the elements from [this] collection.
 *
 * Note that if the immutable array contains duplicate elements then it might be more efficient to
 * convert the immutable array to a set first and remove the set from the collection instead.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Byte>.removeAll(elements: ImmutableByteArray): Boolean {
    return removeAll(elements.asList())
}

/**
 * Removes all the elements from [this] collection.
 *
 * Note that if the immutable array contains duplicate elements then it might be more efficient to
 * convert the immutable array to a set first and remove the set from the collection instead.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Char>.removeAll(elements: ImmutableCharArray): Boolean {
    return removeAll(elements.asList())
}

/**
 * Removes all the elements from [this] collection.
 *
 * Note that if the immutable array contains duplicate elements then it might be more efficient to
 * convert the immutable array to a set first and remove the set from the collection instead.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Short>.removeAll(elements: ImmutableShortArray): Boolean {
    return removeAll(elements.asList())
}

/**
 * Removes all the elements from [this] collection.
 *
 * Note that if the immutable array contains duplicate elements then it might be more efficient to
 * convert the immutable array to a set first and remove the set from the collection instead.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Int>.removeAll(elements: ImmutableIntArray): Boolean {
    return removeAll(elements.asList())
}

/**
 * Removes all the elements from [this] collection.
 *
 * Note that if the immutable array contains duplicate elements then it might be more efficient to
 * convert the immutable array to a set first and remove the set from the collection instead.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Long>.removeAll(elements: ImmutableLongArray): Boolean {
    return removeAll(elements.asList())
}

/**
 * Removes all the elements from [this] collection.
 *
 * Note that if the immutable array contains duplicate elements then it might be more efficient to
 * convert the immutable array to a set first and remove the set from the collection instead.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Float>.removeAll(elements: ImmutableFloatArray): Boolean {
    return removeAll(elements.asList())
}

/**
 * Removes all the elements from [this] collection.
 *
 * Note that if the immutable array contains duplicate elements then it might be more efficient to
 * convert the immutable array to a set first and remove the set from the collection instead.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Double>.removeAll(elements: ImmutableDoubleArray): Boolean {
    return removeAll(elements.asList())
}

/**
 * Retains only the elements in [this] collection that are contained in the specified immutable
 * array.
 *
 * @return true if the collection changed.
 */
public fun <T> MutableCollection<in T>.retainAll(elements: ImmutableArray<T>): Boolean {
    return retainAll(elements.asList())
}

/**
 * Retains only the elements in [this] collection that are contained in the specified immutable
 * array.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Boolean>.retainAll(elements: ImmutableBooleanArray): Boolean {
    return retainAll(elements.asList())
}

/**
 * Retains only the elements in [this] collection that are contained in the specified immutable
 * array.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Byte>.retainAll(elements: ImmutableByteArray): Boolean {
    return retainAll(elements.asList())
}

/**
 * Retains only the elements in [this] collection that are contained in the specified immutable
 * array.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Char>.retainAll(elements: ImmutableCharArray): Boolean {
    return retainAll(elements.asList())
}

/**
 * Retains only the elements in [this] collection that are contained in the specified immutable
 * array.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Short>.retainAll(elements: ImmutableShortArray): Boolean {
    return retainAll(elements.asList())
}

/**
 * Retains only the elements in [this] collection that are contained in the specified immutable
 * array.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Int>.retainAll(elements: ImmutableIntArray): Boolean {
    return retainAll(elements.asList())
}

/**
 * Retains only the elements in [this] collection that are contained in the specified immutable
 * array.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Long>.retainAll(elements: ImmutableLongArray): Boolean {
    return retainAll(elements.asList())
}

/**
 * Retains only the elements in [this] collection that are contained in the specified immutable
 * array.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Float>.retainAll(elements: ImmutableFloatArray): Boolean {
    return retainAll(elements.asList())
}

/**
 * Retains only the elements in [this] collection that are contained in the specified immutable
 * array.
 *
 * @return true if the collection changed.
 */
public fun MutableCollection<in Double>.retainAll(elements: ImmutableDoubleArray): Boolean {
    return retainAll(elements.asList())
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableArray")
public fun <T> Iterable<ImmutableArray<T>>.flatten(): ImmutableArray<T> {
    return buildImmutableArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableBooleanArray")
public fun Iterable<ImmutableBooleanArray>.flatten(): ImmutableBooleanArray {
    return buildImmutableBooleanArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableBooleanArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableByteArray")
public fun Iterable<ImmutableByteArray>.flatten(): ImmutableByteArray {
    return buildImmutableByteArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableByteArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableCharArray")
public fun Iterable<ImmutableCharArray>.flatten(): ImmutableCharArray {
    return buildImmutableCharArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableCharArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableShortArray")
public fun Iterable<ImmutableShortArray>.flatten(): ImmutableShortArray {
    return buildImmutableShortArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableShortArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableIntArray")
public fun Iterable<ImmutableIntArray>.flatten(): ImmutableIntArray {
    return buildImmutableIntArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableIntArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableLongArray")
public fun Iterable<ImmutableLongArray>.flatten(): ImmutableLongArray {
    return buildImmutableLongArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableLongArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableFloatArray")
public fun Iterable<ImmutableFloatArray>.flatten(): ImmutableFloatArray {
    return buildImmutableFloatArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableFloatArray.addAll(nestedArray)
        }
    }
}

/**
 * Returns a single immutable array with all the elements from all nested arrays.
 */
@JvmName("flatten_ImmutableDoubleArray")
public fun Iterable<ImmutableDoubleArray>.flatten(): ImmutableDoubleArray {
    return buildImmutableDoubleArray {
        for (nestedArray in this@flatten) {
            this@buildImmutableDoubleArray.addAll(nestedArray)
        }
    }
}

// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.ImmutableBooleanArray
import com.danrusu.pods4k.immutableArrays.ImmutableByteArray
import com.danrusu.pods4k.immutableArrays.ImmutableCharArray
import com.danrusu.pods4k.immutableArrays.ImmutableDoubleArray
import com.danrusu.pods4k.immutableArrays.ImmutableFloatArray
import com.danrusu.pods4k.immutableArrays.ImmutableIntArray
import com.danrusu.pods4k.immutableArrays.ImmutableLongArray
import com.danrusu.pods4k.immutableArrays.ImmutableShortArray
import kotlin.Boolean
import kotlin.Byte
import kotlin.Char
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Pair
import kotlin.Short
import kotlin.jvm.JvmName

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_GENERIC_GENERIC")
public fun <T, R> ImmutableArray<Pair<T, R>>.unzip(): Pair<ImmutableArray<T>, ImmutableArray<R>> {
    val first = ImmutableArray.Builder<T>(initialCapacity = size)
    val second = ImmutableArray.Builder<R>(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_GENERIC_BOOLEAN")
public fun <T> ImmutableArray<Pair<T, Boolean>>.unzip(): Pair<ImmutableArray<T>, ImmutableBooleanArray> {
    val first = ImmutableArray.Builder<T>(initialCapacity = size)
    val second = ImmutableBooleanArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_GENERIC_BYTE")
public fun <T> ImmutableArray<Pair<T, Byte>>.unzip(): Pair<ImmutableArray<T>, ImmutableByteArray> {
    val first = ImmutableArray.Builder<T>(initialCapacity = size)
    val second = ImmutableByteArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_GENERIC_CHAR")
public fun <T> ImmutableArray<Pair<T, Char>>.unzip(): Pair<ImmutableArray<T>, ImmutableCharArray> {
    val first = ImmutableArray.Builder<T>(initialCapacity = size)
    val second = ImmutableCharArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_GENERIC_SHORT")
public fun <T> ImmutableArray<Pair<T, Short>>.unzip(): Pair<ImmutableArray<T>, ImmutableShortArray> {
    val first = ImmutableArray.Builder<T>(initialCapacity = size)
    val second = ImmutableShortArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_GENERIC_INT")
public fun <T> ImmutableArray<Pair<T, Int>>.unzip(): Pair<ImmutableArray<T>, ImmutableIntArray> {
    val first = ImmutableArray.Builder<T>(initialCapacity = size)
    val second = ImmutableIntArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_GENERIC_LONG")
public fun <T> ImmutableArray<Pair<T, Long>>.unzip(): Pair<ImmutableArray<T>, ImmutableLongArray> {
    val first = ImmutableArray.Builder<T>(initialCapacity = size)
    val second = ImmutableLongArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_GENERIC_FLOAT")
public fun <T> ImmutableArray<Pair<T, Float>>.unzip(): Pair<ImmutableArray<T>, ImmutableFloatArray> {
    val first = ImmutableArray.Builder<T>(initialCapacity = size)
    val second = ImmutableFloatArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_GENERIC_DOUBLE")
public fun <T> ImmutableArray<Pair<T, Double>>.unzip(): Pair<ImmutableArray<T>, ImmutableDoubleArray> {
    val first = ImmutableArray.Builder<T>(initialCapacity = size)
    val second = ImmutableDoubleArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BOOLEAN_GENERIC")
public fun <R> ImmutableArray<Pair<Boolean, R>>.unzip(): Pair<ImmutableBooleanArray, ImmutableArray<R>> {
    val first = ImmutableBooleanArray.Builder(initialCapacity = size)
    val second = ImmutableArray.Builder<R>(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BOOLEAN_BOOLEAN")
public fun ImmutableArray<Pair<Boolean, Boolean>>.unzip(): Pair<ImmutableBooleanArray, ImmutableBooleanArray> {
    val first = ImmutableBooleanArray.Builder(initialCapacity = size)
    val second = ImmutableBooleanArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BOOLEAN_BYTE")
public fun ImmutableArray<Pair<Boolean, Byte>>.unzip(): Pair<ImmutableBooleanArray, ImmutableByteArray> {
    val first = ImmutableBooleanArray.Builder(initialCapacity = size)
    val second = ImmutableByteArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BOOLEAN_CHAR")
public fun ImmutableArray<Pair<Boolean, Char>>.unzip(): Pair<ImmutableBooleanArray, ImmutableCharArray> {
    val first = ImmutableBooleanArray.Builder(initialCapacity = size)
    val second = ImmutableCharArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BOOLEAN_SHORT")
public fun ImmutableArray<Pair<Boolean, Short>>.unzip(): Pair<ImmutableBooleanArray, ImmutableShortArray> {
    val first = ImmutableBooleanArray.Builder(initialCapacity = size)
    val second = ImmutableShortArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BOOLEAN_INT")
public fun ImmutableArray<Pair<Boolean, Int>>.unzip(): Pair<ImmutableBooleanArray, ImmutableIntArray> {
    val first = ImmutableBooleanArray.Builder(initialCapacity = size)
    val second = ImmutableIntArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BOOLEAN_LONG")
public fun ImmutableArray<Pair<Boolean, Long>>.unzip(): Pair<ImmutableBooleanArray, ImmutableLongArray> {
    val first = ImmutableBooleanArray.Builder(initialCapacity = size)
    val second = ImmutableLongArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BOOLEAN_FLOAT")
public fun ImmutableArray<Pair<Boolean, Float>>.unzip(): Pair<ImmutableBooleanArray, ImmutableFloatArray> {
    val first = ImmutableBooleanArray.Builder(initialCapacity = size)
    val second = ImmutableFloatArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BOOLEAN_DOUBLE")
public fun ImmutableArray<Pair<Boolean, Double>>.unzip(): Pair<ImmutableBooleanArray, ImmutableDoubleArray> {
    val first = ImmutableBooleanArray.Builder(initialCapacity = size)
    val second = ImmutableDoubleArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BYTE_GENERIC")
public fun <R> ImmutableArray<Pair<Byte, R>>.unzip(): Pair<ImmutableByteArray, ImmutableArray<R>> {
    val first = ImmutableByteArray.Builder(initialCapacity = size)
    val second = ImmutableArray.Builder<R>(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BYTE_BOOLEAN")
public fun ImmutableArray<Pair<Byte, Boolean>>.unzip(): Pair<ImmutableByteArray, ImmutableBooleanArray> {
    val first = ImmutableByteArray.Builder(initialCapacity = size)
    val second = ImmutableBooleanArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BYTE_BYTE")
public fun ImmutableArray<Pair<Byte, Byte>>.unzip(): Pair<ImmutableByteArray, ImmutableByteArray> {
    val first = ImmutableByteArray.Builder(initialCapacity = size)
    val second = ImmutableByteArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BYTE_CHAR")
public fun ImmutableArray<Pair<Byte, Char>>.unzip(): Pair<ImmutableByteArray, ImmutableCharArray> {
    val first = ImmutableByteArray.Builder(initialCapacity = size)
    val second = ImmutableCharArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BYTE_SHORT")
public fun ImmutableArray<Pair<Byte, Short>>.unzip(): Pair<ImmutableByteArray, ImmutableShortArray> {
    val first = ImmutableByteArray.Builder(initialCapacity = size)
    val second = ImmutableShortArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BYTE_INT")
public fun ImmutableArray<Pair<Byte, Int>>.unzip(): Pair<ImmutableByteArray, ImmutableIntArray> {
    val first = ImmutableByteArray.Builder(initialCapacity = size)
    val second = ImmutableIntArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BYTE_LONG")
public fun ImmutableArray<Pair<Byte, Long>>.unzip(): Pair<ImmutableByteArray, ImmutableLongArray> {
    val first = ImmutableByteArray.Builder(initialCapacity = size)
    val second = ImmutableLongArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BYTE_FLOAT")
public fun ImmutableArray<Pair<Byte, Float>>.unzip(): Pair<ImmutableByteArray, ImmutableFloatArray> {
    val first = ImmutableByteArray.Builder(initialCapacity = size)
    val second = ImmutableFloatArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_BYTE_DOUBLE")
public fun ImmutableArray<Pair<Byte, Double>>.unzip(): Pair<ImmutableByteArray, ImmutableDoubleArray> {
    val first = ImmutableByteArray.Builder(initialCapacity = size)
    val second = ImmutableDoubleArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_CHAR_GENERIC")
public fun <R> ImmutableArray<Pair<Char, R>>.unzip(): Pair<ImmutableCharArray, ImmutableArray<R>> {
    val first = ImmutableCharArray.Builder(initialCapacity = size)
    val second = ImmutableArray.Builder<R>(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_CHAR_BOOLEAN")
public fun ImmutableArray<Pair<Char, Boolean>>.unzip(): Pair<ImmutableCharArray, ImmutableBooleanArray> {
    val first = ImmutableCharArray.Builder(initialCapacity = size)
    val second = ImmutableBooleanArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_CHAR_BYTE")
public fun ImmutableArray<Pair<Char, Byte>>.unzip(): Pair<ImmutableCharArray, ImmutableByteArray> {
    val first = ImmutableCharArray.Builder(initialCapacity = size)
    val second = ImmutableByteArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_CHAR_CHAR")
public fun ImmutableArray<Pair<Char, Char>>.unzip(): Pair<ImmutableCharArray, ImmutableCharArray> {
    val first = ImmutableCharArray.Builder(initialCapacity = size)
    val second = ImmutableCharArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_CHAR_SHORT")
public fun ImmutableArray<Pair<Char, Short>>.unzip(): Pair<ImmutableCharArray, ImmutableShortArray> {
    val first = ImmutableCharArray.Builder(initialCapacity = size)
    val second = ImmutableShortArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_CHAR_INT")
public fun ImmutableArray<Pair<Char, Int>>.unzip(): Pair<ImmutableCharArray, ImmutableIntArray> {
    val first = ImmutableCharArray.Builder(initialCapacity = size)
    val second = ImmutableIntArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_CHAR_LONG")
public fun ImmutableArray<Pair<Char, Long>>.unzip(): Pair<ImmutableCharArray, ImmutableLongArray> {
    val first = ImmutableCharArray.Builder(initialCapacity = size)
    val second = ImmutableLongArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_CHAR_FLOAT")
public fun ImmutableArray<Pair<Char, Float>>.unzip(): Pair<ImmutableCharArray, ImmutableFloatArray> {
    val first = ImmutableCharArray.Builder(initialCapacity = size)
    val second = ImmutableFloatArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_CHAR_DOUBLE")
public fun ImmutableArray<Pair<Char, Double>>.unzip(): Pair<ImmutableCharArray, ImmutableDoubleArray> {
    val first = ImmutableCharArray.Builder(initialCapacity = size)
    val second = ImmutableDoubleArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_SHORT_GENERIC")
public fun <R> ImmutableArray<Pair<Short, R>>.unzip(): Pair<ImmutableShortArray, ImmutableArray<R>> {
    val first = ImmutableShortArray.Builder(initialCapacity = size)
    val second = ImmutableArray.Builder<R>(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_SHORT_BOOLEAN")
public fun ImmutableArray<Pair<Short, Boolean>>.unzip(): Pair<ImmutableShortArray, ImmutableBooleanArray> {
    val first = ImmutableShortArray.Builder(initialCapacity = size)
    val second = ImmutableBooleanArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_SHORT_BYTE")
public fun ImmutableArray<Pair<Short, Byte>>.unzip(): Pair<ImmutableShortArray, ImmutableByteArray> {
    val first = ImmutableShortArray.Builder(initialCapacity = size)
    val second = ImmutableByteArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_SHORT_CHAR")
public fun ImmutableArray<Pair<Short, Char>>.unzip(): Pair<ImmutableShortArray, ImmutableCharArray> {
    val first = ImmutableShortArray.Builder(initialCapacity = size)
    val second = ImmutableCharArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_SHORT_SHORT")
public fun ImmutableArray<Pair<Short, Short>>.unzip(): Pair<ImmutableShortArray, ImmutableShortArray> {
    val first = ImmutableShortArray.Builder(initialCapacity = size)
    val second = ImmutableShortArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_SHORT_INT")
public fun ImmutableArray<Pair<Short, Int>>.unzip(): Pair<ImmutableShortArray, ImmutableIntArray> {
    val first = ImmutableShortArray.Builder(initialCapacity = size)
    val second = ImmutableIntArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_SHORT_LONG")
public fun ImmutableArray<Pair<Short, Long>>.unzip(): Pair<ImmutableShortArray, ImmutableLongArray> {
    val first = ImmutableShortArray.Builder(initialCapacity = size)
    val second = ImmutableLongArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_SHORT_FLOAT")
public fun ImmutableArray<Pair<Short, Float>>.unzip(): Pair<ImmutableShortArray, ImmutableFloatArray> {
    val first = ImmutableShortArray.Builder(initialCapacity = size)
    val second = ImmutableFloatArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_SHORT_DOUBLE")
public fun ImmutableArray<Pair<Short, Double>>.unzip(): Pair<ImmutableShortArray, ImmutableDoubleArray> {
    val first = ImmutableShortArray.Builder(initialCapacity = size)
    val second = ImmutableDoubleArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_INT_GENERIC")
public fun <R> ImmutableArray<Pair<Int, R>>.unzip(): Pair<ImmutableIntArray, ImmutableArray<R>> {
    val first = ImmutableIntArray.Builder(initialCapacity = size)
    val second = ImmutableArray.Builder<R>(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_INT_BOOLEAN")
public fun ImmutableArray<Pair<Int, Boolean>>.unzip(): Pair<ImmutableIntArray, ImmutableBooleanArray> {
    val first = ImmutableIntArray.Builder(initialCapacity = size)
    val second = ImmutableBooleanArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_INT_BYTE")
public fun ImmutableArray<Pair<Int, Byte>>.unzip(): Pair<ImmutableIntArray, ImmutableByteArray> {
    val first = ImmutableIntArray.Builder(initialCapacity = size)
    val second = ImmutableByteArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_INT_CHAR")
public fun ImmutableArray<Pair<Int, Char>>.unzip(): Pair<ImmutableIntArray, ImmutableCharArray> {
    val first = ImmutableIntArray.Builder(initialCapacity = size)
    val second = ImmutableCharArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_INT_SHORT")
public fun ImmutableArray<Pair<Int, Short>>.unzip(): Pair<ImmutableIntArray, ImmutableShortArray> {
    val first = ImmutableIntArray.Builder(initialCapacity = size)
    val second = ImmutableShortArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_INT_INT")
public fun ImmutableArray<Pair<Int, Int>>.unzip(): Pair<ImmutableIntArray, ImmutableIntArray> {
    val first = ImmutableIntArray.Builder(initialCapacity = size)
    val second = ImmutableIntArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_INT_LONG")
public fun ImmutableArray<Pair<Int, Long>>.unzip(): Pair<ImmutableIntArray, ImmutableLongArray> {
    val first = ImmutableIntArray.Builder(initialCapacity = size)
    val second = ImmutableLongArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_INT_FLOAT")
public fun ImmutableArray<Pair<Int, Float>>.unzip(): Pair<ImmutableIntArray, ImmutableFloatArray> {
    val first = ImmutableIntArray.Builder(initialCapacity = size)
    val second = ImmutableFloatArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_INT_DOUBLE")
public fun ImmutableArray<Pair<Int, Double>>.unzip(): Pair<ImmutableIntArray, ImmutableDoubleArray> {
    val first = ImmutableIntArray.Builder(initialCapacity = size)
    val second = ImmutableDoubleArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_LONG_GENERIC")
public fun <R> ImmutableArray<Pair<Long, R>>.unzip(): Pair<ImmutableLongArray, ImmutableArray<R>> {
    val first = ImmutableLongArray.Builder(initialCapacity = size)
    val second = ImmutableArray.Builder<R>(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_LONG_BOOLEAN")
public fun ImmutableArray<Pair<Long, Boolean>>.unzip(): Pair<ImmutableLongArray, ImmutableBooleanArray> {
    val first = ImmutableLongArray.Builder(initialCapacity = size)
    val second = ImmutableBooleanArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_LONG_BYTE")
public fun ImmutableArray<Pair<Long, Byte>>.unzip(): Pair<ImmutableLongArray, ImmutableByteArray> {
    val first = ImmutableLongArray.Builder(initialCapacity = size)
    val second = ImmutableByteArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_LONG_CHAR")
public fun ImmutableArray<Pair<Long, Char>>.unzip(): Pair<ImmutableLongArray, ImmutableCharArray> {
    val first = ImmutableLongArray.Builder(initialCapacity = size)
    val second = ImmutableCharArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_LONG_SHORT")
public fun ImmutableArray<Pair<Long, Short>>.unzip(): Pair<ImmutableLongArray, ImmutableShortArray> {
    val first = ImmutableLongArray.Builder(initialCapacity = size)
    val second = ImmutableShortArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_LONG_INT")
public fun ImmutableArray<Pair<Long, Int>>.unzip(): Pair<ImmutableLongArray, ImmutableIntArray> {
    val first = ImmutableLongArray.Builder(initialCapacity = size)
    val second = ImmutableIntArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_LONG_LONG")
public fun ImmutableArray<Pair<Long, Long>>.unzip(): Pair<ImmutableLongArray, ImmutableLongArray> {
    val first = ImmutableLongArray.Builder(initialCapacity = size)
    val second = ImmutableLongArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_LONG_FLOAT")
public fun ImmutableArray<Pair<Long, Float>>.unzip(): Pair<ImmutableLongArray, ImmutableFloatArray> {
    val first = ImmutableLongArray.Builder(initialCapacity = size)
    val second = ImmutableFloatArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_LONG_DOUBLE")
public fun ImmutableArray<Pair<Long, Double>>.unzip(): Pair<ImmutableLongArray, ImmutableDoubleArray> {
    val first = ImmutableLongArray.Builder(initialCapacity = size)
    val second = ImmutableDoubleArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_FLOAT_GENERIC")
public fun <R> ImmutableArray<Pair<Float, R>>.unzip(): Pair<ImmutableFloatArray, ImmutableArray<R>> {
    val first = ImmutableFloatArray.Builder(initialCapacity = size)
    val second = ImmutableArray.Builder<R>(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_FLOAT_BOOLEAN")
public fun ImmutableArray<Pair<Float, Boolean>>.unzip(): Pair<ImmutableFloatArray, ImmutableBooleanArray> {
    val first = ImmutableFloatArray.Builder(initialCapacity = size)
    val second = ImmutableBooleanArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_FLOAT_BYTE")
public fun ImmutableArray<Pair<Float, Byte>>.unzip(): Pair<ImmutableFloatArray, ImmutableByteArray> {
    val first = ImmutableFloatArray.Builder(initialCapacity = size)
    val second = ImmutableByteArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_FLOAT_CHAR")
public fun ImmutableArray<Pair<Float, Char>>.unzip(): Pair<ImmutableFloatArray, ImmutableCharArray> {
    val first = ImmutableFloatArray.Builder(initialCapacity = size)
    val second = ImmutableCharArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_FLOAT_SHORT")
public fun ImmutableArray<Pair<Float, Short>>.unzip(): Pair<ImmutableFloatArray, ImmutableShortArray> {
    val first = ImmutableFloatArray.Builder(initialCapacity = size)
    val second = ImmutableShortArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_FLOAT_INT")
public fun ImmutableArray<Pair<Float, Int>>.unzip(): Pair<ImmutableFloatArray, ImmutableIntArray> {
    val first = ImmutableFloatArray.Builder(initialCapacity = size)
    val second = ImmutableIntArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_FLOAT_LONG")
public fun ImmutableArray<Pair<Float, Long>>.unzip(): Pair<ImmutableFloatArray, ImmutableLongArray> {
    val first = ImmutableFloatArray.Builder(initialCapacity = size)
    val second = ImmutableLongArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_FLOAT_FLOAT")
public fun ImmutableArray<Pair<Float, Float>>.unzip(): Pair<ImmutableFloatArray, ImmutableFloatArray> {
    val first = ImmutableFloatArray.Builder(initialCapacity = size)
    val second = ImmutableFloatArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_FLOAT_DOUBLE")
public fun ImmutableArray<Pair<Float, Double>>.unzip(): Pair<ImmutableFloatArray, ImmutableDoubleArray> {
    val first = ImmutableFloatArray.Builder(initialCapacity = size)
    val second = ImmutableDoubleArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_DOUBLE_GENERIC")
public fun <R> ImmutableArray<Pair<Double, R>>.unzip(): Pair<ImmutableDoubleArray, ImmutableArray<R>> {
    val first = ImmutableDoubleArray.Builder(initialCapacity = size)
    val second = ImmutableArray.Builder<R>(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_DOUBLE_BOOLEAN")
public fun ImmutableArray<Pair<Double, Boolean>>.unzip(): Pair<ImmutableDoubleArray, ImmutableBooleanArray> {
    val first = ImmutableDoubleArray.Builder(initialCapacity = size)
    val second = ImmutableBooleanArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_DOUBLE_BYTE")
public fun ImmutableArray<Pair<Double, Byte>>.unzip(): Pair<ImmutableDoubleArray, ImmutableByteArray> {
    val first = ImmutableDoubleArray.Builder(initialCapacity = size)
    val second = ImmutableByteArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_DOUBLE_CHAR")
public fun ImmutableArray<Pair<Double, Char>>.unzip(): Pair<ImmutableDoubleArray, ImmutableCharArray> {
    val first = ImmutableDoubleArray.Builder(initialCapacity = size)
    val second = ImmutableCharArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_DOUBLE_SHORT")
public fun ImmutableArray<Pair<Double, Short>>.unzip(): Pair<ImmutableDoubleArray, ImmutableShortArray> {
    val first = ImmutableDoubleArray.Builder(initialCapacity = size)
    val second = ImmutableShortArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_DOUBLE_INT")
public fun ImmutableArray<Pair<Double, Int>>.unzip(): Pair<ImmutableDoubleArray, ImmutableIntArray> {
    val first = ImmutableDoubleArray.Builder(initialCapacity = size)
    val second = ImmutableIntArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_DOUBLE_LONG")
public fun ImmutableArray<Pair<Double, Long>>.unzip(): Pair<ImmutableDoubleArray, ImmutableLongArray> {
    val first = ImmutableDoubleArray.Builder(initialCapacity = size)
    val second = ImmutableLongArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_DOUBLE_FLOAT")
public fun ImmutableArray<Pair<Double, Float>>.unzip(): Pair<ImmutableDoubleArray, ImmutableFloatArray> {
    val first = ImmutableDoubleArray.Builder(initialCapacity = size)
    val second = ImmutableFloatArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

/**
 * Returns a pair of immutable arrays, where first immutable array is built from the first values of
 * each pair, and the second immutable array is built from the second values of each pair.
 */
@JvmName("unzip_Pair_DOUBLE_DOUBLE")
public fun ImmutableArray<Pair<Double, Double>>.unzip(): Pair<ImmutableDoubleArray, ImmutableDoubleArray> {
    val first = ImmutableDoubleArray.Builder(initialCapacity = size)
    val second = ImmutableDoubleArray.Builder(initialCapacity = size)
    for (pair in this) {
        first.add(pair.first)
        second.add(pair.second)
    }
    return Pair(first.build(), second.build())
}

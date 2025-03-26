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
import kotlin.Unit
import kotlin.jvm.JvmName

/**
 * Returns an empty [ImmutableArray].
 */
public fun <T> emptyImmutableArray(): ImmutableArray<T> = ImmutableArray.EMPTY

/**
 * Returns an empty [ImmutableBooleanArray].
 */
public fun emptyImmutableBooleanArray(): ImmutableBooleanArray = ImmutableBooleanArray.EMPTY

/**
 * Returns an empty [ImmutableByteArray].
 */
public fun emptyImmutableByteArray(): ImmutableByteArray = ImmutableByteArray.EMPTY

/**
 * Returns an empty [ImmutableCharArray].
 */
public fun emptyImmutableCharArray(): ImmutableCharArray = ImmutableCharArray.EMPTY

/**
 * Returns an empty [ImmutableShortArray].
 */
public fun emptyImmutableShortArray(): ImmutableShortArray = ImmutableShortArray.EMPTY

/**
 * Returns an empty [ImmutableIntArray].
 */
public fun emptyImmutableIntArray(): ImmutableIntArray = ImmutableIntArray.EMPTY

/**
 * Returns an empty [ImmutableLongArray].
 */
public fun emptyImmutableLongArray(): ImmutableLongArray = ImmutableLongArray.EMPTY

/**
 * Returns an empty [ImmutableFloatArray].
 */
public fun emptyImmutableFloatArray(): ImmutableFloatArray = ImmutableFloatArray.EMPTY

/**
 * Returns an empty [ImmutableDoubleArray].
 */
public fun emptyImmutableDoubleArray(): ImmutableDoubleArray = ImmutableDoubleArray.EMPTY

/**
 * Returns an empty [ImmutableArray].
 */
public fun <T> immutableArrayOf(): ImmutableArray<T> = emptyImmutableArray()

/**
 * Returns an [ImmutableArray] containing the specified [values].
 */
public fun <T> immutableArrayOf(vararg values: T): ImmutableArray<T> {
    return ImmutableArray.copyFrom(source = values, startIndex = 0, size = values.size)
}

/**
 * Returns an [ImmutableBooleanArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Boolean): ImmutableBooleanArray {
    return ImmutableBooleanArray.copyFrom(source = values, startIndex = 0, size = values.size)
}

/**
 * Returns an [ImmutableByteArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Byte): ImmutableByteArray {
    return ImmutableByteArray.copyFrom(source = values, startIndex = 0, size = values.size)
}

/**
 * Returns an [ImmutableCharArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Char): ImmutableCharArray {
    return ImmutableCharArray.copyFrom(source = values, startIndex = 0, size = values.size)
}

/**
 * Returns an [ImmutableShortArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Short): ImmutableShortArray {
    return ImmutableShortArray.copyFrom(source = values, startIndex = 0, size = values.size)
}

/**
 * Returns an [ImmutableIntArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Int): ImmutableIntArray {
    return ImmutableIntArray.copyFrom(source = values, startIndex = 0, size = values.size)
}

/**
 * Returns an [ImmutableLongArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Long): ImmutableLongArray {
    return ImmutableLongArray.copyFrom(source = values, startIndex = 0, size = values.size)
}

/**
 * Returns an [ImmutableFloatArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Float): ImmutableFloatArray {
    return ImmutableFloatArray.copyFrom(source = values, startIndex = 0, size = values.size)
}

/**
 * Returns an [ImmutableDoubleArray] containing the specified [values].
 */
public fun immutableArrayOf(vararg values: Double): ImmutableDoubleArray {
    return ImmutableDoubleArray.copyFrom(source = values, startIndex = 0, size = values.size)
}

/**
 * Returns an [ImmutableArray] containing only the non-null values.
 */
@JvmName("immutableArrayOfNotNull_GENERIC")
public fun <T : Any> immutableArrayOfNotNull(vararg values: T?): ImmutableArray<T> {
    return buildImmutableArray {
        for (value in values) {
            if (value != null) {
                add(value)
            }
        }
    }
}

/**
 * Returns an [ImmutableBooleanArray] containing only the non-null values.
 */
@JvmName("immutableArrayOfNotNull_BOOLEAN")
public fun immutableArrayOfNotNull(vararg values: Boolean?): ImmutableBooleanArray {
    return buildImmutableBooleanArray {
        for (value in values) {
            if (value != null) {
                add(value)
            }
        }
    }
}

/**
 * Returns an [ImmutableByteArray] containing only the non-null values.
 */
@JvmName("immutableArrayOfNotNull_BYTE")
public fun immutableArrayOfNotNull(vararg values: Byte?): ImmutableByteArray {
    return buildImmutableByteArray {
        for (value in values) {
            if (value != null) {
                add(value)
            }
        }
    }
}

/**
 * Returns an [ImmutableCharArray] containing only the non-null values.
 */
@JvmName("immutableArrayOfNotNull_CHAR")
public fun immutableArrayOfNotNull(vararg values: Char?): ImmutableCharArray {
    return buildImmutableCharArray {
        for (value in values) {
            if (value != null) {
                add(value)
            }
        }
    }
}

/**
 * Returns an [ImmutableShortArray] containing only the non-null values.
 */
@JvmName("immutableArrayOfNotNull_SHORT")
public fun immutableArrayOfNotNull(vararg values: Short?): ImmutableShortArray {
    return buildImmutableShortArray {
        for (value in values) {
            if (value != null) {
                add(value)
            }
        }
    }
}

/**
 * Returns an [ImmutableIntArray] containing only the non-null values.
 */
@JvmName("immutableArrayOfNotNull_INT")
public fun immutableArrayOfNotNull(vararg values: Int?): ImmutableIntArray {
    return buildImmutableIntArray {
        for (value in values) {
            if (value != null) {
                add(value)
            }
        }
    }
}

/**
 * Returns an [ImmutableLongArray] containing only the non-null values.
 */
@JvmName("immutableArrayOfNotNull_LONG")
public fun immutableArrayOfNotNull(vararg values: Long?): ImmutableLongArray {
    return buildImmutableLongArray {
        for (value in values) {
            if (value != null) {
                add(value)
            }
        }
    }
}

/**
 * Returns an [ImmutableFloatArray] containing only the non-null values.
 */
@JvmName("immutableArrayOfNotNull_FLOAT")
public fun immutableArrayOfNotNull(vararg values: Float?): ImmutableFloatArray {
    return buildImmutableFloatArray {
        for (value in values) {
            if (value != null) {
                add(value)
            }
        }
    }
}

/**
 * Returns an [ImmutableDoubleArray] containing only the non-null values.
 */
@JvmName("immutableArrayOfNotNull_DOUBLE")
public fun immutableArrayOfNotNull(vararg values: Double?): ImmutableDoubleArray {
    return buildImmutableDoubleArray {
        for (value in values) {
            if (value != null) {
                add(value)
            }
        }
    }
}

/**
 * Builds an [ImmutableArray] for when the size isn't known in advance.
 */
public fun <T> buildImmutableArray(
    initialCapacity: Int = 10,
    body: ImmutableArray.Builder<T>.() -> Unit,
): ImmutableArray<T> {
    val builder = ImmutableArray.Builder<T>(initialCapacity = initialCapacity)
    return builder.apply(body).build()
}

/**
 * Builds an [ImmutableBooleanArray] for when the size isn't known in advance.
 */
public fun buildImmutableBooleanArray(
    initialCapacity: Int = 10,
    body: ImmutableBooleanArray.Builder.() -> Unit,
): ImmutableBooleanArray {
    val builder = ImmutableBooleanArray.Builder(initialCapacity = initialCapacity)
    return builder.apply(body).build()
}

/**
 * Builds an [ImmutableByteArray] for when the size isn't known in advance.
 */
public fun buildImmutableByteArray(
    initialCapacity: Int = 10,
    body: ImmutableByteArray.Builder.() -> Unit,
): ImmutableByteArray {
    val builder = ImmutableByteArray.Builder(initialCapacity = initialCapacity)
    return builder.apply(body).build()
}

/**
 * Builds an [ImmutableCharArray] for when the size isn't known in advance.
 */
public fun buildImmutableCharArray(
    initialCapacity: Int = 10,
    body: ImmutableCharArray.Builder.() -> Unit,
): ImmutableCharArray {
    val builder = ImmutableCharArray.Builder(initialCapacity = initialCapacity)
    return builder.apply(body).build()
}

/**
 * Builds an [ImmutableShortArray] for when the size isn't known in advance.
 */
public fun buildImmutableShortArray(
    initialCapacity: Int = 10,
    body: ImmutableShortArray.Builder.() -> Unit,
): ImmutableShortArray {
    val builder = ImmutableShortArray.Builder(initialCapacity = initialCapacity)
    return builder.apply(body).build()
}

/**
 * Builds an [ImmutableIntArray] for when the size isn't known in advance.
 */
public fun buildImmutableIntArray(
    initialCapacity: Int = 10,
    body: ImmutableIntArray.Builder.() -> Unit,
): ImmutableIntArray {
    val builder = ImmutableIntArray.Builder(initialCapacity = initialCapacity)
    return builder.apply(body).build()
}

/**
 * Builds an [ImmutableLongArray] for when the size isn't known in advance.
 */
public fun buildImmutableLongArray(
    initialCapacity: Int = 10,
    body: ImmutableLongArray.Builder.() -> Unit,
): ImmutableLongArray {
    val builder = ImmutableLongArray.Builder(initialCapacity = initialCapacity)
    return builder.apply(body).build()
}

/**
 * Builds an [ImmutableFloatArray] for when the size isn't known in advance.
 */
public fun buildImmutableFloatArray(
    initialCapacity: Int = 10,
    body: ImmutableFloatArray.Builder.() -> Unit,
): ImmutableFloatArray {
    val builder = ImmutableFloatArray.Builder(initialCapacity = initialCapacity)
    return builder.apply(body).build()
}

/**
 * Builds an [ImmutableDoubleArray] for when the size isn't known in advance.
 */
public fun buildImmutableDoubleArray(
    initialCapacity: Int = 10,
    body: ImmutableDoubleArray.Builder.() -> Unit,
): ImmutableDoubleArray {
    val builder = ImmutableDoubleArray.Builder(initialCapacity = initialCapacity)
    return builder.apply(body).build()
}

internal object BuilderUtils {
    /**
     * Some VMs reserve header words in the array so this is the max safe array size
     */
    public const val MAX_ARRAY_SIZE: Int = Int.MAX_VALUE - 8

    /**
     * Returns a capacity that's greater than or equal to [minCapacity].  If [currentCapacity] is already sufficient
     * then [currentCapacity] is returned.
     *
     * The strategy of choosing the new capacity attempts to balance the negative performance impact of repeated
     * resizing operations with the negative memory impact of ending up with too much unused capacity.
     */
    public fun computeNewCapacity(currentCapacity: Int, minCapacity: Int): Int {
        when {
            minCapacity < 0 -> error("minCapacity encountered overflow")
            currentCapacity >= minCapacity -> return currentCapacity
            minCapacity > MAX_ARRAY_SIZE -> error("minCapacity exceeds max array size")
        }
        // increase the size by at least 50 percent
        val newCapacity = currentCapacity + (currentCapacity shr 1) + 1
        return when {
            newCapacity < 0 -> MAX_ARRAY_SIZE // handle overflow
            newCapacity < minCapacity -> minCapacity
            else -> newCapacity
        }
    }
}

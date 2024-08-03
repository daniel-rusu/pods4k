package com.danrusu.pods4k.immutableArrays

import strikt.api.Assertion

@JvmName("immutableArray_containsExactly")
fun <T> Assertion.Builder<ImmutableArray<T>>.containsExactly(vararg values: T): Assertion.Builder<ImmutableArray<T>> {
    return assert("contains exactly") {
        if (subject.size != values.size) {
            fail("expected [${values.joinToString()}] but was $subject")
        }
        for (index in values.indices) {
            if (subject[index] != values[index]) {
                fail("expected [${values.joinToString()}] but was $subject")
            }
        }
        pass()
    }
}

@JvmName("immutableBooleanArray_containsExactly")
fun Assertion.Builder<ImmutableBooleanArray>.containsExactly(
    vararg values: Boolean,
): Assertion.Builder<ImmutableBooleanArray> {
    return assert("contains exactly") {
        if (subject.size != values.size) {
            fail("expected [${values.joinToString()}] but was $subject")
        }
        for (index in values.indices) {
            if (subject[index] != values[index]) {
                fail("expected [${values.joinToString()}] but was $subject")
            }
        }
        pass()
    }
}

@JvmName("immutableByteArray_containsExactly")
fun Assertion.Builder<ImmutableByteArray>.containsExactly(vararg values: Byte): Assertion.Builder<ImmutableByteArray> {
    return assert("contains exactly") {
        if (subject.size != values.size) {
            fail("expected [${values.joinToString()}] but was $subject")
        }
        for (index in values.indices) {
            if (subject[index] != values[index]) {
                fail("expected [${values.joinToString()}] but was $subject")
            }
        }
        pass()
    }
}

@JvmName("immutableCharArray_containsExactly")
fun Assertion.Builder<ImmutableCharArray>.containsExactly(vararg values: Char): Assertion.Builder<ImmutableCharArray> {
    return assert("contains exactly") {
        if (subject.size != values.size) {
            fail("expected [${values.joinToString()}] but was $subject")
        }
        for (index in values.indices) {
            if (subject[index] != values[index]) {
                fail("expected [${values.joinToString()}] but was $subject")
            }
        }
        pass()
    }
}

@JvmName("immutableDoubleArray_containsExactly")
fun Assertion.Builder<ImmutableDoubleArray>.containsExactly(
    vararg values: Double,
): Assertion.Builder<ImmutableDoubleArray> {
    return assert("contains exactly") {
        if (subject.size != values.size) {
            fail("expected [${values.joinToString()}] but was $subject")
        }
        for (index in values.indices) {
            if (subject[index] != values[index]) {
                fail("expected [${values.joinToString()}] but was $subject")
            }
        }
        pass()
    }
}

@JvmName("immutableFloatArray_containsExactly")
fun Assertion.Builder<ImmutableFloatArray>.containsExactly(
    vararg values: Float,
): Assertion.Builder<ImmutableFloatArray> {
    return assert("contains exactly") {
        if (subject.size != values.size) {
            fail("expected [${values.joinToString()}] but was $subject")
        }
        for (index in values.indices) {
            if (subject[index] != values[index]) {
                fail("expected [${values.joinToString()}] but was $subject")
            }
        }
        pass()
    }
}

@JvmName("immutableIntArray_containsExactly")
fun Assertion.Builder<ImmutableIntArray>.containsExactly(vararg values: Int): Assertion.Builder<ImmutableIntArray> {
    return assert("contains exactly") {
        if (subject.size != values.size) {
            fail("expected [${values.joinToString()}] but was $subject")
        }
        for (index in values.indices) {
            if (subject[index] != values[index]) {
                fail("expected [${values.joinToString()}] but was $subject")
            }
        }
        pass()
    }
}

@JvmName("immutableLongArray_containsExactly")
fun Assertion.Builder<ImmutableLongArray>.containsExactly(vararg values: Long): Assertion.Builder<ImmutableLongArray> {
    return assert("contains exactly") {
        if (subject.size != values.size) {
            fail("expected [${values.joinToString()}] but was $subject")
        }
        for (index in values.indices) {
            if (subject[index] != values[index]) {
                fail("expected [${values.joinToString()}] but was $subject")
            }
        }
        pass()
    }
}

@JvmName("immutableShortArray_containsExactly")
fun Assertion.Builder<ImmutableShortArray>.containsExactly(
    vararg values: Short,
): Assertion.Builder<ImmutableShortArray> {
    return assert("contains exactly") {
        if (subject.size != values.size) {
            fail("expected [${values.joinToString()}] but was $subject")
        }
        for (index in values.indices) {
            if (subject[index] != values[index]) {
                fail("expected [${values.joinToString()}] but was $subject")
            }
        }
        pass()
    }
}

@JvmName("immutableArray_isEmpty")
fun <T> Assertion.Builder<ImmutableArray<T>>.isEmpty(): Assertion.Builder<ImmutableArray<T>> {
    return assert(description = "is empty") {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is not empty")
        }
    }
}

@JvmName("immutableBooleanArray_isEmpty")
fun Assertion.Builder<ImmutableBooleanArray>.isEmpty(): Assertion.Builder<ImmutableBooleanArray> {
    return assert(description = "is empty") {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is not empty")
        }
    }
}

@JvmName("immutableByteArray_isEmpty")
fun Assertion.Builder<ImmutableByteArray>.isEmpty(): Assertion.Builder<ImmutableByteArray> {
    return assert(description = "is empty") {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is not empty")
        }
    }
}

@JvmName("immutableCharArray_isEmpty")
fun Assertion.Builder<ImmutableCharArray>.isEmpty(): Assertion.Builder<ImmutableCharArray> {
    return assert(description = "is empty") {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is not empty")
        }
    }
}

@JvmName("immutableDoubleArray_isEmpty")
fun Assertion.Builder<ImmutableDoubleArray>.isEmpty(): Assertion.Builder<ImmutableDoubleArray> {
    return assert(description = "is empty") {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is not empty")
        }
    }
}

@JvmName("immutableFloatArray_isEmpty")
fun Assertion.Builder<ImmutableFloatArray>.isEmpty(): Assertion.Builder<ImmutableFloatArray> {
    return assert(description = "is empty") {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is not empty")
        }
    }
}

@JvmName("immutableIntArray_isEmpty")
fun Assertion.Builder<ImmutableIntArray>.isEmpty(): Assertion.Builder<ImmutableIntArray> {
    return assert(description = "is empty") {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is not empty")
        }
    }
}

@JvmName("immutableLongArray_isEmpty")
fun Assertion.Builder<ImmutableLongArray>.isEmpty(): Assertion.Builder<ImmutableLongArray> {
    return assert(description = "is empty") {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is not empty")
        }
    }
}

@JvmName("immutableShortArray_isEmpty")
fun Assertion.Builder<ImmutableShortArray>.isEmpty(): Assertion.Builder<ImmutableShortArray> {
    return assert(description = "is empty") {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is not empty")
        }
    }
}

@JvmName("immutableArray_isNotEmpty")
fun <T> Assertion.Builder<ImmutableArray<T>>.isNotEmpty(): Assertion.Builder<ImmutableArray<T>> {
    return assert(description = "is empty") {
        if (subject.size > 0 != subject.isNotEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isNotEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isNotEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is empty")
        }
    }
}

@JvmName("immutableBooleanArray_isNotEmpty")
fun Assertion.Builder<ImmutableBooleanArray>.isNotEmpty(): Assertion.Builder<ImmutableBooleanArray> {
    return assert(description = "is empty") {
        if (subject.size > 0 != subject.isNotEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isNotEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isNotEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is empty")
        }
    }
}

@JvmName("immutableByteArray_isNotEmpty")
fun Assertion.Builder<ImmutableByteArray>.isNotEmpty(): Assertion.Builder<ImmutableByteArray> {
    return assert(description = "is empty") {
        if (subject.size > 0 != subject.isNotEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isNotEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isNotEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is empty")
        }
    }
}

@JvmName("immutableCharArray_isNotEmpty")
fun Assertion.Builder<ImmutableCharArray>.isNotEmpty(): Assertion.Builder<ImmutableCharArray> {
    return assert(description = "is empty") {
        if (subject.size > 0 != subject.isNotEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isNotEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isNotEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is empty")
        }
    }
}

@JvmName("immutableDoubleArray_isNotEmpty")
fun Assertion.Builder<ImmutableDoubleArray>.isNotEmpty(): Assertion.Builder<ImmutableDoubleArray> {
    return assert(description = "is empty") {
        if (subject.size > 0 != subject.isNotEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isNotEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isNotEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is empty")
        }
    }
}

@JvmName("immutableFloatArray_isNotEmpty")
fun Assertion.Builder<ImmutableFloatArray>.isNotEmpty(): Assertion.Builder<ImmutableFloatArray> {
    return assert(description = "is empty") {
        if (subject.size > 0 != subject.isNotEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isNotEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isNotEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is empty")
        }
    }
}

@JvmName("immutableIntArray_isNotEmpty")
fun Assertion.Builder<ImmutableIntArray>.isNotEmpty(): Assertion.Builder<ImmutableIntArray> {
    return assert(description = "is empty") {
        if (subject.size > 0 != subject.isNotEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isNotEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isNotEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is empty")
        }
    }
}

@JvmName("immutableLongArray_isNotEmpty")
fun Assertion.Builder<ImmutableLongArray>.isNotEmpty(): Assertion.Builder<ImmutableLongArray> {
    return assert(description = "is empty") {
        if (subject.size > 0 != subject.isNotEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isNotEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isNotEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is empty")
        }
    }
}

@JvmName("immutableShortArray_isNotEmpty")
fun Assertion.Builder<ImmutableShortArray>.isNotEmpty(): Assertion.Builder<ImmutableShortArray> {
    return assert(description = "is empty") {
        if (subject.size > 0 != subject.isNotEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isNotEmpty():${subject.isEmpty()}")
        }
        if (subject.isEmpty() == subject.isNotEmpty()) {
            return@assert fail("Inconsistent isEmpty():${subject.isEmpty()} with isNotEmpty():${subject.isNotEmpty()}")
        }
        when (subject.isNotEmpty()) {
            true -> pass()
            else -> fail(actual = subject, description = "Array is empty")
        }
    }
}

@JvmName("immutableArray_hasSize")
fun <T> Assertion.Builder<ImmutableArray<T>>.hasSize(expectedSize: Int): Assertion.Builder<ImmutableArray<T>> {
    return assert(description = "has size %d", expectedSize) {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        when (subject.size) {
            expectedSize -> pass()
            else -> fail(actual = subject.size, description = "Invalid size")
        }
    }
}

@JvmName("immutableBooleanArray_hasSize")
fun Assertion.Builder<ImmutableBooleanArray>.hasSize(expectedSize: Int): Assertion.Builder<ImmutableBooleanArray> {
    return assert(description = "has size %d", expectedSize) {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        when (subject.size) {
            expectedSize -> pass()
            else -> fail(actual = subject.size, description = "Invalid size")
        }
    }
}

@JvmName("immutableByteArray_hasSize")
fun Assertion.Builder<ImmutableByteArray>.hasSize(expectedSize: Int): Assertion.Builder<ImmutableByteArray> {
    return assert(description = "has size %d", expectedSize) {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        when (subject.size) {
            expectedSize -> pass()
            else -> fail(actual = subject.size, description = "Invalid size")
        }
    }
}

@JvmName("immutableCharArray_hasSize")
fun Assertion.Builder<ImmutableCharArray>.hasSize(expectedSize: Int): Assertion.Builder<ImmutableCharArray> {
    return assert(description = "has size %d", expectedSize) {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        when (subject.size) {
            expectedSize -> pass()
            else -> fail(actual = subject.size, description = "Invalid size")
        }
    }
}

@JvmName("immutableDoubleArray_hasSize")
fun Assertion.Builder<ImmutableDoubleArray>.hasSize(expectedSize: Int): Assertion.Builder<ImmutableDoubleArray> {
    return assert(description = "has size %d", expectedSize) {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        when (subject.size) {
            expectedSize -> pass()
            else -> fail(actual = subject.size, description = "Invalid size")
        }
    }
}

@JvmName("immutableFloatArray_hasSize")
fun Assertion.Builder<ImmutableFloatArray>.hasSize(expectedSize: Int): Assertion.Builder<ImmutableFloatArray> {
    return assert(description = "has size %d", expectedSize) {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        when (subject.size) {
            expectedSize -> pass()
            else -> fail(actual = subject.size, description = "Invalid size")
        }
    }
}

@JvmName("immutableIntArray_hasSize")
fun Assertion.Builder<ImmutableIntArray>.hasSize(expectedSize: Int): Assertion.Builder<ImmutableIntArray> {
    return assert(description = "has size %d", expectedSize) {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        when (subject.size) {
            expectedSize -> pass()
            else -> fail(actual = subject.size, description = "Invalid size")
        }
    }
}

@JvmName("immutableLongArray_hasSize")
fun Assertion.Builder<ImmutableLongArray>.hasSize(expectedSize: Int): Assertion.Builder<ImmutableLongArray> {
    return assert(description = "has size %d", expectedSize) {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        when (subject.size) {
            expectedSize -> pass()
            else -> fail(actual = subject.size, description = "Invalid size")
        }
    }
}

@JvmName("immutableShortArray_hasSize")
fun Assertion.Builder<ImmutableShortArray>.hasSize(expectedSize: Int): Assertion.Builder<ImmutableShortArray> {
    return assert(description = "has size %d", expectedSize) {
        if (subject.size == 0 != subject.isEmpty()) {
            return@assert fail("Inconsistent size:${subject.size} with isEmpty():${subject.isEmpty()}")
        }
        when (subject.size) {
            expectedSize -> pass()
            else -> fail(actual = subject.size, description = "Invalid size")
        }
    }
}

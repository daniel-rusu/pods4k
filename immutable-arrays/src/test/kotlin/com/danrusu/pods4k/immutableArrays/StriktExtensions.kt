package com.danrusu.pods4k.immutableArrays

import strikt.api.Assertion

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

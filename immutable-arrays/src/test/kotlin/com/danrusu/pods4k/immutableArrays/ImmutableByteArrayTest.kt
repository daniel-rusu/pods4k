package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

private val primitiveByteClass = 3.toByte()::class.java

/**
 * IMPORTANT:
 * Read TESTING-STRATEGY.md before modifying this file.
 */
class ImmutableByteArrayTest {
    @Test
    fun `ensure that primitive class variable is correct`() {
        expectThat(primitiveByteClass.toString()).isEqualTo("byte")
    }

    @Test
    fun `creation validation`() {
        expectThat(ImmutableByteArray(1) { it.toByte() })
            .isA<ImmutableByteArray>()
    }

    @Test
    fun `get validation`() {
        with(ImmutableByteArray(1) { it.toByte() }) {
            expectThat(get(0)::class.java).isEqualTo(primitiveByteClass)
        }
    }

    @Test
    fun `componentN function validation`() {
        val values = ImmutableByteArray(1) { it.toByte() }
        val (first) = values
        expectThat(first::class.java == primitiveByteClass)
    }

    @Test
    fun `first validation`() {
        with(ImmutableByteArray(3) { it.toByte() }) {
            expectThat(this.first()::class.java).isEqualTo(primitiveByteClass)
        }
    }

    @Test
    fun `last validation`() {
        with(ImmutableByteArray(3) { it.toByte() }) {
            expectThat(this.last()::class.java).isEqualTo(primitiveByteClass)
        }
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableByteArray(3) { it.toByte() }) {
            for (value in this) {
                expectThat(value::class.java).isEqualTo(primitiveByteClass)
            }
        }
    }
}

package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

private val primitiveLongClass = 3L::class.java

/**
 * IMPORTANT:
 * Read TESTING-STRATEGY.md before modifying this file.
 */
class ImmutableLongArrayTest {
    @Test
    fun `ensure that primitive class variable is correct`() {
        expectThat(primitiveLongClass.toString()).isEqualTo("long")
    }

    @Test
    fun `creation validation`() {
        expectThat(ImmutableLongArray(1) { it.toLong() })
            .isA<ImmutableLongArray>()
    }

    @Test
    fun `get validation`() {
        with(ImmutableLongArray(1) { it.toLong() }) {
            expectThat(get(0)::class.java).isEqualTo(primitiveLongClass)
        }
    }

    @Test
    fun `componentN function validation`() {
        val values = ImmutableLongArray(1) { it.toLong() }
        val (first) = values
        expectThat(first::class.java == primitiveLongClass)
    }

    @Test
    fun `first validation`() {
        with(ImmutableLongArray(3) { it.toLong() }) {
            expectThat(this.first()::class.java).isEqualTo(primitiveLongClass)
        }
    }

    @Test
    fun `last validation`() {
        with(ImmutableLongArray(3) { it.toLong() }) {
            expectThat(this.last()::class.java).isEqualTo(primitiveLongClass)
        }
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableLongArray(3) { it.toLong() }) {
            for (value in this) {
                expectThat(value::class.java).isEqualTo(primitiveLongClass)
            }
        }
    }
}

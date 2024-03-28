package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

private val primitiveBooleanClass = true::class.java

/**
 * IMPORTANT:
 * Read TESTING-STRATEGY.md before modifying this file.
 */
class ImmutableBooleanArrayTest {
    @Test
    fun `ensure that primitive class variable is correct`() {
        expectThat(primitiveBooleanClass.toString()).isEqualTo("boolean")
    }

    @Test
    fun `creation validation`() {
        expectThat(ImmutableBooleanArray(1) { it % 2 == 0 })
            .isA<ImmutableBooleanArray>()
    }

    @Test
    fun `get validation`() {
        with(ImmutableBooleanArray(3) { it % 2 == 0 }) {
            expectThat(get(0)::class.java).isEqualTo(primitiveBooleanClass)
        }
    }

    @Test
    fun `componentN function validation`() {
        val values = ImmutableBooleanArray(1) { it % 2 == 0 }
        val (first) = values
        expectThat(first::class.java == primitiveBooleanClass)
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableBooleanArray(3) { it % 2 == 0 }) {
            for (value in this) {
                expectThat(value::class.java).isEqualTo(primitiveBooleanClass)
            }
        }
    }
}

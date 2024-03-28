package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

private val primitiveCharClass = 'a'::class.java

/**
 * IMPORTANT:
 * Read TESTING-STRATEGY.md before modifying this file.
 */
class ImmutableCharArrayTest {
    @Test
    fun `ensure that primitive class variable is correct`() {
        expectThat(primitiveCharClass.toString()).isEqualTo("char")
    }

    @Test
    fun `creation validation`() {
        expectThat(ImmutableCharArray(1) { it.toChar() })
            .isA<ImmutableCharArray>()
    }

    @Test
    fun `get validation`() {
        with(ImmutableCharArray(1) { it.toChar() }) {
            expectThat(get(0)::class.java).isEqualTo(primitiveCharClass)
        }
    }

    @Test
    fun `componentN function validation`() {
        val values = ImmutableCharArray(1) { it.toChar() }
        val (first) = values
        expectThat(first::class.java == primitiveCharClass)
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableCharArray(3) { it.toChar() }) {
            for (value in this) {
                expectThat(value::class.java).isEqualTo(primitiveCharClass)
            }
        }
    }
}

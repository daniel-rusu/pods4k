package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

private val primitiveFloatClass = 3.0f::class.java

/**
 * IMPORTANT:
 * Read TESTING-STRATEGY.md before modifying this file.
 */
class ImmutableFloatArrayTest {
    @Test
    fun `ensure that primitive class variable is correct`() {
        expectThat(primitiveFloatClass.toString()).isEqualTo("float")
    }

    @Test
    fun `creation validation`() {
        expectThat(ImmutableFloatArray(1) { it.toFloat() })
            .isA<ImmutableFloatArray>()
    }

    @Test
    fun `get validation`() {
        with(ImmutableFloatArray(1) { it.toFloat() }) {
            expectThat(get(0)::class.java).isEqualTo(primitiveFloatClass)
        }
    }

    @Test
    fun `componentN function validation`() {
        val values = ImmutableFloatArray(1) { it.toFloat() }
        val (first) = values
        expectThat(first::class.java == primitiveFloatClass)
    }

    @Test
    fun `single validation`() {
        with(ImmutableFloatArray(1) { it.toFloat() }) {
            expectThat(this.single()::class.java).isEqualTo(primitiveFloatClass)
        }
    }

    @Test
    fun `first validation`() {
        with(ImmutableFloatArray(3) { it.toFloat() }) {
            expectThat(this.first()::class.java).isEqualTo(primitiveFloatClass)
        }
    }

    @Test
    fun `last validation`() {
        with(ImmutableFloatArray(3) { it.toFloat() }) {
            expectThat(this.last()::class.java).isEqualTo(primitiveFloatClass)
        }
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableFloatArray(3) { it.toFloat() }) {
            for (value in this) {
                expectThat(value::class.java).isEqualTo(primitiveFloatClass)
            }
        }
    }

    @Test
    fun `forEach validation`() {
        with(ImmutableFloatArray(3) { it.toFloat() }) {
            this.forEach { element ->
                expectThat(element::class.java).isEqualTo(primitiveFloatClass)
            }
        }
    }
}

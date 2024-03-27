package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isTrue

private val primitiveIntClass = 3::class.java

/**
 * IMPORTANT:
 * Read TESTING-STRATEGY.md before modifying this file.
 */
class ImmutableIntArrayTest {
    @Test
    fun `ensure that primitive class variable is correct`() {
        expectThat(primitiveIntClass.toString()).isEqualTo("int")
    }

    @Test
    fun `creation validation`() {
        expectThat(ImmutableIntArray(1) { it })
            .isA<ImmutableIntArray>()
    }

    @Test
    fun `toString validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this.toString()).isEqualTo("[]")
        }
        with(ImmutableIntArray(1) { it }) {
            expectThat(this.toString()).isEqualTo("[0]")
        }
        with(ImmutableIntArray(4) { 2 * it }) {
            expectThat(this.toString()).isEqualTo("[0, 2, 4, 6]")
        }
    }

    @Test
    fun `size validation`() {
        // Cannot create with negative size
        expectThrows<NegativeArraySizeException> {
            ImmutableIntArray(-1) { it }
        }

        with(ImmutableIntArray(0) { it }) {
            expectThat(this.size).isEqualTo(0)
        }
        with(ImmutableIntArray(1) { it }) {
            expectThat(this.size).isEqualTo(1)
        }
        with(ImmutableIntArray(10) { it }) {
            expectThat(this.size).isEqualTo(10)
        }
    }

    @Test
    fun `lastIndex validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this.lastIndex).isEqualTo(-1)
        }
        with(ImmutableIntArray(1) { it }) {
            expectThat(this.lastIndex).isEqualTo(0)
        }
        with(ImmutableIntArray(10) { it }) {
            expectThat(this.lastIndex).isEqualTo(9)
        }
    }

    @Test
    fun `get validation`() {
        with(ImmutableIntArray(3) { it }) {
            expectThat(get(0)::class.java).isEqualTo(primitiveIntClass)

            expectThat(get(0)).isEqualTo(0)
            expectThat(get(1)).isEqualTo(1)
            expectThat(get(2)).isEqualTo(2)

            expectThrows<ArrayIndexOutOfBoundsException> {
                get(3)
            }
        }
    }

    @Test
    fun `index operator validation`() {
        with(ImmutableIntArray(3) { it }) {
            expectThat(this[0]).isEqualTo(get(0))
            expectThat(this[1]).isEqualTo(get(1))
            expectThat(this[2]).isEqualTo(get(2))

            expectThrows<ArrayIndexOutOfBoundsException> {
                this[3]
            }
        }
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this.iterator().hasNext()).isFalse()
        }
        with(ImmutableIntArray(1) { it }) {
            val iterator = this.iterator()
            expectThat(iterator.hasNext()).isTrue()
            val first = iterator.next()
            expectThat(first::class.java).isEqualTo(primitiveIntClass)
            expectThat(first).isEqualTo(0)

            expectThat(iterator.hasNext()).isFalse()
        }
        with(ImmutableIntArray(3) { it }) {
            val iterator = this.iterator()
            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(0)

            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(1)

            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(2)

            expectThat(iterator.hasNext()).isFalse()
        }

        // can iterate with a regular for-loop
        with(ImmutableIntArray(3) { it }) {
            val elements = mutableListOf<Int>()
            for (element in this) {
                expectThat(element::class.java).isEqualTo(primitiveIntClass)
                elements += element
            }
            expectThat(elements).isEqualTo(mutableListOf(0, 1, 2))
        }
    }
}

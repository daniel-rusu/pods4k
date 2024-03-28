package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isTrue

private data class Person(val id: Int)

/**
 * IMPORTANT:
 * Read TESTING-STRATEGY.md before modifying this file.
 */
class ImmutableArrayTest {
    @Test
    fun `creation validation`() {
        expectThat(ImmutableArray(1) { "element $it" })
            .isA<ImmutableArray<String>>()
    }

    @Test
    fun `size validation`() {
        // Cannot create with negative size
        expectThrows<NegativeArraySizeException> {
            ImmutableArray(-1) { "element $it" }
        }

        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this.size).isEqualTo(0)
        }
        with(ImmutableArray(1) { "element $it" }) {
            expectThat(this.size).isEqualTo(1)
        }
        with(ImmutableArray(10) { "element $it" }) {
            expectThat(this.size).isEqualTo(10)
        }
    }

    @Test
    fun `lastIndex validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this.lastIndex).isEqualTo(-1)
        }
        with(ImmutableArray(1) { "element $it" }) {
            expectThat(this.lastIndex).isEqualTo(0)
        }
        with(ImmutableArray(10) { "element $it" }) {
            expectThat(this.lastIndex).isEqualTo(9)
        }
    }

    @Test
    fun `toString validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this.toString()).isEqualTo("[]")
        }
        with(ImmutableArray(1) { "element $it" }) {
            expectThat(this.toString()).isEqualTo("[element 0]")
        }
        with(ImmutableArray(4) { Person(id = it) }) {
            expectThat(this.toString()).isEqualTo("[Person(id=0), Person(id=1), Person(id=2), Person(id=3)]")
        }
    }

    @Test
    fun `isEmpty and isNotEmpty validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this.isEmpty()).isTrue()
            expectThat(this.isNotEmpty()).isFalse()
        }
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.isEmpty()).isFalse()
            expectThat(this.isNotEmpty()).isTrue()
        }
    }

    @Test
    fun `get validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(get(0)).isEqualTo("element 0")
            expectThat(get(1)).isEqualTo("element 1")
            expectThat(get(2)).isEqualTo("element 2")

            expectThrows<ArrayIndexOutOfBoundsException> {
                get(3)
            }
        }
    }

    @Test
    fun `index operator validation`() {
        with(ImmutableArray(3) { "element $it" }) {
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
        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this.iterator().hasNext()).isFalse()
        }
        with(ImmutableArray(1) { "element $it" }) {
            val iterator = this.iterator()
            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo("element 0")

            expectThat(iterator.hasNext()).isFalse()
        }
        with(ImmutableArray(3) { Person(id = it) }) {
            val iterator = this.iterator()
            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(Person(id = 0))

            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(Person(id = 1))

            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(Person(id = 2))

            expectThat(iterator.hasNext()).isFalse()
        }

        // can iterate with a regular for-loop
        with(ImmutableArray(3) { "element $it" }) {
            val elements = mutableListOf<String>()
            for (element in this) {
                elements += element
            }
            expectThat(elements).isEqualTo(mutableListOf("element 0", "element 1", "element 2"))
        }
    }
}

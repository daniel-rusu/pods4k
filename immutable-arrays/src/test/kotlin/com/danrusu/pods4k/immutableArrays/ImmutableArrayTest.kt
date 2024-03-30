package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.immutableArrays.emptySingletons.EmptyIterator
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.*

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
    fun `indices validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this.indices).isEqualTo(IntRange(start = 0, endInclusive = -1))
        }
        with(ImmutableArray(1) { "element $it" }) {
            expectThat(this.indices).isEqualTo(IntRange(start = 0, endInclusive = 0))
        }
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.indices).isEqualTo(IntRange(start = 0, endInclusive = 2))
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
    fun `componentN function validation`() {
        val values = ImmutableArray(5) { "element $it" }
        with(values) {
            val (first) = this
            expectThat(first).isEqualTo("element 0")
        }
        with(values) {
            val (first, second) = this
            expectThat(first).isEqualTo("element 0")
            expectThat(second).isEqualTo("element 1")
        }
        with(values) {
            val (first, second, third) = this
            expectThat(first).isEqualTo("element 0")
            expectThat(second).isEqualTo("element 1")
            expectThat(third).isEqualTo("element 2")
        }
        with(values) {
            val (first, second, third, fourth) = this
            expectThat(first).isEqualTo("element 0")
            expectThat(second).isEqualTo("element 1")
            expectThat(third).isEqualTo("element 2")
            expectThat(fourth).isEqualTo("element 3")
        }
        with(values) {
            val (first, second, third, fourth, fifth) = this
            expectThat(first).isEqualTo("element 0")
            expectThat(second).isEqualTo("element 1")
            expectThat(third).isEqualTo("element 2")
            expectThat(fourth).isEqualTo("element 3")
            expectThat(fifth).isEqualTo("element 4")
        }
    }

    @Test
    fun `single validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThrows<NoSuchElementException> { this.single() }
        }.message.isEqualTo("Array is empty!")

        with(ImmutableArray(3) { "element $it" }) {
            expectThrows<IllegalArgumentException> { this.single() }
        }.message.isEqualTo("Array has more than one element!")

        with(ImmutableArray(1) { "element $it" }) {
            expectThat(this.single()).isEqualTo("element 0")
        }
    }

    @Test
    fun `first validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThrows<NoSuchElementException> { this.first() }
        }.message.isEqualTo("Array is empty!")

        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.first()).isEqualTo("element 0")
        }
    }

    @Test
    fun `last validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThrows<NoSuchElementException> { this.last() }
        }.message.isEqualTo("Array is empty!")

        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.last()).isEqualTo("element 2")
        }
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            val iterator = this.iterator()
            expectThat(iterator === EmptyIterator).isTrue()
            expectThat(iterator.hasNext()).isFalse()
            expectThrows<NoSuchElementException> { iterator.next() }
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

    @Test
    fun `asSequence validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this.asSequence() === emptySequence<String>())
        }
        with(ImmutableArray(3) { "element $it" }) {
            val elementsFromSequence = this.asSequence().toList()
            expectThat(elementsFromSequence).isEqualTo(listOf("element 0", "element 1", "element 2"))
        }
    }

    @Test
    fun `forEach validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            val elements = mutableListOf<String>()
            this.forEach { element ->
                elements += element
            }
            expectThat(elements).isEqualTo(mutableListOf("element 0", "element 1", "element 2"))
        }
    }

    @Test
    fun `forEachIndexed validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            val elements = mutableMapOf<Int, String>()
            this.forEachIndexed { index, element ->
                elements[index] = element
            }
            expectThat(elements).isEqualTo(
                mutableMapOf(
                    0 to "element 0",
                    1 to "element 1",
                    2 to "element 2",
                )
            )
        }
    }
}

package com.danrusu.pods4k.immutableArrays

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

        // Cannot create with negative size
        expectThrows<NegativeArraySizeException> {
            ImmutableArray(-1) { "element $it" }
        }
    }

    @Test
    fun `size validation`() {
        with(ImmutableArray(10) { "element $it" }) {
            expectThat(this).hasSize(10)
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
            expectThat(this).isEmpty()
        }
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this).isNotEmpty()
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
    fun `getOrNull validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.getOrNull(2)).isEqualTo("element 2")
            expectThat(this.getOrNull(3)).isNull()
        }
    }

    @Test
    fun `getOrElse validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(
                this.getOrElse(2) { "else" }
            ).isEqualTo("element 2")
            expectThat(
                this.getOrElse(3) { "else" }
            ).isEqualTo("else")
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
        with(ImmutableArray(3) { "element $it" }) {
            expectThrows<IllegalArgumentException> {
                this.single()
            }.message.isEqualTo("Array has more than one element.")
        }
        with(ImmutableArray(1) { "element $it" }) {
            expectThat(this.single()).isEqualTo("element 0")
        }
    }

    @Test
    fun `single with predicate validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThrows<IllegalArgumentException> {
                this.single { it.contains("element") }
            }.message.isEqualTo("Array contains more than one matching element.")
        }
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.single { it.contains("2") }).isEqualTo("element 2")
        }
    }

    @Test
    fun `singleOrNull validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.singleOrNull()).isNull()
        }
        with(ImmutableArray(1) { "element $it" }) {
            expectThat(this.singleOrNull()).isEqualTo("element 0")
        }
        val boo = arrayOf("boo")
    }

    @Test
    fun `singleOrNull with predicate validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(
                this.singleOrNull { it.contains("element") }
            ).isNull()
        }
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.singleOrNull { it.contains("2") }).isEqualTo("element 2")
        }
    }

    @Test
    fun `first validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.first()).isEqualTo("element 0")
        }
    }

    @Test
    fun `first with predicate validation`() {
        with(ImmutableArray(7) { "${2 * it}" }) {
            expectThat(
                this.first { it.contains("2") }
            ).isEqualTo("2")
        }
    }

    @Test
    fun `firstOrNull validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this.firstOrNull()).isNull()
        }
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.firstOrNull()).isEqualTo("element 0")
        }
    }

    @Test
    fun `firstOrNull with predicate validation`() {
        with(ImmutableArray(7) { "${2 * it}" }) {
            expectThat(
                this.firstOrNull { it.contains("2") }
            ).isEqualTo("2")

            expectThat(
                this.firstOrNull { it.contains("3") }
            ).isNull()
        }
    }

    @Test
    fun `last validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.last()).isEqualTo("element 2")
        }
    }

    @Test
    fun `last with predicate validation`() {
        with(ImmutableArray(7) { "${2 * it}" }) {
            expectThat(
                this.last { it.contains("2") }
            ).isEqualTo("12")
        }
    }

    @Test
    fun `lastOrNull with predicate validation`() {
        with(ImmutableArray(7) { "${2 * it}" }) {
            expectThat(
                this.lastOrNull { it.contains("2") }
            ).isEqualTo("12")

            expectThat(
                this.lastOrNull { it.contains("3") }
            ).isNull()
        }
    }

    @Test
    fun `lastOrNull validation`() {
        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this.lastOrNull()).isNull()
        }
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.lastOrNull()).isEqualTo("element 2")
        }
    }

    @Test
    fun `toList validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.toList()).isEqualTo(listOf("element 0", "element 1", "element 2"))
        }
    }

    @Test
    fun `toMutableList validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.toMutableList()).isEqualTo(mutableListOf("element 0", "element 1", "element 2"))
        }
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableArray(2) { Person(id = it) }) {
            val iterator = this.iterator()
            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(Person(id = 0))

            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(Person(id = 1))

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
    fun `asIterable validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            val iterable = this.asIterable()
            expectThat(iterable).isA<Iterable<String>>()

            expectThat(iterable.toList()).isEqualTo(listOf("element 0", "element 1", "element 2"))
        }
    }

    @Test
    fun `withIndex validation`() {
        with(ImmutableArray(2) { "element $it" }) {
            expectThat(this.withIndex().toList()).isEqualTo(
                listOf(IndexedValue(0, "element 0"), IndexedValue(1, "element 1"))
            )
        }
    }

    @Test
    fun `asSequence validation`() {
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

package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.immutableArrays.emptySingletons.EmptyIterator
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.*

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
    fun `indices validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this.indices).isEqualTo(IntRange(start = 0, endInclusive = -1))
        }
        with(ImmutableIntArray(1) { it }) {
            expectThat(this.indices).isEqualTo(IntRange(start = 0, endInclusive = 0))
        }
        with(ImmutableIntArray(3) { it }) {
            expectThat(this.indices).isEqualTo(IntRange(start = 0, endInclusive = 2))
        }
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
    fun `isEmpty and isNotEmpty validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this.isEmpty()).isTrue()
            expectThat(this.isNotEmpty()).isFalse()
        }
        with(ImmutableIntArray(3) { it }) {
            expectThat(this.isEmpty()).isFalse()
            expectThat(this.isNotEmpty()).isTrue()
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
    fun `getOrNull validation`() {
        with(ImmutableIntArray(3) { it }) {
            expectThat(this.getOrNull(0)).isEqualTo(0)
            expectThat(this.getOrNull(2)).isEqualTo(2)

            expectThat(this.getOrNull(-1)).isNull()
            expectThat(this.getOrNull(3)).isNull()
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
    fun `componentN function validation`() {
        val values = ImmutableIntArray(5) { it }
        with(values) {
            val (first) = this
            expectThat(first::class.java == primitiveIntClass)
            expectThat(first).isEqualTo(0)
        }
        with(values) {
            val (first, second) = this
            expectThat(first).isEqualTo(0)
            expectThat(second).isEqualTo(1)
        }
        with(values) {
            val (first, second, third) = this
            expectThat(first).isEqualTo(0)
            expectThat(second).isEqualTo(1)
            expectThat(third).isEqualTo(2)
        }
        with(values) {
            val (first, second, third, fourth) = this
            expectThat(first).isEqualTo(0)
            expectThat(second).isEqualTo(1)
            expectThat(third).isEqualTo(2)
            expectThat(fourth).isEqualTo(3)
        }
        with(values) {
            val (first, second, third, fourth, fifth) = this
            expectThat(first).isEqualTo(0)
            expectThat(second).isEqualTo(1)
            expectThat(third).isEqualTo(2)
            expectThat(fourth).isEqualTo(3)
            expectThat(fifth).isEqualTo(4)
        }
    }

    @Test
    fun `single validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThrows<NoSuchElementException> {
                this.single()
            }.message.isEqualTo("Array is empty!")
        }

        with(ImmutableIntArray(3) { it }) {
            expectThrows<IllegalArgumentException> {
                this.single()
            }.message.isEqualTo("Array has more than one element!")
        }

        with(ImmutableIntArray(1) { it }) {
            val singleValue = this.single()
            expectThat(singleValue).isEqualTo(0)
            expectThat(singleValue::class.java).isEqualTo(primitiveIntClass)
        }
    }

    @Test
    fun `first validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThrows<NoSuchElementException> {
                this.first()
            }.message.isEqualTo("Array is empty!")
        }

        with(ImmutableIntArray(3) { it }) {
            val first = this.first()
            expectThat(first).isEqualTo(0)
            expectThat(first::class.java).isEqualTo(primitiveIntClass)
        }
    }

    @Test
    fun `firstOrNull validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this.firstOrNull()).isNull()
        }
        with(ImmutableArray(3) { it }) {
            expectThat(this.firstOrNull()).isEqualTo(0)
        }
    }

    @Test
    fun `last validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThrows<NoSuchElementException> {
                this.last()
            }.message.isEqualTo("Array is empty!")
        }

        with(ImmutableIntArray(3) { it }) {
            val last = this.last()
            expectThat(last).isEqualTo(2)
            expectThat(last::class.java).isEqualTo(primitiveIntClass)
        }
    }

    @Test
    fun `toList validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this.toList() === emptyList<Int>()).isTrue()
        }
        with(ImmutableIntArray(3) { it }) {
            expectThat(this.toList()).isEqualTo(listOf(0, 1, 2))
        }
    }

    @Test
    fun `toMutableList validation`() {
        with(ImmutableIntArray(3) { it }) {
            expectThat(this.toMutableList()).isEqualTo(mutableListOf(0, 1, 2))
        }
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableIntArray(0) { it }) {
            val iterator = this.iterator()
            expectThat(iterator === EmptyIterator).isTrue()
            expectThat(iterator.hasNext()).isFalse()
            expectThrows<NoSuchElementException> { iterator.next() }
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

    @Test
    fun `asSequence validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this.asSequence() === emptySequence<Int>()).isTrue()
        }
        with(ImmutableIntArray(3) { it }) {
            val elementsFromSequence = this.asSequence().toList()
            expectThat(elementsFromSequence).isEqualTo(listOf(0, 1, 2))
        }
    }

    @Test
    fun `forEach validation`() {
        with(ImmutableIntArray(3) { it }) {
            val elements = mutableListOf<Int>()
            this.forEach { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)
                elements += element
            }
            expectThat(elements).isEqualTo(mutableListOf(0, 1, 2))
        }
    }

    @Test
    fun `forEachIndexed validation`() {
        with(ImmutableIntArray(3) { 10 * it }) {
            val elements = mutableMapOf<Int, Int>()
            this.forEachIndexed { index, element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)
                elements[index] = element
            }
            expectThat(elements).isEqualTo(
                mutableMapOf(
                    0 to 0,
                    1 to 10,
                    2 to 20,
                )
            )
        }
    }
}

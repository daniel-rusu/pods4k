package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isNotEqualTo
import strikt.assertions.isNull
import strikt.assertions.isTrue
import strikt.assertions.message
import kotlin.random.Random

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
            .containsExactly(0)

        // Cannot create with negative size
        expectThrows<NegativeArraySizeException> {
            ImmutableIntArray(-1) { it }
        }
    }

    @Test
    fun `copyFrom validation`() {
        with(intArrayOf(1, 2, 3)) {
            expectThrows<ArrayIndexOutOfBoundsException> {
                ImmutableIntArray.copyFrom(source = this, startIndex = -1, size = 1)
            }

            expectThrows<ArrayIndexOutOfBoundsException> {
                ImmutableIntArray.copyFrom(source = this, startIndex = 3, size = 1)
            }

            expectThrows<ArrayIndexOutOfBoundsException> {
                ImmutableIntArray.copyFrom(source = this, startIndex = 1, size = 3)
            }

            expectThrows<ArrayIndexOutOfBoundsException> {
                ImmutableIntArray.copyFrom(source = this, startIndex = 0, size = 4)
            }

            expectThat(ImmutableIntArray.copyFrom(source = this, startIndex = 0, size = 0))
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(ImmutableIntArray.copyFrom(source = this, startIndex = 0, size = 1))
                .isEqualTo(immutableArrayOf(1))

            expectThat(ImmutableIntArray.copyFrom(source = this, startIndex = 1, size = 2))
                .isEqualTo(immutableArrayOf(2, 3))

            expectThat(ImmutableIntArray.copyFrom(source = this, startIndex = 0, size = 3))
                .isEqualTo(immutableArrayOf(1, 2, 3))
        }
    }

    @Test
    fun `size validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(this).hasSize(0)
        }
        with(ImmutableIntArray(10) { it }) {
            expectThat(this).hasSize(10)
        }
    }

    @Test
    fun `lastIndex validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(this.lastIndex).isEqualTo(-1)
        }
        with(immutableArrayOf(1)) {
            expectThat(this.lastIndex).isEqualTo(0)
        }
        with(ImmutableIntArray(10) { it }) {
            expectThat(this.lastIndex).isEqualTo(9)
        }
    }

    @Test
    fun `indices validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(this.indices).isEqualTo(IntRange(start = 0, endInclusive = 2))
        }
    }

    @Test
    fun `toString validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(this.toString()).isEqualTo("[]")
        }
        with(immutableArrayOf(1)) {
            expectThat(this.toString()).isEqualTo("[1]")
        }
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(this.toString()).isEqualTo("[1, 2, 3]")
        }
    }

    @Test
    fun `joinToString validation`() {
        with(immutableArrayOf(1, 2, 3, 4)) {
            expectThat(
                joinToString(
                    separator = "->",
                    prefix = "#",
                    postfix = "#",
                    limit = 3, // only the first 3 elements
                    truncated = "<>",
                ) { (it * 10).toString() },
            ).isEqualTo("#10->20->30-><>#")
        }
    }

    @Test
    fun `equals validation`() {
        // Comprehensive testing is required here since equals in inline classes are experimental (as of Kotlin 1.9.23)
        // Note that we're purposely using expectThat(a == b).isTrue() instead of expectThat(a).isEqualTo(b) in order
        // to control when boxing occurs and to explicitly validate both scenarios.

        with(emptyImmutableIntArray()) {
            expectThat(this == emptyImmutableIntArray()).isTrue()
            expectThat(this.equals(emptyImmutableIntArray())).isTrue()
            expectThat((this as Any) == emptyImmutableIntArray()).isTrue()
            expectThat(this == (emptyImmutableIntArray() as Any)).isTrue()
            expectThat((this as Any) == (emptyImmutableIntArray() as Any)).isTrue()

            expectThat(this == immutableArrayOf(0)).isFalse()
            expectThat((this as Any) == immutableArrayOf(0)).isFalse()
            expectThat(this == (immutableArrayOf(0) as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf(0) as Any)).isFalse()

            expectThat(this == immutableArrayOf(1, 2)).isFalse()
            expectThat((this as Any) == immutableArrayOf(1, 2)).isFalse()
            expectThat(this == (immutableArrayOf(1, 2) as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf(1, 2) as Any)).isFalse()

            // Ensure same behavior as comparing IntArray with Array<Int>
            expectThat((this as Any) == emptyImmutableArray<Int>()).isFalse()
            expectThat(this == (emptyImmutableArray<Int>() as Any)).isFalse()
            expectThat((this as Any) == (emptyImmutableArray<Int>() as Any)).isFalse()

            // Ensure same behavior as comparing IntArray with BooleanArray
            expectThat((this as Any) == emptyImmutableBooleanArray()).isFalse()
            expectThat(this == (emptyImmutableBooleanArray() as Any)).isFalse()
            expectThat((this as Any) == (emptyImmutableBooleanArray() as Any)).isFalse()
        }

        with(immutableArrayOf(1, 3, 5)) {
            expectThat(this == immutableArrayOf(1, 3, 5)).isTrue()
            expectThat(this.equals(immutableArrayOf(1, 3, 5))).isTrue()
            expectThat((this as Any) == immutableArrayOf(1, 3, 5)).isTrue()
            expectThat(this == (immutableArrayOf(1, 3, 5) as Any)).isTrue()
            expectThat((this as Any) == (immutableArrayOf(1, 3, 5) as Any)).isTrue()

            expectThat(this == immutableArrayOf(1, 3)).isFalse()
            expectThat((this as Any) == immutableArrayOf(1, 3)).isFalse()
            expectThat(this == (immutableArrayOf(1, 3) as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf(1, 3) as Any)).isFalse()

            expectThat(this == immutableArrayOf(1, 3, 6)).isFalse()
            expectThat((this as Any) == immutableArrayOf(1, 3, 6)).isFalse()
            expectThat(this == (immutableArrayOf(1, 3, 6) as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf(1, 3, 6) as Any)).isFalse()

            // Ensure same behavior as comparing IntArray with Array<Int>
            expectThat((this as Any) == immutableArrayOf<Int>(1, 3, 5)).isFalse()
            expectThat(this == (immutableArrayOf<Int>(1, 3, 5) as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf<Int>(1, 3, 5) as Any)).isFalse()
        }
    }

    @Test
    fun `referencesSameArrayAs validation`() {
        val arrayWithValues = immutableArrayOf(1, 2)
        val secondArrayWithSameValues = immutableArrayOf(1, 2)

        expectThat(arrayWithValues.referencesSameArrayAs(arrayWithValues))
            .isTrue()

        expectThat(arrayWithValues)
            .isEqualTo(secondArrayWithSameValues)

        expectThat(arrayWithValues.referencesSameArrayAs(secondArrayWithSameValues))
            .isFalse()
    }

    @Test
    fun `hashCode validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(this.hashCode()).isEqualTo(emptyImmutableIntArray().hashCode())
            expectThat(this.hashCode()).isNotEqualTo(0)
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf(0).hashCode())
        }
        with(immutableArrayOf(0)) {
            expectThat(this.hashCode()).isEqualTo(immutableArrayOf(0).hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf(1).hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf(0, 0).hashCode())
        }
        with(immutableArrayOf(1)) {
            expectThat(this.hashCode()).isEqualTo(immutableArrayOf(1).hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf(0, 1).hashCode())
        }
        with(immutableArrayOf(1, 2)) {
            expectThat(this.hashCode()).isEqualTo(immutableArrayOf(1, 2).hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf(2, 1).hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf(0, 1, 2).hashCode())
        }
    }

    @Test
    fun `isEmpty and isNotEmpty validation`() {
        expectThat(emptyImmutableIntArray())
            .isA<ImmutableIntArray>()
            .isEmpty()

        expectThat(immutableArrayOf(1, 2, 3))
            .isA<ImmutableIntArray>()
            .isNotEmpty()
    }

    @Test
    fun `get validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(get(0)::class.java).isEqualTo(primitiveIntClass)

            expectThat(get(0)).isEqualTo(1)
            expectThat(get(1)).isEqualTo(2)
            expectThat(get(2)).isEqualTo(3)

            expectThrows<ArrayIndexOutOfBoundsException> {
                get(3)
            }
        }
    }

    @Test
    fun `getOrNull validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(this.getOrNull(2)).isEqualTo(3)
            expectThat(this.getOrNull(3)).isNull()
        }
    }

    @Test
    fun `index operator validation`() {
        with(immutableArrayOf(1, 2, 3)) {
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
        val values = immutableArrayOf(1, 2, 3, 4, 5)
        with(values) {
            val (first) = this
            expectThat(first::class.java == primitiveIntClass)
            expectThat(first).isEqualTo(1)
        }
        with(values) {
            val (first, second) = this
            expectThat(first).isEqualTo(1)
            expectThat(second).isEqualTo(2)
        }
        with(values) {
            val (first, second, third) = this
            expectThat(first).isEqualTo(1)
            expectThat(second).isEqualTo(2)
            expectThat(third).isEqualTo(3)
        }
        with(values) {
            val (first, second, third, fourth) = this
            expectThat(first).isEqualTo(1)
            expectThat(second).isEqualTo(2)
            expectThat(third).isEqualTo(3)
            expectThat(fourth).isEqualTo(4)
        }
        with(values) {
            val (first, second, third, fourth, fifth) = this
            expectThat(first).isEqualTo(1)
            expectThat(second).isEqualTo(2)
            expectThat(third).isEqualTo(3)
            expectThat(fourth).isEqualTo(4)
            expectThat(fifth).isEqualTo(5)
        }
    }

    @Test
    fun `single validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            expectThrows<IllegalArgumentException> {
                this.single()
            }.message.isEqualTo("Array has more than one element.")
        }
        with(immutableArrayOf(1)) {
            val singleValue = this.single()
            expectThat(singleValue).isEqualTo(1)
            expectThat(singleValue::class.java).isEqualTo(primitiveIntClass)
        }
    }

    @Test
    fun `single with predicate validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            expectThrows<IllegalArgumentException> {
                this.single { it > 0 }
            }.message.isEqualTo("Array contains more than one matching element.")
        }
        with(immutableArrayOf(2, 3, 4)) {
            expectThat(this.single { it % 2 == 1 }).isEqualTo(3)
        }
    }

    @Test
    fun `singleOrNull validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(this.singleOrNull()).isNull()
        }
        with(immutableArrayOf(1)) {
            expectThat(this.singleOrNull()).isEqualTo(1)
        }
    }

    @Test
    fun `singleOrNull with predicate validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(
                this.singleOrNull { it > 0 },
            ).isNull()
        }
        with(immutableArrayOf(2, 3, 4)) {
            expectThat(this.singleOrNull { it % 2 == 1 }).isEqualTo(3)
        }
    }

    @Test
    fun `first validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            val first = this.first()
            expectThat(first).isEqualTo(1)
            expectThat(first::class.java).isEqualTo(primitiveIntClass)
        }
    }

    @Test
    fun `first with predicate validation`() {
        with(immutableArrayOf(1, 2, 3, 4)) {
            val first = this.first { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)

                element % 2 == 0
            }
            expectThat(first).isEqualTo(2)
        }
    }

    @Test
    fun `firstOrNull validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(this.firstOrNull()).isNull()
        }
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(this.firstOrNull()).isEqualTo(1)
        }
    }

    @Test
    fun `firstOrNull with predicate validation`() {
        with(immutableArrayOf(1, 2, 3, 4)) {
            val first = this.firstOrNull { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)

                element % 2 == 0
            }
            expectThat(first).isEqualTo(2)

            expectThat(this.firstOrNull { it % 7 == 0 }).isNull()
        }
    }

    @Test
    fun `last validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            val last = this.last()
            expectThat(last).isEqualTo(3)
            expectThat(last::class.java).isEqualTo(primitiveIntClass)
        }
    }

    @Test
    fun `last with predicate validation`() {
        with(immutableArrayOf(1, 2, 3, 4)) {
            val last = this.last { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)

                element % 2 == 0
            }
            expectThat(last).isEqualTo(4)
        }
    }

    @Test
    fun `lastOrNull validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(this.lastOrNull()).isNull()
        }
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(this.lastOrNull()).isEqualTo(3)
        }
    }

    @Test
    fun `lastOrNull with predicate validation`() {
        with(immutableArrayOf(1, 2, 3, 4)) {
            val last = this.lastOrNull { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)

                element % 2 == 0
            }
            expectThat(last).isEqualTo(4)

            expectThat(this.lastOrNull { it % 7 == 0 })
                .isNull()
        }
    }

    @Test
    fun `random validation`() {
        expectThrows<NoSuchElementException> {
            emptyImmutableIntArray().random()
        }.message.isEqualTo("Array is empty.")

        expectThat(immutableArrayOf(3).random())
            .isEqualTo(3)

        with(immutableArrayOf(1, 5, 3)) {
            expectThat(random(Random(seed = 0)))
                .isEqualTo(1)

            expectThat(random(Random(seed = 2)))
                .isEqualTo(5)
        }
    }

    @Test
    fun `randomOrNull validation`() {
        expectThat(emptyImmutableIntArray().randomOrNull())
            .isEqualTo(null)

        expectThat(immutableArrayOf(3).randomOrNull())
            .isEqualTo(3)

        with(immutableArrayOf(1, 5, 3)) {
            expectThat(randomOrNull(Random(seed = 0)))
                .isEqualTo(1)

            expectThat(randomOrNull(Random(seed = 2)))
                .isEqualTo(5)
        }
    }

    @Test
    fun `iterator validation`() {
        with(immutableArrayOf(1, 2)) {
            val iterator = this.iterator()
            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(1)

            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(2)

            expectThat(iterator.hasNext()).isFalse()
        }

        // can iterate with a regular for-loop
        with(immutableArrayOf(1, 2, 3)) {
            val elements = mutableListOf<Int>()
            for (element in this) {
                expectThat(element::class.java).isEqualTo(primitiveIntClass)
                elements += element
            }
            expectThat(elements).isEqualTo(mutableListOf(1, 2, 3))
        }
    }

    @Test
    fun `asIterable validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            val iterable = this.asIterable()
            expectThat(iterable).isA<Iterable<Int>>()

            expectThat(iterable.toList()).isEqualTo(listOf(1, 2, 3))
        }
    }

    @Test
    fun `withIndex validation`() {
        with(immutableArrayOf(1, 2)) {
            expectThat(this.withIndex().toList()).isEqualTo(
                listOf(IndexedValue(index = 0, value = 1), IndexedValue(index = 1, value = 2)),
            )
        }
    }

    @Test
    fun `asSequence validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            val elementsFromSequence = this.asSequence().toList()
            expectThat(elementsFromSequence).isEqualTo(listOf(1, 2, 3))
        }
    }

    @Test
    fun `toMutableArray validation`() {
        with(emptyImmutableIntArray()) {
            val result = toMutableArray()

            expectThat(result)
                .isA<IntArray>()

            expectThat(result.size)
                .isEqualTo(0)
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThat(toMutableArray())
                .isEqualTo(intArrayOf(1, 2, 3))
        }
    }

    @Test
    fun `toTypedMutableArray validation`() {
        with(emptyImmutableIntArray()) {
            val result = toTypedMutableArray()

            expectThat(result)
                .isA<Array<Int>>()

            expectThat(result.size)
                .isEqualTo(0)
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThat(toTypedMutableArray())
                .isEqualTo(arrayOf(1, 2, 3))
        }
    }

    @Test
    fun `can use spread operator with toTypedMutableArray`() {
        // Note that numbers is Int? instead of Int otherwise a primitive non-typed array would be required
        fun inspectNumbers(vararg numbers: Int?) {
            expectThat(numbers.size)
                .isEqualTo(2)

            expectThat(numbers[0])
                .isEqualTo(100)

            expectThat(numbers[1])
                .isEqualTo(200)
        }

        val numbers = immutableArrayOf(100, 200)
        inspectNumbers(*numbers.toTypedMutableArray())
    }

    @Test
    fun `can use spread operator with toMutableArray`() {
        fun inspectNumbers(vararg numbers: Int) {
            expectThat(numbers.size)
                .isEqualTo(2)

            expectThat(numbers[0])
                .isEqualTo(100)

            expectThat(numbers[1])
                .isEqualTo(200)
        }

        val numbers = immutableArrayOf(100, 200)
        inspectNumbers(*numbers.toMutableArray())
    }

    @Test
    fun `forEach validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            val elements = mutableListOf<Int>()
            this.forEach { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)
                elements += element
            }
            expectThat(elements).isEqualTo(mutableListOf(1, 2, 3))
        }
    }

    @Test
    fun `forEachIndexed validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            val elements = mutableMapOf<Int, Int>()
            this.forEachIndexed { index, element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)
                elements[index] = element
            }
            expectThat(elements).isEqualTo(
                mutableMapOf(
                    0 to 1,
                    1 to 2,
                    2 to 3,
                ),
            )
        }
    }

    @Test
    fun `all validation`() {
        with(immutableArrayOf(2, 4, 6)) {
            expectThat(all { it % 2 == 0 })
                .isTrue()

            expectThat(all { it <= 5 })
                .isFalse()
        }
    }

    @Test
    fun `any validation`() {
        with(immutableArrayOf(2, 4, 6)) {
            expectThat(any { it % 4 == 0 })
                .isTrue()

            expectThat(any { it > 10 })
                .isFalse()
        }
    }

    @Test
    fun `none validation`() {
        with(immutableArrayOf(2, 4, 6)) {
            expectThat(none { it % 5 == 0 })
                .isTrue()

            expectThat(none { it % 4 == 0 })
                .isFalse()
        }
    }

    @Test
    fun `count validation`() {
        with(immutableArrayOf(2, 4, 6)) {
            expectThat(count { it <= 4 })
                .isEqualTo(2)
        }
    }

    @Test
    fun `indexOfFirst validation`() {
        with(immutableArrayOf(1, 2, 3, 4)) {
            expectThat(indexOfFirst { it % 2 == 0 })
                .isEqualTo(1)

            expectThat(indexOfFirst { it % 5 == 0 })
                .isEqualTo(-1)
        }
    }

    @Test
    fun `indexOfLast validation`() {
        with(immutableArrayOf(1, 2, 3, 4)) {
            expectThat(indexOfLast { it % 2 == 0 })
                .isEqualTo(3)

            expectThat(indexOfLast { it % 5 == 0 })
                .isEqualTo(-1)
        }
    }

    @Test
    fun `sumOf validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(sumOf { it * 2 })
                .isA<Int>()
                .isEqualTo(12)

            expectThat(sumOf { it.toLong() * 2 })
                .isA<Long>()
                .isEqualTo(12L)

            expectThat(sumOf { it * 2.0f })
                .isA<Float>()
                .isEqualTo(12.0f)

            expectThat(sumOf { it * 2.0 })
                .isA<Double>()
                .isEqualTo(12.0)
        }
    }

    @Test
    fun `minBy validation`() {
        with(emptyImmutableIntArray()) {
            expectThrows<NoSuchElementException> { minBy { it % 3 } }
        }

        with(immutableArrayOf(4)) {
            expectThat(minBy { it % 3 })
                .isEqualTo(4)
        }

        with(immutableArrayOf(2, 6, 0)) {
            expectThat(minBy { it % 3 })
                .isEqualTo(6)
        }
    }

    @Test
    fun `minByOrNull validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(minByOrNull { it % 3 })
                .isNull()
        }

        with(immutableArrayOf(4)) {
            expectThat(minByOrNull { it % 3 })
                .isEqualTo(4)
        }

        with(immutableArrayOf(2, 6, 0)) {
            expectThat(minByOrNull { it % 3 })
                .isEqualTo(6)
        }
    }

    @Test
    fun `maxBy validation`() {
        with(emptyImmutableIntArray()) {
            expectThrows<NoSuchElementException> { maxBy { it % 3 } }
        }

        with(immutableArrayOf(4)) {
            expectThat(maxBy { it % 3 })
                .isEqualTo(4)
        }

        with(immutableArrayOf(1, 2, 5)) {
            expectThat(maxBy { it % 3 })
                .isEqualTo(2)
        }
    }

    @Test
    fun `maxByOrNull validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(maxByOrNull { it % 3 })
                .isNull()
        }

        with(immutableArrayOf(4)) {
            expectThat(maxByOrNull { it % 3 })
                .isEqualTo(4)
        }

        with(immutableArrayOf(1, 2, 5)) {
            expectThat(maxByOrNull { it % 3 })
                .isEqualTo(2)
        }
    }

    @Test
    fun `minWith validation`() {
        with(emptyImmutableIntArray()) {
            expectThrows<NoSuchElementException> { minWith(Comparator.comparing { it % 3 }) }
        }

        with(immutableArrayOf(4)) {
            expectThat(minWith(Comparator.comparing { it % 3 }))
                .isEqualTo(4)
        }

        with(immutableArrayOf(2, 6, 0)) {
            expectThat(minWith(Comparator.comparing { it % 3 }))
                .isEqualTo(6)
        }
    }

    @Test
    fun `minWithOrNull validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(minWithOrNull(Comparator.comparing { it % 3 }))
                .isNull()
        }

        with(immutableArrayOf(4)) {
            expectThat(minWithOrNull(Comparator.comparing { it % 3 }))
                .isEqualTo(4)
        }

        with(immutableArrayOf(2, 6, 0)) {
            expectThat(minWithOrNull(Comparator.comparing { it % 3 }))
                .isEqualTo(6)
        }
    }

    @Test
    fun `maxWith validation`() {
        with(emptyImmutableIntArray()) {
            expectThrows<NoSuchElementException> { maxWith(Comparator.comparing { it % 3 }) }
        }

        with(immutableArrayOf(4)) {
            expectThat(maxWith(Comparator.comparing { it % 3 }))
                .isEqualTo(4)
        }

        with(immutableArrayOf(1, 2, 5)) {
            expectThat(maxWith(Comparator.comparing { it % 3 }))
                .isEqualTo(2)
        }
    }

    @Test
    fun `maxWithOrNull validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(maxWithOrNull(Comparator.comparing { it % 3 }))
                .isNull()
        }

        with(immutableArrayOf(4)) {
            expectThat(maxWithOrNull(Comparator.comparing { it % 3 }))
                .isEqualTo(4)
        }

        with(immutableArrayOf(1, 2, 5)) {
            expectThat(maxWithOrNull(Comparator.comparing { it % 3 }))
                .isEqualTo(2)
        }
    }

    @Test
    fun `sortedBy validation`() {
        with(immutableArrayOf(3, 17, 11)) {
            expectThat(sortedBy { it.toString() })
                .isEqualTo(immutableArrayOf(11, 17, 3))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf(3, 17, 11))
        }
    }

    @Test
    fun `take validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(take(0))
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(take(10))
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThrows<IllegalArgumentException> {
                take(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(take(0))
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(take(1))
                .isEqualTo(immutableArrayOf(1))

            expectThat(take(2))
                .isEqualTo(immutableArrayOf(1, 2))

            expectThat(take(3).referencesSameArrayAs(this))
                .isTrue()

            expectThat(take(10).referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `takeWhile validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(takeWhile { true })
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(takeWhile { false })
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 5, 3)) {
            expectThat(takeWhile { it >= 2 })
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(takeWhile { it <= 4 })
                .isEqualTo(immutableArrayOf(1, 2))

            expectThat(takeWhile { it <= 5 }.referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `takeLast validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(takeLast(0))
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(takeLast(10))
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThrows<IllegalArgumentException> {
                takeLast(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(takeLast(0))
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(takeLast(1))
                .isEqualTo(immutableArrayOf(3))

            expectThat(takeLast(2))
                .isEqualTo(immutableArrayOf(2, 3))

            expectThat(takeLast(3).referencesSameArrayAs(this))
                .isTrue()

            expectThat(takeLast(10).referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `takeLastWhile validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(takeLastWhile { true })
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(takeLastWhile { false })
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 5, 2, 3)) {
            expectThat(takeLastWhile { it <= 2 })
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(takeLastWhile { it <= 4 })
                .isEqualTo(immutableArrayOf(2, 3))

            expectThat(takeLastWhile { it <= 5 }.referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `drop validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(drop(0))
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(dropLast(10))
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThrows<IllegalArgumentException> {
                drop(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(drop(0).referencesSameArrayAs(this))
                .isTrue()

            expectThat(drop(1))
                .isEqualTo(immutableArrayOf(2, 3))

            expectThat(drop(2))
                .isEqualTo(immutableArrayOf(3))

            expectThat(drop(3))
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(drop(10))
                .isA<ImmutableIntArray>()
                .isEmpty()
        }
    }

    @Test
    fun `dropWhile validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(dropWhile { true })
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(dropWhile { false })
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 5, 3)) {
            expectThat(dropWhile { it <= 5 })
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(dropWhile { it <= 4 })
                .isEqualTo(immutableArrayOf(5, 3))

            expectThat(dropWhile { it <= 0 }.referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `dropLast validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(dropLast(0))
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(dropLast(10))
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThrows<IllegalArgumentException> {
                dropLast(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(dropLast(0).referencesSameArrayAs(this))
                .isTrue()

            expectThat(dropLast(1))
                .isEqualTo(immutableArrayOf(1, 2))

            expectThat(dropLast(2))
                .isEqualTo(immutableArrayOf(1))

            expectThat(dropLast(3))
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(dropLast(10))
                .isA<ImmutableIntArray>()
                .isEmpty()
        }
    }

    @Test
    fun `dropLastWhile validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(dropLastWhile { true })
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(dropLastWhile { false })
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 5, 3)) {
            expectThat(dropLastWhile { it <= 5 })
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(dropLastWhile { it <= 4 })
                .isEqualTo(immutableArrayOf(1, 2, 5))

            expectThat(dropLastWhile { it <= 0 }.referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `filter validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(filter { it % 2 == 0 })
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 3, 4)) {
            expectThat(filter { it % 2 == 0 })
                .isEqualTo(immutableArrayOf(2, 4))

            expectThat(filter { it >= 0 }.referencesSameArrayAs(this))
                .isTrue()
        }

        // fuzz testing ensuring that the behavior matches regular arrays since the implementation is complex
        repeat(100) {
            val size = Random.nextInt(from = 0, until = 200)
            val randomValues = IntArray(size) { Random.nextInt() }

            expectThat(randomValues.toImmutableArray().filter { it % 2 == 0 }.asList())
                .isEqualTo(randomValues.filter { it % 2 == 0 })
        }
    }

    @Test
    fun `filterIndexed validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(filterIndexed { index, element -> element == index })
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(0, 3, 2, 4)) {
            expectThat(filterIndexed { index, element -> element == index })
                .isEqualTo(immutableArrayOf(0, 2))

            expectThat(
                filterIndexed { index, element -> index + element >= 0 }
                    .referencesSameArrayAs(this),
            ).isTrue()
        }

        // fuzz testing ensuring that the behavior matches regular arrays since the implementation is complex
        repeat(100) {
            val size = Random.nextInt(from = 0, until = 200)
            val randomValues = IntArray(size) { Random.nextInt() }

            expectThat(
                randomValues.toImmutableArray().filterIndexed { index, value -> (index + value) % 2 == 0 }.asList(),
            ).isEqualTo(randomValues.filterIndexed { index, value -> (index + value) % 2 == 0 })
        }
    }

    @Test
    fun `filterNot validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(filterNot { it % 2 == 0 })
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 3, 4)) {
            expectThat(filterNot { it % 2 == 0 })
                .isEqualTo(immutableArrayOf(1, 3))

            expectThat(filterNot { it < 0 }.referencesSameArrayAs(this))
                .isTrue()
        }

        // fuzz testing ensuring that the behavior matches regular arrays since the implementation is complex
        repeat(100) {
            val size = Random.nextInt(from = 0, until = 200)
            val randomValues = IntArray(size) { Random.nextInt() }

            expectThat(randomValues.toImmutableArray().filterNot { it % 2 == 0 }.asList())
                .isEqualTo(randomValues.filterNot { it % 2 == 0 })
        }
    }

    @Test
    fun `partition validation`() {
        with(emptyImmutableIntArray()) {
            val pair = partition { it % 2 == 0 }
            expectThat(pair.first)
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(pair.second)
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, 2, 3, 4)) {
            expectThat(partition { it % 2 == 0 })
                .isEqualTo(Pair(immutableArrayOf(2, 4), immutableArrayOf(1, 3)))

            var pair = partition { it < 0 }
            expectThat(pair.first)
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(pair.second.referencesSameArrayAs(this))
                .isTrue()

            pair = partition { it > 0 }
            expectThat(pair.first.referencesSameArrayAs(this))
                .isTrue()

            expectThat(pair.second)
                .isA<ImmutableIntArray>()
                .isEmpty()
        }
    }

    @Test
    fun `sortedByDescending validation`() {
        with(immutableArrayOf(1)) {
            expectThat(sortedBy { it.toString() }.referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf(3, 17, 11)) {
            expectThat(sortedByDescending { it.toString() })
                .isEqualTo(immutableArrayOf(3, 17, 11))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf(3, 17, 11))
        }
    }

    @Test
    fun `sortedWith validation`() {
        with(immutableArrayOf(1)) {
            val comparator = Comparator<Int> { o1, o2 -> o1.compareTo(o2) }

            expectThat(sortedWith(comparator).referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf(1, 5, 3, 4)) {
            val comparator = Comparator<Int> { o1, o2 -> o1.compareTo(o2) }

            expectThat(sortedWith(comparator))
                .isEqualTo(immutableArrayOf(1, 3, 4, 5))

            expectThat(sortedWith(comparator.reversed()))
                .isEqualTo(immutableArrayOf(5, 4, 3, 1))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf(1, 5, 3, 4))
        }
    }

    @Test
    fun `shuffled validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(shuffled().referencesSameArrayAs(ImmutableIntArray.EMPTY))
                .isTrue()

            expectThat(shuffled(Random).referencesSameArrayAs(ImmutableIntArray.EMPTY))
                .isTrue()
        }

        with(immutableArrayOf(1)) {
            expectThat(shuffled().referencesSameArrayAs(this))
                .isTrue()

            expectThat(shuffled(Random).referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThat(shuffled(Random(seed = 0L)))
                .isEqualTo(immutableArrayOf(2, 3, 1))

            expectThat(this)
                .isEqualTo(immutableArrayOf(1, 2, 3))
        }
    }

    @Test
    fun `distinct validation`() {
        expectThat(emptyImmutableIntArray().distinct())
            .isA<ImmutableIntArray>()
            .isEmpty()

        with(immutableArrayOf(1, 2, 3)) {
            expectThat(distinct().referencesSameArrayAs(this))
                .isTrue()
        }

        expectThat(immutableArrayOf(1, 1, 2, 3, 3).distinct())
            .isA<ImmutableIntArray>()
            .isEqualTo(immutableArrayOf(1, 2, 3))
    }

    @Test
    fun `distinctBy validation`() {
        expectThat(emptyImmutableIntArray().distinctBy { it.toString().length })
            .isA<ImmutableIntArray>()
            .isEmpty()

        with(immutableArrayOf(1, 20, 300)) {
            expectThat(distinctBy { it.toString().length }.referencesSameArrayAs(this))
                .isTrue()
        }

        expectThat(immutableArrayOf(1, 2, 10, 20, 100).distinctBy { it.toString().length })
            .isEqualTo(immutableArrayOf(1, 10, 100))
    }

    @Test
    fun `builder add validation`() {
        val builder = ImmutableIntArray.Builder()

        expectThat(builder.size)
            .isEqualTo(0)
        expectThat(builder.build())
            .isA<ImmutableIntArray>()
            .isEmpty()

        builder.add(1)

        expectThat(builder.size)
            .isEqualTo(1)
        expectThat(builder.build())
            .isEqualTo(immutableArrayOf(1))

        builder.add(2)
        builder.add(3)

        expectThat(builder.size)
            .isEqualTo(3)
        expectThat(builder.build())
            .isEqualTo(immutableArrayOf(1, 2, 3))
    }

    @Test
    fun `builder plusAssign validation`() {
        val builder = ImmutableIntArray.Builder()

        expectThat(builder.size)
            .isEqualTo(0)
        expectThat(builder.build())
            .isA<ImmutableIntArray>()
            .isEmpty()

        builder += 1

        expectThat(builder.size)
            .isEqualTo(1)
        expectThat(builder.build())
            .isEqualTo(immutableArrayOf(1))

        builder += 2

        expectThat(builder.size)
            .isEqualTo(2)
        expectThat(builder.build())
            .isEqualTo(immutableArrayOf(1, 2))
    }

    @Test
    fun `builder resizing validation`() {
        val builder = ImmutableIntArray.Builder(initialCapacity = 10)

        val numElementsToAdd = 100
        for (index in 0..<numElementsToAdd) {
            builder += index

            expectThat(builder.size)
                .isEqualTo(index + 1)
        }

        expectThat(builder.build())
            .isEqualTo(ImmutableIntArray(numElementsToAdd) { it })
    }

    @Test
    fun `builder addAll validation`() {
        val builder = ImmutableIntArray.Builder(initialCapacity = 10)

        // Add all from primitive array
        builder.addAll(intArrayOf(0, 1, 2, 3, 4))

        expectThat(builder.size)
            .isEqualTo(5)
        expectThat(builder.build())
            .isEqualTo(ImmutableIntArray(5) { it })

        // Add all from generic array
        builder.addAll(arrayOf(5, 6, 7, 8, 9, 10))

        expectThat(builder.size)
            .isEqualTo(11)
        expectThat(builder.build())
            .isEqualTo(ImmutableIntArray(11) { it })

        // Add all from primitive immutable array
        builder.addAll(immutableArrayOf(11, 12, 13, 14))

        expectThat(builder.size)
            .isEqualTo(15)
        expectThat(builder.build())
            .isEqualTo(ImmutableIntArray(15) { it })

        // Add all from generic immutable array
        builder.addAll(immutableArrayOf<Int>(15, 16, 17))

        expectThat(builder.size)
            .isEqualTo(18)
        expectThat(builder.build())
            .isEqualTo(ImmutableIntArray(18) { it })

        // Add all from collection
        builder.addAll(listOf(18, 19, 20))

        expectThat(builder.size)
            .isEqualTo(21)
        expectThat(builder.build())
            .isEqualTo(ImmutableIntArray(21) { it })
    }
}

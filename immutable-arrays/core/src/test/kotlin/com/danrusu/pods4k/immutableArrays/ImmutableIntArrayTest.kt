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
import kotlin.collections.set

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

        // Cannot create with negative size
        expectThrows<NegativeArraySizeException> {
            ImmutableIntArray(-1) { it }
        }
    }

    @Test
    fun `size validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this).hasSize(0)
        }
        with(ImmutableIntArray(10) { it }) {
            expectThat(this).hasSize(10)
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
        with(ImmutableIntArray(0) { it }) {
            expectThat(this).isEmpty()
        }
        with(ImmutableIntArray(3) { it }) {
            expectThat(this).isNotEmpty()
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
            expectThat(this.getOrNull(2)).isEqualTo(2)
            expectThat(this.getOrNull(3)).isNull()
        }
    }

    @Test
    fun `getOrElse validation`() {
        with(ImmutableIntArray(3) { it }) {
            expectThat(
                this.getOrElse(2) { 100 }::class.java
            ).isEqualTo(primitiveIntClass)
            expectThat(
                this.getOrElse(2) { 100 }
            ).isEqualTo(2)
            expectThat(
                this.getOrElse(3) { 100 }
            ).isEqualTo(100)
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
        with(ImmutableIntArray(3) { it }) {
            expectThrows<IllegalArgumentException> {
                this.single()
            }.message.isEqualTo("Array has more than one element.")
        }
        with(ImmutableIntArray(1) { it }) {
            val singleValue = this.single()
            expectThat(singleValue).isEqualTo(0)
            expectThat(singleValue::class.java).isEqualTo(primitiveIntClass)
        }
    }

    @Test
    fun `single with predicate validation`() {
        with(ImmutableIntArray(3) { it }) {
            expectThrows<IllegalArgumentException> {
                this.single { it > 0 }
            }.message.isEqualTo("Array contains more than one matching element.")
        }
        with(ImmutableIntArray(3) { it }) {
            expectThat(this.single { it % 2 == 1 }).isEqualTo(1)
        }
    }

    @Test
    fun `singleOrNull validation`() {
        with(ImmutableIntArray(3) { it }) {
            expectThat(this.singleOrNull()).isNull()
        }
        with(ImmutableIntArray(1) { it }) {
            expectThat(this.singleOrNull()).isEqualTo(0)
        }
    }

    @Test
    fun `singleOrNull with predicate validation`() {
        with(ImmutableIntArray(3) { it }) {
            expectThat(
                this.singleOrNull { it > 0 }
            ).isNull()
        }
        with(ImmutableIntArray(3) { it }) {
            expectThat(this.singleOrNull { it % 2 == 1 }).isEqualTo(1)
        }
    }

    @Test
    fun `first validation`() {
        with(ImmutableIntArray(3) { it }) {
            val first = this.first()
            expectThat(first).isEqualTo(0)
            expectThat(first::class.java).isEqualTo(primitiveIntClass)
        }
    }

    @Test
    fun `first with predicate validation`() {
        with(ImmutableIntArray(5) { 2 * it }) {
            val first = this.first { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)

                element % 4 == 0
            }
            expectThat(first).isEqualTo(0)
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
    fun `firstOrNull with predicate validation`() {
        with(ImmutableIntArray(5) { 2 * it }) {
            val first = this.firstOrNull { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)

                element % 4 == 0
            }
            expectThat(first).isEqualTo(0)

            expectThat(this.firstOrNull { it > 0 && it % 7 == 0 }).isNull()
        }
    }

    @Test
    fun `last validation`() {
        with(ImmutableIntArray(3) { it }) {
            val last = this.last()
            expectThat(last).isEqualTo(2)
            expectThat(last::class.java).isEqualTo(primitiveIntClass)
        }
    }

    @Test
    fun `last with predicate validation`() {
        with(ImmutableIntArray(6) { 2 * it }) {
            val last = this.last { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)

                element % 4 == 0
            }
            expectThat(last).isEqualTo(8)
        }
    }

    @Test
    fun `lastOrNull validation`() {
        with(ImmutableIntArray(0) { it }) {
            expectThat(this.lastOrNull()).isNull()
        }
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.lastOrNull()).isEqualTo("element 2")
        }
    }

    @Test
    fun `lastOrNull with predicate validation`() {
        with(ImmutableIntArray(6) { 2 * it }) {
            val last = this.lastOrNull { element ->
                expectThat(element::class.java).isEqualTo(primitiveIntClass)

                element % 4 == 0
            }
            expectThat(last).isEqualTo(8)

            expectThat(
                this.lastOrNull { it > 0 && it % 7 == 0 }
            ).isNull()
        }
    }

    @Test
    fun `iterator validation`() {
        with(ImmutableIntArray(2) { it }) {
            val iterator = this.iterator()
            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(0)

            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo(1)

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
    fun `asIterable validation`() {
        with(ImmutableIntArray(3) { it }) {
            val iterable = this.asIterable()
            expectThat(iterable).isA<Iterable<Int>>()

            expectThat(iterable.toList()).isEqualTo(listOf(0, 1, 2))
        }
    }

    @Test
    fun `withIndex validation`() {
        with(ImmutableIntArray(2) { 10 * it }) {
            expectThat(this.withIndex().toList()).isEqualTo(
                listOf(IndexedValue(index = 0, value = 0), IndexedValue(index = 1, value = 10))
            )
        }
    }

    @Test
    fun `asSequence validation`() {
        with(ImmutableIntArray(3) { it }) {
            val elementsFromSequence = this.asSequence().toList()
            expectThat(elementsFromSequence).isEqualTo(listOf(0, 1, 2))
        }
    }

    @Test
    fun `asList validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(asList())
                .isEqualTo(listOf(1, 2, 3))
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
    fun `sortedByDescending validation`() {
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
    fun `builder add validation`() {
        val builder = ImmutableIntArray.Builder()

        expectThat(builder.size)
            .isEqualTo(0)
        expectThat(builder.build())
            .isEqualTo(emptyImmutableIntArray())

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
            .isEqualTo(emptyImmutableIntArray())

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

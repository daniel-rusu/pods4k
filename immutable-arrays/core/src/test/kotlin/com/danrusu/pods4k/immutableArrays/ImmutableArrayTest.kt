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

private data class Person(val id: Int)

/**
 * IMPORTANT:
 * Read TESTING-STRATEGY.md before modifying this file.
 */
class ImmutableArrayTest {
    @Test
    fun `immutable arrays are covariant`() {
        open class Person(val name: String)
        class Manager(name: String, val numEmployees: Int) : Person(name)

        val bob = Manager(name = "Bob", numEmployees = 3)
        val managers: ImmutableArray<Manager> = immutableArrayOf(bob)

        // This should be allowed because every manager is also a person
        val people: ImmutableArray<Person> = managers

        // The managers ImmutableArray<Manager> is safe from heap pollution when referenced as an
        // ImmutableArray<Person> because it's immutable, so we can't add a regular non-manager person into it
        expectThat(people.single() === bob).isTrue()
    }

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
        with(ImmutableArray(0) { "element $it" }) {
            expectThat(this).hasSize(0)
        }
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
    fun `equals validation`() {
        // Comprehensive testing is required here since equals in inline classes are experimental (as of Kotlin 1.9.23)
        // Note that we're purposely using expectThat(a == b).isTrue() instead of expectThat(a).isEqualTo(b) in order
        // to control when boxing occurs and to explicitly validate both scenarios.

        with(emptyImmutableArray<String>()) {
            expectThat(this == emptyImmutableArray<String>()).isTrue()
            expectThat(this.equals(emptyImmutableArray<String>())).isTrue()
            expectThat((this as Any) == emptyImmutableArray<String>()).isTrue()
            expectThat(this == (emptyImmutableArray<String>() as Any)).isTrue()
            expectThat((this as Any) == (emptyImmutableArray<String>() as Any)).isTrue()

            expectThat(this == immutableArrayOf("")).isFalse()
            expectThat((this as Any) == immutableArrayOf("")).isFalse()
            expectThat(this == (immutableArrayOf("") as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf("") as Any)).isFalse()

            expectThat(this == immutableArrayOf("bob")).isFalse()
            expectThat((this as Any) == immutableArrayOf("bob")).isFalse()
            expectThat(this == (immutableArrayOf("bob") as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf("bob") as Any)).isFalse()

            // Ensure same behavior as comparing Array<String> with Array<Int> since generics are erased at compile
            expectThat((this as Any) == emptyImmutableArray<Int>()).isTrue()
            expectThat(this == (emptyImmutableArray<Int>() as Any)).isTrue()
            expectThat((this as Any) == (emptyImmutableArray<Int>() as Any)).isTrue()
        }

        with(immutableArrayOf("one", "two")) {
            expectThat(this == immutableArrayOf("one", "two")).isTrue()
            expectThat(this.equals(immutableArrayOf("one", "two"))).isTrue()
            expectThat((this as Any) == immutableArrayOf("one", "two")).isTrue()
            expectThat(this == (immutableArrayOf("one", "two") as Any)).isTrue()
            expectThat((this as Any) == (immutableArrayOf("one", "two") as Any)).isTrue()

            expectThat(this == immutableArrayOf("one")).isFalse()
            expectThat((this as Any) == immutableArrayOf("one")).isFalse()
            expectThat(this == (immutableArrayOf("one") as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf("one") as Any)).isFalse()

            expectThat(this == immutableArrayOf("one", "two", "three")).isFalse()
            expectThat((this as Any) == immutableArrayOf("one", "two", "three")).isFalse()
            expectThat(this == (immutableArrayOf("one", "two", "three") as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf("one", "two", "three") as Any)).isFalse()
        }

        with(immutableArrayOf("1", "2")) {
            expectThat((this as Any) == immutableArrayOf<Int>(1, 2)).isFalse()
            expectThat(this == (immutableArrayOf<Int>(1, 2) as Any)).isFalse()
            expectThat((this as Any) == (immutableArrayOf<Int>(1, 2) as Any)).isFalse()
        }
    }

    @Test
    fun `hashCode validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(this.hashCode()).isEqualTo(emptyImmutableArray<String>().hashCode())
            expectThat(this.hashCode()).isNotEqualTo(0)
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf("").hashCode())
        }
        with(immutableArrayOf("")) {
            expectThat(this.hashCode()).isEqualTo(immutableArrayOf("").hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf("boo").hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf("", "").hashCode())
        }
        with(immutableArrayOf("one")) {
            expectThat(this.hashCode()).isEqualTo(immutableArrayOf("one").hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf("", "one").hashCode())
        }
        with(immutableArrayOf("one", "two")) {
            expectThat(this.hashCode()).isEqualTo(immutableArrayOf("one", "two").hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf("two", "one").hashCode())
            expectThat(this.hashCode()).isNotEqualTo(immutableArrayOf("", "one", "two").hashCode())
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

    @Test
    fun `mapIndexed validation`() {
        with(immutableArrayOf("aaa", "bb", "c")) {
            expectThat(this.mapIndexed { index, element -> Pair(index, element) })
                .isEqualTo(immutableArrayOf(Pair(0, "aaa"), Pair(1, "bb"), Pair(2, "c")))

            expectThat(this.mapIndexed { index, element -> element.length + 2 * index })
                .isEqualTo(immutableArrayOf(3, 4, 5))
        }
    }

    @Test
    fun `builder add validation`() {
        val builder = ImmutableArray.Builder<String>()

        expectThat(builder.size)
            .isEqualTo(0)
        expectThat(builder.build())
            .isEqualTo(emptyImmutableArray())

        builder.add("one")

        expectThat(builder.size)
            .isEqualTo(1)
        expectThat(builder.build())
            .isEqualTo(immutableArrayOf("one"))

        builder.add("two")
        builder.add("three")

        expectThat(builder.size)
            .isEqualTo(3)
        expectThat(builder.build())
            .isEqualTo(immutableArrayOf("one", "two", "three"))
    }

    @Test
    fun `builder plusAssign validation`() {
        val builder = ImmutableArray.Builder<String>()

        expectThat(builder.size)
            .isEqualTo(0)
        expectThat(builder.build())
            .isEqualTo(emptyImmutableArray())

        builder += "one"

        expectThat(builder.size)
            .isEqualTo(1)
        expectThat(builder.build())
            .isEqualTo(immutableArrayOf("one"))

        builder += "two"

        expectThat(builder.size)
            .isEqualTo(2)
        expectThat(builder.build())
            .isEqualTo(immutableArrayOf("one", "two"))
    }

    @Test
    fun `builder resizing validation`() {
        val builder = ImmutableArray.Builder<String>(initialCapacity = 10)

        val numElementsToAdd = 100
        for (index in 0..<numElementsToAdd) {
            builder += index.toString()

            expectThat(builder.size)
                .isEqualTo(index + 1)
        }

        expectThat(builder.build())
            .isEqualTo(ImmutableArray(numElementsToAdd) { it.toString() })
    }

    @Test
    fun `builder addAll validation`() {
        val builder = ImmutableArray.Builder<String>(initialCapacity = 10)

        // Add all from array
        builder.addAll(arrayOf("0", "1", "2", "3", "4"))

        expectThat(builder.size)
            .isEqualTo(5)
        expectThat(builder.build())
            .isEqualTo(ImmutableArray(5) { it.toString() })

        // Add all from immutable array
        builder.addAll(immutableArrayOf("5", "6", "7", "8", "9", "10"))

        expectThat(builder.size)
            .isEqualTo(11)
        expectThat(builder.build())
            .isEqualTo(ImmutableArray(11) { it.toString() })

        // Add all from collection
        builder.addAll(listOf("11", "12", "13", "14"))

        expectThat(builder.size)
            .isEqualTo(15)
        expectThat(builder.build())
            .isEqualTo(ImmutableArray(15) { it.toString() })
    }
}

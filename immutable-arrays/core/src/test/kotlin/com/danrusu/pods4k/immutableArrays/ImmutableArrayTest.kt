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
            .containsExactly("element 0")

        // Cannot create with negative size
        expectThrows<NegativeArraySizeException> {
            ImmutableArray(-1) { "element $it" }
        }
    }

    @Test
    fun `copyFrom validation`() {
        with(arrayOf("one", "two", "three")) {
            expectThrows<ArrayIndexOutOfBoundsException> {
                ImmutableArray.copyFrom(source = this, startIndex = -1, size = 1)
            }

            expectThrows<ArrayIndexOutOfBoundsException> {
                ImmutableArray.copyFrom(source = this, startIndex = 3, size = 1)
            }

            expectThrows<ArrayIndexOutOfBoundsException> {
                ImmutableArray.copyFrom(source = this, startIndex = 1, size = 3)
            }

            expectThrows<ArrayIndexOutOfBoundsException> {
                ImmutableArray.copyFrom(source = this, startIndex = 0, size = 4)
            }

            expectThat(ImmutableArray.copyFrom(source = this, startIndex = 0, size = 0))
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(ImmutableArray.copyFrom(source = this, startIndex = 0, size = 1))
                .isEqualTo(immutableArrayOf("one"))

            expectThat(ImmutableArray.copyFrom(source = this, startIndex = 1, size = 2))
                .isEqualTo(immutableArrayOf("two", "three"))

            expectThat(ImmutableArray.copyFrom(source = this, startIndex = 0, size = 3))
                .isEqualTo(immutableArrayOf("one", "two", "three"))
        }
    }

    @Test
    fun `size validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(this).hasSize(0)
        }
        with(ImmutableArray(10) { "element $it" }) {
            expectThat(this).hasSize(10)
        }
    }

    @Test
    fun `lastIndex validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(this.lastIndex).isEqualTo(-1)
        }
        with(immutableArrayOf("one")) {
            expectThat(this.lastIndex).isEqualTo(0)
        }
        with(ImmutableArray(10) { "element $it" }) {
            expectThat(this.lastIndex).isEqualTo(9)
        }
    }

    @Test
    fun `indices validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.indices).isEqualTo(IntRange(start = 0, endInclusive = 2))
        }
    }

    @Test
    fun `toString validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(this.toString()).isEqualTo("[]")
        }
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.toString()).isEqualTo("[one, two, three]")
        }
    }

    @Test
    fun `joinToString validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(
                joinToString(
                    separator = "+",
                    prefix = "***",
                    postfix = "###",
                    limit = 2, // only the first 2 elements
                    truncated = "___",
                ) { element ->
                    element.replaceFirstChar { it.uppercaseChar() }
                },
            ).isEqualTo("***One+Two+___###")
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
    fun `referencesSameArrayAs validation`() {
        val arrayWithValues = immutableArrayOf("one", "two")
        val secondArrayWithSameValues = immutableArrayOf("one", "two")

        expectThat(arrayWithValues.referencesSameArrayAs(arrayWithValues))
            .isTrue()

        expectThat(arrayWithValues)
            .isEqualTo(secondArrayWithSameValues)

        expectThat(arrayWithValues.referencesSameArrayAs(secondArrayWithSameValues))
            .isFalse()
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
        expectThat(emptyImmutableArray<String>())
            .isA<ImmutableArray<String>>()
            .isEmpty()

        expectThat(immutableArrayOf("one", "two", "three"))
            .isA<ImmutableArray<String>>()
            .isNotEmpty()
    }

    @Test
    fun `get validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(get(0)).isEqualTo("one")
            expectThat(get(1)).isEqualTo("two")
            expectThat(get(2)).isEqualTo("three")

            expectThrows<ArrayIndexOutOfBoundsException> {
                get(3)
            }
        }
    }

    @Test
    fun `getOrNull validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.getOrNull(2)).isEqualTo("three")
            expectThat(this.getOrNull(3)).isNull()
        }
    }

    @Test
    fun `index operator validation`() {
        with(immutableArrayOf("one", "two", "three")) {
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
        val values = immutableArrayOf("one", "two", "three", "four", "five")
        with(values) {
            val (first) = this
            expectThat(first).isEqualTo("one")
        }
        with(values) {
            val (first, second) = this
            expectThat(first).isEqualTo("one")
            expectThat(second).isEqualTo("two")
        }
        with(values) {
            val (first, second, third) = this
            expectThat(first).isEqualTo("one")
            expectThat(second).isEqualTo("two")
            expectThat(third).isEqualTo("three")
        }
        with(values) {
            val (first, second, third, fourth) = this
            expectThat(first).isEqualTo("one")
            expectThat(second).isEqualTo("two")
            expectThat(third).isEqualTo("three")
            expectThat(fourth).isEqualTo("four")
        }
        with(values) {
            val (first, second, third, fourth, fifth) = this
            expectThat(first).isEqualTo("one")
            expectThat(second).isEqualTo("two")
            expectThat(third).isEqualTo("three")
            expectThat(fourth).isEqualTo("four")
            expectThat(fifth).isEqualTo("five")
        }
    }

    @Test
    fun `single validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                this.single()
            }.message.isEqualTo("Array has more than one element.")
        }
        with(immutableArrayOf("one")) {
            expectThat(this.single()).isEqualTo("one")
        }
    }

    @Test
    fun `single with predicate validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                this.single { it.contains("o") }
            }.message.isEqualTo("Array contains more than one matching element.")
        }
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.single { it.contains("wo") }).isEqualTo("two")
        }
    }

    @Test
    fun `singleOrNull validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.singleOrNull()).isNull()
        }
        with(immutableArrayOf("one")) {
            expectThat(this.singleOrNull()).isEqualTo("one")
        }
    }

    @Test
    fun `singleOrNull with predicate validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(
                this.singleOrNull { it.contains("o") },
            ).isNull()
        }
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.singleOrNull { it.contains("wo") }).isEqualTo("two")
        }
    }

    @Test
    fun `first validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.first()).isEqualTo("one")
        }
    }

    @Test
    fun `first with predicate validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(
                this.first { it.contains("t") },
            ).isEqualTo("two")
        }
    }

    @Test
    fun `firstOrNull validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(this.firstOrNull()).isNull()
        }
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.firstOrNull()).isEqualTo("one")
        }
    }

    @Test
    fun `firstOrNull with predicate validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(
                this.firstOrNull { it.contains("t") },
            ).isEqualTo("two")

            expectThat(
                this.firstOrNull { it.contains("z") },
            ).isNull()
        }
    }

    @Test
    fun `last validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.last()).isEqualTo("three")
        }
    }

    @Test
    fun `last with predicate validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(
                this.last { it.contains("t") },
            ).isEqualTo("three")
        }
    }

    @Test
    fun `lastOrNull with predicate validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(
                this.lastOrNull { it.contains("t") },
            ).isEqualTo("three")

            expectThat(
                this.lastOrNull { it.contains("z") },
            ).isNull()
        }
    }

    @Test
    fun `lastOrNull validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(this.lastOrNull()).isNull()
        }
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this.lastOrNull()).isEqualTo("three")
        }
    }

    @Test
    fun `random validation`() {
        expectThrows<NoSuchElementException> {
            emptyImmutableArray<String>().random()
        }.message.isEqualTo("Array is empty.")

        expectThat(immutableArrayOf("one").random())
            .isEqualTo("one")

        with(immutableArrayOf("one", "two", "three")) {
            expectThat(random(Random(seed = 0)))
                .isEqualTo("one")

            expectThat(random(Random(seed = 2)))
                .isEqualTo("two")
        }
    }

    @Test
    fun `randomOrNull validation`() {
        expectThat(emptyImmutableArray<String>().randomOrNull())
            .isEqualTo(null)

        expectThat(immutableArrayOf("one").randomOrNull())
            .isEqualTo("one")

        with(immutableArrayOf("one", "two", "three")) {
            expectThat(randomOrNull(Random(seed = 0)))
                .isEqualTo("one")

            expectThat(randomOrNull(Random(seed = 2)))
                .isEqualTo("two")
        }
    }

    @Test
    fun `iterator validation`() {
        with(immutableArrayOf("one", "two")) {
            val iterator = this.iterator()
            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo("one")

            expectThat(iterator.hasNext()).isTrue()
            expectThat(iterator.next()).isEqualTo("two")

            expectThat(iterator.hasNext()).isFalse()
        }

        // can iterate with a regular for-loop
        with(immutableArrayOf("one", "two", "three")) {
            val elements = mutableListOf<String>()
            for (element in this) {
                elements += element
            }
            expectThat(elements).isEqualTo(mutableListOf("one", "two", "three"))
        }
    }

    @Test
    fun `asIterable validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            val iterable = this.asIterable()
            expectThat(iterable).isA<Iterable<String>>()

            expectThat(iterable.toList()).isEqualTo(listOf("one", "two", "three"))
        }
    }

    @Test
    fun `withIndex validation`() {
        with(immutableArrayOf("one", "two")) {
            expectThat(this.withIndex().toList()).isEqualTo(
                listOf(IndexedValue(0, "one"), IndexedValue(1, "two")),
            )
        }
    }

    @Test
    fun `asSequence validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            val elementsFromSequence = this.asSequence().toList()
            expectThat(elementsFromSequence).isEqualTo(listOf("one", "two", "three"))
        }
    }

    @Test
    fun `toMutableArray validation`() {
        with(emptyImmutableArray<String>()) {
            val result = toMutableArray()

            expectThat(result)
                .isA<Array<String>>()

            expectThat(result.size)
                .isEqualTo(0)
        }

        with(immutableArrayOf("a", "b", "c")) {
            expectThat(toMutableArray())
                .isEqualTo(arrayOf("a", "b", "c"))
        }
    }

    @Test
    fun `toTypedMutableArray validation`() {
        with(emptyImmutableArray<String>()) {
            val result = toTypedMutableArray()

            expectThat(result)
                .isA<Array<String>>()

            expectThat(result.size)
                .isEqualTo(0)
        }

        with(immutableArrayOf("a", "b", "c")) {
            expectThat(toTypedMutableArray())
                .isEqualTo(arrayOf("a", "b", "c"))
        }
    }

    @Test
    fun `can use spread operator with toMutableArray and toTypedMutableArray`() {
        fun inspectNames(vararg names: String) {
            expectThat(names.size)
                .isEqualTo(2)

            expectThat(names[0])
                .isEqualTo("Dan")

            expectThat(names[1])
                .isEqualTo("Jill")
        }

        val names = immutableArrayOf("Dan", "Jill")
        inspectNames(*names.toMutableArray())
        inspectNames(*names.toTypedMutableArray())
    }

    @Test
    fun `forEach validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            val elements = mutableListOf<String>()
            this.forEach { element ->
                elements += element
            }
            expectThat(elements).isEqualTo(mutableListOf("one", "two", "three"))
        }
    }

    @Test
    fun `forEachIndexed validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            val elements = mutableMapOf<Int, String>()
            this.forEachIndexed { index, element ->
                elements[index] = element
            }
            expectThat(elements).isEqualTo(
                mutableMapOf(
                    0 to "one",
                    1 to "two",
                    2 to "three",
                ),
            )
        }
    }

    @Test
    fun `all validation`() {
        with(immutableArrayOf("one", "two", "four")) {
            expectThat(all { it.contains('o') })
                .isTrue()

            expectThat(all { it.length == 3 })
                .isFalse()
        }
    }

    @Test
    fun `any validation`() {
        with(immutableArrayOf("one", "two", "four")) {
            expectThat(any { it.contains('w') })
                .isTrue()

            expectThat(any { it.length == 1 })
                .isFalse()
        }
    }

    @Test
    fun `none validation`() {
        with(immutableArrayOf("one", "two", "four")) {
            expectThat(none { it.contains('x') })
                .isTrue()

            expectThat(none { it.length == 4 })
                .isFalse()
        }
    }

    @Test
    fun `count validation`() {
        with(immutableArrayOf("one", "two", "four")) {
            expectThat(count { it.length == 3 })
                .isEqualTo(2)
        }
    }

    @Test
    fun `indexOfFirst validation`() {
        with(immutableArrayOf("a", "bb", "ccc", "ddd")) {
            expectThat(indexOfFirst { it.length == 3 })
                .isEqualTo(2)

            expectThat(indexOfFirst { it.length == 5 })
                .isEqualTo(-1)
        }
    }

    @Test
    fun `indexOfLast validation`() {
        with(immutableArrayOf("a", "bb", "ccc", "ddd")) {
            expectThat(indexOfLast { it.length == 3 })
                .isEqualTo(3)

            expectThat(indexOfLast { it.length == 5 })
                .isEqualTo(-1)
        }
    }

    @Test
    fun `sumOf validation`() {
        with(immutableArrayOf("1", "2", "3")) {
            expectThat(sumOf { it.toInt() })
                .isA<Int>()
                .isEqualTo(6)

            expectThat(sumOf { it.toLong() })
                .isA<Long>()
                .isEqualTo(6L)

            expectThat(sumOf { it.toFloat() })
                .isA<Float>()
                .isEqualTo(6.0f)

            expectThat(sumOf { it.toDouble() })
                .isA<Double>()
                .isEqualTo(6.0)
        }
    }

    @Test
    fun `take validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(take(0))
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(take(10))
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                take(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(take(0))
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(take(1))
                .isEqualTo(immutableArrayOf("one"))

            expectThat(take(2))
                .isEqualTo(immutableArrayOf("one", "two"))

            expectThat(take(3).referencesSameArrayAs(this))
                .isTrue()

            expectThat(take(10).referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `takeWhile validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(takeWhile { true })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(takeWhile { false })
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("a", "bb", "ccc", "d")) {
            expectThat(takeWhile { it.length >= 2 })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(takeWhile { it.length <= 2 })
                .isEqualTo(immutableArrayOf("a", "bb"))

            expectThat(takeWhile { it.length <= 3 }.referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `takeLast validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(takeLast(0))
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(takeLast(10))
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                takeLast(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(takeLast(0))
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(takeLast(1))
                .isEqualTo(immutableArrayOf("three"))

            expectThat(takeLast(2))
                .isEqualTo(immutableArrayOf("two", "three"))

            expectThat(takeLast(3).referencesSameArrayAs(this))
                .isTrue()

            expectThat(takeLast(10).referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `takeLastWhile validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(takeLastWhile { true })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(takeLastWhile { false })
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("aaaa", "bbb", "cc", "d")) {
            expectThat(takeLastWhile { it.isEmpty() })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(takeLastWhile { it.length <= 2 })
                .isEqualTo(immutableArrayOf("cc", "d"))

            expectThat(takeLastWhile { it.length <= 4 }.referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `drop validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(drop(0))
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(drop(10))
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                drop(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(drop(0).referencesSameArrayAs(this))
                .isTrue()

            expectThat(drop(1))
                .isEqualTo(immutableArrayOf("two", "three"))

            expectThat(drop(2))
                .isEqualTo(immutableArrayOf("three"))

            expectThat(drop(3))
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(drop(10))
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }
    }

    @Test
    fun `dropWhile validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(dropWhile { true })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(dropWhile { false })
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("a", "bb", "ccc", "d")) {
            expectThat(dropWhile { it.length <= 3 })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(dropWhile { it.length <= 2 })
                .isEqualTo(immutableArrayOf("ccc", "d"))

            expectThat(dropWhile { it.isEmpty() }.referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `dropLast validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(dropLast(0))
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(dropLast(10))
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                dropLast(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(dropLast(0).referencesSameArrayAs(this))
                .isTrue()

            expectThat(dropLast(1))
                .isEqualTo(immutableArrayOf("one", "two"))

            expectThat(dropLast(2))
                .isEqualTo(immutableArrayOf("one"))

            expectThat(dropLast(3))
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(dropLast(10))
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }
    }

    @Test
    fun `dropLastWhile validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(dropLastWhile { true })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(dropLastWhile { false })
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("a", "bb", "ccc", "d")) {
            expectThat(dropLastWhile { it.length <= 3 })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(dropLastWhile { it.length <= 2 })
                .isEqualTo(immutableArrayOf("a", "bb", "ccc"))

            expectThat(dropLastWhile { it.isEmpty() }.referencesSameArrayAs(this))
                .isTrue()
        }
    }

    @Test
    fun `filter validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(filter { it.length % 2 == 0 })
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("a", "bb", "ccc", "dddd")) {
            expectThat(filter { it.length % 2 == 0 })
                .isEqualTo(immutableArrayOf("bb", "dddd"))

            expectThat(filter { it.isNotEmpty() }.referencesSameArrayAs(this))
                .isTrue()
        }

        // fuzz testing ensuring that the behavior matches regular arrays since the implementation is complex
        repeat(100) {
            val size = Random.nextInt(from = 0, until = 200)
            val randomValues = Array(size) { Random.nextInt() }

            expectThat(randomValues.toImmutableArray<Int>().filter { it % 2 == 0 }.asList())
                .isEqualTo(randomValues.filter { it % 2 == 0 })
        }
    }

    @Test
    fun `filterIndexed validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(filterIndexed { index, element -> element.length == index })
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("a", "b", "c", "ddd")) {
            expectThat(filterIndexed { index, element -> element.length == index })
                .isEqualTo(immutableArrayOf("b", "ddd"))

            expectThat(
                filterIndexed { index, element -> index >= 0 || element.isNotEmpty() }
                    .referencesSameArrayAs(this),
            ).isTrue()
        }

        // fuzz testing ensuring that the behavior matches regular arrays since the implementation is complex
        repeat(100) {
            val size = Random.nextInt(from = 0, until = 200)
            val randomValues = Array(size) { Random.nextInt() }

            expectThat(
                randomValues.toImmutableArray<Int>().filterIndexed { index, value ->
                    (index + value) % 2 == 0
                }.asList(),
            ).isEqualTo(randomValues.filterIndexed { index, value -> (index + value) % 2 == 0 })
        }
    }

    @Test
    fun `filterNot validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(filterNot { it.length % 2 == 0 })
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(immutableArrayOf("a", "bb", "ccc", "dddd")) {
            expectThat(filterNot { it.length % 2 == 0 })
                .isEqualTo(immutableArrayOf("a", "ccc"))

            expectThat(filterNot { it.isEmpty() }.referencesSameArrayAs(this))
                .isTrue()
        }

        // fuzz testing ensuring that the behavior matches regular arrays since the implementation is complex
        repeat(100) {
            val size = Random.nextInt(from = 0, until = 200)
            val randomValues = Array(size) { Random.nextInt() }

            expectThat(randomValues.toImmutableArray<Int>().filterNot { it % 2 == 0 }.asList())
                .isEqualTo(randomValues.filterNot { it % 2 == 0 })
        }
    }

    @Test
    fun `partition validation`() {
        with(emptyImmutableArray<String>().partition { it.length % 2 == 0 }) {
            expectThat(this)
                .isA<Pair<ImmutableArray<String>, ImmutableArray<String>>>()

            expectThat(first)
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(second)
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        expectThat(immutableArrayOf("a", "bb", "ccc", "dddd").partition { it.length % 2 == 0 })
            .isEqualTo(
                Pair(
                    immutableArrayOf("bb", "dddd"),
                    immutableArrayOf("a", "ccc"),
                ),
            )

        with(immutableArrayOf("a", "bb", "ccc", "dddd")) {
            val pair = this.partition { it.isEmpty() }

            expectThat(pair)
                .isA<Pair<ImmutableArray<String>, ImmutableArray<String>>>()

            expectThat(pair.first)
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(pair.second.referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf("a", "bb", "ccc", "dddd")) {
            var pair = partition { it.isNotEmpty() }

            expectThat(pair)
                .isA<Pair<ImmutableArray<String>, ImmutableArray<String>>>()

            expectThat(pair.first.referencesSameArrayAs(this))
                .isTrue()

            expectThat(pair.second)
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }
    }

    @Test
    fun `minBy validation`() {
        with(emptyImmutableArray<String>()) {
            expectThrows<NoSuchElementException> { minBy { it.length } }
        }

        with(immutableArrayOf("a")) {
            expectThat(minBy { it.length })
                .isEqualTo("a")
        }

        with(immutableArrayOf("aa", "b", "c")) {
            expectThat(minBy { it.length })
                .isEqualTo("b")
        }
    }

    @Test
    fun `minByOrNull validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(minByOrNull { it.length }).isNull()
        }

        with(immutableArrayOf("a")) {
            expectThat(minByOrNull { it.length })
                .isEqualTo("a")
        }

        with(immutableArrayOf("aa", "b", "c")) {
            expectThat(minByOrNull { it.length })
                .isEqualTo("b")
        }
    }

    @Test
    fun `maxBy validation`() {
        with(emptyImmutableArray<String>()) {
            expectThrows<NoSuchElementException> { maxBy { it.length } }
        }

        with(immutableArrayOf("a")) {
            expectThat(maxBy { it.length })
                .isEqualTo("a")
        }

        with(immutableArrayOf("a", "bb", "cc")) {
            expectThat(maxBy { it.length })
                .isEqualTo("bb")
        }
    }

    @Test
    fun `maxByOrNull validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(maxByOrNull { it.length }).isNull()
        }

        with(immutableArrayOf("a")) {
            expectThat(maxByOrNull { it.length })
                .isEqualTo("a")
        }

        with(immutableArrayOf("a", "bb", "cc")) {
            expectThat(maxByOrNull { it.length })
                .isEqualTo("bb")
        }
    }

    @Test
    fun `sortedBy validation`() {
        with(immutableArrayOf("one")) {
            expectThat(sortedBy { it.length }.referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf("apples", "pineapples", "dogs")) {
            expectThat(sortedBy { it.length })
                .isEqualTo(immutableArrayOf("dogs", "apples", "pineapples"))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf("apples", "pineapples", "dogs"))
        }
    }

    @Test
    fun `sortedByDescending validation`() {
        with(immutableArrayOf("one")) {
            expectThat(sortedByDescending { it.length }.referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf("apples", "pineapples", "dogs")) {
            expectThat(sortedByDescending { it.length })
                .isEqualTo(immutableArrayOf("pineapples", "apples", "dogs"))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf("apples", "pineapples", "dogs"))
        }
    }

    @Test
    fun `sortedWith validation`() {
        with(immutableArrayOf("one")) {
            val comparator = Comparator<String> { o1, o2 -> o1.compareTo(o2) }

            expectThat(sortedWith(comparator).referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf("dogs", "apples", "pineapples")) {
            val comparator = Comparator<String> { o1, o2 -> o1.compareTo(o2) }

            expectThat(sortedWith(comparator))
                .isEqualTo(immutableArrayOf("apples", "dogs", "pineapples"))

            expectThat(sortedWith(comparator.reversed()))
                .isEqualTo(immutableArrayOf("pineapples", "dogs", "apples"))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf("dogs", "apples", "pineapples"))
        }
    }

    @Test
    fun `shuffled validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(shuffled().referencesSameArrayAs(ImmutableArray.EMPTY))
                .isTrue()

            expectThat(shuffled(Random).referencesSameArrayAs(ImmutableArray.EMPTY))
                .isTrue()
        }

        with(immutableArrayOf("one")) {
            expectThat(shuffled().referencesSameArrayAs(this))
                .isTrue()

            expectThat(shuffled(Random).referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf("a", "b", "c")) {
            expectThat(shuffled(Random(seed = 0L)))
                .isEqualTo(immutableArrayOf("b", "c", "a"))

            expectThat(this)
                .isEqualTo(immutableArrayOf("a", "b", "c"))
        }
    }

    @Test
    fun `distinct validation`() {
        expectThat(emptyImmutableArray<String>().distinct())
            .isA<ImmutableArray<String>>()
            .isEmpty()

        with(immutableArrayOf("one", "two")) {
            expectThat(distinct().referencesSameArrayAs(this))
                .isTrue()
        }

        expectThat(immutableArrayOf("one", "one", "two", "three", "three").distinct())
            .isEqualTo(immutableArrayOf("one", "two", "three"))
    }

    @Test
    fun `distinctBy validation`() {
        expectThat(emptyImmutableArray<String>().distinctBy { it.length })
            .isA<ImmutableArray<String>>()
            .isEmpty()

        with(immutableArrayOf("a", "bb")) {
            expectThat(distinctBy { it.length }.referencesSameArrayAs(this))
                .isTrue()
        }

        expectThat(immutableArrayOf("one", "two", "three").distinctBy { it.length })
            .isEqualTo(immutableArrayOf("one", "three"))
    }

    @Test
    fun `builder add validation`() {
        val builder = ImmutableArray.Builder<String>()

        expectThat(builder.size)
            .isEqualTo(0)
        expectThat(builder.build())
            .isA<ImmutableArray<String>>()
            .isEmpty()

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
            .isA<ImmutableArray<String>>()
            .isEmpty()

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

        // Add all from sequence
        builder.addAll((15..19).asSequence().map { "$it" })

        expectThat(builder.size)
            .isEqualTo(20)
        expectThat(builder.build())
            .isEqualTo(ImmutableArray(20) { it.toString() })
    }
}

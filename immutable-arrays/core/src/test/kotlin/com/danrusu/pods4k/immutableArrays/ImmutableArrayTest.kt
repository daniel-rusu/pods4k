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
        with(emptyImmutableArray<String>()) {
            expectThat(this).isEmpty()
        }
        with(immutableArrayOf("one", "two", "three")) {
            expectThat(this).isNotEmpty()
        }
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
                .isEqualTo(emptyImmutableArray())

            expectThat(take(10))
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                take(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(take(0))
                .isEqualTo(emptyImmutableArray())

            expectThat(take(1))
                .isEqualTo(immutableArrayOf("one"))

            expectThat(take(2))
                .isEqualTo(immutableArrayOf("one", "two"))

            expectThat(take(3))
                .isEqualTo(immutableArrayOf("one", "two", "three"))

            expectThat(take(10))
                .isEqualTo(immutableArrayOf("one", "two", "three"))
        }
    }

    @Test
    fun `takeWhile validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(takeWhile { true })
                .isEqualTo(emptyImmutableArray())

            expectThat(takeWhile { false })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("a", "bb", "ccc", "d")) {
            expectThat(takeWhile { it.length >= 2 })
                .isEqualTo(emptyImmutableArray())

            expectThat(takeWhile { it.length <= 2 })
                .isEqualTo(immutableArrayOf("a", "bb"))

            expectThat(takeWhile { it.length <= 3 })
                .isEqualTo(immutableArrayOf("a", "bb", "ccc", "d"))
        }
    }

    @Test
    fun `takeLast validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(takeLast(0))
                .isEqualTo(emptyImmutableArray())

            expectThat(takeLast(10))
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                takeLast(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(takeLast(0))
                .isEqualTo(emptyImmutableArray())

            expectThat(takeLast(1))
                .isEqualTo(immutableArrayOf("three"))

            expectThat(takeLast(2))
                .isEqualTo(immutableArrayOf("two", "three"))

            expectThat(takeLast(3))
                .isEqualTo(immutableArrayOf("one", "two", "three"))

            expectThat(takeLast(10))
                .isEqualTo(immutableArrayOf("one", "two", "three"))
        }
    }

    @Test
    fun `takeLastWhile validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(takeLastWhile { true })
                .isEqualTo(emptyImmutableArray())

            expectThat(takeLastWhile { false })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("aaaa", "bbb", "cc", "d")) {
            expectThat(takeLastWhile { it.isEmpty() })
                .isEqualTo(emptyImmutableArray())

            expectThat(takeLastWhile { it.length <= 2 })
                .isEqualTo(immutableArrayOf("cc", "d"))

            expectThat(takeLastWhile { it.length <= 4 })
                .isEqualTo(immutableArrayOf("aaaa", "bbb", "cc", "d"))
        }
    }

    @Test
    fun `drop validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(drop(0))
                .isEqualTo(emptyImmutableArray())

            expectThat(drop(10))
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                drop(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(drop(0))
                .isEqualTo(immutableArrayOf("one", "two", "three"))

            expectThat(drop(1))
                .isEqualTo(immutableArrayOf("two", "three"))

            expectThat(drop(2))
                .isEqualTo(immutableArrayOf("three"))

            expectThat(drop(3))
                .isEqualTo(emptyImmutableArray())

            expectThat(drop(10))
                .isEqualTo(emptyImmutableArray())
        }
    }

    @Test
    fun `dropWhile validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(dropWhile { true })
                .isEqualTo(emptyImmutableArray())

            expectThat(dropWhile { false })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("a", "bb", "ccc", "d")) {
            expectThat(dropWhile { it.length <= 3 })
                .isEqualTo(emptyImmutableArray())

            expectThat(dropWhile { it.length <= 2 })
                .isEqualTo(immutableArrayOf("ccc", "d"))

            expectThat(dropWhile { it.isEmpty() })
                .isEqualTo(immutableArrayOf("a", "bb", "ccc", "d"))
        }
    }

    @Test
    fun `dropLast validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(dropLast(0))
                .isEqualTo(emptyImmutableArray())

            expectThat(dropLast(10))
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("one", "two", "three")) {
            expectThrows<IllegalArgumentException> {
                dropLast(-1)
            }.message.isEqualTo("Requested element count -1 is less than zero.")

            expectThat(dropLast(0))
                .isEqualTo(immutableArrayOf("one", "two", "three"))

            expectThat(dropLast(1))
                .isEqualTo(immutableArrayOf("one", "two"))

            expectThat(dropLast(2))
                .isEqualTo(immutableArrayOf("one"))

            expectThat(dropLast(3))
                .isEqualTo(emptyImmutableArray())

            expectThat(dropLast(10))
                .isEqualTo(emptyImmutableArray())
        }
    }

    @Test
    fun `dropLastWhile validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(dropLastWhile { true })
                .isEqualTo(emptyImmutableArray())

            expectThat(dropLastWhile { false })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("a", "bb", "ccc", "d")) {
            expectThat(dropLastWhile { it.length <= 3 })
                .isEqualTo(emptyImmutableArray())

            expectThat(dropLastWhile { it.length <= 2 })
                .isEqualTo(immutableArrayOf("a", "bb", "ccc"))

            expectThat(dropLastWhile { it.isEmpty() })
                .isEqualTo(immutableArrayOf("a", "bb", "ccc", "d"))
        }
    }

    @Test
    fun `filter validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(filter { it.length % 2 == 0 })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("a", "bb", "ccc", "dddd")) {
            expectThat(filter { it.length % 2 == 0 })
                .isEqualTo(immutableArrayOf("bb", "dddd"))

            expectThat(filter { it.isNotEmpty() })
                .isEqualTo(this)
        }
    }

    @Test
    fun `filterIndexed validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(filterIndexed { index, element -> element.length == index })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("a", "b", "c", "ddd")) {
            expectThat(filterIndexed { index, element -> element.length == index })
                .isEqualTo(immutableArrayOf("b", "ddd"))

            expectThat(filterIndexed { index, element -> index >= 0 || element.isNotEmpty() })
                .isEqualTo(this)
        }
    }

    @Test
    fun `filterNot validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(filterNot { it.length % 2 == 0 })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("a", "bb", "ccc", "dddd")) {
            expectThat(filterNot { it.length % 2 == 0 })
                .isEqualTo(immutableArrayOf("a", "ccc"))

            expectThat(filterNot { it.isEmpty() })
                .isEqualTo(this)
        }
    }

    @Test
    fun `partition validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(partition { it.length % 2 == 0 })
                .isEqualTo(Pair(emptyImmutableArray(), emptyImmutableArray()))
        }

        with(immutableArrayOf("a", "bb", "ccc", "dddd")) {
            expectThat(partition { it.length % 2 == 0 })
                .isEqualTo(Pair(immutableArrayOf("bb", "dddd"), immutableArrayOf("a", "ccc")))

            expectThat(partition { it.isEmpty() })
                .isEqualTo(Pair(emptyImmutableArray(), this))

            expectThat(partition { it.isNotEmpty() })
                .isEqualTo(Pair(this, emptyImmutableArray()))
        }
    }

    @Test
    fun `sortedBy validation`() {
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
    fun `distinct validation`() {
        expectThat(emptyImmutableArray<String>().distinct())
            .isEqualTo(emptyImmutableArray())

        expectThat(immutableArrayOf("one", "one", "two", "three", "three").distinct())
            .isEqualTo(immutableArrayOf("one", "two", "three"))
    }

    @Test
    fun `distinctBy validation`() {
        expectThat(emptyImmutableArray<String>().distinctBy { it.length })
            .isEqualTo(emptyImmutableArray())

        expectThat(immutableArrayOf("one", "two", "three").distinctBy { it.length })
            .isEqualTo(immutableArrayOf("one", "three"))
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

        // Add all from sequence
        builder.addAll((15..19).asSequence().map { "$it" })

        expectThat(builder.size)
            .isEqualTo(20)
        expectThat(builder.build())
            .isEqualTo(ImmutableArray(20) { it.toString() })
    }
}

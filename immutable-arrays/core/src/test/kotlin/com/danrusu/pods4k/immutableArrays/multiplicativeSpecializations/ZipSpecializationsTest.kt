package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableCharArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableDoubleArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ZipSpecializationsTest {
    @Test
    fun `zip generic with generic validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(
                zip(emptyImmutableArray<String>()),
            ).isEqualTo(emptyImmutableArray<Pair<String, String>>())

            expectThat(
                zip(immutableArrayOf("one", "two")),
            ).isEqualTo(emptyImmutableArray<Pair<String, String>>())
        }
        with(immutableArrayOf("one", "two")) {
            expectThat(
                zip(emptyImmutableArray<String>()),
            ).isEqualTo(emptyImmutableArray<Pair<String, String>>())

            expectThat(
                zip(immutableArrayOf("1")),
            ).isEqualTo(immutableArrayOf(Pair("one", "1")))

            expectThat(
                zip(immutableArrayOf("1", "2", "3")),
            ).isEqualTo(
                immutableArrayOf(
                    Pair("one", "1"),
                    Pair("two", "2"),
                ),
            )
        }
    }

    @Test
    fun `zip generic with primitive validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(
                zip(emptyImmutableIntArray()),
            ).isEqualTo(emptyImmutableArray<Pair<String, Int>>())

            expectThat(
                zip(immutableArrayOf(1, 2)),
            ).isEqualTo(emptyImmutableArray<Pair<String, Int>>())
        }
        with(immutableArrayOf("one", "two")) {
            expectThat(
                zip(emptyImmutableIntArray()),
            ).isEqualTo(emptyImmutableArray<Pair<String, Int>>())

            expectThat(
                zip(immutableArrayOf(1)),
            ).isEqualTo(immutableArrayOf(Pair("one", 1)))

            expectThat(
                zip(immutableArrayOf(1, 2, 3)),
            ).isEqualTo(
                immutableArrayOf(
                    Pair("one", 1),
                    Pair("two", 2),
                ),
            )
        }
    }

    @Test
    fun `zip primitive with generic validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(
                zip(emptyImmutableArray<String>()),
            ).isEqualTo(emptyImmutableArray<Pair<Int, String>>())

            expectThat(
                zip(immutableArrayOf("one", "two")),
            ).isEqualTo(emptyImmutableArray<Pair<Int, String>>())
        }
        with(immutableArrayOf(1, 2)) {
            expectThat(
                zip(emptyImmutableArray<String>()),
            ).isEqualTo(emptyImmutableArray<Pair<Int, String>>())

            expectThat(
                zip(immutableArrayOf("1")),
            ).isEqualTo(immutableArrayOf(Pair(1, "1")))

            expectThat(
                zip(immutableArrayOf("1", "2", "3")),
            ).isEqualTo(
                immutableArrayOf(
                    Pair(1, "1"),
                    Pair(2, "2"),
                ),
            )
        }
    }

    @Test
    fun `zip primitive with primitive validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(
                zip(emptyImmutableCharArray()),
            ).isEqualTo(emptyImmutableArray<Pair<Int, Char>>())

            expectThat(
                zip(immutableArrayOf('a', 'b')),
            ).isEqualTo(emptyImmutableArray<Pair<Int, Char>>())
        }
        with(immutableArrayOf(1, 2)) {
            expectThat(
                zip(emptyImmutableCharArray()),
            ).isEqualTo(emptyImmutableArray<Pair<Int, Char>>())

            expectThat(
                zip(immutableArrayOf('a')),
            ).isEqualTo(immutableArrayOf(Pair(1, 'a')))

            expectThat(
                zip(immutableArrayOf('a', 'b', 'c')),
            ).isEqualTo(
                immutableArrayOf(
                    Pair(1, 'a'),
                    Pair(2, 'b'),
                ),
            )
        }
    }

    @Test
    fun `zip transforming generic to generic validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(
                zip(emptyImmutableArray()) { a, b -> "$a:$b" },
            ).isEqualTo(emptyImmutableArray())

            expectThat(
                zip(immutableArrayOf("one", "two")) { a, b -> "$a:$b" },
            ).isEqualTo(emptyImmutableArray())
        }
        with(immutableArrayOf("one", "two")) {
            expectThat(
                zip(emptyImmutableArray()) { a, b -> "$a:$b" },
            ).isEqualTo(emptyImmutableArray())

            expectThat(
                zip(immutableArrayOf("1")) { a, b -> "$a:$b" },
            ).isEqualTo(immutableArrayOf("one:1"))

            expectThat(
                zip(immutableArrayOf("1", "2", "3")) { a, b -> "$a:$b" },
            ).isEqualTo(immutableArrayOf("one:1", "two:2"))
        }
    }

    @Test
    fun `zip transforming generic to primitive validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(
                zip(emptyImmutableArray()) { a, b -> a.length + b.length },
            ).isEqualTo(emptyImmutableIntArray())

            expectThat(
                zip(immutableArrayOf("a", "bb")) { a, b -> a.length + b.length },
            ).isEqualTo(emptyImmutableIntArray())
        }
        with(immutableArrayOf("a", "bb")) {
            expectThat(
                zip(emptyImmutableArray()) { a, b -> a.length + b.length },
            ).isEqualTo(emptyImmutableIntArray())

            expectThat(
                zip(immutableArrayOf("a1")) { a, b -> a.length + b.length },
            ).isEqualTo(immutableArrayOf(3))

            expectThat(
                zip(immutableArrayOf("a1", "bb2", "ccc3")) { a, b -> a.length + b.length },
            ).isEqualTo(immutableArrayOf(3, 5))
        }
    }

    @Test
    fun `zip transforming primitive to generic validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(
                zip(emptyImmutableIntArray()) { a, b -> "$a:$b" },
            ).isEqualTo(emptyImmutableArray())

            expectThat(
                zip(immutableArrayOf(1, 2)) { a, b -> "$a:$b" },
            ).isEqualTo(emptyImmutableArray())
        }
        with(immutableArrayOf(1, 2)) {
            expectThat(
                zip(emptyImmutableIntArray()) { a, b -> "$a:$b" },
            ).isEqualTo(emptyImmutableArray())

            expectThat(
                zip(immutableArrayOf(3)) { a, b -> "$a:$b" },
            ).isEqualTo(immutableArrayOf("1:3"))

            expectThat(
                zip(immutableArrayOf(3, 4, 5)) { a, b -> "$a:$b" },
            ).isEqualTo(immutableArrayOf("1:3", "2:4"))
        }
    }

    @Test
    fun `zip transforming primitive to primitive validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(
                zip(emptyImmutableIntArray()) { a, b -> (a + b).toDouble() },
            ).isEqualTo(emptyImmutableDoubleArray())

            expectThat(
                zip(immutableArrayOf(1, 2)) { a, b -> (a + b).toDouble() },
            ).isEqualTo(emptyImmutableDoubleArray())
        }
        with(immutableArrayOf(1, 2)) {
            expectThat(
                zip(emptyImmutableIntArray()) { a, b -> (a + b).toDouble() },
            ).isEqualTo(emptyImmutableDoubleArray())

            expectThat(
                zip(immutableArrayOf(3)) { a, b -> (a + b).toDouble() },
            ).isEqualTo(immutableArrayOf(4.0))

            expectThat(
                zip(immutableArrayOf(3, 4, 5)) { a, b -> (a + b).toDouble() },
            ).isEqualTo(immutableArrayOf(4.0, 6.0))
        }
    }
}

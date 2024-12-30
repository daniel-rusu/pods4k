package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEmpty
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isTrue

class CollectionsTest {
    @Test
    fun `toImmutableArray validation`() {
        with(listOf<String>()) {
            expectThat(this.toImmutableArray())
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }
        with(listOf(1, 3)) {
            expectThat(this.toImmutableArray())
                .isA<ImmutableIntArray>()
                .isEqualTo(immutableArrayOf(1, 3))

            expectThat(this.toImmutableArray<Int>())
                .isA<ImmutableArray<Int>>()
                .isEqualTo(immutableArrayOf<Int>(1, 3))
        }
        with(IntRange(start = 3, endInclusive = 5)) {
            expectThat(this.toImmutableArray())
                .isA<ImmutableIntArray>()
                .isEqualTo(immutableArrayOf(3, 4, 5))

            expectThat(this.toImmutableArray<Int>())
                .isA<ImmutableArray<Int>>()
                .isEqualTo(immutableArrayOf<Int>(3, 4, 5))
        }
    }

    @Test
    fun `containsAll validation`() {
        with(listOf(1, 2.5, 3)) {
            expectThat(containsAll(immutableArrayOf(3, 1)))
                .isTrue()

            expectThat(containsAll(immutableArrayOf<Int>(3, 1)))
                .isTrue()

            expectThat(containsAll(immutableArrayOf(3, 4)))
                .isFalse()
        }
    }

    @Test
    fun `addAll validation`() {
        with(mutableListOf<String>()) {
            addAll(immutableArrayOf())
            expectThat(this)
                .isEmpty()

            addAll(immutableArrayOf("one", "two"))
            expectThat(this)
                .isEqualTo(mutableListOf("one", "two"))
        }

        with(mutableListOf<Int>()) {
            // with generic array
            addAll(immutableArrayOf<Int>(1, 2, 3))
            expectThat(this)
                .isEqualTo(mutableListOf(1, 2, 3))

            // with primitive array
            addAll(immutableArrayOf(4, 5, 6))
            expectThat(this)
                .isEqualTo(mutableListOf(1, 2, 3, 4, 5, 6))
        }

        // adding subclass types
        with(mutableListOf<Any>()) {
            addAll(immutableArrayOf("one", "two"))
            expectThat(this)
                .isEqualTo(mutableListOf("one", "two"))

            // primitive arrays are also allowed
            addAll(immutableArrayOf(1, 2, 3))

            expectThat(this)
                .isEqualTo(mutableListOf("one", "two", 1, 2, 3))
        }
    }

    @Test
    fun `removeAll validation`() {
        with(mutableListOf<String>()) {
            expectThat(removeAll(emptyImmutableArray()))
                .isFalse()

            expectThat(this)
                .isEmpty()
        }

        with(mutableListOf(1, 2, 3, 4, 5, 6.5)) {
            // with generic array
            expectThat(removeAll(immutableArrayOf<Int>(0, 1, 3)))
                .isTrue()

            expectThat(this)
                .isEqualTo(mutableListOf(2, 4, 5, 6.5))

            expectThat(removeAll(immutableArrayOf<Int>(10, 11)))
                .isFalse()

            // with primitive array
            expectThat(removeAll(immutableArrayOf(4, 5)))
                .isTrue()

            expectThat(this)
                .isEqualTo(mutableListOf(2, 6.5))

            expectThat(removeAll(immutableArrayOf(10, 11)))
                .isFalse()
        }
    }

    @Test
    fun `retainAll validation`() {
        with(mutableListOf<String>()) {
            expectThat(retainAll(emptyImmutableArray()))
                .isFalse()

            expectThat(this)
                .isEmpty()
        }

        with(mutableListOf<Number>(1, 2, 3, 4, 5, 6.5)) {
            // with generic array
            expectThat(retainAll(immutableArrayOf<Number>(-1, 0, 4, 5, 6.5)))
                .isTrue()

            expectThat(this)
                .isEqualTo(mutableListOf(4, 5, 6.5))

            expectThat(retainAll(immutableArrayOf<Int>(4, 5)))
                .isTrue()

            expectThat(this)
                .isEqualTo(mutableListOf(4, 5))

            expectThat(retainAll(immutableArrayOf<Int>(4, 5)))
                .isFalse()

            // with primitive array
            expectThat(retainAll(immutableArrayOf(4)))
                .isTrue()

            expectThat(this)
                .isEqualTo(mutableListOf(4))
        }
    }

    @Test
    fun `flatten validation`() {
        // iterable of generic arrays
        with(
            listOf(
                emptyImmutableArray<String>(),
                emptyImmutableArray<String>(),
            ),
        ) {
            expectThat(flatten())
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(
            listOf(
                immutableArrayOf("a", "b"),
                immutableArrayOf("c", "d", "e"),
                emptyImmutableArray<String>(),
            ),
        ) {
            expectThat(flatten())
                .isEqualTo(immutableArrayOf("a", "b", "c", "d", "e"))
        }

        // iterable of primitive arrays
        with(
            listOf(
                emptyImmutableIntArray(),
                emptyImmutableIntArray(),
            ),
        ) {
            expectThat(flatten())
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(
            listOf(
                immutableArrayOf(1, 2),
                immutableArrayOf(3, 4, 5),
                emptyImmutableIntArray(),
            ),
        ) {
            expectThat(flatten())
                .isEqualTo(immutableArrayOf(1, 2, 3, 4, 5))
        }
    }
}

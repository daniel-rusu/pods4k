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
                .isEqualTo(emptyImmutableArray())
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
}

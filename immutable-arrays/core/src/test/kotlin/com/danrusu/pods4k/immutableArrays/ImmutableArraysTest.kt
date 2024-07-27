package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class ImmutableArraysTest {
    @Test
    fun `generic ImmutableArray to primitive immutable array validation`() {
        with(immutableArrayOf<Int>(1, 3, 5)) {
            expectThat(this).isA<ImmutableArray<Int>>()

            val primitiveVersion = this.toImmutableIntArray()
            expectThat(primitiveVersion).isA<ImmutableIntArray>()
            expectThat(primitiveVersion).containsExactly(1, 3, 5)
        }
    }

    @Test
    fun `primitive immutable array to generic ImmutableArray validation`() {
        with(immutableArrayOf(1, 3, 5)) {
            expectThat(this).isA<ImmutableIntArray>()

            val genericVersion = this.toTypedImmutableArray()
            expectThat(genericVersion).isA<ImmutableArray<Int>>()
            expectThat(genericVersion).containsExactly(1, 3, 5)
        }
    }

    @Test
    fun `sorted validation`() {
        with(immutableArrayOf("dogs", "apples", "pineapples")) {
            expectThat(sorted())
                .isEqualTo(immutableArrayOf("apples", "dogs", "pineapples"))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf("dogs", "apples", "pineapples"))
        }

        with(immutableArrayOf(1, 2, 5, 4, 3)) {
            expectThat(sorted())
                .isEqualTo(immutableArrayOf(1, 2, 3, 4, 5))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf(1, 2, 5, 4, 3))
        }
    }

    @Test
    fun `sortedDescending validation`() {
        with(immutableArrayOf("dogs", "apples", "pineapples")) {
            expectThat(sortedDescending())
                .isEqualTo(immutableArrayOf("pineapples", "dogs", "apples"))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf("dogs", "apples", "pineapples"))
        }

        with(immutableArrayOf(1, 2, 5, 4, 3)) {
            expectThat(sortedDescending())
                .isEqualTo(immutableArrayOf(5, 4, 3, 2, 1))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf(1, 2, 5, 4, 3))
        }
    }

    @Test
    fun `plus immutableArray validation`() {
        expectThat(emptyImmutableArray<String>() + emptyImmutableArray())
            .isEqualTo(emptyImmutableArray())

        expectThat(emptyImmutableArray<String>() + immutableArrayOf("one", "two"))
            .isEqualTo(immutableArrayOf("one", "two"))

        expectThat(immutableArrayOf("a", "b", "c") + immutableArrayOf("d", "e"))
            .isEqualTo(immutableArrayOf("a", "b", "c", "d", "e"))

        expectThat(emptyImmutableIntArray() + emptyImmutableIntArray())
            .isEqualTo(emptyImmutableIntArray())

        expectThat(emptyImmutableIntArray() + immutableArrayOf(1, 2))
            .isEqualTo(immutableArrayOf(1, 2))

        expectThat(immutableArrayOf(1, 2, 3) + immutableArrayOf(4, 5))
            .isEqualTo(immutableArrayOf(1, 2, 3, 4, 5))
    }

    @Test
    fun `plus value validation`() {
        expectThat(emptyImmutableArray<String>() + "one")
            .isEqualTo(immutableArrayOf("one"))

        expectThat(immutableArrayOf("a", "b", "c") + "d")
            .isEqualTo(immutableArrayOf("a", "b", "c", "d"))

        expectThat(emptyImmutableIntArray() + 1)
            .isEqualTo(immutableArrayOf(1))

        expectThat(immutableArrayOf(1, 2, 3) + 4)
            .isEqualTo(immutableArrayOf(1, 2, 3, 4))
    }
}

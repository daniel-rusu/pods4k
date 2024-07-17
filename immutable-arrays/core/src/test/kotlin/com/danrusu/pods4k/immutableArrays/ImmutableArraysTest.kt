package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class ImmutableArraysTest {
    @Test
    fun `emptyImmutableArray validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(this).isA<ImmutableArray<String>>()
            expectThat(this).isEmpty()
        }
        with(emptyImmutableIntArray()) {
            expectThat(this).isA<ImmutableIntArray>()
            expectThat(this).isEmpty()
        }
    }

    @Test
    fun `immutableArrayOf validation`() {
        with(immutableArrayOf<String>()) {
            expectThat(this).isA<ImmutableArray<String>>()
            expectThat(this).isEmpty()
        }

        with(immutableArrayOf("one", "two")) {
            expectThat(this).isA<ImmutableArray<String>>()
            expectThat(this).containsExactly("one", "two")
        }

        with(immutableArrayOf(10, 20, 30)) {
            expectThat(this).isA<ImmutableIntArray>()
            expectThat(this).containsExactly(10, 20, 30)
        }
    }

    @Test
    fun `buildImmutableArray validation`() {
        val names = buildImmutableArray {
            add("Bob")
            add("Jill")
        }
        expectThat(names)
            .isEqualTo(immutableArrayOf("Bob", "Jill"))

        val numbers = buildImmutableIntArray {
            add(3)
            add(7)
            add(11)
        }

        expectThat(numbers)
            .isEqualTo(immutableArrayOf(3, 7, 11))
    }

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
}

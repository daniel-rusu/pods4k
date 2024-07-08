package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class ArraysTest {
    @Test
    fun `primitive array toImmutableArray validation`() {
        with(BooleanArray(0)) {
            val immutable = this.toImmutableArray()
            expectThat(immutable).isA<ImmutableBooleanArray>()

            expectThat(immutable).isEmpty()
        }
        with(intArrayOf(1, 3, 5)) {
            val immutable = this.toImmutableArray()
            expectThat(immutable).isA<ImmutableIntArray>()
            expectThat(immutable).containsExactly(1, 3, 5)
        }
    }

    @Test
    fun `generic array toImmutableArray validation`() {
        with(emptyArray<String>()) {
            expectThat(this.toImmutableArray())
                .isEqualTo(emptyImmutableArray())
        }
        with(arrayOf("one", "two")) {
            expectThat(this.toImmutableArray())
                .isEqualTo(immutableArrayOf("one", "two"))
        }
        with(emptyArray<Int>()) {
            expectThat(this.toImmutableArray())
                .isA<ImmutableIntArray>()
                .isEqualTo(emptyImmutableIntArray())

            expectThat(this.toImmutableArray<Int>())
                .isA<ImmutableArray<Int>>()
                .isEqualTo(emptyImmutableArray())
        }
        with(arrayOf(1, 3, 5)) {
            expectThat(this.toImmutableArray())
                .isA<ImmutableIntArray>()
                .isEqualTo(immutableArrayOf(1, 3, 5))

            expectThat(this.toImmutableArray<Int>())
                .isA<ImmutableArray<Int>>()
                .isEqualTo(immutableArrayOf<Int>(1, 3, 5))
        }
    }
}

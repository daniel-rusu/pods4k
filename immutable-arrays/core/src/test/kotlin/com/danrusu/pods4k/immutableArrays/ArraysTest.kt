package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class ArraysTest {
    @Test
    fun `primitive array toImmutableArray validation`() {
        expectThat(BooleanArray(0).toImmutableArray())
            .isA<ImmutableBooleanArray>()
            .isEmpty()

        expectThat(intArrayOf(1, 3, 5).toImmutableArray())
            .isEqualTo(immutableArrayOf(1, 3, 5))
    }

    @Test
    fun `generic array toImmutableArray validation`() {
        expectThat(emptyArray<String>().toImmutableArray())
            .isA<ImmutableArray<String>>()
            .isEmpty()

        expectThat(arrayOf("one", "two").toImmutableArray())
            .isEqualTo(immutableArrayOf("one", "two"))

        with(emptyArray<Int>()) {
            expectThat(this.toImmutableArray())
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(this.toImmutableArray<Int>())
                .isA<ImmutableArray<Int>>()
                .isEmpty()
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

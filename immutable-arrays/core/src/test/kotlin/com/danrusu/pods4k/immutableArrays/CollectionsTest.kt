package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEmpty
import strikt.assertions.isEqualTo

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
        val list = mutableListOf<String>()

        list.addAll(immutableArrayOf())
        expectThat(list)
            .isEmpty()

        list.addAll(immutableArrayOf("one", "two"))
        expectThat(list)
            .isEqualTo(mutableListOf("one", "two"))
    }
}

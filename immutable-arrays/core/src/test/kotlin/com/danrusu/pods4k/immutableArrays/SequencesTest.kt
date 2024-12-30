package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class SequencesTest {
    @Test
    fun `toImmutableArray validation`() {
        with(sequenceOf<String>()) {
            expectThat(this.toImmutableArray())
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

        with(sequenceOf<Int>()) {
            expectThat(this.toImmutableArray())
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(this.toImmutableArray<Int>())
                .isA<ImmutableArray<Int>>()
                .isEmpty()
        }

        with(sequenceOf(1, 3, 5)) {
            expectThat(this.toImmutableArray())
                .isA<ImmutableIntArray>()
                .isEqualTo(immutableArrayOf(1, 3, 5))

            expectThat(this.toImmutableArray<Int>())
                .isA<ImmutableArray<Int>>()
                .isEqualTo(immutableArrayOf<Int>(1, 3, 5))
        }
    }

    @Test
    fun `flatten validation`() {
        // sequence of generic arrays
        with(sequenceOf(immutableArrayOf("a", "bb"), immutableArrayOf("ccc", "dddd"))) {
            expectThat(flatten())
                .isA<Sequence<String>>()

            expectThat(flatten().toList())
                .isEqualTo(listOf("a", "bb", "ccc", "dddd"))
        }

        // sequence of primitive arrays
        with(sequenceOf(immutableArrayOf(1, 2), immutableArrayOf(3, 4))) {
            expectThat(flatten())
                .isA<Sequence<Int>>()

            expectThat(flatten().toList())
                .isEqualTo(listOf(1, 2, 3, 4))
        }
    }
}

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
            expectThat(immutable).hasSize(3)

            expectThat(immutable[0]).isEqualTo(1)
            expectThat(immutable[1]).isEqualTo(3)
            expectThat(immutable[2]).isEqualTo(5)
        }
    }

    @Test
    fun `generic array toImmutableArray validation`() {
        with(emptyArray<String>()) {
            val immutable = this.toImmutableArray()
            expectThat(immutable).isA<ImmutableArray<String>>()

            expectThat(immutable).isEmpty()
        }
        with(arrayOf("one", "two")) {
            val immutable = this.toImmutableArray()
            expectThat(immutable).isA<ImmutableArray<String>>()
            expectThat(immutable).hasSize(2)

            expectThat(immutable[0]).isEqualTo("one")
            expectThat(immutable[1]).isEqualTo("two")
        }
        with(emptyArray<Int>()) {
            val immutable = this.toImmutableIntArray()
            expectThat(immutable).isA<ImmutableIntArray>()
            expectThat(immutable).isEmpty()
        }
        with(arrayOf(1, 3, 5)) {
            val immutable = this.toImmutableIntArray()
            expectThat(immutable).isA<ImmutableIntArray>()
            expectThat(immutable).hasSize(3)

            expectThat(immutable[0]).isEqualTo(1)
            expectThat(immutable[1]).isEqualTo(3)
            expectThat(immutable[2]).isEqualTo(5)
        }
    }
}

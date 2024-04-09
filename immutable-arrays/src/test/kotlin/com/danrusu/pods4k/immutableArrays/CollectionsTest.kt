package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isTrue

class CollectionsTest {
    @Test
    fun `toImmutableArray validation`() {
        with(listOf<String>()) {
            val immutableArray = this.toImmutableArray()
            expectThat(immutableArray).isA<ImmutableArray<String>>()
            expectThat(immutableArray.isEmpty()).isTrue()
        }
        with(listOf(1, 3)) {
            val immutableArray = this.toImmutableArray()
            expectThat(immutableArray).isA<ImmutableArray<Int>>()
            expectThat(immutableArray.size).isEqualTo(2)
            expectThat(immutableArray[0]).isEqualTo(1)
            expectThat(immutableArray[1]).isEqualTo(3)

            val immutableIntArray = this.toImmutableIntArray()
            expectThat(immutableIntArray).isA<ImmutableIntArray>()
            expectThat(immutableIntArray.size).isEqualTo(2)
            expectThat(immutableIntArray[0]).isEqualTo(1)
            expectThat(immutableIntArray[1]).isEqualTo(3)
        }
        with(IntRange(start = 3, endInclusive = 5)) {
            val immutableArray = this.toImmutableArray()
            expectThat(immutableArray).isA<ImmutableArray<Int>>()
            expectThat(immutableArray.size).isEqualTo(3)
            expectThat(immutableArray[0]).isEqualTo(3)
            expectThat(immutableArray[1]).isEqualTo(4)
            expectThat(immutableArray[2]).isEqualTo(5)

            val immutableIntArray = this.toImmutableIntArray()
            expectThat(immutableIntArray).isA<ImmutableIntArray>()
            expectThat(immutableIntArray.size).isEqualTo(3)
            expectThat(immutableIntArray[0]).isEqualTo(3)
            expectThat(immutableIntArray[1]).isEqualTo(4)
            expectThat(immutableIntArray[2]).isEqualTo(5)
        }
    }
}

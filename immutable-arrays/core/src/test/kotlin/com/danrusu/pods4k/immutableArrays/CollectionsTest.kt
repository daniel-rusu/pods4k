package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.ImmutableIntArray
import com.danrusu.pods4k.immutableArrays.toImmutableArray
import com.danrusu.pods4k.immutableArrays.toImmutableIntArray
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA

class CollectionsTest {
    @Test
    fun `toImmutableArray validation`() {
        with(listOf<String>()) {
            val immutableArray = this.toImmutableArray()
            expectThat(immutableArray).isA<ImmutableArray<String>>()
            expectThat(immutableArray).isEmpty()
        }
        with(listOf(1, 3)) {
            val immutableArray = this.toImmutableArray()
            expectThat(immutableArray).isA<ImmutableArray<Int>>()
            expectThat(immutableArray).containsExactly(1, 3)

            val immutableIntArray = this.toImmutableIntArray()
            expectThat(immutableIntArray).isA<ImmutableIntArray>()
            expectThat(immutableIntArray).containsExactly(1, 3)
        }
        with(IntRange(start = 3, endInclusive = 5)) {
            val immutableArray = this.toImmutableArray()
            expectThat(immutableArray).isA<ImmutableArray<Int>>()
            expectThat(immutableArray).containsExactly(3, 4, 5)

            val immutableIntArray = this.toImmutableIntArray()
            expectThat(immutableIntArray).isA<ImmutableIntArray>()
            expectThat(immutableIntArray).containsExactly(3, 4, 5)
        }
    }
}

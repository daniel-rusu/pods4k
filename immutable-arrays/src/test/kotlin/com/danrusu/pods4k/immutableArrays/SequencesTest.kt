package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA

class SequencesTest {
    @Test
    fun `toImmutableArray validation`() {
        with(sequenceOf(1, 3, 5)) {
            val genericImmutableArray = this.toImmutableArray()
            expectThat(genericImmutableArray).isA<ImmutableArray<Int>>()
            expectThat(genericImmutableArray).containsExactly(1, 3, 5)

            val primitiveImmutableArray = this.toImmutableIntArray()
            expectThat(primitiveImmutableArray).isA<ImmutableIntArray>()
            expectThat(primitiveImmutableArray).containsExactly(1, 3, 5)
        }
    }
}

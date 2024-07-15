package com.danrusu.pods4k.immutableArrays.specializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class MapIndexedSpecializationsTest {
    @Test
    fun `generic to generic validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(mapIndexed { index, element -> "$index: $element" })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("Dan", "Jill")) {
            expectThat(mapIndexed { index, element -> "$index: $element" })
                .isEqualTo(immutableArrayOf("0: Dan", "1: Jill"))
        }
    }

    @Test
    fun `generic to primitive validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(mapIndexed { index, element -> index + element.length })
                .isEqualTo(emptyImmutableIntArray())
        }

        with(immutableArrayOf("a", "bb", "ccc")) {
            expectThat(mapIndexed { index, element -> index + element.length })
                .isEqualTo(immutableArrayOf(1, 3, 5))
        }
    }

    @Test
    fun `primitive to generic validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(mapIndexed { index, element -> "$index: $element" })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThat(mapIndexed { index, element -> "$index: $element" })
                .isEqualTo(immutableArrayOf("0: 1", "1: 2", "2: 3"))
        }
    }

    @Test
    fun `primitive to primitive validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(mapIndexed { index, element -> index + element })
                .isEqualTo(emptyImmutableIntArray())
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThat(mapIndexed { index, element -> index + element })
                .isEqualTo(immutableArrayOf(1, 3, 5))
        }
    }
}

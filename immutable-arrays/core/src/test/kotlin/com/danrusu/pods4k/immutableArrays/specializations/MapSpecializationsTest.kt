package com.danrusu.pods4k.immutableArrays.specializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class MapSpecializationsTest {
    @Test
    fun `generic to generic validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(map { it.reversed() })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf("Dan", "Jill")) {
            expectThat(map { it.reversed() })
                .isEqualTo(immutableArrayOf("naD", "lliJ"))
        }
    }

    @Test
    fun `generic to primitive validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(map { it.length })
                .isEqualTo(emptyImmutableIntArray())
        }

        with(immutableArrayOf("a", "bb", "ccc")) {
            expectThat(map { it.length })
                .isEqualTo(immutableArrayOf(1, 2, 3))
        }
    }

    @Test
    fun `primitive to generic validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(map { it.toString() })
                .isEqualTo(emptyImmutableArray())
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThat(map { it.toString() })
                .isEqualTo(immutableArrayOf("1", "2", "3"))
        }
    }

    @Test
    fun `primitive to primitive validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(map { 2 * it })
                .isEqualTo(emptyImmutableIntArray())
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThat(map { 2 * it })
                .isEqualTo(immutableArrayOf(2, 4, 6))
        }
    }
}

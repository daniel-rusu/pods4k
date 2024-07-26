package com.danrusu.pods4k.immutableArrays.specializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableDoubleArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FlatMapSpecializationsTest {
    @Test
    fun `generic to generic validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(flatMap<String, Char> { it.toList() })
                .isEqualTo(emptyImmutableArray<Char>())
        }

        with(immutableArrayOf("Dan", "Jill")) {
            expectThat(flatMap<String, Char> { it.toList() })
                .isEqualTo(immutableArrayOf<Char>('D', 'a', 'n', 'J', 'i', 'l', 'l'))
        }
    }

    @Test
    fun `generic to primitive validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(flatMap { element -> element.toCharArray().map { it.digitToInt() } })
                .isEqualTo(emptyImmutableIntArray())
        }

        with(immutableArrayOf("1", "22", "333")) {
            expectThat(flatMap { element -> element.toCharArray().map { it.digitToInt() } })
                .isEqualTo(immutableArrayOf(1, 2, 2, 3, 3, 3))
        }
    }

    @Test
    fun `primitive to generic validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(flatMap<Char> { it.toString().toList() })
                .isEqualTo(emptyImmutableArray<Char>())
        }

        with(immutableArrayOf(10, 2, 37)) {
            expectThat(flatMap<Char> { it.toString().toList() })
                .isEqualTo(immutableArrayOf<Char>('1', '0', '2', '3', '7'))
        }
    }

    @Test
    fun `primitive to primitive validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(flatMap { element -> DoubleArray(element) { it.toDouble() / element }.toList() })
                .isEqualTo(emptyImmutableDoubleArray())
        }

        with(immutableArrayOf(1, 2, 3)) {
            expectThat(flatMap { element -> DoubleArray(element) { it.toDouble() / element }.toList() })
                .isEqualTo(immutableArrayOf(0.0, 0.0, 1.0 / 2, 0.0, 1.0 / 3, 2.0 / 3))
        }
    }
}

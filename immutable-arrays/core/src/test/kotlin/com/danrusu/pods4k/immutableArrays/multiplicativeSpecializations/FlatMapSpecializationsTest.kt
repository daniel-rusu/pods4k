package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableDoubleArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import com.danrusu.pods4k.immutableArrays.toImmutableArray
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FlatMapSpecializationsTest {
    @Test
    fun `generic to generic validation`() {
        // iterable
        with(emptyImmutableArray<String>()) {
            // iterable
            expectThat(flatMap<String, Char> { it.toList() })
                .isEqualTo(emptyImmutableArray<Char>())

            // immutable array
            expectThat(flatMap { it.toList().toImmutableArray<Char>() })
                .isEqualTo(emptyImmutableArray<Char>())
        }

        with(immutableArrayOf("Dan", "Jill")) {
            // iterable
            expectThat(flatMap<String, Char> { it.toList() })
                .isEqualTo(immutableArrayOf<Char>('D', 'a', 'n', 'J', 'i', 'l', 'l'))

            // immutable array
            expectThat(flatMap { it.toList().toImmutableArray<Char>() })
                .isEqualTo(immutableArrayOf<Char>('D', 'a', 'n', 'J', 'i', 'l', 'l'))
        }
    }

    @Test
    fun `generic to primitive validation`() {
        with(emptyImmutableArray<String>()) {
            // iterable
            expectThat(
                flatMap { element ->
                    element.toCharArray().map { it.digitToInt() }
                },
            ).isEqualTo(emptyImmutableIntArray())

            // immutable array
            expectThat(
                flatMap { element ->
                    element.toCharArray().map { it.digitToInt() }.toImmutableArray()
                },
            ).isEqualTo(emptyImmutableIntArray())
        }

        with(immutableArrayOf("1", "22", "333")) {
            // iterable
            expectThat(
                flatMap { element ->
                    element.toCharArray().map { it.digitToInt() }
                },
            ).isEqualTo(immutableArrayOf(1, 2, 2, 3, 3, 3))

            // immutable array
            expectThat(
                flatMap { element ->
                    element.toCharArray().map { it.digitToInt() }.toImmutableArray()
                },
            ).isEqualTo(immutableArrayOf(1, 2, 2, 3, 3, 3))
        }
    }

    @Test
    fun `primitive to generic validation`() {
        with(emptyImmutableIntArray()) {
            // iterable
            expectThat(flatMap<Char> { it.toString().toList() })
                .isEqualTo(emptyImmutableArray<Char>())

            // immutable array
            expectThat(flatMap { it.toString().toList().toImmutableArray<Char>() })
                .isEqualTo(emptyImmutableArray<Char>())
        }

        with(immutableArrayOf(10, 2, 37)) {
            // iterable
            expectThat(flatMap<Char> { it.toString().toList() })
                .isEqualTo(immutableArrayOf<Char>('1', '0', '2', '3', '7'))

            // immutable array
            expectThat(flatMap { it.toString().toList().toImmutableArray<Char>() })
                .isEqualTo(immutableArrayOf<Char>('1', '0', '2', '3', '7'))
        }
    }

    @Test
    fun `primitive to primitive validation`() {
        with(emptyImmutableIntArray()) {
            // iterable
            expectThat(
                flatMap { element ->
                    DoubleArray(element) { it.toDouble() / element }.toList()
                },
            ).isEqualTo(emptyImmutableDoubleArray())

            // immutable array
            expectThat(
                flatMap { element ->
                    DoubleArray(element) { it.toDouble() / element }.toList().toImmutableArray()
                },
            ).isEqualTo(emptyImmutableDoubleArray())
        }

        with(immutableArrayOf(1, 2, 3)) {
            // iterable
            expectThat(
                flatMap { element ->
                    DoubleArray(element) { it.toDouble() / element }.toList()
                },
            ).isEqualTo(immutableArrayOf(0.0, 0.0, 1.0 / 2, 0.0, 1.0 / 3, 2.0 / 3))

            // immutable array
            expectThat(
                flatMap { element ->
                    DoubleArray(element) { it.toDouble() / element }.toList().toImmutableArray()
                },
            ).isEqualTo(immutableArrayOf(0.0, 0.0, 1.0 / 2, 0.0, 1.0 / 3, 2.0 / 3))
        }
    }
}

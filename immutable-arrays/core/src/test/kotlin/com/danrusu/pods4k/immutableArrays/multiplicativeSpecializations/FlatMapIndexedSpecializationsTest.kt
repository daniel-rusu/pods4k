package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableDoubleArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import com.danrusu.pods4k.immutableArrays.toImmutableArray
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FlatMapIndexedSpecializationsTest {
    @Test
    fun `generic to generic validation`() {
        with(emptyImmutableArray<String>()) {
            // iterable
            expectThat(
                flatMapIndexed<String, Char> { index, element ->
                    element.toList().drop(index)
                },
            ).isEqualTo(emptyImmutableArray<Char>())

            // immutable array
            expectThat(
                flatMapIndexed { index, element ->
                    element.toList().drop(index).toImmutableArray<Char>()
                },
            ).isEqualTo(emptyImmutableArray<Char>())
        }

        with(immutableArrayOf("Dan", "Jill")) {
            // iterable
            expectThat(
                flatMapIndexed<String, Char> { index, element ->
                    element.toList().drop(index)
                },
            ).isEqualTo(immutableArrayOf<Char>('D', 'a', 'n', 'i', 'l', 'l'))

            // immutable array
            expectThat(
                flatMapIndexed { index, element ->
                    element.toList().drop(index).toImmutableArray<Char>()
                },
            ).isEqualTo(immutableArrayOf<Char>('D', 'a', 'n', 'i', 'l', 'l'))
        }
    }

    @Test
    fun `generic to primitive validation`() {
        with(emptyImmutableArray<String>()) {
            // iterable
            expectThat(
                flatMapIndexed { index, element ->
                    element.toCharArray().map { it.digitToInt() } + index
                },
            ).isEqualTo(emptyImmutableIntArray())

            // immutable array
            expectThat(
                flatMapIndexed { index, element ->
                    (element.toCharArray().map { it.digitToInt() } + index).toImmutableArray()
                },
            ).isEqualTo(emptyImmutableIntArray())
        }

        with(immutableArrayOf("1", "22", "333")) {
            // iterable
            expectThat(
                flatMapIndexed { index, element ->
                    element.toCharArray().map { it.digitToInt() } + index
                },
            ).isEqualTo(immutableArrayOf(1, 0, 2, 2, 1, 3, 3, 3, 2))

            // immutable array
            expectThat(
                flatMapIndexed { index, element ->
                    (element.toCharArray().map { it.digitToInt() } + index).toImmutableArray()
                },
            ).isEqualTo(immutableArrayOf(1, 0, 2, 2, 1, 3, 3, 3, 2))
        }
    }

    @Test
    fun `primitive to generic validation`() {
        with(emptyImmutableIntArray()) {
            // iterable
            expectThat(
                flatMapIndexed<Char> { index, element ->
                    element.toString().toList().drop(index)
                },
            ).isEqualTo(emptyImmutableArray<Char>())

            // immutable array
            expectThat(
                flatMapIndexed { index, element ->
                    element.toString().toList().drop(index).toImmutableArray<Char>()
                },
            ).isEqualTo(emptyImmutableArray<Char>())
        }

        with(immutableArrayOf(2, 10, 3789)) {
            // iterable
            expectThat(
                flatMapIndexed<Char> { index, element ->
                    element.toString().toList().drop(index)
                },
            ).isEqualTo(immutableArrayOf<Char>('2', '0', '8', '9'))

            // immutable array
            expectThat(
                flatMapIndexed { index, element ->
                    element.toString().toList().drop(index).toImmutableArray<Char>()
                },
            ).isEqualTo(immutableArrayOf<Char>('2', '0', '8', '9'))
        }
    }

    @Test
    fun `primitive to primitive validation`() {
        with(emptyImmutableIntArray()) {
            // iterable
            expectThat(
                flatMapIndexed { index, element ->
                    DoubleArray(element) { (index + it).toDouble() / element }.toList()
                },
            ).isEqualTo(emptyImmutableDoubleArray())

            // immutable array
            expectThat(
                flatMapIndexed { index, element ->
                    DoubleArray(element) { (index + it).toDouble() / element }.toImmutableArray()
                },
            ).isEqualTo(emptyImmutableDoubleArray())
        }

        with(immutableArrayOf(3, 4)) {
            // iterable
            expectThat(
                flatMapIndexed { index, element ->
                    DoubleArray(element) { (index + it).toDouble() / element }.toList()
                },
            ).isEqualTo(immutableArrayOf(0.0, 1.0 / 3, 2.0 / 3, 1.0 / 4, 2.0 / 4, 3.0 / 4, 4.0 / 4))

            // immutable array
            expectThat(
                flatMapIndexed { index, element ->
                    DoubleArray(element) { (index + it).toDouble() / element }.toImmutableArray()
                },
            ).isEqualTo(immutableArrayOf(0.0, 1.0 / 3, 2.0 / 3, 1.0 / 4, 2.0 / 4, 3.0 / 4, 4.0 / 4))
        }
    }
}

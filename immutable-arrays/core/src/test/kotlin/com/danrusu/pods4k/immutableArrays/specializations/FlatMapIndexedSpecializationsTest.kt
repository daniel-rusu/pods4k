package com.danrusu.pods4k.immutableArrays.specializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableDoubleArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FlatMapIndexedSpecializationsTest {
    @Test
    fun `generic to generic validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(flatMapIndexed<String, Char> { index, element -> element.toList().drop(index) })
                .isEqualTo(emptyImmutableArray<Char>())
        }

        with(immutableArrayOf("Dan", "Jill")) {
            expectThat(flatMapIndexed<String, Char> { index, element -> element.toList().drop(index) })
                .isEqualTo(immutableArrayOf<Char>('D', 'a', 'n', 'i', 'l', 'l'))
        }
    }

    @Test
    fun `generic to primitive validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(flatMapIndexed { index, element -> element.toCharArray().map { it.digitToInt() } + index })
                .isEqualTo(emptyImmutableIntArray())
        }

        with(immutableArrayOf("1", "22", "333")) {
            expectThat(flatMapIndexed { index, element -> element.toCharArray().map { it.digitToInt() } + index })
                .isEqualTo(immutableArrayOf(1, 0, 2, 2, 1, 3, 3, 3, 2))
        }
    }

    @Test
    fun `primitive to generic validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(flatMapIndexed<Char> { index, element -> element.toString().toList().drop(index) })
                .isEqualTo(emptyImmutableArray<Char>())
        }

        with(immutableArrayOf(2, 10, 3789)) {
            expectThat(flatMapIndexed<Char> { index, element -> element.toString().toList().drop(index) })
                .isEqualTo(immutableArrayOf<Char>('2', '0', '8', '9'))
        }
    }

    @Test
    fun `primitive to primitive validation`() {
        with(emptyImmutableIntArray()) {
            expectThat(
                flatMapIndexed { index, element ->
                    DoubleArray(element) { (index + it).toDouble() / element }.toList()
                },
            ).isEqualTo(emptyImmutableDoubleArray())
        }

        with(immutableArrayOf(3, 4)) {
            expectThat(
                flatMapIndexed { index, element ->
                    DoubleArray(element) { (index + it).toDouble() / element }.toList()
                },
            ).isEqualTo(immutableArrayOf(0.0, 1.0 / 3, 2.0 / 3, 1.0 / 4, 2.0 / 4, 3.0 / 4, 4.0 / 4))
        }
    }
}

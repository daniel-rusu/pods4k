package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.ImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import com.danrusu.pods4k.immutableArrays.isEmpty
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class MapIndexedNotNullSpecializationsTest {
    @Test
    fun `generic to generic validation`() {
        with(immutableArrayOf("one", "two", "three")) {
            // all null
            expectThat(mapIndexedNotNull { index, element -> if (index > 10) element else null })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            // some null
            expectThat(mapIndexedNotNull { index, element -> if (index % 2 == 0) element else null })
                .isEqualTo(immutableArrayOf("one", "three"))

            // none null
            expectThat(mapIndexedNotNull { index, element -> if (index >= 0) element else null })
                .isEqualTo(immutableArrayOf("one", "two", "three"))
        }
    }

    @Test
    fun `generic to primitive validation`() {
        with(immutableArrayOf("a", "bb", "ccc")) {
            // all null
            expectThat(mapIndexedNotNull { index, element -> if (index > 10) element.length else null })
                .isA<ImmutableIntArray>()
                .isEmpty()

            // some null
            expectThat(mapIndexedNotNull { index, element -> if (index >= 1) element.length else null })
                .isEqualTo(immutableArrayOf(2, 3))

            // none null
            expectThat(mapIndexedNotNull { index, element -> if (index >= 0) element.length else null })
                .isEqualTo(immutableArrayOf(1, 2, 3))
        }
    }

    @Test
    fun `primitive to generic validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            // all null
            expectThat(mapIndexedNotNull { index, element -> if (index > 10) element.toString() else null })
                .isA<ImmutableArray<String>>()
                .isEmpty()

            // some null
            expectThat(mapIndexedNotNull { index, element -> if (index % 2 == 0) element.toString() else null })
                .isEqualTo(immutableArrayOf("1", "3"))

            // none null
            expectThat(mapIndexedNotNull { index, element -> if (index >= 0) element.toString() else null })
                .isEqualTo(immutableArrayOf("1", "2", "3"))
        }
    }

    @Test
    fun `primitive to primitive validation`() {
        with(immutableArrayOf(1, 2, 3)) {
            // all null
            expectThat(mapIndexedNotNull { index, element -> if (index > 10) 2 * element else null })
                .isA<ImmutableIntArray>()
                .isEmpty()

            // some null
            expectThat(mapIndexedNotNull { index, element -> if (index % 2 == 0) 5 * element else null })
                .isEqualTo(immutableArrayOf(5, 15))

            // none null
            expectThat(mapIndexedNotNull { index, element -> if (index >= 0) 5 * element else null })
                .isEqualTo(immutableArrayOf(5, 10, 15))
        }
    }
}

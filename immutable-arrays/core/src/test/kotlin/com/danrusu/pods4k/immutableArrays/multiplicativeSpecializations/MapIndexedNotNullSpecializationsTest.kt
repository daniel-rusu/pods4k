package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class MapIndexedNotNullSpecializationsTest {
    @Test
    fun `generic to generic validation`() {
        val input = immutableArrayOf("one", "two", "three")

        // all null
        expectThat(input.mapIndexedNotNull { index, element -> if (index > 10) element else null })
            .isEqualTo(emptyImmutableArray())

        // some null
        expectThat(input.mapIndexedNotNull { index, element -> if (index % 2 == 0) element else null })
            .isEqualTo(immutableArrayOf("one", "three"))

        // none null
        expectThat(input.mapIndexedNotNull { index, element -> if (index >= 0) element else null })
            .isEqualTo(immutableArrayOf("one", "two", "three"))
    }

    @Test
    fun `generic to primitive validation`() {
        val input = immutableArrayOf("a", "bb", "ccc")

        // all null
        expectThat(input.mapIndexedNotNull { index, element -> if (index > 10) element.length else null })
            .isEqualTo(emptyImmutableIntArray())

        // some null
        expectThat(input.mapIndexedNotNull { index, element -> if (index >= 1) element.length else null })
            .isEqualTo(immutableArrayOf(2, 3))

        // none null
        expectThat(input.mapIndexedNotNull { index, element -> if (index >= 0) element.length else null })
            .isEqualTo(immutableArrayOf(1, 2, 3))
    }

    @Test
    fun `primitive to generic validation`() {
        val input = immutableArrayOf(1, 2, 3)

        // all null
        expectThat(input.mapIndexedNotNull { index, element -> if (index > 10) element.toString() else null })
            .isEqualTo(emptyImmutableArray())

        // some null
        expectThat(input.mapIndexedNotNull { index, element -> if (index % 2 == 0) element.toString() else null })
            .isEqualTo(immutableArrayOf("1", "3"))

        // none null
        expectThat(input.mapIndexedNotNull { index, element -> if (index >= 0) element.toString() else null })
            .isEqualTo(immutableArrayOf("1", "2", "3"))
    }

    @Test
    fun `primitive to primitive validation`() {
        val input = immutableArrayOf(1, 2, 3)

        // all null
        expectThat(input.mapIndexedNotNull { index, element -> if (index > 10) 2 * element else null })
            .isEqualTo(emptyImmutableIntArray())

        // some null
        expectThat(input.mapIndexedNotNull { index, element -> if (index % 2 == 0) 5 * element else null })
            .isEqualTo(immutableArrayOf(5, 15))

        // none null
        expectThat(input.mapIndexedNotNull { index, element -> if (index >= 0) 5 * element else null })
            .isEqualTo(immutableArrayOf(5, 10, 15))
    }
}

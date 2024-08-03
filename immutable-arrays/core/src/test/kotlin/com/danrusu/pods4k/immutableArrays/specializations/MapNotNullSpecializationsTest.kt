package com.danrusu.pods4k.immutableArrays.specializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class MapNotNullSpecializationsTest {
    @Test
    fun `generic to generic validation`() {
        val input = immutableArrayOf(
            Pair("one", 1),
            Pair("two", 2),
            Pair("three", 3),
        )

        // all null
        expectThat(input.mapNotNull { if (it.second > 10) it.first else null })
            .isEqualTo(emptyImmutableArray())

        // some null
        expectThat(input.mapNotNull { if (it.second % 2 != 0) it.first else null })
            .isEqualTo(immutableArrayOf("one", "three"))

        // none null
        expectThat(input.mapNotNull { if (it.second > 0) it.first else null })
            .isEqualTo(immutableArrayOf("one", "two", "three"))
    }

    @Test
    fun `generic to primitive validation`() {
        val input = immutableArrayOf("a", "bb", "ccc")

        // all null
        expectThat(input.mapNotNull { if (it.length > 10) it.length else null })
            .isEqualTo(emptyImmutableIntArray())

        // some null
        expectThat(input.mapNotNull { if (it.length > 1) it.length else null })
            .isEqualTo(immutableArrayOf(2, 3))

        // none null
        expectThat(input.mapNotNull { if (it.isNotEmpty()) it.length else null })
            .isEqualTo(immutableArrayOf(1, 2, 3))
    }

    @Test
    fun `primitive to generic validation`() {
        val input = immutableArrayOf(1, 2, 3)

        // all null
        expectThat(input.mapNotNull { if (it > 10) it.toString() else null })
            .isEqualTo(emptyImmutableArray())

        // some null
        expectThat(input.mapNotNull { if (it % 2 == 1) it.toString() else null })
            .isEqualTo(immutableArrayOf("1", "3"))

        // none null
        expectThat(input.mapNotNull { if (it > 0) it.toString() else null })
            .isEqualTo(immutableArrayOf("1", "2", "3"))
    }

    @Test
    fun `primitive to primitive validation`() {
        val input = immutableArrayOf(1, 2, 3)

        // all null
        expectThat(input.mapNotNull { if (it > 10) 2 * it else null })
            .isEqualTo(emptyImmutableIntArray())

        // some null
        expectThat(input.mapNotNull { if (it % 2 == 1) 5 * it else null })
            .isEqualTo(immutableArrayOf(5, 15))

        // none null
        expectThat(input.mapNotNull { if (it > 0) 5 * it else null })
            .isEqualTo(immutableArrayOf(5, 10, 15))
    }
}

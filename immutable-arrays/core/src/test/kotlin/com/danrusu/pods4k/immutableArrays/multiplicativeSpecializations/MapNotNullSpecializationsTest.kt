package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.ImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import com.danrusu.pods4k.immutableArrays.isEmpty
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
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
            .isA<ImmutableArray<String>>()
            .isEmpty()

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
            .isA<ImmutableIntArray>()
            .isEmpty()

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
            .isA<ImmutableArray<String>>()
            .isEmpty()

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
            .isA<ImmutableIntArray>()
            .isEmpty()

        // some null
        expectThat(input.mapNotNull { if (it % 2 == 1) 5 * it else null })
            .isEqualTo(immutableArrayOf(5, 15))

        // none null
        expectThat(input.mapNotNull { if (it > 0) 5 * it else null })
            .isEqualTo(immutableArrayOf(5, 10, 15))
    }
}

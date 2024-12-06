package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableCharArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableIntArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class UnzipSpecializationsTest {
    @Test
    fun `generic with generic validation`() {
        expectThat(
            emptyImmutableArray<Pair<String, String>>().unzip(),
        ).isEqualTo(
            Pair(
                emptyImmutableArray<String>(),
                emptyImmutableArray<String>(),
            ),
        )

        expectThat(
            immutableArrayOf(Pair("one", "1")).unzip(),
        ).isEqualTo(
            Pair(
                immutableArrayOf("one"),
                immutableArrayOf("1"),
            ),
        )

        expectThat(
            immutableArrayOf(
                Pair("one", "1"),
                Pair("two", "2"),
            ).unzip(),
        ).isEqualTo(
            Pair(
                immutableArrayOf("one", "two"),
                immutableArrayOf("1", "2"),
            ),
        )
    }

    @Test
    fun `generic with primitive validation`() {
        expectThat(
            emptyImmutableArray<Pair<String, Int>>().unzip(),
        ).isEqualTo(
            Pair(
                emptyImmutableArray<String>(),
                emptyImmutableIntArray(),
            ),
        )

        expectThat(
            immutableArrayOf(Pair("one", 1)).unzip(),
        ).isEqualTo(
            Pair(
                immutableArrayOf("one"),
                immutableArrayOf(1),
            ),
        )

        expectThat(
            immutableArrayOf(
                Pair("one", 1),
                Pair("two", 2),
            ).unzip(),
        ).isEqualTo(
            Pair(
                immutableArrayOf("one", "two"),
                immutableArrayOf(1, 2),
            ),
        )
    }

    @Test
    fun `primitive with generic validation`() {
        expectThat(
            emptyImmutableArray<Pair<Int, String>>().unzip(),
        ).isEqualTo(
            Pair(
                emptyImmutableIntArray(),
                emptyImmutableArray<String>(),
            ),
        )

        expectThat(
            immutableArrayOf(Pair(1, "a")).unzip(),
        ).isEqualTo(
            Pair(
                immutableArrayOf(1),
                immutableArrayOf("a"),
            ),
        )

        expectThat(
            immutableArrayOf(
                Pair(1, "a"),
                Pair(2, "b"),
            ).unzip(),
        ).isEqualTo(
            Pair(
                immutableArrayOf(1, 2),
                immutableArrayOf("a", "b"),
            ),
        )
    }

    @Test
    fun `primitive with primitive validation`() {
        expectThat(
            emptyImmutableArray<Pair<Int, Char>>().unzip(),
        ).isEqualTo(
            Pair(
                emptyImmutableIntArray(),
                emptyImmutableCharArray(),
            ),
        )

        expectThat(
            immutableArrayOf(Pair(1, 'a')).unzip(),
        ).isEqualTo(
            Pair(
                immutableArrayOf(1),
                immutableArrayOf('a'),
            ),
        )

        expectThat(
            immutableArrayOf(
                Pair(1, 'a'),
                Pair(2, 'b'),
            ).unzip(),
        ).isEqualTo(
            Pair(
                immutableArrayOf(1, 2),
                immutableArrayOf('a', 'b'),
            ),
        )
    }
}

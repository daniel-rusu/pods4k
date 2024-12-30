package com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.ImmutableCharArray
import com.danrusu.pods4k.immutableArrays.ImmutableIntArray
import com.danrusu.pods4k.immutableArrays.emptyImmutableArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import com.danrusu.pods4k.immutableArrays.isEmpty
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class UnzipSpecializationsTest {
    @Test
    fun `generic with generic validation`() {
        with(emptyImmutableArray<Pair<String, String>>().unzip()) {
            expectThat(this)
                .isA<Pair<String, String>>()

            expectThat(first)
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(second)
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

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
        with(emptyImmutableArray<Pair<String, Int>>().unzip()) {
            expectThat(this)
                .isA<Pair<ImmutableArray<String>, ImmutableIntArray>>()

            expectThat(first)
                .isA<ImmutableArray<String>>()
                .isEmpty()

            expectThat(second)
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

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
        with(emptyImmutableArray<Pair<Int, String>>().unzip()) {
            expectThat(this)
                .isA<Pair<ImmutableIntArray, ImmutableArray<String>>>()

            expectThat(first)
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(second)
                .isA<ImmutableArray<String>>()
                .isEmpty()
        }

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
        with(emptyImmutableArray<Pair<Int, Char>>().unzip()) {
            expectThat(this)
                .isA<Pair<ImmutableIntArray, ImmutableCharArray>>()

            expectThat(first)
                .isA<ImmutableIntArray>()
                .isEmpty()

            expectThat(second)
                .isA<ImmutableCharArray>()
                .isEmpty()
        }

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

package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class TransformationsToMapTest {

    @Test
    fun `array of pairs toMap validation`() {
        expectThat(emptyImmutableArray<Pair<String, Char>>().toMap())
            .isEqualTo(emptyMap<String, Char>())

        expectThat(
            immutableArrayOf('a' to "Apple").toMap(),
        ).isEqualTo(mapOf('a' to "Apple"))

        expectThat(
            immutableArrayOf(
                1 to "one",
                2 to "two",
            ).toMap(),
        ).isEqualTo(
            mapOf(
                1 to "one",
                2 to "two",
            ),
        )
    }

    @Test
    fun `associate validation`() {
        expectThat(
            immutableArrayOf("a", "bb", "ccc").associate { it to it.length },
        ).isEqualTo(
            mapOf(
                "a" to 1,
                "bb" to 2,
                "ccc" to 3,
            ),
        )

        expectThat(
            immutableArrayOf(1, 2, 3).associate { it to it.toString() },
        ).isEqualTo(
            mapOf(
                1 to "1",
                2 to "2",
                3 to "3",
            ),
        )
    }

    @Test
    fun `associateBy validation`() {
        expectThat(
            immutableArrayOf("a", "bb", "ccc", "ddd").associateBy { it.length },
        ).isEqualTo(
            mapOf(
                1 to "a",
                2 to "bb",
                3 to "ddd",
            ),
        )

        expectThat(
            immutableArrayOf(1, 2, 3, 35).associateBy { it.toString().first() },
        ).isEqualTo(
            mapOf(
                '1' to 1,
                '2' to 2,
                '3' to 35,
            ),
        )
    }

    @Test
    fun `associateWith validation`() {
        expectThat(
            immutableArrayOf("a", "bb", "ccc").associateWith { it.length },
        ).isEqualTo(
            mapOf(
                "a" to 1,
                "bb" to 2,
                "ccc" to 3,
            ),
        )

        expectThat(
            immutableArrayOf(1, 2, 3).associateWith { it.toString() },
        ).isEqualTo(
            mapOf(
                1 to "1",
                2 to "2",
                3 to "3",
            ),
        )
    }

    @Test
    fun `groupBy validation`() {
        expectThat(emptyImmutableArray<String>().groupBy { it.length })
            .isEqualTo(emptyMap())

        expectThat(immutableArrayOf("a", "bb", "ccc", "dddd", "eeeee").groupBy { it.length % 3 })
            .isEqualTo(
                mapOf(
                    1 to immutableArrayOf("a", "dddd"),
                    2 to immutableArrayOf("bb", "eeeee"),
                    0 to immutableArrayOf("ccc"),
                ),
            )

        expectThat(emptyImmutableIntArray().groupBy { it % 3 })
            .isEqualTo(emptyMap())

        expectThat(immutableArrayOf(1, 2, 3, 4, 5).groupBy { it % 3 })
            .isEqualTo(
                mapOf(
                    1 to immutableArrayOf(1, 4),
                    2 to immutableArrayOf(2, 5),
                    0 to immutableArrayOf(3),
                ),
            )
    }
}

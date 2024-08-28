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
}

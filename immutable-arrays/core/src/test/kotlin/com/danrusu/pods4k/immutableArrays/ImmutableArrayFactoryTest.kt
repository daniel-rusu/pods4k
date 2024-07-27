package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo

class ImmutableArrayFactoryTest {
    @Test
    fun `emptyImmutableArray validation`() {
        with(emptyImmutableArray<String>()) {
            expectThat(this).isA<ImmutableArray<String>>()
            expectThat(this).isEmpty()
        }
        with(emptyImmutableIntArray()) {
            expectThat(this).isA<ImmutableIntArray>()
            expectThat(this).isEmpty()
        }
    }

    @Test
    fun `immutableArrayOf validation`() {
        with(immutableArrayOf<String>()) {
            expectThat(this).isA<ImmutableArray<String>>()
            expectThat(this).isEmpty()
        }

        with(immutableArrayOf("one", "two")) {
            expectThat(this).isA<ImmutableArray<String>>()
            expectThat(this).containsExactly("one", "two")
        }

        with(immutableArrayOf(10, 20, 30)) {
            expectThat(this).isA<ImmutableIntArray>()
            expectThat(this).containsExactly(10, 20, 30)
        }
    }

    @Test
    fun `buildImmutableArray validation`() {
        val names = buildImmutableArray {
            add("Bob")
            add("Jill")
        }
        expectThat(names)
            .isEqualTo(immutableArrayOf("Bob", "Jill"))

        val numbers = buildImmutableIntArray {
            add(3)
            add(7)
            add(11)
        }

        expectThat(numbers)
            .isEqualTo(immutableArrayOf(3, 7, 11))
    }
}

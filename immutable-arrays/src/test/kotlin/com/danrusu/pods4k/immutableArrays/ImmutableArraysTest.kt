package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA

class ImmutableArraysTest {
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
}

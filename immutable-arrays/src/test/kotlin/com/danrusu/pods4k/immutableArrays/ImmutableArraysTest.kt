package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEqualTo

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
            expectThat(this.size).isEqualTo(2)

            expectThat(this[0]).isEqualTo("one")
            expectThat(this[1]).isEqualTo("two")

            expectThrows<ArrayIndexOutOfBoundsException> { this[3] }
        }

        with(immutableArrayOf(10, 20, 30)) {
            expectThat(this).isA<ImmutableIntArray>()
            expectThat(this.size).isEqualTo(3)

            expectThat(this[0]).isEqualTo(10)
            expectThat(this[1]).isEqualTo(20)
            expectThat(this[2]).isEqualTo(30)

            expectThrows<ArrayIndexOutOfBoundsException> { this[3] }
        }
    }
}

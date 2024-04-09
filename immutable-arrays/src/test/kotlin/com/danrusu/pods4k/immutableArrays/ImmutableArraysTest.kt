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

    @Test
    fun `generic ImmutableArray to primitive immutable array validation`() {
        with(immutableArrayOf<Int>(1, 3, 5)) {
            expectThat(this).isA<ImmutableArray<Int>>()

            val primitiveVersion = this.toImmutableIntArray()
            expectThat(primitiveVersion).isA<ImmutableIntArray>()
            expectThat(primitiveVersion).containsExactly(1, 3, 5)
        }
    }

    @Test
    fun `primitive immutable array to generic ImmutableArray validation`() {
        with(immutableArrayOf(1, 3, 5)) {
            expectThat(this).isA<ImmutableIntArray>()

            val genericVersion = this.toTypedImmutableArray()
            expectThat(genericVersion).isA<ImmutableArray<Int>>()
            expectThat(genericVersion).containsExactly(1, 3, 5)
        }
    }
}

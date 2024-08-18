package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEmpty
import strikt.assertions.isEqualTo

class TransformationsToSetTest {
    @Test
    fun `toSet validation`() {
        // empty
        with(emptyImmutableArray<String>()) {
            expectThat(toSet()).isEqualTo(emptySet())
        }
        with(emptyImmutableIntArray()) {
            expectThat(toSet()).isEqualTo(emptySet())
        }
        // multiple elements
        with(immutableArrayOf("Bob", "Jill", "Bob")) {
            expectThat(toSet())
                .isEqualTo(setOf("Bob", "Jill"))
        }
        with(immutableArrayOf(7, 15, 15)) {
            expectThat(toSet())
                .isEqualTo(setOf(7, 15))
        }
    }

    @Test
    fun `toMutableSet validation`() {
        // empty
        with(emptyImmutableArray<String>()) {
            expectThat(toMutableSet())
                .isA<LinkedHashSet<String>>()
                .isEmpty()
        }
        with(emptyImmutableIntArray()) {
            expectThat(toMutableSet())
                .isA<LinkedHashSet<String>>()
                .isEmpty()
        }
        // multiple elements
        with(immutableArrayOf("Bob", "Jill", "Bob")) {
            expectThat(toMutableSet())
                .isEqualTo(mutableSetOf("Bob", "Jill"))
        }
        with(immutableArrayOf(7, 15, 15)) {
            expectThat(toMutableSet())
                .isEqualTo(mutableSetOf(7, 15))
        }
    }

    @Test
    fun `toHashSet validation`() {
        // empty
        with(emptyImmutableArray<String>()) {
            expectThat(toHashSet())
                .isA<HashSet<String>>()
                .isEmpty()
        }
        with(emptyImmutableIntArray()) {
            expectThat(toHashSet())
                .isA<HashSet<String>>()
                .isEmpty()
        }
        // multiple elements
        with(immutableArrayOf("Bob", "Jill", "Bob")) {
            expectThat(toHashSet())
                .isEqualTo(hashSetOf("Bob", "Jill"))
        }
        with(immutableArrayOf(7, 15, 15)) {
            expectThat(toHashSet())
                .isEqualTo(hashSetOf(7, 15))
        }
    }
}

package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class TransformationsToListTest {
    @Test
    fun `toList validation`() {
        // empty
        with(emptyImmutableArray<String>()) {
            expectThat(toList()).isEqualTo(emptyList())
        }
        with(emptyImmutableIntArray()) {
            expectThat(toList()).isEqualTo(emptyList())
        }
        // 1 element
        with(immutableArrayOf("Bob")) {
            expectThat(toList())
                .isEqualTo(listOf("Bob"))
        }
        with(immutableArrayOf(7)) {
            expectThat(toList())
                .isEqualTo(listOf(7))
        }
        // multiple elements
        with(immutableArrayOf("Bob", "Jill", "Jane")) {
            expectThat(toList())
                .isEqualTo(listOf("Bob", "Jill", "Jane"))
        }
        with(immutableArrayOf(7, 15, 100)) {
            expectThat(toList())
                .isEqualTo(listOf(7, 15, 100))
        }
    }

    @Test
    fun `toMutableList validation`() {
        // empty
        with(emptyImmutableArray<String>()) {
            expectThat(toMutableList()).isEqualTo(mutableListOf())
        }
        with(emptyImmutableIntArray()) {
            expectThat(toMutableList()).isEqualTo(mutableListOf())
        }
        // 1 element
        with(immutableArrayOf("Bob")) {
            expectThat(toMutableList())
                .isEqualTo(mutableListOf("Bob"))
        }
        with(immutableArrayOf(7)) {
            expectThat(toMutableList())
                .isEqualTo(mutableListOf(7))
        }
        // multiple elements
        with(immutableArrayOf("Bob", "Jill", "Jane")) {
            expectThat(toMutableList())
                .isEqualTo(mutableListOf("Bob", "Jill", "Jane"))
        }
        with(immutableArrayOf(7, 15, 100)) {
            expectThat(toMutableList())
                .isEqualTo(mutableListOf(7, 15, 100))
        }
    }
}

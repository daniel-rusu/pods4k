package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isGreaterThan
import strikt.assertions.isGreaterThanOrEqualTo

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

    @Test
    fun `builderUtils computeNewCapacity validation`() {
        // happy path
        with(BuilderUtils) {
            // capacity doesn't change when it's already sufficient
            expectThat(computeNewCapacity(currentCapacity = 10, minCapacity = 9))
                .isEqualTo(10)

            // 0 initial capacity doesn't get stuck at 0
            expectThat(computeNewCapacity(currentCapacity = 0, minCapacity = 1))
                .isGreaterThan(0)

            // capacity increases by at least 50%
            expectThat(computeNewCapacity(currentCapacity = 10, minCapacity = 11))
                .isGreaterThanOrEqualTo(15)

            // new capacity respects minCapacity
            expectThat(computeNewCapacity(currentCapacity = 10, minCapacity = 1_000_000))
                .isGreaterThanOrEqualTo(1_000_000)
        }

        // Overflow handling
        with(BuilderUtils) {
            val currentCapacity = Int.MAX_VALUE - 20

            // Overflow from the array growth handles overflow gracefully when current size is close to max array size
            expectThat(computeNewCapacity(currentCapacity = currentCapacity, minCapacity = currentCapacity + 1))
                .isEqualTo(MAX_ARRAY_SIZE)

            // Specifying a minCapacity that has overflowed
            expectThrows<OutOfMemoryError> {
                computeNewCapacity(currentCapacity = currentCapacity, minCapacity = currentCapacity + 21)
            }

            // Requesting a capacity equal to the max array size is allowed
            expectThat(computeNewCapacity(currentCapacity = currentCapacity, minCapacity = MAX_ARRAY_SIZE))
                .isEqualTo(MAX_ARRAY_SIZE)

            // Specifying a minCapacity that exceeds the max array size
            expectThrows<OutOfMemoryError> {
                computeNewCapacity(currentCapacity = currentCapacity, minCapacity = MAX_ARRAY_SIZE + 1)
            }
        }
    }
}

package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isGreaterThan
import strikt.assertions.isGreaterThanOrEqualTo
import strikt.assertions.message

class ImmutableArrayFactoryTest {
    @Test
    fun `emptyImmutableArray validation`() {
        expectThat(emptyImmutableArray<String>())
            .isA<ImmutableArray<String>>()
            .isEmpty()

        expectThat(emptyImmutableIntArray())
            .isA<ImmutableIntArray>()
            .isEmpty()
    }

    @Test
    fun `immutableArrayOf validation`() {
        expectThat(immutableArrayOf<String>())
            .isA<ImmutableArray<String>>()
            .isEmpty()

        expectThat(immutableArrayOf("one", "two"))
            .isA<ImmutableArray<String>>()
            .containsExactly("one", "two")

        expectThat(immutableArrayOf(10, 20, 30))
            .isA<ImmutableIntArray>()
            .containsExactly(10, 20, 30)
    }

    @Test
    fun `immutableArrayOfNotNull validation`() {
        // Nobody would purposely attempt to pass explicit nulls to these functions since they would always be ignored.
        // Instead, these nulls come from nullable variables
        val nullString: String? = null
        val nullInt: Int? = null

        expectThat(immutableArrayOfNotNull<String>())
            .isA<ImmutableArray<String>>()
            .isEmpty()

        expectThat(immutableArrayOfNotNull(nullString, nullString))
            .isA<ImmutableArray<String>>()
            .isEmpty()

        expectThat(immutableArrayOfNotNull(nullInt))
            .isA<ImmutableIntArray>()
            .isEmpty()

        expectThat(immutableArrayOfNotNull(nullString, "one", nullString, "two", nullString, nullString))
            .isEqualTo(immutableArrayOf("one", "two"))

        expectThat(immutableArrayOfNotNull(1, nullInt, 2))
            .isEqualTo(immutableArrayOf(1, 2))
    }

    @Test
    fun `buildImmutableArray validation`() {
        expectThat(buildImmutableArray<String> { })
            .isA<ImmutableArray<String>>()
            .isEmpty()

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
            expectThrows<IllegalStateException> {
                computeNewCapacity(currentCapacity = currentCapacity, minCapacity = currentCapacity + 21)
            }.message.isEqualTo("minCapacity encountered overflow")

            // Requesting a capacity equal to the max array size is allowed
            expectThat(computeNewCapacity(currentCapacity = currentCapacity, minCapacity = MAX_ARRAY_SIZE))
                .isEqualTo(MAX_ARRAY_SIZE)

            // Specifying a minCapacity that exceeds the max array size
            expectThrows<IllegalStateException> {
                computeNewCapacity(currentCapacity = currentCapacity, minCapacity = MAX_ARRAY_SIZE + 1)
            }.message.isEqualTo("minCapacity exceeds max array size")
        }
    }
}

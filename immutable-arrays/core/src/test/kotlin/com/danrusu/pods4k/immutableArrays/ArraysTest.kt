package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.ImmutableBooleanArray
import com.danrusu.pods4k.immutableArrays.ImmutableIntArray
import com.danrusu.pods4k.immutableArrays.toImmutableArray
import com.danrusu.pods4k.immutableArrays.toImmutableIntArray
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA

class ArraysTest {
    @Test
    fun `primitive array toImmutableArray validation`() {
        with(BooleanArray(0)) {
            val immutable = this.toImmutableArray()
            expectThat(immutable).isA<ImmutableBooleanArray>()

            expectThat(immutable).isEmpty()
        }
        with(intArrayOf(1, 3, 5)) {
            val immutable = this.toImmutableArray()
            expectThat(immutable).isA<ImmutableIntArray>()
            expectThat(immutable).containsExactly(1, 3, 5)
        }
    }

    @Test
    fun `generic array toImmutableArray validation`() {
        with(emptyArray<String>()) {
            val immutable = this.toImmutableArray()
            expectThat(immutable).isA<ImmutableArray<String>>()

            expectThat(immutable).isEmpty()
        }
        with(arrayOf("one", "two")) {
            val immutable = this.toImmutableArray()
            expectThat(immutable).isA<ImmutableArray<String>>()
            expectThat(immutable).containsExactly("one", "two")
        }
        with(emptyArray<Int>()) {
            val immutable = this.toImmutableIntArray()
            expectThat(immutable).isA<ImmutableIntArray>()
            expectThat(immutable).isEmpty()
        }
        with(arrayOf(1, 3, 5)) {
            val immutable = this.toImmutableIntArray()
            expectThat(immutable).isA<ImmutableIntArray>()
            expectThat(immutable).containsExactly(1, 3, 5)
        }
    }
}

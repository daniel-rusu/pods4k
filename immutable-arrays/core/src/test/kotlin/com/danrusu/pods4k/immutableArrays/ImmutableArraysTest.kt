package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isTrue
import strikt.assertions.message

private val primitiveIntClass = 3::class.java

class ImmutableArraysTest {

    @Suppress("KotlinConstantConditions")
    @Test
    fun `asList validation`() {
        // Suppressing the constant-condition inspection as it's a false positive thinking that a List is always a MutableList
        // Submitted: https://youtrack.jetbrains.com/issue/IDEA-357859/False-positive-for-KotlinConstantConditions-inspection-for-primitiveArray.asList-is-MutableList

        // generic array
        with(immutableArrayOf("one", "two", "three", "two")) {
            val list = asList()
            expectThat(list is MutableList<String>)
                .isFalse()

            expectThat(list.size)
                .isEqualTo(4)

            expectThat(list.isEmpty())
                .isFalse()

            expectThat(list.contains("one"))
                .isTrue()

            expectThat(list.contains("four"))
                .isFalse()

            expectThat(get(1))
                .isEqualTo("two")

            expectThat(indexOf("two"))
                .isEqualTo(1)

            expectThat(lastIndexOf("two"))
                .isEqualTo(3)

            expectThat(list)
                .isEqualTo(listOf("one", "two", "three", "two"))
        }

        // primitive array
        with(immutableArrayOf(1, 2, 1)) {
            val list = asList()

            expectThat(list is MutableList<Int>)
                .isFalse()

            expectThat(list.size)
                .isEqualTo(3)

            expectThat(list.isEmpty())
                .isFalse()

            expectThat(list.contains(2))
                .isTrue()

            expectThat(list.contains(4))
                .isFalse()

            expectThat(get(1))
                .isEqualTo(2)

            expectThat(indexOf(1))
                .isEqualTo(0)

            expectThat(lastIndexOf(1))
                .isEqualTo(2)

            expectThat(list)
                .isEqualTo(listOf(1, 2, 1))
        }
    }

    @Test
    fun `contains validation`() {
        // generic array
        with(immutableArrayOf<Number>(3, 2.5, 2.5f)) {
            // can use `in` operator
            expectThat(2.5 in this)
                .isTrue()
            expectThat(contains(3))
                .isTrue()

            expectThat(contains(2.6))
                .isFalse()
        }
        // primitive array
        with(immutableArrayOf(1, 2, 3)) {
            expectThat(2 in this)
                .isTrue()

            expectThat(contains(3))
                .isTrue()

            expectThat(contains(4))
                .isFalse()
        }
    }

    @Test
    fun `indexOf validation`() {
        // generic array
        with(immutableArrayOf<Number>(3, 2.5, 3.5f, 2.5)) {
            // can use `in` operator
            expectThat(indexOf(2.5))
                .isEqualTo(1)

            expectThat(indexOf(4))
                .isEqualTo(-1)
        }
        // primitive array
        with(immutableArrayOf(1, 2, 3, 3)) {
            expectThat(indexOf(3))
                .isEqualTo(2)

            expectThat(indexOf(4))
                .isEqualTo(-1)
        }
    }

    @Test
    fun `lastIndexOf validation`() {
        // generic array
        with(immutableArrayOf<Number>(3, 2.5, 3.5f, 2.5)) {
            // can use `in` operator
            expectThat(lastIndexOf(2.5))
                .isEqualTo(3)

            expectThat(lastIndexOf(4))
                .isEqualTo(-1)
        }
        // primitive array
        with(immutableArrayOf(1, 2, 3, 3)) {
            expectThat(lastIndexOf(3))
                .isEqualTo(3)

            expectThat(lastIndexOf(4))
                .isEqualTo(-1)
        }
    }

    @Test
    fun `getOrElse validation`() {
        with(ImmutableArray(3) { "element $it" }) {
            expectThat(this.getOrElse(2) { "else" })
                .isEqualTo("element 2")
            expectThat(this.getOrElse(3) { "else" })
                .isEqualTo("else")
        }

        with(ImmutableIntArray(3) { it }) {
            expectThat(this.getOrElse(2) { 100 }::class.java)
                .isEqualTo(primitiveIntClass)
            expectThat(this.getOrElse(2) { 100 })
                .isEqualTo(2)
            expectThat(this.getOrElse(3) { 100 })
                .isEqualTo(100)
        }
    }

    @Test
    fun `sorted validation`() {
        with(immutableArrayOf("dogs", "apples", "pineapples")) {
            expectThat(sorted())
                .isEqualTo(immutableArrayOf("apples", "dogs", "pineapples"))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf("dogs", "apples", "pineapples"))
        }

        with(immutableArrayOf(1, 2, 5, 4, 3)) {
            expectThat(sorted())
                .isEqualTo(immutableArrayOf(1, 2, 3, 4, 5))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf(1, 2, 5, 4, 3))
        }
    }

    @Test
    fun `sortedDescending validation`() {
        with(immutableArrayOf("dogs", "apples", "pineapples")) {
            expectThat(sortedDescending())
                .isEqualTo(immutableArrayOf("pineapples", "dogs", "apples"))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf("dogs", "apples", "pineapples"))
        }

        with(immutableArrayOf(1, 2, 5, 4, 3)) {
            expectThat(sortedDescending())
                .isEqualTo(immutableArrayOf(5, 4, 3, 2, 1))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf(1, 2, 5, 4, 3))
        }
    }

    @Test
    fun `plus immutableArray validation`() {
        expectThat(emptyImmutableArray<String>() + emptyImmutableArray())
            .isEqualTo(emptyImmutableArray())

        expectThat(emptyImmutableArray<String>() + immutableArrayOf("one", "two"))
            .isEqualTo(immutableArrayOf("one", "two"))

        expectThat(immutableArrayOf("a", "b", "c") + immutableArrayOf("d", "e"))
            .isEqualTo(immutableArrayOf("a", "b", "c", "d", "e"))

        expectThat(emptyImmutableIntArray() + emptyImmutableIntArray())
            .isEqualTo(emptyImmutableIntArray())

        expectThat(emptyImmutableIntArray() + immutableArrayOf(1, 2))
            .isEqualTo(immutableArrayOf(1, 2))

        expectThat(immutableArrayOf(1, 2, 3) + immutableArrayOf(4, 5))
            .isEqualTo(immutableArrayOf(1, 2, 3, 4, 5))
    }

    @Test
    fun `plus value validation`() {
        expectThat(emptyImmutableArray<String>() + "one")
            .isEqualTo(immutableArrayOf("one"))

        expectThat(immutableArrayOf("a", "b", "c") + "d")
            .isEqualTo(immutableArrayOf("a", "b", "c", "d"))

        expectThat(emptyImmutableIntArray() + 1)
            .isEqualTo(immutableArrayOf(1))

        expectThat(immutableArrayOf(1, 2, 3) + 4)
            .isEqualTo(immutableArrayOf(1, 2, 3, 4))
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

    @Test
    fun `requireNoNulls validation`() {
        with(immutableArrayOf<String?>("one", "two")) {
            expectThat(requireNoNulls())
                .isEqualTo(immutableArrayOf("one", "two"))
        }

        expectThrows<IllegalArgumentException> {
            immutableArrayOf("one", null).requireNoNulls()
        }.message.isEqualTo("null element found in [one, null]")
    }
}

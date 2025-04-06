package com.danrusu.pods4k.immutableArrays

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isNotEqualTo
import strikt.assertions.isTrue
import strikt.assertions.message
import kotlin.random.Random

private val primitiveIntClass = 3::class.java

class ImmutableArraysTest {

    /**
     * Suppressing the constant-condition inspection as it's a false positive thinking that a List is always a
     * MutableList.  Submitted:
     *
     * https://youtrack.jetbrains.com/issue/IDEA-357859/False-positive-for-KotlinConstantConditions-inspection-for-primitiveArray.asList-is-MutableList
     *
     * This seems to be fixed in K2 mode but leaving it in here while the library targets Kotlin 1.9.x
     */
    @Suppress("KotlinConstantConditions")
    @Test
    fun `asList validation`() {
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
    fun `min validation`() {
        val minBoolean = minOf(true, false)
        val maxBoolean = maxOf(true, false)

        expectThat(minBoolean)
            .isNotEqualTo(maxBoolean)

        // empty scenarios
        with(emptyImmutableArray<String>()) {
            expectThrows<NoSuchElementException> { min() }
        }
        with(emptyImmutableBooleanArray()) {
            expectThrows<NoSuchElementException> { min() }
        }

        // single element
        with(immutableArrayOf("c")) {
            expectThat(min())
                .isEqualTo("c")
        }
        with(immutableArrayOf(minBoolean)) {
            expectThat(min())
                .isEqualTo(minBoolean)
        }
        with(immutableArrayOf(maxBoolean)) {
            expectThat(min())
                .isEqualTo(maxBoolean)
        }

        // multiple elements
        with(immutableArrayOf("c", "a", "b")) {
            expectThat(min())
                .isEqualTo("a")
        }
        with(immutableArrayOf(3, 1, 2, 4)) {
            expectThat(min())
                .isEqualTo(1)
        }
        with(immutableArrayOf(maxBoolean, maxBoolean, maxBoolean, maxBoolean)) {
            expectThat(min())
                .isEqualTo(maxBoolean)
        }
        with(immutableArrayOf(maxBoolean, maxBoolean, minBoolean, maxBoolean)) {
            expectThat(min())
                .isEqualTo(minBoolean)
        }

        // nan handling
        with(immutableArrayOf(1.0, 2.0, Double.NaN)) {
            expectThat(min())
                .isEqualTo(Double.NaN)
        }
        with(immutableArrayOf(1.0f, 2.0f, Float.NaN)) {
            expectThat(min())
                .isEqualTo(Float.NaN)
        }
    }

    @Test
    fun `max validation`() {
        val minBoolean = minOf(true, false)
        val maxBoolean = maxOf(true, false)

        expectThat(minBoolean)
            .isNotEqualTo(maxBoolean)

        // empty scenarios
        with(emptyImmutableArray<String>()) {
            expectThrows<NoSuchElementException> { max() }
        }
        with(emptyImmutableBooleanArray()) {
            expectThrows<NoSuchElementException> { max() }
        }

        // single element
        with(immutableArrayOf("c")) {
            expectThat(max())
                .isEqualTo("c")
        }
        with(immutableArrayOf(minBoolean)) {
            expectThat(max())
                .isEqualTo(minBoolean)
        }
        with(immutableArrayOf(maxBoolean)) {
            expectThat(max())
                .isEqualTo(maxBoolean)
        }

        // multiple elements
        with(immutableArrayOf("c", "a", "b")) {
            expectThat(max())
                .isEqualTo("c")
        }
        with(immutableArrayOf(3, 1, 2, 4)) {
            expectThat(max())
                .isEqualTo(4)
        }
        with(immutableArrayOf(minBoolean, minBoolean, minBoolean, minBoolean)) {
            expectThat(max())
                .isEqualTo(minBoolean)
        }
        with(immutableArrayOf(minBoolean, minBoolean, maxBoolean, minBoolean)) {
            expectThat(max())
                .isEqualTo(maxBoolean)
        }

        // nan handling
        with(immutableArrayOf(1.0, 2.0, Double.NaN)) {
            expectThat(max())
                .isEqualTo(Double.NaN)
        }
        with(immutableArrayOf(1.0f, 2.0f, Float.NaN)) {
            expectThat(max())
                .isEqualTo(Float.NaN)
        }
    }

    @Test
    fun `filterNotNull validation`() {
        with(emptyImmutableArray<String?>()) {
            expectThat(filterNotNull())
                .isEqualTo(emptyImmutableArray<String>())
        }

        with(immutableArrayOf("one", null, "two")) {
            expectThat(filterNotNull())
                .isEqualTo(immutableArrayOf("one", "two"))
        }

        with(immutableArrayOf("one", "two")) {
            expectThat(filterNotNull())
                .isEqualTo(this)
        }

        with(emptyImmutableArray<Int?>()) {
            expectThat(filterNotNull())
                .isA<ImmutableIntArray>()
                .isEmpty()
        }

        with(immutableArrayOf(1, null, 2)) {
            expectThat(filterNotNull())
                .isA<ImmutableIntArray>()
                .isEqualTo(immutableArrayOf(1, 2))
        }
    }

    @Test
    fun `sorted validation`() {
        // references
        with(emptyImmutableArray<String>()) {
            expectThat(sorted().referencesSameArrayAs(ImmutableArray.EMPTY))
                .isTrue()
        }

        with(immutableArrayOf("one")) {
            expectThat(sorted().referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf("dogs", "apples", "pineapples")) {
            expectThat(sorted())
                .isEqualTo(immutableArrayOf("apples", "dogs", "pineapples"))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf("dogs", "apples", "pineapples"))
        }

        // primitives
        with(emptyImmutableIntArray()) {
            expectThat(sorted().referencesSameArrayAs(ImmutableIntArray.EMPTY))
                .isTrue()
        }

        with(immutableArrayOf(1)) {
            expectThat(sorted().referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf(1, 2, 5, 4, 3)) {
            expectThat(sorted())
                .isEqualTo(immutableArrayOf(1, 2, 3, 4, 5))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf(1, 2, 5, 4, 3))
        }

        // boolean primitive (since it has a specialized implementation)
        with(emptyImmutableBooleanArray()) {
            expectThat(sorted().referencesSameArrayAs(ImmutableBooleanArray.EMPTY))
                .isTrue()
        }

        val minBoolean = minOf(true, false)
        val maxBoolean = !minBoolean

        with(immutableArrayOf(minBoolean)) {
            expectThat(sorted().referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf(maxBoolean)) {
            expectThat(sorted().referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf(minBoolean, minBoolean)) {
            expectThat(sorted())
                .isEqualTo(immutableArrayOf(minBoolean, minBoolean))
        }

        with(immutableArrayOf(maxBoolean, maxBoolean)) {
            expectThat(sorted())
                .isEqualTo(immutableArrayOf(maxBoolean, maxBoolean))
        }

        with(immutableArrayOf(maxBoolean, minBoolean)) {
            expectThat(sorted())
                .isEqualTo(immutableArrayOf(minBoolean, maxBoolean))
        }

        // ensure same sorting behavior as sorting a List<Boolean>
        repeat(10) {
            val size = Random.nextInt(100)
            val immutableArray = ImmutableBooleanArray(size) { Random.nextBoolean() }

            expectThat(immutableArray.sorted().asList())
                .isEqualTo(immutableArray.asList().sorted())
        }
    }

    @Test
    fun `sortedDescending validation`() {
        // references
        with(immutableArrayOf("one")) {
            expectThat(sortedDescending().referencesSameArrayAs(this))
                .isTrue()
        }

        with(immutableArrayOf("dogs", "apples", "pineapples")) {
            expectThat(sortedDescending())
                .isEqualTo(immutableArrayOf("pineapples", "dogs", "apples"))

            // original is left unchanged
            expectThat(this)
                .isEqualTo(immutableArrayOf("dogs", "apples", "pineapples"))
        }

        // primitives
        with(immutableArrayOf(1)) {
            expectThat(sortedDescending().referencesSameArrayAs(this))
                .isTrue()
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
            .isA<ImmutableArray<String>>()
            .isEmpty()

        with(immutableArrayOf("one", "two")) {
            expectThat((emptyImmutableArray<String>() + this).referencesSameArrayAs(this))
                .isTrue()

            expectThat((this + emptyImmutableArray<String>()).referencesSameArrayAs(this))
                .isTrue()
        }

        expectThat(immutableArrayOf("a", "b", "c") + immutableArrayOf("d", "e"))
            .isEqualTo(immutableArrayOf("a", "b", "c", "d", "e"))

        expectThat(emptyImmutableIntArray() + emptyImmutableIntArray())
            .isA<ImmutableIntArray>()
            .isEmpty()

        with(immutableArrayOf(1, 2)) {
            expectThat((emptyImmutableIntArray() + this).referencesSameArrayAs(this))
                .isTrue()

            expectThat((this + emptyImmutableIntArray()).referencesSameArrayAs(this))
                .isTrue()
        }

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

            expectThat(this.toImmutableIntArray())
                .isA<ImmutableIntArray>()
                .containsExactly(1, 3, 5)
        }
    }

    @Test
    fun `primitive immutable array to generic ImmutableArray validation`() {
        with(immutableArrayOf(1, 3, 5)) {
            expectThat(this).isA<ImmutableIntArray>()

            expectThat(this.toTypedImmutableArray())
                .isA<ImmutableArray<Int>>()
                .containsExactly(1, 3, 5)
        }
    }

    @Test
    fun `requireNoNulls validation`() {
        with(immutableArrayOf<String?>("one", "two")) {
            expectThat(requireNoNulls())
                .isA<ImmutableArray<String>>()

            expectThat(requireNoNulls().referencesSameArrayAs(this))
                .isTrue()
        }

        expectThrows<IllegalArgumentException> {
            immutableArrayOf("one", null).requireNoNulls()
        }.message.isEqualTo("null element found in [one, null]")
    }

    @Test
    fun `flatten validation`() {
        // nested iterable
        with(
            immutableArrayOf(
                listOf("a", "b"),
                listOf("c", "d", "e"),
                emptyList(),
            ),
        ) {
            expectThat(flatten())
                .isEqualTo(immutableArrayOf("a", "b", "c", "d", "e"))
        }

        // nested generic array
        with(
            immutableArrayOf(
                immutableArrayOf("a", "b"),
                immutableArrayOf("c", "d", "e"),
                emptyImmutableArray(),
            ),
        ) {
            expectThat(flatten())
                .isEqualTo(immutableArrayOf("a", "b", "c", "d", "e"))
        }

        // nested primitive array
        with(
            immutableArrayOf(
                immutableArrayOf(1, 2),
                immutableArrayOf(3, 4, 5),
                emptyImmutableIntArray(),
            ),
        ) {
            expectThat(flatten())
                .isEqualTo(immutableArrayOf(1, 2, 3, 4, 5))
        }
    }
}

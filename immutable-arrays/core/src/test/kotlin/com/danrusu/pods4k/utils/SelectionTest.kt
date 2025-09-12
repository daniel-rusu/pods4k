package com.danrusu.pods4k.utils

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.hasSize
import strikt.assertions.isEmpty
import strikt.assertions.isEqualTo
import kotlin.random.Random

class SelectionTest {
    @Test
    fun `empty selection validation`() {
        with(Selection(numElements = 0) { false }) {
            expectThat(numElements).isEqualTo(0)
            expectThat(numSelectedElements).isEqualTo(0)

            val elements = mutableListOf<Int>()
            forEachSelectedIndex { elements.add(it) }
            expectThat(elements).isEmpty()
        }

        repeat(100) {
            val size = Random.nextInt(from = 0, until = 200)

            with(Selection(size) { false }) {
                expectThat(numElements).isEqualTo(size)
                expectThat(numSelectedElements).isEqualTo(0)

                val elements = mutableListOf<Int>()
                forEachSelectedIndex { elements.add(it) }
                expectThat(elements).isEmpty()
            }
        }
    }

    @Test
    fun `single selection validation`() {
        repeat(100) {
            val size = Random.nextInt(from = 1, until = 200)
            val selectedElement = Random.nextInt(from = 0, until = size)

            with(Selection(size) { it == selectedElement }) {
                expectThat(numElements).isEqualTo(size)
                expectThat(numSelectedElements).isEqualTo(1)

                val elements = mutableListOf<Int>()
                forEachSelectedIndex { elements.add(it) }
                expectThat(elements).hasSize(1)
                expectThat(elements.single()).isEqualTo(selectedElement)
            }
        }
    }

    @Test
    fun `multiple selection validation`() {
        repeat(100) {
            val size = Random.nextInt(from = 3, until = 200)
            val selectionSize = Random.nextInt(from = 2, until = size)
            val selectedElements = hashSetOf<Int>()
            while (selectedElements.size < selectionSize) {
                selectedElements += Random.nextInt(from = 0, until = selectionSize)
            }

            with(Selection(size) { it in selectedElements }) {
                expectThat(numElements).isEqualTo(size)
                expectThat(numSelectedElements).isEqualTo(selectionSize)

                val elements = mutableListOf<Int>()
                forEachSelectedIndex { elements.add(it) }
                expectThat(elements).hasSize(selectionSize)
                expectThat(elements.toSet()).isEqualTo(selectedElements)
            }
        }
    }

    @Test
    fun `every element selected validation`() {
        repeat(100) {
            val size = Random.nextInt(from = 1, until = 200)

            with(Selection(size) { true }) {
                expectThat(numElements).isEqualTo(size)
                expectThat(numSelectedElements).isEqualTo(size)

                val elements = mutableListOf<Int>()
                forEachSelectedIndex { elements.add(it) }
                expectThat(elements).isEqualTo((0..<size).toMutableList())
            }
        }
    }
}

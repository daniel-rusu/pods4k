package com.danrusu.pods4k.utils

@PublishedApi
internal const val ARRAY_ELEMENT_SIZE: Int = 32

@PublishedApi
internal val log2ArrayElementSize: Int = ARRAY_ELEMENT_SIZE - 1 - ARRAY_ELEMENT_SIZE.countLeadingZeroBits()

/** The number of elements at the beginning of the array that are used for storing metadata */
@PublishedApi
internal const val NUM_METADATA_ELEMENTS: Int = 2

/** Represents a selection of elements based on each element index */
@PublishedApi
@JvmInline
internal value class Selection private constructor(
    /**
     * Bitmap to efficiently keep track of the indices using a single bit per index.  This also stores some metadata
     * fields in the beginning of the array, such as the number of selected elements.
     */
    @PublishedApi
    internal val values: IntArray,
) {
    /** The number of elements that passed the selection predicate */
    var numSelectedElements: Int
        get() = values[0]
        private set(value) {
            values[0] = value
        }

    /** The total number of elements (selected and unselected) */
    @PublishedApi
    internal var numElements: Int
        get() = values[1]
        private set(value) {
            values[1] = value
        }

    /**
     * Creates a selection spanning [numElements] and keeps track which elements pass the selection [predicate].
     */
    constructor(numElements: Int, predicate: (index: Int) -> Boolean) : this(
        values = createBackingArray(numElements),
    ) {
        if (numElements == 0) return

        this.numElements = numElements

        var numOneBits = 0
        // the bit index into the current 32-bit int
        var bitIndex = -1 // start at -1 as it gets incremented right away in the loop
        var bitmapIndex = NUM_METADATA_ELEMENTS // skip over the metadata slots
        var currentBits = 0 // the current 32-bits with no elements yet
        for (index in 0..<numElements) {
            if (++bitIndex == ARRAY_ELEMENT_SIZE) {
                // reached the end of the current bits so store them and reset
                values[bitmapIndex++] = currentBits
                currentBits = 0
                bitIndex = 0
            }
            // jit turns this into a branchless operation
            val currentElement = if (predicate(index)) 1 else 0

            // conditionally increase the size without branching
            numOneBits += currentElement

            // conditionally include the current element without branching
            currentBits = currentBits or (currentElement shl bitIndex)
        }
        numSelectedElements = numOneBits

        // store the last set of partially-filled bits
        values[bitmapIndex] = currentBits
    }

    inline fun forEachSelectedIndex(body: (index: Int) -> Unit) {
        var originalIndex = 0
        // start iterating after the metadata elements
        for (i in NUM_METADATA_ELEMENTS..<values.size) {
            var bits = values[i]
            // iterate through the 1-bits
            while (bits != 0) {
                body(originalIndex + bits.countTrailingZeroBits())
                // clear last bit
                bits = bits and (bits - 1)
            }
            originalIndex += ARRAY_ELEMENT_SIZE
        }
    }

    inline fun forEachUnselectedIndex(body: (index: Int) -> Unit) {
        val numIndices = numElements
        val numSelectedIndices = numSelectedElements
        if (numSelectedIndices == numIndices) return

        var originalIndex = 0
        // start after the metadata elements and don't process the last element yet as that can have unused 0-bits
        for (i in NUM_METADATA_ELEMENTS..<values.size - 1) {
            // invert the bits so we can iterate through the 1-bits instead
            var bits = values[i].inv()
            while (bits != 0) {
                body(originalIndex + bits.countTrailingZeroBits())
                // clear last bit
                bits = bits and (bits - 1)
            }
            originalIndex += ARRAY_ELEMENT_SIZE
        }

        // process last element
        // bitwise mod optimization since ARRAY_ELEMENT_SIZE is a power of 2
        val numRemainingBits = numElements and (ARRAY_ELEMENT_SIZE - 1) // = numElements % ARRAY_ELEMENT_SIZE
        // for the mask, start with all 1-bits and zero out the unused bits
        val mask = -1 ushr (ARRAY_ELEMENT_SIZE - numRemainingBits)
        // invert the bits so we can iterate through the 1-bits instead
        var lastBits = values.last().inv() and mask
        while (lastBits != 0) {
            body(originalIndex + lastBits.countTrailingZeroBits())
            lastBits = lastBits and (lastBits - 1) // clear last bit
        }
    }
}

private fun createBackingArray(numElements: Int): IntArray {
    // Divide numElements by ARRAY_ELEMENT_SIZE rounding up
    val bitmapSize = (numElements + ARRAY_ELEMENT_SIZE - 1) ushr log2ArrayElementSize
    return IntArray(NUM_METADATA_ELEMENTS + bitmapSize) // also allow space for the metadata fields
}

// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Int
import kotlin.PublishedApi
import kotlin.Short
import kotlin.ShortArray
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline

@JvmInline
public value class ImmutableShortArray @PublishedApi internal constructor(
  private val values: ShortArray,
) {
  public val size: Int
    get() = values.size

  /**
   * Returns the element at the specified [index]. This method can be called using the index
   * operator.
   */
  public operator fun `get`(index: Int): Short = values[index]

  /**
   * Creates an iterator allowing iteration over the elements of the array.
   */
  public operator fun iterator(): Iterator<Short> = values.iterator()

  public companion object {
    /**
     * Creates a ImmutableShortArray instance of the specified [size], where each element is
     * calculated by calling the specified [init] function.
     *
     * [init] is called sequentially starting at index 0 to initialize the array with each element
     * at its given index.
     *
     * Implementation:
     * We're using the invoke method instead of a regular constructor so that we can declare it
     * inline.  The call site will look like a regular constructor call.
     */
    public inline operator fun invoke(size: Int, `init`: (index: Int) -> Short):
        ImmutableShortArray {
      val backingArray = ShortArray(size) { index -> init(index) }
      return ImmutableShortArray(backingArray)
    }
  }
}

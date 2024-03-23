// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.BooleanArray
import kotlin.Int
import kotlin.PublishedApi
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline

@JvmInline
public value class ImmutableBooleanArray @PublishedApi internal constructor(
  private val values: BooleanArray,
) {
  public val size: Int
    get() = values.size

  /**
   * Returns the element at the specified [index]. This method can be called using the index
   * operator.
   */
  public operator fun `get`(index: Int): Boolean = values[index]

  /**
   * Creates an iterator allowing iteration over the elements of the array.
   */
  public operator fun iterator(): Iterator<Boolean> = values.iterator()

  public companion object {
    /**
     * Creates a ImmutableBooleanArray instance of the specified [size], where each element is
     * calculated by calling the specified [init] function.
     *
     * [init] is called sequentially starting at index 0 to initialize the array with each element
     * at its given index.
     *
     * Implementation:
     * We're using the invoke method instead of a regular constructor so that we can declare it
     * inline.  The call site will look like a regular constructor call.
     */
    public inline operator fun invoke(size: Int, `init`: (index: Int) -> Boolean):
        ImmutableBooleanArray {
      val backingArray = BooleanArray(size) { index -> init(index) }
      return ImmutableBooleanArray(backingArray)
    }
  }
}

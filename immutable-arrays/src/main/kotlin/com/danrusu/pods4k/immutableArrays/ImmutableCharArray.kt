// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Char
import kotlin.CharArray
import kotlin.Int
import kotlin.PublishedApi
import kotlin.String
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline

@JvmInline
public value class ImmutableCharArray @PublishedApi internal constructor(
  private val values: CharArray,
) {
  public val size: Int
    get() = values.size

  override fun toString(): String = values.joinToString(prefix = "[", postfix = "]")

  /**
   * Returns the element at the specified [index]. This method can be called using the index
   * operator.
   */
  public operator fun `get`(index: Int): Char = values[index]

  /**
   * Creates an iterator allowing iteration over the elements of the array.
   */
  public operator fun iterator(): Iterator<Char> = values.iterator()

  public companion object {
    /**
     * Creates a ImmutableCharArray instance of the specified [size], where each element is
     * calculated by calling the specified [init] function.
     *
     * [init] is called sequentially starting at index 0 to initialize the array with each element
     * at its given index.
     *
     * Implementation:
     * We're using the invoke method instead of a regular constructor so that we can declare it
     * inline.  The call site will look like a regular constructor call.
     */
    public inline operator fun invoke(size: Int, `init`: (index: Int) -> Char): ImmutableCharArray {
      val backingArray = CharArray(size) { index -> init(index) }
      return ImmutableCharArray(backingArray)
    }
  }
}

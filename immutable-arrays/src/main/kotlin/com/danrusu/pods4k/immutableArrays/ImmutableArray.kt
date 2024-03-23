// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Any
import kotlin.Array
import kotlin.Int
import kotlin.PublishedApi
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline

@JvmInline
public value class ImmutableArray<T> @PublishedApi internal constructor(
  private val values: Array<Any?>,
) {
  public val size: Int
    get() = values.size

  override fun toString(): String = values.joinToString(prefix = "[", postfix = "]")

  /**
   * Returns the element at the specified [index]. This method can be called using the index
   * operator.
   */
  @Suppress("UNCHECKED_CAST")
  public operator fun `get`(index: Int): T = values[index] as T

  /**
   * Creates an iterator allowing iteration over the elements of the array.
   */
  @Suppress("UNCHECKED_CAST")
  public operator fun iterator(): Iterator<T> = values.iterator() as Iterator<T>

  public companion object {
    /**
     * Creates a ImmutableArray instance of the specified [size], where each element is calculated
     * by calling the specified [init] function.
     *
     * [init] is called sequentially starting at index 0 to initialize the array with each element
     * at its given index.
     *
     * Implementation:
     * We're using the invoke method instead of a regular constructor so that we can declare it
     * inline.  The call site will look like a regular constructor call.
     */
    public inline operator fun <T> invoke(size: Int, `init`: (index: Int) -> T): ImmutableArray<T> {
      val backingArray = Array<Any?>(size) { index -> init(index) }
      return ImmutableArray(backingArray)
    }
  }
}

// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Any
import kotlin.Array
import kotlin.Boolean
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

  /**
   * Returns the index of the last element or -1 if the array is empty.
   */
  public val lastIndex: Int
    get() = values.size - 1

  override fun toString(): String = values.joinToString(prefix = "[", postfix = "]")

  public fun isEmpty(): Boolean = values.isEmpty()

  public fun isNotEmpty(): Boolean = values.isNotEmpty()

  /**
   * Returns the element at the specified [index]. This method can be called using the index
   * operator.
   */
  @Suppress("UNCHECKED_CAST")
  public operator fun `get`(index: Int): T = values[index] as T

  public operator fun component1(): T = get(0)

  public operator fun component2(): T = get(1)

  public operator fun component3(): T = get(2)

  public operator fun component4(): T = get(3)

  public operator fun component5(): T = get(4)

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

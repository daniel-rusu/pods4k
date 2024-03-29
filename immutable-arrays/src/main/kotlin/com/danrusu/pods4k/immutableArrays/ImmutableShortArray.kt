// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Int
import kotlin.PublishedApi
import kotlin.Short
import kotlin.ShortArray
import kotlin.String
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline

@JvmInline
public value class ImmutableShortArray @PublishedApi internal constructor(
  private val values: ShortArray,
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
  public operator fun `get`(index: Int): Short = values[index]

  public operator fun component1(): Short = get(0)

  public operator fun component2(): Short = get(1)

  public operator fun component3(): Short = get(2)

  public operator fun component4(): Short = get(3)

  public operator fun component5(): Short = get(4)

  /**
   * Returns the first element.
   *
   * @throws NoSuchElementException if the array is empty.
   */
  public fun first(): Short {
    if (isEmpty()) throw NoSuchElementException("Array is empty!")

    return get(0)
  }

  /**
   * Returns the last element.
   *
   * @throws NoSuchElementException if the array is empty.
   */
  public fun last(): Short {
    if (isEmpty()) throw NoSuchElementException("Array is empty!")

    return get(lastIndex)
  }

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

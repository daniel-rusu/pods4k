// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.BooleanArray
import kotlin.Int
import kotlin.PublishedApi
import kotlin.String
import kotlin.Unit
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline

@JvmInline
public value class ImmutableBooleanArray @PublishedApi internal constructor(
  private val values: BooleanArray,
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
  public operator fun `get`(index: Int): Boolean = values[index]

  public operator fun component1(): Boolean = get(0)

  public operator fun component2(): Boolean = get(1)

  public operator fun component3(): Boolean = get(2)

  public operator fun component4(): Boolean = get(3)

  public operator fun component5(): Boolean = get(4)

  /**
   * Returns the single element from the array, or throws an exception if the array is empty or has
   * more than one element.
   */
  public fun single(): Boolean = when (size) {
      0 -> throw NoSuchElementException("Array is empty!")
      1 -> get(0)
      else -> throw IllegalArgumentException("Array has more than one element!")
  }

  /**
   * Returns the first element.
   *
   * @throws NoSuchElementException if the array is empty.
   */
  public fun first(): Boolean {
    if (isEmpty()) throw NoSuchElementException("Array is empty!")

    return get(0)
  }

  /**
   * Returns the last element.
   *
   * @throws NoSuchElementException if the array is empty.
   */
  public fun last(): Boolean {
    if (isEmpty()) throw NoSuchElementException("Array is empty!")

    return get(lastIndex)
  }

  /**
   * Creates an iterator allowing iteration over the elements of the array.
   */
  public operator fun iterator(): Iterator<Boolean> = values.iterator()

  /**
   * Performs the specified [action] on each element sequentially starting with the first element
   */
  public inline fun forEach(action: (element: Boolean) -> Unit) {
    for (value in this) {
        action(value)
    }
  }

  /**
   * Performs the specified [action] on each element sequentially starting with the first element
   */
  public inline fun forEachIndexed(action: (index: Int, element: Boolean) -> Unit) {
    for (index in 0..lastIndex) {
        action(index, get(index))
    }
  }

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

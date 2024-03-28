// Auto-generated file. DO NOT EDIT!
package com.danrusu.pods4k.immutableArrays

import kotlin.Boolean
import kotlin.Double
import kotlin.DoubleArray
import kotlin.Int
import kotlin.PublishedApi
import kotlin.String
import kotlin.collections.Iterator
import kotlin.jvm.JvmInline

@JvmInline
public value class ImmutableDoubleArray @PublishedApi internal constructor(
  private val values: DoubleArray,
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
  public operator fun `get`(index: Int): Double = values[index]

  /**
   * Returns the first element.
   *
   * @throws NoSuchElementException if the array is empty.
   */
  public fun first(): Double {
    if (isEmpty()) throw NoSuchElementException("Array is empty!")

    return get(0)
  }

  public operator fun component1(): Double = get(0)

  public operator fun component2(): Double = get(1)

  public operator fun component3(): Double = get(2)

  public operator fun component4(): Double = get(3)

  public operator fun component5(): Double = get(4)

  /**
   * Creates an iterator allowing iteration over the elements of the array.
   */
  public operator fun iterator(): Iterator<Double> = values.iterator()

  public companion object {
    /**
     * Creates a ImmutableDoubleArray instance of the specified [size], where each element is
     * calculated by calling the specified [init] function.
     *
     * [init] is called sequentially starting at index 0 to initialize the array with each element
     * at its given index.
     *
     * Implementation:
     * We're using the invoke method instead of a regular constructor so that we can declare it
     * inline.  The call site will look like a regular constructor call.
     */
    public inline operator fun invoke(size: Int, `init`: (index: Int) -> Double):
        ImmutableDoubleArray {
      val backingArray = DoubleArray(size) { index -> init(index) }
      return ImmutableDoubleArray(backingArray)
    }
  }
}

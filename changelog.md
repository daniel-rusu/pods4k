Change Log
==========

## Unreleased

_Date TBD_

### Immutable Arrays

**New Features:**

* Add `addAll(sequence)` to the immutable array builders
* Add `indexOf(element)` extension function
* Add `contains` operator

## 0.3.0

_2024-07-29_

### Immutable Arrays

**Breaking Changes:**

* Factory functions (like `emptyImmutableArray`, `immutableArrayOf`, `buildImmutableArray`, etc.) have been moved
  to `ImmutableArrayFactory.kt` to improve code organization

**New Features:**

* Add `flatMapIndexed` specializations
* Add `flatMap` specializations
* Add `partition` method
* Add `asList` method
* Add `MutableCollection.addAll(immutableArray)` extension function
* Add `+` operator overload for concatenating an immutable array with an additional value
* Add `+` operator overload for concatenating two immutable arrays
* Add `count(predicate)` method
* Add `none(predicate)` method
* Add `any(predicate)` method
* Add `all(predicate)` method

**Performance Improvements:**

* Reduce the memory usage of converting immutable arrays to lists by adding all the elements in a single step
* Return `EMPTY` singleton when converting an empty regular array to an immutable array
* Immutable array builders: Avoid copying the backing array when the final size matches the array size

## 0.2.0

_2024-07-16_

### Immutable Arrays

**Breaking Changes:**

* Extension functions `toImmutableIntArray`, `toImmutableFloatArray`, etc. have been renamed
  to `toImmutableArray` so that the most efficient primitive variant is chosen by default.

**New Features:**

* Add `sortedByDescending` method
* Add `sortedBy` method
* Add `sortedDescending` extension functions
* Add `sortedWith` method
* Add `sorted` extension functions
* Add `mapIndexedNotNull` specializations
* Add `mapNotNull` specializations
* Add dynamic factory functions (eg. `buildImmutableArray`, `buildImmutableBooleanArray` etc.) for when the size
  isn't known in advance
* Add builders for constructing immutable arrays when the size isn't known in advance
* Add `mapIndexed` specializations
* Add `map` specializations

**Performance Improvements:**

* Use System.arraycopy in `immutableArrayOf` factory functions
* Use System.arraycopy when creating immutable arrays from regular arrays

## 0.1.0

_2024-06-16_

### Immutable Arrays

* New: Add declaration-site variance so that a variable of type ImmutableArray\<Parent> can accept an
  ImmutableArray\<Child> when Child extends Parent
* New: Add `equals` & `hashCode` methods
* New: Add Sequence `toImmutableArray` extension functions
* New: Add ImmutablePrimitiveArray `toTypedImmutableArray` extension functions
* New: Add generic ImmutableArray `toImmutablePrimitiveArray` extension functions
* New: Add Iterable `toImmutableArray` extension functions
* New: Add regular array `toImmutableArray` extension functions
* New: Add `emptyImmutableArray` & `emptyImmutablePrimitiveArray` factory functions
* New: Add `immutableArrayOf` factory functions
* New: Add `singleOrNull(predicate)` method
* New: Add `singleOrNull` method
* New: Add `single(predicate)` method
* New: Add `lastOrNull(predicate)` method
* New: Add `firstOrNull(predicate)` method
* New: Add `last(predicate)` method
* New: Add `first(predicate)` method
* New: Add `withIndex` method
* New: Add `asIterable` method
* New: Add `getOrElse` extension function
* New: Add `lastOrNull` method
* New: Add `firstOrNull` method
* New: Add `getOrNull` method
* New: Add `toMutableList` extension function
* New: Add `toList` method
* New: Add `asSequence` method
* New: Add `indices` property
* New: Add `forEachIndexed` method
* New: Add `forEach` method
* New: Add `single` method
* New: Add `last` method
* New: Add `first` method
* New: Add `componentN` functions for destructuring
* New: Add `isEmpty` & `isNotEmpty` methods
* New: Add `lastIndex` property
* New: Add `toString` method
* New: Add `iterator` operator to allow regular for-loops
* New: Add `invoke` factory function
* New: Create `ImmutableArray` + 8 variants for each primitive type

Change Log
==========

## Unreleased

### Immutable Arrays

**Breaking Changes:**

* Extension functions `toImmutableIntArray`, `toImmutableFloatArray`, etc. have been renamed
  to `toImmutableArray` so that the most efficient primitive variant is chosen by default.

**New Features:**

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

* Optimized `immutableArrayOf` factory functions
* Optimized the creation of immutable arrays from regular arrays

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

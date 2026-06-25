# Performance Invariants

The library sells performance and memory efficiency. Treat performance behavior as part of the API for core immutable-array operations.

## Allocation-Sensitive Areas

- `ImmutableArray*` value classes and their public inline delegating functions.
- Builders and `BuilderUtils.computeNewCapacity`.
- Copy operations: `take`, `takeLast`, `drop`, `dropLast`, `windowed`, `chunked`, `plus`, factory/copy functions.
- Conditional copy operations: `filter`, `filterIndexed`, `filterNot`, `partition`, and `Selection`.
- Transformations: `map`, `mapIndexed`, `mapNotNull`, `flatMap`, `zip`, `unzip`.
- Conversion functions in `transformations-to-standard-collections` allocate by design; do not use them internally as shortcuts for core operations.

## Primitive Specialization Requirements

- Keep all 8 primitive immutable arrays aligned with the generic variant unless a generator path intentionally differs.
- Lambda-return overloads should preserve primitive result binding, for example mapping to `Int` should produce `ImmutableIntArray`.
- Avoid generic helpers on primitive hot paths if they force values through `Any`, nullable wrappers, `Iterable<T>`, or `Array<T>`.
- Tests that assert primitive JVM classes are meaningful; do not replace them with generic helper checks that box values.

## Boxing Risks

- Passing primitives through generic functions, `Any`, nullable types, `Iterable<Int>`, `List<Int>`, `Array<Int>`, or generic lambdas can box.
- `asList`, `asIterable`, `asSequence`, and standard collection conversions may be convenient but can change allocation and boxing behavior.
- `toTypedArray()` on primitive arrays boxes; existing uses should be treated as deliberate and reviewed before expanding.
- Value classes can box when treated as `Any` or generic values; equality/reference tests cover some of this behavior.

## Hot-Path Coding Constraints

- Preserve `inline` on simple delegating functions unless there is local evidence that non-inline is faster.
- Prefer counted loops, primitive arrays, exact-size result allocation, and bulk copies where current code does.
- Keep early exits for empty, singleton, full-selection, and unchanged results.
- Avoid intermediate `List`, `MutableList`, `Sequence`, or builder growth when the final size is known or cheaply knowable.
- Keep bitmap-based `Selection` behavior branch-conscious; metadata slots and bit iteration are part of the design.
- Do not replace specialized generated overloads with one generic implementation just to reduce code size.

## When Benchmark Evidence Is Required

- Changing algorithms for filter/partition/map/flatMap/zip/unzip/sort/copy/build operations.
- Adding or removing intermediate allocations on common operations.
- Replacing primitive-specialized code with generic abstractions.
- Changing `inline` decisions on public hot-path functions.
- Changing builder capacity growth or exact-size allocation strategies.

## Cleaner-Looking Patterns That May Regress

- Implementing operations via `asList().map/filter/...`.
- Returning `List` or `Iterable` internally and converting back to immutable arrays.
- Sharing a generic helper across primitive variants.
- Using `Sequence` pipelines for eager array transformations.
- Building results by repeated `plus` or by growing a collection when the size is known.
- Removing `@JvmName` or overload-resolution annotations from generated overloads.

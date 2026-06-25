# Architecture

## Core Abstractions

- `ImmutableArray<T>` is the generic immutable array wrapper.
- `ImmutableBooleanArray`, `ImmutableByteArray`, `ImmutableCharArray`, `ImmutableShortArray`, `ImmutableIntArray`, `ImmutableLongArray`, `ImmutableFloatArray`, and `ImmutableDoubleArray` are primitive-specialized wrappers.
- Wrappers are generated as `@JvmInline value class` types over backing arrays.
- Constructors and backing arrays are internal, with `@PublishedApi internal` used where public inline functions need access.
- Builders are append-only and produce immutable arrays; they are documented as not thread-safe.
- `Selection` is a manual bitmap-based helper for filter/partition-style operations.

## Source-Set And Module Layout

- Root project: common Gradle setup, Spotless, explicit API, code generation task wiring.
- `buildSrc`: local Gradle plugin plus KotlinPoet generator code. It targets JVM 11.
- `immutable-arrays`: parent project for immutable array modules.
- `immutable-arrays/core`: published core APIs and implementation. It targets JVM 11 through root configuration.
- `immutable-arrays/transformations-to-standard-collections`: conversions to Kotlin/JDK collection types; depends on `immutable-arrays/core`.
- `publishing/aggregator` and `publishing/bom`: publication support modules.

## Generated-Code Model

- The root build applies `id("pods4k-code-generator")`.
- `CodeGenerator` registers `generateCode`.
- Generators write directly to checked-in `src/main/kotlin` directories.
- Generated files start with `// Auto-generated file. DO NOT EDIT!`.
- `generateCode` runs `spotlessApply` afterward.
- CI runs a generation check that fails if `generateCode` produces uncommitted diffs.

## Public API Shape

- APIs live under `com.danrusu.pods4k.immutableArrays`.
- Public construction is through factories such as `immutableArrayOf`, `emptyImmutableIntArray`, `buildImmutableArray`, and value-class companion `invoke`/`copyFrom` functions.
- Operations generally mirror Kotlin array/list naming while returning immutable arrays instead of mutable/read-only lists.
- Multiplicative operations bind lambda return types to the most specific immutable array type, including primitive results.
- Some overloads use `@OverloadResolutionByLambdaReturnType` and `@JvmName`; these affect source and bytecode compatibility.

## Important Invariants

- Immutable array contents cannot be reassigned through the public API.
- Empty results usually reuse `EMPTY`; unchanged full-range results often return `this`.
- Operations on immutable arrays should return immutable arrays unless the function is explicitly a transformation to standard collections.
- Primitive operations should use primitive backing arrays and primitive iterator/value paths where possible.
- Bulk copying with `System.arraycopy`, `copyOf`, or exact-size constructors is preferred where existing code uses it.
- Equality and `referencesSameArrayAs` intentionally handle value-class boxing/reference concerns.

## Boundaries

- Manual code: `Selection.kt`, tests, docs, Gradle build logic, generator implementation.
- Generated code: immutable array classes, factories, extension files, multiplicative specialization files, standard-collection transformation files.
- Tests: JUnit 5 plus Strikt under module `src/test/kotlin`.
- Benchmarks: not executable in this repo; in-repo benchmark docs point to `pods4k-benchmarks`.

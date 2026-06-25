# Context Map

Use this map to find the right files before editing. Generated files are checked in, but their source of truth is usually under `buildSrc`.

## Repository Setup

- Files/directories: `settings.gradle.kts`, `build.gradle.kts`, `gradle.properties`, `gradle/libs.versions.toml`, `.github/workflows/*.yml`.
- Boundaries: root Gradle config applies Kotlin JVM, explicit API mode, warnings-as-errors for non-test Kotlin, Spotless, and the local code generator plugin.
- Verify: `.\gradlew.bat build --no-daemon`, `.\gradlew.bat spotlessCheck`.
- Pitfalls: The README doesn't usually mention unreleased changes.  For example, the minimum Kotlin support might refer to the last release rather than the current mainline.

## Code Generation

- Files/directories: `buildSrc/src/main/kotlin/com/danrusu/pods4k/CodeGenerator.kt`, `buildSrc/src/main/kotlin/com/danrusu/pods4k/immutableArrays`, `buildSrc/src/main/kotlin/com/danrusu/pods4k/utils`.
- Generated outputs:
  - `immutable-arrays/core/src/main/kotlin/com/danrusu/pods4k/immutableArrays/*.kt`
  - `immutable-arrays/core/src/main/kotlin/com/danrusu/pods4k/immutableArrays/multiplicativeSpecializations/*.kt`
  - `immutable-arrays/transformations-to-standard-collections/src/main/kotlin/com/danrusu/pods4k/immutableArrays/*.kt`
- Verify: `.\gradlew.bat generateCode --no-daemon`, then check the diff.
- Pitfalls: changing only generated files will be overwritten; changing a generator can affect many public overloads.

## Immutable Array Core API

- Files/directories: generated `ImmutableArray.kt`, `ImmutableIntArray.kt`, other primitive immutable arrays, `ImmutableArrayFactory.kt`, `Arrays.kt`, `Collections.kt`, `Sequences.kt`, `ImmutableArrays.kt`.
- Source boundary: generated from `ImmutableArrayGenerator`, `ImmutableArrayFactoryGenerator`, and extension generators.
- Tests: `immutable-arrays/core/src/test/kotlin/com/danrusu/pods4k/immutableArrays/ImmutableArrayTest.kt`, `ImmutableIntArrayTest.kt`, factory/array/collection/sequence tests, and `TESTING-STRATEGY.md`.
- Pitfalls: generic `ImmutableArray<T>` and primitive variants need consistent behavior; tests intentionally emphasize generic plus `ImmutableIntArray` unless a generator path is special-cased.

## Multiplicative Specializations

- Files/directories: generated `multiplicativeSpecializations/*.kt`.
- Source boundary: generated from `buildSrc/.../core/multiplicativeSpecializations/*Generator.kt`.
- Tests: `immutable-arrays/core/src/test/kotlin/com/danrusu/pods4k/immutableArrays/multiplicativeSpecializations/*Test.kt`.
- Pitfalls: operations such as `map`, `mapIndexed`, `mapNotNull`, `flatMap`, `zip`, and `unzip` multiply across generic plus 8 primitive base types.

## Manual Utility Code

- Files/directories: `immutable-arrays/core/src/main/kotlin/com/danrusu/pods4k/utils/Selection.kt`.
- Source boundary: manual source; no generated header.
- Tests: `immutable-arrays/core/src/test/kotlin/com/danrusu/pods4k/utils/SelectionTest.kt`, plus filter/partition tests that exercise it indirectly.
- Pitfalls: bitmap metadata layout and branch-sensitive loops are performance-sensitive.

## Standard Collection Transformations

- Files/directories: generated `TransformationsToList.kt`, `TransformationsToSet.kt`, `TransformationsToMap.kt`.
- Source boundary: generated from `buildSrc/.../immutableArraysToStandardCollections/*FileGenerator.kt`.
- Tests: `immutable-arrays/transformations-to-standard-collections/src/test/kotlin/...`.
- Pitfalls: conversions intentionally allocate standard mutable/read-only collections; do not copy these patterns back into immutable-array hot paths.

## Publishing

- Files/directories: `publishing`, `publishing/aggregator`, `publishing/bom`, `RELEASING.md`.
- Boundaries: publishing metadata and module aggregation; avoid touching unless the task is release or artifact related.
- Verify: Needs human review for release-specific commands and credentials.
- Pitfalls: artifact names and module coordinates are public API for consumers.

## Benchmarks And Performance Docs

- Files/directories: `immutable-arrays/BENCHMARKS.md`, `immutable-arrays/resources/benchmarks`, `immutable-arrays/resources/memory`.
- Boundary: benchmark results are documented here; executable JMH benchmarks are documented as living in `https://github.com/daniel-rusu/pods4k-benchmarks`.
- Verify: see `benchmark-workflow.md`.
- Pitfalls: do not claim benchmark improvements from local tests or intuition.

# AI/Codex Guidance

pods4k is a performance-oriented Kotlin library. The current repository centers on immutable array data structures that provide list-like APIs while preserving immutability, primitive specialization, and low allocation overhead.

## Important Directories

- `immutable-arrays/core`: core immutable array APIs, implementation, and tests.
- `immutable-arrays/transformations-to-standard-collections`: conversions from immutable arrays to standard collections.
- `buildSrc/src/main/kotlin/com/danrusu/pods4k`: local `pods4k-code-generator` Gradle plugin and KotlinPoet generators.
- `publishing`: aggregator and BOM publishing modules.
- `immutable-arrays/resources`: benchmark and memory-layout images used by docs.
- `docs/ai`: repo-specific AI guidance.

## Commands

- Build and test like CI: `.\gradlew.bat build --no-daemon`
- Run tests only: `.\gradlew.bat test --no-daemon`
- Format Kotlin and Gradle Kotlin DSL: `.\gradlew.bat spotlessApply`
- Check formatting: `.\gradlew.bat spotlessCheck`
- Regenerate checked-in generated sources: `.\gradlew.bat generateCode --no-daemon`

Use `./gradlew` instead of `.\gradlew.bat` on Unix-like shells.

## Generated Code Rules

- Do not manually edit files starting with `// Auto-generated file. DO NOT EDIT!`.
- Change the relevant generator under `buildSrc`, then run `generateCode`.
- Include generated output when generator changes affect checked-in sources.
- `generateCode` is finalized by `spotlessApply`; expect formatting changes in generated Kotlin.

## Kotlin/API Conventions

- Kotlin explicit API mode is enabled; public/internal declarations need explicit visibility and public API types.
- Main project and `buildSrc` JVM targets are 11.
- The API uses `@JvmInline value class` wrappers around backing arrays plus `@PublishedApi internal` access where inline public functions need backing access.
- Keep public factories and overloads aligned across generic and primitive immutable array types.

## Performance-Sensitive Constraints

- Primitive specializations are a core feature, not an implementation detail to simplify away.
- Avoid changes that introduce unnecessary boxing for primitives, or extra temporary collections.
- Preserve fast paths that return `this` or shared empty instances when results are unchanged or empty.
- See [performance-invariants.md](docs/ai/performance-invariants.md) before changing generated operations, builders, filtering, mapping, or flat-mapping.

## Public API Compatibility Cautions

- Public types and extension functions are published artifacts; treat signatures, overload resolution, package names, and `@JvmName` values as compatibility-sensitive.
- README documents Java interop limitations for Kotlin compiler-specific techniques; do not assume Java-callable API shape without checking bytecode or tests.

## Done Means

- Relevant source or generator changes are made in the right boundary.
- Generated sources are current after generator changes.
- Tests relevant to the touched module pass, or any skipped verification is reported.
- Formatting is applied or checked.
- Performance-sensitive changes include benchmark evidence or an explicit note that benchmarks were not run.
- No unrelated code changes are included.

## More Guidance

- [Context map](docs/ai/context-map.md)
- [Architecture](docs/ai/architecture.md)
- [Performance invariants](docs/ai/performance-invariants.md)
- [Code review checklist](docs/ai/code-review.md)

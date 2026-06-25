# Code Review Checklist

Use this for reviewing Codex-generated changes. Prioritize correctness, compatibility, generated-code consistency, and performance regressions.

## API Compatibility

- Public package names, class names, function names, parameters, return types, visibility, and overloads are unchanged unless intended.
- `@JvmName`, `@JvmInline`, `@PublishedApi`, `inline`, variance, and overload-resolution annotations are preserved or deliberately changed.
- Public operations still return immutable arrays except explicit standard-collection transformation APIs.

## Generated-Code Consistency

- Files with `// Auto-generated file. DO NOT EDIT!` were changed through `buildSrc` generators.
- `generateCode` was run after generator changes.
- Generated output is consistent across generic plus Boolean, Byte, Char, Short, Int, Long, Float, and Double variants.
- Multiplicative specialization output is consistent across source and target base-type combinations.

## Primitive Specialization

- Primitive arrays remain backed by primitive JVM arrays.
- Mapping to primitive lambda return types still produces primitive immutable arrays.
- New helpers do not route primitive values through generic, nullable, `Any`, `List`, `Iterable`, `Sequence`, or `Array<Int>`-style paths unless intentional and measured.
- Tests that check primitive behavior avoid helper functions that would box before assertion.

## Allocations And Boxing

- Empty and unchanged-result fast paths still return `EMPTY` or `this` where expected.
- Known-size results allocate exact-size arrays or use existing bulk-copy patterns.
- Builders are not used where a final size is already known unless there is a reason.
- No new intermediate standard collections appear in core hot paths.
- No new repeated resizing or per-element copying replaces existing bulk operations.

## Tests

- Behavior changes have tests in the relevant module.
- Generated operation changes inspect generic `ImmutableArray` and `ImmutableIntArray` coverage per `TESTING-STRATEGY.md`, plus any special-case generator paths.
- Multiplicative specialization changes update or add tests under `multiplicativeSpecializations`.
- Manual `Selection` changes include direct `SelectionTest` coverage and indirect filter/partition behavior where relevant.

## Benchmarks

- Benchmark-sensitive changes either include current benchmark evidence or clearly state benchmarks were not run.
- Benchmark claims cite the command, environment, baseline, changed commit, and result interpretation.
- External benchmark repo usage is explicit.

## Documentation

- README, module README files, `BENCHMARKS.md`, and AI docs are updated when behavior, commands, or public API guidance changes.
- Performance claims are not strengthened without benchmark evidence.
- Generated-code rules remain visible when generator workflows change.

## Gradle And Source Sets

- Module dependencies remain minimal and directional, for example transformations depend on core.
- Root compiler settings still apply: JVM 11, explicit API, warnings-as-errors for non-test Kotlin.
- Spotless target/excludes still avoid build outputs.

# Aggregator

Each module of this library is published as a separate artifact to maven central. To simplify dependency management for
users, the aggregator creates a top-level `pods4k` artifact which includes compile dependencies to all the artifacts in
this library. When adding a dependency to the top-level `pods4k` artifact, that will automatically bring in all the
other artifacts of this library.

Adding a dependency to this top-level artifact is described in
the [installation instructions](../../README.md#installation).

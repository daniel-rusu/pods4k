# Code Generation

This module defines the local `pods4k-code-generator` Gradle plugin for the auto-generated portions of this library.
This increases the safety of the library and reduces defects by using a single code path to generate capabilities that
are mostly duplicates aside from their types, such as when creating specializations for each of the 8 base types. Note
that some capabilities are multiplicative so if each of the 8 primitive immutable array types needs a capability
that's specialized for each of the 8 base types again (like the `map` function) then we have 64 variations of this
capability.

Auto-generating this type of code significantly reduces the maintenance overhead and risk as we only need to modify one
place and have all the specializations generated instead of manually maintaining multiple variations.

## Regenerating Sources

Generated sources are checked in. Do not manually edit files that start with:

```kotlin
// Auto-generated file. DO NOT EDIT!
```

Change the relevant generator in `buildSrc`, then run:

```shell
./gradlew generateCode --no-daemon
```

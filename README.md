# pods4k [![Build Status](https://img.shields.io/github/actions/workflow/status/daniel-rusu/pods4k/ci.yml?branch=main&label=CI&logo=github)](https://github.com/daniel-rusu/pods4k/actions/workflows/ci.yml?query=branch%3Amain++)

## Performance-oriented data structures for Kotlin

A collection of performance-oriented data structures providing performance and efficiency that might appear to be
impossible at first glance.

If you're enjoying this library, please give it
a [![GitHub stars](https://img.shields.io/github/stars/daniel-rusu/pods4k?label=Star)](https://github.com/daniel-rusu/pods4k)
and share it with others.

## Dependency

**Gradle:**

```kotlin
dependencies {
    implementation("com.danrusu.pods4k:pods4k:0.5.0")
}
```

**Maven:**

```xml

<dependency>
    <groupId>com.danrusu.pods4k</groupId>
    <artifactId>pods4k</artifactId>
    <version>0.5.0</version>
</dependency>
```

Alternatively, you can [pick & choose](publishing/bom/README.md) individual components of this library.

## Immutable Arrays

[Immutable Arrays](immutable-arrays/README.md) are a safer and more efficient alternative to read-only lists while
maintaining familiar operations. Immutable arrays are up to 12X faster than lists and use up to 32X less memory!

Unlike regular arrays, the elements cannot be re-assigned, so immutable arrays can be safely shared without needing
immutable collections:

```kotlin
val names = immutableArrayOf("Dan", "Bob")
println(names[0]) // "Dan"

names[1] = "Jane" // Compile error: No set method providing array access
```

Immutable arrays are also more efficient than regular arrays as most transformation operations on arrays generate lists:

```kotlin
// This generates a List<Int> when the `people` variable is an Array<Person>
// but generates an ImmutableIntArray when `people` variable is an ImmutableArray<Person>
val ages = people.map { it.age }
```

See [Immutable Arrays](immutable-arrays/README.md) for more specifics along with a
detailed comparison against regular arrays, read-only lists, and immutable lists.

## Minimum Requirements

* Kotlin 1.9.25
* JDK 11
    * Automated tests are run on JDK LTS releases 11, 17, & 21

## Java Compatibility

Some data structures use techniques which are only supported by the Kotlin compiler. While they can be used in a mixed
Java & Kotlin codebase to store one of these data structures in a Java-defined collection, referencing these data
structures by their class name is only supported within Kotlin files.

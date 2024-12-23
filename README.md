# pods4k [![Build Status](https://img.shields.io/github/actions/workflow/status/daniel-rusu/pods4k/ci.yml?branch=main&label=CI&logo=github)](https://github.com/daniel-rusu/pods4k/actions/workflows/ci.yml?query=branch%3Amain++)

## Performance-oriented data structures for Kotlin

A collection of performance-oriented data structures providing performance and efficiency that might appear to be
impossible at first glance.

If you find this library useful, please consider giving it
a [![GitHub stars](https://img.shields.io/github/stars/daniel-rusu/pods4k?label=Star)](https://github.com/daniel-rusu/pods4k)
on [GitHub](https://github.com/daniel-rusu/pods4k) and sharing it with others.

## Dependency

**Gradle:**

```kotlin
dependencies {
    implementation("com.danrusu.pods4k:pods4k:0.6.0")
}
```

**Maven:**

```xml

<dependency>
    <groupId>com.danrusu.pods4k</groupId>
    <artifactId>pods4k</artifactId>
    <version>0.6.0</version>
</dependency>
```

Alternatively, you can [pick & choose](publishing/bom/README.md) individual components of this library.

## Immutable Arrays

[Immutable Arrays](immutable-arrays/README.md) offer a safer and more efficient alternative to lists while maintaining
the same look and feel.

### Key Benefits

* **Clean & Familiar**
    * Uses a list-like syntax ensuring easy adoption with clean code.
* **True Immutability**
    * Unlike read-only lists, Immutable Arrays cannot be mutated through casting.
* **Fast**
    * 2 to 8 times faster than lists for many common operations, with some even faster!
* **Memory Efficient**
    * Over 5X memory reduction versus lists for many common scenarios!
        * `people.map { it.weightKg }` creates a primitive `ImmutableFloatArray`.
    * Many operations retain zero extra memory when results are empty or the same elements.
        * `people.filter { it.isEmployed() }` returns same instance when everyone is employed.
    * etc.
* **Type Safety**
    * Accidental mutation attempts are prevented at compile time.

### Usage

```kotlin
val people = immutableArrayOf(dan, jill, bobby)
people[0] // dan

// Normal iteration with loops, forEach, asSequence, etc.
for (person in people) {
    sendMarketingEmail(person)
}

// All the typical transformations and conditions
val adults = people.filter { it.age >= 18 }
val adultAges = adults.map { it.age }
val containsRetirees = adults.any { it.isRetired() }
```

See [Immutable Arrays](immutable-arrays/README.md) for more specifics along with benchmarks and detailed comparisons
against regular arrays, read-only lists, and immutable lists.

## Minimum Requirements

* Kotlin 1.9.25
    * This library is K2 compatible as it's used in other projects that use Kotlin 2.1 etc.
* JDK 11
    * Automated tests are run on JDK LTS releases 11, 17, & 21

## Java Compatibility

Some data structures use techniques which are only supported by the Kotlin compiler. While they can be used in a mixed
Java & Kotlin codebase to store one of these data structures in a Java-defined collection, referencing these data
structures by their class name is only supported within Kotlin files.

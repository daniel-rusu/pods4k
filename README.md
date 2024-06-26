# pods4k

## Performance-oriented data structures for Kotlin

A collection of performance-oriented data structures providing performance and efficiency that might appear to be
impossible at first glance.

## Dependency

**Gradle:**

```kotlin
dependencies {
    implementation("com.danrusu.pods4k:pods4k:0.1.0")
}
```

**Maven:**

```xml

<dependency>
    <groupId>com.danrusu.pods4k</groupId>
    <artifactId>pods4k</artifactId>
    <version>0.1.0</version>
</dependency>
```

Alternatively, you can [pick & choose](publishing/bom/README.md) individual components of this library.

## Immutable Arrays

[Immutable Arrays](immutable-arrays/README.md) are a safer and more efficient alternative to read-only lists while
maintaining familiar operations.

Unlike regular arrays, the elements cannot be re-assigned, so immutable arrays can be safely shared without needing
immutable collections:

```kotlin
val names = immutableArrayOf("Dan", "Bob")
println(names[0]) // "Dan"

names[1] = "Jane" // Compile error: No set method providing array access
```

On top of the base efficiency improvements, immutable arrays are even more efficient when dealing with the 8 base
types such as Int, Boolean, etc. For example, depending on your JVM configuration, when storing integers, this reduces
memory consumption by 5 to 8 times compared to lists and performance can improve by over 10 times when performing
operations on these values.

```kotlin
val people = immutableArrayOf(
    Person(name = "Dan", age = 3),
    Person(name = "Bob", age = 4),
) // ImmutableArray<Person>

// Since age is a non-nullable Int, mapping ages uses an efficient ImmutableIntArray storing primitive int values
val ages = people.map { it.age }
performStatisticalAnalysis(ages)
```

Surprisingly, immutable arrays are significantly more efficient than regular arrays as they have specializations for
dozens of commonly used operations. See [Immutable Arrays](immutable-arrays/README.md) for more specifics along with a
detailed comparison against regular arrays, read-only lists, and immutable lists.

## Java Compatibility

Requires JDK 11 or later. Automated tests are run on JDK LTS releases 11, 17, & 21.

Some data structures use techniques which are only supported by the Kotlin compiler. While they can be used in a mixed
Java & Kotlin codebase to store one of these data structures in a Java-defined collection, referencing these data
structures by their class name is only supported within Kotlin files.

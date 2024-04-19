# pods4k

## Performance-oriented data structures for Kotlin

A collection of performance-oriented data structures that provide performance and efficiency that might appear to be
impossible at first glance.

## Immutable Arrays

[Immutable Arrays](immutable-arrays/README.md) wrap regular arrays with zero-cost abstractions that get eliminated at
compile-time. However, unlike
standard arrays, the array elements cannot be re-assigned, so immutable arrays can be safely shared without needing to
be wrapped in immutable collections:

```kotlin
val names = immutableArrayOf("Dan", "Bob")
println(names[0]) // Dan

names[1] = "Jane" // Compile error: No set method providing array access
```

On top of the base efficiency improvements over immutable or read-only lists when storing typical generic types,
immutable arrays are even more efficient when dealing with the 8 primitive types. For example, when storing integers,
this reduces memory consumption by 5 to 8 times depending on how the JVM is configured and performance can improve by
over 10 times when performing operations on these values in tight loops:

```kotlin
val people = immutableArrayOf(
    Person(name = "Dan", age = 3),
    Person(name = "Bob", age = 4),
) // ImmutableArray<Person>

// Mapping ages automatically uses an efficient ImmutableIntArray[3, 4] storing primitive int values
val ages = people.map { it.age }
performStatisticalAnalysis(ages)
```

When mutability isn't needed, Immutable arrays are also a safer and cleaner alternative to regular arrays providing
significant efficiency improvements over regular arrays for dozens of commonly used operations. See
[Immutable Arrays](immutable-arrays/README.md) for more specifics along with a detailed comparison against regular
arrays, read-only lists, and immutable lists.

## Java Compatibility

Requires JDK 11 or later. Automated tests are run on JDK LTS releases 11, 17, & 21.

Some data structures use techniques which are only supported by the Kotlin compiler. While they can be used in a mixed
Java & Kotlin codebase to store one of these data structures in a Java-defined collection, referencing these data
structures by their class name is only supported within Kotlin files.

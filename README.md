# pods4k

## Performance-oriented data structures for Kotlin.

A collection of performance-oriented data structures that make use of advanced Kotlin techniques to provide some
capabilities with efficiency that's impossible to achieve in Java.

## Immutable Arrays

A safer and more efficient alternative to read-only lists.

Immutable arrays are zero-cost abstractions that compile down to regular arrays. However, unlike standard arrays, the
array elements cannot be re-assigned, so immutable arrays can be safely passed around without needing to be wrapped
in an immutable collection.

```kotlin
val names = immutableArrayOf("Dan", "Bob")
println(names[0]) // Dan

names[1] = "Jane" // Compile error: No set method providing array access
```

Immutable arrays are also safer than read-only lists as they don't have any back-door to get at the underlying data.

```kotlin
@Suppress("CAST_NEVER_SUCCEEDS")
(names as Array<String>)[1] = "Jane"
// ClassCastException: ImmutableArray cannot be cast
```

Immutable arrays are more efficient than lists for practically all operations. Additionally, they are significantly
more efficient when dealing with primitive types as they can store those directly without needing to auto-box the
values:

```kotlin
val people = immutableArrayOf(
    Person(name = "Dan", age = 3),
    Person(name = "Bob", age = 4),
) // ImmutableArray<Person>

val ages = people.map { it.age }
// ImmutableIntArray[3, 4] storing primitive int values
```

All the typical operations that you would use on lists are also available with immutable arrays. See
[Immutable arrays](immutable-arrays/README.md) for a detailed list of benefits over regular arrays, read-only lists, and
immutable lists.

## Java Compatibility

Automated tests are run on all the LTS JDK releases which are supported by Kotlin (JDK 8, 11, 17, etc.)

Some data structures use techniques which are only supported by the Kotlin compiler. While they can be used in a mixed
Java & Kotlin codebase, such as storing one of these data structures in a Java-defined collection, using these data
structures by their class name is only supported within Kotlin files.

# pods4k

## Performance-oriented data structures for Kotlin

A collection of performance-oriented data structures that provide performance and efficiency that might appear to be
impossible at first glance.

## Immutable Arrays

A safer and more efficient alternative to read-only lists providing the same type of capabilities and similar-looking
code. Immutable arrays are also safer, cleaner, and more efficient than regular arrays when mutability isn't required.

Immutable arrays are zero-cost abstractions over regular arrays which are eliminated at compile-time. However, unlike
standard arrays, the array elements cannot be re-assigned, so immutable arrays can be safely shared without needing to
be wrapped in immutable collections:

```kotlin
val names = immutableArrayOf("Dan", "Bob")
println(names[0]) // Dan

names[1] = "Jane" // Compile error: No set method providing array access
```

Immutable arrays are safer than read-only lists as they don't have any back-door to get at the underlying data. They're
more efficient than lists for pretty much all operations
[details here](immutable-arrays/README.md#benefits-over-read-only-lists)). Additionally, they're significantly more
efficient when dealing with primitive types as primitive values are stored together in a compact contiguous region of
memory instead of auto-boxing each value and storing pointers to scattered wrapper objects:

```kotlin
val people = immutableArrayOf(
    Person(name = "Dan", age = 3),
    Person(name = "Bob", age = 4),
) // ImmutableArray<Person>

val ages = people.map { it.age }
// ImmutableIntArray[3, 4] storing primitive int values
```

See [Immutable arrays](immutable-arrays/README.md) for more specifics along with a detailed comparison against regular
arrays, read-only lists, and immutable lists.

## Java Compatibility

Automated tests are run on all the LTS JDK releases which are supported by Kotlin (JDK 8, 11, 17, etc.)

Some data structures use techniques which are only supported by the Kotlin compiler. While they can be used in a mixed
Java & Kotlin codebase, such as storing one of these data structures in a Java-defined collection, using these data
structures by their class name is only supported within Kotlin files.

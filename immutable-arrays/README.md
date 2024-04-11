## Immutable Arrays

A safer and more efficient alternative to read-only lists.

Immutable arrays are zero-cost abstractions that compile down to regular arrays, so they have the same memory and
performance of regular arrays. However, unlike standard arrays, the
array elements cannot be re-assigned, so immutable arrays can be safely passed around without needing to be wrapped
in an immutable collection.

```kotlin
val names = immutableArrayOf("Dan", "Bob")
println(names[0]) // Dan

names[1] = "Jane" // Compile error: No set method providing array access
```

All the typical operations that you would use on lists are also available with immutable arrays:

```kotlin
val people = immutableArrayOf(
    Person(name = "Dan", age = 3),
    Person(name = "Bob", age = 20),
    Person(name = "Jane", age = 25),
)

val adults = people.filter { it.age >= 18 } // ImmutableArray<Person>[Bob, Jane]

// Mapping to primitive types uses immutable primitive arrays to avoid auto-boxing so it's much more efficient than lists
val adultAges = adults.map { it.age } // ImmutableIntArray[20, 25]
```

### Benefits over regular arrays

### Benefits over read-only lists

### Benefits over immutable lists

### Caveats

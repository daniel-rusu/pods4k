## Testing Strategy

All functions with custom logic should be fully tested.

All functions that don't have any logic and simply delegate to the equivalent version from the Kotlin standard library
should be tested just enough to convince ourselves that the wiring is correct. A trivial happy-path test is ideal for
delegating functions as we should avoid duplicating the testing effort of the Kotlin team and trust that the Kotlin
standard library that we delegate to operates correctly.

We iterate through the base types (8 primitives + 1 generic) and follow a single code path to generate all 9 types of
arrays. The only caveat is that the generic **ImmutableArray** also gets type casts inserted. Therefore, to confirm
that all 9 types of arrays work correctly, it's sufficient to validate **ImmutableIntArray** along with the generic
**ImmutableArray**. We should avoid any redundant copy-and-paste tests (with changed types) in addition to validating
these 2 arrays as that doesn't provide any additional value and adds unnecessary maintenance overhead. The only
exception to this is when the code generator follows a different code path for one of the arrays, in which case that
special-case should also be validated.

### Testing primitive types:

Unlike Java, Kotlin hides the distinction between primitives and objects. However, the resulting compiled code still
makes use of primitives when possible as that can have a large impact on performance.

```kotlin
println(3::class.java) // int

var number: Int? = 3
println(number!!::class.java) // java.lang.Integer
```

When checking that a value is of a primitive type, like **int**, we can't check whether the class is an
**Int** since a value that is auto-boxed into a **java.lang.Integer** wrapper will also pass that test. We also can't
create a utility function for this check because if that function accepts a generic type then the value will be
auto-boxed before being tested even if the function is inline with a reified generic type. Similarly, if a utility
method accepts a primitive type then the value will be automatically unboxed before being tested so we won't know the
type of the initial value.

#### How to validate primitive types:

Unlike the Java wrapper classes, primitive classes are not exposed, so we can't reference them directly. To
reference these internal JVM classes, we need to get the class of a value that is known to be primitive and check
against that instead:

```kotlin
val primitiveIntClass = 3::class.java // int (not java.lang.Integer)

// check if getValue() returns a primitive int
expectThat(getValue()::class.java).isEqualTo(primitiveIntClass)
```

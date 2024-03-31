## Testing Strategy

All functions that don't have any logic and simply delegate to the equivalent version from the Kotlin standard library
should be tested just enough to convince ourselves that the wiring is correct. A trivial happy-path test is ideal for
delegating functions as we should avoid duplicating the testing effort of the Kotlin team and trust that the Kotlin
standard library that we delegate to operates correctly.

When the array classes are generated, we loop through the base types, such as Int, Long, Boolean, etc., and pass that
to a single code generator in order to generate that type of array. Confirming that a method works correctly for one
type of array is sufficient to infer that all the other array types also work correctly since the same code generator
and code path is used for all of them. The only caveat is that the generic **ImmutableArray** requires additional
type casts to be inserted. So we should also validate **ImmutableArray** to ensure that the type casts are inserted
correctly.

Therefore, in order to avoid redundant tests which reduce maintainability, only **ImmutableArray** and
**ImmutableIntArray** should be tested for correct behavior while abiding to the delegation principle above. The others
should only be tested to ensure that they operate on and produce the correct types without validating their behavior
since that's inferred from validating the behavior of **ImmutableIntArray**.

### Testing primitive types:

When checking a type, such as whether a number is a primitive **int**, we can't check whether the class is an
**Int** since a value that is auto-boxed into a **java.lang.Integer** wrapper will also pass that test. We also can't
create a utility function for this check because if that function accepts a generic type then the value will be
auto-boxed before being tested even if the function is inline with a reified generic type. Similarly, if a utility
method accepts a primitive type then the value will be automatically unboxed before being tested so we won't know the
type of the initial value.

#### Differentiating primitives versus wrapper classes:

```kotlin
println(3::class.java) // int

var number: Int? = 3
println(number!!::class.java) // java.lang.Integer
```

#### How to validate primitive types:

Unlike the Java wrapper classes, primitive classes are not exposed so we can't reference them directly. To
reference these internal JVM classes, we need to get the class of a value that is known to be primitive and check
against that instead:

```kotlin
val primitiveIntClass = 3::class.java // int (not java.lang.Integer)

// check if getValue() returns a primitive int
expectThat(getValue()::class.java).isEqualTo(primitiveIntClass)
```

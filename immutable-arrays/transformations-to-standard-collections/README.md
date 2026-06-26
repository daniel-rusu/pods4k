# Immutable Array Transformations to Standard Collections

Extensions for transforming immutable arrays into Kotlin/JDK standard-library collections.

## Use Case

Some operations naturally produce standard collections rather than immutable arrays. This module provides those
operations separately from the core immutable-array API, including functions such as `toList`, `toSet`, `associateBy`,
`groupBy`, etc.

Keeping these APIs in a separate module preserves a clear boundary: core transformations produce immutable arrays, while
this module intentionally allocates standard collections.

There are several performance-oriented collection libraries like
[Eclipse Collections](https://github.com/eclipse/eclipse-collections), [FastUtil](https://github.com/vigna/fastutil),
and others that advertise improved efficiency. Additionally, [Project Valhalla](https://openjdk.org/projects/valhalla/)
might enable more efficient collections over time.

If this library ever adds transformations to non-standard collections, those APIs can live in a new module without
changing this module's standard-collection behavior. There are no plans for using different collection libraries at the
moment so this approach is just a precaution to reduce backward-compatibility risk.

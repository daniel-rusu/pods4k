# Immutable Array to Standard Collections

Extensions for transforming immutable arrays into standard library collections.

## Use case

Some transformation functions like `associateBy`, `groupBy`, etc. produce collections.

There are several performance-oriented collection libraries like
[Eclipse Collections](https://github.com/eclipse/eclipse-collections), [FastUtil](https://github.com/vigna/fastutil),
etc. that advertise improved efficiency. Additionally, [Project Valhalla](https://openjdk.org/projects/valhalla/) should
enable more efficient collections and might even enhance the standard-library collections enabling them to be used in a
more efficient manner.

If we ever decide to produce different collections for these transformations in the future, that ability would be added
in a separate module to avoid needing to break backwards compatibility. This will allow users to either continue using
standard-library collections for these transformations or swap the dependency to utilize the new module. There are no
plans for using different collections at the moment so this approach is just a precaution to reduce future
backward-compatibility risk.

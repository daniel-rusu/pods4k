# Publishing

This parent module does not add runtime capabilities to pods4k. It exists to publish convenience artifacts to Maven
Central.

The child modules serve two dependency-management use cases:

* `aggregator` publishes the top-level `com.danrusu.pods4k:pods4k` artifact for users who want the whole library.
* `bom` publishes the bill of materials for users who want to pick and choose individual artifacts while keeping
  versions aligned.

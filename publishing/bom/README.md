# Bill of Materials

This library is composed of multiple modules where each module is published as a separate artifact on Maven Central. We
also publish a single top-level artifact that automatically brings in all the artifacts of this library, so the simplest
way to depend on the entire library is to add a single dependency to the top-level artifact as described in
[dependency details](../../README.md#dependency).

In addition to the above, we also publish a bill of materials, BOM, which references all the artifact versions in that
release. The main use-case for the BOM is if you prefer to pick and choose individual components instead of
depending on the entire library. In that case, you can reference the BOM at a particular version and add dependencies
for the components that you want without specifying their individual versions.

[![Latest Release][latest-version-shield]][maven-central-url]

## Gradle

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    // Import the BOM at a particular version
    implementation(platform("com.danrusu.pods4k:bom:<latest_version>"))

    // Pick the artifacts that you want but don't specify their versions as that's controlled by the BOM
    implementation("com.danrusu.pods4k.immutable-arrays:core")
    implementation("com.danrusu.pods4k.immutable-arrays:transformations-to-standard-collections")
}
```

## Maven

```xml

<project>
    <!-- Import the BOM at a particular version -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>com.danrusu.pods4k</groupId>
                <artifactId>bom</artifactId>
                <version>latest_version</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <!-- Pick the artifacts that you want but don't specify their versios as that's controlled by the BOM -->
    <dependencies>
        <dependency>
            <groupId>com.danrusu.pods4k.immutable-arrays</groupId>
            <artifactId>core</artifactId>
        </dependency>
        <dependency>
            <groupId>com.danrusu.pods4k.immutable-arrays</groupId>
            <artifactId>transformations-to-standard-collections</artifactId>
        </dependency>
    </dependencies>
</project>
```

## Artifacts

The `bom` references the following artifacts:

| GroupId                               | ArtifactId                                | Description                                                                |
|:--------------------------------------|:------------------------------------------|:---------------------------------------------------------------------------|
| `com.danrusu.pods4k.immutable-arrays` | `core`                                    | The core Immutable Arrays library                                          |
| `com.danrusu.pods4k.immutable-arrays` | `transformations-to-standard-collections` | Extensions that transform immutable arrays to standard-library collections |

[latest-version-shield]: https://img.shields.io/badge/dynamic/json?url=https%3A%2F%2Fraw.githubusercontent.com%2Fdaniel-rusu%2Fpods4k%2Frefs%2Fheads%2Fmain%2Flatest_version.json&query=version&label=Latest%20Version&color=orange

[maven-central-url]: https://central.sonatype.com/artifact/com.danrusu.pods4k/bom

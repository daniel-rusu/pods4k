# Bill of Materials

This library is published as a single artifact (see [dependency details](../README.md#dependency)) that you can
reference. When publishing a release of this library, we also publish the individual components as separate artifacts
along with a bill of materials, BOM, which references the artifacts and their versions.

The main use-case for the BOM in this library is if you prefer to pick and choose individual artifacts instead of
adding a dependency on the entire library. In that case, you'll want to reference the BOM at a particular version and
add dependencies for the artifacts that you want without specifying their individual versions.

## Gradle

```kotlin
dependencies {
    // Import the BOM at a particular version
    implementation(platform("com.danrusu.pods4k:bom:[version]"))

    // Pick the artifacts that you want but don't specify their versions
    implementation("com.danrusu.pods4k.immutable-arrays:core")
    implementation("com.danrusu.pods4k.immutable-arrays:transformations-to-standard-collections")
}
```

## Maven

```xml
<!-- Import the BOM at a particular version -->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.danrusu.pods4k</groupId>
            <artifactId>bom</artifactId>
            <version>[version]</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<!-- Pick the artifacts that you want without specifying versions -->
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
```

## Artifacts

The `bom` references the following artifacts:

| GroupId                               | ArtifactId                                | Description                                                                |
|:--------------------------------------|:------------------------------------------|:---------------------------------------------------------------------------|
| `com.danrusu.pods4k`                  | `bom`                                     | The bill of materials                                                      |
| `com.danrusu.pods4k.immutable-arrays` | `core`                                    | The core Immutable Arrays library                                          |
| `com.danrusu.pods4k.immutable-arrays` | `transformations-to-standard-collections` | Extensions that transform immutable arrays to standard-library collections |

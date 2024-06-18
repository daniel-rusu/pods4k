Releasing
=========

1. Make sure that CI is green (builds & all tests pass)
2. Create a `Prepare for release X.Y.Z` commit with the following changes:
    * Update [changelog.md](changelog.md) for the upcoming release
    * Update the `VERSION_NAME` property in [gradle.properties](gradle.properties) for the new release using semantic
      versioning based on the changelog
    * Update the documentation if necessary but don't update the documented dependency version yet
3. Create a GitHub release:
    * Create a new tag `vX.Y.Z` matching the version from [gradle.properties](gradle.properties)
    * **Release Title**: `X.Y.Z`
    * **Description**: Copy the changes from [changelog.md](changelog.md) for this release
4. Release artifacts in Maven Central:
    * Make sure the `Trigger Release` action completed successfully
    * Check the artifacts in [Sonatype](https://central.sonatype.com/)
    * Release the publication if everything looks good
5. Create a `Finalize release X.Y.Z` commit with the following changes:
    * Update [README.md](README.md#dependency) to reference the newly-released version in the gradle & maven dependency
    * Update the `VERSION_NAME` property in [gradle.properties](gradle.properties)
        * Increment the middle minor version number
        * Append `-SNAPSHOT`

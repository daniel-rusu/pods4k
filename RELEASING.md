Releasing
=========

1. Make sure that CI is green (builds & all tests pass)
2. Create a `Prepare for release X.Y.Z` commit with the following changes:
    * Update [changelog.md](changelog.md) with anything that's missing but don't document the new release version yet
    * Update the `VERSION_NAME` property in [gradle.properties](gradle.properties) for the new release using semantic
      versioning based on the changelog
        * The version should have already been bumped and appended with `-SNAPSHOT` so removing the `-SNAPSHOT` is
          usually sufficient unless this is a patch release for the prior version.
    * Update the documentation if necessary but don't update the documented dependency version yet
3. Create a GitHub release:
    * Create a new tag `vX.Y.Z` matching the version from [gradle.properties](gradle.properties)
    * **Release Title**: `X.Y.Z`
    * **Description**: Copy the changes from [changelog.md](changelog.md) for this release
        * Copy the raw contents to avoid formatting issues due to escaped characters etc.
4. Release artifacts in Maven Central:
    * Make sure the `Trigger Release` action completed successfully
    * Check the artifacts in [Sonatype](https://central.sonatype.com/)
    * Release the publication if everything looks good
5. Create a `Finalize release X.Y.Z` commit with the following changes:
    * Update [README.md](README.md#dependency) to reference the newly-released version in the gradle & maven dependency
    * Document the new release version & date in the [changelog.md](changelog.md)
    * Update the `VERSION_NAME` property in [gradle.properties](gradle.properties)
        * Increment the middle minor version number
        * Append `-SNAPSHOT`

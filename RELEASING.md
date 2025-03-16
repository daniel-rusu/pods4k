Releasing
=========

1. Make sure that CI is green on
   the [`main` branch](https://github.com/daniel-rusu/pods4k/actions?query=branch%3Amain) (builds & all tests pass)
2. Create a `Prepare for release X.Y.Z` commit with the following changes:
    * Update [changelog.md](changelog.md) with anything that's missing but don't document the new release version yet
    * Update the `VERSION_NAME` property in [gradle.properties](gradle.properties) for the new release using semantic
      versioning based on the changelog
    * Update the documentation if necessary but don't update the documented dependency version yet
3. Create a GitHub release:
    * Create a new tag `vX.Y.Z` matching the version from [gradle.properties](gradle.properties)
    * **Release Title**: `X.Y.Z`
    * **Description**: Copy the changes from [changelog.md](changelog.md) for this release
        * Copy the raw contents to avoid formatting issues due to escaped characters etc.
4. Release artifacts in Maven Central:
    * The previous step should have automatically triggered the release workflow
    * Make sure the [`Trigger Release` action](https://github.com/daniel-rusu/pods4k/actions/workflows/release.yml)
      completed successfully
    * Check the artifacts in [Sonatype](https://central.sonatype.com/) (navigate to `Publish` -> `Deployments`)
    * Release the publication if everything looks good
    * Wait and refresh the deployment until the status shows `PUBLISHED` before proceeding to the next step. It can take
      a long time for the artifact status to go from `PUBLISHING` to `PUBLISHED` so I recommend checking back every 30
      minutes or so.
5. Create a `Finalize release X.Y.Z` commit with the following changes:
    * Update [latest_version.json](latest_version.json) with the new version as the documentation uses this version
    * Document the new release version & date in the [changelog.md](changelog.md)

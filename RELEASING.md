Releasing
=========

1. Make sure that CI is green on
   the [`main` branch](https://github.com/daniel-rusu/pods4k/actions?query=branch%3Amain) (builds & all tests pass)
2. Create a `Prepare for release X.Y.Z` commit with the following changes:
    * Update [changelog.md](changelog.md) with anything that's missing
        * Leave the version as `Unreleased` and date `Date TBD` in the changelog
    * Update the `VERSION_NAME` property in [gradle.properties](gradle.properties) for the new release
        * The version number should have already been bumped so you just need to remove the `-SNAPSHOT` suffix.
        * Ensure that the new version number is an appropriate bump from the previous release in accordance with
          semantic versioning based on the changes from the changelog.
3. Create a GitHub release:
    * Create a new tag `vX.Y.Z` matching the version from [gradle.properties](gradle.properties)
    * **Release Title**: `X.Y.Z`
    * **Description**: Copy the changes from [changelog.md](changelog.md) for this release
        * Copy the **raw** contents to avoid formatting issues due to escaped characters etc.
    * Uncheck the `Set as latest release` checkbox as it's not quite ready yet
4. Release artifacts in Maven Central:
    * The previous step should have automatically triggered the release workflow.
    * Make sure the [`Trigger Release` action](https://github.com/daniel-rusu/pods4k/actions/workflows/release.yml)
      completed successfully.
    * Check the artifacts in [Sonatype](https://central.sonatype.com/) (navigate to `Publish` -> `Deployments`) and
      release the publication if everything looks good.
    * Wait and refresh the deployment until the status shows `PUBLISHED` before proceeding to the next step.
        * I recommend checking back every 30 minutes as this step can take a long time.
5. Create a `Finalize release X.Y.Z` commit with the following changes:
    * Document the new release version & date in the [changelog.md](changelog.md)
    * Bump the `VERSION_NAME` property in [gradle.properties](gradle.properties) with the version for the next upcoming
      release along with the `-SNAPSHOT` suffix.
       * The `-SNAPSHOT` suffix is important so that we don't accidentally publish work-in-progress releases.
       * Snapshots are published to a separate repository where they're automatically deleted after 90 days.
6. Mark the new release as the latest release
    * Edit the new [GitHub release](https://github.com/daniel-rusu/pods4k/releases) and select the
      `Set as the latest release` checkbox at the bottom
    * Make sure that the new release displays as the latest release in the `Releases` section of
      the [repo front page](https://github.com/daniel-rusu/pods4k)

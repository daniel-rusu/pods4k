plugins {
    id("java-platform")
    alias(libs.plugins.mavenPublishing)
}

dependencies {
    constraints {
        api(projects.immutableArrays.core)
        api(projects.immutableArrays.transformationsToStandardCollections)
    }
}

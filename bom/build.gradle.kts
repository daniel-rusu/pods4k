plugins {
    id("java-platform")
    alias(libs.plugins.mavenPublishing)
}

javaPlatform {
    allowDependencies()
}

repositories {
    mavenCentral()
}

dependencies {
    constraints {
        api(projects.immutableArrays)
        api(projects.immutableArraysToStandardCollections)
    }
}

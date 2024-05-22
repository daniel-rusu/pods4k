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
        api(projects.immutableArrays.core)
        api(projects.immutableArrays.transformationsToStandardCollections)
    }
}

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.mavenPublishing)
}

dependencies {
    implementation(projects.immutableArrays.core)
}

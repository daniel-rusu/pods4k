import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.mavenPublishing)
}

dependencies {
    api(projects.immutableArrays.core)
    api(projects.immutableArrays.transformationsToStandardCollections)
}

mavenPublishing {
    pom {
        packaging = "pom"
    }
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.None(),
        )
    )
}

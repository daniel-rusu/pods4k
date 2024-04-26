import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.mavenPublishing)
}

mavenPublishing {
    coordinates("com.danrusu.pods4k", "immutable-arrays", "0.5.0")
    publishToMavenCentral(host = SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()

    pom {
        name = "immutable-arrays"
        description = "Immutable Arrays for Kotlin"
        inceptionYear = "2024"
        url = "https://github.com/daniel-rusu/pods4k/tree/main/immutable-arrays"

        licenses {
            license {
                name = "The Apache License, Version 2.0"
                distribution = "repo"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }

        developers {
            developer {
                id = "daniel-rusu"
                name = "Dan Rusu"
                url = "https://github.com/daniel-rusu"
            }
        }

        issueManagement {
            system = "GitHub"
            url = "https://github.com/daniel-rusu/pods4k/issues"
        }

        scm {
            connection = "scm:git:git://github.com/daniel-rusu/pods4k.git"
            url = "https://github.com/daniel-rusu/pods4k"
        }
    }
}

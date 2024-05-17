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
        api(project(":immutable-arrays"))
    }
}

mavenPublishing {
    coordinates(artifactId = "bom")
    publishToMavenCentral(host = com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL, automaticRelease = false)
    signAllPublications()

    pom {
        name = "bom"
        description = "Bill of materials for pods4k allowing for a single dependency"
        inceptionYear = "2024"
        url = "https://github.com/daniel-rusu/pods4k"

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

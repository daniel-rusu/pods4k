plugins {
    kotlin("jvm") version libs.versions.kotlin
    `jvm-test-suite`
}

allprojects {
    group = "com.danrusu"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
            allWarningsAsErrors.set(true)
        }
    }

    plugins.withId("org.jetbrains.kotlin.jvm") {
        dependencies {
            testImplementation(libs.strikt)
            testRuntimeOnly(libs.jUnitPlatformLauncher)
        }
        testing {
            suites {
                val test by getting(JvmTestSuite::class) {
                    useJUnitJupiter(libs.versions.jUnit)
                }
            }
        }
    }
}

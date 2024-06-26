import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version libs.versions.kotlin
    `jvm-test-suite`
    id("pods4k-code-generator")
}

allprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)

            // generate default methods in interfaces without the DefaultImpls
            freeCompilerArgs.add("-Xjvm-default=all")
            freeCompilerArgs.add("-XXLanguage:+CustomEqualsInValueClasses")

            // enforce redundant visibility modifiers
            kotlin.explicitApi()

            // prevent warnings from compiling in non-test code
            if (name != "compileTestKotlin") {
                allWarningsAsErrors.set(true)
            }
        }
    }

    // Ensure "org.gradle.jvm.version" is set to "11" in Gradle metadata.
    tasks.withType<JavaCompile> {
        options.release.set(11)
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

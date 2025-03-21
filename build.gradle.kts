import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version libs.versions.kotlin
    `jvm-test-suite`
    id("pods4k-code-generator")
    alias(libs.plugins.spotless)
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

            // enforce redundant visibility modifiers
            kotlin.explicitApi()

            // prevent warnings from compiling in non-test code
            if (name != "compileTestKotlin") {
                allWarningsAsErrors.set(true)
            }

            // experimental features
            freeCompilerArgs.add("-XXLanguage:+CustomEqualsInValueClasses")
            freeCompilerArgs.add("-opt-in=kotlin.experimental.ExperimentalTypeInference")
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

val ktlintEditorConfigOverride = mapOf(
    "ktlint_standard_discouraged-comment-location" to "disabled",
    "ktlint_standard_value-argument-comment" to "disabled",
    "ktlint_standard_function-expression-body" to "disabled",
)

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("**/build/**/*.*")
        ktlint()
            .editorConfigOverride(ktlintEditorConfigOverride)
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlinGradle {
        target("**/*.gradle.kts")
        ktlint()
            .editorConfigOverride(ktlintEditorConfigOverride)
        trimTrailingWhitespace()
        endWithNewline()
    }
}

tasks.named("generateCode").configure {
    finalizedBy("spotlessApply")
}

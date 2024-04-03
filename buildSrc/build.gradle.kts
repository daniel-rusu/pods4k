plugins {
    kotlin("jvm") version libs.versions.kotlin
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinPoet)
    implementation(gradleApi())
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8)

        // generate default methods in interfaces without the DefaultImpls
        freeCompilerArgs.add("-Xjvm-default=all")
        freeCompilerArgs.add("-Xcontext-receivers")

        // enforce redundant visibility modifiers
        kotlin.explicitApi()

        // prevent warnings from compiling in non-test code
        if (name != "compileTestKotlin") {
            allWarningsAsErrors.set(true)
        }
    }
}

// Ensure "org.gradle.jvm.version" is set to "8" in Gradle metadata.
tasks.withType<JavaCompile> {
    options.release.set(8)
}

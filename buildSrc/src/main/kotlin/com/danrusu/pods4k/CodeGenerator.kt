package com.danrusu.pods4k

import com.danrusu.pods4k.immutableArrays.ImmutableArrayCodeGenerator
import org.gradle.api.Plugin
import org.gradle.api.Project

public open class CodeGenerator : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("generateCode") { task ->
            task.group = "code generation"
            task.description = "Runs the code generators in pods4k"
            task.doLast {
                val path = target.childProjects["immutable-arrays"]!!.projectDir.absolutePath + "/src/main/kotlin"
                ImmutableArrayCodeGenerator.generate(destinationPath = path)
            }
        }
    }
}

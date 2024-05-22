package com.danrusu.pods4k

import com.danrusu.pods4k.immutableArrays.immutableArraysModule.ArrayExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.immutableArraysModule.CollectionExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.immutableArraysModule.ImmutableArrayCodeGenerator
import com.danrusu.pods4k.immutableArrays.immutableArraysModule.ImmutableArraysFileGenerator
import com.danrusu.pods4k.immutableArrays.immutableArraysModule.SequenceExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollectionsModule.TransformationsToListFileGenerator
import org.gradle.api.Plugin
import org.gradle.api.Project

public open class CodeGenerator : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("generateCode") { task ->
            task.group = "code generation"
            task.description = "Runs the code generators in pods4k"
            task.doLast {
                generateImmutableArraysModule(target)
                generateImmutableArraysToStandardCollectionsModule(target)
            }
        }
    }
}

private fun generateImmutableArraysModule(target: Project) {
    val moduleSourcePath = target.childProjects["immutable-arrays"]!!
        .childProjects["core"]!!
        .projectDir.absolutePath + "/src/main/kotlin"

    ImmutableArrayCodeGenerator.generate(destinationPath = moduleSourcePath)
    ImmutableArraysFileGenerator.generate(destinationPath = moduleSourcePath)
    ArrayExtensionsGenerator.generate(destinationPath = moduleSourcePath)
    CollectionExtensionsGenerator.generate(destinationPath = moduleSourcePath)
    SequenceExtensionsGenerator.generate(destinationPath = moduleSourcePath)
}

private fun generateImmutableArraysToStandardCollectionsModule(target: Project) {
    val moduleSourcePath = target.childProjects["immutable-arrays"]!!
        .childProjects["transformations-to-standard-collections"]!!
        .projectDir.absolutePath + "/src/main/kotlin"

    TransformationsToListFileGenerator.generate(moduleSourcePath)
}

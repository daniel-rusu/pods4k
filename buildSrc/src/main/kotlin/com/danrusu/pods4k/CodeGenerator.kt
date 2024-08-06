package com.danrusu.pods4k

import com.danrusu.pods4k.immutableArrays.core.ArrayExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.core.CollectionExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.core.ImmutableArrayExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.core.ImmutableArrayFactoryGenerator
import com.danrusu.pods4k.immutableArrays.core.ImmutableArrayGenerator
import com.danrusu.pods4k.immutableArrays.core.SequenceExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.core.specializations.FlatMapIndexedSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.specializations.FlatMapSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.specializations.MapIndexedNotNullSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.specializations.MapIndexedSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.specializations.MapNotNullSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.specializations.MapSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollections.TransformationsToListFileGenerator
import org.gradle.api.Plugin
import org.gradle.api.Project

public open class CodeGenerator : Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("generateCode") { task ->
            task.group = "code generation"
            task.description = "Runs the code generators in pods4k"
            task.doLast {
                generateCoreImmutableArraysModule(target)
                generateImmutableArraysToStandardCollectionsModule(target)
            }
        }
    }
}

private fun generateCoreImmutableArraysModule(target: Project) {
    val moduleSourcePath = target.childProjects["immutable-arrays"]!!
        .childProjects["core"]!!
        .projectDir.absolutePath + "/src/main/kotlin"

    ImmutableArrayGenerator.generate(destinationPath = moduleSourcePath)
    ImmutableArrayExtensionsGenerator.generate(destinationPath = moduleSourcePath)
    ImmutableArrayFactoryGenerator.generate(destinationPath = moduleSourcePath)
    ArrayExtensionsGenerator.generate(destinationPath = moduleSourcePath)
    CollectionExtensionsGenerator.generate(destinationPath = moduleSourcePath)
    SequenceExtensionsGenerator.generate(destinationPath = moduleSourcePath)

    generateImmutableArraySpecializations(moduleSourcePath)
}

private fun generateImmutableArraySpecializations(moduleSourcePath: String) {
    MapSpecializationGenerator.generate(moduleSourcePath)
    MapIndexedSpecializationGenerator.generate(moduleSourcePath)
    MapNotNullSpecializationGenerator.generate(moduleSourcePath)
    MapIndexedNotNullSpecializationGenerator.generate(moduleSourcePath)
    FlatMapSpecializationGenerator.generate(moduleSourcePath)
    FlatMapIndexedSpecializationGenerator.generate(moduleSourcePath)
}

private fun generateImmutableArraysToStandardCollectionsModule(target: Project) {
    val moduleSourcePath = target.childProjects["immutable-arrays"]!!
        .childProjects["transformations-to-standard-collections"]!!
        .projectDir.absolutePath + "/src/main/kotlin"

    TransformationsToListFileGenerator.generate(moduleSourcePath)
}

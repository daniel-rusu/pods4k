package com.danrusu.pods4k

import com.danrusu.pods4k.immutableArrays.core.ArrayExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.core.CollectionExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.core.ImmutableArrayExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.core.ImmutableArrayFactoryGenerator
import com.danrusu.pods4k.immutableArrays.core.ImmutableArrayGenerator
import com.danrusu.pods4k.immutableArrays.core.SequenceExtensionsGenerator
import com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations.FlatMapIndexedSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations.FlatMapSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations.MapIndexedNotNullSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations.MapIndexedSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations.MapNotNullSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations.MapSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations.ZipSpecializationGenerator
import com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollections.TransformationsToListFileGenerator
import com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollections.TransformationsToMapFileGenerator
import com.danrusu.pods4k.immutableArrays.immutableArraysToStandardCollections.TransformationsToSetFileGenerator
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

    generateImmutableArrayMultiplicativeSpecializations(moduleSourcePath)
}

private fun generateImmutableArrayMultiplicativeSpecializations(moduleSourcePath: String) {
    MapSpecializationGenerator.generate(moduleSourcePath)
    MapIndexedSpecializationGenerator.generate(moduleSourcePath)
    MapNotNullSpecializationGenerator.generate(moduleSourcePath)
    MapIndexedNotNullSpecializationGenerator.generate(moduleSourcePath)
    FlatMapSpecializationGenerator.generate(moduleSourcePath)
    FlatMapIndexedSpecializationGenerator.generate(moduleSourcePath)
    ZipSpecializationGenerator.generate(moduleSourcePath)
}

private fun generateImmutableArraysToStandardCollectionsModule(target: Project) {
    val moduleSourcePath = target.childProjects["immutable-arrays"]!!
        .childProjects["transformations-to-standard-collections"]!!
        .projectDir.absolutePath + "/src/main/kotlin"

    TransformationsToListFileGenerator.generate(moduleSourcePath)
    TransformationsToSetFileGenerator.generate(moduleSourcePath)
    TransformationsToMapFileGenerator.generate(moduleSourcePath)
}

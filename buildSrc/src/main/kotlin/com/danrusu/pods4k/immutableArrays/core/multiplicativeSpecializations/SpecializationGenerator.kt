package com.danrusu.pods4k.immutableArrays.core.multiplicativeSpecializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.createFile
import com.squareup.kotlinpoet.FileSpec
import java.io.File

internal abstract class SpecializationGenerator(private val fileName: String) {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.specializationPackageName, fileName) {
            for (fromType in BaseType.entries) {
                for (toType in BaseType.entries) {
                    generateSpecialization(this, fromType, toType)
                }
            }
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }

    protected abstract fun generateSpecialization(
        fileSpec: FileSpec.Builder,
        fromType: BaseType,
        toType: BaseType,
    )
}

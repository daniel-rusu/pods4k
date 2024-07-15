package com.danrusu.pods4k.immutableArrays.immutableArraysModule.specializations

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.createFile
import com.squareup.kotlinpoet.FileSpec
import java.io.File

internal abstract class SpecializationGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.specializationPackageName, this::class.simpleName.toString()) {
            for (fromType in BaseType.values()) {
                for (toType in BaseType.values()) {
                    generateSpecialization(this, fromType, toType)
                }
            }
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }

    protected abstract fun generateSpecialization(fileSpec: FileSpec.Builder, fromType: BaseType, toType: BaseType)
}

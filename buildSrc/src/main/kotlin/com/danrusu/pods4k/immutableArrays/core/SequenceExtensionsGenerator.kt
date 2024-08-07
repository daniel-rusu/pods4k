package com.danrusu.pods4k.immutableArrays.core

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object SequenceExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "Sequences") {
            addSequenceToImmutableArray()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addSequenceToImmutableArray() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of this sequence.",
            receiver = Sequence::class.asTypeName().parameterizedBy(baseType.type),
            name = "toImmutableArray",
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            controlFlow("return build${baseType.generatedClassName}") {
                statement("addAll(this@toImmutableArray)")
            }
        }
    }
}

package com.danrusu.pods4k.immutableArrays

import com.danrusu.pods4k.utils.addFunction
import com.danrusu.pods4k.utils.createFile
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object SequenceExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(Config.packageName, "Sequences") {
            addSequenceToImmutableArray()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addSequenceToImmutableArray() {
    for (baseType in BaseType.values()) {
        addFunction(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of this sequence.",
            receiver = Sequence::class.asTypeName().parameterizedBy(baseType.type),
            name = "to${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addCode(
                """
                    val elements = this.toList()
                    return ${baseType.generatedClassName}(elements.size) { elements[it] }
                """.trimIndent()
            )
        }
    }
}

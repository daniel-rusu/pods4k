package com.danrusu.pods4k.immutableArrays.immutableArraysModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.Config
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.createFile
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object CollectionExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(Config.packageName, "Collections") {
            addIterableToImmutableArray()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addIterableToImmutableArray() {
    for (baseType in BaseType.values()) {
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of [this] collection.",
            receiver = Iterable::class.asTypeName().parameterizedBy(baseType.type),
            name = "toImmutableArray",
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            addCode(
                """
                    if (this is Collection<${baseType.type}>) {
                        val iterator = this.iterator()
                        return ${baseType.generatedClassName}(size) { iterator.next() }
                    }
                    val values = this.toList()
                    return ${baseType.generatedClassName}(values.size) { values[it] }
                """.trimIndent()
            )
        }
    }
}

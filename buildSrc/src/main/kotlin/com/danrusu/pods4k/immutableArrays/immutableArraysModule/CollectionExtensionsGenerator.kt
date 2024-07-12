package com.danrusu.pods4k.immutableArrays.immutableArraysModule

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

internal object CollectionExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "Collections") {
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
            controlFlow("if (this is Collection<%T>)", baseType.type) {
                statement("val iterator = this.iterator()")
                statement("return ${baseType.generatedClassName}(size) { iterator.next() }")
            }
            statement("val values = this.toList()")
            statement("return ${baseType.generatedClassName}(values.size) { values[it] }")
        }
    }
}

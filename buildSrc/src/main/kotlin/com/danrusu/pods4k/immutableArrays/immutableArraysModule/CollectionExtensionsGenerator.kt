package com.danrusu.pods4k.immutableArrays.immutableArraysModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.comment
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.WildcardTypeName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object CollectionExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "Collections") {
            addIterableToImmutableArray()
            addMutableCollectionAddAll()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addIterableToImmutableArray() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of [this] collection.",
            receiver = Iterable::class.asTypeName().parameterizedBy(baseType.type),
            name = "toImmutableArray",
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            controlFlow("val initialCapacity = when (this)") {
                statement("is Collection<%T> -> size", baseType.type)
                statement("else -> 10")
            }
            controlFlow("return build${baseType.generatedClassName}(initialCapacity)") {
                statement("addAll(this@toImmutableArray)")
            }
        }
    }
}

private fun FileSpec.Builder.addMutableCollectionAddAll() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = """
                Adds all the elements to [this] collection.

                @return true if the collection changed.
            """.trimIndent(),
            receiver = ClassName("kotlin.collections", "MutableCollection")
                .parameterizedBy(WildcardTypeName.consumerOf(baseType.type)),
            name = "addAll",
            parameters = { "elements"(type = baseType.getGeneratedTypeName()) },
            returns = Boolean::class.asTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            comment("Wrap the backing array without copying the contents so we can delegate to the existing addAll method which ensures sufficient capacity in a single step")
            statement("return addAll(elements.asList())")
        }
    }
}

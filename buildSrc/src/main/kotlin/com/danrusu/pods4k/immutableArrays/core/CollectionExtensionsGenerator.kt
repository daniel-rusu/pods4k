package com.danrusu.pods4k.immutableArrays.core

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.BaseType.GENERIC
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.comment
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.jvmName
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
            addCollectionContainsAll()
            addMutableCollectionAddAll()
            addMutableCollectionRemoveAll()
            addMutableCollectionRetainAll()
            addIterableFlatten()
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
            if (baseType == GENERIC) {
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

private fun FileSpec.Builder.addCollectionContainsAll() {
    for (baseType in BaseType.entries) {
        // Use Any? for primitive arrays to allow calling it on collections of supertypes.
        // The generic version is fine since ImmutableArray is covariant so
        // Collection<T>.containsAll(ImmutableArray<ChildT>) will be allowed
        val collectionType = when (baseType) {
            GENERIC -> baseType.type
            else -> Any::class.asTypeName().copy(nullable = true)
        }
        function(
            kdoc = "Checks whether [this] collection contains all the elements from the specified immutable array",
            receiver = ClassName("kotlin.collections", "Collection")
                .parameterizedBy(collectionType),
            name = "containsAll",
            parameters = { "elements"(type = baseType.getGeneratedTypeName()) },
            returns = Boolean::class.asTypeName(),
            forceFunctionBody = true,
        ) {
            if (baseType == GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return containsAll(elements.asList())")
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
            if (baseType == GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            comment(
                "Wrap the backing array without copying the contents so we can delegate to the existing addAll " +
                    "method which ensures sufficient capacity in a single step",
            )
            statement("return addAll(elements.asList())")
        }
    }
}

private fun FileSpec.Builder.addMutableCollectionRemoveAll() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = """
                Removes all the elements from [this] collection.

                Note that if the immutable array contains duplicate elements then it might be more efficient to convert the immutable array to a set first and remove the set from the collection instead.

                @return true if the collection changed.
            """.trimIndent(),
            receiver = ClassName("kotlin.collections", "MutableCollection")
                .parameterizedBy(WildcardTypeName.consumerOf(baseType.type)),
            name = "removeAll",
            parameters = { "elements"(type = baseType.getGeneratedTypeName()) },
            returns = Boolean::class.asTypeName(),
            forceFunctionBody = true,
        ) {
            if (baseType == GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return removeAll(elements.asList())")
        }
    }
}

private fun FileSpec.Builder.addMutableCollectionRetainAll() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = """
                Retains only the elements in [this] collection that are contained in the specified immutable array.

                @return true if the collection changed.
            """.trimIndent(),
            receiver = ClassName("kotlin.collections", "MutableCollection")
                .parameterizedBy(WildcardTypeName.consumerOf(baseType.type)),
            name = "retainAll",
            parameters = { "elements"(type = baseType.getGeneratedTypeName()) },
            returns = Boolean::class.asTypeName(),
            forceFunctionBody = true,
        ) {
            if (baseType == GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return retainAll(elements.asList())")
        }
    }
}

private fun FileSpec.Builder.addIterableFlatten() {
    for (baseType in BaseType.entries) {
        function(
            kdoc = "Returns a single immutable array with all the elements from all nested arrays.",
            receiver = Iterable::class.asTypeName().parameterizedBy(baseType.getGeneratedTypeName()),
            name = "flatten",
            returns = baseType.getGeneratedTypeName(),
            forceFunctionBody = true,
        ) {
            jvmName("flattenIterableOf${baseType.generatedClassName}")
            if (baseType == GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            controlFlow("return build${baseType.generatedClassName}()") {
                controlFlow("for (nestedArray in this@flatten)") {
                    statement("this@build${baseType.generatedClassName}.addAll(nestedArray)")
                }
            }
        }
    }
}

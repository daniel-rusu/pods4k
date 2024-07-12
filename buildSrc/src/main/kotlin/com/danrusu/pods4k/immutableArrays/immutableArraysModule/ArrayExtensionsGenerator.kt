package com.danrusu.pods4k.immutableArrays.immutableArraysModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.danrusu.pods4k.utils.suppress
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asTypeName
import java.io.File

internal object ArrayExtensionsGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "Arrays") {
            addPrimitiveArrayToImmutableArray()
            addGenericArrayToImmutableArray()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addGenericArrayToImmutableArray() {
    for (baseType in BaseType.values()) {
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of this array.",
            receiver = Array::class.asTypeName().parameterizedBy(baseType.type),
            name = "toImmutableArray",
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)

                // Generic to generic can use the fast arraycopy
                suppress("UNCHECKED_CAST")
                statement("val backingArray = arrayOfNulls<Any?>(size) as Array<%T>", baseType.type)
                statement("System.arraycopy(this, 0, backingArray, 0, size)")
                statement("return ${baseType.generatedClassName}(backingArray)")
            } else {
                // Generic to primitive type needs to unbox each value individually
                statement("return ${baseType.generatedClassName}(size)·{·this[it]·}")
            }
        }
    }
}

private fun FileSpec.Builder.addPrimitiveArrayToImmutableArray() {
    for (baseType in BaseType.values()) {
        if (baseType == BaseType.GENERIC) continue

        function(
            kdoc = "Returns an [${baseType.generatedClassName}] with the contents of this array.",
            receiver = baseType.backingArrayType,
            name = "toImmutableArray",
            returns = baseType.getGeneratedTypeName(),
        ) {
            statement("val backingArray = ${baseType.backingArrayConstructor}(size)")
            statement("System.arraycopy(this, 0, backingArray, 0, size)")
            statement("return ${baseType.generatedClassName}(backingArray)")
        }
    }
}

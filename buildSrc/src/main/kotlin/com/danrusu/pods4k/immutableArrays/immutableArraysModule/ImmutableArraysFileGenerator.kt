package com.danrusu.pods4k.immutableArrays.immutableArraysModule

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.statement
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

internal object ImmutableArraysFileGenerator {
    fun generate(destinationPath: String) {
        val fileSpec = createFile(ImmutableArrayConfig.packageName, "ImmutableArrays") {
            addEmptyFunctions()
            addImmutableArrayOf()
            addGenericImmutableArrayToPrimitiveImmutableArray()
            addPrimitiveImmutableArrayToTypedImmutableArray()
            addImmutableArrayGetOrElse()
        }
        fileSpec.writeTo(File(destinationPath, ""))
    }
}

private fun FileSpec.Builder.addImmutableArrayOf() {
    // Calling immutableArrayOf() without arguments will delegate to the empty generic factory function
    function(
        kdoc = "Returns an empty [${BaseType.GENERIC.generatedClassName}].",
        name = "immutableArrayOf",
        returns = BaseType.GENERIC.getGeneratedTypeName(),
    ) {
        addTypeVariable(BaseType.GENERIC.type as TypeVariableName)
        statement("return empty${BaseType.GENERIC.generatedClassName}()")
    }

    for (baseType in BaseType.values()) {
        function(
            kdoc = "Returns an [${baseType.generatedClassName}] containing the specified [values].",
            name = "immutableArrayOf",
            parameters = { "values"(type = baseType.type, isVararg = true) },
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return ${baseType.generatedClassName}(values.size) { values[it] }")
        }
    }
}

private fun FileSpec.Builder.addEmptyFunctions() {
    for (baseType in BaseType.values()) {
        function(
            kdoc = "Returns an empty [${baseType.generatedClassName}].",
            name = "empty${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return ${baseType.generatedClassName}.EMPTY")
        }
    }
}

private fun FileSpec.Builder.addGenericImmutableArrayToPrimitiveImmutableArray() {
    for (baseType in BaseType.values()) {
        if (baseType == BaseType.GENERIC) continue

        function(
            kdoc = """
                Returns an [${baseType.generatedClassName}] containing the values of this array.
                
                [${baseType.generatedClassName}] uses less memory and is faster to access as it stores the primitive values directly without needing to store them in wrapper objects.
            """.trimIndent(),
            receiver = BaseType.GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            name = "to${baseType.generatedClassName}",
            returns = baseType.getGeneratedTypeName(),
            code = "return ${baseType.generatedClassName}(size)·{·this[it]·}"
        )
    }
}

private fun FileSpec.Builder.addPrimitiveImmutableArrayToTypedImmutableArray() {
    for (baseType in BaseType.values()) {
        if (baseType == BaseType.GENERIC) continue

        function(
            kdoc = """
                Returns a typed [${baseType.generatedClassName}] containing the values of this array.
                
                Note that [${BaseType.GENERIC.generatedClassName}] uses more memory and is slower to access as each primitive value will be auto-boxed in a wrapper object.
            """.trimIndent(),
            receiver = baseType.getGeneratedClass(),
            name = "toTyped${BaseType.GENERIC.generatedClassName}",
            returns = BaseType.GENERIC.getGeneratedClass().parameterizedBy(baseType.type),
            code = "return ${BaseType.GENERIC.generatedClassName}(size)·{·this[it]·}"
        )
    }
}

private fun FileSpec.Builder.addImmutableArrayGetOrElse() {
    for (baseType in BaseType.values()) {
        val receiver = when (baseType) {
            BaseType.GENERIC -> baseType.getGeneratedClass().parameterizedBy(baseType.type)
            else -> baseType.getGeneratedClass()
        }
        function(
            kdoc = "See [Array.getOrElse]",
            modifiers = listOf(KModifier.INLINE),
            receiver = receiver,
            name = "getOrElse",
            parameters = {
                "index"<Int>()
                "defaultValue"(type = lambda(parameters = { "index"<Int>() }, returnType = baseType.type))
            },
            returns = baseType.type,
        ) {
            if (baseType == BaseType.GENERIC) {
                addTypeVariable(baseType.type as TypeVariableName)
            }
            statement("return values.getOrElse(index, defaultValue)")
        }
    }
}

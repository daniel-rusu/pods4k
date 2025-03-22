package com.danrusu.pods4k.immutableArrays.core

import com.danrusu.pods4k.immutableArrays.BaseType
import com.danrusu.pods4k.immutableArrays.BaseType.GENERIC
import com.danrusu.pods4k.immutableArrays.ImmutableArrayConfig
import com.danrusu.pods4k.utils.ParameterDSL
import com.danrusu.pods4k.utils.addGenericTypes
import com.danrusu.pods4k.utils.addPrimaryConstructor
import com.danrusu.pods4k.utils.comment
import com.danrusu.pods4k.utils.companionObject
import com.danrusu.pods4k.utils.controlFlow
import com.danrusu.pods4k.utils.createFile
import com.danrusu.pods4k.utils.declareClass
import com.danrusu.pods4k.utils.emptyLine
import com.danrusu.pods4k.utils.function
import com.danrusu.pods4k.utils.property
import com.danrusu.pods4k.utils.statement
import com.danrusu.pods4k.utils.suppress
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.NOTHING
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.WildcardTypeName
import com.squareup.kotlinpoet.asTypeName
import java.io.File
import kotlin.random.Random

internal object ImmutableArrayGenerator {
    fun generate(destinationPath: String) {
        for (baseType in BaseType.entries) {
            val fileSpec = generateImmutableArrayFile(baseType)
            fileSpec.writeTo(File(destinationPath, ""))
        }
    }
}

private fun generateImmutableArrayFile(baseType: BaseType): FileSpec {
    return createFile(ImmutableArrayConfig.packageName, baseType.generatedClassName) {
        declareClass(modifiers = listOf(KModifier.VALUE), name = baseType.generatedClassName) {
            addKdoc(
                "Represents an array that cannot have its elements re-assigned." +
                    "\n" +
                    "\nAlthough this is a class that wraps a regular array, it's really a zero-cost abstraction " +
                    "that gets eliminated at compile time so that variables of this type end up pointing " +
                    "directly at the underlying array." +
                    "\n" +
                    "\nTo preserve the same performance as regular arrays, all functions that simply delegate to " +
                    "the same function on the backing array are marked inline.  This won't result in code " +
                    "duplication as it's a direct substitution replacing calls to the wrapper with direct calls " +
                    "to the underlying functions on the backing array.",
            )
            suppress("NOTHING_TO_INLINE")
            addAnnotation(JvmInline::class)
            if (baseType == GENERIC) {
                val typeName = (baseType.type as TypeVariableName).name
                addTypeVariable(TypeVariableName(typeName, KModifier.OUT))
            }
            addPrimaryConstructor(baseType)
            property<Int>(
                name = "size",
                getModifiers = listOf(KModifier.INLINE),
                get = "return values.size",
            )
            property<Int>(
                kdoc = "Returns the index of the last element or -1 if the array is empty.",
                name = "lastIndex",
                getModifiers = listOf(KModifier.INLINE),
                get = "return values.lastIndex",
            )
            property<IntRange>(
                kdoc = "Returns the range of valid indices for the array.",
                name = "indices",
                getModifiers = listOf(KModifier.INLINE),
                get = "return values.indices",
            )
            overrideToString()

            "joinToString"(
                typeSpecBuilder = this,
                baseType = baseType,
                makeInline = false, // because the lambda is nullable
                parameters = {
                    "separator"<CharSequence>(defaultValue = "\", \"")
                    "prefix"<CharSequence>(defaultValue = "\"\"")
                    "postfix"<CharSequence>(defaultValue = "\"\"")
                    "limit"<Int>(defaultValue = "-1")
                    "truncated"<CharSequence>(defaultValue = "\"...\"")
                    "transform"(
                        type = nullableLambda<CharSequence>(parameters = { "element"(type = baseType.type) }),
                        defaultValue = "null",
                    )
                },
                returns = String::class.asTypeName(),
            )

            addEqualsOperator(baseType)
            addReferencesSameArrayAs(baseType)
            overrideHashCode(baseType)
            "isEmpty"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Boolean::class.asTypeName(),
            )
            "isNotEmpty"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Boolean::class.asTypeName(),
            )
            addArrayIndexOperator(baseType)
            "getOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "index"<Int>() },
                returns = baseType.type.copy(nullable = true),
            )
            addComponentNFunctions(baseType)
            "single"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type,
            )
            "single"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type,
                forceFunctionBody = true,
            )
            "singleOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "singleOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type.copy(nullable = true),
                forceFunctionBody = true,
            )
            "first"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type,
            )
            "first"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type,
                forceFunctionBody = true,
            )
            "firstOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "firstOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type.copy(nullable = true),
                forceFunctionBody = true,
            )
            "last"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type,
            )
            "last"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type,
                forceFunctionBody = true,
            )
            "lastOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "lastOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = baseType.type.copy(nullable = true),
                forceFunctionBody = true,
            )
            "random"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type,
            )
            "random"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "random"<Random>() },
                returns = baseType.type,
            )
            "randomOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = baseType.type.copy(nullable = true),
            )
            "randomOrNull"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "random"<Random>() },
                returns = baseType.type.copy(nullable = true),
            )
            "iterator"(
                typeSpecBuilder = this,
                baseType = baseType,
                modifiers = listOf(KModifier.OPERATOR),
                returns = Iterator::class.asTypeName().parameterizedBy(baseType.type),
            )
            "asIterable"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Iterable::class.asTypeName().parameterizedBy(baseType.type),
            )
            "withIndex"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Iterable::class.asTypeName().parameterizedBy(
                    IndexedValue::class.asTypeName().parameterizedBy(baseType.type),
                ),
            )
            "asSequence"(
                typeSpecBuilder = this,
                baseType = baseType,
                returns = Sequence::class.asTypeName().parameterizedBy(baseType.type),
            )
            "forEach"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "action"(type = lambda<Unit> { "element"(type = baseType.type) })
                },
            )
            "forEachIndexed"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "action"(
                        type = lambda<Unit> {
                            "index"<Int>()
                            "element"(type = baseType.type)
                        },
                    )
                },
            )
            "all"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Boolean::class.asTypeName(),
                forceFunctionBody = true,
            )
            "any"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Boolean::class.asTypeName(),
                forceFunctionBody = true,
            )
            "none"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Boolean::class.asTypeName(),
                forceFunctionBody = true,
            )
            "count"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = { "predicate"(type = lambda<Boolean> { "predicate"(type = baseType.type) }) },
                returns = Int::class.asTypeName(),
                forceFunctionBody = true,
            )
            "indexOfFirst"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = Int::class.asTypeName(),
                forceFunctionBody = true,
            )
            "indexOfLast"(
                typeSpecBuilder = this,
                baseType = baseType,
                parameters = {
                    "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) })
                },
                returns = Int::class.asTypeName(),
                forceFunctionBody = true,
            )
            for (resultType in listOf(Int::class, Long::class, Double::class)) {
                "sumOf"(
                    typeSpecBuilder = this,
                    baseType = baseType,
                    annotations = listOf(
                        AnnotationSpec.builder(OverloadResolutionByLambdaReturnType::class).build(),
                    ),
                    parameters = {
                        "selector"(
                            type = lambda(
                                parameters = { "element"(type = baseType.type) },
                                returnType = resultType.asTypeName(),
                            ),
                        )
                    },
                    returns = resultType.asTypeName(),
                )
            }
            addSumOfFloat(baseType)
            addTake(baseType)
            addTakeWhile(baseType)
            addTakeLast(baseType)
            addTakeLastWhile(baseType)
            addDrop(baseType)
            addDropWhile(baseType)
            addDropLast(baseType)
            addDropLastWhile(baseType)
            addFilter(baseType)
            addFilterIndexed(baseType)
            addFilterNot(baseType)
            addPartition(baseType)
            addSortedBy(baseType)
            addSortedByDescending(baseType)
            addSortedWith(baseType)
            addShuffled(baseType)
            addDistinct(baseType)
            addDistinctBy(baseType)

            companionObject {
                if (baseType == GENERIC) {
                    suppress("UNCHECKED_CAST")
                }
                addCompanionObjectEmptyProperty(baseType)
                addCompanionObjectInvokeOperator(baseType)
                addCompanionObjectCopyOf(baseType)
            }

            declareClass(name = "Builder") {
                addKdoc(
                    "Builder to create immutable arrays when the resulting size isn't known in advance.\n\n" +
                        "@param initialCapacity The initial capacity of the temporary array where the values " +
                        "are accumulated.  A larger value reduces the number of times it's resized as elements " +
                        "get added.",
                )
                if (baseType == GENERIC) {
                    addTypeVariable(baseType.type as TypeVariableName)
                }
                addPrimaryConstructor(
                    parameters = { "initialCapacity"<Int>(defaultValue = "10") },
                )
                property<Int>(isMutable = true, name = "size", init = "0", privateSetter = true)
                property(
                    modifiers = listOf(KModifier.PRIVATE),
                    isMutable = true,
                    name = "values",
                    type = when (baseType) {
                        GENERIC -> Array::class.asTypeName()
                            .parameterizedBy(Any::class.asTypeName().copy(nullable = true))

                        else -> baseType.backingArrayType
                    },
                ) {
                    when (baseType) {
                        GENERIC -> initializer("arrayOfNulls(initialCapacity)")
                        else -> initializer("${baseType.backingArrayConstructor}(initialCapacity)")
                    }
                }

                /**
                 * IMPORTANT: See the warning in [addBuilderBuildFunction] before considering adding mutating
                 * capabilities that clear, remove, or re-assign previous elements.  Adding these types of capabilities
                 * would require that optimization to be removed.
                 */
                addBuilderAddFunction(baseType)
                addBuilderPlusAssignOperator(baseType)
                addBuilderAddAllFunctions(baseType)
                addBuilderBuildFunction(baseType)
                addBuilderEnsureCapacityFunction()
            }
        }
    }
}

/**
 * Delegates to the same function on the backing array.
 *
 * @param makeInline Controls whether it should be an inline function.  IMPORTANT: Default to true so that all delegated
 * functions perform exactly the same as if working with an array directly instead of waiting for the JIT warmup to
 * inline tiny functions.
 */
private operator fun String.invoke(
    typeSpecBuilder: TypeSpec.Builder,
    baseType: BaseType,
    kdoc: String = "See [${if (baseType == GENERIC) "Array" else baseType.backingArrayConstructor}.$this]",
    makeInline: Boolean = true,
    annotations: List<AnnotationSpec> = emptyList(),
    modifiers: List<KModifier> = emptyList(),
    parameters: ParameterDSL.() -> Unit = {},
    returns: TypeName = Unit::class.asTypeName(),
    forceFunctionBody: Boolean = false,
) {
    val params = ParameterDSL().apply(parameters).build().joinToString { it.name }
    typeSpecBuilder.function(
        kdoc = kdoc,
        modifiers = if (makeInline) modifiers + KModifier.INLINE else modifiers,
        name = this,
        parameters = parameters,
        returns = returns,
        forceFunctionBody = forceFunctionBody,
    ) {
        addAnnotations(annotations)
        if (returns == Unit::class.asTypeName()) {
            statement("values.${this@invoke}($params)")
        } else {
            statement("return values.${this@invoke}($params)")
        }
    }
}

private fun TypeSpec.Builder.addPrimaryConstructor(baseType: BaseType) {
    // adding a parameter to the primary constructor and creating an identical property initialized by that parameter
    // ends up defining it in the primary constructor
    addPrimaryConstructor(
        modifiers = listOf(KModifier.INTERNAL),
        parameters = { "values"(type = baseType.backingArrayType) },
    ) {
        addAnnotation(PublishedApi::class)
    }.property(
        kdoc = "The backing array is internal instead of private so that we can have inline functions that delegate " +
            "to the same function on the backing array.  The backing array won't be accessible from Kotlin code " +
            "since the auto-generated arrays are in their own module and the internal modifier prevents outside " +
            "access.  The constructor is also internal preventing anyone from creating an \"instance\" that " +
            "points to an array that they have access to." +
            "\n" +
            "\nAttempting to bypass the internal visibility from java won't work since this is an inline class " +
            "so both the field and constructor are mangled by the Kotlin compiler.  While these might appear to " +
            "be accessible from Java due to the friendly Kotlin interop, these won't actually exist with those " +
            "names in the generated bytecode resulting in an unknown symbol exception." +
            "\n" +
            "\nTherefore, the combination of being internal in its own module along with inline classes makes " +
            "this effectively private.",
        modifiers = listOf(KModifier.INTERNAL),
        name = "values",
        type = baseType.backingArrayType,
        init = "values",
    ) {
        addAnnotation(PublishedApi::class)
    }
}

private fun TypeSpec.Builder.overrideToString() {
    function(
        modifiers = listOf(KModifier.OVERRIDE),
        name = "toString",
        returns = String::class.asTypeName(),
    ) {
        statement(
            """
                return values.joinToString(prefix = "[", postfix = "]")
            """.trimIndent(),
        )
    }
}

private fun TypeSpec.Builder.addEqualsOperator(baseType: BaseType) {
    val otherType = when (baseType) {
        GENERIC -> baseType.getGeneratedClass().parameterizedBy(STAR)
        else -> baseType.getGeneratedClass()
    }
    function(
        modifiers = listOf(KModifier.OPERATOR),
        name = "equals",
        parameters = { "other"(type = otherType) },
        returns = Boolean::class.asTypeName(),
    ) {
        // IMPORTANT: Check referential equality of backing array (not `other === this`) to handle auto-boxing scenarios
        statement("if (other.values === this.values) return true")
        statement("if (other.size != this.size) return false")
        emptyLine()
        controlFlow("forEachIndexed { index, element ->") {
            statement("if (other[index] != element) return false")
        }
        statement("return true")
    }
}

private fun TypeSpec.Builder.addReferencesSameArrayAs(baseType: BaseType) {
    val otherType = when (baseType) {
        GENERIC -> baseType.getGeneratedClass().parameterizedBy(STAR)
        else -> baseType.getGeneratedClass()
    }
    function(
        kdoc = "Immutable Arrays compile to regular arrays in the generated bytecode so this checks if both " +
            "immutable arrays reference the same array instance." +
            "\n" +
            "\nKotlin doesn't allow checking reference equality of inline-class \"instances\" since auto-boxing " +
            "the same immutable array twice can result in two separate wrapper objects that both represent the " +
            "same immutable array with both wrappers referencing the same backing array instance.  This method " +
            "allows us to safely check if we're dealing with the same immutable array bypassing the auto-boxing " +
            "concerns.",
        name = "referencesSameArrayAs",
        parameters = { "other"(type = otherType) },
        returns = Boolean::class.asTypeName(),
        forceFunctionBody = true,
    ) {
        statement("return other.values === this.values")
    }
}

private fun TypeSpec.Builder.overrideHashCode(baseType: BaseType) {
    val prime1 = 7
    val prime2 = 31
    function(
        modifiers = listOf(KModifier.OVERRIDE),
        name = "hashCode",
        returns = Int::class.asTypeName(),
    ) {
        comment(
            "Start with non-zero hash so that arrays that start with a different number of zero-hash elements end " +
                "up with different hashCodes",
        )

        statement("var hashCode = $prime1")
        controlFlow("for (value in values)") {
            when (baseType) {
                GENERIC -> statement("hashCode = $prime2 * hashCode + (value?.hashCode() ?: 0)")
                else -> statement("hashCode = $prime2 * hashCode + value.hashCode()")
            }
        }
        statement("return hashCode")
    }
}

private fun TypeSpec.Builder.addArrayIndexOperator(baseType: BaseType) {
    function(
        modifiers = listOf(KModifier.INLINE, KModifier.OPERATOR),
        kdoc = "Returns the element at [index]. This method can be called using the index operator.",
        name = "get",
        parameters = { "index"<Int>() },
        returns = baseType.type,
    ) {
        statement("return values[index]")
    }
}

private fun TypeSpec.Builder.addComponentNFunctions(baseType: BaseType) {
    for (n in 1..ImmutableArrayConfig.NUM_COMPONENT_N_FUNCTIONS) {
        function(
            modifiers = listOf(KModifier.OPERATOR),
            name = "component$n",
            returns = baseType.type,
        ) {
            statement("return get(${n - 1})")
        }
    }
}

/**
 * For some reason, the Kotlin team decided to have sumOf Int, Long, and Double but not Float:
 * https://youtrack.jetbrains.com/issue/KT-43310/Add-sumOf-with-Float-return-type
 *
 * So we need to code this manually instead of delegating to the same method on the backing array (since that doesn't
 * exist for floats).
 */
private fun TypeSpec.Builder.addSumOfFloat(baseType: BaseType) {
    function(
        kdoc = "Returns the sum of all values produced by the [selector] function applied to each element.",
        modifiers = listOf(KModifier.INLINE),
        name = "sumOf",
        parameters = {
            "selector"(
                type = lambda(
                    parameters = { "element"(type = baseType.type) },
                    returnType = Float::class.asTypeName(),
                ),
            )
        },
        returns = Float::class.asTypeName(),
    ) {
        addAnnotation(AnnotationSpec.builder(OverloadResolutionByLambdaReturnType::class).build())
        statement("var sum = 0.0f")
        controlFlow("for (element in values)") {
            statement("sum += selector(element)")
        }
        statement("return sum")
    }
}

private fun TypeSpec.Builder.addTake(baseType: BaseType) {
    function(
        kdoc = """
            Returns an immutable array containing the first [n] elements.

            @throws IllegalArgumentException if [n] is negative.
        """.trimIndent(),
        name = "take",
        parameters = { "n"<Int>() },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement(
            """
            require(n >= 0) { "Requested element count ${'$'}n is less than zero." }
            """.trimIndent(),
        )
        statement("if (n >= size) return this")
        emptyLine()
        statement("return copyFrom(source = values, startIndex = 0, size = n)")
    }
}

private fun TypeSpec.Builder.addTakeWhile(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing the first elements that satisfy the [predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "takeWhile",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = baseType.getGeneratedTypeName(),
    ) {
        controlFlow("for (index in 0..lastIndex)") {
            controlFlow("if (!predicate(values[index]))") {
                statement("return take(index)")
            }
        }
        statement("return this")
    }
}

private fun TypeSpec.Builder.addTakeLast(baseType: BaseType) {
    function(
        kdoc = """
            Returns an immutable array containing the last [n] elements.

            @throws IllegalArgumentException if [n] is negative.
        """.trimIndent(),
        name = "takeLast",
        parameters = { "n"<Int>() },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement(
            """
            require(n >= 0) { "Requested element count ${'$'}n is less than zero." }
            """.trimIndent(),
        )
        statement("if (n >= size) return this")
        emptyLine()
        statement("return copyFrom(source = values, startIndex = size - n, size = n)")
    }
}

private fun TypeSpec.Builder.addTakeLastWhile(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing the last elements that satisfy the [predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "takeLastWhile",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = baseType.getGeneratedTypeName(),
    ) {
        controlFlow("for (index in lastIndex downTo 0)") {
            controlFlow("if (!predicate(values[index]))") {
                statement("return takeLast(size - index - 1)")
            }
        }
        statement("return this")
    }
}

private fun TypeSpec.Builder.addDrop(baseType: BaseType) {
    function(
        kdoc = """
            Returns an immutable array containing all the elements except the first n elements.

            @throws IllegalArgumentException if [n] is negative.
        """.trimIndent(),
        name = "drop",
        parameters = { "n"<Int>() },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement(
            """
            require(n >= 0) { "Requested element count ${'$'}n is less than zero." }
            """.trimIndent(),
        )
        emptyLine()
        statement("return takeLast((size - n).coerceAtLeast(0))")
    }
}

private fun TypeSpec.Builder.addDropWhile(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing all the elements except the first elements that satisfy the " +
            "[predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "dropWhile",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = baseType.getGeneratedTypeName(),
    ) {
        controlFlow("for (index in 0..lastIndex)") {
            controlFlow("if (!predicate(values[index]))") {
                statement("return takeLast(size - index)")
            }
        }
        statement("return EMPTY")
    }
}

private fun TypeSpec.Builder.addDropLast(baseType: BaseType) {
    function(
        kdoc = """
            Returns an immutable array containing all the elements except the last n elements.

            @throws IllegalArgumentException if [n] is negative.
        """.trimIndent(),
        name = "dropLast",
        parameters = { "n"<Int>() },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement(
            """
            require(n >= 0) { "Requested element count ${'$'}n is less than zero." }
            """.trimIndent(),
        )
        emptyLine()
        statement("return take((size - n).coerceAtLeast(0))")
    }
}

private fun TypeSpec.Builder.addDropLastWhile(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing all the elements except the last elements that satisfy the " +
            "[predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "dropLastWhile",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = baseType.getGeneratedTypeName(),
    ) {
        controlFlow("for (index in lastIndex downTo 0)") {
            controlFlow("if (!predicate(values[index]))") {
                statement("return take(index + 1)")
            }
        }
        statement("return EMPTY")
    }
}

private fun TypeSpec.Builder.addFilter(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing only the elements matching the given [predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "filter",
        parameters = {
            "predicate"(
                modifiers = listOf(KModifier.CROSSINLINE),
                type = lambda<Boolean> { "element"(type = baseType.type) },
            )
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        comment("delegate to filterIndexed as that's extremely optimized")
        statement("return filterIndexed { _, element -> predicate(element) }")
    }
}

private fun TypeSpec.Builder.addFilterIndexed(baseType: BaseType) {
    function(
        kdoc = """
            Returns an immutable array containing only the elements matching the given [predicate].

            Warning: This code is quite dense because it's highly optimized to reduce the temporary
            memory overhead and also dramatically improves performance due to branch elimination and
            a perfectly-sized result.
        """.trimIndent(),
        name = "filterIndexed",
        parameters = {
            "predicate"(
                type = lambda<Boolean> {
                    "index"<Int>()
                    "element"(type = baseType.type)
                },
            )
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement("if (isEmpty()) return this")
        emptyLine()
        comment("divide by 32 rounding up")
        statement("val bitArraySize = (size + 31) ushr 5")

        // Note that I tried using a Long array but that was marginally slower and more complex due to int conversions
        comment("store an array of int values whose 1-bits capture which elements pass the predicate")
        statement("val bitArray = IntArray(bitArraySize)")
        emptyLine()
        statement("var resultSize = 0")
        comment("the bit index into the current 32-bit int")
        statement("var bitIndex = -1 // start at -1 as it gets incremented right away in the loop")
        statement("var bitArrayIndex = 0")
        statement("var currentBits = 0 // the current 32-bits with no elements yet")
        controlFlow("forEachIndexed { index, element ->") {
            controlFlow("if (++bitIndex == 32)") {
                comment("reached the end of the current bits so store them and reset")
                statement("bitArray[bitArrayIndex++] = currentBits")
                statement("currentBits = 0")
                statement("bitIndex = 0")
            }
            comment("jit turns this into a branchless operation")
            statement("val currentElement = if (predicate(index, element)) 1 else 0")
            emptyLine()
            comment("conditionally increase the size without branching")
            statement("resultSize += currentElement")
            emptyLine()
            comment("conditionally include the current element without branching")
            statement("currentBits = currentBits or (currentElement shl bitIndex)")
        }
        statement("if (resultSize == 0) return EMPTY")
        statement("if (resultSize == size) return this")
        emptyLine()
        comment("store the last set of partially-filled bits")
        statement("bitArray[bitArrayIndex] = currentBits")
        emptyLine()
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement("val result = arrayOfNulls<Any>(resultSize) as Array<T>")
        } else {
            statement("val result = ${baseType.backingArrayConstructor}(resultSize)")
        }
        statement("var resultIndex = 0")
        statement("bitArrayIndex = 0")
        statement("bitIndex = -1")
        statement("currentBits = bitArray[0]")
        statement("var originalIndex = 0")
        comment("check the resultIndex instead of the originalIndex so that we can stop early")
        controlFlow("while (resultIndex < result.size)") {
            controlFlow("if (++bitIndex == 32)") {
                comment("reached the end of the current bits so get the next 32 bits and reset")
                statement("currentBits = bitArray[++bitArrayIndex]")
                statement("bitIndex = 0")
            }
            comment("always copy to avoid branching as resultIndex won't increment if current element isn't included")
            statement("result[resultIndex] = this[originalIndex++]")
            comment("increment the resultIndex if the current element should be included")
            statement("val currentElement = (currentBits ushr bitIndex) and 1")
            statement("resultIndex += currentElement")
        }
        statement("return ${baseType.generatedClassName}(result)")
    }
}

private fun TypeSpec.Builder.addFilterNot(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing only the elements that don't match the [predicate].",
        modifiers = listOf(KModifier.INLINE),
        name = "filterNot",
        parameters = {
            "predicate"(
                modifiers = listOf(KModifier.CROSSINLINE),
                type = lambda<Boolean> { "element"(type = baseType.type) },
            )
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        comment("delegate to filterIndexed as that's extremely optimized")
        statement("return filterIndexed { _, element -> !predicate(element) }")
    }
}

private fun TypeSpec.Builder.addPartition(baseType: BaseType) {
    // Validated with JMH benchmarks that this function is faster as a regular non-inlined function
    function(
        kdoc = "Creates a pair of immutable arrays, where the first contains elements for which the predicate " +
            "yielded true, and the second contains the other elements.",
        name = "partition",
        parameters = { "predicate"(type = lambda<Boolean> { "element"(type = baseType.type) }) },
        returns = Pair::class.asTypeName()
            .parameterizedBy(baseType.getGeneratedTypeName(), baseType.getGeneratedTypeName()),
    ) {
        /*
        Create a perfectly-sized double-ended buffer.  Add the elements that yielded true starting from the beginning of
        the buffer and the other elements from the end.  The only trick is to remember to copy the elements from the end
        in reverse order so that they maintain their original ordering.

        This uses less memory and is much faster based on JMH benchmarks compared to the traditional approach of
        maintaining separate builders.  That's because unlike the builders, the buffer never needs to be resized so the
        elements don't need to be copied multiple times into larger replacements as it gets resized along the way.
         */
        statement("var firstIndex = 0")
        statement("var secondIndex = size - 1")
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement("val buffer = arrayOfNulls<Any?>(size) as Array<T>")
        } else {
            statement("val buffer = ${baseType.backingArrayConstructor}(size)")
        }
        controlFlow("for (element in values)") {
            addCode(
                """
                    if (predicate(element)) {
                        buffer[firstIndex] = element
                        firstIndex++
                    } else {
                        buffer[secondIndex] = element
                        secondIndex--
                    }
                """.trimIndent(),
            )
        }
        // IMPORTANT: Don't try to remove this empty check because although copyFrom has an empty check, we want to use
        // this as the right side without copying it
        statement("if (firstIndex == 0) return Pair(EMPTY, this)")
        statement("if (firstIndex == size) return Pair(this, EMPTY)")
        emptyLine()
        statement("val first = copyFrom(source = buffer, startIndex = 0, size = firstIndex)")
        statement("val second = ${baseType.generatedClassName}(size - first.size) { buffer[size - it - 1] }")
        statement("return Pair(first, second)")
    }
}

private fun TypeSpec.Builder.addSortedBy(baseType: BaseType) {
    val genericVariableName = "R"
    val genericType = TypeVariableName(genericVariableName)
    function(
        kdoc = "Leaves this immutable array as is and returns an ${baseType.generatedClassName} with all elements " +
            "sorted according to the natural sort order of the value returned by the [selector].\n\n" +
            "The sort is _stable_ so equal elements preserve their order relative to each other after sorting.",
        modifiers = listOf(KModifier.INLINE),
        name = "sortedBy",
        parameters = {
            "selector"(
                modifiers = listOf(KModifier.CROSSINLINE),
                type = lambda(
                    parameters = { "element"(type = baseType.type) },
                    returnType = genericType.copy(nullable = true),
                ),
            )
        },
        returns = baseType.getGeneratedTypeName(),
        forceFunctionBody = true,
    ) {
        addTypeVariable(
            TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType)),
        )
        statement("return sortedWith(compareBy(selector))")
    }
}

private fun TypeSpec.Builder.addSortedByDescending(baseType: BaseType) {
    val genericVariableName = "R"
    val genericType = TypeVariableName(genericVariableName)
    function(
        kdoc = "Leaves this immutable array as is and returns an ${baseType.generatedClassName} with all elements " +
            "sorted according to the reverse natural sort order of the value returned by the [selector]." +
            "\n" +
            "\nThe sort is _stable_ so equal elements preserve their order relative to each other after sorting.",
        modifiers = listOf(KModifier.INLINE),
        name = "sortedByDescending",
        parameters = {
            "selector"(
                modifiers = listOf(KModifier.CROSSINLINE),
                type = lambda(
                    parameters = { "element"(type = baseType.type) },
                    returnType = genericType.copy(nullable = true),
                ),
            )
        },
        returns = baseType.getGeneratedTypeName(),
        forceFunctionBody = true,
    ) {
        addTypeVariable(
            TypeVariableName(genericVariableName, Comparable::class.asTypeName().parameterizedBy(genericType)),
        )
        statement("return sortedWith(compareByDescending(selector))")
    }
}

private fun TypeSpec.Builder.addSortedWith(baseType: BaseType) {
    function(
        kdoc = "Leaves this immutable array as is and returns an [${baseType.generatedClassName}] with all elements " +
            "sorted according to the specified [comparator].",
        name = "sortedWith",
        parameters = {
            "comparator"(
                type = ClassName("kotlin", "Comparator").parameterizedBy(WildcardTypeName.consumerOf(baseType.type)),
            )
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        statement("if (size <= 1) return this")
        emptyLine()
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement("val backingArray = arrayOfNulls<Any?>(size) as Array<%T>", baseType.type)
            statement("System.arraycopy(values, 0, backingArray, 0, size)")
            emptyLine()
            statement("backingArray.sortWith(comparator)")
            statement("return ${baseType.generatedClassName}(backingArray)")
        } else {
            // The standard library comparator-based sort utilities only operate on generic arrays.
            // This is probably to avoid auto-boxing each value everytime it's compared
            statement("val temp = values.toTypedArray()")
            statement("temp.sortWith(comparator)")
            statement("return temp.toImmutableArray()")
        }
    }
}

private fun TypeSpec.Builder.addShuffled(baseType: BaseType) {
    val kdoc = "Leaves this immutable array as is and returns an [${baseType.generatedClassName}] with all elements " +
        "shuffled."
    val functionName = "shuffled"
    val returnType = baseType.getGeneratedTypeName()

    function(
        kdoc = kdoc,
        name = functionName,
        returns = returnType,
    ) {
        statement("if (size <= 1) return this")
        emptyLine()
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement("val backingArray = arrayOfNulls<Any?>(size) as Array<%T>", baseType.type)
            statement("System.arraycopy(values, 0, backingArray, 0, size)")
            statement("backingArray.shuffle()")
        } else {
            statement("val backingArray = values.copyOf().apply { shuffle() }")
        }
        statement("return ${baseType.generatedClassName}(backingArray)")
    }

    function(
        kdoc = kdoc,
        name = functionName,
        parameters = { "random"<Random>() },
        returns = returnType,
    ) {
        statement("if (size <= 1) return this")
        emptyLine()
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement("val backingArray = arrayOfNulls<Any?>(size) as Array<%T>", baseType.type)
            statement("System.arraycopy(values, 0, backingArray, 0, size)")
            statement("backingArray.shuffle(random)")
        } else {
            statement("val backingArray = values.copyOf().apply { shuffle(random) }")
        }
        statement("return ${baseType.generatedClassName}(backingArray)")
    }
}

private fun TypeSpec.Builder.addDistinct(baseType: BaseType) {
    function(
        kdoc = """
            Returns an immutable array containing only the distinct elements from this immutable array.

            Iteration order is preserved and subsequent duplicate elements are ignored.
        """.trimIndent(),
        name = "distinct",
        returns = baseType.getGeneratedTypeName(),
        forceFunctionBody = true,
    ) {
        statement("if (size <= 1) return this")
        emptyLine()

        // This is more efficient than values.toSet().toImmutableArray() because it doesn't need to use a
        // LinkedHashSet to maintain ordering so it uses less memory
        statement("val distinctValues = HashSet<%T>()", baseType.type)
        statement("return filter { distinctValues.add(it) }")
    }
}

private fun TypeSpec.Builder.addDistinctBy(baseType: BaseType) {
    val key = TypeVariableName("K")
    function(
        kdoc = "Returns an immutable array containing only the elements having distinct keys returned by the " +
            "[selector]",
        modifiers = listOf(KModifier.INLINE),
        name = "distinctBy",
        parameters = {
            "selector"(
                modifiers = listOf(KModifier.CROSSINLINE),
                type = lambda(
                    parameters = { "element"(type = baseType.type) },
                    returnType = key,
                ),
            )
        },
        returns = baseType.getGeneratedTypeName(),
        forceFunctionBody = true,
    ) {
        addGenericTypes(key)

        statement("if (size <= 1) return this")
        emptyLine()
        statement("val keys = HashSet<%T>()", key)
        statement("return filter { keys.add(selector(it)) }")
    }
}

private fun TypeSpec.Builder.addCompanionObjectEmptyProperty(baseType: BaseType) {
    val type = when (baseType) {
        GENERIC -> baseType.getGeneratedClass().parameterizedBy(NOTHING)
        else -> baseType.getGeneratedClass()
    }
    property(
        modifiers = listOf(KModifier.INTERNAL),
        name = "EMPTY",
        type = type,
    ) {
        addAnnotation(PublishedApi::class)
        when (baseType) {
            GENERIC -> initializer("${baseType.generatedClassName}(emptyArray<Any>()) as %T", type)
            else -> initializer("${baseType.generatedClassName}(${baseType.backingArrayConstructor}(0))")
        }
    }
}

private fun TypeSpec.Builder.addCompanionObjectInvokeOperator(baseType: BaseType) {
    function(
        kdoc = "Returns an ${baseType.generatedClassName} instance of the specified [size], where each element is " +
            "calculated by calling the [init] function." +
            "\n" +
            "\n[init] is called sequentially, starting at index 0, to initialize the array with each element at " +
            "its given index." +
            "\n" +
            "\nImplementation:" +
            "\nWe're using the invoke operator instead of a regular constructor so that we can declare it " +
            "inline.  The call site will look like a regular constructor call.",
        modifiers = listOf(KModifier.INLINE, KModifier.OPERATOR),
        name = "invoke",
        parameters = {
            "size"<Int>()
            "init"(type = lambda(parameters = { "index"<Int>() }, returnType = baseType.type))
        },
        returns = baseType.getGeneratedTypeName(),
    ) {
        addGenericTypes(baseType.type)

        statement("if (size == 0) return EMPTY")
        emptyLine()
        statement("val backingArray = ${baseType.backingArrayConstructor}(size) { index -> init(index) }")
        if (baseType == GENERIC) {
            statement("return ${baseType.generatedClassName}(backingArray as %T)", baseType.backingArrayType)
        } else {
            statement("return ${baseType.generatedClassName}(backingArray)")
        }
    }
}

private fun TypeSpec.Builder.addCompanionObjectCopyOf(baseType: BaseType) {
    val returnType = baseType.getGeneratedTypeName()
    val backingArrayType = when (baseType) {
        GENERIC -> Array::class.asTypeName().parameterizedBy(baseType.type)
        else -> baseType.backingArrayType
    }
    function(
        kdoc = "Returns an ${baseType.generatedClassName} with the first [size] elements copied from [copy] " +
            "starting from [startIndex].",
        name = "copyFrom",
        parameters = {
            "source"(type = backingArrayType)
            "startIndex"<Int>()
            "size"<Int>()
        },
        returns = returnType,
    ) {
        addGenericTypes(baseType.type)
        statement("if (size == 0) return EMPTY")
        emptyLine()
        /*
        IMPORTANT:
        The implementation must not insert any values that aren't in the source array.  Eg, regularArray.copyOf(n) pads
        the result with null / 0 when n exceeds the size of the copy so we don't want that behavior.

        We're not validating the bounds because System.arraycopy will validate those to ensure that startIndex is in
        range and that there are at least size elements after the startIndex.

        We're not delegating to copyOfRange(startIndex, startIndex + size) because that duplicates the bounds checks
        and then delegates to arraycopy which will validate the bounds again.
         */
        if (baseType == GENERIC) {
            statement("val backingArray = arrayOfNulls<Any?>(size) as %T", backingArrayType)
        } else {
            statement("val backingArray = ${baseType.backingArrayConstructor}(size)")
        }
        statement("System.arraycopy(source, startIndex, backingArray, 0, size)")
        statement("return ${baseType.generatedClassName}(backingArray)")
    }
}

private fun TypeSpec.Builder.addBuilderAddFunction(baseType: BaseType) {
    val returnType = when (baseType) {
        GENERIC -> ClassName(ImmutableArrayConfig.packageName, baseType.generatedClassName, "Builder")
            .parameterizedBy(baseType.type)

        else -> ClassName(ImmutableArrayConfig.packageName, baseType.generatedClassName, "Builder")
    }
    function(
        name = "add",
        parameters = { "element"(type = baseType.type) },
        returns = returnType,
    ) {
        statement("ensureCapacity(size + 1)")
        statement("values[size++] = element")
        statement("return this")
    }
}

private fun TypeSpec.Builder.addBuilderPlusAssignOperator(baseType: BaseType) {
    function(
        modifiers = listOf(KModifier.OPERATOR),
        kdoc = "Adds the [element] to the builder.",
        name = "plusAssign",
        parameters = { "element"(type = baseType.type) },
    ) {
        statement("add(element)")
    }
}

private fun TypeSpec.Builder.addBuilderAddAllFunctions(baseType: BaseType) {
    val builderType = when (baseType) {
        GENERIC -> ClassName(ImmutableArrayConfig.packageName, baseType.generatedClassName, "Builder")
            .parameterizedBy(baseType.type)

        else -> ClassName(ImmutableArrayConfig.packageName, baseType.generatedClassName, "Builder")
    }
    function(
        name = "addAll",
        parameters = { "elements"(type = baseType.backingArrayType) },
        returns = builderType,
    ) {
        statement("ensureCapacity(size + elements.size)")
        statement("System.arraycopy(elements, 0, values, size, elements.size)")
        statement("size += elements.size")
        statement("return this")
    }

    if (baseType != GENERIC) {
        // Supports boxed values.  Eg. adding Array<Int> to ImmutableIntArray.Builder
        function(
            name = "addAll",
            parameters = { "elements"(type = Array::class.asTypeName().parameterizedBy(baseType.type)) },
            returns = builderType,
        ) {
            statement("ensureCapacity(size + elements.size)")
            controlFlow("for (element in elements)") {
                statement("values[size++] = element")
            }
            statement("return this")
        }
    }

    function(
        name = "addAll",
        parameters = { "elements"(type = baseType.getGeneratedTypeName()) },
        returns = builderType,
    ) {
        statement("ensureCapacity(size + elements.size)")
        statement("System.arraycopy(elements.values, 0, values, size, elements.size)")
        statement("size += elements.size")
        statement("return this")
    }

    if (baseType != GENERIC) {
        // Supports boxed values.  Eg. adding ImmutableArray<Int> to ImmutableIntArray.Builder
        function(
            name = "addAll",
            parameters = { "elements"(type = GENERIC.getGeneratedClass().parameterizedBy(baseType.type)) },
            returns = builderType,
        ) {
            statement("ensureCapacity(size + elements.size)")
            controlFlow("for (element in elements)") {
                statement("values[size++] = element")
            }
            statement("return this")
        }
    }

    function(
        name = "addAll",
        parameters = { "elements"(type = Iterable::class.asTypeName().parameterizedBy(baseType.type)) },
        returns = builderType,
    ) {
        controlFlow("if (elements is Collection)") {
            statement("ensureCapacity(size + elements.size)")
            controlFlow("for (element in elements)") {
                statement("values[size++] = element")
            }
            statement("return this")
        }
        controlFlow("for (element in elements)") {
            statement("add(element)")
        }
        statement("return this")
    }

    function(
        name = "addAll",
        parameters = { "elements"(type = Sequence::class.asTypeName().parameterizedBy(baseType.type)) },
        returns = builderType,
    ) {
        statement("elements.forEach { add(it) }")
        statement("return this")
    }
}

private fun TypeSpec.Builder.addBuilderBuildFunction(baseType: BaseType) {
    function(
        kdoc = "Returns an immutable array containing the elements that were added.",
        name = "build",
        returns = baseType.getGeneratedTypeName(),
    ) {
        // This check is needed for the scenario where the initial capacity is set to 0 and no elements are added
        // so that we always use the EMPTY singleton for empty immutable arrays
        statement("if (size == 0) return EMPTY")
        /*

        Avoiding copying the array again when the size matches the capacity is important for when the initial capacity
        was set appropriately.  Other capabilities of this library depend on this optimization for optimal efficiency.

         *** IMPORTANT ***
        This optimization is only safe as long as the builder can only append elements without the ability to remove or
        re-assign previously-added elements.  Allowing the ability to modify previously-assigned array positions would
        introduce a mutation backdoor:
         1. Call build() when the array is exactly full so that the immutable array uses the same backing array
         2. Continue using the builder to remove or re-assign previous elements modifying the immutable array

        This optimization is safe if you can only read and append to the builder because:
         1. Reading doesn't modify the immutable array anyway
         2. Continuing to use the builder to append more elements would end up creating a new backing array because
         this optimization only applies when calling build() with the array exactly full.
         */
        if (baseType == GENERIC) {
            suppress("UNCHECKED_CAST")
            statement(
                "if (size == values.size) return ${baseType.generatedClassName}(values as Array<%T>)",
                baseType.type,
            )
        } else {
            statement("if (size == values.size) return ${baseType.generatedClassName}(values)")
        }
        emptyLine()
        if (baseType == GENERIC) {
            statement("return copyFrom(source = values as Array<%T>, startIndex = 0, size = size)", baseType.type)
        } else {
            statement("return copyFrom(source = values, startIndex = 0, size = size)")
        }
    }
}

/**
 * Ensures that the backing array is large enough to add more elements.
 *
 * IMPORTANT:
 * When creating a larger backing array, don't modify the existing array because build() may have been called on a full
 * array which ends up sharing the same backing array with the generated immutable array.  See the warning in
 * [addBuilderBuildFunction] for more specifics.
 */
private fun TypeSpec.Builder.addBuilderEnsureCapacityFunction() {
    function(
        modifiers = listOf(KModifier.PRIVATE),
        name = "ensureCapacity",
        parameters = { "minCapacity"<Int>() },
    ) {
        statement("val newCapacity = BuilderUtils.computeNewCapacity(values.size, minCapacity)")
        statement("if (newCapacity == values.size) return")
        emptyLine()
        statement("values = values.copyOf(newCapacity)")
    }
}

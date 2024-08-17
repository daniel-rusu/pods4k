package com.danrusu.pods4k.immutableArrays

internal object ImmutableArrayConfig {
    const val NUM_COMPONENT_N_FUNCTIONS = 5

    val packageName: String = BaseType::class.java.`package`.name
    val specializationPackageName: String = "$packageName.multiplicativeSpecializations"
}

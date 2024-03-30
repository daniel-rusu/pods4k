package com.danrusu.pods4k.immutableArrays.emptySingletons

internal object EmptyIterator : Iterator<Nothing> {
    override fun hasNext(): Boolean = false

    override fun next(): Nothing = throw NoSuchElementException()
}

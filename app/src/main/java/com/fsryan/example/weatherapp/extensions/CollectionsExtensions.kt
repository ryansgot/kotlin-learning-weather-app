package com.fsryan.example.weatherapp.extensions

fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()

inline fun <T, R : Any> Iterable<T>.firstResult(transformation: (T) -> R?): R {
    for (element in this) {
        val result = transformation(element)
        if (result != null) return result
    }
    throw NoSuchElementException("No element was found")
}
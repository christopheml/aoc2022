package com.github.christopheml.aoc2022.common

fun String.halves(): Pair<String, String> {
    val cutPoint = this.length / 2
    return Pair(this.substring(0, cutPoint), this.substring(cutPoint))
}

fun String.asList(): List<Char> {
    return this.toCharArray().asList()
}

fun String.asSet(): Set<Char> {
    return this.toCharArray().toSet()
}

fun String.toPair(separator: Char): Pair<String, String> {
    return when (val cutPoint = this.indexOf(separator)) {
        -1 -> Pair(this, "")
        else -> Pair(this.substring(0, cutPoint), this.substring(cutPoint + 1))
    }
}
fun String.toRange(separator: Char = '-'): IntRange {
    val cutPoint = this.indexOf(separator)
    assert(cutPoint > 0) { "Invalid range representation: $this" }
    return IntRange(this.substring(0, cutPoint).toInt(), this.substring(cutPoint + 1).toInt())
}

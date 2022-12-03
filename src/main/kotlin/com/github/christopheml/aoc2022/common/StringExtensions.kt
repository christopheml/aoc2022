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

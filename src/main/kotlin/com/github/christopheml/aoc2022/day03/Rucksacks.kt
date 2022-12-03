package com.github.christopheml.aoc2022.day03

import com.github.christopheml.aoc2022.common.*
import com.github.christopheml.aoc2022.common.runners.Solution

class Rucksacks : Solution<String, Int>(3) {
    override fun partOne(input: Input<String>): Int =
        input.asSequence()
            .filterNot { it.isEmpty() }
            .map { it.halves() }
            .map { it.map(String::asSet) }
            .map { it.first.intersect(it.second) }
            .sumOf { priority(it.first()) }

    override fun partTwo(input: Input<String>): Int =
        input.asSequence()
            .filterNot { it.isEmpty() }
            .map(String::asSet)
            .chunked(3)
            .map { it[0].intersect(it[1]).intersect(it[2]) }
            .sumOf { priority(it.first()) }

    override fun input() = ::TextInput
}

fun priority(item: Char): Int = if (item.isUpperCase()) item - 'A' + 27 else item - 'a' + 1

fun main() {
    Rucksacks().run()
}

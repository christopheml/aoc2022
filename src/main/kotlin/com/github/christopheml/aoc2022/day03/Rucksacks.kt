package com.github.christopheml.aoc2022.day03

import com.github.christopheml.aoc2022.common.*
import com.github.christopheml.aoc2022.common.runners.Solution

class Rucksacks : Solution<Int>(3) {
    override fun partOne(input: Input): Int =
        input.multi
            .asSequence()
            .map { it.halves() }
            .map { it.map(String::toSet) }
            .map { it.first.intersect(it.second) }
            .sumOf { priority(it.first()) }

    override fun partTwo(input: Input): Int =
        input.multi
            .asSequence()
            .map(String::toSet)
            .chunked(3)
            .map { it[0].intersect(it[1]).intersect(it[2]) }
            .sumOf { priority(it.first()) }

}

fun priority(item: Char): Int = if (item.isUpperCase()) item - 'A' + 27 else item - 'a' + 1

fun main() {
    Rucksacks().run()
}

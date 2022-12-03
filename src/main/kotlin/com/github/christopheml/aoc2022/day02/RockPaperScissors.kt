package com.github.christopheml.aoc2022.day02

import com.github.christopheml.aoc2022.common.Input
import com.github.christopheml.aoc2022.common.TextInput
import com.github.christopheml.aoc2022.common.runners.Solution

class RockPaperScissors : Solution<String, Int>(2) {

    private val simpleScore = mapOf(
        'A' to 'X' to 3 + 1,
        'A' to 'Y' to 6 + 2,
        'A' to 'Z' to 0 + 3,
        'B' to 'X' to 0 + 1,
        'B' to 'Y' to 3 + 2,
        'B' to 'Z' to 6 + 3,
        'C' to 'X' to 6 + 1,
        'C' to 'Y' to 0 + 2,
        'C' to 'Z' to 3 + 3,
    )

    private val resultBasedScore = mapOf(
        'A' to 'X' to 0 + 3,
        'A' to 'Y' to 3 + 1,
        'A' to 'Z' to 6 + 2,
        'B' to 'X' to 0 + 1,
        'B' to 'Y' to 3 + 2,
        'B' to 'Z' to 6 + 3,
        'C' to 'X' to 0 + 2,
        'C' to 'Y' to 3 + 3,
        'C' to 'Z' to 6 + 1,
    )

    override fun partOne(input: Input<String>): Int = calculateScore(input, simpleScore)

    override fun partTwo(input: Input<String>): Int = calculateScore(input, resultBasedScore)

    private fun calculateScore(input: Input<String>, scoring: Map<Pair<Char, Char>, Int>) = input
            .asSequence()
            .filterNot { it.isEmpty() }
            .map { Pair(it[0], it[2]) }
            .sumOf { scoring[it]!! }

    override fun input() = ::TextInput

}

fun main() {
    RockPaperScissors().run()
}

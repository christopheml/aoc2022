package com.github.christopheml.aoc2022.day01

import com.github.christopheml.aoc2022.common.Input
import com.github.christopheml.aoc2022.common.runners.Solution

class Calories : Solution<Int>(1) {

    override fun partOne(input: Input): Int =
        input.multi
            .split("")
            .maxOf { it.sumOf(String::toInt) }

    override fun partTwo(input: Input): Int =
        input.multi
            .split("")
            .map { it.sumOf(String::toInt) }
            .sortedDescending()
            .take(3)
            .sum()

}

fun main() {
    Calories().run()
}

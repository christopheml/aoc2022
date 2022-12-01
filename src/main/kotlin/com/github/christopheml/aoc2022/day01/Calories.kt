package com.github.christopheml.aoc2022.day01

import com.github.christopheml.aoc2022.common.Input
import com.github.christopheml.aoc2022.common.TextInput
import com.github.christopheml.aoc2022.common.runners.Solution

class Calories : Solution<String, Int>(1) {
    override fun partOne(input: Input<String>): Int =
        input
            .split("")
            .maxOf { it.sumOf(String::toInt) }

    override fun partTwo(input: Input<String>): Int =
        input
            .split("")
            .map { it.sumOf(String::toInt) }
            .sortedDescending()
            .take(3)
            .sum()

    override fun input() = ::TextInput
}


fun main() {
    Calories().run()
}

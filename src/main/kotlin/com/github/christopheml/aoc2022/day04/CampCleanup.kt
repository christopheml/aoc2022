package com.github.christopheml.aoc2022.day04

import com.github.christopheml.aoc2022.common.*
import com.github.christopheml.aoc2022.common.runners.Solution

class CampCleanup : Solution<String, Int>(4) {

    override fun partOne(input: Input<String>): Int =
        input.asSequence()
            .filterNot { it.isEmpty() }
            .map { it.toPair(',') }
            .map { it.map { value -> value.toRange() } }
            .count { it.first.fullyOverlaps(it.second) || it.second.fullyOverlaps(it.first) }

    override fun partTwo(input: Input<String>): Int =
        input.asSequence()
            .filterNot { it.isEmpty() }
            .map { it.toPair(',') }
            .map { it.map { value -> value.toRange() } }
            .count { it.first.overlaps(it.second) }

    override fun input() = ::TextInput

}

fun main() {
    CampCleanup().run()
}

package com.github.christopheml.aoc2022.day04

import com.github.christopheml.aoc2022.common.*
import com.github.christopheml.aoc2022.common.runners.Solution

class CampCleanup : Solution<Int>(4) {

    override fun partOne(input: Input): Int =
        input.multi
            .asSequence()
            .map { it.toPair(',') }
            .map { it.map { value -> value.toRange() } }
            .count { it.first.fullyOverlaps(it.second) || it.second.fullyOverlaps(it.first) }

    override fun partTwo(input: Input): Int =
        input.multi
            .asSequence()
            .map { it.toPair(',') }
            .map { it.map { value -> value.toRange() } }
            .count { it.first.overlaps(it.second) }

}

fun main() {
    CampCleanup().run()
}

package com.github.christopheml.aoc2022.day06

import com.github.christopheml.aoc2022.common.Input
import com.github.christopheml.aoc2022.common.runners.Solution

class CommunicationSystem : Solution<Int>(6) {
    override fun partOne(input: Input): Int = findMarker(input, 4)

    override fun partTwo(input: Input): Int = findMarker(input, 14)

    private fun findMarker(input: Input, markerLength: Int) =
        input.single.value
            .windowed(markerLength)
            .indexOfFirst { it.toSet().size == markerLength } + markerLength

}

fun main() {
    CommunicationSystem().run()
}

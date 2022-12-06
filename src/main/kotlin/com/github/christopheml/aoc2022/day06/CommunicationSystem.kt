package com.github.christopheml.aoc2022.day06

import com.github.christopheml.aoc2022.common.Input
import com.github.christopheml.aoc2022.common.TextInput
import com.github.christopheml.aoc2022.common.runners.Solution

class CommunicationSystem : Solution<String, Int>(6) {
    override fun partOne(input: Input<String>): Int = findMarker(input, 4)

    override fun partTwo(input: Input<String>): Int = findMarker(input, 14)

    private fun findMarker(input: Input<String>, markerLength: Int) =
        input.first()
            .asSequence()
            .windowed(markerLength)
            .indexOfFirst { it.toSet().size == markerLength } + markerLength

    override fun input() = ::TextInput

}

fun main() {
    CommunicationSystem().run()
}

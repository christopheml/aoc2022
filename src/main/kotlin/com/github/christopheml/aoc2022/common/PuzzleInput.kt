package com.github.christopheml.aoc2022.common

class PuzzleInput(private val day: Int) {

    fun asList(): List<String> {
        return PuzzleInput::class.java.getResource("/inputs/day%02d.txt".format(day))!!.readText()
            .lines()
    }

    fun asSingleLine(): String {
        return asList()[0]
    }

}

package com.github.christopheml.aoc2022.common.runners

import com.github.christopheml.aoc2022.common.Input

abstract class Solution<In, Out>(private val day: Int) {

    abstract fun partOne(input: Input<In>): Out
    abstract fun partTwo(input: Input<In>): Out
    abstract fun input(): (Int) -> Input<In>

    fun run() {
        println("Solution for day %02d".format(day))
        val input = input().invoke(day)
        runPart(1, input, this::partOne)
        runPart(2, input, this::partTwo)
    }

    private fun runPart(number: Int, input: Input<In>, runnable: (Input<In>) -> Out) {
        val timer = Timer()
        val result = runnable.invoke(input)
        val time = timer.readString()

        var representation = when (result) {
            null -> "<no result>"
            is String -> result
            else -> result.toString()
        }
        println("\tPart %d (time: %s): %s".format(number, time, representation))
    }

}

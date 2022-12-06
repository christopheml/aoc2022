package com.github.christopheml.aoc2022.day05

import com.github.christopheml.aoc2022.common.Input
import com.github.christopheml.aoc2022.common.runners.Solution

class Crates : Solution<String>(5) {
    override fun partOne(input: Input): String =
        Crane(input)
            .crateMover9000()
            .topCrates()

    override fun partTwo(input: Input): String =
        Crane(input)
            .crateMover9001()
            .topCrates()

}

class Crane(input: Input) {

    private val stacks: List<ArrayDeque<String>>
    private val operations: List<Triple<Int, Int, Int>>

    init {
        val inputParts = input.multi.split("")
        stacks = readStacks(inputParts[0])
        operations = readOperations(inputParts[1])
    }

    fun crateMover9000(): Crane {
        operations.forEach { operation ->
            repeat(operation.first) { stacks[operation.third - 1].addFirst(stacks[operation.second - 1].removeFirst()) }
        }
        return this
    }

    fun crateMover9001(): Crane {
        operations.forEach { operation ->
            stacks[operation.third - 1].addAll(0, stacks[operation.second - 1].take(operation.first))
            repeat(operation.first) { stacks[operation.second - 1].removeFirst() }
        }
        return this
    }

    fun topCrates() = stacks.joinToString("") { it.first() }

    private fun readOperations(input: List<String>): List<Triple<Int, Int, Int>> =
        input.map {
            val parts = it.split(" ")
            Triple(parts[1].toInt(), parts[3].toInt(), parts[5].toInt())
        }

    private fun readStacks(input: List<String>): List<ArrayDeque<String>> {
        // IntelliJ kept stripping trailing whitespace from my input >:(
        val stackDefs = input.filter { it.startsWith("[") }
        val stackCount = (stackDefs.maxOf { it.length } + 1) / 4
        val stacks = (0 until stackCount).map { ArrayDeque<String>() }
        input.forEach {
            if (it.startsWith("[")) {
                for (i in 0 until stackCount) {
                    val cratePosition = i * 4 + 1
                    if (cratePosition < it.length && it[cratePosition] != ' ') {
                        stacks[i].addLast(it[cratePosition].toString())
                    }
                }
            }
        }
        return stacks
    }

}

fun main() {
    Crates().run()
}

package com.github.christopheml.aoc2022.day01

import com.github.christopheml.aoc2022.common.PuzzleInput
import com.github.christopheml.aoc2022.common.split

fun main() {
    val sortedCalories = PuzzleInput(1)
        .asList()
        .split("")
        .map { it.map { element -> element.toInt() } }
        .map { it.sum() }
        .sortedDescending()

    val mostCalories = sortedCalories.first()

    println("The elf with most calories has $mostCalories calories")

    val threeMostCalories = sortedCalories.subList(0, 3).sum()

    println("The three elves with most calories have $threeMostCalories calories")

}

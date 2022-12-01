package com.github.christopheml.aoc2022.day01

import com.github.christopheml.aoc2022.common.TextInput

fun main() {
    val sortedCalories = TextInput(1)
        .split("")
        .map { it.sumOf(String::toInt) }
        .sortedDescending()

    val mostCalories = sortedCalories.first()
    println("The elf with most calories has $mostCalories calories")

    val threeMostCalories = sortedCalories.subList(0, 3).sum()
    println("The three elves with most calories have $threeMostCalories calories")
}

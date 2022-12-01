package com.github.christopheml.aoc2022.common

interface Input<T> {

    fun asList(): List<T>

    fun asSequence(): Sequence<T>

    fun split(separator: T): List<List<T>>

    fun first(): T

    fun last(): T

}

abstract class ListInput<T>(day: Int, elementMapper: (String) -> T): Input<T> {

    private val elements: List<T>

    init {
        elements = rawInput(day).map(elementMapper)
    }

    override fun asList(): List<T> = elements

    override fun asSequence() = elements.asSequence()

    override fun split(separator: T): List<List<T>> = elements.split(separator)

    override fun first(): T = elements.first()

    override fun last(): T = elements.last()

}

class TextInput(day: Int): ListInput<String>(day, { it })

class IntInput(day: Int): ListInput<Int>(day, String::toInt)

fun rawInput(day: Int): Iterable<String> {
    return object {}.javaClass.getResource("/inputs/day%02d.txt".format(day))!!.readText().lines()
}

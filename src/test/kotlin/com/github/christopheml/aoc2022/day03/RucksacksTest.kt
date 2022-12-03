package com.github.christopheml.aoc2022.day03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RucksacksTest {

    @Test
    internal fun priority() {
        assertEquals(1, priority('a'))
        assertEquals(5, priority('e'))
        assertEquals(52, priority('Z'))
        assertEquals(28, priority('B'))
    }

}

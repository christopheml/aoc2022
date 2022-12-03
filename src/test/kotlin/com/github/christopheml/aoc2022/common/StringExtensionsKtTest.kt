package com.github.christopheml.aoc2022.common

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class StringExtensionsKtTest {

    @Test
    internal fun halves() {
        assertEquals(Pair("abc", "def"), "abcdef".halves())
    }

}

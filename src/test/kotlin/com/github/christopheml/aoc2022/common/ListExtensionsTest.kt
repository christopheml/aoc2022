package com.github.christopheml.aoc2022.common

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ListExtensionsTest {

    @Test
    fun list_split_minimal_test() {
        assertThat(listOf(1,2,3).split(2))
            .containsExactly(listOf(1), listOf(3))
    }

    @Test
    fun list_split_longer_sublist_test() {
        assertThat(listOf(1,2,3,4).split(3))
            .containsExactly(listOf(1,2), listOf(4))
    }

    @Test
    fun list_split_separator_first() {
        assertThat(listOf(1, 2, 3).split(1))
            .containsExactly(listOf(2, 3))
    }

    @Test
    fun list_split_separator_last() {
        assertThat(listOf(1, 2, 3).split(3))
            .containsExactly(listOf(1, 2))
    }

    @Test
    fun list_real_use_cae() {
        val input = listOf(
            "GHD",
            "BBE",
            "",
            "FGU",
            ""
        )
        assertThat(input.split(""))
            .containsExactly(
                listOf("GHD", "BBE"),
                listOf("FGU")
            )
    }


}

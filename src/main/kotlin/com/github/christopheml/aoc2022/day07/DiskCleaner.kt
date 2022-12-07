package com.github.christopheml.aoc2022.day07

import com.github.christopheml.aoc2022.common.Input
import com.github.christopheml.aoc2022.common.runners.Solution
import java.nio.file.Path
import java.nio.file.Paths

class DiskCleaner : Solution<Long>(7) {
    override fun partOne(input: Input): Long {
        return fileSystem(input).directorySizes().filter { it <= 100000 }.sum()
    }

    override fun partTwo(input: Input): Long {
        val directorySizes = fileSystem(input).directorySizes()
        val spaceToFree = directorySizes.max() - 40000000
        return directorySizes.filter { it >= spaceToFree }.min()
    }

    private fun fileSystem(input: Input): FileSystem {
        val fileSystem = FileSystem()
        val terminal = input.multi
            .asList()
            .drop(1)
            .toMutableList()

        while (terminal.isNotEmpty()) {
            val command = terminal.removeFirst()
            if (command == "\$ cd /") fileSystem.navigateToRoot()
            else if (command == "\$ cd ..") fileSystem.navigateUp()
            else if (command.startsWith("\$ cd ")) fileSystem.navigateTo(command.substring(5))
            else if (command == "$ ls") {
                var size: Long = 0
                while (terminal.isNotEmpty() && !terminal.first().startsWith("\$")) {
                    val file = terminal.removeFirst().split(" ")
                    if (file[0] != "dir") size += file[0].toLong()
                }
                fileSystem.setDirectorySize(size)
            }
        }
        return fileSystem
    }
}

class FileSystem {

    private var path: Path = Paths.get("/")

    private val directorySizes: MutableMap<String, Long> = HashMap()

    fun navigateTo(directory: String) {
        path = path.resolve(directory)
    }

    fun navigateUp() {
        path = path.parent
    }

    fun navigateToRoot() {
        path = Paths.get("/")
    }

    fun setDirectorySize(size: Long) {
        directorySizes[path.toString()] = size
    }

    fun directorySizes(): List<Long> =
        directorySizes.keys.map {
            directorySizes.filter { e -> e.key.startsWith(it) }.values.sum()
        }

}

fun main() {
    DiskCleaner().run()
}

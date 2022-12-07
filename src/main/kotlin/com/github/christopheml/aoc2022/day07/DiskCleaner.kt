package com.github.christopheml.aoc2022.day07

import com.github.christopheml.aoc2022.common.Input
import com.github.christopheml.aoc2022.common.runners.Solution

class DiskCleaner : Solution<Long>(7) {
    override fun partOne(input: Input): Long {
        return fileSystem(input).sizeOfBiggestDirectories()
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
                while (terminal.isNotEmpty() && !terminal.first().startsWith("\$")) {
                    val file = terminal.removeFirst().split(" ")
                    if (file[0] != "dir") fileSystem.addFile(file[1], file[0].toLong())
                }
            }
        }
        return fileSystem
    }

    override fun partTwo(input: Input): Long {
        return fileSystem(input).sizeOfDirectoryToDelete()
    }
}

class FileSystem {

    val root = Directory("/", null)
    var workingDirectory = root

    fun navigateTo(directory: String) {
        workingDirectory.addDirectory(directory)
        workingDirectory = workingDirectory.getChild(directory)
    }

    fun navigateUp() {
        workingDirectory = workingDirectory.parent!!
    }

    fun navigateToRoot() {
        workingDirectory = root
    }

    fun addFile(name: String, size: Long) {
        workingDirectory.addFile(name, size)
    }

    fun sizeOfBiggestDirectories(): Long {
        val sizes = HashMap<String, Long>()
        root.size(sizes)
        return sizes.values.filter { it <= 100000 }.sum()
    }

    fun sizeOfDirectoryToDelete(): Long {
        val sizes = HashMap<String, Long>()
        val spaceToFree = 30000000 - (70000000 - root.size(sizes))
        return sizes.values.filter { it >= spaceToFree }.minOf { it }
    }

}
class Directory(val name: String, val parent: Directory?) {

    val path: String = (parent?.path ?: "") + "/" + name
    private val directories: MutableMap<String, Directory> = HashMap()
    private val files: MutableMap<String, File> = HashMap()
    fun addFile(name: String, size: Long) {
        files.putIfAbsent(name, File(name, size, this))
    }

    fun addDirectory(name: String): Directory {
        val directory = Directory(name, this)
        directories.putIfAbsent(name, directory)
        return directory
    }

    fun getChild(name: String) = directories[name]!!

    fun size(cache: MutableMap<String, Long>): Long {
        val size = files.values.sumOf { it.size } + directories.values.sumOf { it.size(cache) }
        cache[path] = size
        return size
    }


}

data class File(val name: String, val size: Long, val parent: Directory)

fun main() {
    DiskCleaner().run()
}

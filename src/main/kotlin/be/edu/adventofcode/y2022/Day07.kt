package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines

class Day07 {
    fun part1(input: Lines): Long {
        val instructions = input.get().map { Instruction.parse(it) }
        instructions.fold(mutableListOf(Directory("/"))) { dirtree, instruction -> instruction.execute(dirtree) }
        return instructions.filterIsInstance<Directory>().map { it.size() }.filter { it <= 100000 }.sumOf { it }
    }

    fun part2(input: Lines): Long {
        val instructions = input.get().map { Instruction.parse(it) }
        val dirtree = mutableListOf(Directory("/"))
        instructions.fold(dirtree) { tree, instruction -> instruction.execute(tree) }

        val freeSpace = 70000000 - dirtree.first().size()
        val spaceRequired = 30000000 - freeSpace
        return instructions.filterIsInstance<Directory>().map { it.size() }.filter { it >= spaceRequired }.minOf { it }
    }

    interface Instruction {
        companion object {
            fun parse(input: String): Instruction {
                if (input == "$ ls") return ListContent()
                if (input.startsWith("$ cd")) return ChangeDirectory(input.removePrefix("$ cd "))
                if (input.startsWith("dir")) return Directory(input.removePrefix("dir "))
                else {
                    val tokens = input.split(' ')
                    return File(tokens.last(), tokens.first().toLong())
                }
            }
        }

        fun execute(dirtree: MutableList<Directory>): MutableList<Directory>
    }

    data class ChangeDirectory(val arg: String) : Instruction {
        override fun execute(dirtree: MutableList<Directory>): MutableList<Directory> {
            if (arg == "/") {
                return mutableListOf(dirtree.first())
            }
            if (arg == "..") {
                dirtree.removeLast()
            } else {
                dirtree.add(dirtree.last().findDirectory(arg))
            }
            return dirtree
        }
    }

    class ListContent() : Instruction {
        override fun execute(dirtree: MutableList<Directory>): MutableList<Directory> {
            return dirtree
        }
    }

    interface FileSystem : Instruction {
        fun name(): String

        fun size(): Long

        override fun execute(dirtree: MutableList<Directory>): MutableList<Directory> {
            dirtree.last().addContent(this)
            return dirtree
        }
    }

    data class File(val name: String, val size: Long) : FileSystem {
        override fun name(): String = name

        override fun size(): Long = size
    }

    data class Directory(val name: String, val content: MutableList<FileSystem> = mutableListOf()) : FileSystem {
        override fun name(): String = name

        override fun size(): Long = content.sumOf { it.size() }

        fun addContent(toAdd: FileSystem): Directory {
            content.add(toAdd)
            return this;
        }

        fun findDirectory(name: String): Directory {
            return content.filterIsInstance<Directory>().first { it.name() == name }
        }
    }
}

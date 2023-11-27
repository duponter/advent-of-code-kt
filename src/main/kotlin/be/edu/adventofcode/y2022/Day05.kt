package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import be.edu.adventofcode.grid.transpose
import be.edu.adventofcode.y2017.day10.split

class Day05 {
    fun part1(input: Lines): String {
        val lines = input.get()
        val split = lines.split(lines.indexOf(""))

        val stacks: List<ArrayDeque<String>> = composeStacks(split.first)
        val arranged = split.second.drop(1)
            .map { Instruction.parse(it) }
            .fold(stacks) { stack, instruction -> instruction.moveOneByOne(stack) }

        return arranged.joinToString("") { it.first() }
    }

    fun part2(input: Lines): String {
        val lines = input.get()
        val split = lines.split(lines.indexOf(""))

        val stacks: List<ArrayDeque<String>> = composeStacks(split.first)
        val arranged = split.second.drop(1)
            .map { Instruction.parse(it) }
            .fold(stacks) { stack, instruction -> instruction.moveAllAtOnce(stack) }

        return arranged.joinToString("") { it.first() }
    }

    private fun composeStacks(input: List<String>): List<ArrayDeque<String>> {
        val maxLineLength = input.dropLast(1).maxOf { it.length }
        return input.dropLast(1)
            .map { it.padEnd(maxLineLength, ' ') }
            .map { it.chunked(1) }
            .transpose()
            .filterIndexed { index, _ -> (index - 1) % 4 == 0 }
            .map { it.filter { crate -> crate.isNotBlank() } }
            .map { ArrayDeque(it) }
    }

    data class Instruction(val count: Int, val src: Int, val dest: Int) {

        companion object {
            fun parse(input: String): Instruction {
                val destructured = StringDestructure("move (\\d+) from (\\d+) to (\\d+)").triple(input)
                return Instruction(destructured.first.toInt(), destructured.second.toInt(), destructured.third.toInt())
            }
        }

        fun moveOneByOne(stacks: List<ArrayDeque<String>>): List<ArrayDeque<String>> {
            val sourceStack = stacks[src - 1]
            val destinationStack = stacks[dest - 1]
            repeat(count) {
                destinationStack.addFirst(sourceStack.removeFirst())
            }
            return stacks
        }

        fun moveAllAtOnce(stacks: List<ArrayDeque<String>>): List<ArrayDeque<String>> {
            val sourceStack = stacks[src - 1]
            val destinationStack = stacks[dest - 1]
            destinationStack.addAll(0, sourceStack.take(count))
            repeat(count) {
                sourceStack.removeFirst()
            }
            return stacks
        }
    }
}

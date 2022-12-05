package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import be.edu.adventofcode.grid.transpose
import be.edu.adventofcode.y2017.day10.split

class Day05 {
    fun part1(input: Lines): String {
        val lines = input.get()
        val split = lines.split(lines.indexOf(""))

        val maxLineLength = split.first.dropLast(1).maxOf { it.length }
        val stacks: List<ArrayDeque<String>> = split.first.dropLast(1)
            .map { it.padEnd(maxLineLength, ' ') }
            .map { it.chunked(1) }
            .transpose()
            .filterIndexed { index, _ -> (index - 1) % 4 == 0 }
            .map { it.filter { crate -> crate.isNotBlank() } }
            .map { ArrayDeque(it) }

        val arranged = split.second.drop(1)
            .map { Instruction.parse(it) }
            .fold(stacks) { stack, instruction -> instruction.execute(stack) }

        return arranged.joinToString("") { it.first() }
    }

    data class Instruction(val count: Int, val src: Int, val dest: Int) {
        companion object {
            fun parse(input: String): Instruction {
                val destructured = StringDestructure("move (\\d+) from (\\d+) to (\\d+)").triple(input)
                return Instruction(destructured.first.toInt(), destructured.second.toInt(), destructured.third.toInt())
            }
        }

        fun execute(stacks: List<ArrayDeque<String>>): List<ArrayDeque<String>> {
            val sourceStack = stacks[src - 1]
            val destinationStack = stacks[dest - 1]
            repeat(count) {
                destinationStack.addFirst(sourceStack.removeFirst())
            }
            return stacks
        }
    }


    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }
}

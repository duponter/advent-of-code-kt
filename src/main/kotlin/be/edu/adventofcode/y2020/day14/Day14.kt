package be.edu.adventofcode.y2020.day14

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import be.edu.adventofcode.fromDecimal
import be.edu.adventofcode.toDecimal

class Day14 {
    fun part1(input: Lines): Int {
        val memory: MutableMap<Int, Int> = mutableMapOf()

        input.get().fold("") { acc, next -> executeNext(memory, acc, next) }

        println(memory)
        return memory.values.sum()
    }

    private fun executeNext(memory: MutableMap<Int, Int>, mask: String, next: String): String {
        val newMask = parseMask(next)
        return if (newMask != null)
            newMask
        else {
            val (key, value) = parseWrite(next)
            memory[key] = applyMask(mask, value)
            mask
        }
    }

    private fun applyMask(mask: String, value: Int): Int {
        val binaryValue = fromDecimal(value).padStart(mask.length, '0')
        return binaryValue.toCharArray()
            .zip(mask.toCharArray())
            .map { if (it.second == 'X') it.first else it.second }
            .joinToString("")
            .let { toDecimal(it) }
    }

    private fun parseMask(input: String): String? = if (input.startsWith("mask = ")) input.drop(7) else null

    private fun parseWrite(input: String): Pair<Int, Int> = StringDestructure("mem\\[(\\d+)\\] = (\\d+)").pair(input).let { it.first.toInt() to it.second.toInt() }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

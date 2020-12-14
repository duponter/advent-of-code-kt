package be.edu.adventofcode.y2020.day14

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import be.edu.adventofcode.fromDecimal
import be.edu.adventofcode.toDecimal

class Day14 {
    fun part1(input: Lines): Long {
        val memory: MutableMap<Int, Long> = mutableMapOf()
        input.get().fold("") { acc, next -> executeNext(memory, acc, next) }
        return memory.values.sum()
    }

    private fun executeNext(memory: MutableMap<Int, Long>, mask: String, next: String): String {
        val newMask = parseMask(next)
        return if (newMask != null) {
            newMask
        } else {
            val (key, value) = parseWrite(next)
            memory[key] = applyMaskToValue(mask, value)
            mask
        }
    }

    private fun applyMaskToValue(mask: String, value: Int): Long {
        val binaryValue = fromDecimal(value).padStart(mask.length, '0')
        return binaryValue.toCharArray()
            .zip(mask.toCharArray())
            .map { if (it.second == 'X') it.first else it.second }
            .joinToString("")
            .let { toDecimal(it) }
    }

    fun part2(input: Lines): Long {
        val memory: MutableMap<Long, Long> = mutableMapOf()
        input.get().fold("") { acc, next -> executeNextV2(memory, acc, next) }
        return memory.values.sum()
    }

    private fun executeNextV2(memory: MutableMap<Long, Long>, mask: String, next: String): String {
        val newMask = parseMask(next)
        return if (newMask != null) {
            newMask
        } else {
            val (key, value) = parseWrite(next)
            applyMaskToKey(mask, key).forEach { memory[it] = value.toLong() }
            mask
        }
    }

    private fun applyMaskToKey(mask: String, key: Int): List<Long> {
        val binaryValue = fromDecimal(key).padStart(mask.length, '0')
        return binaryValue.toCharArray()
            .zip(mask.toCharArray())
            .map { if (it.second == '0') it.first else it.second }
            .joinToString("")
            .let { replaceX(it) }
            .map { toDecimal(it) }
    }

    private fun replaceX(value: String): List<String> {
        if (!value.contains('X')) {
            return listOf(value)
        }
        return replaceX(value.replaceFirst('X', '0')).plus(replaceX(value.replaceFirst('X', '1')))
    }

    private fun parseMask(input: String): String? = if (input.startsWith("mask = ")) input.drop(7) else null

    private fun parseWrite(input: String): Pair<Int, Int> = StringDestructure("mem\\[(\\d+)\\] = (\\d+)").pair(input).let { it.first.toInt() to it.second.toInt() }
}

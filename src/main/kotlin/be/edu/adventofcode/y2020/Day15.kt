package be.edu.adventofcode.y2020

import be.edu.adventofcode.Text

class Day15 {
    fun part1(input: Text): Int = memoryGame(input, 2020)

    fun part2(input: Text): Int = memoryGame(input, 30000000)

    private fun memoryGame(input: Text, targetNumber: Int): Int {
        val turns = input.get().split(',').mapIndexed { index, number -> number.toInt() to index + 1 }
        val (startValue, startTurn) = turns.last()
        val memory = turns.dropLast(1).associate { it }.toMutableMap()
        return (startTurn + 1..targetNumber).fold(startValue) { prevValue, currentTurn -> playMemoryGame(memory, prevValue, currentTurn) }
    }

    private fun playMemoryGame(memory: MutableMap<Int, Int>, prevValue: Int, currentTurn: Int): Int =
        if (memory.containsKey(prevValue)) {
            val prevTurn = memory[prevValue]!!
            memory[prevValue] = currentTurn - 1
            currentTurn - 1 - prevTurn
        } else {
            memory[prevValue] = currentTurn - 1
            0
        }
}

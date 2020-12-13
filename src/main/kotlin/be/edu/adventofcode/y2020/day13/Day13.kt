package be.edu.adventofcode.y2020.day13

import be.edu.adventofcode.Lines
import kotlin.math.ceil

class Day13 {
    fun part1(input: Lines): Int {
        val tokens = input.get()
        val timestamp = tokens[0].toInt()
        return tokens[1].split(',')
            .asSequence()
            .filterNot { it == "x" }
            .map { it.toInt() }
            .map { it to ceil(timestamp.toDouble() / it).toInt() * it }
            .map { it.first to it.second - timestamp }
            .minByOrNull { it.second }!!
            .let { it.first * it.second }
    }

    fun part2(input: Lines): Long {
        val busses: Sequence<Pair<Int, Int>> = input.get().last()
            .split(',')
            .asSequence()
            .mapIndexed { index, bus -> bus to index }
            .filterNot { it.first == "x" }
            .map { it.first.toInt() to it.second }

        val maxBus = busses.maxByOrNull { it.first }!!
        val otherBusses = busses.sortedByDescending { it.first }.drop(1)

        val timestamp: Long = generateSequence(0L) { it + maxBus.first }
            .first { departAllInOrder(otherBusses, maxBus, it) }

        return busses.map { timestamp + it.second - maxBus.second }.minByOrNull { it }!!
    }

    private fun departAllInOrder(busses: Sequence<Pair<Int, Int>>, maxBus: Pair<Int, Int>, timestamp: Long): Boolean {
        return busses.all { (timestamp + it.second - maxBus.second) % it.first == 0L }
    }
}

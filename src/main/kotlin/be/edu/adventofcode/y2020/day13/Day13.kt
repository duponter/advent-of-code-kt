package be.edu.adventofcode.y2020.day13

import be.edu.adventofcode.Lines
import be.edu.adventofcode.calculations.Multiplications.Static.lcm
import kotlin.math.ceil
import kotlin.math.floor

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

    fun part2(input: Lines, start: Long = 0L): Long {
        val busses: Sequence<Pair<Int, Int>> = input.get().last()
            .split(',')
            .asSequence()
            .mapIndexed { index, bus -> bus to index }
            .filterNot { it.first == "x" }
            .map { it.first.toInt() to it.second }
        busses.forEach { println(it) }
        println("LCM = ${lcm(busses.map { it.first.toLong() })}")

        val maxBus = busses.maxByOrNull { it.first }!!
        val otherBusses = busses.sortedByDescending { it.first }.drop(1)

        return generateSequence(floor(start.toDouble() / maxBus.first).toLong()) { it + maxBus.first }
            .first { departAllInOrder(otherBusses, maxBus, it) }
            .let { it - maxBus.second }
    }

    private fun departAllInOrder(busses: Sequence<Pair<Int, Int>>, maxBus: Pair<Int, Int>, timestamp: Long): Boolean {
        return busses.all { (timestamp + it.second - maxBus.second) % it.first == 0L }
    }
}

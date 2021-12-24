package be.edu.adventofcode.y2017.day10

import be.edu.adventofcode.Text

class Day10 {
    fun part1(input: Text, size: Int): Int {
        val numbers = (0 until size).toList()
        val hash = KnotHash()
        return input.get().split(Regex(",\\s*")).map(String::toInt)
            .foldIndexed(Pair(numbers, 0)) { index, acc, length -> hash.singleRound(acc, index, length) }
            .first.take(2)
            .fold(1) { acc, i -> acc * i }
    }

    fun part2(input: Text, size: Int): String = KnotHash().calculate(input.get(), size)
}

fun <T> List<T>.reverseCycled(index: Int, length: Int): List<T> {
    val initialSplit = this.split(index)
    return if (initialSplit.second.size >= length) {
        val finalSplit = initialSplit.second.split(length)
        initialSplit.first.plus(finalSplit.first.reversed()).plus(finalSplit.second)
    } else {
        val start = length - initialSplit.second.size
        val finalSplit = initialSplit.first.split(start)
        val reversed = initialSplit.second.plus(finalSplit.first).reversed()
        val reversedSplit = reversed.split(initialSplit.second.size)
        reversedSplit.second.plus(finalSplit.second).plus(reversedSplit.first)
    }
}

fun <T> List<T>.split(index: Int): Pair<List<T>, List<T>> {
    val pair = Pair(this.take(index), this.drop(index))
    if (pair.first.size + pair.second.size != this.size) throw IllegalStateException("Split list sizes (${pair.first.size} and ${pair.second.size}) don't match original size ${this.size}")
    return pair
}

fun <T> List<T>.repeat(times: Int): List<T> = (1..times).fold(listOf()) { acc, _ -> acc.plus(this) }

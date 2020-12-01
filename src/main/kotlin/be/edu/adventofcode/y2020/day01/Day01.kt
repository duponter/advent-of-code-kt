package be.edu.adventofcode.y2020.day01

import be.edu.adventofcode.Lines

class Day01 {
    private fun <T, U> cartesianProduct(c1: Collection<T>, c2: Collection<U>): List<Pair<T, U>> {
        return c1.flatMap { lhsElem -> c2.map { rhsElem -> lhsElem to rhsElem } }
    }

    private fun <T, U, V> cartesianProduct(c1: Collection<T>, c2: Collection<U>, c3: Collection<V>): List<Triple<T, U, V>> {
        return c1.flatMap { el1 -> c2.flatMap { el2 -> c3.map { el3 -> Triple(el1, el2, el3) } } }
    }

    fun part1(input: Lines): Int {
        val entries: List<Int> = input.get().map { it.toInt() }
        return cartesianProduct(entries, entries)
                .first { it.first + it.second == 2020 }
                .let { it.first * it.second }
    }

    fun part2(input: Lines): Int {
        val entries: List<Int> = input.get().map { it.toInt() }
        return cartesianProduct(entries, entries, entries)
                .first { it.first + it.second + it.third == 2020 }
                .let { it.first * it.second * it.third }
    }
}

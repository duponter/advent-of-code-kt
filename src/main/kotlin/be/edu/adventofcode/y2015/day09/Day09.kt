package be.edu.adventofcode.y2015.day09

import be.edu.adventofcode.Lines

class Day09 {
    fun part1(input: Lines): Int {
        val regex = Regex("([\\w]+) to ([\\w]+) = (\\d+)")
        val map = input.get()
                .map { regex.matchEntire(it)!!.destructured }
                .map { Pair(Pair(it.component1(), it.component2()), it.component3().toInt()) }
                .toMap()
        return map.keys.flatMap { it.toList() }.toSet().toList().permutations()
                .map { it.fold(Pair("", 0), { prev, current -> Pair(current, prev.second + (map[Pair(prev.first, current)] ?: (map[Pair(current, prev.first)] ?: 0))) }).second }
                .minOrNull() ?: 0
    }

    fun part2(input: Lines): Int {
        val regex = Regex("([\\w]+) to ([\\w]+) = (\\d+)")
        val map = input.get()
                .map { regex.matchEntire(it)!!.destructured }
                .map { Pair(Pair(it.component1(), it.component2()), it.component3().toInt()) }
                .toMap()
        return map.keys.flatMap { it.toList() }.toSet().toList().permutations()
                .map { it.fold(Pair("", 0), { prev, current -> Pair(current, prev.second + (map[Pair(prev.first, current)] ?: (map[Pair(current, prev.first)] ?: 0))) }).second }
                .maxOrNull() ?: 0
    }
}

fun <T> List<T>.permutations(): List<List<T>> {
    if (this.size == 1) return listOf(this)
    val perms = mutableListOf<List<T>>()
    val toInsert = this[0]
    for (perm in this.drop(1).permutations()) {
        for (i in 0..perm.size) {
            val newPerm = perm.toMutableList()
            newPerm.add(i, toInsert)
            perms.add(newPerm)
        }
    }
    return perms
}
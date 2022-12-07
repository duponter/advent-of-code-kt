package be.edu.adventofcode.y2021

import be.edu.adventofcode.Lines

class Day12 {
    fun part1(input: Lines): Int {
        val caves: Map<String, Cave> = parseCaves(input)
        return Path().crawl(caves["start"]!!).distinct().filter { it.visited.last() == "end" }.size
    }

    fun part2(input: Lines): Int {
        val caves: Map<String, Cave> = parseCaves(input)
        val start = caves["start"]!!
        return caves.minus(listOf("start", "end")).values.map { Path2(it.name) }
            .flatMap { it.crawl(start) }
            .map { it.visited }
            .distinct()
            .filter { it.last() == "end" }
            .size
    }

    private fun parseCaves(input: Lines): Map<String, Cave> {
        val connections: List<List<String>> = input.get()
            .map { it.split("-") }

        val caves: Map<String, Cave> = connections.map { it.first() }.plus(connections.map { it.last() }).toSortedSet().associateWith { Cave(it) }

        connections.forEach {
            caves[it.first()]!!.connections.add(caves[it.last()]!!)
            caves[it.last()]!!.connections.add(caves[it.first()]!!)
        }
        caves["end"]!!.connections.clear()
        return caves
    }
}

data class Path(val visited: MutableList<String> = mutableListOf()) {
    fun crawl(cave: Cave): List<Path> {
        if (cave.small && visited.contains(cave.name)) {
            return listOf(this)
        }
        this.visited.add(cave.name)
        if (cave.connections.isEmpty()) {
            return listOf(this)
        }
        return cave.connections.flatMap { Path(visited.toMutableList()).crawl(it) }
    }
}

data class Path2(val twice: String, val visited: MutableList<String> = mutableListOf()) {
    fun crawl(cave: Cave): List<Path2> {
        if (cave.small && visited.contains(cave.name) && (cave.name != twice || visited.count { it == twice } == 2)) {
            return listOf(this)
        }
        this.visited.add(cave.name)
        if (cave.connections.isEmpty()) {
            return listOf(this)
        }
        return cave.connections.flatMap { Path2(twice, visited.toMutableList()).crawl(it) }
    }
}

data class Cave(val name: String, val small: Boolean, val connections: MutableList<Cave>) {
    constructor(name: String) : this(name, name == name.lowercase(), mutableListOf())

    override fun toString(): String {
        return "Cave(name=$name, small=$small, connections=${connections.map { "Cave(name=${it.name}, small=${it.small}" }})"
    }
}


package be.edu.adventofcode.y2021.day12

import be.edu.adventofcode.Lines

class Day12 {
    fun part1(input: Lines): Int {
        val connections: List<List<String>> = input.get()
            .map { it.split("-") }

        val caves: Map<String, Cave> = connections.map { it.first() }.plus(connections.map { it.last() }).toSortedSet().associateWith { Cave(it) }

        connections.forEach {
            caves[it.first()]!!.connections.add(caves[it.last()]!!)
            caves[it.last()]!!.connections.add(caves[it.first()]!!)
        }
        caves["end"]!!.connections.clear()

        return Path().crawl(caves["start"]!!).distinct().filter { it.visited.last() == "end" }.size
    }

    fun part2(input: Lines): Int {
        return input.get().count()
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

data class Cave(val name: String, val small: Boolean, val connections: MutableList<Cave>) {
    constructor(name: String) : this(name, name == name.lowercase(), mutableListOf())

    override fun toString(): String {
        return "Cave(name=$name, small=$small, connections=${connections.map { "Cave(name=${it.name}, small=${it.small}" }})"
    }
}


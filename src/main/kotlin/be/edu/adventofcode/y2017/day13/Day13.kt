package be.edu.adventofcode.y2017.day13

import be.edu.adventofcode.Lines

class Day13 {
    fun part1(input: Lines): Int {
        val defined = input.get().map { it.split(": ") }
                .map { Scanner(it.first().toInt(), it.last().toInt()) }
                .groupBy(Scanner::depth)
                .mapValues { it.value.single() }
        val scanners = (0..defined.keys.max()!!).minus(defined.keys).map { Scanner(it) }
                .plus(defined.values)
                .toSortedSet(Comparator { o1, o2 -> o1.depth - o2.depth })
        scanners.forEach { println(it) }

        return scanners.foldIndexed(0, { index, severity, scanner -> severity + scanner.caught(index) })
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

data class Scanner(val depth: Int, private val range: Int = 0) {
    fun caught(picosecond: Int): Int = if (positionAt(picosecond) == 0) severity() else 0

    private fun severity(): Int = depth * range

    private fun positionAt(picosecond: Int): Int {
        // 2: 0, 2, 4
        // 3: 0, 4, 8,
        // 4: 0, 6, 12
        // 5: 0, 8, 16
        // 6: 0, 10, 20
        return picosecond % ((range - 1) * 2)
    }
}

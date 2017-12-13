package be.edu.adventofcode.y2017.day13

import be.edu.adventofcode.Lines

class Day13 {
    fun part1(input: Lines): Int = severity(scanners(input))

    private fun scanners(input: Lines): Iterable<Scanner> {
        val defined = input.get().map { it.split(": ") }
                .map { Scanner(it.first().toInt(), it.last().toInt()) }
                .groupBy(Scanner::depth)
                .mapValues { it.value.single() }
        return (0..defined.keys.max()!!).minus(defined.keys).map { Scanner(it) }
                .plus(defined.values)
                .toSortedSet(Comparator { o1, o2 -> o1.depth - o2.depth })
    }

    private fun severity(scanners: Iterable<Scanner>): Int =
            scanners.foldIndexed(0, { index, severity, scanner -> severity + scanner.penalty(index) })

    fun part2(input: Lines): Int {
        val scanners = scanners(input)
        return delay(scanners) - scanners.count()
    }

    private tailrec fun delay(scanners: Iterable<Scanner>): Int =
            if (!caught(scanners)) scanners.count() else delay(listOf(Scanner(scanners.first().depth - 1)).plus(scanners))

    private fun caught(scanners: Iterable<Scanner>): Boolean =
            scanners.withIndex().filterNot { it.value.dummy() }.any { it.value.caught(it.index) }
}

data class Scanner(val depth: Int, private val range: Int = 0) {
    fun penalty(picosecond: Int): Int = if (caught(picosecond)) severity() else 0

    fun dummy(): Boolean = range == 0

    fun caught(picosecond: Int) = positionAt(picosecond) == 0

    private fun severity(): Int = depth * range

    private fun positionAt(picosecond: Int): Int = if (dummy()) -1 else picosecond % ((range - 1) * 2)
}

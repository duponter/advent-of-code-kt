package be.edu.adventofcode.y2024

import be.edu.adventofcode.Lines

class Day04 {
    fun part1(input: Lines): Int {
        val xmas = "XMAS".toRegex()
        val samx = "SAMX".toRegex()

        val multiView = MultiView(input.get())
        return multiView.horizontal()
            .plus(multiView.vertical())
            .plus(multiView.diagonalUp())
            .plus(multiView.diagonalDown())
            .sumOf { xmas.findAll(it).count() + samx.findAll(it).count() }
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }

    class MultiView(val lines: List<String>) {

        fun horizontal(): List<String> = lines

        fun vertical(): List<String> = transpose(lines)

        fun diagonalDown(): List<String> {
            return transpose(lines.indices.map { x -> lines[x].drop(x) + " ".repeat(x) }).map { it.trim() }.reversed()
                .plus(
                    transpose((1 until lines.size).map { y -> " ".repeat(lines[y].count() - y) + lines[y].take(y) }).map { it.trim() }
                        .reversed()
                        .filter { it.isNotBlank() }
                )
        }

        fun diagonalUp(): List<String> {
            return transpose(lines.indices.map { x -> " ".repeat(x) + lines[x].take(lines[x].count() - x) }
                .reversed()).map { it.trim() }
                .plus(
                    transpose(
                        lines.indices
                        .map { y -> lines[y].drop(lines[y].count() - y) + " ".repeat(lines[y].count() - y) }
                        .reversed())
                        .filter { it.isNotBlank() }
                        .map { it.trim() }
                )

        }

        private fun transpose(strings: List<String>): List<String> {
            return strings[0].indices.map { x ->
                strings.indices
                    .map { y -> strings[y][x] }
                    .joinToString("")
            }
        }
    }
}

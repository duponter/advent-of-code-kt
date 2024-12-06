package be.edu.adventofcode.y2024

import be.edu.adventofcode.Lines
import kotlin.math.min

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
        val mas = "MAS".toRegex()
        val sam = "SAM".toRegex()

        val lines = input.get()
        val multiView = MultiView(lines)

        val upIndices = findLetterA(multiView.diagonalUp(), mas)
            .plus( findLetterA(multiView.diagonalUp(), sam))
            .map { it.toUpPoint(lines.size - 1) }

        val downIndices = findLetterA(multiView.diagonalDown(), mas)
            .plus( findLetterA(multiView.diagonalDown(), sam))
            .map { it.toDownPoint(lines[0].length - 1) }

        return (upIndices intersect downIndices).size
    }

    private fun findLetterA(list: List<String>, regex: Regex): List<Cell> {
        return list.withIndex().flatMap { regex.findAll(it.value).map { mr -> Cell(it.index, mr.range.drop(1).first()) }.toList() }
    }

    class MultiView(val lines: List<String>) {

        fun horizontal(): List<String> = lines

        fun vertical(): List<String> = transpose(lines)

        // from top left to bottom right
        fun diagonalDown(): List<String> {
            return transpose(lines.indices.map { x -> lines[x].drop(x) + " ".repeat(x) }).map { it.trim() }.reversed()
                .plus(
                    transpose((1 until lines.size).map { y -> " ".repeat(lines[y].count() - y) + lines[y].take(y) }).map { it.trim() }
                        .reversed()
                        .filter { it.isNotBlank() }
                )
        }

        // from bottom left to top right
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

    data class Cell(val row: Int, val col: Int) {
        fun toUpPoint(ymax: Int): Point {
            return (if (row <= ymax) Point(0, row) else Point(row - ymax, ymax)).let { p -> Point(p.x + col, p.y - col) }
        }

        fun toDownPoint(xmax: Int): Point {
            return (if (row <= xmax) Point(xmax - row, 0) else Point(0, row - xmax)).let { p -> Point(p.x + col, p.y + col) }
        }
    }

    data class Point(val x: Int, val y: Int)
}

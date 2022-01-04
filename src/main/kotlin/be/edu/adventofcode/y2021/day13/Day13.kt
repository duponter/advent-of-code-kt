package be.edu.adventofcode.y2021.day13

import be.edu.adventofcode.Lines

class Day13 {
    fun part1(input: Lines): Int {
        val dots: List<Pair<Int, Int>> = parseDots(input)
        val paper: Paper = plot(dots)
        val folds = parseFolds(input)
//        folds.fold(paper) { p, fold -> fold.map(p) }.forEach { println(it) }
        return folds.first().map(paper).dotCount()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }

    private fun plot(dots: List<Pair<Int, Int>>): Paper {
        val dotsByLine = dots.groupBy({ it.second }) { it.first }
        val emptyRow = ".".repeat(dots.maxOf { it.first } + 1)
        return (0..dots.maxOf { it.second }).map {
            (dotsByLine[it] ?: emptyList())
                .fold(emptyRow) { row, col -> row.replaceRange(col, col + 1, "#") }
        }
    }

    private fun parseDots(input: Lines) = input.get().takeWhile { it.isNotBlank() }
        .map { it.split(',') }
        .map { Pair(it[0].toInt(), it[1].toInt()) }

    private fun parseFolds(input: Lines) = input.get().dropWhile { !it.startsWith("fold along") }
        .map { it.removePrefix("fold along ").split('=') }
        .map { Fold(it[0], it[1]) }
}

typealias Paper = List<String>

fun Paper.dotCount(): Int = sumOf { it.count { ch -> ch == '#' } }

fun Paper.foldUp(row: Int): Paper = this.foldDown(row).reversed()

fun Paper.foldDown(row: Int): Paper {
    val upper = this.take(row).reversed()
    val lower = this.drop(row + 1)
    return upper.zip(lower) { s1, s2 -> s1.zip(s2) { ch1, ch2 -> if (ch1 == '#') ch1 else ch2 } }
        .map { it.joinToString("") }
        .plus(upper.drop(lower.size))
        .plus(lower.drop(upper.size))
}

fun Paper.foldLeft(col: Int): Paper = this.foldRight(col)

fun Paper.foldRight(col: Int): Paper {
    val left = this.map { it.take(col).reversed() }
    val right = this.map { it.drop(col + 1) }
    return left.zip(right) { s1, s2 -> s1.zip(s2) { ch1, ch2 -> if (ch1 == '#') ch1 else ch2 }.joinToString("") + s1.drop(s2.length) + s2.drop(s1.length) }
}

data class Fold(val lines: Int, val up: Boolean) {
    constructor(direction: String, lines: String) : this(lines.toInt(), direction == "y")

    fun map(paper: Paper): Paper = if (up) paper.foldUp(lines) else paper.foldLeft(lines)
}

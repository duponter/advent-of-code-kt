package be.edu.adventofcode.y2021.day04

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.Matrix
import be.edu.adventofcode.grid.transpose

class Day04 {
    fun part1(input: Lines): Int {
        val lines: List<String> = input.get()
        val drawnNumbers = lines.first()
        val bingo = Bingo.parse(lines.drop(1), 5)
        return drawnNumbers.split(',')
            .map { it.toInt() }
            .fold(-1) { acc, called -> if (acc > -1) acc else bingo.draw(called) }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

data class Bingo(val boards: List<Board>) {
    companion object Parse {
        fun parse(lines: List<String>, size: Int): Bingo {
            return lines.chunked(size + 1) { it.drop(1).map { l -> l.trim().split(Regex(" +")).map { v -> Number(v.toInt()) } } }
                .map { Board(it) }.let { Bingo(it) }
        }
    }

    fun draw(called: Int): Int {
        return boards.fold(-1) { acc, board -> if (acc > -1) acc else board.draw(called) }
    }

    fun print(): String {
        return boards.joinToString("\n\n") { it.print() }
    }
}

data class Board(val numbers: Matrix<Number>) {
    fun draw(called: Int): Int {
        val marked: Number? = numbers.flatten().firstOrNull { it.draw(called) }
        return if (marked != null && wins()) score(called) else -1
    }

    private fun score(called: Int): Int {
        return numbers.flatten().filterNot { it.marked }.sumOf { it.value } * called
    }

    private fun wins(): Boolean {
        val winningRow: Boolean = numbers.any { it.all { n -> n.marked } }
        val winningCol: Boolean = numbers.transpose().any { it.all { n -> n.marked } }
        return (winningRow || winningCol)
    }

    fun print(): String {
        return numbers.joinToString("\n") { it.joinToString(" - ") { n -> n.print() } }
    }
}

data class Number(val value: Int, var marked: Boolean = false) {
    fun draw(called: Int): Boolean {
        marked = marked || value == called
        return value == called
    }

    fun print(): String {
        val formatted = String.format("%2d", value)
        return if (marked) "($formatted)" else " $formatted "
    }
}


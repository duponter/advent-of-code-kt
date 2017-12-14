package be.edu.adventofcode.y2017.day14

import be.edu.adventofcode.Text
import be.edu.adventofcode.y2017.day10.KnotHash

class Day14 {
    fun part1(input: Text): Int = knotHashToBinary(input.get()).map { it.count { it == '1' } }.sum()

    private fun knotHashToBinary(input: String): Iterable<String> {
        val hash = KnotHash()
        return (0..127).map { "$input-$it" }
                .map { hash.calculate(it, 256) }
                .map { it.asIterable().joinToString("") { Integer.toBinaryString(Integer.parseInt(it.toString(), 16)).padStart(4, '0') } }
    }

    fun part2(input: Text): Int {
        var squares = knotHashToBinary(input.get())
                .map { it.toCharArray().toTypedArray() }
                .toTypedArray()
                .mapIndexed { r, row -> row.mapIndexed { c, square -> toUsedSquare(square, r, c) }.filterNotNull() }
                .flatMap { it }

        var groups = 0

        do {
            squares = assembleGroup(squares.drop(1), squares.take(1))
            groups++
        } while (squares.isNotEmpty())

        return groups
    }

    private tailrec fun assembleGroup(all: List<UsedSquare>, neighbours: List<UsedSquare>): List<UsedSquare> {
        val candidates = neighbours.flatMap { it.candidateNeighbours() }
        val partition = all.partition(candidates::contains)
        return if (partition.first.isEmpty()) partition.second else assembleGroup(partition.second, partition.first)
    }

    private fun toUsedSquare(input: Char, row: Int, col: Int): UsedSquare? = when (input) {
        '1' -> UsedSquare(row, col)
        else -> null
    }
}

data class UsedSquare(private val row: Int, private val col: Int) {
    fun candidateNeighbours(): List<UsedSquare> =
            listOf(UsedSquare(row + 1, col), UsedSquare(row - 1, col), UsedSquare(row, col + 1), UsedSquare(row, col + 1))
}
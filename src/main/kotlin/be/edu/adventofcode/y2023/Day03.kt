package be.edu.adventofcode.y2023

import be.edu.adventofcode.Lines

class Day03 {
    fun part1(input: Lines): Int {
        val matrix = LinearMatrix(input.get().joinToString(""), input.get().first().length)

        val tokens: List<String> = input.get()
            .flatMap { it.split(Regex("\\D")).filterNot { s -> s.isEmpty() } }


        return tokens
            .filterIndexed { index, s -> matrix.isPartNumber(s, tokens.take(index + 1).count { d -> d == s }) }
            .sumOf { it.toInt() }
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }
}

data class LinearMatrix(val data: String, val cols: Int) {

    fun indexOf(search: String): Int = data.indexOf(search)

    fun isPartNumber(search: String, count: Int): Boolean {
        var indexOf = data.indexOf(search)
        for (start in count - 1 downTo 1) {
            indexOf = data.indexOf(search, indexOf + search.length)
        }

        val prevRow = prevRow(prevCol(indexOf))..prevRow(indexOf + search.length)
        val currentRow = prevCol(indexOf)..(indexOf + search.length)
        val nextRow = nextRow(prevCol(indexOf))..nextRow(indexOf + search.length)

        val box = listOf(prevRow, currentRow, nextRow)
            .flatMap { it.filter { i -> i in data.indices }.map { i -> data[i] } }

        return !box.all {  it.isDigit() || it == '.' }
    }

    fun prevRow(index: Int): Int = index - cols
    fun nextRow(index: Int): Int = index + cols
    fun prevCol(index: Int): Int = index - 1
    fun nextCol(index: Int): Int = index + 1

    fun isTopRow(index: Int): Boolean = index < cols

    fun isBottomRow(index: Int): Boolean = index >= data.length - cols

    fun isFirstCol(index: Int): Boolean = index % cols == 0

    fun isLastCol(index: Int): Boolean = index % cols == cols - 1

}

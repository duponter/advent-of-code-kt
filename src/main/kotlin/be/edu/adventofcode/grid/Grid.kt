package be.edu.adventofcode.grid

import kotlin.math.abs

class Grid<T>(private val layout: List<List<T>>) {
    fun contains(point: Point): Boolean {
        val (row, col) = toCell(point)
        return contains(row, col)
    }

    fun contains(row: Int, col: Int): Boolean {
        return row >= 0 && col >= 0 && row < this.layout.size && col < this.layout[row].size
    }

    fun value(point: Point): T? {
        val (row, col) = toCell(point)
        return if (contains(row, col)) this.layout[row][col] else null
    }

    fun cells(): List<Triple<Int, Int, T>> {
        return layout.flatMapIndexed { rowIdx, row -> row.mapIndexed { colIdx, value -> Triple(rowIdx, colIdx, value )} }
    }

    fun replace(point: Point, newValue: T): Pair<Grid<T>, T?> {
        val (rowIndex, colIndex) = toCell(point)
        if (contains(rowIndex, colIndex)) {
            val row = this.layout[rowIndex].toMutableList()
            val oldValue = row[colIndex]
            row[colIndex] = newValue
            val newLayout = this.layout.toMutableList()
            newLayout[rowIndex] = row
            return Grid(newLayout.toList()) to oldValue
        }
        return this to null
    }

    fun print(formatter: (T) -> String = { it.toString() }) {
        this.layout.forEach { it.forEach { value -> print(formatter(value)) }; println() }
    }

    private fun toCell(point: Point): Pair<Int, Int> = point.coordinates().let { abs(it.first) to abs(it.second) }
}

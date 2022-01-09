package be.edu.adventofcode.grid

import kotlin.math.abs

class Grid<T>(private val layout: List<List<T>>) {
    fun dimensions(): Pair<Int, Int> = layout.size to layout[0].size

    fun contains(point: Point): Boolean = value(point) != null

    fun contains(row: Int, col: Int): Boolean {
        return row >= 0 && col >= 0 && row < this.layout.size && col < this.layout[row].size
    }

    fun value(point: Point): T? = point.value(this.layout)

    fun value(cell: Pair<Int, Int>): T? {
        val (row, col) = cell
        return if (contains(row, col)) this.layout[row][col] else null
    }

    fun raw(row: Int, col: Int): T = this.layout[row][col]

    fun cells(): List<T> {
        return this.cells { _, _, value -> value!! }
    }

    fun <R> cells(mapper: (Int, Int, T) -> R): List<R> {
        return this.map(mapper).layout.flatten()
    }

    fun <R> map(mapper: (Int, Int, T) -> R): Grid<R> {
        return Grid(layout.mapIndexed { rowIdx, row -> row.mapIndexed { colIdx, value -> mapper(rowIdx, colIdx, value) } })
    }

    fun replace(point: Point, newValue: T): Pair<Grid<T>, T?> {
        val (rowIndex, colIndex) = toCell(point)
        return this.replace(rowIndex, colIndex, newValue)
    }

    fun replace(rowIndex: Int, colIndex: Int, newValue: T): Pair<Grid<T>, T?> {
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

    fun print(formatter: (T?) -> String = { it.toString() }) {
        this.layout.forEach { it.forEach { value -> print(formatter(value)) }; println() }
    }

    private fun toCell(point: Point): Pair<Int, Int> = point.coordinates().let { abs(it.first) to abs(it.second) }
}

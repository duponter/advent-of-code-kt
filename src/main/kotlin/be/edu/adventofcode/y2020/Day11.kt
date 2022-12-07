package be.edu.adventofcode.y2020

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.BasicCell
import be.edu.adventofcode.grid.Cell
import be.edu.adventofcode.grid.EastBorderCell
import be.edu.adventofcode.grid.Grid
import be.edu.adventofcode.grid.NorthBorderCell
import be.edu.adventofcode.grid.SkippingCell
import be.edu.adventofcode.grid.SouthBorderCell
import be.edu.adventofcode.grid.WestBorderCell

class Day11 {
    fun part1(input: Lines): Int = rounds(
        SeatLayout(cellGridFactory(Grid(input.get().map { it.toCharArray().toList() })) { row, col, value -> BasicCell(row, col, value) })
    ) { { cell: Cell<Char> -> it.switchSeat(cell, 3) } }

    fun part2(input: Lines): Int = rounds(
        SeatLayout(cellGridFactory(Grid(input.get().map { it.toCharArray().toList() })) { row, col, value -> if (value == '.') SkippingCell(row, col, value) else BasicCell(row, col, value) })
    ) { { cell: Cell<Char> -> it.switchSeat(cell, 4) } }

    private fun cellGridFactory(grid: Grid<Char>, baseCellCreation: (Int, Int, Char) -> Cell<Char>): Grid<Cell<Char>> {
        val (rows, cols) = grid.dimensions()
        return grid.map { row, col, value ->
            var cell: Cell<Char> = baseCellCreation(row, col, value)
            if (row == 0)
                cell = NorthBorderCell(cell)
            if (row == rows - 1)
                cell = SouthBorderCell(cell)
            if (col == 0)
                cell = WestBorderCell(cell)
            if (col == cols - 1)
                cell = EastBorderCell(cell)
            cell
        }
    }

    private fun rounds(input: SeatLayout, switchSeat: (SeatLayout) -> (Cell<Char>) -> Char?): Int {
        var seatLayout = input
        var countOccupied = 0
        var tmp: Int
        var counter = 0
        do {
            counter++
            tmp = countOccupied
            seatLayout = seatLayout.round(switchSeat(seatLayout))
            countOccupied = seatLayout.countOccupied()
        } while (tmp != countOccupied)

        return countOccupied
    }

    class SeatLayout(private val grid: Grid<Cell<Char>>) {
        fun round(switchSeat: (Cell<Char>) -> Char?): SeatLayout {
            return SeatLayout(grid.cells().fold(grid, { acc, next -> gridUpdate(acc, next, switchSeat) }))
        }

        private fun gridUpdate(grid: Grid<Cell<Char>>, cell: Cell<Char>, switchSeat: (Cell<Char>) -> Char?): Grid<Cell<Char>> {
            val updatedValue = switchSeat(cell)
            return if (updatedValue == null) grid else cell.map { row, col, _ -> grid.replace(row, col, cell.replace(updatedValue)) }.first
        }

        fun switchSeat(cell: Cell<Char>, emptyThreshold: Int): Char? {
            val seat: Char = cell.value()!!
            if (!floor(seat)) {
                val count = cell.adjacents(this.grid).count { occupied(it.value() ?: '-') }
                if (empty(seat) && count == 0) {
                    return '#'
                } else if (occupied(seat) && count > emptyThreshold) {
                    return 'L'
                }
            }
            return null
        }

        fun countOccupied(): Int = grid.cells { _, _, value -> value }.count { occupied(it.value() ?: '-') }

        private fun empty(position: Char): Boolean = position == 'L'

        private fun occupied(position: Char): Boolean = position == '#'

        private fun floor(position: Char): Boolean = position == '.'
    }
}

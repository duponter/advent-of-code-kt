package be.edu.adventofcode.y2020.day11

import be.edu.adventofcode.Lines
import be.edu.adventofcode.grid.*

class Day11 {
    fun part1(input: Lines): Int = rounds(SeatLayout(cellGridFactory1(Grid(input.get().map { it.toCharArray().toList() })))) { it::switchSeat1 }

    private fun cellGridFactory1(grid: Grid<Char>): Grid<Cell<Char>> {
        val (rows, cols) = grid.dimensions()
        return grid.map { row, col, value ->
            var cell: Cell<Char> = BasicCell(row, col, value)
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

    fun part2(input: Lines): Int = rounds(SeatLayout(cellGridFactory2(Grid(input.get().map { it.toCharArray().toList() })))) { it::switchSeat2 }

    private fun cellGridFactory2(grid: Grid<Char>): Grid<Cell<Char>> {
        val (rows, cols) = grid.dimensions()
        return grid.map { row, col, value ->
            var cell: Cell<Char> = if (value == '.') SkippingCell(row, col, value) else BasicCell(row, col, value)
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
            println("Starting round $counter")
            seatLayout = seatLayout.round(switchSeat(seatLayout))
            countOccupied = seatLayout.countOccupied()
        } while (tmp != countOccupied)

        return countOccupied
    }

    class SeatLayout(private val grid: Grid<Cell<Char>>) {
        fun round(switchSeat: (Cell<Char>) -> Char?): SeatLayout {
//            grid.print { it?.value()?.toString() ?: "" }
//            grid.print { "$it\n" }
            return SeatLayout(grid.cells().fold(grid, { acc, next -> gridUpdate(acc, next, switchSeat) }))
        }

        private fun gridUpdate(grid: Grid<Cell<Char>>, cell: Cell<Char>, switchSeat: (Cell<Char>) -> Char?): Grid<Cell<Char>> {
            val updatedValue = switchSeat(cell)
            return if (updatedValue == null) grid else cell.map { row, col, _ -> grid.replace(row, col, cell.replace(updatedValue)) }.first
        }

        fun switchSeat1(cell: Cell<Char>): Char? {
            val seat: Char = cell.value()!!
            if (!floor(seat)) {
                val count = cell.adjacents(this.grid).count { occupied(it.value() ?: '-') }
                if (empty(seat) && count == 0) {
                    return '#'
                } else if (occupied(seat) && count > 3) {
                    return 'L'
                }
            }
            return null
        }

        fun switchSeat2(cell: Cell<Char>): Char? {
            val seat: Char = cell.value()!!
            if (!floor(seat)) {
//                cell.map { row, col, _ ->
//                    if (row == 0 && col == 2) {println("--- Adjacents $cell ---"); cell.adjacents(this.grid).forEach { println(it) } ; println("--- Adjacents End ---")}
//                }
//                println("--- Adjacents $cell ---"); cell.adjacents(this.grid).forEach { println(it) } ; println("--- Adjacents End ---")
                val count = cell.adjacents(this.grid).count { occupied(it.value() ?: '-') }
//                println("$cell has $count occupied")
//                println("$cell has ${cell.adjacents(this.grid).count { empty(it.value() ?: '-') }} empty")
                if (empty(seat) && count == 0) {
                    return '#'
                } else if (occupied(seat) && count > 4) {
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

fun main() {
//    println("part 1 = " + Day11().part1(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")))
//    println("8 occupied = " + Day11().part2(LinesFromArray(".......#.", "...#.....", ".#.......", ".........", "..#L....#", "....#....", ".........", "#........", "...#.....")))
//    println("0 occupied = " + Day11().part2(LinesFromArray(".##.##.", "#.#.#.#", "##...##", "...L...", "##...##", "#.#.#.#", ".##.##.")))
//    println("only 1 empty = " + Day11().part2(LinesFromArray(".............", ".L.L.#.#.#.#.", ".............")))
//    println("part 2 = " + Day11().part2(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL")))
//    println("part 2 = " + Day11().part2(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")))
}

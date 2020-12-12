package be.edu.adventofcode.y2020.day11

import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray
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

    fun part2(input: Lines): Int = rounds(SeatLayout(cellGridFactory1(Grid(input.get().map { it.toCharArray().toList() })))) { it::switchSeat1 }

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
//            println("Starting new round")
//            grid.print { it?.value()?.toString() ?: "" }
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

        fun switchSeat2(cell: Triple<Int, Int, Char>): Char? {
            val seat: Char = cell.third
            if (!floor(seat)) {
                val start = Point(cell.first to cell.second)

                val count = listOfNotNull(
                    firstInDirection(start) { it.up().left() },
                    firstInDirection(start, Point::up),
                    firstInDirection(start) { it.up().right() },
                    firstInDirection(start, Point::right),
                    firstInDirection(start) { it.down().right() },
                    firstInDirection(start, Point::down),
                    firstInDirection(start) { it.down().left() },
                    firstInDirection(start, Point::left)
                ).mapNotNull { grid.value(it.coordinates()) }.count { occupied(it.value() ?: '-') }
                if (empty(seat) && count == 0) {
                    return '#'
                } else if (occupied(seat) && count > 4) {
                    return 'L'
                }
            }
            return null
        }

        private fun firstInDirection(start: Point, direction: (Point) -> Point?): Point? {
            return generateSequence(start) { direction(it) }
                .firstOrNull { grid.value(it.coordinates())?.let { ch -> !floor(ch.value() ?: '-') } ?: true }
        }

        fun countOccupied(): Int = grid.cells { _, _, value -> value }.count { occupied(it.value() ?: '-') }

        private fun empty(position: Char): Boolean = position == 'L'

        private fun occupied(position: Char): Boolean = position == '#'

        private fun floor(position: Char): Boolean = position == '.'
    }
}

fun main() {
    println("part 1 = " + Day11().part1(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")))
    println("part 2 = " + Day11().part2(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")))
}

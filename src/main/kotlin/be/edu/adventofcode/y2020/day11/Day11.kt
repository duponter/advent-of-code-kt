package be.edu.adventofcode.y2020.day11

import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray
import be.edu.adventofcode.grid.Grid
import be.edu.adventofcode.grid.Point

class Day11 {
    fun part1(input: Lines): Int {
        var seatLayout = SeatLayout(Grid(input.get().map { it.toCharArray().toList() }))

        var countOccupied = 0
        var tmp: Int
        do {
            tmp = countOccupied
            seatLayout = seatLayout.round()
            countOccupied = seatLayout.countOccupied()
        } while (tmp != countOccupied)

        return countOccupied
    }

    fun part2(input: Lines): Int {
        var seatLayout = SeatLayout(Grid(input.get().map { it.toCharArray().toList() }))

        var countOccupied = 0
        var tmp: Int
        do {
            tmp = countOccupied
            seatLayout = seatLayout.round()
            countOccupied = seatLayout.countOccupied()
        } while (tmp != countOccupied)

        return countOccupied
    }

    class SeatLayout(private val grid: Grid<Char>) {
        fun round(): SeatLayout {
            return SeatLayout(grid.cells().fold(grid, { acc, next -> gridUpdate(acc, next, switchSeat2(next)) }))
        }

        private fun gridUpdate(grid: Grid<Char>, cell: Triple<Int, Int, Char>, updatedValue: Char?): Grid<Char> =
            if (updatedValue == null) grid else grid.replace(Point(cell.first, cell.second), updatedValue).first

        private fun switchSeat2(cell: Triple<Int, Int, Char>): Char? {
            val seat: Char = cell.third
            if (!floor(seat)) {
                val count = adjacentSeats(cell.first to cell.second).count { occupied(it) }
                if (empty(seat) && count == 0) {
                    return '#'
                } else if (occupied(seat) && count > 3) {
                    return 'L'
                }
            }
            return null
        }

        private fun adjacentSeats(center: Pair<Int, Int>): List<Char> = Point(center).adjacentPoints().filter { grid.contains(it.coordinates().first, it.coordinates().second) }.map { grid.value(it)!! }

        fun countOccupied(): Int = grid.cells().count { occupied(it.third) }

        fun print() {
            println("-- Grid print --")
            grid.print()
        }

        private fun empty(position: Char): Boolean = position == 'L'

        private fun occupied(position: Char): Boolean = position == '#'

        private fun floor(position: Char): Boolean = position == '.'
    }
}

fun main() {
    print(Day11().part1(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")))
}

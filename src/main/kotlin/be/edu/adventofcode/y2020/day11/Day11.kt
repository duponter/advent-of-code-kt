package be.edu.adventofcode.y2020.day11

import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray
import be.edu.adventofcode.grid.Grid
import be.edu.adventofcode.grid.Point

class Day11 {
    fun part1(input: Lines): Int = rounds(input) { it::switchSeat1 }

    fun part2(input: Lines): Int = rounds(input) { it::switchSeat2 }

    private fun rounds(input: Lines, switchSeat: (SeatLayout) -> (Triple<Int, Int, Char>) -> Char?): Int {
        var seatLayout = SeatLayout(Grid(input.get().map { it.toCharArray().toList() }))

        var countOccupied = 0
        var tmp: Int
        do {
            tmp = countOccupied
            seatLayout = seatLayout.round(switchSeat(seatLayout))
            countOccupied = seatLayout.countOccupied()
        } while (tmp != countOccupied)

        return countOccupied
    }

    class SeatLayout(private val grid: Grid<Char>) {
        fun round(switchSeat: (Triple<Int, Int, Char>) -> Char?): SeatLayout {
            return SeatLayout(grid.cells().fold(grid, { acc, next -> gridUpdate(acc, next, switchSeat) }))
        }

        private fun gridUpdate(grid: Grid<Char>, cell: Triple<Int, Int, Char>, switchSeat: (Triple<Int, Int, Char>) -> Char?): Grid<Char> {
            val updatedValue = switchSeat(cell)
            return if (updatedValue == null) grid else grid.replace(Point(cell.first, cell.second), updatedValue).first
        }

        fun switchSeat1(cell: Triple<Int, Int, Char>): Char? {
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
                ).mapNotNull { grid.value(it.coordinates()) }.count { occupied(it) }
                if (empty(seat) && count == 0) {
                    return '#'
                } else if (occupied(seat) && count > 4) {
                    return 'L'
                }
            }
            return null
        }

        private fun firstInDirection(start:Point, direction: (Point) -> Point?): Point? {
            return generateSequence(start) { direction(it) }
                .firstOrNull { grid.value(it.coordinates())?.let { ch -> !floor(ch) } ?: true }
        }

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
    print(Day11().part2(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")))
}

package be.edu.adventofcode.y2020.day11

import be.edu.adventofcode.Lines
import be.edu.adventofcode.LinesFromArray
import kotlin.math.max
import kotlin.math.min

class Day11 {
    fun part1(input: Lines): Int {
        var seatLayout = SeatLayout(input.get())

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
        var seatLayout = SeatLayout(input.get())

        var countOccupied = 0
        var tmp: Int
        do {
            tmp = countOccupied
            seatLayout = seatLayout.round2()
            countOccupied = seatLayout.countOccupied()
        } while (tmp != countOccupied)

        return countOccupied
    }

    class SeatLayout(private val grid: List<String>) {
        fun round(): SeatLayout {
            var changed = this
            for (row in grid.indices) {
                for (col in grid[row].indices) {
                    val center = row to col
                    val tmp = this.switchSeat(center)
                    changed = changed.set(center, tmp.seat(center))
                }
            }
            return changed
        }

        private fun switchSeat(center: Pair<Int, Int>): SeatLayout {
            val seat: Char = seat(center)
            if (!floor(seat)) {
                val count = adjacentSeats(center).count { occupied(it) }
                if (empty(seat) && count == 0) {
                    return set(center, '#')
                } else if (occupied(seat) && count > 3) {
                    return set(center, 'L')
                }
            }
            return this
        }

        fun round2(): SeatLayout {
            var changed = this
            for (row in grid.indices) {
                for (col in grid[row].indices) {
                    val center = row to col
                    val tmp = this.switchSeat(center)
                    changed = changed.set(center, tmp.seat(center))
                }
            }
            return changed
        }

        fun adjacentSeats(center: Pair<Int, Int>): CharSequence {
            return subGrid(center).grid.joinToString("").replaceFirst(seat(center).toString(), "")
        }

        private fun seat(center: Pair<Int, Int>): Char = this.grid[center.first][center.second]

        private fun set(center: Pair<Int, Int>, value: Char): SeatLayout {
            val mutable = this.grid.toMutableList()
            mutable[center.first] = this.grid[center.first].replaceRange(center.second, center.second + 1, value.toString())
            return SeatLayout(mutable.toList())
        }

        private fun subGrid(center: Pair<Int, Int>): SeatLayout {
            val (row, col) = center
            return SeatLayout(
                grid.drop(max(0, row - 1)).dropLast(max(grid.size - row - 2, 0))
                .map { it.substring(max(col - 1, 0), min(col + 2, it.length)) })
        }

        fun countOccupied(): Int = grid.joinToString("").count { occupied(it) }

        fun print() {
            println("-- Grid print --")
            grid.forEach { println(it) }
        }

        private fun empty(position: Char): Boolean = position == 'L'

        private fun occupied(position: Char): Boolean = position == '#'

        private fun floor(position: Char): Boolean = position == '.'
    }
}

fun main() {
    print(Day11().part1(LinesFromArray("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL")))
}

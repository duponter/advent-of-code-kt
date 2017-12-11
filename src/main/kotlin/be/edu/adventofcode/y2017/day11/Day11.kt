package be.edu.adventofcode.y2017.day11

import be.edu.adventofcode.Text
import kotlin.math.abs

class Day11 {
    fun part1(input: Text): Int {
        val start = Hex()
        return input.get().split(Regex(",\\s*"))
                .map { Direction.valueOf(it.toUpperCase()) }
                .fold(start, { acc, dir -> dir.apply(acc) })
                .distance(start)
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }
}

enum class Direction {
    NW {
        override fun apply(start: Hex): Hex = start.nw()
    },
    N {
        override fun apply(start: Hex): Hex = start.n()
    },
    NE {
        override fun apply(start: Hex): Hex = start.ne()
    },
    SE {
        override fun apply(start: Hex): Hex = start.se()
    },
    S {
        override fun apply(start: Hex): Hex = start.s()
    },
    SW {
        override fun apply(start: Hex): Hex = start.sw()
    };

    abstract fun apply(start: Hex): Hex;
}

// https://www.redblobgames.com/grids/hexagons/
data class Hex(private val row: Int = 0, private val column: Int = 0) {
    fun distance(other: Hex): Int {
        return (abs(this.column - other.column)
                + abs(this.column + this.row - other.column - other.row)
                + abs(this.row - other.row)) / 2
    }

    fun nw(): Hex = Hex(if (column % 2 == 0) row - 1 else row, column - 1)
    fun n(): Hex = Hex(row - 1, column)
    fun ne(): Hex = Hex(if (column % 2 == 0) row - 1 else row, column + 1)
    fun se(): Hex = Hex(if (column % 2 == 1) row + 1 else row, column + 1)
    fun s(): Hex = Hex(row + 1, column)
    fun sw(): Hex = Hex(if (column % 2 == 1) row + 1 else row, column - 1)
}
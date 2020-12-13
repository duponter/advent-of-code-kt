package be.edu.adventofcode.y2017.day11

import be.edu.adventofcode.Text
import kotlin.math.abs

class Day11 {
    fun part1(input: Text): Int {
        val start = Hex()
        return input.get().split(Regex(",\\s*"))
            .map { HexDirection.valueOf(it.toUpperCase()) }
                .fold(start, { acc, dir -> dir.apply(acc) })
                .distance(start)
    }

    fun part2(input: Text): Int {
        val start = Hex()
        return input.get().split(Regex(",\\s*"))
            .map { HexDirection.valueOf(it.toUpperCase()) }
                .fold(Pair(start, 0), { acc, dir -> Pair(dir.apply(acc.first), maxOf(acc.second, dir.apply(acc.first).distance(start))) })
                .second
    }
}

enum class HexDirection {
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

    abstract fun apply(start: Hex): Hex
}

// http://3dmdesign.com/development/hexmap-coordinates-the-easy-way
data class Hex(private val x: Int = 0, private val y: Int = 0) {
    fun distance(other: Hex): Int = maxOf(maxOf(abs(this.x - other.x), abs(this.y - other.y)), abs((this.x - other.x) - (this.y - other.y)))

    fun nw(): Hex = Hex(x - 1, y)
    fun n(): Hex = Hex(x, y + 1)
    fun ne(): Hex = Hex(x + 1, y + 1)
    fun se(): Hex = Hex(x + 1, y)
    fun s(): Hex = Hex(x, y - 1)
    fun sw(): Hex = Hex(x - 1, y - 1)
}
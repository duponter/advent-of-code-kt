package be.edu.adventofcode.y2017.day16

import be.edu.adventofcode.Text

class Day16 {
    fun part1(programs: String, input: Text): String {
        return input.get().split(",")
                .map { DanceMove.parse(it) }
                .fold(programs, { acc, danceMove -> danceMove.perform(acc) })
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }
}

interface DanceMove {
    fun perform(programs: String): String

    companion object {
        fun parse(input: String): DanceMove {
            return Spin.parse(input) ?: Exchange.parse(input) ?: Partner.parse(input)!!
        }
    }
}

data class Spin(val count: Int) : DanceMove {
    override fun perform(programs: String): String = programs.takeLast(count).plus(programs.dropLast(count))

    companion object {
        fun parse(input: String): Spin? {
            val matchResult = Regex("s(\\d+)").matchEntire(input)
            return if (matchResult != null) Spin(matchResult.destructured.component1().toInt()) else null
        }
    }
}

data class Exchange(val first: Int, val second: Int) : DanceMove {
    override fun perform(programs: String): String = Partner(programs[first], programs[second]).perform(programs)

    companion object {
        fun parse(input: String): Exchange? {
            val matchResult = Regex("x(\\d+)/(\\d+)").matchEntire(input)
            return if (matchResult != null) Exchange(matchResult.destructured.component1().toInt(), matchResult.destructured.component2().toInt()) else null
        }
    }

}

data class Partner(val first: Char, val second: Char) : DanceMove {
    override fun perform(programs: String): String = programs.replace(first, 'x').replace(second, first).replace('x', second)

    companion object {
        fun parse(input: String): Partner? {
            val matchResult = Regex("p(\\w)/(\\w)").matchEntire(input)
            return if (matchResult != null) Partner(matchResult.destructured.component1().single(), matchResult.destructured.component2().single()) else null
        }
    }
}
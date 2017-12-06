package be.edu.adventofcode.y2017.day06

import be.edu.adventofcode.Text
import java.util.*

class Day06 {
    fun part1(input: Text): Int = redistribute(input).first

    fun part2(input: Text): Int = redistribute(input).second

    private fun redistribute(input: Text): Pair<Int, Int> {
        val blocks = input.get().split(Regex("\\s+")).map(String::toInt).mapIndexed { index, value -> Pair(index, value) }.toMutableList()

        var configurations = listOf<String>()
        var configuration = blocks.map(Pair<Int, Int>::second).joinToString(",")
        var count = 0

        do {
            configurations = configurations.plus(configuration)

            val max = blocks.maxWith(IntPairComparator())!!
            blocks[max.first] = Pair(max.first, 0)

            (max.first + 1..max.first + max.second).forEach {
                val index = if (it < blocks.size) it else it % blocks.size
                blocks[index] = Pair(blocks[index].first, blocks[index].second + 1)
            }

            count++

            configuration = blocks.map(Pair<Int, Int>::second).joinToString(",")
        } while (!configurations.contains(configuration))

        configurations = configurations.plus(configuration)
        return Pair(count, configurations.size - (configurations.indexOf(configuration) + 1))
    }
}

class IntPairComparator : Comparator<Pair<Int, Int>> {
    override fun compare(o1: Pair<Int, Int>?, o2: Pair<Int, Int>?): Int =
            if (o1!!.second - o2!!.second == 0) -(o1.first - o2.first) else (o1.second - o2.second)

}
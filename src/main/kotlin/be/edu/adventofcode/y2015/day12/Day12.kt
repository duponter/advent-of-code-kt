package be.edu.adventofcode.y2015.day12

import be.edu.adventofcode.Text

class Day12 {
    fun part1(input: Text): Int = calculate(input.get())

    fun part2(input: Text): Int {
        val betweenBrackets = Regex("\\[[^\\[\\]{}]*]")
        val betweenBraces = Regex("\\{[^\\[\\]{}]*}")

        var text = input.get()
        while (text.contains(betweenBrackets) || text.contains(betweenBraces)) {
            while (text.contains(betweenBrackets)) {
                text = text.replace(betweenBrackets, { calculate(it.value).toString() })
            }
            while (text.contains(betweenBraces)) {
                text = text.replace(betweenBraces, { if (it.value.contains(":\"red\"")) "0" else calculate(it.value).toString() })
            }
        }

        return calculate(text)
    }

    private fun calculate(input: String): Int = Regex("(-?\\d+)").findAll(input).map { it.value.toInt() }.sum()
}

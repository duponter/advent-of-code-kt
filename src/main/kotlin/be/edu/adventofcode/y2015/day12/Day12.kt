package be.edu.adventofcode.y2015.day12

import be.edu.adventofcode.Text
import be.edu.adventofcode.TextFromString

class Day12 {
    fun part1(input: Text): Int = Regex("(-?\\d+)").findAll(input.get())
            .map { it.value.toInt() }
            .sum()

    fun part2(input: Text): Int = part1(TextFromString(Regex("\\{[^{]*?:\"red\".*?}").replace(input.get(), "")))
//    fun part2(input: Text): Int = part1(TextFromString(removeDoubleCounts(input.get())))

    private fun removeDoubleCounts(input: String): String {
        // 87529 < answer < 148671
        println("input=${input.length}")
        return if (input.contains(":\"red\"")) {
            val manipulated = removeJsonMiddleman(ignoreRed(input))
            println("manipulated = ${manipulated.length}")
            if (manipulated == input) manipulated else removeDoubleCounts(manipulated)
        } else {
            input
        }
    }

    private fun ignoreRed(input: String): String = Regex("\\{[^{}]*?:\"red\"[^{}]*?},?").replace(input, "")

    private fun removeJsonMiddleman(json: String): String = Regex("(\"\\w+\":)?\\{([^{}]*?)}").replace(json, { it.destructured.component2() })
}

package be.edu.adventofcode.y2020.day07

import be.edu.adventofcode.Lines
import be.edu.adventofcode.StringDestructure
import java.lang.IllegalArgumentException

class Day07 {
    fun part1(input: Lines): Int {
        val regulations = input.asSequence()
            .map { parse(it) }
            .associateBy { it.type }
        return regulations.values.count { it.contains("shiny gold", regulations) }
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }

    private fun parse(line: String): Bag {
        val (bag, content) = StringDestructure("([\\w ]+) contain ([\\w ,]+).").pair(line)
        val typeParser = StringDestructure("(\\d*) ?([a-z]+ [a-z]+) bags?")
        return Bag(
            typeParser.pair(bag).second,
            if (content == "no other bags") mapOf() else content.split(", ")
                .map { typeParser.pair(it) }
                .associate { it.second to it.first.toInt() }
        )
    }

    data class Bag(val type: String, val content: Map<String, Int>) {
        fun contains(type: String, regulations: Map<String, Bag>): Boolean {
            if (content.containsKey(type)) {
                return true
            }
            return content.keys
                .map { regulations[it] ?: throw IllegalArgumentException("Bag $it not found in regulations") }
                .any { it.contains(type, regulations) }
        }
    }
}

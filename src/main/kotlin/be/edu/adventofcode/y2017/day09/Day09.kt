package be.edu.adventofcode.y2017.day09

import be.edu.adventofcode.Text

class Day09 {
    fun part1(input: Text): Int {
        return Regex("!.").replace(input.get(), "").asIterable()
                .fold(Group(), { acc: Context, c: Char -> acc.apply(c) })
                .groups()
    }

    fun part2(input: Text): Int {
        return Regex("!.").replace(input.get(), "").asIterable()
                .fold(Group(), { acc: Context, c: Char -> acc.apply2(c) })
                .garbage()
    }
}

interface Context {
    fun apply(next: Char): Context

    fun apply2(next: Char): Context

    fun groups(): Int

    fun garbage(): Int
}

data class Group(private val totalValue: Int = 0, private val depth: Int = 0) : Context {
    override fun apply(next: Char): Context {
        return when (next) {
            '{' -> Group(totalValue, depth + 1)
            '}' -> Group(totalValue + depth, depth - 1)
            '<' -> Garbage(this)
            else -> this
        }
    }

    override fun apply2(next: Char): Context {
        return when (next) {
            '<' -> Garbage(this, totalValue)
            else -> this
        }
    }

    override fun groups(): Int = totalValue

    override fun garbage(): Int = totalValue
}

data class Garbage(private val group: Group, private val count: Int = 0) : Context {
    override fun apply(next: Char): Context {
        return when (next) {
            '>' -> group
            else -> this
        }
    }

    override fun apply2(next: Char): Context {
        return when (next) {
            '>' -> Group(count)
            else -> Garbage(group, count + 1)
        }
    }

    override fun groups(): Int = group.groups()

    override fun garbage(): Int = count
}
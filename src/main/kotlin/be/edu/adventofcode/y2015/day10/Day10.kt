package be.edu.adventofcode.y2015.day10

import be.edu.adventofcode.Text

class Day10 {
    fun part1(input: Text): Int = recurse(40, this::lookAndSay)(input.get()).length

    fun part2(input: Text): Int = recurse(50, this::lookAndSay)(input.get()).length

    private fun <T> recurse(times: Int, function: (T) -> T): (T) -> T = if (times < 2) function else { x -> recurse(times - 1, function)(function(x)) }

    fun lookAndSay(input: String): String = input.split(Regex("(?<=(.))(?!\\1)")).dropLastWhile { it.isEmpty() }
            .joinToString("") { it.length.toString().plus(it.first()) }
}
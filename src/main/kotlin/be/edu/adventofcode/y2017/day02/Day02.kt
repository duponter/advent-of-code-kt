package be.edu.adventofcode.y2017.day02

import be.edu.adventofcode.Lines

class Day02 {
    fun part1(input: Lines): Int {
        return input.get()
                .map(this::stringToDifference)
                .sum()
    }

    private fun stringToDifference(input: String): Int {
        val values = input.split(Regex("\\s+")).map(String::toInt)
        return values.maxOrNull()!! - values.minOrNull()!!
    }

    fun part2(input: Lines): Int {
        return input.get()
                .map(this::stringToDivision)
                .sum()
    }

    private fun stringToDivision(input: String): Int {
        val values = input.split(Regex("\\s+")).map(String::toInt).sortedDescending()
        return evenlyDivide(values.first(), values.drop(1))
    }

    private fun evenlyDivide(dividend: Int, divisors: List<Int>): Int {
        val divisor = divisors.firstOrNull { dividend % it == 0 }
        return if (divisor != null) {
            dividend / divisor
        } else {
            evenlyDivide(divisors.first(), divisors.drop(1))
        }
    }
}

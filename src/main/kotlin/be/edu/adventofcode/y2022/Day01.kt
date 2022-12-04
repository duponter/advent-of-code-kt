package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines

class Day01 {
    fun part1(input: Lines): Int {
        return input.get()
            .fold(mutableListOf(mutableListOf(0))) { elves, calories -> carryCalories(elves, calories) }
            .maxOf { it.sum() }
    }

    private fun carryCalories(elves: MutableList<MutableList<Int>>, calories: String): MutableList<MutableList<Int>> {
        if (calories.isEmpty()) {
            elves.add(mutableListOf(0));
        } else {
            elves.last().add(calories.toInt())
        }
        return elves
    }

    fun part2(input: Lines): Int {
        return input.get()
            .fold(mutableListOf(mutableListOf(0))) { elves, calories -> carryCalories(elves, calories) }
            .map { it.sum() }
            .sorted()
            .takeLast(3)
            .sum()
    }
}

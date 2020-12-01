package be.edu.adventofcode.y2019.day07

import be.edu.adventofcode.Text
import be.edu.adventofcode.y2019.intcode.AmplifierControllerSoftware

class Day07 {
    fun part1(input: Text): Long {
        return permutations((0..4).toList())
                .map { part1(input, it) }
                .maxOrNull()!!
    }

    private fun <T> permutations(input: List<T>): List<List<T>> {
        if (input.size == 1) return listOf(input)
        val perms = mutableListOf<List<T>>()
        val toInsert = input[0]
        for (perm in permutations(input.drop(1))) {
            for (i in 0..perm.size) {
                val newPerm = perm.toMutableList()
                newPerm.add(i, toInsert)
                perms.add(newPerm)
            }
        }
        return perms
    }

    fun part1(input: Text, phaseSetting: List<Int>): Long {
        return AmplifierControllerSoftware(input.get(), phaseSetting).execute(0)
    }

    fun part2(input: Text): Long {
        return permutations((5..9).toList())
                .map { part2(input, it) }
                .maxOrNull()!!
    }

    fun part2(input: Text, phaseSetting: List<Int>): Long {
        var output = 0L
        val amplifierControllerSoftware = AmplifierControllerSoftware(input.get(), phaseSetting)
        for(i in 1..5) {
            output = amplifierControllerSoftware.execute(output)
        }
        return output
    }
}

class Switcher<T>(val first: (T) -> T, val second: (T) -> T) {
    private var chooser = Chooser.FIRST

    fun apply(input: T): T {
        chooser = chooser.inverse()
        return chooser.inverse().delegate(first, second)(input)
    }
}

enum class Chooser {
    FIRST {
        override fun <T> delegate(first: T, second: T): T = first

        override fun inverse(): Chooser = SECOND
    },
    SECOND {
        override fun <T> delegate(first: T, second: T): T = second

        override fun inverse(): Chooser = FIRST
    };

    abstract fun <T> delegate(first: T, second: T): T

    abstract fun inverse(): Chooser
}

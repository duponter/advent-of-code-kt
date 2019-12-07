package be.edu.adventofcode.y2019.day07

import be.edu.adventofcode.Text
import be.edu.adventofcode.y2019.day05.IO
import be.edu.adventofcode.y2019.day05.Operation

class Day07 {
    fun part1(input: Text): Int {
        return permutations((0..4).toList())
                .map { part1(input, it) }
                .max()!!
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

    fun part1(input: Text, phaseSetting: List<Int>): Int {
        return phaseSetting.fold(0) { output, phase -> program(input, IO(phase, output)) }
    }

    fun program(input: Text, io: IO<Int, Int>): Int {
        val mutableList = input.get().split(',')
                .map { it.toInt() }
                .toMutableList()

        var operation = Operation(0, io)
        while (operation.index != -1) {
            operation = operation.apply(mutableList)
        }
        return operation.io.output
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }
}

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
        return execute(AmplifierControllerSoftware(input), phaseSetting).io.output
    }

    fun part2(input: Text): Int {
        return permutations((5..9).toList())
                .map { part2(input, it) }
                .max()!!
    }

    fun part2(input: Text, phaseSetting: List<Int>): Int {
        var result: Operation
        do {
            result = execute(AmplifierControllerSoftware(input), phaseSetting)
        } while (result.index != -1)
        return result.io.output
    }

    private fun execute(acs: AmplifierControllerSoftware, phaseSetting: List<Int>): Operation {
        return phaseSetting.fold(Operation(0, IO(0, 0))) { op, phase -> acs.execute(Operation(0, op.io.newInput(phase))) }
    }

    //generateSequence { it }.flatten()
}

class AmplifierControllerSoftware(private val instructions: MutableList<Int>) {
    constructor(input: Text) : this(input.get().split(',')
            .map { it.toInt() }
            .toMutableList())

    fun execute(start: Operation): Operation {
        var operation = start
        while (operation.index != -1) {
            operation = operation.apply(instructions)
        }
        return operation
    }
}

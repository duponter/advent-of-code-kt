package be.edu.adventofcode.y2020.day08

import be.edu.adventofcode.Lines

class Day08 {
    fun part1(input: Lines): Int {
        val instructions: List<Instruction> = input.get().map { Instruction.parse(it) }
        val visits: MutableSet<Int> = mutableSetOf(0)
        var index = 0
        var acc = 0
        do {
            val instruction = instructions[index]
            acc = instruction.accumulate(acc)
            index = instruction.next(index)
        } while (visits.add(index))
        return acc
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

sealed class Instruction(val arg: Int) {
    companion object {
        fun parse(input: String): Instruction {
            val tokens = input.split(" ")
            return when {
                tokens[0] == "acc" -> Accumulate(tokens[1].toInt())
                tokens[0] == "jmp" -> Jump(tokens[1].toInt())
                tokens[0] == "nop" -> NoOperation(tokens[1].toInt())
                else -> throw UnsupportedOperationException(input)
            }
        }
    }

    abstract fun next(index: Int): Int

    abstract fun accumulate(acc: Int): Int
}

class Accumulate(arg: Int) : Instruction(arg) {
    override fun next(index: Int): Int = index + 1

    override fun accumulate(acc: Int): Int = acc + arg
}

class Jump(arg: Int) : Instruction(arg) {
    override fun next(index: Int): Int = index + arg

    override fun accumulate(acc: Int): Int = acc
}

class NoOperation(arg: Int) : Instruction(arg) {
    override fun next(index: Int): Int = index + 1

    override fun accumulate(acc: Int): Int = acc
}
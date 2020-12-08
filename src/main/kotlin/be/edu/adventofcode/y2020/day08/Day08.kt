package be.edu.adventofcode.y2020.day08

import be.edu.adventofcode.Lines

class Day08 {
    fun part1(input: Lines): Int {
        val instructions: List<Instruction> = input.get().map { Instruction.parse(it) }
        return visit(instructions).second
    }

    fun part2(input: Lines): Int {
        val instructions: List<Instruction> = input.get().map { Instruction.parse(it) }
        return bruteForceVisitsWithSingleRepair(instructions)
    }

    private fun bruteForceVisitsWithSingleRepair(instructions: List<Instruction>): Int {
        for (i in instructions.indices) {
            if (instructions[i] !is Accumulate) {
                val repaired = instructions.toMutableList()
                repaired[i] = repaired[i].repair()
                val (index, acc) = visit(repaired)
                if (index >= instructions.size) {
                    return acc
                }
            }
        }
        throw IllegalStateException("No acc determined")
    }

    private fun visit(instructions: List<Instruction>): Pair<Int, Int> {
        val visits: MutableSet<Int> = mutableSetOf(0)
        var index = 0
        var acc = 0
        do {
            val instruction = instructions[index]
            acc = instruction.accumulate(acc)
            index = instruction.next(index)
        } while (visits.add(index) && index < instructions.size)
        return index to acc
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

    override fun toString(): String = "${this::class.simpleName}($arg)"

    abstract fun next(index: Int): Int

    abstract fun accumulate(acc: Int): Int

    abstract fun repair(): Instruction
}

class Accumulate(arg: Int) : Instruction(arg) {
    override fun next(index: Int): Int = index + 1

    override fun accumulate(acc: Int): Int = acc + arg

    override fun repair(): Instruction = this
}

class Jump(arg: Int) : Instruction(arg) {
    override fun next(index: Int): Int = index + arg

    override fun accumulate(acc: Int): Int = acc

    override fun repair(): Instruction = NoOperation(arg)
}

class NoOperation(arg: Int) : Instruction(arg) {
    override fun next(index: Int): Int = index + 1

    override fun accumulate(acc: Int): Int = acc

    override fun repair(): Instruction = Jump(arg)
}
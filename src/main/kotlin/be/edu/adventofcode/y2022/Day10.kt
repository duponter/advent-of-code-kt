package be.edu.adventofcode.y2022

import be.edu.adventofcode.Lines

class Day10 {
    fun part1(input: Lines): Int {
        val instructions = input.get().map { Instruction.parse(it) }
        return listOf(20, 60, 100, 140, 180, 220)
            .sumOf { signalStrength(instructions, it) }
    }

    private fun signalStrength(instructions: List<Instruction>, atCycle: Int): Int {
        val cycles = mutableListOf<Int>()
        val value = instructions.fold(1) { x, instruction ->
            cycles.add(instruction.cycles())
            if (cycles.sum() < atCycle) x + instruction.registerIncrease() else x
        }
//        println("During the ${atCycle}th cycle, register X has the value ${value}, so the signal strength is ${atCycle * value}.")
        return value * atCycle
    }

    fun part2(input: Lines): Int {
        return input.get()
            .count()
    }

    interface Instruction {
        companion object {
            fun parse(input: String): Instruction {
                if (input == "noop") return NoOp()
                if (input.startsWith("addx")) return AddX(input.removePrefix("addx ").toInt())
                throw IllegalArgumentException(input)
            }
        }

        fun cycles(): Int

        fun registerIncrease(): Int
    }

    data class NoOp(val increase: Int = 0) : Instruction {
        override fun cycles(): Int = 1

        override fun registerIncrease(): Int = increase
    }

    data class AddX(val increase: Int) : Instruction {
        override fun cycles(): Int = 2

        override fun registerIncrease(): Int = increase
    }
}

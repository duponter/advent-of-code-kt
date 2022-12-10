package be.edu.adventofcode.y2022

import be.edu.adventofcode.DigitDisplay
import be.edu.adventofcode.Lines
import kotlin.math.abs

class Day10 {
    fun part1(input: Lines): Int {
        val instructions = input.get().map { Instruction.parse(it) }
        return listOf(20, 60, 100, 140, 180, 220)
            .sumOf { signalStrength(instructions, it) }
    }

    private fun signalStrength(instructions: List<Instruction>, atCycle: Int): Int = registerX(instructions, atCycle) * atCycle

    private fun registerX(instructions: List<Instruction>, atCycle: Int): Int {
        var cycles = 0
        val value = instructions.fold(1) { x, instruction ->
            cycles += instruction.cycles
            if (cycles < atCycle) x + instruction.registerIncrease else x
        }
        return value
    }

    @DigitDisplay
    fun part2(input: Lines): List<String> {
        val instructions = input.get().map { Instruction.parse(it) }
        return (1..240)
            .map { drawPixel(registerX(instructions, it), it) }
            .chunked(40) { it.joinToString("") }
    }

    private fun drawPixel(x: Int, cycle: Int) = if (abs((cycle - 1) % 40 - x) < 2) "#" else "."

    data class Instruction(val cycles: Int, val registerIncrease: Int = 0) {
        companion object {
            fun parse(input: String): Instruction {
                if (input == "noop") return Instruction(1)
                if (input.startsWith("addx")) return Instruction(2, input.removePrefix("addx ").toInt())
                throw IllegalArgumentException(input)
            }
        }
    }
}

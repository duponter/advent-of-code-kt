package be.edu.adventofcode.y2017.day07

import be.edu.adventofcode.Lines

class Day07 {
    fun part1(input: Lines): String {
        val programs = input.get().map(this::parseProgram)
        val programNames = programs.map(Program::name)
        val programWithParent = programs.flatMap(Program::disc).toSet()
        return programNames.minus(programWithParent).single()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }

    private fun parseProgram(input: String): Program {
        return Regex("([a-z]+) \\((\\d+)\\)(?: -> )?((?:[a-z]+(?:, )?)*)?").matchEntire(input)!!
                .destructured.let { Program(it.component1(), it.component2().toInt(), it.component3().split(", ")) }
    }
}

data class Program(val name: String, val weight: Int, val disc: List<String>)

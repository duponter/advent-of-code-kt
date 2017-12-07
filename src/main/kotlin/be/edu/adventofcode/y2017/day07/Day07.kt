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
        val programs = input.get().map(this::parseProgram).groupBy(Program::name, { it }).mapValues { it.value.single() }

        val tmp = programs.map { it.value.unbalancedNode(programs) }
        println(tmp)
        return programs.map { Pair(it.value, it.value.unbalancedNode(programs)) }.single { it.second != null }.first.weight
    }

    private fun parseProgram(input: String): Program {
        return Regex("([a-z]+) \\((\\d+)\\)(?: -> )?((?:[a-z]+(?:, )?)*)?").matchEntire(input)!!
                .destructured.let { Program(it.component1(), it.component2().toInt(), if (it.component3().isNotEmpty()) it.component3().split(", ") else listOf()) }
    }
}

data class Program(val name: String, val weight: Int, val disc: List<String>) {
    fun unbalancedNode(programs: Map<String, Program>): Pair<Program, Int>? {
        if (disc.isEmpty()) return null

        val withDiscWeights = programs.filterKeys { disc.contains(it) }.map { Pair(it.value, it.value.discWeight(programs)) }.groupBy { it.second }
        println("$this has following disc weights $withDiscWeights with keys ${withDiscWeights.keys}")
        return withDiscWeights.filterValues { it.size == 1 }.mapValues { it.value.singleOrNull() }.values.firstOrNull()
    }

    fun discWeight(programs: Map<String, Program>): Int {
        return weight + disc.map { programs.getValue(it).weight }.sum()
    }
}

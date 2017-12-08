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

        val unbalanced = programs.map { it.value.toDisc(programs).unbalancedNode() }.filterNotNull()

        return unbalanced.single { it.first.program.disc.none { unbalanced.map { it.first.program.name }.contains(it) } }.second
    }

    private fun parseProgram(input: String): Program {
        return Regex("([a-z]+) \\((\\d+)\\)(?: -> )?((?:[a-z]+(?:, )?)*)?").matchEntire(input)!!
                .destructured.let { Program(it.component1(), it.component2().toInt(), if (it.component3().isNotEmpty()) it.component3().split(", ") else listOf()) }
    }
}

data class Program(val name: String, val weight: Int, val disc: List<String>) {
    fun toDisc(programs: Map<String, Program>): Disc {
        val discPrograms = disc.map { programs[it]!!.toDisc(programs) }
        return Disc(this, weight + discPrograms.map(Disc::weight).sum(), discPrograms)
    }
}

data class Disc(val program: Program, val weight: Int, private val disc: List<Disc>) {
    fun unbalancedNode(): Pair<Disc, Int>? {
        if (disc.isEmpty()) return null

        val countWeights = disc.groupBy(Disc::weight)
        return when {
            countWeights.size == 1 -> null
            countWeights.size == 2 -> {
                val unbalanced = countWeights.filterValues { it.size == 1 }.mapValues { it.value.single() }.values.first()
                val balancedWeight = countWeights.filterValues { it.size != 1 }.keys.single()
                Pair(unbalanced, unbalanced.program.weight + balancedWeight - unbalanced.weight)
            }
            else -> throw IllegalStateException("Expected 1 or 2 entries: $countWeights")
        }
    }

}

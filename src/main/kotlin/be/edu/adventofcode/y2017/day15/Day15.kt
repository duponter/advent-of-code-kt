package be.edu.adventofcode.y2017.day15

class Day15 {
    fun part1(input: Pair<Int, Int>, loops: Int): Int {
        var generatedA = input.first
        var generatedB = input.second
        var count = 0
        (1..loops).forEach {
            generatedA = this.calculate(generatedA.toLong(), 16807)
            generatedB = this.calculate(generatedB.toLong(), 48271)
            val binaryA = generatedA.let { Integer.toBinaryString(it) }.padStart(16, '0')
            val binaryB = generatedB.let { Integer.toBinaryString(it) }.padStart(16, '0')
            if (binaryA.takeLast(16) == binaryB.takeLast(16)) count++
        }

        return count
    }

    private fun calculate(start: Long, factor: Long): Int = ((start * factor) % 2147483647).toInt()

    fun part2(input: Pair<Int, Int>, loops: Int): Int {
        var generatedA = input.first
        var generatedB = input.second
        var count = 0
        (1..loops).forEach {
            generatedA = this.calculate(generatedA.toLong(), 16807, 4)
            generatedB = this.calculate(generatedB.toLong(), 48271, 8)
            val binaryA = generatedA.let { Integer.toBinaryString(it) }.padStart(16, '0')
            val binaryB = generatedB.let { Integer.toBinaryString(it) }.padStart(16, '0')
            if (binaryA.takeLast(16) == binaryB.takeLast(16)) count++
        }

        return count
    }

    private tailrec fun calculate(start: Long, factor: Long, multipleOf: Int): Int {
        val calculated = this.calculate(start, factor)
        return if (calculated % multipleOf == 0) calculated else calculate(calculated.toLong(), factor, multipleOf)
    }
}
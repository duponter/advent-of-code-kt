package be.edu.adventofcode.y2017.day15

class Day15 {
    fun part1(input: Pair<Int, Int>, loops: Int): Int {
        var generatedA = input.first
        var generatedB = input.second
        var count = 0
        (1..loops).forEach {
            generatedA = this.calculate(generatedA.toLong(), 16807)
            generatedB = this.calculate(generatedB.toLong(), 48271)
//            println("Generated $generatedA and $generatedB")
            val binaryA = generatedA.let { Integer.toBinaryString(it) }.padStart(16, '0')
//            println(binaryA)
            val binaryB = generatedB.let { Integer.toBinaryString(it) }.padStart(16, '0')
//            println(binaryB)
            if (binaryA.takeLast(16) == binaryB.takeLast(16)) count++
        }

        return count
    }

    fun calculate(start: Long, factor: Long): Int = ((start * factor) % 2147483647).toInt()

    fun part2(input: Pair<Int, Int>): Int {
        return 0
    }
}
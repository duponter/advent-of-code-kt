package be.edu.adventofcode.y2015.day06

import be.edu.adventofcode.Lines

class Day06 {
    fun part1(input: Lines): Int {
        val grid = Grid()
        input.get().mapNotNull { toInstruction(it) }.forEach({ it.forEach { row, col, operation -> grid.apply(row, col, operation::light) } })
        return grid.countLit()
    }

    fun part2(input: Lines): Int {
        val grid = Grid()
        input.get().mapNotNull { toInstruction(it) }.forEach({ it.forEach { row, col, operation -> grid.apply(row, col, operation::increase) } })
        return grid.totalBrightness()
    }

    private fun toInstruction(input: String): Instruction? = Instruction.REGEX.matchEntire(input)?.destructured?.let { destructured ->
        val upperLeft = Coordinates(destructured.component2().toInt(), destructured.component3().toInt())
        val lowerRight = Coordinates(destructured.component4().toInt(), destructured.component5().toInt())
        return when (destructured.component1()) {
            "turn on" -> Instruction(TurnOn(), upperLeft, lowerRight)
            "toggle" -> Instruction(Toggle(), upperLeft, lowerRight)
            "turn off" -> Instruction(TurnOff(), upperLeft, lowerRight)
            else -> null
        }
    }
}

class Grid(rows: Int, private val cols: Int) {
    private val grid = Array(rows, { Array<Int>(cols, { 0 }) })

    constructor() : this(1000, 1000)

    fun apply(row: Int, col: Int, operation: (Int) -> Int) {
        grid[row][col] = operation(grid[row][col])
    }

    fun countLit(): Int = grid.flatMap { it -> it.toList() }.filter { it > 0 }.count()

    fun totalBrightness(): Int = grid.flatMap { it -> it.toList() }.sum()
}

data class Coordinates(val row: Int, val col: Int)

data class Instruction(private val operation: Operation, private val upperLeft: Coordinates, private val lowerRight: Coordinates) {
    companion object {
        val REGEX = Regex("([\\w ]+) (\\d+),(\\d+) through (\\d+),(\\d+)")
    }

    fun forEach(function: (Int, Int, Operation) -> Unit) {
        (upperLeft.row..lowerRight.row).forEach { row -> (upperLeft.col..lowerRight.col).forEach { col -> function(row, col, operation) } }
    }
}

sealed class Operation {
    abstract fun light(current: Int): Int

    abstract fun increase(current: Int): Int
}

class TurnOn : Operation() {
    override fun light(current: Int): Int = 1

    override fun increase(current: Int): Int = current + 1
}

class TurnOff : Operation() {
    override fun light(current: Int): Int = 0

    override fun increase(current: Int): Int = maxOf(current - 1, 0)
}

class Toggle : Operation() {
    override fun light(current: Int): Int = if (current == 0) 1 else 0

    override fun increase(current: Int): Int = current + 2
}
package be.edu.adventofcode.y2015.day06

import be.edu.adventofcode.Lines

class Day06 {
    fun part1(input: Lines): Int {
        val grid = Grid()
        input.get().mapNotNull { toInstruction(it) }.forEach({ it.applyTo(grid) })
        return grid.countLit()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
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
    private val grid = Array(rows, { Array<Boolean>(cols, { false }) })

    constructor() : this(1000, 1000)

    fun apply(row: Int, col: Int, operation: Operation) {
        grid[row][col] = operation.apply(grid[row][col])
    }

    fun countLit(): Int = grid.flatMap { it -> it.toList() }.filter { it }.count()
}

data class Coordinates(val row: Int, val col: Int)

data class Instruction(private val operation: Operation, private val upperLeft: Coordinates, private val lowerRight: Coordinates) {
    companion object {
        val REGEX = Regex("([\\w ]+) (\\d+),(\\d+) through (\\d+),(\\d+)")
    }

    fun applyTo(grid: Grid) {
        (upperLeft.row..lowerRight.row).forEach { row -> (upperLeft.col..lowerRight.col).forEach { col -> grid.apply(row, col, operation) } }
    }
}

sealed class Operation {
    abstract fun apply(current: Boolean): Boolean
}

class TurnOn : Operation() {
    override fun apply(current: Boolean): Boolean = true
}

class TurnOff : Operation() {
    override fun apply(current: Boolean): Boolean = false
}

class Toggle : Operation() {
    override fun apply(current: Boolean): Boolean = !current
}
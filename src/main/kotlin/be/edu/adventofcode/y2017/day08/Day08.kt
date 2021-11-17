package be.edu.adventofcode.y2017.day08

import be.edu.adventofcode.Lines
import kotlin.math.max

class Day08 {
    fun part1(input: Lines): Int {
        val regex = Regex("([a-z]+) (inc|dec) (-?\\d+) if ([a-z]+) ([!=<>]=?) (-?\\d+)")

        val tokens = input.get().map { regex.matchEntire(it) }.map { it!!.groupValues }
        val registers = tokens.flatMap { listOf(it[1], it[4]) }.toSet().groupBy({ it }, { Register(it) }).mapValues { it.value.single() }
        tokens.map { toInstruction(it, registers) }.map(Instruction::execute)
        return registers.maxByOrNull { it.value.value }!!.value.value
    }

    private fun toInstruction(tokens: List<String>, registers: Map<String, Register>): Instruction {
        val operation = Operation(registers[tokens[1]]!!, tokens[3].toInt(), Operator.valueOf(tokens[2].uppercase()))
        val condition = Condition(registers[tokens[4]]!!, tokens[6].toInt(), ConditionalOperator(tokens[5]))
        return Instruction(operation, condition)
    }

    fun part2(input: Lines): Int {
        val regex = Regex("([a-z]+) (inc|dec) (-?\\d+) if ([a-z]+) ([!=<>]=?) (-?\\d+)")

        val tokens = input.get().map { regex.matchEntire(it) }.map { it!!.groupValues }
        val registers = tokens.flatMap { listOf(it[1], it[4]) }.toSet().groupBy({ it }, { Register(it) }).mapValues { it.value.single() }
        val instructions = tokens.map { toInstruction(it, registers) }
        return instructions.fold(0, { acc, instruction -> max(acc, instruction.execute().value) })
    }
}

data class Register(val name: String, var value: Int = 0)

data class Instruction(private val operation: Operation, private val condition: Condition) {
    fun execute(): Register {
        println("Executing $this")
        if (condition.execute()) operation.execute()
        println("Changed register ${operation.register}")
        return operation.register
    }
}

data class Operation(var register: Register, private val operand: Int, private val operator: Operator) {
    fun execute() {
        register.value = operator.apply(register.value, operand)
    }
}

enum class Operator {
    INC {
        override fun apply(registerValue: Int, operand: Int): Int = registerValue + operand
    },
    DEC {
        override fun apply(registerValue: Int, operand: Int): Int = registerValue - operand
    };

    abstract fun apply(registerValue: Int, operand: Int): Int
}

data class Condition(private var register: Register, private val operand: Int, private val operator: ConditionalOperator) {
    fun execute(): Boolean = operator.apply(register.value, operand)
}

data class ConditionalOperator(val value: String) {
    fun apply(registerValue: Int, operand: Int): Boolean {
        return when (value) {
            ">" -> registerValue > operand
            ">=" -> registerValue >= operand
            "<" -> registerValue < operand
            "<=" -> registerValue <= operand
            "==" -> registerValue == operand
            "!=" -> registerValue != operand
            else -> throw UnsupportedOperationException(value)
        }
    }
}

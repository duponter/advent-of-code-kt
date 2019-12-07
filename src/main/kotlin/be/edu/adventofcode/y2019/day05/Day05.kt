package be.edu.adventofcode.y2019.day05

import be.edu.adventofcode.Text

class Day05 {
    fun bothParts(input: Text, inputInstruction: Int): Int {
        val mutableList = input.get().split(',')
                .map { it.toInt() }
                .toMutableList()

        println("$mutableList")
        var operation = Operation(0, -1)
        while (operation.index != -1) {
            operation = operation.apply(mutableList, inputInstruction)
        }
        return operation.output
    }
}

class Operation(val index: Int, val output: Int) {
    fun apply(values: MutableList<Int>, input: Int): Operation {
        val opCode = OpCode(values[index])
        val mode1 = opCode.parameterMode(1)
        val mode2 = opCode.parameterMode(2)
        val mode3 = opCode.parameterMode(3)
        when (opCode.intCode()) {
            1 -> {
                values[mode3.resolve(values, index + 3)] = mode1.resolve(values, values[index + 1]) + mode2.resolve(values, values[index + 2])
                return Operation(index + 4, output)
            }
            2 -> {
                values[mode3.resolve(values, index + 3)] = mode1.resolve(values, values[index + 1]) * mode2.resolve(values, values[index + 2])
                return Operation(index + 4, output)
            }
            3 -> {
                values[mode1.resolve(values, index + 1)] = input
                return Operation(index + 2, output)
            }
            4 -> {
                return Operation(index + 2, mode1.resolve(values, values[index + 1]))
            }
            5 -> {
                return if (values[mode1.resolve(values, index + 1)] != 0) Operation(values[mode2.resolve(values, index + 2)], output) else Operation(index + 3, output)
            }
            6 -> {
                return if (values[mode1.resolve(values, index + 1)] == 0) Operation(values[mode2.resolve(values, index + 2)], output) else Operation(index + 3, output)
            }
            7 -> {
                values[mode3.resolve(values, index + 3)] = if (values[mode1.resolve(values, index + 1)] < values[mode2.resolve(values, index + 2)]) 1 else 0
                return Operation(index + 4, output)
            }
            8 -> {
                values[mode3.resolve(values, index + 3)] = if (values[mode1.resolve(values, index + 1)] == values[mode2.resolve(values, index + 2)]) 1 else 0
                return Operation(index + 4, output)
            }
            99 -> return Operation(-1, output)
            else -> throw IllegalArgumentException("Invalid OpCode $opCode")
        }
    }
}

data class OpCode(val value: String) {
    constructor(intValue: Int) : this(intValue.toString().padStart(5, '0'))

    fun intCode(): Int = value.takeLast(2).toInt()

    fun parameterMode(order: Int): ParameterMode = ParameterMode.fromValue(value.drop(3 - order).take(1).toInt())
}

enum class ParameterMode {
    POSITION {
        override fun resolve(values: MutableList<Int>, parameter: Int): Int = values[parameter]
    },
    IMMEDIATE {
        override fun resolve(values: MutableList<Int>, parameter: Int): Int = parameter
    };

    abstract fun resolve(values: MutableList<Int>, parameter: Int): Int

    companion object {
        fun fromValue(value: Int): ParameterMode = when (value) {
            0 -> POSITION
            1 -> IMMEDIATE
            else -> throw IllegalArgumentException("Invalid ParameterMode $value")
        }
    }
}
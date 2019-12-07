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
        val param1 = opCode.parameter(1)
        val param2 = opCode.parameter(2)
        val param3 = opCode.parameter(3)
        when (opCode.intCode()) {
            1 -> {
                values[param3.immediate(values, index)] = param1.position(values, index) + param2.position(values, index)
                return Operation(index + 4, output)
            }
            2 -> {
                values[param3.immediate(values, index)] = param1.position(values, index) * param2.position(values, index)
                return Operation(index + 4, output)
            }
            3 -> {
                values[param1.immediate(values, index)] = input
                return Operation(index + 2, output)
            }
            4 -> {
                return Operation(index + 2, param1.position(values, index))
            }
            5 -> {
                return if (values[param1.immediate(values, index)] != 0) Operation(values[param2.immediate(values, index)], output) else Operation(index + 3, output)
            }
            6 -> {
                return if (values[param1.immediate(values, index)] == 0) Operation(values[param2.immediate(values, index)], output) else Operation(index + 3, output)
            }
            7 -> {
                values[param3.immediate(values, index)] = if (values[param1.immediate(values, index)] < values[param2.immediate(values, index)]) 1 else 0
                return Operation(index + 4, output)
            }
            8 -> {
                values[param3.immediate(values, index)] = if (values[param1.immediate(values, index)] == values[param2.immediate(values, index)]) 1 else 0
                return Operation(index + 4, output)
            }
            99 -> return Operation(-1, output)
            else -> throw IllegalArgumentException("Invalid OpCode $opCode")
        }
    }
}

data class Parameter(val order: Int, val mode: ParameterMode) {
    fun position(values: List<Int>, baseIndex: Int): Int = mode.resolve(values, values[baseIndex + order])

    fun immediate(values: List<Int>, baseIndex: Int): Int = mode.resolve(values, baseIndex + order)
}

data class OpCode(val value: String) {
    constructor(intValue: Int) : this(intValue.toString().padStart(5, '0'))

    fun intCode(): Int = value.takeLast(2).toInt()

    fun parameter(order: Int): Parameter = Parameter(order, ParameterMode.fromValue(value.drop(3 - order).take(1).toInt()))
}

enum class ParameterMode {
    POSITION {
        override fun resolve(values: List<Int>, parameter: Int): Int = values[parameter]
    },
    IMMEDIATE {
        override fun resolve(values: List<Int>, parameter: Int): Int = parameter
    };

    abstract fun resolve(values: List<Int>, parameter: Int): Int

    companion object {
        fun fromValue(value: Int): ParameterMode = when (value) {
            0 -> POSITION
            1 -> IMMEDIATE
            else -> throw IllegalArgumentException("Invalid ParameterMode $value")
        }
    }
}
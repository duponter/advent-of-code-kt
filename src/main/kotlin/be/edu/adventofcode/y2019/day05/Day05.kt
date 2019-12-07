package be.edu.adventofcode.y2019.day05

import be.edu.adventofcode.Text

class Day05 {
    fun bothParts(input: Text, inputInstruction: Int): Int {
        val mutableList = input.get().split(',')
                .map { it.toInt() }
                .toMutableList()

        var operation = Operation(0, IO(inputInstruction, 0))
        while (operation.index != -1) {
            operation = operation.apply(mutableList)
        }
        return operation.io.output
    }
}

class Operation(val index: Int, val io: IO<Int, Int>) {
    fun apply(values: MutableList<Int>): Operation {
        val opCode = OpCode(values[index])
        val param1 = opCode.parameter(1)
        val param2 = opCode.parameter(2)
        val param3 = opCode.parameter(3)
        when (opCode.intCode()) {
            1 -> {
                values[param3.immediate(values, index)] = param1.position(values, index) + param2.position(values, index)
                return Operation(index + 4, io)
            }
            2 -> {
                values[param3.immediate(values, index)] = param1.position(values, index) * param2.position(values, index)
                return Operation(index + 4, io)
            }
            3 -> {
                values[param1.immediate(values, index)] = io.input
                return Operation(index + 2, io)
            }
            4 -> {
                return Operation(index + 2, io.newOutput(param1.position(values, index)))
            }
            5 -> {
                return if (values[param1.immediate(values, index)] != 0) Operation(values[param2.immediate(values, index)], io) else Operation(index + 3, io)
            }
            6 -> {
                return if (values[param1.immediate(values, index)] == 0) Operation(values[param2.immediate(values, index)], io) else Operation(index + 3, io)
            }
            7 -> {
                values[param3.immediate(values, index)] = if (values[param1.immediate(values, index)] < values[param2.immediate(values, index)]) 1 else 0
                return Operation(index + 4, io)
            }
            8 -> {
                values[param3.immediate(values, index)] = if (values[param1.immediate(values, index)] == values[param2.immediate(values, index)]) 1 else 0
                return Operation(index + 4, io)
            }
            99 -> return Operation(-1, io)
            else -> throw IllegalArgumentException("Invalid OpCode $opCode")
        }
    }
}

data class IO<I, O>(val input: I, val output: O) {
    fun <T> newInput(input: T): IO<T, O> = IO(input, output)

    fun <T> newOutput(output: T): IO<I, T> = IO(input, output)
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
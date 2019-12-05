package be.edu.adventofcode.y2019.day05

import be.edu.adventofcode.Text

class Day05 {
    fun part1(input: Text, inputInstruction: Int): Int {
        val mutableList = input.get().split(',')
                .map { it.toInt() }
                .toMutableList()

        println("$mutableList")
        var pair = Pair(0, -1)
        while (pair.first != -1) {
            pair = Operation(pair).apply(mutableList, inputInstruction)
        }
        return pair.second
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }
}

class Operation(private val pair: Pair<Int, Int>) {
    fun apply(values: MutableList<Int>, input: Int): Pair<Int, Int> {
        val index = pair.first
        val opCode = values[index].toString().padStart(5, '0')
        println("operation code $opCode")
        val mode1 = ParameterMode.fromValue(opCode.drop(2).take(1).toInt())
        val mode2 = ParameterMode.fromValue(opCode.drop(1).take(1).toInt())
        val mode3 = ParameterMode.fromValue(opCode.take(1).toInt())
        when (opCode.takeLast(2).toInt()) {
            1 -> {
                values[mode3.resolve(values, index + 3)] = mode1.resolve(values, values[index + 1]) + mode2.resolve(values, values[index + 2])
                return Pair(index + 4, pair.second)
            }
            2 -> {
                values[mode3.resolve(values, index + 3)] = mode1.resolve(values, values[index + 1]) * mode2.resolve(values, values[index + 2])
                return Pair(index + 4, pair.second)
            }
            3 -> {
                values[mode1.resolve(values, index + 1)] = input
                return Pair(index + 2, pair.second)
            }
            4 -> {
                val output = mode1.resolve(values, values[index + 1])
                println("Output $output")
                return Pair(index + 2, output)
            }
            99 -> return Pair(-1, pair.second)
            else -> throw IllegalArgumentException("Invalid OpCode $opCode")
        }
    }
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
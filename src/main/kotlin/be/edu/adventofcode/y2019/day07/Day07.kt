package be.edu.adventofcode.y2019.day07

import be.edu.adventofcode.Text
import be.edu.adventofcode.y2019.intcode.OpCode

class Day07 {
    fun part1(input: Text): Int {
        return permutations((0..4).toList())
                .map { part1(input, it) }
                .max()!!
    }

    private fun <T> permutations(input: List<T>): List<List<T>> {
        if (input.size == 1) return listOf(input)
        val perms = mutableListOf<List<T>>()
        val toInsert = input[0]
        for (perm in permutations(input.drop(1))) {
            for (i in 0..perm.size) {
                val newPerm = perm.toMutableList()
                newPerm.add(i, toInsert)
                perms.add(newPerm)
            }
        }
        return perms
    }

    fun part1(input: Text, phaseSetting: List<Int>): Int {
        return execute(AmplifierControllerSoftware(input), Operation(0, IO(0, 0)), phaseSetting).io.output
    }

    private fun execute(acs: AmplifierControllerSoftware, start: Operation, phaseSetting: List<Int>): Operation {
        return phaseSetting.fold(start) { op, phase -> acs.execute(Operation(0, op.io.newInput(phase))) }
    }

    fun part2(input: Text): Int {
        return permutations((5..9).toList())
                .map { part2(input, it) }
                .max()!!
    }

    fun part2(input: Text, phaseSetting: List<Int>): Int {
        val amplifiers = generateSequence { phaseSetting }.flatten().iterator()

        val nextAmplifier = { io: IO<Int, Int> -> val tmp = io.newInput(amplifiers.next()); println("AMPL $tmp"); tmp  }
        val nextOutput = { io: IO<Int, Int> -> val tmp = io.newInput(io.output); println("OI $tmp"); tmp }
        val switcher = Switcher(nextAmplifier, nextOutput)

        return AmplifierControllerSoftware(input)
                .execute(Operation(0, IO(0, 0))) { switcher.apply(it) }
                .io.output
    }
}

class Switcher<T>(val first: (T) -> T, val second: (T) -> T) {
    var chooser = Chooser.FIRST

    fun apply(input: T): T {
        chooser = chooser.inverse()
        return chooser.inverse().delegate(first, second)(input)
    }
}

enum class Chooser {
    FIRST {
        override fun <T> delegate(first: T, second: T): T = first

        override fun inverse(): Chooser = SECOND
    },
    SECOND {
        override fun <T> delegate(first: T, second: T): T = second

        override fun inverse(): Chooser = FIRST
    };

    abstract fun <T> delegate(first: T, second: T): T

    abstract fun inverse(): Chooser
}

class AmplifierControllerSoftware(private val instructions: MutableList<Int>) {
    constructor(input: Text) : this(input.get().split(',')
            .map { it.toInt() }
            .toMutableList())

    fun execute(start: Operation): Operation = execute(start) { it.newInput(it.output) }

    fun execute(start: Operation, nextInput: (IO<Int, Int>) -> IO<Int, Int>): Operation {
        var operation = start
        while (operation.index != -1) {
            operation = operation.apply(instructions, nextInput)
        }
        return operation
    }
}

data class Operation(val index: Int, val io: IO<Int, Int>) {
    fun apply(values: MutableList<Int>): Operation = apply(values) { it.newInput(it.output) }

    fun apply(values: MutableList<Int>, nextInput: (IO<Int, Int>) -> IO<Int, Int>): Operation {
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
                val next = nextInput(io)
                values[param1.immediate(values, index)] = next.input
                println("input set to $next")
                return Operation(index + 2, next)
            }
            4 -> {
                val newOutput = io.newOutput(param1.position(values, index))
                println("new output: $newOutput")
                return Operation(index + 2, newOutput)
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
package be.edu.adventofcode.y2019.intcode

class Computer {
    fun execute(input: String, startingInput: Int): Int = Program(input).execute(startingInput)
}

class Program(val values: MutableList<Int>) {
    constructor(input: String) : this(input.split(',')
            .map { it.toInt() }
            .toMutableList())

    fun execute(startingInput: Int): Int {
        return execute(IntermediateOutput(startingInput, 0))
    }

    private tailrec fun execute(output: Output): Int {
        return when(output) {
            is IntermediateOutput -> execute(Operation(output.index).execute(this, Input(listOf(output.intermediate))))
            is FinalOutput -> output.final
        }
    }
}

interface Instruction {
    fun execute(program: Program, input: Input): Output
}

data class Input(var values: List<Int>) {
    fun next(): Int {
        val next = values.first()
        values = values.drop(1)
        return next
    }
}

sealed class Output(val value: Int)
data class IntermediateOutput(val intermediate: Int, val index: Int) : Output(intermediate)
data class FinalOutput(val final: Int) : Output(final)


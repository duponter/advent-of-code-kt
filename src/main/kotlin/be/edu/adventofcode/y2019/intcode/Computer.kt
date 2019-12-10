package be.edu.adventofcode.y2019.intcode

class Computer {
    fun execute(input: String, startingInput: Long): Long = Program(input).execute(startingInput)
}

open class Program(val values: MutableList<Long>) {
    constructor(input: String) : this(input.split(',')
            .map { it.toLong() }
            .toMutableList())

    open fun execute(startingInput: Long): Long {
        return execute(IntermediateOutput(startingInput, 0))
    }

    private tailrec fun execute(output: Output): Long {
        return when(output) {
            is IntermediateOutput -> execute(Operation(output.index).execute(this, Input(listOf(output.intermediate))))
            is FinalOutput -> output.final
        }
    }
}

class AmplifierControllerSoftware(input: String, val phaseSettings: List<Int>): Program(input) {
//    private val phaseIterator: Iterator<Int> = generateSequence { phaseSettings }.flatten().iterator()
//    private val phaseIterator: Iterator<Int> = phaseSettings.iterator()

    override fun execute(startingInput: Long): Long {
        return phaseSettings.fold(0L) { input, phase -> restartOnExecution(Input(listOf(phase.toLong(), input))) }
    }

    private fun restartOnExecution(input: Input): Long {
        return when(val output = Operation(0).execute(this, input)) {
            is IntermediateOutput -> output.intermediate
            is FinalOutput -> output.final
        }
    }

    private tailrec fun continueOnExecution(index: Int, input: Input): Long {
        return when (val output = Operation(index).execute(this, input)) {
            is IntermediateOutput -> continueOnExecution(output.index, input)
            is FinalOutput -> output.final
        }
    }
}

interface Instruction {
    fun execute(program: Program, input: Input): Output
}

data class Input(var values: List<Long>) {
    fun next(): Long {
        println("before $values")
        val next = values.first()
        values = values.drop(1)
        println("after $values, returning $next")
        return next
    }
}

sealed class Output(val value: Long)
data class IntermediateOutput(val intermediate: Long, val index: Int) : Output(intermediate)
data class FinalOutput(val final: Long) : Output(final)


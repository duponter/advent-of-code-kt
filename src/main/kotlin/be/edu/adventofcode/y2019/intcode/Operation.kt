package be.edu.adventofcode.y2019.intcode

data class Operation(val index: Int) : Instruction {
    override fun execute(program: Program, input: Input): Output {
        val opCode = OpCode(program.values[index])
        val param1 = opCode.parameter(1)
        val param2 = opCode.parameter(2)
        val param3 = opCode.parameter(3)
        when (opCode.intCode()) {
            1 -> {
                program.values[param3.immediate(program.values, index)] = param1.position(program.values, index) + param2.position(program.values, index)
                return Operation(index + 4).execute(program, input)
            }
            2 -> {
                program.values[param3.immediate(program.values, index)] = param1.position(program.values, index) * param2.position(program.values, index)
                return Operation(index + 4).execute(program, input)
            }
            3 -> {
                program.values[param1.immediate(program.values, index)] = input.next()
                return Operation(index + 2).execute(program, input)
            }
            4 -> {
                return IntermediateOutput(param1.position(program.values, index), index + 2)
            }
            5 -> {
                val nextOp = if (program.values[param1.immediate(program.values, index)] != 0) Operation(program.values[param2.immediate(program.values, index)]) else Operation(index + 3)
                return nextOp.execute(program, input)
            }
            6 -> {
                val nextOp = if (program.values[param1.immediate(program.values, index)] == 0) Operation(program.values[param2.immediate(program.values, index)]) else Operation(index + 3)
                return nextOp.execute(program, input)
            }
            7 -> {
                program.values[param3.immediate(program.values, index)] = if (program.values[param1.immediate(program.values, index)] < program.values[param2.immediate(program.values, index)]) 1 else 0
                return Operation(index + 4).execute(program, input)
            }
            8 -> {
                program.values[param3.immediate(program.values, index)] = if (program.values[param1.immediate(program.values, index)] == program.values[param2.immediate(program.values, index)]) 1 else 0
                return Operation(index + 4).execute(program, input)
            }
            99 -> return FinalOutput(input.next())
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
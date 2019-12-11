package be.edu.adventofcode.y2019.intcode

data class Operation(val index: Int) : Instruction {

    override fun execute(program: Program, input: Input, relativeBase: Int): Output {
        val opCode = OpCode(program.values[index])
        val param1 = opCode.parameter(1)
        val param2 = opCode.parameter(2)
        val param3 = opCode.parameter(3)
        println("Operation.execute(relativeBase:$relativeBase) with $opCode")
        when (opCode.intCode()) {
            1 -> {
                program.safeSet(param3.immediate(program, index, relativeBase), param1.position(program, index, relativeBase) + param2.position(program, index, relativeBase))
                return Operation(index + 4).execute(program, input, relativeBase)
            }
            2 -> {
                program.safeSet(param3.immediate(program, index, relativeBase), param1.position(program, index, relativeBase) * param2.position(program, index, relativeBase))
                return Operation(index + 4).execute(program, input, relativeBase)
            }
            3 -> {
                program.safeSet(param1.immediate(program, index, relativeBase), input.next())
                return Operation(index + 2).execute(program, input, relativeBase)
            }
            4 -> {
                return IntermediateOutput(param1.position(program, index, relativeBase), index + 2, relativeBase)
            }
            5 -> {
                val nextOp = if (program.safeGet(param1.immediate(program, index, relativeBase)) != 0L) Operation(program.safeGet(param2.immediate(program, index, relativeBase)).toInt()) else Operation(index + 3)
                return nextOp.execute(program, input, relativeBase)
            }
            6 -> {
                val nextOp = if (program.safeGet(param1.immediate(program, index, relativeBase)) == 0L) Operation(program.safeGet(param2.immediate(program, index, relativeBase)).toInt()) else Operation(index + 3)
                return nextOp.execute(program, input, relativeBase)
            }
            7 -> {
                program.safeSet(param3.immediate(program, index, relativeBase), if (program.safeGet(param1.immediate(program, index, relativeBase)) < program.safeGet(param2.immediate(program, index, relativeBase))) 1 else 0)
                return Operation(index + 4).execute(program, input, relativeBase)
            }
            8 -> {
                program.safeSet(param3.immediate(program, index, relativeBase), if (program.safeGet(param1.immediate(program, index, relativeBase)) == program.safeGet(param2.immediate(program, index, relativeBase))) 1 else 0)
                return Operation(index + 4).execute(program, input, relativeBase)
            }
            9 -> {
                return Operation(index + 2).execute(program, input, relativeBase + param1.position(program, index, relativeBase).toInt())
            }
            99 -> return FinalOutput(input.next())
            else -> throw IllegalArgumentException("Invalid OpCode $opCode")
        }
    }
}

data class Parameter(val order: Int, val mode: ParameterMode) {
    fun position(program: Program, baseIndex: Int, relativeBase: Int): Long = mode.resolve(program, program.safeGet(baseIndex + order.toLong()), relativeBase)

    fun immediate(program: Program, baseIndex: Int, relativeBase: Int): Long = mode.resolve(program, (baseIndex + order).toLong(), relativeBase)
}

data class OpCode(val value: String) {
    constructor(code: Long) : this(code.toString().padStart(5, '0'))

    fun intCode(): Int = value.takeLast(2).toInt()

    fun parameter(order: Int): Parameter = Parameter(order, ParameterMode.fromValue(value.drop(3 - order).take(1).toInt()))
}

enum class ParameterMode {
    POSITION {
        override fun resolve(program: Program, parameter: Long, relativeBase: Int): Long = program.safeGet(parameter)
    },
    IMMEDIATE {
        override fun resolve(program: Program, parameter: Long, relativeBase: Int): Long = parameter
    },
    RELATIVE {
        override fun resolve(program: Program, parameter: Long, relativeBase: Int): Long = program.safeGet(relativeBase + parameter)
    };

    abstract fun resolve(program: Program, parameter: Long, relativeBase: Int): Long

    companion object {
        fun fromValue(value: Int): ParameterMode = when (value) {
            0 -> POSITION
            1 -> IMMEDIATE
            2 -> RELATIVE
            else -> throw IllegalArgumentException("Invalid ParameterMode $value")
        }
    }
}
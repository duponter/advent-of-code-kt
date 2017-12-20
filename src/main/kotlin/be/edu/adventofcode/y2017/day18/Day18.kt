package be.edu.adventofcode.y2017.day18

import be.edu.adventofcode.Lines

class Day18 {
    fun part1(input: Lines): Int {
        val instructions = input.get().withIndex().map { Instruction.parse(it.index, it.value) }
        val registers = mutableMapOf<Char, Int>();
        var instruction = Pair(instructions.firstOrNull(), 0)
        while (instruction.first != null) {
            val first = instruction.first!!
            println("Executing $first")
            instruction = first.apply(registers, instructions)
        }
        return instruction.second
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

sealed class Instruction(val index: Int) {
    companion object {
        fun parse(index: Int, input: String): Instruction {
            val tokens = input.split(" ")
            return when {
                tokens.first() == "snd" -> Sound(index, tokens.last().first())
                tokens.first() == "set" -> Assign(index, tokens[1].first(), parseRegister(tokens.last()))
                tokens.first() == "add" -> Increase(index, tokens[1].first(), parseRegister(tokens.last()))
                tokens.first() == "mul" -> Multiplication(index, tokens[1].first(), parseRegister(tokens.last()))
                tokens.first() == "mod" -> Modulo(index, tokens[1].first(), parseRegister(tokens.last()))
                tokens.first() == "rcv" -> Recover(index, tokens.last().first())
                tokens.first() == "jgz" -> Jump(index, tokens[1].first(), parseRegister(tokens.last()))
                else -> throw UnsupportedOperationException(input)
            }
        }

        private fun parseRegister(input: String): Instruction = if (input.matches("-?\\d+".toRegex())) Constant(input.toInt()) else Lookup(input.first())
    }

    abstract fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int>

    fun next(instructions: List<Instruction>): Instruction? =
            if (instructions.last() != this) instructions[instructions.indexOf(this) + 1] else null
}

data class Constant(val value: Int) : Instruction(-1) {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int> = Pair(null, value)
}

data class Lookup(private val register: Char) : Instruction(-1) {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int> = Pair(null, registers[register] ?: 0)
}

data class Sound(private val idx: Int, private val register: Char) : Instruction(idx) {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int> {
        //snd X plays a sound with a frequency equal to the value of X.
        val value = Lookup(register).apply(registers, instructions).second
        registers['!'] = value
        return Pair(this.next(instructions), value)
    }
}

data class Assign(private val idx: Int, private val register: Char, private val instruction: Instruction) : Instruction(idx) {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int> {
        //set X Y sets register X to the value of Y.
        val value = instruction.apply(registers, instructions).second
        registers[register] = value
        return Pair(this.next(instructions), value)
    }
}

data class Increase(private val idx: Int, private val register: Char, private val instruction: Instruction) : Instruction(idx) {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int> {
        //add X Y increases register X by the value of Y.
        val value = Lookup(register).apply(registers, instructions).second + instruction.apply(registers, instructions).second
        registers[register] = value
        return Pair(this.next(instructions), value)
    }
}

data class Multiplication(private val idx: Int, private val register: Char, private val instruction: Instruction) : Instruction(idx) {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int> {
        //mul X Y sets register X to the result of multiplying the value contained in register X by the value of Y.
        val value = Lookup(register).apply(registers, instructions).second * instruction.apply(registers, instructions).second
        registers[register] = value
        return Pair(this.next(instructions), value)
    }
}

data class Modulo(private val idx: Int, private val register: Char, private val instruction: Instruction) : Instruction(idx) {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int> {
        //mod X Y sets register X to the remainder of dividing the value contained in register X by the value of Y (that is, it sets X to the result of X modulo Y).
        val value = Lookup(register).apply(registers, instructions).second % instruction.apply(registers, instructions).second
        registers[register] = value
        return Pair(this.next(instructions), value)
    }
}

data class Recover(private val idx: Int, private val register: Char) : Instruction(idx) {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int> {
        //rcv X recovers the frequency of the last sound played, but only when the value of X is not zero. (If it is zero, the command does nothing.)
        return if (Lookup(register).apply(registers, instructions).second != 0) {
            Pair(null, Lookup('!').apply(registers, instructions).second)
        } else {
            Pair(this.next(instructions), 0)
        }
    }
}

data class Jump(private val idx: Int, private val register: Char, private val instruction: Instruction) : Instruction(idx) {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Pair<Instruction?, Int> {
        //jgz X Y jumps with an offset of the value of Y, but only if the value of X is greater than zero. (An offset of 2 skips the next instruction, an offset of -1 jumps to the previous instruction, and so on.)
        return if (Lookup(register).apply(registers, instructions).second > 0) {
            println("Jumping to $this")
            val index = instructions.indexOf(this) + instruction.apply(registers, instructions).second
            if (index < 0 || index >= instructions.size) Pair(this.next(instructions), 0)
            else Pair(instructions[index], 0)
        } else Pair(this.next(instructions), 0)
    }
}
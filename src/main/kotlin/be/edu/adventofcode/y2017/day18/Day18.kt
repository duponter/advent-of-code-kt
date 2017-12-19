package be.edu.adventofcode.y2017.day18

import be.edu.adventofcode.Lines

class Day18 {
    fun part1(input: Lines): Int {
        input.get().map { Instruction.parse(it) }.forEach { println(it) }
        return input.get().count()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

sealed class Instruction {
    companion object {
        fun parse(input: String): Instruction {
            val tokens = input.split(" ")
            return when {
                tokens.first() == "snd" -> Sound(tokens.last().first())
                tokens.first() == "set" -> Assign(tokens[1].first(), parseRegister(tokens.last()))
                tokens.first() == "add" -> Increase(tokens[1].first(), parseRegister(tokens.last()))
                tokens.first() == "mul" -> Multiplication(tokens[1].first(), parseRegister(tokens.last()))
                tokens.first() == "mod" -> Modulo(tokens[1].first(), parseRegister(tokens.last()))
                tokens.first() == "rcv" -> Recover(tokens.last().first())
                tokens.first() == "jgz" -> Jump(tokens[1].first(), parseRegister(tokens.last()))
                else -> throw UnsupportedOperationException(input)
            }
        }

        private fun parseRegister(input: String): Instruction = if (input.matches("-?\\d+".toRegex())) Constant(input.toInt()) else Lookup(input.first())
    }

    abstract fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int
}

data class Constant(val value: Int) : Instruction() {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int = value
}

data class Lookup(private val register: Char) : Instruction() {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int = registers[register] ?: 0
}

data class Sound(private val register: Char) : Instruction() {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int {
        //snd X plays a sound with a frequency equal to the value of X.
        return Lookup(register).apply(registers, instructions)
    }
}

data class Assign(private val register: Char, private val instruction: Instruction) : Instruction() {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int {
        //set X Y sets register X to the value of Y.
        val value = instruction.apply(registers, instructions)
        registers[register] = value
        return value
    }
}

data class Increase(private val register: Char, private val instruction: Instruction) : Instruction() {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int {
        //add X Y increases register X by the value of Y.
        val value = Lookup(register).apply(registers, instructions) + instruction.apply(registers, instructions)
        registers[register] = value
        return value
    }
}

data class Multiplication(private val register: Char, private val instruction: Instruction) : Instruction() {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int {
        //mul X Y sets register X to the result of multiplying the value contained in register X by the value of Y.
        val value = Lookup(register).apply(registers, instructions) * instruction.apply(registers, instructions)
        registers[register] = value
        return value
    }
}

data class Modulo(private val register: Char, private val instruction: Instruction) : Instruction() {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int {
        //mod X Y sets register X to the remainder of dividing the value contained in register X by the value of Y (that is, it sets X to the result of X modulo Y).
        val value = Lookup(register).apply(registers, instructions) % instruction.apply(registers, instructions)
        registers[register] = value
        return value
    }
}

data class Recover(private val register: Char) : Instruction() {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int {
        //rcv X recovers the frequency of the last sound played, but only when the value of X is not zero. (If it is zero, the command does nothing.)
        return if (Lookup(register).apply(registers, instructions) != 0) {
//            instructions.takeWhile { it != this }.filter { it. }
//                    .filterIsInstance(Sound.class)
            0
        } else 0

    }
}

data class Jump(private val register: Char, private val instruction: Instruction) : Instruction() {
    override fun apply(registers: MutableMap<Char, Int>, instructions: List<Instruction>): Int {
        //jgz X Y jumps with an offset of the value of Y, but only if the value of X is greater than zero. (An offset of 2 skips the next instruction, an offset of -1 jumps to the previous instruction, and so on.)
        return if (Lookup(register).apply(registers, instructions) > 0) {
            instructions[instructions.indexOf(this) + instruction.apply(registers, instructions)].apply(registers, instructions)
        } else 0

    }
}


/*
set a 1
add a 2
mul a a
mod a 5
snd a
set a 0
rcv a
jgz a -1
set a 1
jgz a -2
 */
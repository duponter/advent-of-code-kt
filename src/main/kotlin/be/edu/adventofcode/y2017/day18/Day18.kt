package be.edu.adventofcode.y2017.day18

import be.edu.adventofcode.Lines

class Day18 {
    fun part1(input: Lines): Int {
        return input.get().count()
    }

    fun part2(input: Lines): Int {
        return input.get().count()
    }
}

sealed class Instruction {
    companion object {
        fun parse(input: String) {

        }
    }
}

data class Sound(val frequency: Int) : Instruction() {
//snd X plays a sound with a frequency equal to the value of X.
}

data class Set(val register: Char, val value: Int) : Instruction() {
//set X Y sets register X to the value of Y.
}

data class Increase(val register: Char, val value: Int) : Instruction() {
//add X Y increases register X by the value of Y.
}

data class Multiplication(val register: Char, val value: Int) : Instruction() {
//mul X Y sets register X to the result of multiplying the value contained in register X by the value of Y.
}

data class Modulo(val register: Char, val value: Int) : Instruction() {
//mod X Y sets register X to the remainder of dividing the value contained in register X by the value of Y (that is, it sets X to the result of X modulo Y).
}

data class Recover(val register: Char) : Instruction() {
//rcv X recovers the frequency of the last sound played, but only when the value of X is not zero. (If it is zero, the command does nothing.)
}

data class Jump(val register: Char, val offset: Int) : Instruction() {
//jgz X Y jumps with an offset of the value of Y, but only if the value of X is greater than zero. (An offset of 2 skips the next instruction, an offset of -1 jumps to the previous instruction, and so on.)
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
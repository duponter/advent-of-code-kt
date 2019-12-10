package be.edu.adventofcode.y2019.day05

import be.edu.adventofcode.Text
import be.edu.adventofcode.y2019.intcode.Computer

class Day05 {
    fun bothParts(input: Text, inputInstruction: Long): Long = Computer().execute(input.get(), inputInstruction)
}
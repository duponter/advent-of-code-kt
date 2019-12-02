package be.edu.adventofcode.y2019.day02

import be.edu.adventofcode.Text

class Day02 {
    fun part1(input: Text): Int {
        val mutableList = input.get().split(',')
                .map { it.toInt() }
                .toMutableList()
        mutableList[1] = 12
        mutableList[2] = 2

        return performOperations(mutableList)[0]
    }

    fun performOperations(mutableList: MutableList<Int>): MutableList<Int> {
        for (i in mutableList.indices step 4) {
            if (mutableList[i] == 99) break
            Operation(mutableList[i], mutableList[i + 1], mutableList[i + 2], mutableList[i + 3]).apply(mutableList)
        }
        return mutableList
    }

    fun part2(input: Text): Int {
        return input.get().count()
    }

    class Operation(private val opCode: Int, private val posInput1: Int, private val posInput2: Int, private val posResult: Int) {
        fun apply(values: MutableList<Int>) {
            val input1 = values[posInput1]
            val input2 = values[posInput2]
            if (opCode == 1) {
                values[posResult] = input1 + input2
            } else if (opCode == 2) {
                values[posResult] = input1 * input2
            }
        }

    }
}

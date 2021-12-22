package be.edu.adventofcode

import kotlin.math.pow

fun toDecimal(binaryNumber: String): Long = BinaryString(binaryNumber).toDecimal()

fun fromDecimal(decimalNumber: Int): String = BinaryString(decimalNumber.toLong()).value

fun pow(base: Int, exponent: Int) = base.toDouble().pow(exponent.toDouble()).toLong()

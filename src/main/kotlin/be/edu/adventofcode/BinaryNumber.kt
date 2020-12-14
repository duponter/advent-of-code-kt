package be.edu.adventofcode

import kotlin.math.pow

fun toDecimal(binaryNumber: String): Long {
    var sum = 0L
    binaryNumber.reversed().forEachIndexed { k, v ->
        sum += v.toString().toLong() * pow(2, k)
    }
    return sum
}

fun fromDecimal(decimalNumber: Int, binaryString: String = "") : String {
    while (decimalNumber > 0) {
        val temp = "${binaryString}${decimalNumber%2}"
        return fromDecimal(decimalNumber/2, temp)
    }
    return binaryString.reversed()
}

fun pow(base: Int, exponent: Int) = base.toDouble().pow(exponent.toDouble()).toLong()

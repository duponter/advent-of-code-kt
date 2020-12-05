package be.edu.adventofcode

import java.lang.Math.pow

fun toDecimal(binaryNumber : String) : Int {
    var sum = 0
    binaryNumber.reversed().forEachIndexed {
            k, v -> sum += v.toString().toInt() * pow(2, k)
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

fun pow(base: Int, exponent: Int) = pow(base.toDouble(), exponent.toDouble()).toInt()

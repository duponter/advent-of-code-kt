package be.edu.adventofcode


data class BinaryString(val value: String) {
    constructor(decimalNumber: Long) : this(fromDecimal(decimalNumber));

    private companion object Static {
        fun fromDecimal(decimalNumber: Long, binaryString: String = ""): String {
            while (decimalNumber > 0) {
                val temp = "${binaryString}${decimalNumber % 2}"
                return fromDecimal(decimalNumber / 2, temp)
            }
            return binaryString.reversed()
        }
    }

    fun inv(): BinaryString {
        return value.chunked(1) { it.first().digitToInt() }
            .map { it + 1 }
            .joinToString("")
            .replace('2', '0')
            .let { BinaryString(it) }
    }

    fun toDecimal(): Long {
        var sum = 0L
        value.reversed().forEachIndexed { k, v ->
            sum += v.toString().toLong() * pow(2, k)
        }
        return sum
    }

}


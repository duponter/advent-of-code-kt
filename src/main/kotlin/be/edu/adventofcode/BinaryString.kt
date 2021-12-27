package be.edu.adventofcode


data class BinaryString(val value: String) {
    constructor(decimalNumber: Long) : this(fromDecimal(decimalNumber));

    constructor(decimalNumber: Int) : this(decimalNumber.toLong());

    private companion object {
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

    fun toDecimal(): Long = value.toLong(2)
}


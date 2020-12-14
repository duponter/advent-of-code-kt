package be.edu.adventofcode.calculations


class Multiplications {
    companion object Static {
        // Greatest common divisor = GGD
        fun gcd(x: Long, y: Long): Long {
            return if (y == 0L) x else gcd(y, x % y)
        }

        fun gcd(numbers: Sequence<Long>): Long {
            return numbers.fold(0) { x: Long, y: Long -> gcd(x, y) }
        }

        // Least common multiple = KGV
        fun lcm(numbers: Sequence<Long>): Long {
            return numbers.fold(1) { x: Long, y: Long -> x * (y / gcd(x, y)) }
        }
    }
}
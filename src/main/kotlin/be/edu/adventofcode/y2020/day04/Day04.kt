package be.edu.adventofcode.y2020.day04

import be.edu.adventofcode.Text

class Day04 {
    fun part1(input: Text): Int {
        return input.get().split("\n\n")
            .map { Passport(it) }
            .count { it.allFieldsPresent() }
    }

    fun part2(input: Text): Int {
        return input.get().split("\n\n")
            .map { Passport(it) }
            .count { it.allFieldsPresent() && it.allValuesValid() }
    }

    class Passport(private val fields: Map<String, String>) {
        constructor(fieldString: String) : this(
            fieldString.split(Regex("\\s"))
                .map { it.split(':') }
                .associate { it[0] to it[1] }
        )

        fun allFieldsPresent(): Boolean = fields.size == 8 || (fields.size == 7 && !fields.containsKey("cid") )

        fun allValuesValid(): Boolean {
            return isBirthYearValid()
                    && isIssueYearValid()
                    && isExpirationYearValid()
                    && isHeightValid()
                    && isHairColorValid()
                    && isEyeColorValid()
                    && isPassportIdValid()
        }

        private fun isBirthYearValid(): Boolean {
            val byr = fields["byr"]!!
            return parseYear(byr) in 1920..2002
        }

        private fun isIssueYearValid(): Boolean {
            val iyr = fields["iyr"]!!
            return parseYear(iyr) in 2010 .. 2020
        }

        private fun isExpirationYearValid(): Boolean {
            val eyr = fields["eyr"]!!
            return parseYear(eyr) in 2020 .. 2030
        }

        private fun isHeightValid(): Boolean {
            val hgt = fields["hgt"]!!
            return Regex("(\\d+)(cm|in)").matchEntire(hgt)?.destructured
                .let { (it?.component1()?.toInt() ?: 0) to it?.component2() }
                .let { if (it.second == "cm") it.first in 150..193 else it.first in 59..76 }
        }

        private fun isHairColorValid(): Boolean {
            val hcl = fields["hcl"]!!
            return Regex("(#[\\da-f]{6})").matches(hcl)
        }

        private fun isEyeColorValid(): Boolean {
            val ecl = fields["ecl"]!!
            return listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(ecl)
        }

        private fun isPassportIdValid(): Boolean {
            val pid = fields["pid"]!!
            return Regex("(\\d{9})").matches(pid)
        }

        private fun parseYear(year: String): Int {
            return Regex("(\\d{4})").matchEntire(year)?.destructured
                .let { it!!.component1().toInt() }
        }
    }

}

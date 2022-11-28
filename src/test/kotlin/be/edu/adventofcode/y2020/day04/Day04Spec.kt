package be.edu.adventofcode.y2020.day04

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day04Spec : DescribeSpec({
    describe("day 04") {
        val day04 = Day04()
        context("part 1") {
            it("Your improved system would report 2 valid passports.") {
                day04.part1(TextFromString("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\nbyr:1937 iyr:2017 cid:147 hgt:183cm\n\niyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\nhcl:#cfa07d byr:1929\n\nhcl:#ae17e1 iyr:2013\neyr:2024\necl:brn pid:760753108 byr:1931\nhgt:179cm\n\nhcl:#cfa07d eyr:2025 pid:166559648\niyr:2011 ecl:brn hgt:59in")) shouldBe 2
            }
            it("In your batch file, how many passports are valid (required fields)?") {
                day04.part1(DayInput().text(day04)) shouldBe 245
            }
        }
        context("part 2") {
            it("invalid passports") {
                day04.part2(TextFromString("eyr:1972 cid:100\nhcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926\n\niyr:2019\nhcl:#602927 eyr:1967 hgt:170cm\necl:grn pid:012533040 byr:1946\n\nhcl:dab227 iyr:2012\necl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277\n\nhgt:59cm ecl:zzz\neyr:2038 hcl:74454a iyr:2023\npid:3556412378 byr:2007")) shouldBe 0
            }
            it("valid passports") {
                day04.part2(TextFromString("pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\nhcl:#623a2f\n\neyr:2029 ecl:blu cid:129 byr:1989\niyr:2014 pid:896056539 hcl:#a97842 hgt:165cm\n\nhcl:#888785\nhgt:164cm byr:2001 iyr:2015 cid:88\npid:545766238 ecl:hzl\neyr:2022\n\niyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719")) shouldBe 4
            }
            it("In your batch file, how many passports are valid (required fields + valid values)?") {
                day04.part2(DayInput().text(day04)) shouldBe 133
            }
        }
    }
})

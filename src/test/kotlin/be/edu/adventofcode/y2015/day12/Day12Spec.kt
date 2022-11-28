package be.edu.adventofcode.y2015.day12

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.TextFromString
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Day12Spec : DescribeSpec({
    describe("day 12") {
        val day12 = Day12()
        context("part 1") {
            it("[1,2,3] and {\"a\":2,\"b\":4} both have a sum of 6.") {
                day12.part1(TextFromString("[1,2,3]")) shouldBe 6
                day12.part1(TextFromString("{\"a\":2,\"b\":4}")) shouldBe 6
            }
            it("[[[3]]] and {\"a\":{\"b\":4},\"c\":-1} both have a sum of 3.") {
                day12.part1(TextFromString("[[[3]]]")) shouldBe 3
                day12.part1(TextFromString("{\"a\":{\"b\":4},\"c\":-1}")) shouldBe 3
            }
            it("{\"a\":[-1,1]} and [-1,{\"a\":1}] both have a sum of 0.") {
                day12.part1(TextFromString("{\"a\":[-1,1]}")) shouldBe 0
                day12.part1(TextFromString("[-1,{\"a\":1}]")) shouldBe 0
            }
            it("[] and {} both have a sum of 0.") {
                day12.part1(TextFromString("[]")) shouldBe 0
                day12.part1(TextFromString("{}")) shouldBe 0
            }
            it("should answer What is the sum of all numbers in the document?") {
                day12.part1(DayInput().text(day12)) shouldBe 191164
            }
        }
        context("part 2") {
            it("[1,2,3] still has a sum of 6.") {
                day12.part2(TextFromString("[1,2,3]")) shouldBe 6
            }
            it("[1,{\"c\":\"red\",\"b\":2},3] now has a sum of 4, because the middle object is ignored.") {
                day12.part2(TextFromString("[1,{\"c\":\"red\",\"b\":2},3]")) shouldBe 4
            }
            it("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5} now has a sum of 0, because the entire structure is ignored.") {
                day12.part2(TextFromString("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}")) shouldBe 0
            }
            it("[1,\"red\",5]") {
                day12.part2(TextFromString("[1,\"red\",5]")) shouldBe 6
            }
            it("{\"e\":126,\"c\":39,\"a\":[\"violet\",94,\"orange\",102,\"blue\"],\"b\":55,\"d\":\"yellow\",\"f\":\"yellow\"},146,{\"c\":169,\"a\":\"red\",\"b\":\"red\"}") {
                day12.part2(TextFromString("{\"e\":126,\"c\":39,\"a\":[\"violet\",94,\"orange\",102,\"blue\"],\"b\":55,\"d\":\"yellow\",\"f\":\"yellow\"},146,{\"c\":169,\"a\":\"red\",\"b\":\"red\"}")) shouldBe 562
            }
            it("{\"c\": [\"red\", 1], \"c\":1}") {
                day12.part2(TextFromString("{\"c\": [\"red\", 1], \"c\":1}")) shouldBe 2
            }
            it("should answer What is the sum of all numbers in the document, ignoring objects which has any property with the value \"red\"?") {
                day12.part2(DayInput().text(day12)) shouldBe 87842
            }
        }
    }
})

package be.edu.adventofcode.y2020

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

val testInput = LinesFromArray(
    "..##.........##.........##.........##.........##.........##.......",
    "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..",
    ".#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.",
    "..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#",
    ".#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.",
    "..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....",
    ".#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#",
    ".#........#.#........#.#........#.#........#.#........#.#........#",
    "#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...",
    "#...##....##...##....##...##....##...##....##...##....##...##....#",
    ".#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#"
)

class Day03Spec : DescribeSpec({
    describe("day 03") {
        val day03 = Day03()
        context("part 1") {
            it("testcase") {
                day03.part1(testInput) shouldBe 7
            }
            it("Following a slope of right 3 and down 1, how many trees would you encounter?") {
                day03.part1(DayInput().lines(day03)) shouldNotBe 94
                day03.part1(DayInput().lines(day03)) shouldNotBe 72
                day03.part1(DayInput().lines(day03)) shouldBe 272
            }
        }
        context("part 2") {
            it("testcase") {
                day03.slopeTreeCount(testInput, 1, 1) shouldBe 2
                day03.slopeTreeCount(testInput, 3, 1) shouldBe 7
                day03.slopeTreeCount(testInput, 5, 1) shouldBe 3
                day03.slopeTreeCount(testInput, 7, 1) shouldBe 4
                day03.slopeTreeCount(testInput, 1, 2) shouldBe 2
                day03.part2(testInput) shouldBe 336
            }
            it("What do you get if you multiply together the number of trees encountered on each of the listed slopes?") {
                day03.part2(DayInput().lines(day03)) shouldBe 3898725600
            }
        }
    }
})

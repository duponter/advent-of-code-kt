package be.edu.adventofcode.y2020.day03

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import io.kotest.core.spec.style.DescribeSpec
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

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
                assertEquals(7, day03.part1(testInput))
            }
            it("Following a slope of right 3 and down 1, how many trees would you encounter?") {
                assertNotEquals(94, day03.part1(DayInput().lines(day03)))
                assertNotEquals(72, day03.part1(DayInput().lines(day03)))
                assertEquals(272, day03.part1(DayInput().lines(day03)))
            }
        }
        context("part 2") {
            it("testcase") {
                assertEquals(2, day03.slopeTreeCount(testInput,1,1))
                assertEquals(7, day03.slopeTreeCount(testInput,3,1))
                assertEquals(3, day03.slopeTreeCount(testInput,5,1))
                assertEquals(4, day03.slopeTreeCount(testInput,7,1))
                assertEquals(2, day03.slopeTreeCount(testInput,1,2))
                assertEquals(336, day03.part2(testInput))
            }
            it("What do you get if you multiply together the number of trees encountered on each of the listed slopes?") {
                assertEquals(3898725600, day03.part2(DayInput().lines(day03)))
            }
        }
    }
})

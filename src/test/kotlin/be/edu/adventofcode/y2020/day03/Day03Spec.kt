package be.edu.adventofcode.y2020.day03

import be.edu.adventofcode.DayInput
import be.edu.adventofcode.LinesFromArray
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

object Day03Spec : Spek({
    describe("day 03") {
        val day03 = Day03()
        context("part 1") {
            it("testcase") {
                assertEquals(
                    7, day03.part1(
                        LinesFromArray(
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
                    )
                )
            }
            it("Following a slope of right 3 and down 1, how many trees would you encounter?") {
                assertNotEquals(94, day03.part1(DayInput().lines(day03)))
                assertNotEquals(72, day03.part1(DayInput().lines(day03)))
                assertEquals(272, day03.part1(DayInput().lines(day03)))
            }
        }
        xcontext("part 2") {
            it("testcase") {
                assertEquals(1, day03.part2(LinesFromArray("line")))
            }
            it("should answer Part2") {
                assertEquals(0, day03.part2(DayInput().lines(day03)))
            }
        }
    }
})

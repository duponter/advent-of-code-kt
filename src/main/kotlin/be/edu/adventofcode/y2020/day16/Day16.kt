package be.edu.adventofcode.y2020.day16

import be.edu.adventofcode.StringDestructure
import be.edu.adventofcode.Text

class Day16 {
    fun part1(input: Text): Int = TrainService.parse(input).ticketScanningErrors().sum()

    fun part2(input: Text): Int {
        return input.get().count()
    }

    data class TrainService(val rules: List<FieldRule>, val myTicket: Ticket, val nearbyTickets: List<Ticket>) {
        companion object {
            fun parse(input: Text): TrainService {
                val tokens: List<String> = input.get().split(Regex("(\\s*(?:your ticket|nearby tickets):\\s*)"))
                assert(tokens.size == 3) { "Expecting exactly 3 tokens to parse TrainService" }
                return TrainService(
                    tokens[0].split("\n").filterNot { it.isEmpty() }.map { FieldRule.parse(it) },
                    Ticket.parse(tokens[1]),
                    tokens[2].split("\n").filterNot { it.isEmpty() }.map { Ticket.parse(it) }
                )
            }
        }

        fun ticketScanningErrors(): List<Int> {
            val bundledRules: FieldRule = rules.reduce { acc, next -> acc.or(next) }
            return nearbyTickets.flatMap { it.invalidFields(bundledRules::validate) }
        }
    }

    data class Ticket(val fields: List<Int>) {
        companion object {
            fun parse(input: String): Ticket {
                return Ticket(input.replace("\n", "").split(',').map { it.toInt() })
            }
        }

        fun invalidFields(rules: (Int) -> Boolean): List<Int> = fields.filterNot(rules)
    }

    data class FieldRule(val name: String, val test: (Int) -> Boolean) {
        companion object {
            fun parse(input: String): FieldRule {
                val tokens = StringDestructure("([a-z ]+): (\\d+)-(\\d+) or (\\d+)-(\\d+)").many(input)
                assert(tokens.size == 5) { "Expecting exactly 5 tokens to parse FieldRule" }
                return FieldRule(tokens[0], createTest(tokens))
            }

            private fun createTest(tokens: List<String>): (Int) -> Boolean {
                return { value -> value in tokens[1].toInt()..tokens[2].toInt() || value in tokens[3].toInt()..tokens[4].toInt() }
            }
        }

        fun validate(input: Int): Boolean = test(input)

        fun or(other: FieldRule, names: (String, String) -> String = { n1, n2 -> "$n1||$n2" }): FieldRule {
            return FieldRule(names(name, other.name)) { value -> test(value) || other.test(value) }
        }
    }
}



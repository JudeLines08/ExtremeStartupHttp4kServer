package com.oocode

import kotlin.math.cbrt
import kotlin.math.sqrt

class Answerer {
    fun answerFor(question: String): String =
        if (question == "What is your name?") {
            "Jude"
        } else {
            if (question.contains("Which of the following numbers is the largest:")) {
                removeQuestionMark(question).split(":").last().split(",").maxOf { it }.trim()
            } else if (question.contains("plus")) {
                addNumbers(question)
            } else if (question.contains("multiplied by")) {
                multiplyNumbers(question)
            } else if (question.contains("Which of the following numbers is both a square and a cube: ")) {
                whatIsSquareAndCube(question)

            }
            else if (question.contains("minus")) {
                minusNumbers(question)
            }
            else if (question.contains("prime")) {
                isPrime(question)
            }
            else {""}
        }

    private fun minusNumbers(question: String): String =
        removeQuestionMark(question).split("What is ").last().split("minus")
            .map { it.trim() }
            .reduce { x,y -> (x.toInt() - y.toInt()).toString() }


    private fun addNumbers(question: String): String =
        removeQuestionMark(question).split("What is ").last().split("plus")
            .map { it.trim() }
            .sumOf { it.toInt() }
            .toString()

    private fun removeQuestionMark(question: String): String =
        question.split("?").first()

    private fun multiplyNumbers(question: String): String {
        val ints = removeQuestionMark(question).split("What is ").last().split("multiplied by ")
            .map { it.trim().toInt() }
        return (ints.first() * ints.last()).toString()
    }

    private fun whatIsSquareAndCube(question: String): String {
        val ints = removeQuestionMark(question).split("Which of the following numbers is both a square and a cube: ").last().split(", ")
            .filter {
                val x = sqrt(it.toDouble())
                x.minus(x.toInt()) == 0.0

            }.filter { val x = cbrt(it.toDouble())
                x.minus(x.toInt()) == 0.0
            }
        return ints.joinToString(", ") { it.toString() }

    }

    private fun isPrime(question: String): String {
        val split = removeQuestionMark(question)
            .split("Which of the following numbers are primes: ").last()
            .split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }

        val ints = split.filter { it.toIntOrNull()?.let(::isPrimeNumber) ?: false }
        return ints.joinToString(", ")
    }

    private fun isPrimeNumber(n: Int): Boolean {
        if (n < 2) return false
        if (n == 2) return true
        if (n % 2 == 0) return false
        var i = 3
        while (i * i <= n) {
            if (n % i == 0) return false
            i += 2
        }
        return true
    }

}

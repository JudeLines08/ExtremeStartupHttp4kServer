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
            else {""}
        }

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
}

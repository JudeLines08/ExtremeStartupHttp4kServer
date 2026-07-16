package com.oocode

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
            } else {""}
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
}

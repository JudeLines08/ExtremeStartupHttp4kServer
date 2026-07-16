package com.oocode

class Answerer {
    fun answerFor(question: String): String {

        return if (question == "What is your name?") "Jude"
        else {
            val isLargest = question.contains("Which of the following numbers is the largest:")
            if (isLargest) {
                question.split("?").first().split(":").last().split(",").maxOf { it }.trim()
            } else {
                val isAdd = question.contains("plus")
                if (isAdd) {
                    question.split("?").first().split("What is ").last().split("plus")
                        .map { it.trim() }
                        .sumOf { it.toInt() }
                        .toString()
                }
                else
                {
                    ""
                }
            }
        }
    }
}

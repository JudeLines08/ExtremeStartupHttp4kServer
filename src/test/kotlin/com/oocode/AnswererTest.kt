package com.oocode

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class AnswererTest {
    @Test
    fun canAnswerMyName() {
        val contents = Answerer().answerFor("What is your name?")
        assertThat(contents, equalTo("Jude"))
    }

    @Test
    fun canAnswerLargest() {
        val contents = Answerer().answerFor("Which of the following numbers is the largest: 21, 74, 14?")
        assertThat(contents, equalTo("74"))
    }
}

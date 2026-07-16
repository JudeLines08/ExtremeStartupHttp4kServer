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

    @Test
    fun canAddNumbers()
    {
        val contents = Answerer().answerFor("What is 4 plus 62?")
        assertThat(contents, equalTo("66"))
    }

    @Test
    fun canMultiply(){
        val contents = Answerer().answerFor("What is 92 multiplied by 46?")
        assertThat(contents, equalTo("4232"))
    }
}

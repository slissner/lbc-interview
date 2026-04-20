package com.slissner.lbc.interview.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomFizzBuzzTest {

    @Test
    fun `should apply, given multiple of int1 and int2, then expect concat str1str2`() {
        val result = CustomFizzBuzz(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz", number = 15).apply()
        assertThat("FizzBuzz").isEqualTo(result)
    }

    @Test
    fun `should apply given multipleOfInt1 then expectConcatStr1`() {
        val result = CustomFizzBuzz(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz", number = 9).apply()
        assertThat("Fizz").isEqualTo(result)
    }

    @Test
    fun `should apply, given multipleOfInt2, then expectConcatStr2`() {
        val result = CustomFizzBuzz(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz", number = 10).apply()
        assertThat("Buzz").isEqualTo(result)
    }

    @Test
    fun `should apply, given no multiple, then expect number as is`() {
        val result = CustomFizzBuzz(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz", number = 7).apply()
        assertThat("7").isEqualTo(result)
    }

    @Test
    fun `should return emitter`() {
        val emitter1 = CustomFizzBuzz.emitter(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz")
        val emitter2 = CustomFizzBuzz.emitter(int1 = 6, int2 = 7, limit = 100, str1 = "Fizz", str2 = "Buzz")

        assertThat(emitter1).isNotNull
        assertThat("FizzBuzz").isEqualTo(emitter1(15).apply())

        assertThat(emitter2).isNotNull
        assertThat("15").isEqualTo(emitter2(15).apply())
    }
}

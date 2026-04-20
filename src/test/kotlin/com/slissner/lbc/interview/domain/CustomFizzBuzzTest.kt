package com.slissner.lbc.interview.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CustomFizzBuzzTest {

    @Test
    fun test_apply_given_multipleOfInt1AndInt2_then_expectConcatStr1Str2() {
        val result = CustomFizzBuzz(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz", number = 15).apply()
        assertEquals("FizzBuzz", result)
    }

    @Test
    fun test_apply_given_multipleOfInt1_then_expectConcatStr1() {
        val result = CustomFizzBuzz(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz", number = 9).apply()
        assertEquals("Fizz", result)
    }

    @Test
    fun test_apply_given_multipleOfInt2_then_expectConcatStr2() {
        val result = CustomFizzBuzz(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz", number = 10).apply()
        assertEquals("Buzz", result)
    }

    @Test
    fun test_apply_given_noMultiple_then_expectNumberAsIs() {
        val result = CustomFizzBuzz(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz", number = 7).apply()
        assertEquals("7", result)
    }

    @Test
    fun test_emitter() {
        val emitter1 = CustomFizzBuzz.emitter(int1 = 3, int2 = 5, limit = 100, str1 = "Fizz", str2 = "Buzz")
        val emitter2 = CustomFizzBuzz.emitter(int1 = 6, int2 = 7, limit = 100, str1 = "Fizz", str2 = "Buzz")

        assertNotNull(emitter1)
        assertEquals("FizzBuzz", emitter1(15).apply())

        assertNotNull(emitter2)
        assertEquals("15", emitter2(15).apply())
    }
}

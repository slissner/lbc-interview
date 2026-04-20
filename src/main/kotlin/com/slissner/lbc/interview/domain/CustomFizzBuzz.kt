package com.slissner.lbc.interview.domain

import org.slf4j.LoggerFactory


/**
 * A custom fizz buzz implementation where all multiples of int1 are replaced by str1, all multiples of int2 are
 * replaced by str2, all multiples of int1 and int2 are replaced by str1str2.
 *
 * @param int1 1st multiple to replace
 * @param int2 2nd multiple to replace
 * @param limit max number to calculate
 * @param str1 1st replacement
 * @param str2 2nd replacement
 * @param number concrete number for which we want to calculate the fizz buzz
 * @return the calculated fizz buzz
 */
data class CustomFizzBuzz(
    val int1: Int,
    val int2: Int,
    val limit: Int,
    val str1: String,
    val str2: String,
    val number: Int
) {

    private val log = LoggerFactory.getLogger(CustomFizzBuzz::class.java)

    /**
     * Applies core domain logic of the custom fizz buzz data class.
     */
    fun apply(): String {
        val result =
            if (number % int1 == 0 && number % int2 == 0) {
                str1 + str2
            } else if (number % int1 == 0) {
                str1
            } else if (number % int2 == 0) {
                str2
            } else {
                number.toString()
            }
        log.debug("Calculated fizz buzz for number. [number={}, result={}]", number, result)
        return result
    }

    companion object {
        private val log = LoggerFactory.getLogger(CustomFizzBuzz::class.java)

        /**
         * Closure to create a new CustomFizzBuzz object.
         */
        fun emitter(int1: Int, int2: Int, limit: Int, str1: String, str2: String): (Int) -> CustomFizzBuzz {
            log.debug("Creating emitter for fizz buzz sequence. [int1=$int1, int2=$int2, limit=$limit, str1=$str1, str2=$str2]")
            return { number: Int ->
                log.trace("Emitting fizz buzz for number. [number=$number]")
                CustomFizzBuzz(int1, int2, limit, str1, str2, number)
            }
        }
    }
}

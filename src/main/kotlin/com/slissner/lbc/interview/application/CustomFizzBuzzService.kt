package com.slissner.lbc.interview.application

import com.slissner.lbc.interview.domain.CustomFizzBuzz
import com.slissner.lbc.interview.presentation.CustomFizzBuzzController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CustomFizzBuzzService(val statisticsService: CustomFizzBuzzStatisticsService) {

    private val log = LoggerFactory.getLogger(CustomFizzBuzzService::class.java)

    /**
     * Computes a sequence of custom FizzBuzz values based on the provided parameters.
     *
     * @param int1 The first integer used to determine divisibility.
     * @param int2 The second integer used to determine divisibility.
     * @param limit The maximum number up to which FizzBuzz values will be calculated.
     * @param str1 The string to replace multiples of int1.
     * @param str2 The string to replace multiples of int2.
     * @return A flow of strings representing the custom FizzBuzz sequence.
     */
    fun calcCustomFizzBuzz(int1: Int, int2: Int, limit: Int, str1: String, str2: String): Flow<String> {
        log.debug("Calculating custom fizz buzz. [int1=$int1, int2=$int2, limit=$limit, str1=$str1, str2=$str2]")

        statisticsService.count(int1, int2, str1, str2)

        val emitter = CustomFizzBuzz.emitter(int1, int2, limit, str1, str2)

        return (1..limit).asFlow()
            .map(emitter)
            .map(CustomFizzBuzz::apply)
    }
}

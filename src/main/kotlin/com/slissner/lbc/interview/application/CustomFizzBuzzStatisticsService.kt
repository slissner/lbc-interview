package com.slissner.lbc.interview.application

import com.slissner.lbc.interview.domain.CustomFizzBuzzStatistic
import com.slissner.lbc.interview.infrastructure.CustomFizzBuzzStatisticsRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.concurrent.atomics.ExperimentalAtomicApi

@Service
class CustomFizzBuzzStatisticsService(val statisticsRepository: CustomFizzBuzzStatisticsRepository) {

    private val log = LoggerFactory.getLogger(CustomFizzBuzzStatisticsService::class.java)

    fun count(int1: Int, int2: Int, str1: String, str2: String) {
        val count = statisticsRepository.count(CustomFizzBuzzStatistic.Key(int1, int2, str1, str2))
        log.debug("Counted custom fizz buzz statistic. [int1=$int1, int2=$int2, str1=$str1, str2=$str2, count=$count]")
    }

    @OptIn(ExperimentalAtomicApi::class)
    fun getMostFrequent(): CustomFizzBuzzStatistic? {
        return statisticsRepository.mostFrequent()
    }
}

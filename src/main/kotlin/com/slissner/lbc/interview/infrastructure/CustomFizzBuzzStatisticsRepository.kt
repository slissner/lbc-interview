package com.slissner.lbc.interview.infrastructure

import com.slissner.lbc.interview.domain.CustomFizzBuzzStatistic
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap
import kotlin.concurrent.atomics.AtomicLong
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.concurrent.atomics.incrementAndFetch

@Repository
@OptIn(ExperimentalAtomicApi::class)
class CustomFizzBuzzStatisticsRepository {

    private val frequencyMap = ConcurrentHashMap<CustomFizzBuzzStatistic.Key, AtomicLong>()

    fun count(key: CustomFizzBuzzStatistic.Key): Long {
        return frequencyMap
            .getOrPut(key) { AtomicLong(0) }
            .incrementAndFetch()
    }

    fun mostFrequent(): CustomFizzBuzzStatistic? {
        return frequencyMap
            .maxByOrNull { it.value.load() }
            ?.let { CustomFizzBuzzStatistic(it.key, it.value.load()) }
    }

}

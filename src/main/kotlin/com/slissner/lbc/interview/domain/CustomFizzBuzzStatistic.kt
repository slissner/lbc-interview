package com.slissner.lbc.interview.domain

data class CustomFizzBuzzStatistic(
    val key: Key,
    val hits: Long
) {
    data class Key(val int1: Int, val int2: Int, val str1: String, val str2: String)
}

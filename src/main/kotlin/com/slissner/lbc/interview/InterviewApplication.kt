package com.slissner.lbc.interview

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InterviewApplication

private val log = LoggerFactory.getLogger(InterviewApplication::class.java)

fun main(args: Array<String>) {
	runApplication<InterviewApplication>(*args)
	log.info("FizzBuzz Application started")
}

package com.slissner.lbc.interview.presentation

import com.slissner.lbc.interview.application.CustomFizzBuzzService
import kotlinx.coroutines.flow.toList
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CustomFizzBuzzController(val customFizzBuzzService: CustomFizzBuzzService) {

    private val log = LoggerFactory.getLogger(CustomFizzBuzzController::class.java)

    @GetMapping("/fizzbuzz")
    @ResponseBody
    suspend fun getCustomFizzBuzz(): ResponseEntity<String> {
        log.info("User requested custom fizz buzz.")

        val result = customFizzBuzzService.calcCustomFizzBuzz(3, 5, 100, "Fizz", "Buzz")

        // TODO return result as stream - warning: currently loads into memory and blocks thread
        log.debug("TODO fizz buzz result: {}", result.toList())

        return ResponseEntity.ok("TODO")
    }
}

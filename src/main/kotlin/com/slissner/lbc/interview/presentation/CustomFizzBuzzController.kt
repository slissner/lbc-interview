package com.slissner.lbc.interview.presentation

import com.slissner.lbc.interview.application.CustomFizzBuzzService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CustomFizzBuzzController(val customFizzBuzzService: CustomFizzBuzzService) {

    private val log = LoggerFactory.getLogger(CustomFizzBuzzController::class.java)

    @GetMapping("/fizzbuzz", produces = [MediaType.APPLICATION_NDJSON_VALUE])
    @ResponseBody
    suspend fun getCustomFizzBuzz(
        @RequestParam int1: Int,
        @RequestParam int2: Int,
        @RequestParam limit: Int,
        @RequestParam str1: String,
        @RequestParam str2: String
    ): Flow<CustomFizzBuzzResponseDto> {
        log.info("User requested custom fizz buzz. [int1=$int1, int2=$int2, limit=$limit, str1=$str1, str2=$str2]")

        val fizzBuzzFlow = customFizzBuzzService.calcCustomFizzBuzz(
            int1 = int1,
            int2 = int2,
            limit = limit,
            str1 = str1,
            str2 = str2
        ).map { CustomFizzBuzzResponseDto(it) }

        return fizzBuzzFlow
    }
}

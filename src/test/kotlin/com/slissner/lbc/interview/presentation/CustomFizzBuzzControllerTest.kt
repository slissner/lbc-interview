package com.slissner.lbc.interview.presentation

import com.slissner.lbc.interview.application.CustomFizzBuzzService
import com.slissner.lbc.interview.application.CustomFizzBuzzStatisticsService
import kotlinx.coroutines.flow.flow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBodyList

@WebFluxTest(CustomFizzBuzzController::class)
class CustomFizzBuzzControllerTest {

    @Autowired
    private lateinit var client: WebTestClient

    @MockitoBean
    private lateinit var customFizzBuzzService: CustomFizzBuzzService

    @MockitoBean
    private lateinit var statisticsService: CustomFizzBuzzStatisticsService

    @Test
    fun `should return fizzbuzz stream`() {
        val items = listOf("1", "2", "fizz", "4", "buzz")

        whenever(
            customFizzBuzzService.calcCustomFizzBuzz(
                int1 = any(),
                int2 = any(),
                limit = any(),
                str1 = any(),
                str2 = any()
            )
        ).thenReturn(flow { items.forEach { emit(it) } })

        val result = client.get()
            .uri { uriBuilder ->
                uriBuilder.path("/fizzbuzz")
                    .queryParam("int1", 3)
                    .queryParam("int2", 5)
                    .queryParam("limit", 5)
                    .queryParam("str1", "fizz")
                    .queryParam("str2", "buzz")
                    .build()
            }
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus().isOk
            .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .expectBodyList<CustomFizzBuzzResponseDto>()
            .returnResult()
            .responseBody!!

        assertThat(result.map { it.value }).containsExactlyElementsOf(items)
    }
}

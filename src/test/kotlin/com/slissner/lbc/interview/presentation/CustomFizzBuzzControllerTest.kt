package com.slissner.lbc.interview.presentation

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@WebFluxTest(CustomFizzBuzzController::class)
class CustomFizzBuzzControllerTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    fun getCustomFizzBuzz() {
        webTestClient.get()
            .uri("/fizzbuzz")
            .exchange()
            .expectStatus().isOk
            .expectBody<String>()
            .isEqualTo("TODO")
    }
}

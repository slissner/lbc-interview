package com.slissner.lbc.interview.application

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
class CustomFizzBuzzServiceTest {

    @Mock
    private lateinit var statisticsService: CustomFizzBuzzStatisticsService

    @InjectMocks
    private lateinit var service: CustomFizzBuzzService

    @Test
    fun `should return a custom fizz buzz flow`() = runTest {

        val result = service.calcCustomFizzBuzz(int1 = 3, int2 = 5, limit = 5, str1 = "fizz", str2 = "buzz")
            .toList()

        assertEquals(listOf("1", "2", "fizz", "4", "buzz"), result)

        verify(statisticsService).count(
            anyInt(),
            anyInt(),
            anyString(),
            anyString()
        )
    }
}

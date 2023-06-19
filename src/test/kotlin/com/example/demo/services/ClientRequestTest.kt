package com.example.demo.services

import com.example.demo.domain.model.forecast.City
import org.junit.jupiter.api.Test

class ClientRequestTest {

    private val clientRequest = ClientRequest()
    @Test
    fun forecast() {
        clientRequest.forecast(City("Kemerovo"))
    }

    @Test
    fun weather() {
        clientRequest.weather(City("Kemerovo"))
    }
}
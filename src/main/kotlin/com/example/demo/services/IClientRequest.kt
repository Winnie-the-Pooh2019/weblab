package com.example.demo.services

import com.example.demo.domain.model.forecast.City

interface IClientRequest {
    fun forecast(city: City)

    fun weather(city: City)
}
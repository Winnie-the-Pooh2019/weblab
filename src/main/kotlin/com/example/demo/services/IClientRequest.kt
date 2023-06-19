package com.example.demo.services

import com.example.demo.domain.model.City
import com.example.demo.domain.model.ForecastWrapper
import com.example.demo.domain.model.weather.WeatherWrapper

interface IClientRequest {
    fun forecast(city: City): ForecastWrapper

    fun weather(city: City): WeatherWrapper
}
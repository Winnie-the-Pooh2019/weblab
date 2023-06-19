package com.example.demo.services

import com.example.demo.domain.model.forecast.City
import com.example.demo.domain.model.forecast.ForecastWrapper
import com.example.demo.domain.model.weather.WeatherWrapper

interface IClientRequest {
    fun forecast(): ForecastWrapper

    fun weather(): WeatherWrapper
}
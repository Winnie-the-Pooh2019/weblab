package com.example.demo.domain.model.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherWrapper(
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,

    @SerialName("name")
    val cityName: String
)

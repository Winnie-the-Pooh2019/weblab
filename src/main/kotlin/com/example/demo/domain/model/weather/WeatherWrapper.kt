package com.example.demo.domain.model.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class WeatherWrapper(
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,

    @SerializedName("name")
    val cityName: String
)

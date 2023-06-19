package com.example.demo.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Main(
    val temp: Double,

    @SerialName("feels_like")
    val feelsLike: Double
)

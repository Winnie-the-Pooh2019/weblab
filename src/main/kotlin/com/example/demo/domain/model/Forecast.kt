package com.example.demo.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    val main: Main,

    @SerialName("dt_txt")
    val date: String
)

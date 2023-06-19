package com.example.demo.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ForecastWrapper(
    val list: List<Forecast>,
    val city: City
)

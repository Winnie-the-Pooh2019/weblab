package com.example.demo.domain.model.forecast

data class ForecastWrapper(
    val list: List<Forecast>,
    val city: City
)

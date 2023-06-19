package com.example.demo.domain.model.forecast

import com.google.gson.annotations.SerializedName

data class Main(
    val temp: Double,

    @SerializedName("feels_like")
    val feelsLike: Double
)

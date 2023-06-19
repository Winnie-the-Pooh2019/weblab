package com.example.demo.domain.model.forecast

import com.google.gson.annotations.SerializedName

data class Forecast(
    val main: Main,

    @SerializedName("dt_txt")
    val date: String
)

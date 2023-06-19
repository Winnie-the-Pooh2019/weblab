package com.example.demo.services

import com.example.demo.domain.model.forecast.City
import com.example.demo.domain.model.forecast.Forecast
import com.example.demo.domain.model.forecast.ForecastWrapper
import com.example.demo.domain.model.weather.WeatherWrapper
import com.google.gson.Gson
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class ClientRequest : IClientRequest {
    override fun forecast(): ForecastWrapper {
        val restTemplate = RestTemplate()

        val url = "https://api.openweathermap.org/data/2.5/weather?q=Kemerovo&appid=b7eedb84f15757c5da8941a00663136d&units=metric&lang=ru"

        val response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            String::class.java
        )

        val body = Gson().fromJson(response.body, ForecastWrapper::class.java)

        println(body)

        return body
    }

    override fun weather(): WeatherWrapper {
        val restTemplate = RestTemplate()

        val url = "https://api.openweathermap.org/data/2.5/weather?q=Kemerovo&appid=b7eedb84f15757c5da8941a00663136d&units=metric&lang=ru"

        val response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            String::class.java
        )

        val body = Gson().fromJson(response.body, WeatherWrapper::class.java)

        println(body)

        return body
    }
}
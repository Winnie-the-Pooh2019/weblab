package com.example.demo.controllers

import com.example.demo.services.ClientRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("api")
class WeatherController(
    @Autowired
    private val clientRequest: ClientRequest
) {
    @GetMapping("forecast")
    fun forecast(model: Model): String {
        val forecastWrapper = clientRequest.forecast()

        model.addAttribute("city", forecastWrapper.city)
        model.addAttribute("forecasts", forecastWrapper.list)

        return "forecast"
    }

    @GetMapping("weather")
    fun weather(model: Model): String {
        val weatherWrapper = clientRequest.weather()

        model.addAttribute("city", weatherWrapper.cityName)
        model.addAttribute("weathers", weatherWrapper.weather)

        return "weather"
    }
}
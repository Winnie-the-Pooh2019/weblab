package com.example.demo.controllers

import com.example.demo.dto.LoginDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginMvcController {
    @GetMapping("/login")
    fun login(model: Model): String {
        println("HELLO FROM LOGIN ")

        model.addAttribute("user", LoginDto())

        return "login"
    }

    @GetMapping("/register")
    fun register(model: Model): String {
        println("HELLO FROM LOGIN ")

        model.addAttribute("user", LoginDto())

        return "register"
    }
}
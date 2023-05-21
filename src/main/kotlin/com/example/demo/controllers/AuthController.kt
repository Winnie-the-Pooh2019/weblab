package com.example.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController {
    @GetMapping("hello")
    fun hello() = "hello"
}
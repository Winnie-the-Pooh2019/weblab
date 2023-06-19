package com.example.demo.dto

import com.example.demo.models.User

data class RegisterDto(
    val name: String,
    val email: String,
    val password: String,
    val city: String
) {
    fun toEntity() = User(
        name = name,
        email = email,
        password = password,
        city = city
    )
}

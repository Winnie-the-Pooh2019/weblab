package com.example.demo.dto

import com.example.demo.models.User

data class RegisterDto(
    val name: String,
    val email: String,
    val password: String
) {
    fun toEntity() = User()
}

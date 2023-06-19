package com.example.demo.services

import com.example.demo.models.User
import com.example.demo.repos.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun save(user: User) = userRepository.save(user)

    fun findByEmail(email: String) = userRepository.findByEmail(email)
}
package com.example.demo.controllers

import com.example.demo.dto.LoginDto
import com.example.demo.dto.Message
import com.example.demo.dto.RegisterDto
import com.example.demo.models.User
import com.example.demo.services.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
class AuthController(private val userService: UserService) {

    @PostMapping("register")
    fun register(userCredentials: RegisterDto): ResponseEntity<User> {
        println("HELLO FROM REG")

        return ResponseEntity.ok(userService.save(userCredentials.toEntity()))
    }

    @PostMapping("login")
    fun login(userCredentials: LoginDto, response: HttpServletResponse): ResponseEntity<Any> {
        val user = userService.findByEmail(userCredentials.email)
            ?: return ResponseEntity.badRequest().body(Message("User not found"))

        if (!user.comparePass(userCredentials.password))
            return ResponseEntity.badRequest().body(Message("Invalid password"))

        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() * 24 * 60 * 1000))
            .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256)).compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("Success"))
    }
}

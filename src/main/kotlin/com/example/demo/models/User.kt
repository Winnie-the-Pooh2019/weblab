package com.example.demo.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @Column
    var name: String = ""

    @Column
    var email: String = ""

    @Column
    var password: String = ""
        set(value) {
            field = BCryptPasswordEncoder().encode(value)
        }

    fun comparePass(password: String) = BCryptPasswordEncoder().matches(password, this.password)
}

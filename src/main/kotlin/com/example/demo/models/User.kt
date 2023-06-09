package com.example.demo.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0,

    @Column
    var name: String = "",

    @Column
    var email: String = "",

    @Column
    var city: String = ""
) {
    @Column
    var password: String = ""
        set(value) {
            field = BCryptPasswordEncoder().encode(value)
        }

    public constructor(
        id: Int = 0,
        name: String,
        email: String,
        password: String,
        city: String
    ) : this(id, name, email, city) {
        this.password = password
    }

    fun comparePass(password: String) = BCryptPasswordEncoder().matches(password, this.password)
}
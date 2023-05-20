package com.example.demo.models

import kotlinx.serialization.Serializable

@Serializable
data class Bank(
    val accountNumber: String,
    var trust: Double,
    var transactionFee: Int
)

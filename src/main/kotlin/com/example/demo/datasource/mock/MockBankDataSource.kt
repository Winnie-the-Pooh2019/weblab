package com.example.demo.datasource.mock

import com.example.demo.datasource.BankDataSource
import com.example.demo.models.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
    private val banks = listOf(
        Bank("asfs", 5.0, 1),
        Bank("123123", 4.2, 4),
        Bank("4144141", 6.2, 23)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
}
package com.example.demo.datasource.mock

import com.example.demo.datasource.BankDataSource
import com.example.demo.models.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockBankDataSource : BankDataSource {
    private val banks = mutableListOf(
        Bank("asfs", 5.0, 1),
        Bank("123123", 4.2, 4),
        Bank("4144141", 6.2, 23)
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String) = banks.firstOrNull { it.accountNumber == accountNumber }
        ?: throw NoSuchElementException("No bank with number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any {it.accountNumber == bank.accountNumber})
            throw IllegalArgumentException("Bank with number ${bank.accountNumber} already exist")

        banks.add(bank)

        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number ${bank.accountNumber}")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

        banks.remove(currentBank)
    }
}
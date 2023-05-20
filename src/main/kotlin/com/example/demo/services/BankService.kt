package com.example.demo.services

import com.example.demo.datasource.BankDataSource
import com.example.demo.models.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()

    fun getBank(accountNumber: String) = dataSource.retrieveBank(accountNumber)

    fun addBank(bank: Bank) = dataSource.createBank(bank)

    fun updateBank(bank: Bank) = dataSource.updateBank(bank)

    fun deleteBank(accountNumber: String) = dataSource.deleteBank(accountNumber)
}
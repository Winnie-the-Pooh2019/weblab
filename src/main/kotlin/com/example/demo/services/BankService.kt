package com.example.demo.services

import com.example.demo.datasource.BankDataSource
import com.example.demo.models.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
}
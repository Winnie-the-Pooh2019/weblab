package com.example.demo.datasource

import com.example.demo.models.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
}
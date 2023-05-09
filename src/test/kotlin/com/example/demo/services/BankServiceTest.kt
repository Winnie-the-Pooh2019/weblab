package com.example.demo.services

import com.example.demo.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify

class BankServiceTest {
    private val dataSource = mockk<BankDataSource>(relaxed = true)

    private val bankService = BankService(dataSource)
    
    @Test
    fun `should call its data source to retrieve banks`() {
        // given
        every { dataSource.retrieveBanks() } returns emptyList()
        // when
        bankService.getBanks()
        // then
        verify(exactly = 1) { dataSource.retrieveBanks() }
    }
}
package com.example.demo.datasource.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MockBankDataSourceTest {

    private val mockSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks`() {
        // given

        // when
        val banks = mockSource.retrieveBanks()
        // then
        Assertions.assertThat(banks).isNotEmpty
        Assertions.assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide mock data`() {
        // given

        // when
        val banks = mockSource.retrieveBanks()
        // then
        Assertions.assertThat(banks).allSatisfy { it.accountNumber.isNotBlank() }
        Assertions.assertThat(banks).anyMatch { it.transactionFee != 0 }
        Assertions.assertThat(banks).anyMatch { it.trust != 0.0 }
    }
}
package com.example.demo.controllers

import com.example.demo.models.Bank
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.*
import java.util.stream.Stream

@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    private final val url = "/api/banks"

    @Test
    fun `should return all blanks`() {
        mockMvc.get(url)
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
            }
    }

    @Test
    fun `should return one bank successfully`() {
        // given
        val accountId = "asfs"

        // when/then
        mockMvc.get("$url/$accountId").andDo { print() }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$.accountNumber") { value(accountId) }
        }
    }

    @Test
    fun `should NOT found`() {
        val accountId = "number"

        // when/then
        mockMvc.get("$url/$accountId").andDo { print() }
            .andExpect { status { isNotFound() } }
    }

    @Test
    fun `should add new bank`() {
        val newBank = Bank(
            accountNumber = "124421",
            trust = 3.2,
            transactionFee = 4
        )

        mockMvc.post(url) {
            contentType = MediaType.APPLICATION_JSON
            content = Json.encodeToString(newBank)
        }
            .andDo { print() }
            .andExpect {
                status { isCreated() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    json(Json.encodeToString(newBank))
                }
            }

        mockMvc.get("$url/${newBank.accountNumber}")
            .andExpect { content { json(Json.encodeToString(newBank)) } }
    }

    @Test
    fun `should return bad request while adding corrupted bank`() {
        val bank = Bank(
            accountNumber = "asfs",
            trust = 1.0,
            transactionFee = 2
        )

        mockMvc.post(url) {
            contentType = MediaType.APPLICATION_JSON
            content = Json.encodeToString(bank)
        }
            .andDo { print() }
            .andExpect { status { isBadRequest() } }
    }

    @Test
    @DirtiesContext
    fun `should delete existing bank`() {
        val accountId = "asfs"

        mockMvc.delete("$url/${accountId}")
            .andDo { print() }
            .andExpect { status { isNoContent() } }

        mockMvc.get("$url/${accountId}")
            .andExpect { status { isNotFound() } }
    }

    @Test
    fun `should return not found while deleting bank with corrupted account id`() {
        val accountId = "corrupted id"

        mockMvc.delete("$url/$accountId")
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }

    @Test
    fun `should update an existing bank`() {
        val bank = Bank(
            accountNumber = "asfs",
            1.0,
            1
        )

        mockMvc.patch(url) {
            contentType = MediaType.APPLICATION_JSON
            content = Json.encodeToString(bank)
        }
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    json(Json.encodeToString(bank))
                }
            }

        mockMvc.get("$url/${bank.accountNumber}")
            .andExpect { content { json(Json.encodeToString(bank)) } }
    }

    @Test
    fun `should return not found while updating corrupted bank`() {
        val bank = Bank(
            accountNumber = "false number",
            trust = 4.5,
            transactionFee = 4
        )

        mockMvc.patch(url) {
            contentType = MediaType.APPLICATION_JSON
            content = Json.encodeToString(bank)
        }
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }
}
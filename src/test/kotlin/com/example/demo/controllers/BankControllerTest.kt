package com.example.demo.controllers

import com.example.demo.models.Bank
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
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.util.stream.Stream

@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return all blanks`() {
        mockMvc.get("/api/banks")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].accountNumber") { value("asfs") }
            }
    }

    @Test
    fun `should return one bank successfully`() {
        // when/then
        mockMvc.get("/api/banks/asfs").andDo { print() }.andExpect {
            status { isOk() }
        }
    }

    @Test
    fun `should return one bank non successfully`() {
        // when/then
        mockMvc.get("/api/banks/123321").andDo { print() }.andExpect {
            status { isNoContent() }
        }
    }

//    @ParameterizedTest
//    fun `should put bank`(intput: Bank, expected: HttpStatus) {
//        // when/then
//
//    }
}
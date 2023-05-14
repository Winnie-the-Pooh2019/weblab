package com.example.demo.controllers

import com.example.demo.models.Bank
import com.example.demo.services.BankService
import org.apache.coyote.ContinueResponseTiming
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.reflect.full.memberProperties

@RestController
@RequestMapping("/api/banks")
class BankController(
    @Autowired
    private val service: BankService
) {

    @GetMapping
    fun getBanks() = service.getBanks()

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): ResponseEntity<Bank> {
        val bank = service.getBanks().find { it.accountNumber == id }

        return if (bank == null)
            ResponseEntity(HttpStatus.NO_CONTENT)
        else
            ResponseEntity(bank, HttpStatus.OK)
    }

    @PostMapping
    fun addBank(@RequestBody bank: Bank): ResponseEntity<Bank> {
        if (service.getBanks().toMutableList().add(bank))
            return ResponseEntity(bank, HttpStatus.CREATED)

        return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @PatchMapping
    fun updateBank(@RequestBody bank: Bank): ResponseEntity<Bank> {
        val oldBank = service.getBanks().find { it.accountNumber == bank.accountNumber }
            ?: return ResponseEntity(HttpStatus.NO_CONTENT)

        oldBank.transactionFee = bank.transactionFee
        oldBank.trust = bank.trust

        return ResponseEntity(oldBank, HttpStatus.OK)
    }

    @DeleteMapping
    fun deleteById(@PathVariable id: String): ResponseEntity<Bank> =
        if (service.getBanks().toMutableList().removeIf { it.accountNumber == id })
            ResponseEntity(HttpStatus.OK)
        else
            ResponseEntity(HttpStatus.NO_CONTENT)
}
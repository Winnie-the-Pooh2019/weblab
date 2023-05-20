package com.example.demo.controllers

import com.example.demo.models.Bank
import com.example.demo.services.BankService
import org.apache.coyote.ContinueResponseTiming
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException

@RestController
@RequestMapping("/api/banks")
class BankController(
    @Autowired
    private val service: BankService
) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElement(exception: NoSuchElementException) = ResponseEntity(exception.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(exception: IllegalArgumentException) = ResponseEntity(exception.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun getBanks() = service.getBanks()

    @GetMapping("{id}")
    fun getById(@PathVariable id: String) = service.getBank(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody bank: Bank) = service.addBank(bank)

    @PatchMapping
    fun updateBank(@RequestBody bank: Bank) = service.updateBank(bank)

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: String) = service.deleteBank(accountNumber = id)
}
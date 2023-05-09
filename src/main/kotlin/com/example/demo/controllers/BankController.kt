package com.example.demo.controllers

import com.example.demo.models.Bank
import com.example.demo.services.BankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(
    @Autowired
    private val service: BankService
) {

    @GetMapping
    fun getBanks() = service.getBanks()
}
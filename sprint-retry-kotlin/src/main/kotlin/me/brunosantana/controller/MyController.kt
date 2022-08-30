package me.brunosantana.controller

import me.brunosantana.service.RetryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController(
    private val retryService: RetryService
) {

    @GetMapping("retry")
    fun retry(): ResponseEntity<String>{
        retryService.retryServiceWithRecovery("select * from table")
        return ResponseEntity("OK", HttpStatus.OK)
    }

}
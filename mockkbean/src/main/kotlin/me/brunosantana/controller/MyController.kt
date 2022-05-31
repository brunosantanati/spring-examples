package me.brunosantana.controller

import me.brunosantana.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @Autowired
    private lateinit var greetingService: GreetingService

    @GetMapping("greet")
    fun greet(): ResponseEntity<String>{
        return ResponseEntity(greetingService.greet(), HttpStatus.OK)
    }

}
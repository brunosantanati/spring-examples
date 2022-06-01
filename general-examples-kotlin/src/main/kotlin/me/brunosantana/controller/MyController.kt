package me.brunosantana.controller

import me.brunosantana.model.Person
import me.brunosantana.service.LuckNumberGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @Autowired
    private lateinit var luckNumberGenerator: LuckNumberGenerator

    @PostMapping("luck")
    fun getPersonLuckNumber(@RequestBody person: Person): Person{
        return luckNumberGenerator.generateLuckNumber(person)
    }

}
package com.example.demo.controller

import com.example.demo.dto.PersonDTO
import com.example.demo.dto.ResponseDTO
import com.example.demo.http.client.PersonHttpClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(
        val personHttpClient: PersonHttpClient
) {

    @PostMapping("person")
    fun getPerson(@RequestBody personDTO: PersonDTO): ResponseEntity<ResponseDTO>{
        println(personDTO.name)
        println(personDTO.personType)
        println(personDTO.getPersonTypeCode())
        return ResponseEntity.ok(ResponseDTO(
                message = "${personDTO.name} - ${personDTO.personType} - ${personDTO.getPersonTypeCode()}",
                personType = personDTO.personType
        ))
    }

    @GetMapping("test-person")
    fun testPerson(){
        personHttpClient.testPersonEndpoint()
    }

}
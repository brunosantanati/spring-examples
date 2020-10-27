package com.example.demo.controller

import com.example.demo.dto.PersonDTO
import com.example.demo.dto.ResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    @PostMapping("person")
    fun getPerson(@RequestBody personDTO: PersonDTO): ResponseEntity<ResponseDTO>{
        println(personDTO.name)
        println(personDTO.personType)
        println(personDTO.getPersonTypeCode())
        return ResponseEntity.ok(ResponseDTO(
                "${personDTO.name} - ${personDTO.personType} - ${personDTO.getPersonTypeCode()}"
        ))
    }

}
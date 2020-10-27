package com.example.demo.dto

import com.example.demo.enums.PersonType

data class PersonDTO (
        val name: String,
        val personType: PersonType
){
    fun getPersonTypeCode() = when(personType){
            PersonType.PESSOA_FISICA -> "PF"
            PersonType.PESSOA_JURIDICA -> "PJ"
            else -> "Undefined"
        }
}
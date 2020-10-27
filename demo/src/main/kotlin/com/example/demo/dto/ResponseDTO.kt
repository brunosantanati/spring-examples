package com.example.demo.dto

import com.example.demo.enums.PersonType

data class ResponseDTO (
        val message: String,
        val personType: PersonType
)
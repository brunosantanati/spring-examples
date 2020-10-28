package com.example.demo.dto

import com.example.demo.enums.TypesOfPerson

data class OtherPersonDTO (
        val name: String,
        val personType: TypesOfPerson
)
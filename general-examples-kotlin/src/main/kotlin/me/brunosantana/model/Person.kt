package me.brunosantana.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Person (
    @JsonProperty("name")
    val name: String,
    @JsonProperty("luck_number")
    var luckNumber: Int
)
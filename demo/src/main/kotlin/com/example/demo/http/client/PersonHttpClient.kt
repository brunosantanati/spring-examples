package com.example.demo.http.client

import com.example.demo.dto.PersonDTO
import com.example.demo.dto.ResponseDTO
import com.example.demo.enums.PersonType
import com.google.gson.Gson
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service

@Service
class PersonHttpClient(
        val gson: Gson
){

    fun testPersonEndpoint(){

        val json = gson.toJson(PersonDTO("Bruno Sant Ana", PersonType.PESSOA_FISICA))
        println("json $json")

        khttp.post(
                url = "http://localhost:8080/person",
                headers = HttpHeaders().also {
                    it.contentType = MediaType.APPLICATION_JSON
                }.toSingleValueMap(),
                data = json
        ).let { response ->
            println("response ${response.text}")
            val obj = gson.fromJson(response.text, ResponseDTO::class.java)
            println("obj $obj")
            println("obj enum field ${obj.personType}")
        }
    }

}
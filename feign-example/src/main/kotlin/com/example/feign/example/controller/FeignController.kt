package com.example.feign.example.controller

import com.example.feign.example.BookControllerFeignClientBuilder
import com.example.feign.example.feign.BookClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

//Antes de rodar esse projeto rodar o projeto com a api: spring-hypermedia-api
//URL da api: http://localhost:8081/api/books
//URL desse projeto: http://localhost:8082/test-feign
//Exemplo baseado nesse link https://www.baeldung.com/intro-to-feign
//Código original do projeto no link https://github.com/eugenp/tutorials/tree/master/feign

@RestController
class FeignController {

    @GetMapping("test-feign")
    @ResponseBody
    fun testFeign(): String{
        val feignClientBuilder = BookControllerFeignClientBuilder()
        val bookClient = feignClientBuilder.bookClient
        val books = bookClient.findAll()
        var names: String = ""
        books?.map { names = "[${it?.book?.title}] $names" }
        return names
    }

}
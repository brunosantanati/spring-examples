package me.brunosantana.async.controller

import me.brunosantana.async.utils.AsyncComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @Autowired
    private lateinit var asyncComponent: AsyncComponent

    @GetMapping("async")
    fun testAsync(): ResponseEntity<String> {
        println(Thread.currentThread().name + " - Before")
        asyncComponent.asyncMethodWithVoidReturnType()
        for(num in 1..10){
            println(Thread.currentThread().name + " - " + num)
        }
        return ResponseEntity("OK", HttpStatus.OK)
    }

}
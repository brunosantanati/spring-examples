package me.brunosantana.async.controller

import me.brunosantana.async.utils.AsyncComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @Autowired
    private lateinit var asyncComponent: AsyncComponent

    @GetMapping("async")
    fun testAsync(): ResponseEntity<String> {
        println(Thread.currentThread().name + " - Before")
        asyncMethodWithVoidReturnType() //Self-invocation — calling the async method from within the same class — won't work.
        asyncComponent.asyncMethodWithVoidReturnType()
        for(num in 1..10){
            println(Thread.currentThread().name + " - " + num)
        }
        return ResponseEntity("OK", HttpStatus.OK)
    }

    /*
    This should not work and here is the explanation in the website: https://www.baeldung.com/spring-async#1-methods-with-void-return-type
    The same explanation below:

    First, let's go over the rules. @Async has two limitations:

    It must be applied to public methods only.
    Self-invocation — calling the async method from within the same class — won't work.

    The reasons are simple: The method needs to be public so that it can be proxied. And self-invocation doesn't work because it bypasses the proxy and calls the underlying method directly.
     */
    @Async
    fun asyncMethodWithVoidReturnType() {
        for(num in 1..10){
            println(Thread.currentThread().name + " - " + num + " - Fail executing asynchronously")
        }
    }

}
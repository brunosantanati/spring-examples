package me.brunosantana.service

import org.springframework.stereotype.Service

@Service
class GreetingService2 {

    fun greet(name: String): String{
        return "Hello $name!"
    }

}
package me.brunosantana.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AnotherGreetingService {

    @Autowired
    private lateinit var greetingService2: GreetingService2

    fun greet2(name: String): String{
        return greetingService2.greet(name)
    }

}
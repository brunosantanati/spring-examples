package me.brunosantana.async.utils

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class AsyncComponent {

    @Async
    fun asyncMethodWithVoidReturnType() {
        for(num in 1..10){
            println(Thread.currentThread().name + " - " + num + " - Execute method asynchronously")
        }
    }

}
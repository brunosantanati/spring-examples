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

    @Async
    fun asyncMethodThatThrowsException() {
        val numbers: IntArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(Thread.currentThread().name + " - " + numbers[0])
        println(numbers[10]) //force an exception
    }

}
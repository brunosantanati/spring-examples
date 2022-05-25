package me.brunosantana.async

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//Example based on this: https://www.baeldung.com/spring-async

@SpringBootApplication
class AsyncApplication

fun main(args: Array<String>) {
	runApplication<AsyncApplication>(*args)
}

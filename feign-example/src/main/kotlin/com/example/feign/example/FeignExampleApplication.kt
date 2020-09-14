package com.example.feign.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class FeignExampleApplication

fun main(args: Array<String>) {
	runApplication<FeignExampleApplication>(*args)
}

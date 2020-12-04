package com.example.feign.example

import feign.Logger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean

@EnableFeignClients(basePackages = ["com.example.feign.example"])
@SpringBootApplication
class FeignExampleApplication {

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<FeignExampleApplication>(*args)
		}

		@Bean
		fun feignLoggerLevel(): Logger.Level? {
			return Logger.Level.FULL
		}
	}

}

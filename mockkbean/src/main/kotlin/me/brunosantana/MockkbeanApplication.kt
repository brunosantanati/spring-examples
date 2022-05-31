package me.brunosantana

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["me.brunosantana"])
class MockkbeanApplication

fun main(args: Array<String>) {
	runApplication<MockkbeanApplication>(*args)
}

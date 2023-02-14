package me.brunosantana.general

import org.junit.jupiter.api.Test
import org.springframework.util.ResourceUtils

class GeneralTests {

    @Test
    fun `should read a JSON file and print it`() {
        val psalm139: String = ResourceUtils.getFile("classpath:json-files/psalm-139.json").readText()
        println(psalm139)
    }

}
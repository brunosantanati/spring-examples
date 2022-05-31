package me.brunosantana.controller

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import me.brunosantana.service.GreetingService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@WebMvcTest
class MyControllerTest {

    @MockkBean
    private lateinit var greetingService: GreetingService

    @Autowired
    private lateinit var controller: MyController

    @Test
    fun `should greet by delegating to the greeting service`(){
        every { greetingService.greet() } returns "Hi"

        Assertions.assertEquals("Hi", controller.greet().body)
        verify { greetingService.greet() }
    }

}
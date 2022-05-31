package me.brunosantana.controller

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import me.brunosantana.service.AnotherGreetingService
import me.brunosantana.service.GreetingService
import me.brunosantana.service.GreetingService2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@WebMvcTest
@Import(AnotherGreetingService::class)
class MyControllerTest {

    @MockkBean
    private lateinit var greetingService: GreetingService

    @MockkBean
    private lateinit var greetingService2: GreetingService2

    @Autowired
    private lateinit var controller: MyController

    @Test
    fun `should greet by delegating to the greeting service`(){
        every { greetingService.greet() } returns "Hi"

        Assertions.assertEquals("Hi", controller.greet().body)
        verify { greetingService.greet() }
    }

    @Test
    fun `should greet by delegating to the greeting service which uses another service`(){
        every { greetingService2.greet("Bruno") } returns "Hi Bruno!"

        Assertions.assertEquals("Hi Bruno!", controller.greet2("Bruno").body)
        verify { greetingService2.greet("Bruno") }
    }

}
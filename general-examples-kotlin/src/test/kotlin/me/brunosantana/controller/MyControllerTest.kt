package me.brunosantana.controller

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import me.brunosantana.model.Person
import me.brunosantana.service.LuckNumberGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MyControllerTest {

    @MockK
    private lateinit var luckNumberGenerator: LuckNumberGenerator

    @InjectMockKs
    private lateinit var myController: MyController

    @Test
    fun `make sure a expected person is being passed`() {
        every { luckNumberGenerator.generateLuckNumber(any()) } returns Person("Bruno", 10)

        val person = Person("Bruno", 0)

        myController.getPersonLuckNumber(person)

        verify { luckNumberGenerator.generateLuckNumber(person) }
    }

    @Test
    fun `make sure a expected person is being passed using objects with different reference`() {
        every { luckNumberGenerator.generateLuckNumber(any()) } returns Person("Bruno", 10)

        val person = Person("Bruno", 0)

        myController.getPersonLuckNumber(person)

        verify { luckNumberGenerator.generateLuckNumber(Person("Bruno", 0)) }
    }

    @Test
    fun `comparing using any`() {
        every { luckNumberGenerator.generateLuckNumber(any()) } returns Person("Bruno", 10)

        val person = Person("Bruno", 0)

        myController.getPersonLuckNumber(person)

        verify { luckNumberGenerator.generateLuckNumber(any()) }
    }

    @Test
    fun `fail when verifying a different person`() {
        every { luckNumberGenerator.generateLuckNumber(any()) } returns Person("Bruno", 10)

        val person = Person("Bruno", 0)

        myController.getPersonLuckNumber(person)

        verify { luckNumberGenerator.generateLuckNumber(Person("Bruno", 20)) }
    }

}
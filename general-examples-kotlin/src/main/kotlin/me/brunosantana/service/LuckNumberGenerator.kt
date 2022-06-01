package me.brunosantana.service

import me.brunosantana.model.Person
import org.springframework.stereotype.Service

@Service
class LuckNumberGenerator {

    fun generateLuckNumber(person: Person): Person{
        val luckNumber = (0..100).random()
        person.luckNumber = luckNumber
        return person
    }

}
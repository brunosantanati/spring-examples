package me.brunosantana.service

import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import java.sql.SQLException

@Service
class RetryService {

    @Retryable(value = [SQLException::class])
    fun retryServiceWithRecovery(sql: String) {
        println("\nexecuting...")
        val randomNumber = (0..1).random()
        if(randomNumber == 0) {
            throw SQLException("error in the select statement"); //only retry if the exception is a SQLException
        }
        print("OK")
    }

    @Recover
    fun recover(e: SQLException, sql: String){
        println("recovering... - ${e.message} - $sql")
    }

}
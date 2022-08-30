package me.brunosantana.service

import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import java.sql.SQLException

@Service
class RetryService {

    //@Retryable(value = [SQLException::class, RuntimeException::class], maxAttempts = 2, backoff = Backoff(delay = 5000))
    @Retryable(value = [SQLException::class, RuntimeException::class], maxAttemptsExpression = "\${retry.max.attempts}",
        backoff = Backoff(delayExpression = "\${retry.backoff}"))
    fun retryServiceWithRecovery(sql: String) {
        println("\nexecuting...")
        val randomNumber = (0..1).random()
        if(randomNumber == 0) {
            throw SQLException("error in the select statement"); //only retry if the exception is a SQLException
        }
        if(randomNumber == 1) {
            throw RuntimeException("problem with the select statement"); //only retry if the exception is a SQLException
        }
        print("OK")
    }

    @Recover
    fun recover(e: Exception, sql: String){
        println("recovering... - ${e.message} - $sql")
    }

}
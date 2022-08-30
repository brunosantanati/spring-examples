package me.brunosantana.service

import me.brunosantana.repository.UserRepository
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import java.sql.SQLException

@Service
class RetryService {

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

    @Retryable(value = [IllegalStateException::class], maxAttempts = 3, backoff = Backoff(delay = 3000)) //it works
    //@Retryable(value = [IllegalCallerException::class], maxAttempts = 3, backoff = Backoff(delay = 3000)) //it works
    //@Retryable(value = [IllegalArgumentException::class], maxAttempts = 3, backoff = Backoff(delay = 3000)) //it works
    //@Retryable(value = [ArithmeticException::class], maxAttempts = 3, backoff = Backoff(delay = 3000)) //it only executes once but executes @Recover
    fun retrying(){
        println("\nperforming...")
        UserRepository().saveUser()
        println("End")
    }

    @Recover
    fun recovering(e: Exception){
        println("recovering.... - ${e.message}")
        //e.printStackTrace()
    }

}
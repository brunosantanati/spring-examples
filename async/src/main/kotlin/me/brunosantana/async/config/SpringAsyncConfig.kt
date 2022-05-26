package me.brunosantana.async.config

import me.brunosantana.async.exception.CustomAsyncExceptionHandler
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import java.util.concurrent.Executor


@Configuration
@EnableAsync
class SpringAsyncConfig : AsyncConfigurer {

    override fun getAsyncExecutor(): Executor? {
        return SimpleAsyncTaskExecutor()
    }
    override fun getAsyncUncaughtExceptionHandler(): AsyncUncaughtExceptionHandler? {
        return CustomAsyncExceptionHandler()
    }
}
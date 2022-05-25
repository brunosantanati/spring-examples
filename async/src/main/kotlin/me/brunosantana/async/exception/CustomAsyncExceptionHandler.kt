package me.brunosantana.async.exception

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import java.lang.reflect.Method

class CustomAsyncExceptionHandler : AsyncUncaughtExceptionHandler {
  override fun handleUncaughtException(
    throwable: Throwable, method: Method, vararg obj: Any
  ) {
    println("Exception message - " + throwable.message)
    System.out.println("Method name - " + method.getName())
    for (param in obj) {
      println("Parameter value - $param")
    }
  }
}
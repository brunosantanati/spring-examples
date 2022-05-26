package me.brunosantana.async.exception

import me.brunosantana.async.model.Data
import me.brunosantana.async.model.Data2
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import java.lang.reflect.Method

class CustomAsyncExceptionHandler : AsyncUncaughtExceptionHandler {
  override fun handleUncaughtException(
    throwable: Throwable, method: Method, vararg obj: Any
  ) {
    println(Thread.currentThread().name)
    println("Exception message - " + throwable.message)
    println("Method name - " + method.name)
    for (param in obj) {
      if(param is Data2) {
        println("Parameter value - Data2 " + param.getName() + " " + param.list) //print fields / info manually
      }else if(param is Data){
        println("Parameter value - Data(3) " + param.getName()) //print fields / info manually
      }else {
        println("Parameter value - $param") //data classes has a toString and prints the whole object
      }
    }
  }
}
package me.brunosantana.service

import me.brunosantana.worker.Worker
import org.springframework.stereotype.Service

@Service
class MapInjectionService(
    private val workers: Map<String, Worker>
) {

    fun execute(){
        workers.forEach { (key, value) ->
            println(key)
            println(value)
            value.run()
        }
    }

}
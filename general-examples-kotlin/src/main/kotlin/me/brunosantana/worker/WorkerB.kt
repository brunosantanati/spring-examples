package me.brunosantana.worker

import org.springframework.stereotype.Component

@Component("WORKER_B")
class WorkerB : Worker {

    override fun run(): Boolean {
        println("Worker B executing....")
        return true
    }

}
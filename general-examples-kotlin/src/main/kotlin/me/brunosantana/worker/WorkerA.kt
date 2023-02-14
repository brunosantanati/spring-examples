package me.brunosantana.worker

import org.springframework.stereotype.Component

@Component("WORKER_A")
class WorkerA : Worker {

    override fun run(): Boolean {
        println("Worker A executing...")
        return true
    }

}
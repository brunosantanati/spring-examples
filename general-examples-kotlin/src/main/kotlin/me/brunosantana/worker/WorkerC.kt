package me.brunosantana.worker

import org.springframework.stereotype.Component

@Component("WORKER_C")
class WorkerC : Worker {

    override fun run(): Boolean {
        println("Worker C executing.....")
        return true
    }

}
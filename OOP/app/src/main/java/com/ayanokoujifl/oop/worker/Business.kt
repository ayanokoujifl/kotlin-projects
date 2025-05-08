package com.ayanokoujifl.oop.worker

class Business(worker: Worker) : Worker by worker {
    val message: String by lazy {
        println("Initialization...")
        "Hello, world!"
    }

    fun printMSg() {
        println(message)
    }
}
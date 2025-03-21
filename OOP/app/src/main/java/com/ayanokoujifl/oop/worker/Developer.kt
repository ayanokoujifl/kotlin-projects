package com.ayanokoujifl.oop.worker

class Developer(val name: String) : Worker {
    override fun work() {
        println("${this.name} Drawing solutions...")
    }
}
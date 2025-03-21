package com.ayanokoujifl.oop.smartdevice

open class SmartDevice {
    var name: String = ""
    var category: String = ""
    var deviceStatus: String = "offline"

    constructor()

    constructor(name: String, category: String, deviceStatus: String = "offline") {
        this.name = name
        this.category = category
        this.deviceStatus = deviceStatus
    }
}
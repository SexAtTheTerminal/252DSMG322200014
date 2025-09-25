package com.example.kotlin_conditionals

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Clase reguladora de rangos
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

// Clase SmartDevice
class SmartDevice(val name: String, val category: String) {

    private var deviceStatus = "online"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }

    // 🔹 NUEVO MÉTODO: imprimir información del dispositivo
    fun printDeviceInfo() {
        val deviceType = "unknown"
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// Clase padre
open class SmartDevice_Father(val name: String, val category: String) {

    var deviceStatus = "off"
        protected set

    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "off"
            1 -> "on"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = "on"
        println("Smart device is turned on.")
    }

    open fun turnOff() {
        deviceStatus = "off"
        println("Smart device is turned off.")
    }
}

// Clase SmartTvDevice
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice_Father(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        if (deviceStatus == "on") {
            speakerVolume++
            println("Speaker volume increased to $speakerVolume.")
        }
    }

    // 🔹 NUEVO MÉTODO: disminuir volumen
    fun decreaseVolume() {
        if (deviceStatus == "on") {
            speakerVolume--
            println("Speaker volume decreased to $speakerVolume.")
        }
    }

    fun nextChannel() {
        if (deviceStatus == "on") {
            channelNumber++
            println("Channel number increased to $channelNumber.")
        }
    }

    // 🔹 NUEVO MÉTODO: canal anterior
    fun previousChannel() {
        if (deviceStatus == "on") {
            channelNumber--
            println("Channel number decreased to $channelNumber.")
        }
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    // 🔹 NUEVO MÉTODO: imprimir información
    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// Clase SmartLightDevice
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice_Father(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        if (deviceStatus == "on") {
            brightnessLevel++
            println("Brightness increased to $brightnessLevel.")
        }
    }

    // 🔹 NUEVO MÉTODO: disminuir brillo
    fun decreaseBrightness() {
        if (deviceStatus == "on") {
            brightnessLevel--
            println("Brightness decreased to $brightnessLevel.")
        }
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }

    // 🔹 NUEVO MÉTODO: imprimir información
    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

// Clase SmartHome
class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        if (smartTvDevice.deviceStatus != "on") {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
    }

    fun turnOffTv() {
        if (smartTvDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun decreaseTvVolume() {
        smartTvDevice.decreaseVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }

    fun turnOnLight() {
        if (smartLightDevice.deviceStatus != "on") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }

    fun turnOffLight() {
        if (smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

// Función principal
fun main() {
    val tv = SmartTvDevice("Android TV", "Entertainment")
    val light = SmartLightDevice("Google Light", "Utility")
    val home = SmartHome(tv, light)

    home.turnOnTv()
    home.increaseTvVolume()
    home.decreaseTvVolume()
    home.changeTvChannelToNext()
    home.changeTvChannelToPrevious()
    home.printSmartTvInfo()

    home.turnOnLight()
    home.increaseLightBrightness()
    home.decreaseLightBrightness()
    home.printSmartLightInfo()

    println("Devices currently on: ${home.deviceTurnOnCount}")

    home.turnOffAllDevices()
    println("Devices currently on: ${home.deviceTurnOnCount}")
}

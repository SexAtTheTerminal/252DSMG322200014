package com.example.connecttointernet

import kotlinx.coroutines.*
import kotlin.system.*

fun main4() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}

//Forma estructurada
suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}

//Manejo de Excepciones
fun main2() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}

suspend fun getWeatherReport2() = coroutineScope {
    val forecast = async { getForecast2() }
    val temperature = async {
        try {
            getTemperature2()
        } catch (e: AssertionError) {
            println("Caught exception $e")
            "{ No temperature found }"
        }
    }

    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast2(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature2(): String {
    delay(500)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}

//Cancelacion de Corrutina

fun main3() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport3())
        println("Have a good day!")
    }
}

suspend fun getWeatherReport3() = coroutineScope {
    val forecast = async { getForecast3() }
    val temperature = async { getTemperature3() }
    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast3(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature3(): String {
    delay(1000)
    return "30\u00b0C"
}

//Dispatchers
fun main() {
    runBlocking {
        println("${Thread.currentThread().name} - runBlocking function")
                launch {
            println("${Thread.currentThread().name} - launch function")
            withContext(Dispatchers.Default) {
                println("${Thread.currentThread().name} - withContext function")
                delay(1000)
                println("10 results found.")
            }
            println("${Thread.currentThread().name} - end of launch function")
        }
        println("Loading...")
    }
}
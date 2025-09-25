package com.example.kotlin_conditionals

fun main()
{
    condiciones_signos()
}

fun condiciones_signos(){
    traffic_light()
    traffic_light2()
    when_conditional()
    combination()
}

fun traffic_light(){
    val trafficLightColor = "Red"

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Orange"){
        println("Slow down and Stop")
    } else if (trafficLightColor == "Green"){
        println("Pass")
    } else{
        println("El semáforo está malogrado x.x")
    }
}

fun when_conditional(){
    val x: Any = 4

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        is Int -> println("x is an integer number, but not between 1 and 10.")
        else -> println("x isn't an integer number.")
    }
}

fun traffic_light2(){
    val trafficLightColor = "Orange"

    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow", "Orange" -> println("Slow down and Stop")
        "Green" -> println("Pass")
        else -> println("El semáforo está malogrado x.x")
    }
}

fun combination(){
    val trafficLightColor = "Black"

    val message = when(trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Orange" -> "Slow down and Stop"
        "Green" -> "Pass"
        else -> "El semáforo está malogrado x.x"
    }
    println(message)
}
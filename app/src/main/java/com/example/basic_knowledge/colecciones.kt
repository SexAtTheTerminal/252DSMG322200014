package com.example.basic_knowledge

fun main(){
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = rockPlanets + gasPlanets

    val solarSystem2 = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println(solarSystem.indexOf("Pluto")) //Retorna -1

    for (planet in solarSystem) {
        println(planet)
    }

    val solarSystem3 = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    solarSystem3.add("Pluto")
    solarSystem3.add(3, "Theia")

    solarSystem3.removeAt(9)

    println(solarSystem3.contains("Pluto"))

    println("Future Moon" in solarSystem3)
}
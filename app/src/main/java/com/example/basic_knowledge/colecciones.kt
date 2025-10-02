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


    //-------------------- Hash Code Set----------------------------------
    val solarSystem4 = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    solarSystem4.add("Pluto") //No pueden haber duplicados

    println(solarSystem4.size)

    println(solarSystem.contains("Pluto"))

    "Pluto" in solarSystem4

    solarSystem4.remove("Pluto")

    //-------------------- MAPAS ----------------------------------

    val solarSystem5 = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystem5.size)

    solarSystem5["Pluto"] = 5

    println(solarSystem5.size)

    println(solarSystem5["Pluto"])

    println(solarSystem5.get("Theia"))

    solarSystem5["Jupiter"] = 78 //Permite actualizar valores mediante el subindice key-value
    println(solarSystem5["Jupiter"])

}
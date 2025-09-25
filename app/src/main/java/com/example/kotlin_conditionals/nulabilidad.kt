package com.example.kotlin_conditionals

fun main()
{
    null_variable()
    safe_call_operator()
    non_null_asertion()
    elvis_operator()
}

fun null_variable(){

    var number: Int? = 10
    println(number)

    number = null
    println(number)

}

fun safe_call_operator() {
    var favoriteActor: String? = null
    println(favoriteActor?.length)
}

fun non_null_asertion(){
    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor!!.length)
}

fun elvis_operator() {
    var favoriteActor: String? = "Sandra Oh"

    favoriteActor = null

    val lengthOfName = favoriteActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}
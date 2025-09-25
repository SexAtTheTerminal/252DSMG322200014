package com.example.kotlin_conditionals

fun main() {
    val trickFunction_try = trick2

    val coins: (Int) -> String = {
        "$it quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)
    trick1()
    trickFunction_try()

    treatFunction()
    trickFunction()

    val treatFunction2 = trickOrTreat2(false, coins)
    val trickFunction2 = trickOrTreat2(true, cupcake)

    treatFunction2()
    trickFunction2()

    val treatFunction3 = trickOrTreat2(false, {"$it quarters"})
    val trickFunction3 = trickOrTreat2(true,  {""})

    treatFunction3()
    trickFunction3()

    repeat(4){
        treatFunction3() // Orden Superior... interesante
    }
    trickFunction3()
}

fun trick1() {
    println("No treats!")
}

val trick2 = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trick2
    } else {
        return treat
    }
}

fun trickOrTreat2(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if (isTrick) {
        return trick2
    } else {
        println(extraTreat(5))
        return treat
    }
}
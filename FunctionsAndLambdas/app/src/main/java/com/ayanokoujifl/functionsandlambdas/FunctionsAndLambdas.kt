package com.ayanokoujifl.functionsandlambdas

fun main() {
    //variable receives function
    // ::name-function / operator "::" represents a function without call - val x = ::function

//    val coins: (Int) -> String = { quantity ->
//        "$quantity quarters"
//    }

    val coins: (Int) -> String = {
        "$it quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake"
    }

    val trickFunction = trickOrTreat(true, null)
    //val treatFunction = trickOrTreat(false, coins)
    //val treatFunction = trickOrTreat(false, { "$it quarters" })
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    repeat(4) { i -> treatFunction() }
}

//function with explicit return type
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) return trick
    else {
        if (extraTreat != null) println(extraTreat(5))
        return treats
    }
}

//lambda
val trick = {
    println("No treats!")
}

val treats = {
    println("Have treats!")
}

//lambda is val name = { function body }
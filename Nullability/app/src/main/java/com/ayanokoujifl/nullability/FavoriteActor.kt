package com.ayanokoujifl.nullability

fun main() {
    var favoriteActor: String? = "Robert Downey Jr."
    println(favoriteActor ?: "Nao tem ator favorito")
}

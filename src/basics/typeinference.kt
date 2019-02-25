package basics

fun main() {
    // El tipo de dato es opcional
    var aString = "Kotlin"
    var aInt = 1
    var aLong = 1L
    var aBoolean = true

    // Indicando explicitamente el tipo de dato
    val explicitType: Number = 12.3
}

// Type inferece en una funcion de una sola linea
fun plusOne(x: Int) = x + 1
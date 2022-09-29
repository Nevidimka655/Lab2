package examples

import kotlin.Exception

fun main(args: Array<String>) {
    try {
        println(0)
        throw RuntimeException("Неперевірена помилка") // кидаємо виключення
        println(1)
    } catch (e: Exception) { // виняток перехоплено
        println("2$e") // виняток опрацьовано
    }
    println(3)
}
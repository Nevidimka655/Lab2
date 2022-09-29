package examples

import kotlin.Exception

fun main(args: Array<String>) {
    try {
        println(0)
        throw RuntimeException("Неперевірена помилка") // кидаємо виключення
    } catch (e: Exception) { // виняток перехоплено
        println("1$e") // виняток опрацьовано
    }
    println(2)
}
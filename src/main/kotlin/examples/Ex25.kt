package examples

fun main(args: Array<String>) {
    try {
        println(0)
        throw RuntimeException("Помилка") // кидаємо виключення
    } catch (e: NullPointerException) { // виняток перехоплено
        println(1) // виняток опрацьовано
    }
    println(2)
}
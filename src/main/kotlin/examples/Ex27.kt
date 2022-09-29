package examples

fun main(args: Array<String>) {
    try {
        try {
            println(0)
            throw NullPointerException("Помилка") // кидаємо виключення
        } catch (e: NullPointerException) { // виняток перехоплено
            println(1) // виняток опрацьовано
        }
        throw ArithmeticException()
    } catch (e: ArithmeticException) {
        println(2)
    }
    println(3)
}
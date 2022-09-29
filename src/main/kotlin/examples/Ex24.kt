package examples

fun main(args: Array<String>) {
    try {
        println(0)
        throw RuntimeException("Помилка") // кидаємо виключення
    } catch (e: NullPointerException) { // виняток перехоплено
        println(1) // виняток опрацьовано
    } catch (e: RuntimeException) { // виняток перехоплено
        println(2) // виняток опрацьовано
    } catch (e: Error) { // виняток перехоплено
        println(3) // виняток опрацьовано
    }
    println(4)
}
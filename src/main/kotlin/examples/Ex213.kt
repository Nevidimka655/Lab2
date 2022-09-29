package examples

fun main(args: Array<String>) {
    try {
        val l = args.size
        println("Array size: $l")
        val h = 10 / l
        args[l+1] = "10"
        println(0)
    } catch (e: ArithmeticException) { // виняток перехоплено
        println("Divide by zero") // виняток опрацьовано
    } finally { // виняток перехоплено
        println("Index not found") // виняток опрацьовано
    }
}
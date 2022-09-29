package examples

fun m214(x: Int) = 10 / x

fun main(args: Array<String>) {
    try {
        val l = args.size
        println("Array size: $l")
        m214(0)
    } catch (e: ArithmeticException) { // виняток перехоплено
        println("Divide by zero") // виняток опрацьовано
    }
}
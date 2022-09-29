package examples

fun m29() = try {
    println(0)
    55 // вихід з методу
} finally {
    println(1)
}

fun main(args: Array<String>) {
    println(m29())
}
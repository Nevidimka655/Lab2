package examples

fun m210() = try {
    println(0)
    15 // вихід з методу
} finally {
    println(1)
    20
}

fun main(args: Array<String>) {
    println(m210())
}
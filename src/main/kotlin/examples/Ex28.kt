package examples

fun m28() {
    try {
        println(0)
        throw RuntimeException()
    } finally {
        println(1)
    }
}

fun main(args: Array<String>) {
    println(m28())
}
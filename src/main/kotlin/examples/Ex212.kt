package examples

fun m212(str: String?, num: Double) {
    str ?: throw IllegalArgumentException("Рядок введено неправильно")
    if (num > 0.001) throw IllegalArgumentException("Неправильнe число")
}

fun main(args: Array<String>) {
    println(m212(null, 0.000001))
}
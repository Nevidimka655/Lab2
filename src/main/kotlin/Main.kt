import kotlin.system.exitProcess

typealias Row = Array<Double>

private var _size: Int? = null
private val size get() = _size!!

private var _rows: Array<Row?>? = null
private val rows get() = _rows!!

fun main(args: Array<String>): Unit = exceptionParser {
    _size ?: queryMatrixSize()
    _rows ?: setupRowArray()
    for (i in 0 until size) {
        val currentRow = rows[i]
        currentRow ?: run { rows[i] = queryMatrixRow(i) }
    }
    printMatrix()
    val pair = findPair()
    println("Pair [$pair; $pair] found")
    exitProcess(0)
}

fun queryMatrixSize() {
    println("Input matrix size (YxY):")
    val size = readlnOrNull()!!.toInt()
    if (size <= 0) throw NumberFormatException("Size must be greater than zero")
    else _size = size
}

fun queryMatrixRow(index: Int) = run {
    println("Input row #${index + 1}. Size is $size. Separate values by comma")
    var newRowArray = arrayOf<Double>()
    val formattedArray = readlnOrNull()!!.split(",")
    if (formattedArray.size != size) throw NumberFormatException("Wrong numbers count")
    formattedArray.forEach {
        val value = it.trim().toDouble()
        newRowArray = newRowArray.plus(value)
    }
    newRowArray
}

fun findPair() = run {
    val values = arrayListOf<Double>()
    var lastPair: Double? = null
    rows.forEachIndexed { i, row ->
        val currentValue = row!![size - i - 1]
        if (values.contains(currentValue)) {
            lastPair = if (lastPair == null) currentValue
            else {
                if (currentValue > lastPair!!) currentValue
                else lastPair
            }
        } else values.add(currentValue)
    }
    lastPair ?: run {
        _size = null
        _rows = null
        throw ArithmeticException()
    }
}

fun printMatrix() {
    println("MATRIX ${size}X$size:")
    rows.forEach { row ->
        row!!.forEach { print("[$it]\t") }
        println()
    }
}

fun setupRowArray() = run { _rows = arrayOfNulls(size) }

fun exceptionParser(block: () -> Unit) = try {
    block.invoke()
} catch (e: NullPointerException) {
    println("Value is null")
} catch (e: NumberFormatException) {
    println("Unable to convert input data to a num. ${e.message}")
} catch (e: ArithmeticException) {
    println("Unable to find pair")
    exitProcess(0)
} catch (e: Exception) {
    println("E: ${e.message}")
} finally {
    println("Press 'Enter' to continue...")
    readLine()
    main(arrayOf())
}
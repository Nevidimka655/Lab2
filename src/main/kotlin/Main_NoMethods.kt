import kotlin.system.exitProcess

object Main_NoMethods {
    private var _size: Int? = null
    private val size get() = _size!!

    private var _rows: Array<Row?>? = null
    private val rows get() = _rows!!

    fun main(args: Array<String>) {
        try {
            _size ?: run {
                println("Input matrix size (YxY):")
                val size = readln().toInt()
                if (size <= 0) throw NumberFormatException("Size must be greater than zero")
                else _size = size
            }
            _rows ?: run { _rows = arrayOfNulls(size) }
            for (i in 0 until size) {
                val currentRow = rows[i]
                currentRow ?: run {
                    rows[i] = run {
                        println("Input row #${i + 1}. Size is $size. Separate values by comma")
                        var newRowArray = arrayOf<Double>()
                        val formattedArray = readln().split(",")
                        if (formattedArray.size != size) throw NumberFormatException("Wrong numbers count")
                        formattedArray.forEach {
                            val value = it.trim().toDouble()
                            newRowArray = newRowArray.plus(value)
                        }
                        newRowArray
                    }
                }
            }
            println("MATRIX ${size}X$size:")
            rows.forEach { row ->
                row!!.forEach { print("[$it]\t") }
                println()
            }
            val pair = run {
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
            println("Pair [$pair; $pair] found")
            exitProcess(0)
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
            main(args)
        }
    }


}
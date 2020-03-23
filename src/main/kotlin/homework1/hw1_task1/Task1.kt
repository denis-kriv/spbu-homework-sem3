package homework1.hw1_task1
import java.lang.NumberFormatException
import java.util.*

fun listReverse(startIndexes: Int, endIndexes: Int, inputList: MutableList<Int>?) {
    if (inputList.isNullOrEmpty() || startIndexes + endIndexes != inputList.size) {
        throw Exception()
    }
    inputList.subList(0, startIndexes).reverse()
    inputList.subList(startIndexes, inputList.size).reverse()
    inputList.reverse()
}
fun main() {
    val scan = Scanner(System.`in`)
    println("Введите длину начала и длину конца")
    val startIndexes = scan.nextInt()
    val endIndexes = scan.nextInt()
    println("Введите ${startIndexes + endIndexes} элементов массива")
    val inputList: MutableList<Int>?
    try {
        inputList = (readLine()?.split(" ")?.map { it.toInt() })?.toMutableList()
    } catch (e: NumberFormatException) {
        println("В массиве нет элементов")
        return
    }
    try {
        listReverse(startIndexes, endIndexes, inputList)
    } catch (e: Exception) {
        print("Введены некорректные данные")
        return
    }
    println("Полученный массив:")
    inputList?.forEach() { print("$it ") }
}
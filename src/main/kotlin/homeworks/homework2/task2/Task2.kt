package homeworks.homework2.task2

import java.util.Scanner

inline fun <reified T> deleteRepeatElements(mutableArray: Array<T>): Array<T> {
    val mapOfUniqueElements = mutableMapOf<Int, T>()
    mutableArray.reverse()
    var index = 0
    mutableArray.forEach {
        if (!mapOfUniqueElements.containsValue(it)) {
            mapOfUniqueElements += index to it
            index++
        }
    }
    return (Array<T>(mapOfUniqueElements.size) { mapOfUniqueElements.getValue(it) }).reversedArray()
}

fun main() {
    val scan = Scanner(System.`in`)
    println("Введите массив")
    val inputArray = scan.nextLine().split(" ").toTypedArray()
    val resultArray = deleteRepeatElements(inputArray)
    println("Полученный массив:")
    resultArray.forEach {
        print("$it ")
    }
}

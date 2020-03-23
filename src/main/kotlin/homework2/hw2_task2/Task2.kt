package homework2.hw2_task2
import java.util.*

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
    println("Введите массив")               //Реализация на примере массива слов
    val inputArray = scan.nextLine().split(" ").toTypedArray()
    val resultArray = deleteRepeatElements(inputArray)
    println("Полученный массив:")
    resultArray.forEach {
        print("$it ")
    }
}

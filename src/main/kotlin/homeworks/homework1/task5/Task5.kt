package homeworks.homework1.task5

import java.util.Scanner
import java.io.File

fun countOfStrings(filePath: String): Int {
    val listOfFileStrings = File(filePath).useLines { it.toList() }
    var result = 0
    listOfFileStrings.forEach {
        if (!it.isNullOrBlank()) {
            result++
        }
    }
    return result
}

fun main() {
    val scan = Scanner(System.`in`)
    println("Введите путь к файлу")
    val filePath = scan.nextLine()
    println("Количество непустых строк: ${countOfStrings(filePath)}")
}

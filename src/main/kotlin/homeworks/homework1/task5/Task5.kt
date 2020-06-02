package homeworks.homework1.task5

import java.io.File

fun countOfStrings(filePath: String): Int {
    val listOfFileStrings = File(filePath).useLines { it.toList() }
    return listOfFileStrings.count { it.isNotBlank() }
}

fun main() {
    println("Введите путь к файлу")
    val filePath = readLine()
    if (filePath.isNullOrEmpty()) println("Строка ввода пуста")
    else println("Количество непустых строк: ${countOfStrings(filePath)}")
}

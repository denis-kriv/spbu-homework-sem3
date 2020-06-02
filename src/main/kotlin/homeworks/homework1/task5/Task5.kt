package homeworks.homework1.task5

import java.io.File
import java.io.FileNotFoundException

fun countOfStrings(filePath: String): Int {
    var reader = File(filePath).reader()
    val listOfFileStrings = reader.useLines { it.toList() }
    return listOfFileStrings.count { it.isNotBlank() }
}

fun main() {
    try {
        println("Введите путь к файлу")
        val filePath = readLine()
        if (filePath.isNullOrEmpty()) println("Строка ввода пуста")
        else println("Количество непустых строк: ${countOfStrings(filePath)}")
    } catch (e: FileNotFoundException) {
        println("Файл не найден")
    }
}

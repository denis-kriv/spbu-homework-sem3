package homework1.task3

import java.util.Scanner

fun countOfSubstrings(firstString: String, secondString: String): Int {
    if (firstString.length < secondString.length) {
        return 0
    }
    if (firstString.length == secondString.length) {
        if (firstString == secondString) {
            return 1
        }
        return 0
    }
    if (firstString.length > secondString.length) {
        var result = 0
        for (i in 0..firstString.length - secondString.length) {
            if (firstString.substring(i, i + secondString.length) == secondString) result++
        }
        return result
    }
    return 0
}

fun main() {
    val scan = Scanner(System.`in`)
    println("Введите первую строку")
    val firstInputString = scan.nextLine()
    println("Введите вторую строку")
    val secondInputString = scan.nextLine()
    println("Количество вхождений второй строки в первую: ${countOfSubstrings(firstInputString, secondInputString)}")
}

package homework1.task3

import java.util.Scanner

fun countOfSubstrings(firstString: String, secondString: String): Int {
    var result = 0
    if (firstString.length < secondString.length) result = 0
    if (firstString.length == secondString.length) {
        if (firstString == secondString) result = 1
    }
    if (firstString.length > secondString.length) {
        for (i in 0..firstString.length - secondString.length) {
            if (firstString.substring(i, i + secondString.length) == secondString) result++
        }
    }
    return result
}

fun main() {
    val scan = Scanner(System.`in`)
    println("Введите первую строку")
    val firstInputString = scan.nextLine()
    println("Введите вторую строку")
    val secondInputString = scan.nextLine()
    println("Количество вхождений второй строки в первую: ${countOfSubstrings(firstInputString, secondInputString)}")
}

package homewroks.homework1.task4

import java.util.Scanner

fun isPolyndrom(checkedString: String): Boolean {
    return checkedString == checkedString.reversed()
}

fun main() {
    val scan = Scanner(System.`in`)
    println("Введите строку")
    val inputString = scan.nextLine()
    if (isPolyndrom(inputString)) {
        print("Строка является полиндромом")
    } else {
        print("Строка не полиндром")
    }
}

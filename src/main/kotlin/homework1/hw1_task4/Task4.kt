package homework1.hw1_task4
import java.util.*

fun isPolyndrom(checkedString: String): Boolean {
    if (checkedString == checkedString.reversed()) return true
    return false
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
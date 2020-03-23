package homework1.hw1_task2
import java.util.*

fun factorial(n: Int): Int {
    if (n < 0) throw Exception()
    var result = 1
    for (i in 1..n) {
        result *= i
    }
    return result
}

fun recursionFactorial(n: Int): Int {
    if (n < 0) throw Exception()
    if (n == 1 || n == 0) return 1
    return n * recursionFactorial(n - 1)
}

fun main() {
    val scan = Scanner(System.`in`)
    println("Введите число")
    val digit = scan.nextInt()
    try {
        println("Итеративный факториал введенного числа: ${factorial(digit)}")
        println("Рекурсивный факториал введенного числа:  ${recursionFactorial(digit)}")
    } catch (e: Exception) {
        print("Введено отрицательное число")
    }
}
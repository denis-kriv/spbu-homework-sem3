package homeworks.homework1.task2

import java.util.Scanner

fun iterativeFactorial(n: Int): Int {
    if (n < 0) throw ArithmeticException("Введено отрицательное число")
    var result = 1
    for (i in 1..n) {
        result *= i
    }
    return result
}

fun recursionFactorial(n: Int): Int {
    if (n < 0) throw ArithmeticException("Введено отрицательное число")
    if (n == 1 || n == 0) return 1
    return n * recursionFactorial(n - 1)
}

fun main() {
    val scan = Scanner(System.`in`)
    println("Введите число")
    val digit = scan.nextInt()
    try {
        println("Итеративный факториал введенного числа: ${iterativeFactorial(digit)}")
        println("Рекурсивный факториал введенного числа:  ${recursionFactorial(digit)}")
    } catch (e: ArithmeticException) {
        print(e.message)
    }
}

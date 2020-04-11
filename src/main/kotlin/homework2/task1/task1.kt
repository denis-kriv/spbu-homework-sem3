package homework2.task1

import java.util.Scanner

fun stringWithoutSubStr(startString: String): Int {
    var isCannotAdd = false
    //Считаем сколько 'x' идут подряд
    var quantityOfSymbols = 0
    var result = 0
    for (i in startString) {
        if (quantityOfSymbols == 2) isCannotAdd = true
        if (i == 'x' && !isCannotAdd) quantityOfSymbols++
        if (i == 'x' && isCannotAdd) result++
        if (i != 'x') {
            quantityOfSymbols = 0
            isCannotAdd = false
        }
    }
    return result
}

fun main() {
    val scan = Scanner(System.`in`)
    println("Введите исходную строку")
    var inputString = scan.nextLine()
    println("Количество симоволов, которые нужно удалить")
    println(stringWithoutSubStr(inputString))
}

package homework2.hw1_task1
import java.util.*

fun stringWithoutSubStr(startString: String): Int {
    var isCannotAdd = false
    var quantityOfSymbols = 0 //Считаем сколько 'x' идут подряд
    var result = 0
    for (i in startString) {
        if (quantityOfSymbols == 2) isCannotAdd = true
        if (i == 'x' && !isCannotAdd) {
            quantityOfSymbols++
            continue
        }
        if (i == 'x' && isCannotAdd) {
            result++
            continue
        }
        if (i != 'x') {
            quantityOfSymbols = 0
            isCannotAdd = false
            continue
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
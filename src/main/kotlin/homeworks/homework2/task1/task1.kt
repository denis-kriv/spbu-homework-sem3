package homeworks.homework2.task1

fun stringWithoutSubStr(startString: String): Int {
    var result = 0
    for (i in 0 until startString.length - 2) {
        if (startString[i] == 'x' && startString[i + 1] == 'x' && startString[i + 2] == 'x') result++
    }
    return result
}

fun main() {
    println("Введите исходную строку")
    val inputString = readLine()
    if (inputString.isNullOrEmpty()) print("Введена пустая строка")
    else {
        println("Количество симоволов, которые нужно удалить")
        println(stringWithoutSubStr(inputString))
    }
}

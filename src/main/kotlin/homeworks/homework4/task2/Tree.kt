package homeworks.homework4.task2

import homeworks.homework4.task2.models.Operand
import homeworks.homework4.task2.models.Operator
import homeworks.homework4.task2.models.Operators
import homeworks.homework4.task2.models.interfaces.TreeItem
import java.io.File

private fun leftRight(input: List<String>): Pair<List<String>, List<String>> {
    var balance = 0

    for ((index, it) in input.withIndex()) {
        if (it == "(") balance--
        if (it == ")") balance++
        if (balance == 0) return Pair(input.subList(0, index + 1), input.subList(index + 1, input.lastIndex + 1))
    }

    throw IllegalArgumentException("String is not correct.")
}

private fun fillTree(input: List<String>): TreeItem {
    if (input[0].toIntOrNull() != null) return Operand(input[0].toInt())

    val children = leftRight(input.subList(2, input.lastIndex))

    Operators.values().forEach {
        if (it.value == input[1]) return Operator(it, fillTree(children.first), fillTree(children.second))
    }

    throw IllegalArgumentException("String is not correct.")
}

private fun read(path: String?): List<String> {
    if (path.isNullOrBlank()) throw KotlinNullPointerException("String is empty.")

    val file = File(path)
    if (!file.exists()) throw NoSuchFileException(file, null, "File does not exist.")

    val input = StringBuilder(file.readText())
    var index = 0

    while(true) {
        if (input[index] == '(') {
            input.insert(index + 1, " ")
            index++
        }

        if (input[index] == ')') {
            input.insert(index, " ")
            index++
        }

        index++

        if (input.length <= index) break
    }

    return input.split(" ")
}

class Tree(path: String?) {

    private val head: TreeItem = fillTree(read(path))

    fun print() {
        println(head)
    }

    fun printResult() {
        print(head.toInt())
    }
}

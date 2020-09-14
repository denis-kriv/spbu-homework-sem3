package homeworks.semester3.homework1.task1.utils

import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.Network
import homeworks.semester3.homework1.task1.models.OperationSystem
import homeworks.semester3.homework1.task1.models.getConfigInfo
import java.io.File

private fun parseComputerInfo(info: List<String>): Computer {
    val probabilities = getConfigInfo()

    val system = when (info[0]) {
        "Windows" -> OperationSystem("Windows", probabilities["Windows"]!!)
        "Linux" -> OperationSystem("Linux", probabilities["Linux"]!!)
        "Mac" -> OperationSystem("Mac", probabilities["Mac"]!!)
        else -> throw UnsupportedOperationException("Operation system string must be correct.")
    }

    val isInfected = when (info[1]) {
        "true" -> true
        "false" -> false
        else -> throw UnsupportedOperationException("IsInfected string must be correct.")
    }

    return Computer(system, isInfected)
}

private fun parseLinksInfo(info: List<String>): MutableList<Int> {
    val result = mutableListOf<Int>()

    info.forEach {
        result.add(
            it.toIntOrNull()
                ?: throw NumberFormatException("The list of computer neighbors must contain only numbers.")
        )
    }

    return result
}

class Parser {

    fun parse(file: File): Network {
        val computers = mutableListOf<Computer>()
        val links = mutableListOf<MutableList<Int>>()

        file.forEachLine {
            val elements = it.split("||")

            when (elements.size) {
                2 -> {
                    val info = elements[0].split(" ")

                    if (info.lastIndex != 1) throw UnsupportedOperationException("String must be correct.")

                    computers.add(parseComputerInfo(info))
                    links.add(parseLinksInfo(elements[1].split(" ")))
                }

                1 -> {
                    val info = elements[0].split(" ")

                    if (info.lastIndex != 1) throw UnsupportedOperationException("String must be correct.")

                    computers.add(parseComputerInfo(info))
                    links.add(mutableListOf())
                }

                else -> throw UnsupportedOperationException("String must be correct.")
            }
        }

        return Network(computers, links)
    }
}

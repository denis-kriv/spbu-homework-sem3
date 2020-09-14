package homeworks.semester3.homework1.task1.utils

import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.Network
import homeworks.semester3.homework1.task1.models.OperationSystem
import homeworks.semester3.homework1.task1.models.getConfigInfo
import java.io.File

private fun parseComputerInfo(info: List<String>, probabilities: Map<String, Double>): Computer {

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

class Parser(private val pathToConfig: String) {

    fun parse(file: File): Network {
        val computers = mutableListOf<Computer>()
        val links = mutableListOf<MutableList<Int>>()

        val probabilities = getConfigInfo(pathToConfig)

        file.forEachLine {
            val elements = it.split("||")

            if (elements.size != 2) throw UnsupportedOperationException("String must be correct.")

            val info = elements[0].trim().split(" ")
            if (info.lastIndex != 1) throw UnsupportedOperationException("String must be correct.")

            computers.add(parseComputerInfo(info, probabilities))

            val linksInfo =
                if (elements[1].trim() != "") parseLinksInfo(elements[1].trim().split(" ")) else mutableListOf()

            links.add(linksInfo)
        }

        return Network(computers, links)
    }
}

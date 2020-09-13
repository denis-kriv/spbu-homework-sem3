package homeworks.semester3.homework1.task1.utils

import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.Network
import homeworks.semester3.homework1.task1.models.OperationSystem
import java.io.File

private fun parseComputerInfo(info: String): Computer {
    val computerInfo = info.split(" ")

    val system = when (computerInfo[0]) {
        "Windows" -> OperationSystem.Windows
        "Linux" -> OperationSystem.Linux
        "Mac" -> OperationSystem.Mac
        else -> throw UnsupportedOperationException("Operation system string must be correct.")
    }

    val isInfected = when (computerInfo[1]) {
        "true" -> true
        "false" -> false
        else -> throw UnsupportedOperationException("IsInfected string must be correct.")
    }

    return Computer(system, isInfected)
}

private fun parseLinksInfo(info: String): MutableList<Int> {
    val linksInfo = mutableListOf<Int>()

    info.split(" ").forEach {
        linksInfo.add(
            it.toIntOrNull()
                ?: throw NumberFormatException("The list of computer neighbors must contain only numbers.")
        )
    }

    return linksInfo
}

class Parser {

    fun parse(file: File): Network {
        val computers = mutableListOf<Computer>()
        val links = mutableListOf<MutableList<Int>>()

        file.forEachLine {
            val elements = it.split(" || ")

            computers.add(parseComputerInfo(elements[0]))

            if (elements.size == 1) {
                val info = elements[0].split(" ")

                if (info.size == 3 && info[2] == "||") links.add(mutableListOf())
                else throw UnsupportedOperationException("String must be correct.")
            } else {
                links.add(parseLinksInfo(elements[1]))
            }
        }

        return Network(computers, links)
    }
}

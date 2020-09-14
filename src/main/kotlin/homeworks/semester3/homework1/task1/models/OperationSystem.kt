package homeworks.semester3.homework1.task1.models

import java.io.File

private fun parseLine(elements: List<String>): Pair<String, Double> {
    val name = when (elements[0]) {
        "Windows" -> elements[0]
        "Linux" -> elements[0]
        "Mac" -> elements[0]
        else -> throw UnsupportedOperationException("Config info must be correct.")
    }

    val probability = elements[1].toDoubleOrNull()
        ?: throw UnsupportedOperationException("Config info must be correct.")

    return Pair(name, probability)
}

private fun parse(file: File): Map<String, Double> {
    val result = mutableMapOf<String, Double>()

    var indexOfLine = 0

    file.forEachLine {
        if (indexOfLine > 2) throw ArithmeticException("Config info must be correct.")

        val elements = it.trim().split(" ")

        if (elements.size != 2) throw UnsupportedOperationException("Config info must be correct.")

        val parsedLine = parseLine(elements)

        result[parsedLine.first] = parsedLine.second

        indexOfLine++
    }

    return result
}

fun getConfigInfo(pathToConfig: String): Map<String, Double> {
    val file = File(pathToConfig)

    if (!file.exists()) throw NoSuchFileException(file, null, "Config file must exist.")

    val result = parse(file)

    if (!result.containsKey("Windows") || !result.containsKey("Linux") || !result.containsKey("Mac")) {
        throw UnsupportedOperationException("Config info must be correct.")
    }

    return result
}

data class OperationSystem(val name: String, val probability: Double)

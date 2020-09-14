package homeworks.semester3.homework1.task1.models

import java.io.File

private fun parse(file: File): Map<String, Double> {
    val result = mutableMapOf<String, Double>()

    file.forEachLine {
        val elements = it.split(" ")

        if (elements.size != 2) throw UnsupportedOperationException("Config info must be correct.")

        val name = when (elements[0]) {
            "Windows" -> elements[0]
            "Linux" -> elements[0]
            "Mac" -> elements[0]
            else -> throw UnsupportedOperationException("Config info must be correct.")
        }

        val probability = elements[1].toDoubleOrNull() ?: throw UnsupportedOperationException("Config info must be correct.")

        result.put(name, probability)
    }

    return result
}

fun getConfigInfo(): Map<String, Double> {
    val file = File("src/main/kotlin/homeworks/semester3/homework1/task1/data/config")

    if (!file.exists()) throw NoSuchFileException(file, null, "Config file must exist.")

    val result = parse(file)

    if (!result.containsKey("Windows") || !result.containsKey("Linux") || !result.containsKey("Mac")) {
        throw UnsupportedOperationException("Config info must be correct.")
    }

    return result
}

data class OperationSystem(val name: String, val probability: Double)

package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.Network
import homeworks.semester3.homework1.task1.models.OperationSystem
import homeworks.semester3.homework1.task1.models.Simulator
import java.io.File
import kotlin.random.Random

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
                ?: throw NumberFormatException("The list of computer neighbors must contain only natural numbers.")
        )
    }

    return linksInfo
}

private fun parseFile(file: File): Network {
    val computers = mutableListOf<Computer>()
    val links = mutableListOf<MutableList<Int>>()

    file.forEachLine {
        val elements = it.split(" || ")

        computers.add(parseComputerInfo(elements[0]))
        links.add(parseLinksInfo(elements[1]))
    }

    return Network(computers, links)
}

private fun readFromFile(path: String): Network {
    val file = File(path)

    if (!file.exists()) throw NoSuchFileException(file, null, "The file must exist.")

    return parseFile(file)
}

private fun generateLinks(lastIndex: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    for (i in 0..lastIndex) {
        val links = List(Random.nextInt(1, lastIndex / 2)) {
            var index = Random.nextInt(0, lastIndex)

            while (index == i) index = Random.nextInt(0, lastIndex)

            index
        }

        result.add(i, links.distinct())
    }

    return result
}

private fun generate(): Network {
    val computers = List(Random.nextInt(1000, 10000)) {
        val isInfected = Random.nextInt(0, 100) < 10
        val system = OperationSystem.values()[Random.nextInt(0, 3)]

        Computer(system, isInfected)
    }

    return Network(computers, generateLinks(computers.lastIndex))
}

private fun initializeNetwork(): Network {
    return when (readLine()) {
        "0" -> {
            println("Path to file:")

            readFromFile(readLine() ?: throw KotlinNullPointerException("The input string must be non-empty."))
        }

        "1" -> generate()

        else -> throw UnsupportedOperationException("The input string must be correct.")
    }
}

private fun simulate(simulator: Simulator) {
    when (readLine()) {
        "0" -> {
            println("Quantity of steps")

            println(
                simulator.simulate(
                    readLine()?.toIntOrNull() ?: throw KotlinNullPointerException("The input string must be non-empty.")
                )
            )
        }

        "1" -> {
            while (true) {
                println(simulator.simulate(1))

                println("0: Continue")
                println("Else: Stop")

                if (readLine() != "0") break
            }
        }

        else -> throw UnsupportedOperationException("The input string must be correct.")
    }
}

fun main() {
    try {
        println("0: Read network from file.")
        println("1: Generate network.")

        val network = initializeNetwork()

        println("0: Simulate by quantity of steps")
        println("1: Simulate step by step")

        simulate(Simulator(network))
    } catch (e: UnsupportedOperationException) {
        println(e.message)
    } catch (e: KotlinNullPointerException) {
        println(e.message)
    } catch (e: NoSuchFileException) {
        println(e.message)
    } catch (e: NumberFormatException) {
        println(e.message)
    } catch (e: CloneNotSupportedException) {
        println(e.message)
    } catch (e: ArithmeticException) {
        println(e.message)
    } finally {
        println("Program stopped.")
    }
}
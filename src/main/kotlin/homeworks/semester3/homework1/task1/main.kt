package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.Network
import homeworks.semester3.homework1.task1.models.OperationSystem
import homeworks.semester3.homework1.task1.models.Simulator
import java.io.File
import java.lang.Exception
import java.lang.NullPointerException

private fun readFromFile(path: String): Network {
    val file = File(path)

    val computers = mutableListOf<Computer>()
    val links = mutableListOf<MutableList<Int>>()

    if (!file.exists()) throw Exception()

    file.forEachLine {
        val elements = it.split(" || ")

        val computerInfo = elements[0].split(" ")

        val system = when (computerInfo[0]) {
            "Windows" -> OperationSystem.Windows

            "Linux" -> OperationSystem.Linux

            "Mac" -> OperationSystem.Mac

            else -> throw Exception()
        }

        val isInfected = when (computerInfo[1]) {
            "true" -> true

            "false" -> false

            else -> throw Exception()
        }

        val linksInfo = mutableListOf<Int>()

        elements[1].split(" ").forEach { i -> linksInfo.add(i.toIntOrNull() ?: throw Exception()) }

        computers.add(Computer(system, isInfected))
        links.add(linksInfo)
    }

    return Network(computers, links)
}

private fun generate(): Network {
    return Network(listOf(), listOf())
}

private fun start() {
    println("0: Read network from file.")
    println("1: Generate network.")

    val network = when (readLine()) {
        "0" -> {
            println("Path to file:")

            readFromFile(readLine() ?: throw Exception())
        }

        "1" -> {
            generate()
        }

        else -> {
            throw Exception()
        }
    }

    val simulator = Simulator(network)

    println("0: Simulate by quantity of steps")
    println("1: Simulate step by step")

    when (readLine()) {
        "0" -> {
            println("Quantity of steps")

            println(simulator.simulate(readLine()?.toIntOrNull() ?: throw Exception()))
        }

        "1" -> {
            while (true) {
                println(simulator.simulate(1))

                println("0: Continue")
                println("Else: Stop")

                if (readLine() != "0") break
            }
        }

        else -> return
    }
}

fun main() {
    try {
        start()
    } catch (e: Exception) {

    } catch (e: NullPointerException) {

    } finally {
        println("Program stopped.")
    }
}
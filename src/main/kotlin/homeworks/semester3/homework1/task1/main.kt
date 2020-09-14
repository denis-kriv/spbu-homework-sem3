package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.models.Network
import homeworks.semester3.homework1.task1.utils.Generator
import homeworks.semester3.homework1.task1.utils.Parser
import homeworks.semester3.homework1.task1.utils.Simulator
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

private fun readFromFile(path: String, pathToConfig: String): Network {
    val file = File(path)

    if (!file.exists()) throw NoSuchFileException(file, null, "The file must exist.")

    return Parser(pathToConfig).parse(file)
}

private fun initializeNetwork(pathToConfig: String): Network {
    return when (readLine()) {
        "0" -> {
            println("Path to file:")

            readFromFile(
                readLine() ?: throw KotlinNullPointerException("The input string must be non-empty."),
                pathToConfig
            )
        }

        "1" -> Generator(pathToConfig).generate()

        else -> throw UnsupportedOperationException("The input string must be correct.")
    }
}

private fun simulate(simulator: Simulator) {
    when (readLine()) {
        "0" -> {
            println("Quantity of steps")

            runBlocking {
                launch {
                    println(
                        simulator.simulate(
                            readLine()?.toIntOrNull()
                                ?: throw KotlinNullPointerException("The input string must be non-empty.")
                        )
                    )
                }
            }
        }

        "1" -> {
            while (true) {
                runBlocking {
                    launch {
                        println(simulator.simulate(1))
                    }
                }

                println("0: Continue")
                println("Else: Stop")

                if (readLine() != "0") break
            }
        }

        else -> throw UnsupportedOperationException("The input string must be correct.")
    }
}

fun main() {
    val pathToConfig = "src/main/kotlin/homeworks/semester3/homework1/task1/data/config"

    try {
        println("0: Read network from file.")
        println("1: Generate network.")

        val network = initializeNetwork(pathToConfig)

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

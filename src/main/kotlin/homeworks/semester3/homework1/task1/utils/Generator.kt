package homeworks.semester3.homework1.task1.utils

import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.Network
import homeworks.semester3.homework1.task1.models.OperationSystem
import homeworks.semester3.homework1.task1.models.getConfigInfo
import kotlin.random.Random

private object Constants {
    const val minSizeOfNetwork = 10
    const val maxSizeOfNetwork = 100
    const val infectionProbability = 0.2
    const val systemTypesQuantity = 3
}

private fun generateLinks(lastIndex: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    for (i in 0 until lastIndex) {
        val links = List(Random.nextInt(1, lastIndex / 2)) {
            var index = Random.nextInt(0, lastIndex)

            while (index == i) index = Random.nextInt(0, lastIndex)

            index
        }

        result.add(i, links.distinct())
    }

    val links = List(lastIndex) { it }
    result.add(lastIndex, links)

    return result
}

class Generator(private val pathToConfig: String) {

    fun generate(): Network {
        val probabilities = getConfigInfo(pathToConfig)

        val computers = List(Random.nextInt(Constants.minSizeOfNetwork, Constants.maxSizeOfNetwork)) {
            val isInfected = Random.nextDouble() < Constants.infectionProbability

            val system = when (Random.nextInt(0, Constants.systemTypesQuantity)) {
                0 -> OperationSystem("Windows", probabilities["Windows"]!!)
                1 -> OperationSystem("Linux", probabilities["Linux"]!!)
                else -> OperationSystem("Mac", probabilities["Mac"]!!)
            }

            Computer(system, isInfected)
        }

        return Network(computers, generateLinks(computers.lastIndex))
    }
}

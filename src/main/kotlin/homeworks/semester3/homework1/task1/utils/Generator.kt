package homeworks.semester3.homework1.task1.utils

import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.Network
import homeworks.semester3.homework1.task1.models.OperationSystem
import kotlin.random.Random

private object Constants {
    const val minSizeOfNetwork = 1000
    const val maxSizeOfNetwork = 10000
    const val infectionProbability = 0.2
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

class Generator {

    fun generate(): Network {
        val computers = List(Random.nextInt(Constants.minSizeOfNetwork, Constants.maxSizeOfNetwork)) {
            val isInfected = Random.nextDouble() < Constants.infectionProbability
            val system = OperationSystem.values()[Random.nextInt(0, OperationSystem.values().size)]

            Computer(system, isInfected)
        }

        return Network(computers, generateLinks(computers.lastIndex))
    }
}

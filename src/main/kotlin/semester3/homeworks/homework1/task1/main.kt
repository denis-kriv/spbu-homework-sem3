package semester3.homeworks.homework1.task1

import semester3.homeworks.homework1.task1.models.Computer
import semester3.homeworks.homework1.task1.models.Network
import semester3.homeworks.homework1.task1.models.OperationSystem
import kotlin.random.Random

private fun generateLinks(size: Int, index: Int): Set<Int> {
    val quantity = Random.nextInt(0, 10) * size / 100
    val links = MutableList(quantity) { Random.nextInt(0, 100) }

    if (links.contains(index)) links.removeAll { it == index }

    return links.toSet()
}

private fun generateNetwork(): Network {
    val size = Random.nextInt(1000, 10000)

    val computers = List(size) { index ->
        val system = OperationSystem.values()[Random.nextInt(0, 3)]
        val links = generateLinks(size, index)
        val isInfected = Random.nextInt(0, 100) < 10

        Computer(system, links, isInfected)
    }

    return Network(computers.toSet())
}

fun main() {
    simulate(generateNetwork())
}

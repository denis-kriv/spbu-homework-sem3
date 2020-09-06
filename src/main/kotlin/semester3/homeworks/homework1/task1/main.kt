package semester3.homeworks.homework1.task1

import kotlin.random.Random

private fun addLinks(computers: MutableList<Computer>) {
    computers.forEach {
        val quantity = Random.nextInt(0, 10) * computers.size / 100
        val links = List(quantity) { Random.nextInt(0, 100) }

        for (i in links) {
            if (!it.links.contains(computers[i])) {
                it.links.add(computers[i])
                computers[i].links.add(it)
            }
        }
    }
}

private fun generateNetwork(): Network {
    val computers = MutableList(Random.nextInt(1000, 10000)) {
        val computer = Computer(OperationSystem.values()[Random.nextInt(0, 3)])

        if (Random.nextInt(0, 100) < 10) computer.isInfected = true

        computer
    }

    addLinks(computers)

    return Network(computers)
}

fun main() {
    val network = generateNetwork()

    while (true) {
        val statistics = network.getStatistics()
        println("Health: ${statistics.first} || Infected: ${statistics.second}")

        network.infect()

        println("Press 0 for continue, press any key for stop")

        if (readLine() != "0") break
    }
}

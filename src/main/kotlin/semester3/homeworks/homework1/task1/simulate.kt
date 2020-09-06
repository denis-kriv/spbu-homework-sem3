package semester3.homeworks.homework1.task1

import semester3.homeworks.homework1.task1.models.Network

fun simulate(network: Network) {
    while (true) {
        val statistics = network.getStatistics()
        println("Health: ${statistics.first} || Infected: ${statistics.second}")

        network.infect()

        println("Press 0 for continue, press any key for stop")

        if (readLine() != "0") return
    }
}
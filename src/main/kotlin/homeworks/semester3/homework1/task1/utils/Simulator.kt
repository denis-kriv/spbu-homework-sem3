package homeworks.semester3.homework1.task1.utils

import homeworks.semester3.homework1.task1.models.Network

class Simulator(private val network: Network) {

    fun simulate(stepsQuantity: Int): String {
        if (stepsQuantity < 0) throw ArithmeticException("The number of steps must be greater than zero.")

        for (i in 0 until stepsQuantity) {
            network.infect()
        }

        return network.getStatistics()
    }
}

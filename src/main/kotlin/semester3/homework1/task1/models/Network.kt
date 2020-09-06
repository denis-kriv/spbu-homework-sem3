package semester3.homework1.task1.models

import java.lang.IndexOutOfBoundsException

class Network(private val computers: Set<Computer>) {

    init {
        computers.forEach {
            it.links.forEach { i ->
                if (i < 0 || i >= computers.size) {
                    throw IndexOutOfBoundsException("Computer with index $i does not exist")
                }
            }
        }
    }

    fun infect() {
        val willBeInfect: MutableList<Int> = mutableListOf()

        computers.forEach { if (it.isInfected) willBeInfect.addAll(it.links) }

        willBeInfect.forEach { computers.elementAt(it).tryToInfect() }
    }

    fun getStatistics(): Pair<Int, Int> {
        var quantityOfInfected = 0
        var quantityOfHealth = 0

        computers.forEach { if (it.isInfected) quantityOfInfected++ else quantityOfHealth++ }

        return Pair(quantityOfHealth, quantityOfInfected)
    }
}

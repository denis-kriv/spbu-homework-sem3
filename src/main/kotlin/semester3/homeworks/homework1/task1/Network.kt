package semester3.homeworks.homework1.task1

class Network(private val computers: MutableList<Computer>) {

    fun infect() {
        val willBeInfect: MutableList<Computer> = mutableListOf()

        computers.forEach {
            if (it.isInfected) willBeInfect.addAll(it.links)
        }

        willBeInfect.forEach {
            it.tryToInfect()
        }
    }

    fun getStatistics(): Pair<Int, Int> {
        var quantityOfInfected = 0
        var quantityOfHealth = 0

        computers.forEach {
            if (it.isInfected) quantityOfInfected++ else quantityOfHealth++
        }

        return Pair(quantityOfHealth, quantityOfInfected)
    }
}

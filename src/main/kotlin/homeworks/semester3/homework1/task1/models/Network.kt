package homeworks.semester3.homework1.task1.models

class Network(private val computers: List<Computer>, private val links: List<List<Int>>) {

    private val infectedComputers: MutableList<Int> = mutableListOf()

    init {
        if (computers.distinct().size != computers.size) throw Exception()

        if (links.size > computers.size) throw Exception()

        links.forEach {
            if (it.distinct().size != it.size) throw Exception()

            it.forEach { i ->
                if (i > computers.lastIndex) throw Exception()

                if (i == links.indexOf(it)) throw Exception()
            }
        }

        computers.forEach { if (it.isInfected) infectedComputers.add(computers.indexOf(it)) }
    }

    fun infect() {
        val wasInfected = mutableListOf<Int>()

        infectedComputers.forEach {
            links[it].forEach { i ->
                val computer = computers[i]

                if (!computer.isInfected && computer.tryToInfect()) wasInfected.add(i)
            }
        }

        infectedComputers.addAll(wasInfected)
    }

    fun getStatistics(): String {
        return " "
    }
}

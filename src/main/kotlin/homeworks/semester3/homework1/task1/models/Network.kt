package homeworks.semester3.homework1.task1.models

class Network(private val computers: List<Computer>, private val links: List<List<Int>>) {

    private val infectedComputers: MutableList<Int> = mutableListOf()

    init {
        links.forEach {
            if (it.distinct().size != it.size) {
                throw CloneNotSupportedException("The list of computer neighbors should not contain duplicates.")
            }

            it.forEach { i ->
                if (i > computers.lastIndex) {
                    throw ArrayIndexOutOfBoundsException(
                        "The list of computer neighbors shouldn't contain indexes, large numbers of computers."
                    )
                }

                if (i < 0) {
                    throw ArrayIndexOutOfBoundsException(
                        "The list of computer neighbors shouldn't contain indexes, less than zero."
                    )
                }

                if (i == links.indexOf(it)) {
                    throw UnsupportedOperationException("The list of computer neighbors should not contain itself.")
                }
            }
        }

        computers.forEach { if (it.isInfected()) infectedComputers.add(computers.indexOf(it)) }
    }

    fun infect() {
        val wasInfected = mutableListOf<Int>()

        infectedComputers.forEach {
            links[it].forEach { i ->
                val computer = computers[i]

                if (!computer.isInfected() && computer.tryToInfect()) wasInfected.add(i)
            }
        }

        infectedComputers.addAll(wasInfected)
    }

    fun getStatistics(): String {
        if (infectedComputers.isEmpty()) return "All computers are healthy"

        val result = StringBuilder("Infected computers: ")

        infectedComputers.sorted().forEach {
            result.append("$it ")
        }

        return result.toString()
    }
}

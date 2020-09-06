package semester3.homeworks.homework1.task1

import kotlin.random.Random

enum class OperationSystem(val value: Int) { Windows(70), Linux(50), Mac(30) }

class Computer(private val system: OperationSystem) {

    val links: MutableList<Computer> = mutableListOf()
    var isInfected: Boolean = false

    fun tryToInfect(): Boolean {
        if (Random.nextInt(0, 100) < system.value) {
            isInfected = true

            return true
        }

        return false
    }
}

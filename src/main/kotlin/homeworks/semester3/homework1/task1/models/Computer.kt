package homeworks.semester3.homework1.task1.models

import kotlin.random.Random

data class Os(val probability: Double)

enum class OperationSystem(val systemInfo: Os) {
    Windows(Os(0.7)),
    Linux(Os(0.5)),
    Mac(Os(0.3))
}

class Computer(private val system: OperationSystem, private var isInfected: Boolean) {

    fun isInfected(): Boolean {
        return isInfected
    }

    fun tryToInfect(): Boolean {
        if (Random.nextDouble() < system.systemInfo.probability) isInfected = true

        return isInfected
    }
}

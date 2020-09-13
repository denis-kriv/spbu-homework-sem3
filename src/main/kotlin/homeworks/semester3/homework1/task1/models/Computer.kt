package homeworks.semester3.homework1.task1.models

import kotlin.random.Random

private object Constants {
    const val windowsProbability = 0.7
    const val linuxProbability = 0.5
    const val macProbability = 0.3
}

enum class OperationSystem(val probability: Double) {
    Windows(Constants.windowsProbability),
    Linux(Constants.linuxProbability),
    Mac(Constants.macProbability)
}

class Computer(private val system: OperationSystem, isInfected: Boolean) {

    var isInfected: Boolean = isInfected
        private set

    fun tryToInfect(): Boolean {
        if (Random.nextDouble() < system.probability) isInfected = true

        return isInfected
    }
}

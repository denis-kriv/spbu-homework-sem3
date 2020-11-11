package homeworks.semester3.homework1.task1.models

import kotlin.random.Random

class Computer(private val system: OperationSystem, private var isInfected: Boolean) {

    fun isInfected(): Boolean {
        return isInfected
    }

    fun tryToInfect(): Boolean {
        if (Random.nextDouble() < system.probability) isInfected = true

        return isInfected
    }
}

package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.OperationSystem
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ComputerTests {

    @Test
    fun isInfectedShouldReturnsTrueWhenComputerIsInfected() {
        val computer = Computer(OperationSystem.Mac, false)

        assertFalse(computer.isInfected())
    }

    @Test
    fun isInfectedShouldReturnsFalseWhenComputerIsNotInfected() {
        val computer = Computer(OperationSystem.Mac, true)

        assertTrue(computer.isInfected())
    }

    @Test
    fun tryToInfectShouldReturnsTrueWhenComputerIsInfected() {
        val computer = Computer(OperationSystem.Mac, false)
        var result = false

        while (!computer.isInfected()) result = computer.tryToInfect()

        assertTrue(result)
    }
}

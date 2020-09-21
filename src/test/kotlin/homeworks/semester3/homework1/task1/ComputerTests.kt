package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.models.Computer
import homeworks.semester3.homework1.task1.models.OperationSystem
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ComputerTests {

    @Test
    fun isInfectedShouldReturnsTrueWhenComputerIsInfected() {
        val computer = Computer(OperationSystem("Mac", 0.3), false)

        assertFalse(computer.isInfected())
    }

    @Test
    fun isInfectedShouldReturnsFalseWhenComputerIsNotInfected() {
        val computer = Computer(OperationSystem("Windows", 0.7), true)

        assertTrue(computer.isInfected())
    }

    @Test
    fun tryToInfectShouldReturnsTrueWhenComputerIsInfected() {
        val computer = Computer(OperationSystem("Linux", 0.5), false)
        var result = false

        while (!computer.isInfected()) result = computer.tryToInfect()

        assertTrue(result)
    }
}

package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.utils.Generator
import homeworks.semester3.homework1.task1.utils.Simulator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.ArithmeticException

class SimulatorTests {

    @Test
    fun simulateShouldThrowsArithmeticExceptionWhenStepsQuantityIsLessThanZero() {
        assertThrows<ArithmeticException> {
            Simulator(Generator("src/test/kotlin/homeworks/semester3/homework1/task1/config/config")
                .generate())
                .simulate(-1)
        }
    }

    @Test
    fun simulateShouldWorksCorrectlyWhenStepsQuantityIsZero() {
        assertDoesNotThrow {
            Simulator(Generator("src/test/kotlin/homeworks/semester3/homework1/task1/config/config")
                .generate())
                .simulate(0)
        }
    }

    @Test
    fun simulateShouldWorksCorrectlyWhenStepsQuantityIsLargeThanZero() {
        assertDoesNotThrow {
            Simulator(Generator("src/test/kotlin/homeworks/semester3/homework1/task1/config/config")
                .generate())
                .simulate(100)
        }
    }
}

package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.utils.Generator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GeneratorTests {

    @Test
    fun generateShouldNotThrowsExceptionWhenGenerateNetwork() {
        val generator = Generator("src/test/kotlin/homeworks/semester3/homework1/task1/config/config")

        for (i in 0..20) {
            assertDoesNotThrow { generator.generate() }
        }
    }
}
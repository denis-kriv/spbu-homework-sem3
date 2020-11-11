package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.models.getConfigInfo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class OperationSystemTests {

    @Test
    fun getConfigInfoShouldThrowsNoSuchFileExceptionWhenConfigFileDoesNotExist() {
        assertThrows<NoSuchFileException> {
            getConfigInfo(
                "src/test/kotlin/homeworks/semester3/homework1/task1/data/testConfigs/example"
            )
        }
    }

    @Test
    fun getConfigInfoShouldThrowsUnsupportedOperationExceptionWhenConfigFileIsNotContainsAllOs() {
        assertThrows<UnsupportedOperationException> {
            getConfigInfo(
                "src/test/kotlin/homeworks/semester3/homework1/task1/data/testConfigs/fileWithoutMacOs"
            )
        }
    }

    @Test
    fun getConfigInfoShouldThrowsArithmeticExceptionWhenConfigFileHasTooManyLines() {
        assertThrows<ArithmeticException> {
            getConfigInfo(
                "src/test/kotlin/homeworks/semester3/homework1/task1/data/testConfigs/fileWithTooManyLines"
            )
        }
    }

    @Test
    fun getConfigInfoShouldThrowsUnsupportedOperationExceptionWhenConfigFileHasIncorrectLine() {
        assertThrows<UnsupportedOperationException> {
            getConfigInfo(
                "src/test/kotlin/homeworks/semester3/homework1/task1/data/testConfigs/fileWithIncorrectLine"
            )
        }
    }

    @Test
    fun getConfigInfoShouldThrowsUnsupportedOperationExceptionWhenConfigFileHasEmptyLine() {
        assertThrows<UnsupportedOperationException> {
            getConfigInfo(
                "src/test/kotlin/homeworks/semester3/homework1/task1/data/testConfigs/fileWithEmptyLine"
            )
        }
    }

    @Test
    fun getConfigInfoShouldThrowsUnsupportedOperationExceptionWhenOsStringIsIncorrect() {
        assertThrows<UnsupportedOperationException> {
            getConfigInfo(
                "src/test/kotlin/homeworks/semester3/homework1/task1/data/testConfigs/fileWithIncorrectOsString"
            )
        }
    }

    @Test
    fun getConfigInfoShouldThrowsUnsupportedOperationExceptionWhenProbabilityStringIsIncorrect() {
        assertThrows<UnsupportedOperationException> {
            getConfigInfo(
                "src/test/kotlin/homeworks/semester3/homework1/task1/data/testConfigs/fileWithIncorrectProbabilityString"
            )
        }
    }

    @Test
    fun getConfigInfoShouldWorksCorrectlyWhenDataIsCorrect() {
        assertDoesNotThrow {
            getConfigInfo(
                "src/test/kotlin/homeworks/semester3/homework1/task1/data/testConfigs/fileWithCorrectData"
            )
        }
    }
}

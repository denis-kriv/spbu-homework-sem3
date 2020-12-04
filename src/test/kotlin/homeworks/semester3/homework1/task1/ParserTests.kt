package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.utils.Parser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.io.File

class ParserTests {

    @Test
    fun parseShouldThrowsUnsupportedOperationExceptionWhenStringIsIncorrect() {
        val file = File(
            "src/test/kotlin/homeworks/semester3/homework1/task1/data/testNetworks/fileWithIncorrectString"
        )

        assertThrows<UnsupportedOperationException> {
            Parser("src/test/kotlin/homeworks/semester3/homework1/task1/config/config").parse(file)
        }
    }

    @Test
    fun parseShouldThrowsUnsupportedOperationExceptionWhenOperationSystemStringIsIncorrect() {
        val file = File(
            "src/test/kotlin/homeworks/semester3/homework1/task1/data/testNetworks/fileWithIncorrectOS"
        )

        assertThrows<UnsupportedOperationException> {
            Parser("src/test/kotlin/homeworks/semester3/homework1/task1/config/config").parse(file)
        }
    }

    @Test
    fun parseShouldThrowsUnsupportedOperationExceptionWhenIsInfectedStringIsIncorrect() {
        val file = File(
            "src/test/kotlin/homeworks/semester3/homework1/task1/data/testNetworks/fileWithIncorrectIsInfected"
        )

        assertThrows<UnsupportedOperationException> {
            Parser("src/test/kotlin/homeworks/semester3/homework1/task1/config/config").parse(file)
        }
    }

    @Test
    fun parseShouldThrowsNumberFormatExceptionWhenComputerNeighborsStringIsIncorrect() {
        val file = File(
            "src/test/kotlin/homeworks/semester3/homework1/task1/data/testNetworks/fileWithIncorrectLinks"
        )

        assertThrows<NumberFormatException> {
            Parser("src/test/kotlin/homeworks/semester3/homework1/task1/config/config").parse(file)
        }
    }

    @Test
    fun parseShouldThrowsUnsupportedOperationExceptionWhenSomeStringsIsEmpty() {
        val file = File(
            "src/test/kotlin/homeworks/semester3/homework1/task1/data/testNetworks/fileWithSomeEmptyStrings"
        )

        assertThrows<UnsupportedOperationException> {
            Parser("src/test/kotlin/homeworks/semester3/homework1/task1/config/config").parse(file)
        }
    }

    @Test
    fun parseShouldWorksCorrectlyWhenDataIsCorrectAndAllStringsIsNotEmpty() {
        val file = File(
            "src/test/kotlin/homeworks/semester3/homework1/task1/data/testNetworks/fileWithCorrectDataAndNotEmptyStrings"
        )

        assertDoesNotThrow {
            Parser("src/test/kotlin/homeworks/semester3/homework1/task1/config/config").parse(file)
        }
    }

    @Test
    fun parseShouldWorksCorrectlyWhenDataIsCorrectAndSomeLinksStringsIsEmpty() {
        val file = File(
            "src/test/kotlin/homeworks/semester3/homework1/task1/data/testNetworks/fileWithCorrectDataAndSomeEmptyLinksStrings"
        )

        assertDoesNotThrow {
            Parser("src/test/kotlin/homeworks/semester3/homework1/task1/config/config").parse(file)
        }
    }
}

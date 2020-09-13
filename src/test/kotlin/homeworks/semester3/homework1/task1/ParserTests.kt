package homeworks.semester3.homework1.task1

import homeworks.semester3.homework1.task1.utils.Parser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.io.File

class ParserTests {

    @Test
    fun parseShouldThrowsUnsupportedOperationExceptionWhenStringIsIncorrect() {
        val file = File("src/test/kotlin/homeworks/semester3/homework1/task1/data/fileWithIncorrectString")

        assertThrows<UnsupportedOperationException> { Parser().parse(file) }
    }

    @Test
    fun parseShouldThrowsUnsupportedOperationExceptionWhenOperationSystemStringIsIncorrect() {
        val file = File("src/test/kotlin/homeworks/semester3/homework1/task1/data/fileWithIncorrectOS")

        assertThrows<UnsupportedOperationException> { Parser().parse(file) }
    }

    @Test
    fun parseShouldThrowsUnsupportedOperationExceptionWhenIsInfectedStringIsIncorrect() {
        val file = File("src/test/kotlin/homeworks/semester3/homework1/task1/data/fileWithIncorrectIsInfected")

        assertThrows<UnsupportedOperationException> { Parser().parse(file) }
    }

    @Test
    fun parseShouldThrowsNumberFormatExceptionWhenComputerNeighborsStringIsIncorrect() {
        val file = File("src/test/kotlin/homeworks/semester3/homework1/task1/data/fileWithIncorrectLinks")

        assertThrows<NumberFormatException> { Parser().parse(file) }
    }

    @Test
    fun parseShouldWorksCorrectlyWhenDataIsCorrectAndAllStringsIsNotEmpty() {
        val file = File(
            "src/test/kotlin/homeworks/semester3/homework1/task1/data/fileWithCorrectDataAndNotEmptyStrings"
        )

        assertDoesNotThrow { Parser().parse(file) }
    }

    @Test
    fun parseShouldWorksCorrectlyWhenDataIsCorrectAndSomeLinksStringsIsEmpty() {
        val file = File(
            "src/test/kotlin/homeworks/semester3/homework1/task1/data/fileWithCorrectDataAndSomeEmptyLinksStrings"
        )

        assertDoesNotThrow { Parser().parse(file) }
    }
}

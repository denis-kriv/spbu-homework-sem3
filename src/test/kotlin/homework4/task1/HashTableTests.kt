package homework4.task1

import homeworks.homework4.task1.HashTable
import homeworks.homework4.task1.hashFunctions.PolynomialHashFunction
import homeworks.homework4.task1.hashFunctions.QuadraticHashFunction
import homeworks.homework4.task1.models.Statistics
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.random.Random

internal class HashTableTests {

    @Test
    fun initShouldThrowExceptionWhenArraySizeIsNotNaturalNumber() {
        assertThrows<ArithmeticException> { HashTable(-1) }
    }

    @Test
    fun initShouldCreateTableWhenDataIsCorrect() {
        assertDoesNotThrow { HashTable(Random.nextInt(10, 100)) }
    }

    @Test
    fun getItemsShouldReturnAllItems() {
        val table = HashTable(123)

        val expected = mutableListOf<String>()
        for (i in 0..10) {
            table.plus("Example$i")
            expected.add("Example$i")
        }

        table.getItems().forEach { assertTrue(expected.contains(it)) }
    }

    @Test
    fun plusShouldThrowExceptionWhenValueIsNull() {
        val table = HashTable(10)

        assertThrows<KotlinNullPointerException> { table.plus(null) }
    }

    @Test
    fun plusShouldThrowExceptionWhenValueIsExist() {
        val table = HashTable(10)

        table.plus("Example")

        assertThrows<CloneNotSupportedException> { table.plus("Example") }
    }

    @Test
    fun plusShouldAddValueWhenDataIsCorrect() {
        val table = HashTable(10)

        table.plus("Example")

        assertTrue(table.getItems().contains("Example"))
    }

    @Test
    fun minusShouldThrowExceptionWhenValueIsBlank() {
        val table = HashTable(100)

        assertThrows<KotlinNullPointerException> { table.minus("  ") }
    }

    @Test
    fun minusShouldThrowExceptionWhenValueDoesNotExist() {
        val table = HashTable(10)

        assertThrows<NoSuchElementException> { table.minus("Example") }
    }

    @Test
    fun minusShouldRemoveElementWhenDataIsCorrect() {
        val table = HashTable(5)

        table.plus("Example")
        table.minus("Example")

        assertEquals(0, table.getItems().size)
    }

    @Test
    fun getIndexShouldThrowExceptionWhenInputValueDoesNotCorrect() {
        val table = HashTable(100)

        assertThrows<KotlinNullPointerException> { table.getIndex(" ") }
    }

    @Test
    fun getIndexShouldThrowExceptionWhenElementDoesNotExist() {
        val table = HashTable(100)

        assertThrows<NoSuchElementException> { table.getIndex("Example") }
    }

    @Test
    fun getIndexShouldWorkCorrectlyWhenDataIsCorrect() {
        val table = HashTable(100)

        table.plus("Example")

        assertEquals(table.getIndex("Example"), QuadraticHashFunction().getHash("Example", 100))
    }

    @Test
    fun getStatisticsShouldReturnRightData() {
        val table = HashTable(19)

        table.plus("Statistics")
        val expected = Statistics(19, 0, 1, 0.05263157894736842)

        assertEquals(expected, table.getStatistics())
    }

    @Test
    fun plusFromFileShouldThrowExceptionWhenFilePathIsBlank() {
        val table = HashTable(100)

        assertThrows<KotlinNullPointerException> { table.plusFromFile("") }
    }

    @Test
    fun plusFromFileShouldThrowExceptionWhenFileDoesNotExist() {
        val table = HashTable(17)

        assertThrows<NoSuchFileException> { table.plusFromFile("Example") }
    }

    @Test
    fun plusFromFileShouldThrowExceptionWhenDataInFileIsIncorrect() {
        val table = HashTable(18)

        val path = "src/test/kotlin/homework4/task1/Data/FileWithEmptyLines.txt"

        assertThrows<KotlinNullPointerException> { table.plusFromFile(path) }
    }

    @Test
    fun plusFromFileShouldAddItemsExceptionWhenDataIsCorrect() {
        val table = HashTable(1000)

        val path = "src/test/kotlin/homework4/task1/Data/FileWithCorrectElements.txt"
        table.plusFromFile(path)
        val items = table.getItems()

        for (it in 1..5) {
            assertTrue(items.contains("plusFromFile$it"))
        }
    }

    @Test
    fun chooseHashFunctionShouldChangeFunction() {
        val table = HashTable(99)

        table.plus("Example")
        table.chooseHashFunction(PolynomialHashFunction(17))

        assertEquals(table.getIndex("Example"), PolynomialHashFunction(17).getHash("Example", 99))
    }
}

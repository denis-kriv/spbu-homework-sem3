package homework4.task1

import homeworks.homework4.task1.HashTable
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class HashTableTests {

    private val testTable: HashTable = HashTable(10)

    init {
        testTable.items[testTable.hashFunction.getHash("Plus")].add("Plus")
        testTable.items[testTable.hashFunction.getHash("Minus")].add("Minus")
        testTable.items[testTable.hashFunction.getHash("GetIndex")].add("GetIndex")
        testTable.items[testTable.hashFunction.getHash("PlusFromFile")].add("PlusFromFile")
    }

    @Test
    fun plusShouldThrowsKotlinNullPointerExceptionWhenInputStringIsBlank() {
        assertThrows<KotlinNullPointerException> { testTable.plus("   ") }
    }

    @Test
    fun plusShouldThrowsKotlinNullPointerExceptionWhenInputStringIsNull() {
        assertThrows<KotlinNullPointerException> { testTable.plus(null) }
    }

    @Test
    fun plusShouldThrowsCloneNotSupportedExceptionWhenInputValueIsAlreadyExist() {
        assertThrows<CloneNotSupportedException> { testTable.plus("Plus") }
    }

    @Test
    fun plusShouldAddItemWhenInputStringIsCorrect() {
        testTable.plus("Plus1")

        assertTrue(testTable.items[testTable.hashFunction.getHash("Plus1")].contains("Plus1"))
    }

    @Test
    fun minusShouldThrowsKotlinNullPointerExceptionWhenInputStringIsBlank() {
        assertThrows<KotlinNullPointerException> { testTable.minus("   ") }
    }

    @Test
    fun minusShouldThrowsKotlinNullPointerExceptionWhenInputStringIsNull() {
        assertThrows<KotlinNullPointerException> { testTable.minus(null) }
    }

    @Test
    fun minusShouldThrowsNoSuchElementExceptionWhenInputValueIsNotExist() {
        assertThrows<NoSuchElementException> { testTable.minus("Minus1") }
    }

    @Test
    fun minusShouldRemoveItemWhenInputStringIsCorrect() {
        testTable.minus("Minus")

        assertFalse(testTable.items[testTable.hashFunction.getHash("Minus")].contains("Minus"))
    }

    @Test
    fun getIndexShouldThrowsKotlinNullPointerExceptionWhenInputStringIsBlank() {
        assertThrows<KotlinNullPointerException> { testTable.getIndex("   ") }
    }

    @Test
    fun getIndexShouldThrowsKotlinNullPointerExceptionWhenInputStringIsNull() {
        assertThrows<KotlinNullPointerException> { testTable.getIndex(null) }
    }

    @Test
    fun getIndexShouldThrowsNoSuchElementExceptionWhenInputValueIsNotExist() {
        assertThrows<NoSuchElementException> { testTable.getIndex("GetIndex1") }
    }

    @Test
    fun getIndexShouldReturnsItemIndexWhenInputStringIsCorrect() {
        assertEquals(testTable.getIndex("GetIndex"), testTable.hashFunction.getHash("GetIndex"))
    }

    @Test
    fun getStatisticsShouldReturnsStatistics() {
        val table = HashTable()
        table.plus("Statistics")
        val result = table.getStatistics()

        assertEquals(2048, result.size)
        assertEquals(0, result.conflicts)
        assertEquals(1, result.maxLength)
        assertEquals(0.0, result.loadFactor)
    }

    @Test
    fun plusFromFileShouldThrowsKotlinNullPointerExceptionWhenInputStringIsBlank() {
        assertThrows<KotlinNullPointerException> { testTable.plusFromFile("   ") }
    }

    @Test
    fun plusFromFileShouldThrowsKotlinNullPointerExceptionWhenInputStringIsNull() {
        assertThrows<KotlinNullPointerException> { testTable.plusFromFile(null) }
    }

    @Test
    fun plusFromFileShouldThrowsNoSuchFIleExceptionWhenFileIsNotExist() {
        assertThrows<NoSuchFileException> { testTable.plusFromFile("NotExistingFile") }
    }

    @Test
    fun plusFromFileShouldThrowsKotlinNullPointerExceptionWhenElementInFileIsEmpty() {
        val path = "src/test/kotlin/homework4/task1/Data/FileWithEmptyLines.txt"

        assertThrows<KotlinNullPointerException> { testTable.plusFromFile(path) }
    }

    @Test
    fun plusFromFileShouldThrowsCloneNotSupportedExceptionWhenElementInFileIsAlreadyExist() {
        val path = "src/test/kotlin/homework4/task1/Data/FileWithExistingItems.txt"

        assertThrows<CloneNotSupportedException> { testTable.plusFromFile(path) }
    }

    @Test
    fun plusFromFileShouldFillsTableWhenInputPathIsCorrectAndElementsInFileIsCorrect() {
        val path = "src/test/kotlin/homework4/task1/Data/FileWithCorrectElements.txt"
        testTable.plusFromFile(path)

        for (it in 1 .. 5) {
            assertTrue(testTable.items[testTable.hashFunction.getHash("plusFromFile$it")].contains("plusFromFile$it"))
        }
    }

    @Test
    fun chooseHashFunctionShouldThrowsKotlinNullPointerExceptionWhenInputStringIsBlank() {
        assertThrows<KotlinNullPointerException> { testTable.chooseHashFunction("   ") }
    }

    @Test
    fun chooseHashFunctionShouldThrowsKotlinNullPointerExceptionWhenInputStringIsNull() {
        assertThrows<KotlinNullPointerException> { testTable.chooseHashFunction(null) }
    }

    @Test
    fun chooseHashFunctionShouldThrowsIllegalArgumentExceptionWhenInputStringISNotCorrect() {
        assertThrows<IllegalArgumentException> { testTable.chooseHashFunction("Hash1") }
    }

    @Test
    fun chooseHashFunctionShouldChangeHashFunctionWhenInputStringIsCorrect() {
        testTable.chooseHashFunction("Hash5")

        testTable.items.forEach {
            for (i in it) {
                assertEquals(testTable.hashFunction.getHash(i), testTable.items.indexOf(it))
            }
        }
        assertEquals(5, testTable.hashFunction.key)
    }
}
package homework2Tests

import homeworks.homework2.task1.stringWithoutSubStr
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class TestsForTask1 {

    @Test
    fun testForEmptyString() {
        val testString = ""
        val result = 0
        assertEquals(result, stringWithoutSubStr(testString))
    }

    @Test
    fun testWhenStartAndEndIsSubstring() {
        val testString = "xxxabcxxx"
        val result = 2
        assertEquals(result, stringWithoutSubStr(testString))
    }

    @Test
    fun testWhenAllCharsIsX() {
        val testString = "xxxxxxx"
        val result = 5
        assertEquals(result, stringWithoutSubStr(testString))
    }

    @Test
    fun testWhenGoTwoXInARow() {
        val testString = "xxacxxaxxxx"
        val result = 2
        assertEquals(result, stringWithoutSubStr(testString))
    }

    @Test
    fun commonTest() {
        val testString = "xaxaxaxxxaxxxaxxxa"
        val result = 3
        assertEquals(result, stringWithoutSubStr(testString))
    }
}

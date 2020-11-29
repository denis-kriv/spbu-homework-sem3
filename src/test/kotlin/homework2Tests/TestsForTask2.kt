package homework2Tests

import homeworks.homework2.task2.deleteRepeatElements
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class TestsForTask1 {

    @Test
    fun testWhenFirstElementAndLastElementIsEquals() {
        val testArray: Array<String> = arrayOf("abc", "bcd", "abc")
        val resultArray: Array<String> = arrayOf("bcd", "abc")
        assertArrayEquals(resultArray, deleteRepeatElements(testArray))
    }

    @Test
    fun testWhereNoEqualsElements() {
        val testArray: Array<String> = arrayOf("abc", "bcd", "cde")
        val resultArray: Array<String> = arrayOf("abc", "bcd", "cde")
        assertArrayEquals(resultArray, deleteRepeatElements(testArray))
    }

    @Test
    fun testWhereTwoElementsInARowHaveEquals() {
        val testArray: Array<String> = arrayOf("bcd", "abc", "bcd", "abc")
        val resultArray: Array<String> = arrayOf("bcd", "abc")
        assertArrayEquals(resultArray, deleteRepeatElements(testArray))
    }

    @Test
    fun testWhereTwoElementsInARowIsEquals() {
        val testArray: Array<String> = arrayOf("cde", "bcd", "bcd", "abc", "cde")
        val resultArray: Array<String> = arrayOf("bcd", "abc", "cde")
        assertArrayEquals(resultArray, deleteRepeatElements(testArray))
    }

    @Test
    fun commonTest() {
        val testArray: Array<String> = arrayOf("abc", "bcd", "abc", "cde", "abc")
        val resultArray: Array<String> = arrayOf("bcd", "cde", "abc")
        assertArrayEquals(resultArray, deleteRepeatElements(testArray))
    }
}



package homework1Tests

import homework1.task4.isPolyndrom
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TestsForTask4 {

    @Test
    fun testForEmptyString() {
        val testString = ""
        val result = true
        assertEquals(result, isPolyndrom(testString))
    }

    @Test
    fun testForSpaces() {
        val testString = "  "
        val result = true
        assertEquals(result, isPolyndrom(testString))
    }

    @Test
    fun testForSpacesWithOtherChars() {
        val testString = " abccba "
        val result = true
        assertEquals(result, isPolyndrom(testString))
    }

    @Test
    fun commonTest() {
        val testString = "abcde"
        val result = false
        assertEquals(result, isPolyndrom(testString))
    }

    @Test
    fun testWithOneSpace() {
        val testString = "AbccbA "
        val result = false
        assertEquals(result, isPolyndrom(testString))
    }
}

package homework1Tests

import homewroks.homework1.task4.isPolyndrom
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TestsForTask4 {

    @Test
    fun testForEmptyString() {
        val testString = ""
        assertTrue(isPolyndrom(testString))
    }

    @Test
    fun testForSpaces() {
        val testString = "  "
        assertTrue(isPolyndrom(testString))
    }

    @Test
    fun testForSpacesWithOtherChars() {
        val testString = " abccba "
        assertTrue(isPolyndrom(testString))
    }

    @Test
    fun commonTest() {
        val testString = "abcde"
        assertFalse(isPolyndrom(testString))
    }

    @Test
    fun testWithOneSpace() {
        val testString = "AbccbA "
        assertFalse(isPolyndrom(testString))
    }
}

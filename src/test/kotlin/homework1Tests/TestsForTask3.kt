package homework1Tests

import homeworks.homework1.task3.countOfSubstrings
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TestsForTask3 {

    @Test
    fun testForOneChar() {
        val firstTestString = "aaaaaa"
        val secondTestString = "a"
        val result = 6
        assertEquals(result, countOfSubstrings(firstTestString, secondTestString))
    }

    @Test
    fun testForSpaces() {
        val firstTestString = "  "
        val secondTestString = " "
        val result = 2
        assertEquals(result, countOfSubstrings(firstTestString, secondTestString))
    }

    @Test
    fun testForStringWithTwoEntriesInARow() {
        val firstTestString = "abcabc"
        val secondTestString = "abc"
        val result = 2
        assertEquals(result, countOfSubstrings(firstTestString, secondTestString))
    }

    @Test
    fun testForStringWithEntriesNotInARow() {
        val firstTestString = "aabaabab"
        val secondTestString = "ab"
        val result = 3
        assertEquals(result, countOfSubstrings(firstTestString, secondTestString))
    }

    @Test
    fun testForStringWithSameChars() {
        val firstTestString = "aadddddaddd"
        val secondTestString = "ddd"
        val result = 4
        assertEquals(result, countOfSubstrings(firstTestString, secondTestString))
    }

    @Test
    fun testWhenFirstStringIsSmallerThanSecond() {
        val firstTestString = "aa"
        val secondTestString = "abc"
        val result = 0
        assertEquals(result, countOfSubstrings(firstTestString, secondTestString))
    }

    @Test
    fun testWhenStringsAreEquals() {
        val firstTestString = "acc"
        val secondTestString = "acc"
        val result = 1
        assertEquals(result, countOfSubstrings(firstTestString, secondTestString))
    }
}
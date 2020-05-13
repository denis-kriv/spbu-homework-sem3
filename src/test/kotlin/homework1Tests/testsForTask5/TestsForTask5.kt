package homework1Tests.testsForTask5

import  homeworks.homework1.task5.countOfStrings
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TestsForTask5 {

    @Test
    fun testForOneNotEmptyString() {
        val pathToFile = "src/test/kotlin/homework1Tests/testsForTask5/Test1.txt"
        val result = 1
        assertEquals(result, countOfStrings(pathToFile))
    }

    @Test
    fun testForEmptyStringsInMiddle() {
        val pathToFile = "src/test/kotlin/homework1Tests/testsForTask5/Test2.txt"
        val result = 2
        assertEquals(result, countOfStrings(pathToFile))
    }

    @Test
    fun testWithSomeEmptyStringsAtTheBeginning() {
        val pathToFile = "src/test/kotlin/homework1Tests/testsForTask5/Test3.txt"
        val result = 1
        assertEquals(result, countOfStrings(pathToFile))
    }

    @Test
    fun testWithSomeEmptyStringsAndNotEmptyStringAtTheMiddle() {
        val pathToFile = "src/test/kotlin/homework1Tests/testsForTask5/Test4.txt"
        val result = 3
        assertEquals(result, countOfStrings(pathToFile))
    }

    @Test
    fun testWithOneNotEmptyStringAndSomeEmptyStringsAfter() {
        val pathToFile = "src/test/kotlin/homework1Tests/testsForTask5/Test5.txt"
        val result = 1
        assertEquals(result, countOfStrings(pathToFile))
    }
}
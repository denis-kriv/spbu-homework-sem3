package homework1Tests

import homework1.hw1_task2.factorial
import homework1.hw1_task2.recursionFactorial
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TestsForTask2 {

    @Test
    fun testForFactorialWhenValueIsZero() {
        val result = 1
        val testValue = 0
        assertEquals(result, factorial(testValue))
    }

    @Test
    fun testForFactorialWhenValueIsOne() {
        val result = 1
        val testValue = 1
        assertEquals(result, factorial(testValue))
    }

    @Test
    fun testForFactorialWhenValueIsFive() {
        val result = 120
        val testValue = 5
        assertEquals(result, factorial(testValue))
    }

    @Test
    fun testForFactorialWhenInputIsNotCorrect() {
        val testValue = -1
        assertThrows(Exception::class.java) {
            factorial(testValue)
        }
    }

    @Test
    fun testForRecursionFactorialWhenValueIsZero() {
        val result = 1
        val testValue = 0
        assertEquals(result, recursionFactorial(testValue))
    }

    @Test
    fun testForRecursionFactorialWhenValueIsOne() {
        val result = 1
        val testValue = 1
        assertEquals(result, recursionFactorial(testValue))
    }

    @Test
    fun testForRecursionFactorialWhenValueIsFive() {
        val result = 120
        val testValue = 5
        assertEquals(result, recursionFactorial(testValue))
    }

    @Test
    fun testForRecursionFactorialWhenInputIsNotCorrect() {
        val testValue = -5
        assertThrows(Exception::class.java) {
            recursionFactorial(testValue)
        }
    }
}
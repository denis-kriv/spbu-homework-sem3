package homework1Tests

import homeworks.homework1.task2.iterativeFactorial
import homeworks.homework1.task2.recursionFactorial
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class TestsForTask2 {

    @Test
    fun testForFactorialWhenValueIsZero() {
        val result = 1
        val testValue = 0
        assertEquals(result, iterativeFactorial(testValue))
    }

    @Test
    fun testForFactorialWhenValueIsOne() {
        val result = 1
        val testValue = 1
        assertEquals(result, iterativeFactorial(testValue))
    }

    @Test
    fun testForFactorialWhenValueIsFive() {
        val result = 120
        val testValue = 5
        assertEquals(result, iterativeFactorial(testValue))
    }

    @Test
    fun testForFactorialWhenInputIsNotCorrect() {
        val testValue = -1
        assertThrows<ArithmeticException> { iterativeFactorial(testValue) }
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
        assertThrows<ArithmeticException> { recursionFactorial(testValue) }
    }
}
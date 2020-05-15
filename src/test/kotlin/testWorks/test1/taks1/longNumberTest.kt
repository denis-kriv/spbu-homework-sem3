package testWorks.test1.taks1

import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test


internal class longNumberTest {
    @Test
    fun plusTest() {
        val number1 = longNumber(mutableListOf(10, 100))
        val number2 = longNumber(mutableListOf(11, 100))
        val result: MutableList<Int> = mutableListOf(21, 200)
        number1.plus(number2)
        assertIterableEquals(number1.value, result)
    }

    @Test
    fun minusTest() {
        val number1 = longNumber(mutableListOf(10, 100))
        val number2 = longNumber(mutableListOf(9, 100))
        val result: MutableList<Int> = mutableListOf(19, 200)
        number1.minus(number2)
        assertIterableEquals(number1.value, result)
    }

    @Test
    fun multiplicationTest() {
        val number1 = longNumber(mutableListOf(10, 100))
        val number2 = longNumber(mutableListOf(11, 111))
        val result: MutableList<Int> = mutableListOf(112, 221, 100)
        number1.multiplication(number2)
        assertIterableEquals(number1.value, result)
    }
}
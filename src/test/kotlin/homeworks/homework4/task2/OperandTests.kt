package homeworks.homework4.task2

import homeworks.homework4.task2.models.Operand
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OperandTests {

    @Test
    fun toIntShouldReturnsRightValueWhenValuePositively() {
        val operand = Operand(10)

        assertEquals(10, operand.toInt())
    }

    @Test
    fun toIntShouldReturnsRightValueWhenValueIsZero() {
        val operand = Operand(0)

        assertEquals(0, operand.toInt())
    }

    @Test
    fun toIntShouldReturnsRightValueWhenValueNegatively() {
        val operand = Operand(-111110)

        assertEquals(-111110, operand.toInt())
    }

    @Test
    fun toStringShouldReturnsRightValueWhenValuePositively() {
        val operand = Operand(10)

        assertEquals("10", operand.toString())
    }

    @Test
    fun toStringShouldReturnsRightValueWhenValueIsZero() {
        val operand = Operand(0)

        assertEquals("0", operand.toString())
    }

    @Test
    fun toStringShouldReturnsRightValueWhenValueNegatively() {
        val operand = Operand(-111110)

        assertEquals("-111110", operand.toString())
    }
}

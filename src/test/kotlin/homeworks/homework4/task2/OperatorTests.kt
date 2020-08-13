package homeworks.homework4.task2

import homeworks.homework4.task2.models.Operand
import homeworks.homework4.task2.models.Operator
import homeworks.homework4.task2.models.Operators
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.ArithmeticException

internal class OperatorTests {

    @Test
    fun toIntForMultiplyingShouldReturnsRightValueWhenLeftChildPositivelyAndRightChildPositively() {
        val left = Operand(100)
        val right = Operand(123)

        val operator = Operator(Operators.Multiplying, left, right)

        assertEquals(12300, operator.toInt())
    }

    @Test
    fun toIntForMultiplyingShouldReturnsRightValueWhenLeftChildPositivelyAndRightChildIsZero() {
        val left = Operand(100)
        val right = Operand(0)

        val operator = Operator(Operators.Multiplying, left, right)

        assertEquals(0, operator.toInt())
    }

    @Test
    fun toIntForMultiplyingShouldReturnsRightValueWhenLeftChildPositivelyAndRightChildNegatively() {
        val left = Operand(100)
        val right = Operand(-123)

        val operator = Operator(Operators.Multiplying, left, right)

        assertEquals(-12300, operator.toInt())
    }

    @Test
    fun toIntForAdditionShouldReturnsRightValueWhenLeftChildIsZeroAndRightChildPositively() {
        val left = Operand(0)
        val right = Operand(123)

        val operator = Operator(Operators.Addition, left, right)

        assertEquals(123, operator.toInt())
    }

    @Test
    fun toIntForAdditionShouldReturnsRightValueWhenLeftChildNegativelyAndRightChildPositively() {
        val left = Operand(-100)
        val right = Operand(123)

        val operator = Operator(Operators.Addition, left, right)

        assertEquals(23, operator.toInt())
    }

    @Test
    fun toIntForAdditionShouldReturnsRightValueWhenLeftChildIsZeroAndRightChildNegatively() {
        val left = Operand(0)
        val right = Operand(-123)

        val operator = Operator(Operators.Addition, left, right)

        assertEquals(-123, operator.toInt())
    }

    @Test
    fun toIntForSubtractionShouldReturnsRightValueWhenLeftChildIsZeroAndRightChildIsZero() {
        val left = Operand(0)
        val right = Operand(0)

        val operator = Operator(Operators.Subtraction, left, right)

        assertEquals(0, operator.toInt())
    }

    @Test
    fun toIntForSubtractionShouldReturnsRightValueWhenLeftChildNegativelyAndRightChildIsZero() {
        val left = Operand(-100)
        val right = Operand(0)

        val operator = Operator(Operators.Subtraction, left, right)

        assertEquals(-100, operator.toInt())
    }

    @Test
    fun toIntForSubtractionShouldReturnsRightValueWhenLeftChildNegativelyAndRightChildNegatively() {
        val left = Operand(-100)
        val right = Operand(-123)

        val operator = Operator(Operators.Subtraction, left, right)

        assertEquals(23, operator.toInt())
    }

    @Test
    fun toIntForDividingShouldReturnsRightValueWhenLeftChildPositivelyAndRightChildPositively() {
        val left = Operand(1000)
        val right = Operand(200)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals(5, operator.toInt())
    }

    @Test
    fun toIntForDividingShouldThrowsArithmeticExceptionWhenLeftChildPositivelyAndRightChildIsZero() {
        val left = Operand(1001)
        val right = Operand(0)

        val operator = Operator(Operators.Dividing, left, right)

        assertThrows<ArithmeticException> { operator.toInt() }
    }

    @Test
    fun toIntForDividingShouldReturnsRightValueWhenLeftChildIsZeroAndRightChildPositively() {
        val left = Operand(0)
        val right = Operand(200)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals(0, operator.toInt())
    }

    @Test
    fun toIntForDividingShouldReturnsRightValueWhenLeftChildPositivelyAndRightChildNegatively() {
        val left = Operand(1001)
        val right = Operand(-200)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals(-5, operator.toInt())
    }

    @Test
    fun toIntForDividingShouldReturnsRightValueWhenLeftChildNegativelyAndRightChildPositively() {
        val left = Operand(-1000)
        val right = Operand(300)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals(-3, operator.toInt())
    }

    @Test
    fun toIntForDividingShouldThrowsArithmeticExceptionWhenLeftChildIsZeroAndRightChildIsZero() {
        val left = Operand(0)
        val right = Operand(0)

        val operator = Operator(Operators.Dividing, left, right)

        assertThrows<ArithmeticException> { operator.toInt() }
    }

    @Test
    fun toIntForDividingShouldReturnsRightValueWhenLeftChildIsZeroAndRightChildNegatively() {
        val left = Operand(0)
        val right = Operand(-300)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals(0, operator.toInt())
    }

    @Test
    fun toIntForDividingShouldThrowsArithmeticExceptionWhenLeftChildNegativelyAndRightChildIsZero() {
        val left = Operand(-1000)
        val right = Operand(0)

        val operator = Operator(Operators.Dividing, left, right)

        assertThrows<ArithmeticException> { operator.toInt() }
    }

    @Test
    fun toIntForDividingShouldReturnsRightValueWhenLeftChildNegativelyAndRightChildNegatively() {
        val left = Operand(-300)
        val right = Operand(-300)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals(1, operator.toInt())
    }

    @Test
    fun toStringForMultiplyingShouldReturnsRightStringWhenLeftChildPositivelyAndRightChildPositively() {
        val left = Operand(33)
        val right = Operand(200)

        val operator = Operator(Operators.Multiplying, left, right)

        assertEquals("(* 33 200)", operator.toString())
    }

    @Test
    fun toStringForMultiplyingShouldReturnsRightStringWhenLeftChildPositivelyAndRightChildIsZero() {
        val left = Operand(33)
        val right = Operand(0)

        val operator = Operator(Operators.Multiplying, left, right)

        assertEquals("(* 33 0)", operator.toString())
    }

    @Test
    fun toStringForMultiplyingShouldReturnsRightStringWhenLeftChildPositivelyAndRightChildNegatively() {
        val left = Operand(33)
        val right = Operand(-200)

        val operator = Operator(Operators.Multiplying, left, right)

        assertEquals("(* 33 -200)", operator.toString())
    }

    @Test
    fun toStringForAdditionShouldReturnsRightStringWhenLeftChildIsZeroAndRightChildPositively() {
        val left = Operand(0)
        val right = Operand(200)

        val operator = Operator(Operators.Addition, left, right)

        assertEquals("(+ 0 200)", operator.toString())
    }

    @Test
    fun toStringForAdditionShouldReturnsRightStringWhenLeftChildNegativelyAndRightChildPositively() {
        val left = Operand(-33)
        val right = Operand(200)

        val operator = Operator(Operators.Addition, left, right)

        assertEquals("(+ -33 200)", operator.toString())
    }

    @Test
    fun toStringForAdditionShouldReturnsRightStringWhenLeftChildIsZeroAndRightChildNegatively() {
        val left = Operand(0)
        val right = Operand(-200)

        val operator = Operator(Operators.Addition, left, right)

        assertEquals("(+ 0 -200)", operator.toString())
    }

    @Test
    fun toStringForSubtractionShouldReturnsRightStringWhenLeftChildIsZeroAndRightChildIsZero() {
        val left = Operand(0)
        val right = Operand(0)

        val operator = Operator(Operators.Subtraction, left, right)

        assertEquals("(- 0 0)", operator.toString())
    }

    @Test
    fun toStringForSubtractionShouldReturnsRightStringWhenLeftChildNegativelyAndRightChildIsZero() {
        val left = Operand(-33)
        val right = Operand(0)

        val operator = Operator(Operators.Subtraction, left, right)

        assertEquals("(- -33 0)", operator.toString())
    }

    @Test
    fun toStringForSubtractionShouldReturnsRightStringWhenLeftChildNegativelyAndRightChildNegatively() {
        val left = Operand(-33)
        val right = Operand(-200)

        val operator = Operator(Operators.Subtraction, left, right)

        assertEquals("(- -33 -200)", operator.toString())
    }

    @Test
    fun toStringForDividingShouldReturnsRightStringWhenLeftChildPositivelyAndRightChildPositively() {
        val left = Operand(33)
        val right = Operand(200)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals("(/ 33 200)", operator.toString())
    }

    @Test
    fun toStringForDividingShouldReturnsRightStringWhenLeftChildPositivelyAndRightChildIsZero() {
        val left = Operand(33)
        val right = Operand(0)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals("(/ 33 0)", operator.toString())
    }

    @Test
    fun toStringForDividingShouldReturnsRightStringWhenLeftChildIsZeroAndRightChildPositively() {
        val left = Operand(0)
        val right = Operand(200)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals("(/ 0 200)", operator.toString())
    }

    @Test
    fun toStringForDividingShouldReturnsRightStringWhenLeftChildPositivelyAndRightChildNegatively() {
        val left = Operand(33)
        val right = Operand(-200)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals("(/ 33 -200)", operator.toString())
    }

    @Test
    fun toStringForDividingShouldReturnsRightStringWhenLeftChildNegativelyAndRightChildPositively() {
        val left = Operand(-33)
        val right = Operand(200)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals("(/ -33 200)", operator.toString())
    }

    @Test
    fun toStringForDividingShouldReturnsRightStringWhenLeftChildIsZeroAndRightChildIsZero() {
        val left = Operand(0)
        val right = Operand(0)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals("(/ 0 0)", operator.toString())
    }

    @Test
    fun toStringForDividingShouldReturnsRightStringWhenLeftChildIsZeroAndRightChildNegatively() {
        val left = Operand(0)
        val right = Operand(-200)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals("(/ 0 -200)", operator.toString())
    }

    @Test
    fun toStringForDividingShouldReturnsRightStringWhenLeftChildNegativelyAndRightChildIsZero() {
        val left = Operand(-33)
        val right = Operand(0)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals("(/ -33 0)", operator.toString())
    }

    @Test
    fun toStringForDividingShouldReturnsRightStringWhenLeftChildNegativelyAndRightChildNegatively() {
        val left = Operand(-33)
        val right = Operand(-200)

        val operator = Operator(Operators.Dividing, left, right)

        assertEquals("(/ -33 -200)", operator.toString())
    }

    @Test
    fun toIntShouldReturnsRightValueWhenTreeIsHard() {
        val leftLeft = Operand(1000)
        val leftRight = Operand(200)
        val rightLeft = Operand(0)
        val rightRightLeft = Operand(10)
        val rightRightRight = Operand(-90)

        val leftOperator = Operator(Operators.Dividing, leftLeft, leftRight)
        val rightRightOperator = Operator(Operators.Subtraction, rightRightLeft, rightRightRight)
        val rightOperator = Operator(Operators.Addition, rightLeft, rightRightOperator)

        val operator = Operator(Operators.Multiplying, leftOperator, rightOperator)

        assertEquals(500, operator.toInt())
    }

    @Test
    fun toStringShouldReturnsRightStringWhenTreeIsHard() {
        val leftLeft = Operand(1000)
        val leftRight = Operand(200)
        val rightLeft = Operand(0)
        val rightRightLeft = Operand(10)
        val rightRightRight = Operand(-90)

        val leftOperator = Operator(Operators.Dividing, leftLeft, leftRight)
        val rightRightOperator = Operator(Operators.Subtraction, rightRightLeft, rightRightRight)
        val rightOperator = Operator(Operators.Addition, rightLeft, rightRightOperator)

        val operator = Operator(Operators.Multiplying, leftOperator, rightOperator)

        assertEquals("(* (/ 1000 200) (+ 0 (- 10 -90)))", operator.toString())
    }
}

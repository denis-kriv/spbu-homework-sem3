package tests.reExam

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.sqrt

data class ExampleValue(private val value: Int) : Ordered<ExampleValue> {
    override fun plus(other: ExampleValue): ExampleValue {
        return ExampleValue(value + other.value)
    }

    override fun minus(other: ExampleValue): ExampleValue {
        return ExampleValue(value - other.value)
    }

    override fun times(other: ExampleValue): ExampleValue {
        return ExampleValue(value * other.value)
    }

    override fun sqrt(): ExampleValue {
        return ExampleValue(sqrt(value.toDouble()).toInt())
    }

    override fun isZero(): Boolean {
        return value == 0
    }

    fun getValue(): Int {
        return value
    }
}

class VectorTests {

    @Test
    fun `plus should throws exception when vector sizes are not equals`() {
        val coordinates1 = listOf(ExampleValue(1), ExampleValue(2))
        val coordinates2 = listOf(ExampleValue(1), ExampleValue(2), ExampleValue(3))

        val vector1 = Vector(coordinates1)
        val vector2 = Vector(coordinates2)

        assertThrows<ArithmeticException> { vector1 + vector2 }
    }

    @Test
    fun `plus should works correctly when data is correct`() {
        val coordinates1 = listOf(ExampleValue(1), ExampleValue(2))
        val coordinates2 = listOf(ExampleValue(1), ExampleValue(2))

        val vector1 = Vector(coordinates1)
        val vector2 = Vector(coordinates2)

        val result = vector1 + vector2

        assertIterableEquals(listOf(ExampleValue(2), ExampleValue(4)), result.getCoordinates())
    }

    @Test
    fun `minus Should Throws Exception When Vector Sizes Are Not Equals`() {
        val coordinates1 = listOf(ExampleValue(1), ExampleValue(2))
        val coordinates2 = listOf(ExampleValue(1), ExampleValue(2), ExampleValue(3))

        val vector1 = Vector(coordinates1)
        val vector2 = Vector(coordinates2)

        assertThrows<ArithmeticException> { vector1 - vector2 }
    }

    @Test
    fun `minus should works correctly when data is correct`() {
        val coordinates1 = listOf(ExampleValue(1), ExampleValue(2))
        val coordinates2 = listOf(ExampleValue(1), ExampleValue(3))

        val vector1 = Vector(coordinates1)
        val vector2 = Vector(coordinates2)

        val result = vector1 - vector2

        assertIterableEquals(listOf(ExampleValue(0), ExampleValue(-1)), result.getCoordinates())
    }

    @Test
    fun `times Should Throws Exception When Vector Sizes Are Not Equals`() {
        val coordinates1 = listOf(ExampleValue(1), ExampleValue(2))
        val coordinates2 = listOf(ExampleValue(1), ExampleValue(2), ExampleValue(3))

        val vector1 = Vector(coordinates1)
        val vector2 = Vector(coordinates2)

        assertThrows<ArithmeticException> { vector1 * vector2 }
    }

    @Test
    fun `times should works correctly when data is correct`() {
        val coordinates1 = listOf(ExampleValue(1), ExampleValue(2))
        val coordinates2 = listOf(ExampleValue(1), ExampleValue(2))

        val vector1 = Vector(coordinates1)
        val vector2 = Vector(coordinates2)

        assertEquals(ExampleValue(5), vector1 * vector2)
    }

    @Test
    fun `norma should works correctly when data is correct`() {
        val coordinates = listOf(ExampleValue(-3), ExampleValue(4))

        val vector = Vector(coordinates)

        assertEquals(ExampleValue(5), vector.norma())
    }

    @Test
    fun `isZero should return false when vector is not zero`() {
        val coordinates = listOf(ExampleValue(-3), ExampleValue(4), ExampleValue(10))

        val vector = Vector(coordinates)

        assertFalse(vector.isZero())
    }

    @Test
    fun `isZero should return true when vector is zero`() {
        val coordinates = listOf(ExampleValue(0), ExampleValue(0), ExampleValue(0))

        val vector = Vector(coordinates)

        assertTrue(vector.isZero())
    }

    @Test
    fun `clone should works correctly when data is correct`() {
        val coordinates = listOf(ExampleValue(0), ExampleValue(0), ExampleValue(0))

        val vector = Vector(coordinates)

        assertIterableEquals(coordinates, vector.clone().getCoordinates())
    }

    @Test
    fun `getCoordinates should works correctly when data is correct`() {
        val coordinates = listOf(ExampleValue(0), ExampleValue(0), ExampleValue(0))

        val vector = Vector(coordinates)

        assertIterableEquals(coordinates, vector.getCoordinates())
    }
}

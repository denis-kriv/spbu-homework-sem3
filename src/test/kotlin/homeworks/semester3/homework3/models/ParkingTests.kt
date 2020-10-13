package homeworks.semester3.homework3.models

import homeworks.semester3.homework3.task1.models.Automate
import homeworks.semester3.homework3.task1.models.Parking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.random.Random

class SimpleAutomate(override val parking: Parking) : Automate {

    override fun addCar(): Boolean {
        return parking.newCar()
    }

    override fun removeCar() {
        parking.register()
    }
}

class ParkingTests {

    @Test
    fun `newCar should return true when parking contain empty places`() {
        val parking = Parking(10)

        assertTrue(parking.newCar())
    }

    @Test
    fun `newCar should return false when parking does not contain empty places`() {
        val parking = Parking(0)

        assertFalse(parking.newCar())
    }

    @Test
    fun `newCar should return true cars while parking contain empty places`() {
        val parking = Parking(10)

        val result = mutableListOf<Boolean>()
        for (i in 0..10) result.add(parking.newCar())

        val expected = List(11) { it < 10 }

        assertIterableEquals(result, expected)
    }

    @Test
    fun `newCar should add cars`() {
        val parking = Parking(100)

        for (i in 0 until 20) parking.newCar()

        assertEquals(parking.getCurrentPlacesQuantity(), 20)
    }

    @Test
    fun `register should throw ArithmeticException when parking is empty`() {
        val parking = Parking(20)

        assertThrows<ArithmeticException> { parking.register() }
    }

    @Test
    fun `register should register cars when parking is not empty`() {
        val parking = Parking(1000)

        parking.newCar()

        assertDoesNotThrow { parking.register() }
    }

    @Test
    fun `register should register cars while parking contain cars`() {
        val parking = Parking(100)

        for (i in 0 until 10) parking.newCar()

        val result = mutableListOf<Boolean>()
        val expected = List(11) { it < 10 }

        for (i in 0..10) {
            var success = true

            try {
                parking.register()
            } catch (e: ArithmeticException) {
                success = false
            }

            result.add(success)
        }

        assertIterableEquals(result, expected)
    }

    @Test
    fun `register should remove cars`() {
        val parking = Parking(10000)

        for (i in 0 until 20) parking.newCar()
        for (i in 0 until 10) parking.register()

        assertEquals(parking.getCurrentPlacesQuantity(), 10)
    }

    @Test
    fun `getCurrentPlaces should return zero when parking is empty`() {
        val parking = Parking(500)

        assertEquals(parking.getCurrentPlacesQuantity(), 0)
    }

    @Test
    fun `getCurrentPlaces should return right value when parking is not empty`() {
        val parking = Parking(100)

        for (i in 0 until 10) parking.newCar()

        assertEquals(parking.getCurrentPlacesQuantity(), 10)
    }

    @Test
    fun `getCurrentPlaces should return right value when parking does not contain empty places`() {
        val parking = Parking(600)

        for (i in 0 until 600) parking.newCar()

        assertEquals(parking.getCurrentPlacesQuantity(), 600)
    }

    @Test
    fun `newCar and register should work correctly async`() {
        val parking = Parking(100000)
        var result = 1000

        for (i in 0 until 1000) parking.newCar()

        val threads = List(10) {
            when (Random.nextDouble()) {
                in 0.0..0.3 -> {
                    result += 49
                    Thread { for (i in 0..100) if (i % 4 == 0) parking.register() else parking.newCar() }
                }

                in 0.4..0.6 -> {
                    result += 33
                    Thread { for (i in 0..100) if (i % 3 == 0) parking.register() else parking.newCar() }
                }

                else -> {
                    result -= 1
                    Thread { for (i in 0..100) if (i % 2 == 0) parking.register() else parking.newCar() }
                }
            }
        }
        threads.forEach { it.start() }

        Thread.sleep(1000)

        assertEquals(parking.getCurrentPlacesQuantity(), result)
    }

    @Test
    fun `parking should correctly work with some automates`() {
        val parking = Parking(50000)
        val automates = List(20) { SimpleAutomate(parking) }
        var result = 1000

        for (i in 0 until 1000) parking.newCar()

        val threads = List(20) {
            when (Random.nextDouble()) {
                in 0.0..0.3 -> {
                    result += 49
                    Thread {
                        for (i in 0..100) {
                            if (i % 4 == 0) automates[it].parking.register() else automates[it].parking.newCar()
                        }
                    }
                }

                in 0.4..0.6 -> {
                    result += 33
                    Thread {
                        for (i in 0..100) {
                            if (i % 3 == 0) automates[it].parking.register() else automates[it].parking.newCar()
                        }
                    }
                }

                else -> {
                    result -= 1
                    Thread {
                        for (i in 0..100) {
                            if (i % 2 == 0) automates[it].parking.register() else automates[it].parking.newCar()
                        }
                    }
                }
            }
        }
        threads.forEach { it.start() }

        Thread.sleep(1000)

        assertEquals(parking.getCurrentPlacesQuantity(), result)
    }
}

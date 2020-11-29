package homework4.task1

import homeworks.homework4.task1.hashFunctions.AdjacentCharactersHashFunction
import homeworks.homework4.task1.hashFunctions.PolynomialHashFunction
import homeworks.homework4.task1.hashFunctions.QuadraticHashFunction
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class HashFunctionsTests {

    private val randomString1 = String(ByteArray((Math.random() * 1000).toInt()) { (Math.random() * 10).toByte() })
    private val randomString2 = String(ByteArray((Math.random() * 1000).toInt()) { (Math.random() * 10).toByte() })

    @Test
    fun adjacentCharactersHashFunctionShouldCreateDifferentHashCodesForRandomStrings() {
        val function = AdjacentCharactersHashFunction()

        assertNotEquals(function.getHash(randomString1, 53), function.getHash(randomString2, 53))
    }

    @Test
    fun quadraticHashFunctionShouldCreateDifferentHashCodesForRandomStrings() {
        val function = QuadraticHashFunction()

        assertNotEquals(function.getHash(randomString1, 47), function.getHash(randomString2, 47))
    }

    @Test
    fun polynomialHashFunctionShouldCreateDifferentHashCodesForRandomStrings() {
        val function = PolynomialHashFunction(13)

        assertNotEquals(function.getHash(randomString1, 59), function.getHash(randomString2, 59))
    }
}

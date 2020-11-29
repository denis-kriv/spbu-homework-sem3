package homework4.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class HashFunctionsTests {

    private val randomString1: String = String(ByteArray((Math.random() * 1000).toInt()) {(Math.random() * 10).toByte()})
    private val randomString2: String = String(ByteArray((Math.random() * 1000).toInt()) {(Math.random() * 10).toByte()})

    @Test
    fun getHashWithKey3ShouldReturnsDifferentIndexesForTwoRandomStrings() {
        val hashFunction = HashFunctions(HashKeys.Hash3)

        assertFalse(hashFunction.getHash(randomString1) == hashFunction.getHash(randomString2))
    }

    @Test
    fun getHashWithKey3ShouldReturnsOneIndexForOneString() {
        val hashFunction = HashFunctions(HashKeys.Hash3)

        assertEquals(hashFunction.getHash(randomString1), hashFunction.getHash(randomString1))
    }

    @Test
    fun getHashWithKey3ShouldCreatesCollisionForTwoSpecialStrings() {
        val hashFunction = HashFunctions(HashKeys.Hash3)

        val specialString1 = "ddd"
        val specialString2 = "pcc"

        assertEquals(hashFunction.getHash(specialString1), hashFunction.getHash(specialString2))
    }

    @Test
    fun getHashWithKey5ShouldReturnsDifferentIndexesForTwoRandomStrings() {
        val hashFunction = HashFunctions(HashKeys.Hash5)

        assertFalse(hashFunction.getHash(randomString1) == hashFunction.getHash(randomString2))
    }

    @Test
    fun getHashWithKey5ShouldReturnsOneIndexForOneString() {
        val hashFunction = HashFunctions(HashKeys.Hash5)

        assertEquals(hashFunction.getHash(randomString1), hashFunction.getHash(randomString1))
    }

    @Test
    fun getHashWithKey5ShouldCreatesCollisionForTwoSpecialStrings() {
        val hashFunction = HashFunctions(HashKeys.Hash5)

        val specialString1 = "222"
        val specialString2 = "P11"

        assertEquals(hashFunction.getHash(specialString1), hashFunction.getHash(specialString2))
    }

    @Test
    fun getHashWithKey7ShouldReturnsDifferentIndexesForTwoRandomStrings() {
        val hashFunction = HashFunctions(HashKeys.Hash7)

        assertFalse(hashFunction.getHash(randomString1) == hashFunction.getHash(randomString2))
    }

    @Test
    fun getHashWithKey7ShouldReturnsOneIndexForOneString() {
        val hashFunction = HashFunctions(HashKeys.Hash7)

        assertEquals(hashFunction.getHash(randomString1), hashFunction.getHash(randomString1))
    }

    @Test
    fun getHashWithKey7ShouldCreatesCollisionForTwoSpecialStrings() {
        val hashFunction = HashFunctions(HashKeys.Hash7)

        val specialString1 = "222"
        val specialString2 = "j11"

        assertEquals(hashFunction.getHash(specialString1), hashFunction.getHash(specialString2))
    }

    @Test
    fun getHashWithKey11ShouldReturnsDifferentIndexesForTwoRandomStrings() {
        val hashFunction = HashFunctions(HashKeys.Hash11)

        assertFalse(hashFunction.getHash(randomString1) == hashFunction.getHash(randomString2))
    }

    @Test
    fun getHashWithKey11ShouldReturnsOneIndexForOneString() {
        val hashFunction = HashFunctions(HashKeys.Hash11)

        assertEquals(hashFunction.getHash(randomString1), hashFunction.getHash(randomString1))
    }

    @Test
    fun getHashWithKey11ShouldCreatesCollisionForTwoSpecialStrings() {
        val hashFunction = HashFunctions(HashKeys.Hash11)

        val specialString1 = "dd"
        val specialString2 = "oc"

        assertEquals(hashFunction.getHash(specialString1), hashFunction.getHash(specialString2))
    }
}

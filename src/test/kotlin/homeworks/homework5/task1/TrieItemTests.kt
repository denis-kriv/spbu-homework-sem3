package homeworks.homework5.task1

import homeworks.homework5.task1.models.TrieItem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TrieItemTests {

    @Test
    fun plusShouldReturnsTrueWhenStringIsNotEmptyAndWordDoesNotExist() {
        val item = TrieItem("e")

        assertTrue(item.plus("example"))
    }

    @Test
    fun plusShouldReturnsTrueWhenAFewDifferentWordsAreAdded() {
        val item = TrieItem("e")

        assertTrue(item.plus("exa"))
        assertTrue(item.plus("examp"))
        assertTrue(item.plus("example"))
        assertTrue(item.plus("exceptions"))
        assertTrue(item.plus("excep"))
    }

    @Test
    fun plusShouldReturnsFalseWhenStringIsNotEmptyAndWordExist() {
        val item = TrieItem("e")

        item.plus("example")

        assertFalse(item.plus("example"))
    }

    @Test
    fun isExistShouldReturnsTrueWhenStringIsEmptyAndWordExist() {
        val item = TrieItem("")

        item.plus("")

        assertTrue(item.isExist(""))
    }

    @Test
    fun isExistShouldReturnsTrueWhenStringIsNotEmptyAndWordExist() {
        val item = TrieItem("e")

        item.plus("example")

        assertTrue(item.isExist("example"))
    }

    @Test
    fun isExistShouldReturnsFalseWhenStringIsNotEmptyAndWordDoesNotExist() {
        val item = TrieItem("a")

        assertFalse(item.isExist("example"))
    }

    @Test
    fun minusShouldReturnsFalseWhenStringIsNotEmptyAndWordDoesNotExist() {
        val item = TrieItem("e")

        assertFalse(item.minus("example"))
    }

    @Test
    fun minusShouldReturnsTrueWhenStringIsEmptyAndWordExist() {
        val item = TrieItem("e")

        item.plus("")

        assertTrue(item.minus(""))
    }

    @Test
    fun minusShouldReturnsTrueWhenStringIsNotEmptyAndWordExist() {
        val item = TrieItem("e")

        item.plus("example")

        assertTrue(item.minus("example"))
    }

    @Test
    fun sizeShouldReturnsZeroWhenTreeIsEmpty() {
        val tree = Trie()

        Assertions.assertEquals(0, tree.size())
    }

    @Test
    fun sizeShouldReturnsRightValueWhenTreeIsNotEmptyAndEmptyWordExist() {
        val item = TrieItem("e")

        item.plus("exa")
        item.plus("exam")
        item.plus("example")
        item.plus("exceptions")
        item.plus("exception")

        Assertions.assertEquals(5, item.size())
    }

    @Test
    fun quantityWithThisPrefixShouldReturnsZeroWhenTreeIsEmpty() {
        val item = TrieItem("p")

        assertEquals(0, item.quantityWithThisPrefix("prefix"))
    }

    @Test
    fun quantityWithThisPrefixShouldReturnsRightValueWhenWordsWithThisPrefixDoesNotExist() {
        val item = TrieItem("e")

        item.plus("example")
        item.plus("exam")

        assertEquals(0, item.quantityWithThisPrefix("exception"))
    }

    @Test
    fun getAllWordsShouldFillStreamWhenTreeIsNotEmpty() {
        val item = TrieItem("e")

        item.plus("exa")
        item.plus("exam")
        item.plus("example")
        item.plus("exceptions")
        item.plus("exception")

        val expected = mutableListOf("exa", "exam", "example", "exceptions", "exception")
        val result = item.getAllWords("")

        expected.forEach {
            assertTrue(result.contains(it))
        }
    }
}
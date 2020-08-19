package homeworks.homework5.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.*

class BorTreeTests {

    @Test
    fun addShouldReturnsTrueWhenStringIsEmptyAndWordDoesNotExist() {
        val tree = BorTree()

        assertTrue(tree.add(""))
    }

    @Test
    fun addShouldReturnsTrueWhenStringIsNotEmptyAndWordDoesNotExist() {
        val tree = BorTree()

        assertTrue(tree.add("example"))
    }

    @Test
    fun addShouldReturnsTrueWhenAFewDifferentWordsAreAdded() {
        val tree = BorTree()

        assertTrue(tree.add(""))
        assertTrue(tree.add("e"))
        assertTrue(tree.add("exa"))
        assertTrue(tree.add("examp"))
        assertTrue(tree.add("example"))
        assertTrue(tree.add("exceptions"))
        assertTrue(tree.add("excep"))
        assertTrue(tree.add("kotlin"))
        assertTrue(tree.add("kotl"))
        assertTrue(tree.add("ko"))
    }

    @Test
    fun addShouldReturnsFalseWhenStringIsEmptyAndWordExist() {
        val tree = BorTree()

        tree.add("")

        assertFalse(tree.add(""))
    }

    @Test
    fun addShouldReturnsFalseWhenStringIsNotEmptyAndWordExist() {
        val tree = BorTree()

        tree.add("example")

        assertFalse(tree.add("example"))
    }

    @Test
    fun containsShouldReturnsTrueWhenStringIsEmptyAndWordExist() {
        val tree = BorTree()

        tree.add("")

        assertTrue(tree.contains(""))
    }

    @Test
    fun containsShouldReturnsFalseWhenStringIsEmptyAndWordDoesNotExist() {
        val tree = BorTree()

        assertFalse(tree.contains(""))
    }

    @Test
    fun containsShouldReturnsTrueWhenStringIsNotEmptyAndWordExist() {
        val tree = BorTree()

        tree.add("example")

        assertTrue(tree.contains("example"))
    }

    @Test
    fun containsShouldReturnsFalseWhenStringIsNotEmptyAndWordDoesNotExist() {
        val tree = BorTree()

        assertFalse(tree.contains("example"))
    }

    @Test
    fun removeShouldReturnsFalseWhenStringIsEmptyAndWordDoesNotExist() {
        val tree = BorTree()

        assertFalse(tree.remove(""))
    }

    @Test
    fun removeShouldReturnsFalseWhenStringIsNotEmptyAndWordDoesNotExist() {
        val tree = BorTree()

        assertFalse(tree.remove("example"))
    }

    @Test
    fun removeShouldReturnsTrueWhenStringIsEmptyAndWordExist() {
        val tree = BorTree()

        tree.add("")

        assertTrue(tree.remove(""))
    }

    @Test
    fun removeShouldReturnsTrueWhenStringIsNotEmptyAndWordExist() {
        val tree = BorTree()

        tree.add("example")

        assertTrue(tree.remove("example"))
    }

    @Test
    fun removeShouldReturnsTrueAndThanFalseWhenTheSameWordIsDeletedSeveralTimes() {
        val tree = BorTree()

        tree.add("example")

        assertTrue(tree.remove("example"))
        assertFalse(tree.remove("example"))
    }

    @Test
    fun sizeShouldReturnsZeroWhenTreeIsEmpty() {
        val tree = BorTree()

        assertEquals(0, tree.size())
    }

    @Test
    fun sizeShouldReturnsRightValueWhenTreeIsNotEmptyAndEmptyWordExist() {
        val tree = BorTree()

        tree.add("")
        tree.add("e")
        tree.add("exa")
        tree.add("examp")
        tree.add("example")
        tree.add("exceptions")
        tree.add("excep")
        tree.add("kotlin")
        tree.add("kotl")
        tree.add("ko")

        assertEquals(10, tree.size())
    }

    @Test
    fun sizeShouldReturnsRightValueWhenTreeIsNotEmptyAndEmptyWordDoesNotExist() {
        val tree = BorTree()

        tree.add("e")
        tree.add("exa")
        tree.add("examp")
        tree.add("example")
        tree.add("exceptions")
        tree.add("excep")
        tree.add("kotlin")
        tree.add("kotl")
        tree.add("ko")

        assertEquals(9, tree.size())
    }

    @Test
    fun howManyStartWithPrefixShouldReturnsZeroWhenTreeIsEmpty() {
        val tree = BorTree()

        assertEquals(0, tree.howManyStartWithPrefix("prefix"))
    }

    @Test
    fun howManyStartWithPrefixShouldReturnsRightValueWhenPrefixIsEmpty() {
        val tree = BorTree()

        tree.add("")
        tree.add("e")
        tree.add("exa")
        tree.add("examp")
        tree.add("example")
        tree.add("exceptions")
        tree.add("excep")
        tree.add("kotlin")
        tree.add("kotl")
        tree.add("ko")

        assertEquals(10, tree.howManyStartWithPrefix(""))
    }

    @Test
    fun howManyStartWithPrefixShouldReturnsRightValueWhenWordsWithThisPrefixDoesNotExist() {
        val tree = BorTree()

        tree.add("")
        tree.add("e")
        tree.add("exa")
        tree.add("examp")
        tree.add("example")
        tree.add("exceptions")
        tree.add("excep")
        tree.add("kotlin")
        tree.add("kotl")
        tree.add("ko")

        assertEquals(0, tree.howManyStartWithPrefix("prefix"))
    }

    @Test
    fun howManyStartWithPrefixShouldReturnsRightValueWhenWordsWithThisPrefixExist() {
        val tree = BorTree()

        tree.add("")
        tree.add("e")
        tree.add("exa")
        tree.add("examp")
        tree.add("example")
        tree.add("exceptions")
        tree.add("excep")
        tree.add("kotlin")
        tree.add("kotl")
        tree.add("ko")

        assertEquals(6, tree.howManyStartWithPrefix("e"))
    }

    @Test
    fun serializeShouldThrowsIOExceptionWhenTreeIsEmpty() {
        val tree = BorTree()
        val stream = FileOutputStream("src/test/kotlin/homeworks/homework5/task1/data/serializeFile.txt")

        assertThrows<IOException> { tree.serialize(stream) }
    }

    @Test
    fun serializeShouldFillStreamWhenTreeIsNotEmpty() {
        val tree = BorTree()
        val stream = FileOutputStream("src/test/kotlin/homeworks/homework5/task1/data/serializeFile.txt")

        tree.add("")
        tree.add("e")
        tree.add("exa")
        tree.add("examp")
        tree.add("example")
        tree.add("exceptions")
        tree.add("excep")
        tree.add("kotlin")
        tree.add("kotl")
        tree.add("ko")

        assertDoesNotThrow { tree.serialize(stream) }
    }

    @Test
    fun deserializeShouldThrowsKotlinNullPointerExceptionWhenTreeIsEmpty() {
        val tree = BorTree()
        val stream = FileInputStream("src/test/kotlin/homeworks/homework5/task1/data/deserializeEmptyFile.txt")

        assertThrows<KotlinNullPointerException> { tree.deserialize(stream) }
    }

    @Test
    fun deserializeShouldThrowsIOExceptionWhenStringIsNotCorrect() {
        val tree = BorTree()
        val stream = FileInputStream("src/test/kotlin/homeworks/homework5/task1/data/deserializeIncorrectFile.txt")

        assertThrows<IOException> { tree.deserialize(stream) }
    }

    @Test
    fun deserializeShouldFillTreeWhenFileIsCorrect() {
        val tree = BorTree()
        val stream = FileInputStream("src/test/kotlin/homeworks/homework5/task1/data/deserializeCorrectFile.txt")

        assertDoesNotThrow { tree.deserialize(stream) }

        assertTrue(tree.contains(""))
        assertTrue(tree.contains("e"))
        assertTrue(tree.contains("exa"))
        assertTrue(tree.contains("examp"))
        assertTrue(tree.contains("example"))
        assertTrue(tree.contains("exceptions"))
        assertTrue(tree.contains("excep"))
        assertTrue(tree.contains("kotlin"))
        assertTrue(tree.contains("kotl"))
        assertTrue(tree.contains("ko"))
    }
}

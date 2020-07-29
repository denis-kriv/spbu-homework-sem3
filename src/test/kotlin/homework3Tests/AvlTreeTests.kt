package homework3Tests

import homeworks.homework3.AvlTree
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AvlTreeTests {

    @Test
    fun isEmptyShouldReturnsTrueWhenHeadIsNull() {
        val tree = AvlTree(1, 1)
        tree.minus(1)
        assertTrue(tree.isEmpty())
    }

    @Test
    fun isEmptyShouldReturnsFalseWhenHeadIsNotNull() {
        val tree = AvlTree(1, 1)
        assertFalse(tree.isEmpty())
    }

    @Test
    fun getShouldReturnsNullWhenKeyDoesNotExist() {
        val tree = AvlTree(1, 1)
        assertEquals(null, tree[3])
    }

    @Test
    fun getShouldReturnsValueWhenKeyIsHead() {
        val tree = AvlTree(1, 1)
        assertEquals(1, tree[1])
    }

    @Test
    fun getShouldReturnsValueWhenKeyExist() {
        val tree = AvlTree(1, 1)
        tree.plus(2 to 2)
        assertEquals(2, tree.get(2))
    }

    @Test
    fun containsKeyShouldReturnsTrueWhenKeyExist() {
        val tree = AvlTree(1, 1)
        tree.plus(2 to 2)
        tree.plus(0 to 0)
        assertTrue(tree.containsKey(0))
    }

    @Test
    fun containsKeyShouldReturnsFalseWhenKeyDoesNotExist() {
        val tree = AvlTree(1, 1)
        assertFalse(tree.containsKey(0))
    }

    @Test
    fun containsValueShouldReturnsTrueWhenKeyExist() {
        val tree = AvlTree(1, 1)
        assertTrue(tree.containsValue(1))
    }

    @Test
    fun containsValueShouldReturnsFalseWhenKeyDoesNotExist() {
        val tree = AvlTree(1, 1)
        assertFalse(tree.containsKey(5))
    }

    @Test
    fun plusShouldThrowsExceptionWhenKeyExist() {
        val tree = AvlTree(1, 1)
        assertThrows<Exception> { tree.plus(1 to 2) }
    }

    @Test
    fun plusShouldAddItemWhenHeadIsNull() {
        val tree = AvlTree(1, 1)
        tree.minus(1)
        tree.plus(2 to 2)
        assertEquals(setOf(2), tree.keys)
        assertEquals(listOf(2), tree.values)
        assertEquals(1, tree.size)
    }

    @Test
    fun plusShouldAddItemWhenDataIsCorrect() {
        val tree = AvlTree(1, 1)
        tree.plus(2 to 2)
        tree.plus(3 to 3)
        tree.plus(4 to 4)
        tree.plus(5 to 5)
        tree.plus(6 to 6)
        assertEquals(setOf(1, 2, 3, 4, 5, 6), tree.keys)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), tree.values)
        assertEquals(6, tree.size)
    }

    @Test
    fun minusShouldThrowsExceptionWhenHeadIsNull() {
        val tree = AvlTree(1, 1)
        tree.minus(1)
        assertThrows<NullPointerException> { tree.minus(2) }
    }

    @Test
    fun minusShouldThrowsExceptionWhenKeyDoesNotExist() {
        val tree = AvlTree(1, 1)
        assertThrows<NoSuchElementException> { tree.minus(2) }
    }

    @Test
    fun minusShouldRemoveItemWhenItemIsHead() {
        val tree = AvlTree(1, 1)
        tree.minus(1)
        val resultKeys: Set<Int> = setOf()
        val resultValues: List<Int> = listOf()
        assertEquals(resultKeys, tree.keys)
        assertEquals(resultValues, tree.values)
        assertEquals(0, tree.size)
    }

    @Test
    fun minusShouldRemoveItemWhenDataIsCorrect() {
        val tree = AvlTree(1, 1)
        tree.plus(2 to 2)
        tree.plus(3 to 3)
        tree.plus(4 to 4)
        tree.plus(5 to 5)
        tree.plus(6 to 6)
        tree.minus(4 )
        tree.minus(2)
        assertEquals(setOf(1, 3, 5, 6), tree.keys)
        assertEquals(listOf(1, 3, 5, 6), tree.values)
        assertEquals(4, tree.size)
    }
}
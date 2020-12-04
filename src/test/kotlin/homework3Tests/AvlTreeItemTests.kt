package homework3Tests

import homeworks.homework3.task1.AvlTreeItem
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class AvlTreeItemTests {

    @Test
    fun getValueByKeyShouldReturnsNullWhenKeyDoesNotExist() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        val item3 = AvlTreeItem(3, 3)
        item2.leftChild = item1
        item2.rightChild = item3
        item2.height = 2
        assertEquals(null, item2.getValueByKey(4))
    }

    @Test
    fun getValueByKeyShouldReturnsValueWhenKeyIsHead() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        val item3 = AvlTreeItem(3, 3)
        item2.leftChild = item1
        item2.rightChild = item3
        item2.height = 2
        assertEquals(2, item2.getValueByKey(2))
    }

    @Test
    fun getValueByKeyShouldReturnsValueWhenKeyExist() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        val item3 = AvlTreeItem(3, 3)
        item2.leftChild = item1
        item2.rightChild = item3
        item2.height = 2
        assertEquals(3, item2.getValueByKey(3))
    }

    @Test
    fun insertShouldAddItemWhenDataIsCorrect() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)

        item2.leftChild = item1

        assertEquals(item1, item2.insert(Pair(0, 0)))
    }

    @Test
    fun removeShouldThrowsExceptionWhenKeyDoesNotExist() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        val item3 = AvlTreeItem(3, 3)

        item2.leftChild = item1
        item2.rightChild = item3
        item2.height = 2

        assertThrows<NoSuchElementException> { item2.remove(5) }
    }

    @Test
    fun removeShouldRemoveItemWhenItemIsHead() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        val item3 = AvlTreeItem(3, 3)

        item2.leftChild = item1
        item2.rightChild = item3
        item2.height = 2

        assertEquals(item3, item2.remove(2))
    }

    @Test
    fun removeShouldRemoveItemWhenDataIsCorrect() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        val item3 = AvlTreeItem(3, 3)

        item2.leftChild = item1
        item2.rightChild = item3
        item2.height = 2

        assertEquals(item2, item2.remove(1))
    }

    @Test
    fun balanceShouldNotChangeHeightWhenBalanceFactorIsMinusOne() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        item2.leftChild = item1
        item2.height = 2
        item2.balance()
        assertEquals(2, item2.height)
    }

    @Test
    fun balanceShouldNotChangeHeightWhenBalanceFactorIsOne() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        item1.rightChild = item2
        item1.height = 2
        item1.balance()
        assertEquals(2, item1.height)
    }

    @Test
    fun balanceShouldNotChangeHeightWhenBalanceFactorIsZero() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        val item3 = AvlTreeItem(3, 3)
        item2.leftChild = item1
        item2.rightChild = item3
        item2.height = 2
        item2.balance()
        assertEquals(2, item2.height)
    }

    @Test
    fun balanceShouldChangeHeightWhenBalanceFactorIsMinusTwo() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        val item3 = AvlTreeItem(3, 3)
        item3.leftChild = item2
        item2.leftChild = item1
        item3.height = 3
        item2.height = 2
        item3.balance()
        assertEquals(1, item3.height)
    }

    @Test
    fun balanceShouldChangeHeightWhenBalanceFactorIsTwo() {
        val item1 = AvlTreeItem(1, 1)
        val item2 = AvlTreeItem(2, 2)
        val item3 = AvlTreeItem(3, 3)
        item1.rightChild = item2
        item2.rightChild = item3
        item1.height = 3
        item2.height = 2
        item1.balance()
        assertEquals(1, item1.height)
    }
}

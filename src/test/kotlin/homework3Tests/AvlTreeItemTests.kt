package homework3Tests

import homeworks.homework3.AvlTreeItem
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AvlTreeItemTests {

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

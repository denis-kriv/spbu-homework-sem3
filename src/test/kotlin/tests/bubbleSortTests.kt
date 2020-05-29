package tests

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import tests.test2.task1.bubbleSort
import tests.test2.task1.comparatorForInt
import tests.test2.task1.comparatorForString
import java.lang.NullPointerException

internal class BubbleSortTests {

    @Test
    fun bubbleSortWithEmptyArray() {
        val array = emptyArray<String>()
        val comparator = comparatorForString()
        assertThrows<NullPointerException> { bubbleSort(array, comparator) }
    }

    @Test
    fun bubbleSortWithSortedArrayOfInt() {
        val array = arrayOf(1, 2, 3, 4, 5)
        val result = arrayOf(1, 2, 3, 4, 5)
        val comparator = comparatorForInt()
        bubbleSort(array, comparator)
        assertArrayEquals(array, result)
    }

    @Test
    fun bubbleSortWithUnsortedArrayOfString() {
        val array = arrayOf("a", "bb", "dddd", "eeeee", "ccc")
        val result = arrayOf("a", "bb", "ccc", "dddd", "eeeee")
        val comparator = comparatorForString()
        bubbleSort(array, comparator)
        assertArrayEquals(array, result)
    }

    @Test
    fun bubbleSortPairsOfElements() {
        val array = arrayOf(1, 1, 2, 3, 3, 2)
        val result = arrayOf(1, 1, 2, 2, 3, 3)
        val comparator = comparatorForInt()
        bubbleSort(array, comparator)
        assertArrayEquals(array, result)
    }

    @Test
    fun bubbleSortWithTenElements() {
        val array = arrayOf(1, 10, 9, 8, 7, 6, 5, 4, 3, 2)
        val result = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val comparator = comparatorForInt()
        bubbleSort(array, comparator)
        assertArrayEquals(array, result)
    }

    @Test
    fun bubbleSortWithOneElements() {
        val array = arrayOf("aa")
        val result = arrayOf("aa")
        val comparator = comparatorForString()
        bubbleSort(array, comparator)
        assertArrayEquals(array, result)
    }

    @Test
    fun bubbleSortWithTwoElements() {
        val array = arrayOf("aaa", "aa")
        val result = arrayOf("aa", "aaa")
        val comparator = comparatorForString()
        bubbleSort(array, comparator)
        assertArrayEquals(array, result)
    }
}
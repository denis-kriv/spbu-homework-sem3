package homework1Tests

import homework1.task1.listReverse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.lang.Exception

internal class TestsForTask1 {

    @Test
    fun startAndEndIsOne() {
        val testList: MutableList<Int> = mutableListOf(10101011, 2929229)
        val resultList: MutableList<Int> = mutableListOf(2929229, 10101011)
        val startIndexes = 1
        val endIndexes = 1
        listReverse(startIndexes, endIndexes, testList)
        assertIterableEquals(resultList, testList)
    }

    @Test
    fun startEqualsEnd() {
        val testList: MutableList<Int> = MutableList(6, init = { it })
        val resultList: MutableList<Int> = mutableListOf(3, 4, 5, 0, 1, 2)
        val startIndexes = 3
        val endIndexes = 3
        listReverse(startIndexes, endIndexes, testList)
        assertIterableEquals(resultList, testList)
    }

    @Test
    fun beginningOneMoreEnd() {
        val testList: MutableList<Int> = MutableList(7, init = { it })
        val resultList: MutableList<Int> = mutableListOf(4, 5, 6, 0, 1, 2, 3)
        val startIndexes = 4
        val endIndexes = 3
        listReverse(startIndexes, endIndexes, testList)
        assertIterableEquals(resultList, testList)
    }

    @Test
    fun beginLessOneThanEnd() {
        val testList: MutableList<Int> = MutableList(7, init = { it })
        val resultList: MutableList<Int> = mutableListOf(3, 4, 5, 6, 0, 1, 2)
        val startIndexes = 3
        val endIndexes = 4
        listReverse(startIndexes, endIndexes, testList)
        assertIterableEquals(resultList, testList)
    }

    @Test
    fun startIsZero() {
        val testList: MutableList<Int> = MutableList(3, init = { it })
        val resultList: MutableList<Int> = mutableListOf(0, 1, 2)
        val startIndexes = 0
        val endIndexes = 3
        listReverse(startIndexes, endIndexes, testList)
        assertIterableEquals(resultList, testList)
    }

    @Test
    fun endIsZero() {
        val testList: MutableList<Int> = MutableList(1, init = { it })
        val resultList: MutableList<Int> = mutableListOf(0)
        val startIndexes = 1
        val endIndexes = 0
        listReverse(startIndexes, endIndexes, testList)
        assertIterableEquals(resultList, testList)
    }

    @Test
    fun startIsMoreThanEnd() {
        val testList: MutableList<Int> = MutableList(7, init = { it })
        val resultList: MutableList<Int> = mutableListOf(5, 6, 0, 1, 2, 3, 4)
        val startIndexes = 5
        val endIndexes = 2
        listReverse(startIndexes, endIndexes, testList)
        assertIterableEquals(resultList, testList)
    }

    @Test
    fun incorrectDataEntry() {
        val testList: MutableList<Int> = mutableListOf(1, 2, 3)
        val startIndexes = 0
        val endIndexes = 0
        assertThrows(Exception::class.java) {
            listReverse(startIndexes, endIndexes, testList)
        }
    }
}
package homeworks.homework6.task1

import java.io.File
import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.FileOutputStream

private const val resultsQuantity = 10
private const val minSizeForArray = 100000
private const val maxSizeForArray = 1000000

private fun <T : Comparable<T>> partition(array: Array<T>, indexBegin: Int, indexEnd: Int): Int {
    var lowerIndex = indexBegin
    var topIndex = indexEnd

    val middle = array[(indexBegin + indexEnd) / 2]

    while (lowerIndex <= topIndex) {
        while (array[lowerIndex] < middle) lowerIndex++
        while (array[topIndex] > middle) topIndex--

        if (lowerIndex >= topIndex) break

        val variableForSwap = array[lowerIndex]
        array[lowerIndex] = array[topIndex]
        array[topIndex] = variableForSwap

        lowerIndex++
        topIndex--
    }

    return topIndex
}

private fun <T : Comparable<T>> simpleQuickSort(array: Array<T>, indexBegin: Int, indexEnd: Int) {
    if (indexBegin < indexEnd) {
        val index = partition(array, indexBegin, indexEnd)

        simpleQuickSort(array, indexBegin, index)
        simpleQuickSort(array, index + 1, indexEnd)
    }
}

private suspend fun <T : Comparable<T>> asyncQuickSort(array: Array<T>, indexBegin: Int, indexEnd: Int) {
    if (indexBegin < indexEnd) {
        val index = partition(array, indexBegin, indexEnd)

        asyncQuickSort(array, indexBegin, index)
        asyncQuickSort(array, index + 1, indexEnd)
    }
}

private fun calculate(): String {
    val size = Random.nextInt(minSizeForArray, maxSizeForArray)
    val array = Array(size) { Random.nextInt() }

    val arrayForSimpleSort = array.clone()
    val arrayForAsyncSort = array.clone()

    val simpleQuickSortTime = measureTimeMillis {
        simpleQuickSort(arrayForSimpleSort, 0, arrayForSimpleSort.lastIndex)
    }
    val asyncQuickSortTime = measureTimeMillis {
        runBlocking {
            launch {
                asyncQuickSort(arrayForAsyncSort, 0, arrayForAsyncSort.lastIndex)
            }
        }
    }

    return "Simple sort: $simpleQuickSortTime || Async sort: $asyncQuickSortTime \n"
}

fun main() {
    val file = File("src/main/kotlin/homeworks/homework6/task1/data/results.txt")
    val output = FileOutputStream(file)

    for (i in 1..resultsQuantity) {
        output.write(calculate().toByteArray())
    }

    output.close()
}
